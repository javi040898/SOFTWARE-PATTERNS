package Estrategia;

import Modelos.Equipo;
import java.util.List;

/**
 * Clase que se utiliza para ver que estrategia de ordenación se va a usar y ejecutarla sobre los equipos
 * @author Javier y Chrsitian
 */
public class ContextoEquipo {
    /**
     * Estrategia a usar
     */
    private EstrategiaEquipo estrategia;
    /**
     * Lista de equipos
     */
    private final List<Equipo> objetos; 

    /**
     * Constructor
     * @param e estrategia que se va a usar
     * @param eq lista de equipos
     */
    public ContextoEquipo(EstrategiaEquipo e, List<Equipo> eq) { 
        this.estrategia = e;
        this.objetos = eq;
    }

    /**
     * Establece la estrategia a usar.
     *
     * @param e Estrategia a usar.
     */
    public void setEstrategia(EstrategiaEquipo e) {
        this.estrategia = e;
    }

    /**
     * Ejecuta la estrategia.
     */
    public void ejecutaEstrategia() {
        estrategia.ordena(objetos);
    }
}
