package com.company;

import java.util.ArrayList;

public class TaskPoolSolver {
   private ArrayList<Runnable> tasks = new ArrayList<>();

    public synchronized Runnable startTaskPoolSolving(){
        while (tasks.isEmpty()){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        Runnable task = tasks.get(0);
        tasks.remove(task);
        return task;
    }

    public synchronized void addTask(Runnable task){
        tasks.add(task);
        notify();
    }
}
