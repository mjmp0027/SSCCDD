package es.ujaen.ssccdd;

public class Product {
    @Override
    public String toString() {
        return "Product{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }

    private final String nombre;
    private double precio;

    public Product(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
