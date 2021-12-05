package Estrategia;

import Modelos.Jugador;
import java.util.List;

/**
 * Clase que se utiliza para ver que estrategia de ordenación se va a usar y ejecutarla sobre los jugadores
 * @author Javier y Chrsitian
 */
public class Contexto {
    /**
     * Estrategia que se usa.
     */
    private Estrategia estrategia;
    /**
     * Lista de jugadores
     */
    private final List<Jugador> objetos;

    /**
     * Constructor
     * @param e
     * @param j 
     */
    public Contexto(Estrategia e, List<Jugador> j) {
        this.estrategia = e;
        this.objetos = j;
    }

    /**
     * Establece la estrategia a usar.
     *
     * @param e Estrategia a usar.
     */
    public void setEstrategia(Estrategia e) {
        this.estrategia = e;
    }

    /**
     * Ejecuta la estrategia.
     */
    public void ejecutaEstrategia() {
        estrategia.ordena(objetos);
    }
}
