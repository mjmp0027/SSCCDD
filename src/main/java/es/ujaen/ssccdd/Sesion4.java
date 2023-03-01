package es.ujaen.ssccdd;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sesion4 {

    public static void main(String[] args) throws RuntimeException {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Task task = new Task("Task " + i);
            taskList.add(task);
        }
        List<Future<Result>> futureList = null;
        try {
            futureList = executor.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();

        System.out.println("Core: Printing the results\n");
        assert futureList != null;
        for (Future<Result> resultFuture : futureList)
            try {
                Result result = resultFuture.get();
                System.out.println(result.getNombreTask() + ": " + result.getResultTask() + "\n");
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
    }
}