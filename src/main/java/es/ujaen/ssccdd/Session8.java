package es.ujaen.ssccdd;

import java.util.concurrent.TimeUnit;

public class Session8 {


    public static void main(String[] args) {
        SafeTask task = new SafeTask();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}