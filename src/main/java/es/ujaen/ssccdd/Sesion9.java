package es.ujaen.ssccdd;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Sesion9 {

    public static void main(String[] args) {
        ConcurrentSkipListMap<String, Contact> listContactos = new ConcurrentSkipListMap<>();

        Thread[] threads = new Thread[25];
        int cont = 0;

        for (int i = 'A'; i < 'Z'; i++) {
            Task task = new Task(listContactos, String.valueOf(i));
            threads[cont] = new Thread(task);
            threads[cont].start();
            cont++;
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: Size of the map: %d\n", listContactos.size());

        Map.Entry<String, Contact> element;
        Contact contact;

        element = listContactos.firstEntry();
        contact = element.getValue();
        System.out.printf("Main: First Entry: %s: %s\n", contact.getNombre(), contact.getTelefeno());


        element = listContactos.lastEntry();
        contact = element.getValue();
        System.out.printf("Main: Last Entry: %s: %s\n", contact.getNombre(), contact.getTelefeno());


        System.out.print("Main: Submap from A1996 to B1002: \n");
        ConcurrentNavigableMap<String, Contact> submap = listContactos.subMap("A1996", "B1002");
        do {
            element = submap.pollFirstEntry();
            if (element != null) {
                contact = element.getValue();
                System.out.printf("%s: %s\n", contact.getNombre(), contact.getTelefeno());
            }
        } while (element != null);

    }
}