package es.ujaen.ssccdd;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {

    public Task() {

    }

    @Override
    public String call() throws Exception {
        while (true) {
            System.out.print("Task: Test\n");
            Thread.sleep(100);
        }
    }
}
