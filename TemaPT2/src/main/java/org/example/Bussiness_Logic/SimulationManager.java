package org.example.Bussiness_Logic;

import org.example.GUI.SimulationFrame;
import org.example.Model.Server;
import org.example.Model.Task;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import java.util.List;

import static java.lang.Thread.sleep;

public class SimulationManager implements Runnable {

    public int timeLimit; // maximum processing time  - read from UI
    public int maxProcessingTime;
    public int minProcessingTime ;
    public int numberOfServers;
    public int numberOfClients;
    public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;

    //entity responsible with queue management and client distribution
    private Scheduler scheduler;
    //frame for displaying simulation
    private SimulationFrame frame;
    //pool of tasks (client shopping in store)
    private List<Task> tasks;

    public SimulationManager()
    {
        // initialize frame to display simulation
        frame = new SimulationFrame(tasks);
        frame.setVisible(true);

        while(true) {
            if (frame.ok) {
                minProcessingTime = frame.minArrival > 0? frame.minArrival : 1;
                maxProcessingTime = frame.maxArrival;
                numberOfClients = frame.nrClienti;
                timeLimit = frame.tMaxSim;
                numberOfServers = frame.nrCozi >0? frame.nrCozi : 1;
                break;
            } else {
                continue;
            }
        }


        // initialize the scheduler
        //      => create and start numberOfServers threads
        scheduler = new Scheduler(numberOfServers,numberOfClients/numberOfServers);
        //      => initialize selection strategy => createStrategy
        scheduler.createStrategy();

        // generate numberOfClients clients using generateNRandomTasks()
        generateRandomTasks();
        //and store them to generatedTasks


    }

    public void generateRandomTasks()
    {
        // generate N random tasks:
        tasks = new ArrayList<Task>();
        Random aux =(new Random());
        for(int i = 0; i < numberOfClients; i++) {
            int rand = aux.nextInt(minProcessingTime,maxProcessingTime);
            // - random processing time
            //minProcessingTime < processingTime < maxProcessingTime
            int rand2 = aux.nextInt(frame.minService>0? frame.minService : 1,frame.maxService);
            // - random arrivalTime
            tasks.add( new Task(i+1,rand, rand2));
        }
        //sort list to respect to arrivalTime
        tasks.sort(Task::compareTo);
    }

    @Override
    public void run() {
        int currentTime =0;
        while(currentTime < timeLimit) {


            // zona de sincronizare {
            //iterate generatedTasks list and pick tasks that have the arrivalTime equal with the currentTime
            tasks.forEach(n -> System.out.println(n.toString()));

            //  - send task to queue by calling the dispatchTask method from Scheduler
            //  - delete client from list

            for (int i = 0; i < tasks.size(); i++) {

                if (tasks.get(i).getArrivalTime() == currentTime) {
                    scheduler.dispatchTask(tasks.get(i));
                    tasks.remove(i);
                }
            }
            // update UI frame
            frame.updateT(tasks);
            // zona pentru sincronizare



            currentTime++;
            // wait an interval of 1 second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args)
    {
        SimulationManager gen = new SimulationManager();
        Thread t = new Thread(gen);
        Thread t2 = new Thread(gen);

        t.start();
        t2.start();



    }
}
