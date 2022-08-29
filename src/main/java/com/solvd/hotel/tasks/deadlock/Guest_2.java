package com.solvd.hotel.tasks.deadlock;

import java.time.LocalDateTime;

public class Guest_2 implements Runnable {
    private Object guest1;
    private Object guest2;
    private Object guest3;

    public Guest_2(Object guest1, Object guest2, Object guest3) {
        this.guest1 = guest1;
        this.guest2 = guest2;
        this.guest3 = guest3;
    }

    @Override
    public void run() {
        synchronized (guest2) {
            System.out.println(Thread.currentThread().getName() + " adopted " + "guest 2 lock for: " + LocalDateTime.now());
            synchronized (guest3) {
                System.out.println(Thread.currentThread().getName() + " adopted " + "guest 3 lock for: " + LocalDateTime.now());
                synchronized (guest1) {
                    System.out.println(Thread.currentThread().getName() + " adopted " + "guest 1 lock for: " + LocalDateTime.now());
                }
            }
        }
    }
}
