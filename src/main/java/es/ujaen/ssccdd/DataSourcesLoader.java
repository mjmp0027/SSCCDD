package es.ujaen.ssccdd;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourcesLoader implements Runnable{
    @Override
    public void run() {
        System.out.println("Begining data sources loading: " + new Date());

        try{
            TimeUnit.SECONDS.sleep(4);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Data sources loading has finished: " + new Date());
    }
}
