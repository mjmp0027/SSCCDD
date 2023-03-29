package es.ujaen.ssccdd;

import java.util.concurrent.ConcurrentLinkedDeque;

public class PoolTask implements Runnable {


    private final ConcurrentLinkedDeque<String> listElementos;

    public PoolTask(ConcurrentLinkedDeque<String> listElementos) {
        this.listElementos = listElementos;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            listElementos.pollFirst();
            listElementos.pollLast();
        }
    }
}
