package es.ujaen.ssccdd;

import java.util.Date;
import java.util.concurrent.*;

public class Sesion5 {

    public static void main(String[] args) throws RuntimeException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        Task task = new Task();

        System.out.println("Main starting at: " + new Date());
        Future<String> result = executor.submit(task);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main cancelling the task\n");
        result.cancel(true);
        System.out.println("Main cancelled: " + result.isCancelled() + "\n");
        System.out.println("Main done: " + result.isDone() + "\n");
        executor.shutdown();

        System.out.println("Main ends at: " + new Date());
    }
}