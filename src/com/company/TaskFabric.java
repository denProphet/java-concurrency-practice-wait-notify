package com.company;

public class TaskFabric {

    public Runnable getTask() {
        int id = (int)(Math.random()*10);
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Task " + id + " has started");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task " +
                        id + "has been completed");

            }
        };
    }
}
