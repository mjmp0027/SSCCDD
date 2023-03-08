package es.ujaen.ssccdd;

import java.util.Date;
import java.util.concurrent.*;

public class Sesion5 {

    public static void main(String[] args) throws RuntimeException {

        RejectedExecutionHandler controller = new RejectedTaskController();
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
        executor.setRejectedExecutionHandler(controller);

        System.out.println("Main starting\n");
        for (int i = 0; i < 3; i++) {
            Task task = new Task("Task " + i);
            executor.submit(task);
        }

        System.out.println("Main shutting down the executor\n");
        executor.shutdown();

        System.out.print("Main: Sending another Task.\n");
        Task task=new Task("RejectedTask");
        executor.submit(task);

        System.out.println("Main ends at: " + new Date());
    }
}