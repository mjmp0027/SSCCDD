package es.ujaen.ssccdd;

import java.util.concurrent.TimeUnit;

public class Session4 {


    public static void main(String[] args) {
        FileSearch searcher = new FileSearch("..//..//..","build.xml");
        Thread thread = new Thread(searcher);
        thread.start();

        try{
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e){
            System.out.println("Hola");
            e.printStackTrace();
        }

        thread.interrupt();
    }
}