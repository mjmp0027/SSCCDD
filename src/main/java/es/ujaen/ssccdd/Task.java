package es.ujaen.ssccdd;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable{
    private final String nombre;
    private final Date fechaCreacion = new Date();

    public Task(String nombre) {
        this.nombre = nombre;
        this.fechaCreacion.setTime(System.nanoTime());
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Task " + nombre + ": Created on: " + fechaCreacion);
        System.out.println(Thread.currentThread().getName() + ": Task " + nombre + ": Started on: " + new Date());

        try{
            long duration = (long)(Math.random()*10);
            System.out.println(Thread.currentThread().getName() + ": Task " + nombre + ": Doing a task during " + duration + " seconds\n");
            TimeUnit.SECONDS.sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": Task " + nombre + ": Finished on: " + new Date());
    }
}
