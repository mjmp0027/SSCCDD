package es.ujaen.ssccdd;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable{

    private final LinkedBlockingDeque<String> list;

    public Client(LinkedBlockingDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                StringBuilder request = new StringBuilder();
                request.append(i);
                request.append(":");
                request.append(j);
                try{
                    list.put(request.toString());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Client: " + request + " at: " + new Date()+ "\n");
            }
            try {
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Client: End.\n");
    }
}
