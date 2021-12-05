package Estrategia;

import Modelos.Equipo;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Clase que se utiliza para ordenar la clasificación de los equipos según sus
 * puntos
 *
 * @author Javier y Chrsitian
 */
public class EstrategiaConcretaClasificacion implements EstrategiaEquipo {

    @Override
    public void ordena(List<Equipo> equipos) {
        Comparator AsisComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Equipo uni1 = (Equipo) o1;
                Equipo uni2 = (Equipo) o2;

                return uni1.getPuntos() - uni2.getPuntos();
            }
        };

        Collections.sort(equipos, AsisComp.reversed());
    }

}
