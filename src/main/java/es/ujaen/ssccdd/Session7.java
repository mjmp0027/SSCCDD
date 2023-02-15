package es.ujaen.ssccdd;

public class Session7 {


    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();

        try{
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread has finished");
    }
}