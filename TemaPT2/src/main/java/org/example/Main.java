package org.example;

import org.example.Bussiness_Logic.SimulationManager;

public class Main {
    public static void main(String[] args) {
        SimulationManager Start = new SimulationManager();
        Thread t = new Thread(Start);
        t.start();
    }
}