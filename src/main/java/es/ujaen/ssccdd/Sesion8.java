package es.ujaen.ssccdd;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class Sesion8 {

    public static void main(String[] args) throws Exception {
        DelayQueue<Event> queue = new DelayQueue<>();
        Thread[] threads = new Thread[5];
        for (int i = 0; i< threads.length; i++) {
            Task task = new Task(i+1, queue);
            threads[i] = new Thread(task);
            threads[i].start();
            threads[i].join();
        }

        do {
            int counter=0;
            Event event;
            do {
                event=queue.poll();
                if (event!=null) counter++;
            } while (event!=null);
            System.out.printf("At %s you have read %d events\n",new Date(),counter);
            TimeUnit.MILLISECONDS.sleep(500);
        } while (queue.size()>0);

    }
}