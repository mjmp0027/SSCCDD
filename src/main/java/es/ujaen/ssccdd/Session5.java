package es.ujaen.ssccdd;

import java.util.concurrent.TimeUnit;

public class Session5 {


    public static void main(String[] args) {
        FileClock clock = new FileClock();
        Thread thread = new Thread(clock);
        thread.start();

        try{
            TimeUnit.SECONDS.sleep(15);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        thread.interrupt();
    }
}