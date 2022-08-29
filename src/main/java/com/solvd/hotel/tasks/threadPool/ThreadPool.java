package com.solvd.hotel.tasks.threadPool;

import java.time.LocalDateTime;

public class ThreadPool implements Runnable {
    private String name;

    public ThreadPool(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 3; i++) {
                if (i == 0) {
                    System.out.println("Executed time for"
                            + " the: " + name + " = " + LocalDateTime.now());
                } else {
                    System.out.println("Executing time for the: " +
                            name + " is " + LocalDateTime.now() + " for the " + i);
                }
                Thread.sleep(1000);
            }
            System.out.println(name + " is completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}