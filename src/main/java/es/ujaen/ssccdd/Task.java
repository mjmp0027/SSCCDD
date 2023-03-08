package es.ujaen.ssccdd;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {
    private final String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String call() {
        System.out.println(taskName + ": Starting at: " + new Date());
        return "Hello, World";
    }
}
