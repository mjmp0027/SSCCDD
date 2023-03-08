package es.ujaen.ssccdd;

import java.util.Date;
import java.util.concurrent.*;

public class Sesion5 {

    public static void main(String[] args) throws RuntimeException {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletionService<String> service = new ExecutorCompletionService<>(executor);

        ReportRequest faceRequest = new ReportRequest("Face", service);
        ReportRequest onlineRequest = new ReportRequest("Online", service);
        Thread faceThread = new Thread(faceRequest);
        Thread onlineThread = new Thread(onlineRequest);

        ReportProcessor processor = new ReportProcessor(service);
        Thread senderThread = new Thread(processor);

        System.out.println("Main starting the Threads");
        faceThread.start();
        onlineThread.start();
        senderThread.start();

        try {
            System.out.print("Main waiting for the request generators.\n");
            faceThread.join();
            onlineThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main shuting down the executor.\n");
        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        processor.setEnd(true);

        System.out.println("Main ends at: " + new Date());
    }
}