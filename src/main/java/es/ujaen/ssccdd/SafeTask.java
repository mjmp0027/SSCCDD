package es.ujaen.ssccdd;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable{
    public static ThreadLocal<Date> startDate = new ThreadLocal<Date>();
    protected Date initialValue(){
        return new Date();
    }
    @Override
    public void run() {
        System.out.println("Starting Thread: " + Thread.currentThread().getId() + " : " + initialValue());
        try{
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread Finished: " + Thread.currentThread().getId() + " : " + startDate.get());
    }
}
