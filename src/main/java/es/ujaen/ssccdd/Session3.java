package es.ujaen.ssccdd;

import java.util.concurrent.TimeUnit;

public class Session3 {


    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();

        try{
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }
}