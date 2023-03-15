package es.ujaen.ssccdd;

import java.io.Serial;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Task extends RecursiveAction {

    @Serial
    private static final long serialVersionUID = 1L;

    private final List<Product> productList;

    private final int first;
    private final int last;

    private final double increment;

    public Task(List<Product> productList, int first, int last, double increment) {
        this.productList = productList;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    @Override
    protected void compute() {
        if (last - first < 10) {
            updatePrices();
        } else {
            int middle = (last - first) / 2;
            System.out.println("Pending tasks: " + getQueuedTaskCount());
            Task task1 = new Task(productList, first, middle, increment);
            Task task2 = new Task(productList, middle + 1, last, increment);
            invokeAll(task1, task2);
        }
    }

    private void updatePrices() {
        for (int i = first; i < last; i++) {
            productList.get(i).setPrecio(productList.get(i).getPrecio() * (1 + increment));
        }
    }
}
