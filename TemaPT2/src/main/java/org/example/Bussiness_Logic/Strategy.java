package org.example.Bussiness_Logic;

import org.example.Model.Server;
import org.example.Model.Task;

import java.util.List;

public interface Strategy {

    public void addTask(List<Server> servers, Task t);
}
