package es.ujaen.ssccdd;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    ThreadPoolExecutor hiloEjecutor;

    public Server(){
        int poolSize = 10;
        int queueSize = 50;
        hiloEjecutor = new ThreadPoolExecutor(poolSize, poolSize, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(queueSize));
    }

    public void executeTask(Task task){
        System.out.print("Server: A new task has arrived\n");
        hiloEjecutor.execute(task);
        System.out.printf("Server: Pool Size: %d\n",hiloEjecutor.getPoolSize());
        System.out.printf("Server: Active Count: %d\n",hiloEjecutor.getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n",hiloEjecutor.getCompletedTaskCount());
    }

    public void endServer(){
        hiloEjecutor.shutdown();
    }
}
