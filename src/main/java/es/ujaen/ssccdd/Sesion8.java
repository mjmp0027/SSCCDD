package es.ujaen.ssccdd;

import java.util.concurrent.PriorityBlockingQueue;

public class Sesion8 {

    public static void main(String[] args) {
        PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            Task task = new Task(i,queue);
            threads[i]= new Thread(task);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: Queue Size: %d\n",queue.size());
        for (int i=0; i<threads.length*1000; i++){
            Event event=queue.poll();
            assert event != null;
            System.out.printf("Thread %s: Priority %d\n",event.getHilo(),event.getPrioridad());
        }
        System.out.printf("Main: Queue Size: %d\n",queue.size());
        System.out.print("Main: End of the program\n");

    }
}