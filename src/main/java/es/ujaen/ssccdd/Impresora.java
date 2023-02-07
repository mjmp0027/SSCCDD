package es.ujaen.ssccdd;

public class Impresora {
    private final int id;

    public Impresora(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Impresora{" +
                "id=" + id +
                '}';
    }
}
