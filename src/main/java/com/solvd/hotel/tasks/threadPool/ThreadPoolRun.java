package com.solvd.hotel.tasks.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolRun {
    private static final int MAX_THREADS = 3;

    public static void main(String[] args) {


        Runnable threadPool1 = new ThreadPool("Guest queue 1.");
        Runnable threadPool2 = new ThreadPool("Guest queue 2.");
        Runnable threadPool3 = new ThreadPool("Guest queue 3.");

        ExecutorService pool = Executors.newFixedThreadPool(MAX_THREADS);

        pool.execute(threadPool1);
        pool.execute(threadPool2);
        pool.execute(threadPool3);

        pool.shutdown();

    }
}
