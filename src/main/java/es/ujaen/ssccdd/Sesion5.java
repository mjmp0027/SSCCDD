package es.ujaen.ssccdd;

import java.util.Date;
import java.util.concurrent.*;

public class Sesion5 {

    public static void main(String[] args) throws RuntimeException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        ResultTask[] resultTask = new ResultTask[5];
        for (int i = 0; i < resultTask.length; i++) {
            ExecutableTask executableTask = new ExecutableTask("Task " + i);
            resultTask[i] = new ResultTask(executableTask);
            executor.submit(resultTask[i]);
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (ResultTask task : resultTask) {
            task.cancel(true);
        }

        for (ResultTask task : resultTask) {
            try {
                if (!task.isCancelled()) {
                    System.out.println(task.get() + "\n");
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

        System.out.println("Main ends at: " + new Date());
    }
}