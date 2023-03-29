package es.ujaen.ssccdd;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Sesion8 {

    public static void main(String[] args) throws Exception {
        ConcurrentLinkedDeque<String> listElementos = new ConcurrentLinkedDeque<>();
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            AddTask task = new AddTask(listElementos);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        System.out.println("Main: " + threads.length + " AddTask threads have been launched\n");

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Main: Size of the List: " + listElementos.size() + "\n");

        for (int i = 0; i < threads.length; i++) {
            PoolTask task = new PoolTask(listElementos);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        System.out.println("Main: " + threads.length + " PollTask threads have been launched\n");

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Main: Size of the List: " + listElementos.size() + "\n");

    }

}