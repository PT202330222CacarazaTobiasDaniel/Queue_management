package org.example.Bussiness_Logic;

import org.example.Model.Server;
import org.example.Model.Task;

import java.util.ArrayList;
import java.util.List;

public class Scheduler{
    private List<Server> servers;
    private int maxNoServers;
    private int maxTasksPerServer;
    private Strategy strategy;

    public Scheduler(int maxNoServers1,int maxTasksPerServer1)
    {
        //for maxNoServers
        Thread[] thread = new Thread[maxNoServers1];
        this.servers = new ArrayList<Server>();

            for (int i = 0; i < maxNoServers1; i++) {
                // - create server object
                servers.add(new Server(maxTasksPerServer1));
                // - create thread with the object
                thread[i] = new Thread(servers.get(i));
                thread[i].start();
            }
            this.maxNoServers = maxNoServers1;
            this.maxTasksPerServer = maxTasksPerServer1;

    }


    public void createStrategy()
    {
        this.strategy = new ConcreteStrategyQueue();
    }
    public void changeStrategy(SelectionPolicy policy)
    {
        //apply strategy patter to instantiate the strategy with concrete strategy corresponding to policy

        if(policy == SelectionPolicy.SHORTEST_QUEUE)
        {
            strategy = new ConcreteStrategyQueue();
        }
    }
    public void dispatchTask(Task t)
    {
        //call the strategy addTask method
        strategy.addTask(servers,t);
    }

    public int getMaxNoServers() {
        return maxNoServers;
    }


    public int getMaxTasksPerServer() {
        return maxTasksPerServer;
    }

    public void setMaxNoServers(int maxNoServers) {
        this.maxNoServers = maxNoServers;
    }

    public void setMaxTasksPerServer(int maxTasksPerServer) {
        this.maxTasksPerServer = maxTasksPerServer;
    }

    public List<Server> getServers()
    {
        return servers;
    }


    public int nrTasks() {
        int sum = 0;
        for(Server server:servers)
        {
            sum+= server.getNrTasks();
        }
        return sum;
    }
}
