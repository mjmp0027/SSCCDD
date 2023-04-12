package es.ujaen.ssccdd;

public class Contact {
    private final String nombre;

    private final String telefono;

    public Contact(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefeno() {
        return telefono;
    }
}
