package es.ujaen.ssccdd;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GestorImpresion {
    private final Impresora[] impresoras;
    private final ArrayList<TrabajoImpresion> trabajos;
    private static final int PRIMERO = 0;
    private Random generador;

    public GestorImpresion(Impresora[] impresoras, ArrayList<TrabajoImpresion> trabajos) {
        generador = new Random();
        this.impresoras = impresoras;
        this.trabajos = trabajos;
    }

    /**
     * Nos permite añadir un nuevo trabajo de impresión a la lista de trabajos
     * pendientes
     * @param elm el trabajo de impresión que queda pendiente en el gestor
     */
    public void agregarTrabajo(TrabajoImpresion elm){
        trabajos.add(elm);
        System.out.println("Se ha añadido el trabajo " + elm + " para su impresión");
    }

    /**
     * Simula la realización de un trabajo de impresión en una de las impresoras
     * disponibles en el sistema.
     * @throws InterruptedException devuelve una excepción de tipo java.lang.InterruptedException
     */
    public void realizarTrabajo() throws InterruptedException{
        int idImpresora;
        TrabajoImpresion siguienteTrabajo;

        idImpresora=seleccionarImpresora();
        siguienteTrabajo = trabajos.remove(PRIMERO);
        TimeUnit.SECONDS.sleep(siguienteTrabajo.getTiempoTrabajo());

        System.out.println("Se ha realizado el trabajo: " + siguienteTrabajo +
                           "en la impresora: " + impresoras[idImpresora]);
    }

    /**
     * Nos devuelve si hay trabajos pendientes en el gestor de impresión
     * @return true si hay trabajos pendientes, false en otro caso
     */
    public boolean hayTrabajos(){
        return !trabajos.isEmpty();
    }

    /**
     * Seleccionamos una impresora disponible
     * @return id de la impresora disponible
     */
    public int seleccionarImpresora(){
        return generador.nextInt(impresoras.length);
    }
}