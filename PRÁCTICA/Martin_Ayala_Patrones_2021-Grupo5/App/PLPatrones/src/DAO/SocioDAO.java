package DAO;

import Modelos.Socio;

/**
 * Interfaz donde se definan las funciones de la tabla Socio de la BD
 *
 * @author Javier
 */
public interface SocioDAO extends DAO<Socio, String> {

    /**
     * Método para obtener el DNI a partir de su DNI Esto se utiliza para saber
     * si existe ese DNI en la BD, ya que si no devuelve nada, no existe ese DNI
     *
     * @param DNI
     * @return El DNI en formato String
     * @throws DAOException
     */
    String obtenerDNI(String DNI) throws DAOException;

    /**
     * Método para obtener la contraseña a partir de su DNI
     *
     * @param DNI
     * @return La contraseña en formato String
     * @throws DAOException
     */
    String obtenerContraseña(String DNI) throws DAOException;
    /**
     * Método para obtener el id del equipo al que pertenece a partir de su DNI
     *
     * @param DNI
     * @return El id del equipo en formato int
     * @throws DAOException
     */
    int obtenerIDEquipo(String DNI) throws DAOException;

}
