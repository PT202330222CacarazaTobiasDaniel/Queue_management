package org.example.Bussiness_Logic;

import org.example.GUI.SimulationFrame;
import org.example.Model.Server;
import org.example.Model.Task;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static java.lang.Thread.sleep;

public class SimulationManager implements Runnable {

    public int timeLimit ; // maximum processing time  - read from UI
    public int maxProcessingTime ;
    public int minProcessingTime;
    public int numberOfServers;
    public int numberOfClients;
    public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;

    //entity responsible with queue management and client distribution
    private Scheduler scheduler;
    //frame for displaying simulation
    private SimulationFrame frame;
    //pool of tasks (client shopping in store)
    private List<Task> tasks;

    private String text;

    public SimulationManager() {
        // initialize frame to display simulation
        text = "";
        frame = new SimulationFrame(tasks);
        frame.setVisible(true);

        while(!frame.ok) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        minProcessingTime = frame.minArrival > 0? frame.minArrival : 1;
        maxProcessingTime = frame.maxArrival;
        numberOfClients = frame.nrClienti;
        timeLimit = frame.tMaxSim;
        numberOfServers = frame.nrCozi >0? frame.nrCozi : 1;

        // initialize the scheduler
        //      => create and start numberOfServers threads
        scheduler = new Scheduler(numberOfServers,numberOfClients/numberOfServers +1);
        //      => initialize selection strategy => createStrategy
        scheduler.createStrategy();

        // generate numberOfClients clients using generateNRandomTasks()
        generateRandomTasks();
        //and store them to generatedTasks


    }

    public void setText(int currentTime)
    {
        String auxText= "Time "+currentTime+'\n'+"Waiting clients: ";

        for(int i = 0 ; i < tasks.size(); i++)
        {
            auxText +="("+
            tasks.get(i).getID()+","+
            tasks.get(i).getArrivalTime()+","+
            tasks.get(i).getServiceTime()+");";
        }
        int j = 1;
            if(scheduler.getMaxTasksPerServer()>0) {
                List<Server> servere = scheduler.getServers();
                int ok = 0;
                for (Server serv:servere) {
                        auxText+= "\nQueue "+(j++)+": ";
                        Task[] clienti =serv.getTasks();
                        for(Task client:clienti)
                        {
                            auxText+="("+client.getID()+","+client.getArrivalTime()+","+client.getServiceTime()+");";
                            ok++;
                        }
                    if(ok==0)
                    {
                        auxText+="closed";
                    }
                    ok = 0;
                }
            }
            else {
                auxText+="No Queue;";
            }

        text+=auxText+"\n\n";
        System.out.println(auxText+"\n\n");
        frame.updateT(tasks,text);
    }


    public void generateRandomTasks()
    {
        // generate N random tasks:
        tasks = new ArrayList<Task>();
        Random aux =(new Random());
        for(int i = 0; i < numberOfClients; i++) {
            int rand = aux.nextInt(minProcessingTime,maxProcessingTime+1);
            // - random processing time
            //minProcessingTime < processingTime < maxProcessingTime
            int rand2 = aux.nextInt(frame.minService>0? frame.minService : 1,frame.maxService>0? frame.maxService +1 : 2);
            // - random arrivalTime
            tasks.add( new Task(i+1,rand, rand2));
        }
        //sort list to respect to arrivalTime
        tasks.sort(Task::compareTo);
    }

    @Override
    public void run() {
        int currentTime =0;
        //iterate generatedTasks list and pick tasks that have the arrivalTime equal with the currentTime
        //tasks.forEach(n -> System.out.println(n.toString()));
        double AverageWaitingTime[]= new double[timeLimit];
        double AverageServiceTime = 0.0;

        for(Task task:tasks)
        {
            AverageServiceTime+=task.getServiceTime();
        }
        AverageServiceTime/= tasks.size();

    int clientMax = 0,peakHour = 0;

        while(currentTime < timeLimit) {


            for(Task task:tasks)
            {
                AverageWaitingTime[currentTime]+=task.getArrivalTime();
            }
            AverageWaitingTime[currentTime]/= tasks.size()!=0? tasks.size() : 1;
            //  - send task to queue by calling the dispatchTask method from Scheduler
            //  - delete client from list
            for (int i = 0; i < tasks.size(); i++) {

                if (tasks.get(i).getArrivalTime() == currentTime) {
                    scheduler.dispatchTask(tasks.get(i));
                    tasks.remove(i);
                    i--;
                }
            }
            int aux = scheduler.nrTasks();
            if (aux > clientMax) {
                clientMax = aux;
                peakHour = currentTime ;
            }
            // update UI frame
            setText(currentTime);


            currentTime++;
            // wait an interval of 1 second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        text+="\nAverage service time: "+AverageServiceTime+"\n";
        Double sumAver = 0.0;
        for(Double aux:AverageWaitingTime)
        {
            sumAver += aux;
        }
        sumAver /=timeLimit;
        text+="\nAverage waiting time: "+sumAver+"\n";

        text+="\nPeak hour: "+peakHour+"\n";

        try (FileWriter file = new FileWriter("Tema.txt")) {
            file.write(text);
        } catch (IOException e) {
            System.out.println("File write error");
        }
    }

    public static void main(String[] args)
    {
        SimulationManager gen = new SimulationManager();
        Thread t = new Thread(gen);
        t.start();

    }
}
