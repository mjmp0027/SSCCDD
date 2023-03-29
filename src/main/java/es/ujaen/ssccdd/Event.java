package es.ujaen.ssccdd;

public class Event implements Comparable<Event> {

    public int getHilo() {
        return hilo;
    }

    private final int hilo;

    public int getPrioridad() {
        return prioridad;
    }

    private final int prioridad;

    public Event(int hilo, int prioridad) {
        this.hilo = hilo;
        this.prioridad = prioridad;
    }

    @Override
    public int compareTo(Event e) {
        return Integer.compare(e.getPrioridad(), this.prioridad);
    }
}
