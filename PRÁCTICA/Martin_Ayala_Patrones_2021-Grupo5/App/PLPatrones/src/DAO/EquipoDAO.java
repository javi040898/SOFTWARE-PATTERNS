package DAO;

import Modelos.Equipo;

/**
 * Interfaz donde se definan las funciones de la tabla Dueño de la BD
 *
 * @author Javier y Christian
 */
public interface EquipoDAO extends DAO<Equipo, Integer> {

    /**
     *
     * @param nombre
     * @return Método para obtener el id del equipo al que pertenece a partir
     * del nombre
     * @throws DAOException
     */
    public String obtenerID(String nombre) throws DAOException;

}
