package es.ujaen.ssccdd;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ExecutableTask implements Callable<String> {

    private final String name;

    public ExecutableTask(String name) {
        this.name = name;
    }

    @Override
    public String call() {
        try {
            long duration = (long) (Math.random() * 10);
            System.out.println(name + ": waiting " + duration + " second for results.\n");
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello, world. I´m " + name;
    }

    public String getName() {
        return name;
    }
}
