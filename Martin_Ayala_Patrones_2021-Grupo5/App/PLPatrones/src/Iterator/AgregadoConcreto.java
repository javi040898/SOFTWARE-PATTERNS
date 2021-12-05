package Iterator;

import java.util.List;

/**
 * Clase que crea una listabde elementos que se van a recorrer y el iterador que
 * lo va a hacer
 *
 * @author Javier y Christian
 */
public class AgregadoConcreto implements Agregado {

    /**
     * Lista de elementos a recorrer.
     *
     */
    public List elementos;

    /**
     * Constructor.
     *
     * @param vec Lista de elementos a recorrer.
     */
    public AgregadoConcreto(List vec) {
        elementos = vec;
    }

    @Override
    public Iterador crearIterador() {
        return new IteradorConcreto(this);
    }
}
