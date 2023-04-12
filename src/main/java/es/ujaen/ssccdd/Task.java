package es.ujaen.ssccdd;

import java.util.concurrent.ConcurrentSkipListMap;

public class Task implements Runnable {

    private final String id;

    private final ConcurrentSkipListMap<String, Contact> listContactos;

    public Task(ConcurrentSkipListMap<String, Contact> listContactos, String id) {
        this.id = id;
        this.listContactos = listContactos;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Contact contact = new Contact(id, String.valueOf(i + 1000));
            listContactos.put(id + contact.getTelefeno(), contact);
        }

    }
}
