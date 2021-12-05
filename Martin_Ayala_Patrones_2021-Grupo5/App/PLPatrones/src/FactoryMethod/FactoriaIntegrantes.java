package FactoryMethod;

/**
 * Creador: clase para crear distintos integrantes de plantilla.
 *
 * @author Javier y Christian
 */
public class FactoriaIntegrantes {

    /**
     * Constante
     */
    public static final int JUGADOR = 0;
    /**
     * Constante
     */
    public static final int MIEMBROCT = 1;

    /**
     * Crea un objeto de tipo IntegrantePlantilla.
     *
     * @param tipo Tipo de integrante de la plantilla que se desea crear.
     * @return Objeto de tipo IntegrantePlantilla.
     */
    public IntegrantePlantilla getIntegrantePlantilla(int tipo) {
        if (tipo == JUGADOR) {
            return (new JugadorIntegrantePlantilla());
        } else {
            return (new MiembroCTIntegrantePlantilla());
        }

    }

}
