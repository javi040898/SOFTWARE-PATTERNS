
package DAO;

import Modelos.Jugador;
import java.sql.Date;
import java.util.List;

/**
 * Interfaz donde se definan las funciones de la tabla Jugador de la BD
 * @author Javier
 */
public interface JugadorDAO extends DAO<Jugador,String> {  
    /**
     * Método para obtener el DNI a partir de su DNI
     * Esto se utiliza para saber si existe ese DNI en la BD, ya que si no devuelve nada, no existe ese DNI
     * @param DNI
     * @return El DNI en formato String
     * @throws DAOException 
     */
    String obtenerDNI(String DNI) throws DAOException;
    /**
     * Método para obtener la contraseña a partir de su DNI
     * @param DNI
     * @return La contraseña en formato String
     * @throws DAOException 
     */
    String obtenerContraseña(String DNI) throws DAOException;
    
    /**
     * Método para actualizar el dorsal de un registro de la tabla Jugador
     * @param i
     * @param DNI
     * @throws DAOException 
     */
    void modificarD(Integer i, String DNI) throws DAOException;
    /**
     * Método para actualizar el estado de un registro de la tabla Jugador
     * @param i
     * @param DNI
     * @throws DAOException 
     */
    void modificarE(String i, String DNI) throws DAOException;
    /**
     * Método para actualizar la fecha de fin de contrato de un registro de la tabla Jugador
     * @param f
     * @param DNI
     * @throws DAOException 
     */
    void modificarF(Date f, String DNI) throws DAOException;
    /**
     * Método para obtener el id del equipo al que pertenece a partir de su DNI
     *
     * @param DNI
     * @return El id del equipo en formato int
     * @throws DAOException
     */
    int obtenerIDEquipo(String DNI) throws DAOException;
    /**
     * Método para obtener la plantilla entera de jugadores de un equipo
     * @param Nombre_equipo
     * @return Lista con todos los jugadores
     * @throws DAOException 
     */
    List<Jugador> obtenerPlantilla(String Nombre_equipo) throws DAOException;
    /**
     * Método para obtener el estado de un jugador
     * @param DNI
     * @return Estado de un jugador en formato String
     * @throws DAOException 
     */
    String obtenerEstado (String DNI) throws DAOException;
    /**
     * Método para obtener el número de jugadores de un equipo
     * Se usará para comprobar que no sobrepasa el máximo ni es por debajo del mínimo
     * @param id_Equipo
     * @return Número de jugadores en formato int
     * @throws DAOException 
     */
    int obtenerNumeroJugadores(int id_Equipo) throws DAOException;
    /**
     * Método para obtener el dorsal de un jugador
     * Se usará para coprobar que no haya dos jugadores con el mismo dorsal en el mismo equipo
     * @param id_Equipo
     * @param dorsal
     * @return Dorsal del jugador en formato int
     * @throws DAOException 
     */
    int obtenerDorsal(int id_Equipo,int dorsal) throws DAOException;
    
}
