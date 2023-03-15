package es.ujaen.ssccdd;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Sesion6 {

    public static void main(String[] args) throws RuntimeException {

        ArrayGenerator generator = new ArrayGenerator();
        int[] array = generator.generateArray(1000);


        TaskManager manager = new TaskManager();

        ForkJoinPool pool = new ForkJoinPool();

        SearchNumberTask task = new SearchNumberTask(array, 0, 1000, 5, manager);

        pool.execute(task);

        pool.shutdown();

        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Result: %d", task.join());


    }

}