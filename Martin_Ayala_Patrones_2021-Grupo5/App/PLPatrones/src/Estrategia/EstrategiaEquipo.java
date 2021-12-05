package Estrategia;

import Modelos.Equipo;
import java.util.List;

/**
 * 
 * @author Javier y Chrsitian
 */
public interface EstrategiaEquipo {
    /**
     * Metodo que ordena los equipos dependiendo de la estrategia concreta a utilizar,
     * en este caso solo por puntos que tenga los equipos
     * @param equipos lista de equipos que se van a ordenar
     */
    public void ordena(List<Equipo> equipos);
}
