package com.solvd.hotel.tasks.deadpool;

public class Deadlock {
    public static void main(String[] args) {
        Object guest1 = new Object();
        Object guest2 = new Object();
        Object guest3 = new Object();
        Thread thread1 = new Thread(new Guest_1(guest1, guest2, guest3));
        Thread thread2 = new Thread(new Guest_2(guest1, guest2, guest3));
        Thread thread3 = new Thread(new Guest_3(guest1, guest2, guest3));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
