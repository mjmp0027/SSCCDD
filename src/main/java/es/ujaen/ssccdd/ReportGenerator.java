package es.ujaen.ssccdd;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ReportGenerator implements Callable<String> {
    private final String name;
    private final String title;

    public ReportGenerator(String name, String title) {
        this.name = name;
        this.title = title;
    }

    @Override
    public String call() {
        try{
            long duration=(long)(Math.random()*10);
            System.out.println(name + " report generator: generating a report during " + duration + " seconds\n");
            TimeUnit.SECONDS.sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return name + ": " + title;
    }
}
