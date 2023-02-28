package es.ujaen.ssccdd;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

public class Sesion4 {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<>(10));
        ArrayList<Future<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            Integer numero = random.nextInt(10);
            FactorialCalculator calculator = new FactorialCalculator(numero);
            Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
        }
        do {
            System.out.println("Main: Number of Completed tasks: " + executor.getCompletedTaskCount());
            for (int i = 0; i < resultList.size(); i++) {
                Future<Integer> result = resultList.get(i);
                System.out.println("Main: Task " + i + ": " + result.isDone());
            }
            try{
                Thread.sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        } while (executor.getCompletedTaskCount() < resultList.size());
        System.out.println("Main results: \n");
        for (int i = 0; i < resultList.size(); i++) {
            Future<Integer> result = resultList.get(i);
            Integer numero = null;
            try{
                numero = result.get();
            }catch (InterruptedException | ExecutionException e){
                e.printStackTrace();
            }
            System.out.println("Core: Task "+ i + ": " + numero);
        }
        executor.shutdown();
    }
}