package es.ujaen.ssccdd;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<Result> {
    private final String nombreTask;

    public Task(String nombreTask) {
        this.nombreTask = nombreTask;
    }

    @Override
    public Result call() {
        System.out.println(this.nombreTask + ": Starting\n");
        try {
            long duration = (long) (Math.random() * 10);
            System.out.println(this.nombreTask + ": Waiting " + duration + " seconds for result\n");
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int value = 0;
        for (int i = 0; i < 5; i++) {
            value += (int) (Math.random() * 100);
        }

        Result result = new Result();
        result.setNombreTask(this.nombreTask);
        result.setResultTask(value);
        System.out.println(this.nombreTask + ": Ends\n");

        return result;
    }
}
