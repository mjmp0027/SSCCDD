package es.ujaen.ssccdd;

import java.util.concurrent.ConcurrentLinkedDeque;

public class AddTask implements Runnable {


    private final ConcurrentLinkedDeque<String> listElementos;

    public AddTask(ConcurrentLinkedDeque<String> listElementos) {

        this.listElementos = listElementos;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++)
            listElementos.add(Thread.currentThread().getName() + ": elemento " + i);
    }
}
