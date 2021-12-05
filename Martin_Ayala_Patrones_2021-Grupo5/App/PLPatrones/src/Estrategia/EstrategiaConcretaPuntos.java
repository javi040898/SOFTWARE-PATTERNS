package Estrategia;

import Modelos.Jugador;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Clase que se utiliza para ordenar los jugadores según sus puntos
 * @author Javier y Chrsitian
 */
public class EstrategiaConcretaPuntos implements Estrategia {

    @Override
    public void ordena(List<Jugador> jugadores) {
        Comparator PtosAluComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Jugador uni1 = (Jugador) o1;
                Jugador uni2 = (Jugador) o2;

                return uni1.getMediaPuntos()-uni2.getMediaPuntos();
            }
        };

        Collections.sort(jugadores, PtosAluComp.reversed());
    }
    
}
