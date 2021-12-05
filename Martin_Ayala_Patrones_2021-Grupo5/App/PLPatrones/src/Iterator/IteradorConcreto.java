package Iterator;

/**
 * Clase que a a partir del iterador ya creado y la lista que hay que recorrer,
 * realiza operaciones como mostrar el priemer elemento de dicha lista, mostrar
 * el siguiente elemento al actual, decir si hay mas elementos y mostrar el
 * elemento acutal
 *
 * @author Javier y Christian
 */
public class IteradorConcreto implements Iterador {

    /**
     * Referencia al agregado concreto.
     */
    private final AgregadoConcreto agregado;
    /**
     *
     * Indica la posición actual en la lista.
     */
    private int indice = 0;

    /**
     * Constructor.
     *
     * @param agregado Agregado concreto.
     */
    public IteradorConcreto(AgregadoConcreto agregado) {
        this.agregado = agregado;
    }

    @Override
    public Object primero() throws IndexOutOfBoundsException {
        Object objeto = null;
        if (!agregado.elementos.isEmpty()) {
            indice = 0;
            objeto = agregado.elementos.get(0);
        } else {
            throw new IndexOutOfBoundsException();
        }
        return objeto;
    }

    @Override
    public Object siguiente() throws IndexOutOfBoundsException {
        Object objeto = null;
        if (indice < agregado.elementos.size()) {
            objeto = agregado.elementos.get(indice);
            indice++;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return objeto;
    }

    @Override
    public boolean hayMas() {
        boolean resultado = true;
        if (agregado.elementos.isEmpty() || indice == agregado.elementos.size()) {
            resultado = false;
        }
        return resultado;
    }

    @Override
    public Object elementoActual() throws IndexOutOfBoundsException {
        Object objeto = null;
        if (indice < agregado.elementos.size()) {
            objeto = agregado.elementos.get(indice);
        } else {
            throw new IndexOutOfBoundsException();
        }
        return objeto;
    }
}
