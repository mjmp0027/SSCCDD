package es.ujaen.ssccdd;

public class Task implements Runnable{
    @Override
    public void run() {
        int numero = Integer.parseInt("TTT");
        System.out.println("Número: " + numero);
    }
}
