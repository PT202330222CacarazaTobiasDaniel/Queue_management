package org.example.Model;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {

    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;

    public Server(){
        //initialize queue and waitingPeriod
        this.tasks = null;
        this.waitingPeriod = null;
    }
    public Server(BlockingQueue<Task> tasks1,AtomicInteger waitingPeriod1){
        //initialize queue and waitingPeriod
        this.tasks = tasks1;
        this.waitingPeriod = waitingPeriod1;
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
            //take next task from queue
            if(tasks.contains(null));
            // stop the thread for a time equal with the task's processing time

            // decrement waitingPeriod
            waitingPeriod.decrementAndGet();
            ///waitingPeriod.set(waitingPeriod.getAndDecrement());
        }
    }
    public Task[] getTasks(){
        return null;
    }
}
