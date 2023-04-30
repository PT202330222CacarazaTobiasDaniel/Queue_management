package org.example.Model;

public class Task implements Comparable{

    private int ID;
    private int arrivalTime;
    private int serviceTime;

    public Task() {
        this.arrivalTime = -1;
        this.serviceTime = -1;
    }

    public Task(int id, int arrivalTime, int serviceTime) {
        this.ID = id;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }
    public int getArrivalTime()
    {
        return this.arrivalTime;
    }
    public int getID()
    {
        return this.ID;
    }
    public int getServiceTime()
    {
        return this.serviceTime;
    }

    @Override
    public String toString()
    {
        return "ID: " + this.ID +", ArrivalTime = "+ this.arrivalTime + ", serviceTime = " + this.serviceTime;
    }

    @Override
    public int compareTo(Object o) {
        return this.arrivalTime-((Task)o).arrivalTime;
    }

    public void decrementService() {
        this.serviceTime = this.serviceTime-1;
    }


}
