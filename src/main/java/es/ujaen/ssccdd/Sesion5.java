package es.ujaen.ssccdd;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Sesion5 {

    public static void main(String[] args) throws RuntimeException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        System.out.println("Main starting at: " + new Date());
        for (int i = 0; i < 5; i++) {
            Task task = new Task("Task " + i);
            executor.schedule(task, i + 1, TimeUnit.SECONDS);
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main ends at: " + new Date());
    }
}