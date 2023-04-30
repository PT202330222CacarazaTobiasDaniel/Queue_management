package org.example.Model;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {

    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod = new AtomicInteger(0);


    public Server(){
        //initialize queue and waitingPeriod
        this.tasks = null;
        this.waitingPeriod = null;
    }
    public Server(int tasks1){
        //initialize queue and waitingPeriod
        this.tasks = new ArrayBlockingQueue<Task>(tasks1);
    }


    public void addTask(Task newTask)
    {
        //add task to queue
        tasks.add(newTask);
        //increment the waitingPeriod
        waitingPeriod.incrementAndGet();
        ///waitingPeriod.set(waitingPeriod.getAndIncrement());
    }


    @Override
    public void run() {

            while(true)
            {
                if(tasks.size()>0)
                {
                    //take next task from queue
                    Task task = tasks.peek();
                    task.decrementService();
                    // decrement waitingPeriod
                    waitingPeriod.decrementAndGet();
                    // stop the thread for a time equal with the task's processing time
                    if(task.getServiceTime() == 0) {
                        tasks.remove();
                    }
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

    }
    public Task[] getTasks(){
        return tasks.toArray(Task[]::new);
    }
    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    public int getNrTasks()
    {
        return tasks.size();
    }

}
