package es.ujaen.ssccdd;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Task: " + name + " starting\n");
        try {
            long duration = (long) (Math.random() * 10);
            System.out.println("Task: " + name + " generating a report during " + duration + " seconds\n");
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task: " + name + " ending\n");
    }
}
