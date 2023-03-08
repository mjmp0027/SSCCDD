package es.ujaen.ssccdd;

import java.util.Date;

public class Task implements Runnable {
    private final String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(taskName + ": executed at: " + new Date());
    }
}
