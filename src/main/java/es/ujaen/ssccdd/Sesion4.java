package es.ujaen.ssccdd;

public class Sesion4 {

    public static void main(String[] args) {
        Server server = new Server();
        for (int i = 0; i < 50; i++) {
            Task task = new Task("Task " + i);
            server.executeTask(task);
        }
        server.endServer();
    }
}