package es.ujaen.ssccdd;

public class TrabajoImpresion {
    private final int idTrabajo;
    private final int tiempoTrabajo;

    public TrabajoImpresion(int idTrabajo, int tiempoTrabajo) {
        this.idTrabajo = idTrabajo;
        this.tiempoTrabajo = tiempoTrabajo;
    }

    public int getIdTrabajo() {
        return idTrabajo;
    }

    public int getTiempoTrabajo() {
        return tiempoTrabajo;
    }

    @Override
    public String toString() {
        return "TrabajoImpresion{" +
                "idTrabajo=" + idTrabajo +
                ", tiempoTrabajo=" + tiempoTrabajo +
                '}';
    }
}
