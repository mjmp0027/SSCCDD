package es.ujaen.ssccdd;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Sesion6 {

    public static void main(String[] args) throws RuntimeException {
        ProductListGenerator generator = new ProductListGenerator();
        List<Product> products = generator.generate(100);

        Task task = new Task(products, 0, products.size(), 0.20);

        ForkJoinPool pool = new ForkJoinPool();

        pool.execute(task);

        do {
            System.out.println("Main: Thread count: " + pool.getActiveThreadCount());
            System.out.println("Main: Thread steal: " + pool.getStealCount());
            System.out.println("Main: Paralelism: " + pool.getParallelism());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("La aplicación ha fallado: " + e.getMessage());
            }
        } while (!task.isDone());

        pool.shutdown();

        if (task.isCompletedNormally()) {
            System.out.println("Main: the process has completed normally");
        }

        for (Product product : products) {
            if (product.getPrecio() != 12)
                System.out.println("Product " + product.getNombre() + ": " + product.getPrecio());
        }
        System.out.println("Main: end of the program");
    }
}