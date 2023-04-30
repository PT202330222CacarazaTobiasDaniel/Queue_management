package org.example.Bussiness_Logic;

import org.example.Model.Server;
import org.example.Model.Task;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcreteStrategyQueue implements Strategy {
    @Override
    public void addTask(List<Server> servers, Task t) {
        // TODO Auto-generated method stub
        int min =Integer.MAX_VALUE;
        Server StratServer = null;
        for(Server server:servers)
        {
            if(server.getNrTasks()<min)
            {
                min = server.getNrTasks();
                StratServer = server;
            }
        }
        StratServer.addTask(t);

    }
}
