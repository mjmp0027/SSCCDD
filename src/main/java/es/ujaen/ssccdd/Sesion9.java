package es.ujaen.ssccdd;

public class Sesion9 {

    public static void main(String[] args) {
        Thread[] threads = new Thread[3];

        for (Thread thread : threads) {
            TaskLocalRandom task = new TaskLocalRandom();
            thread = new Thread(task);
            thread.start();
        }
    }
}