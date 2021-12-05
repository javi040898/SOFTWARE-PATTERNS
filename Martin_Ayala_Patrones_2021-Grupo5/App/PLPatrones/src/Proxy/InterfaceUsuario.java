package Proxy;

import DAO.DAOException;
import java.sql.SQLException;

/**
 * Interfaz que define los métodos de comprobación de credenciales
 *
 * @author Javier y Christian
 */
public interface InterfaceUsuario {

    /**
     * Método que comprueba si las credenciales introducidas del jugador
     * coinciden con la información de la base de datos
     *
     * @param u objeto de tipo Usuario
     * @return devuelve si los datos introducidos del jugador coinciden con la
     * información de la base de datos
     * @throws DAOException
     * @throws SQLException
     */
    public boolean comprobarJugadorUsuario(Usuario u) throws DAOException, SQLException;

    /**
     * Método que comprueba si las credenciales introducidas del dueño coinciden
     * con la información de la base de datos
     *
     * @param u objeto de tipo Usuario
     * @return devuelve si los datos introducidos del dueño coinciden con la
     * información de la base de datos
     * @throws DAOException
     * @throws SQLException
     */
    public boolean comprobarDuenoUsuario(Usuario u) throws DAOException, SQLException;

    /**
     * Método que comprueba si las credenciales introducidas del directivo
     * coinciden con la información de la base de datos
     *
     * @param u objeto de tipo Usuario
     * @return devuelve si los datos introducidos del directivo coinciden con la
     * información de la base de datos
     * @throws DAOException
     * @throws SQLException
     */
    public boolean comprobarDirectivaUsuario(Usuario u) throws DAOException, SQLException;

    /**
     * Método que comprueba si las credenciales introducidas del socio coinciden
     * con la información de la base de datos
     *
     * @param u objeto de tipo Usuario
     * @return devuelve si los datos introducidos del socio coinciden con la
     * información de la base de datos
     * @throws DAOException
     * @throws SQLException
     */
    public boolean comprobarSocioUsuario(Usuario u) throws DAOException, SQLException;

    /**
     * Método que comprueba si las credenciales introducidas del miembro del CT
     * coinciden con la información de la base de datos
     *
     * @param u objeto de tipo Usuario
     * @return devuelve si los datos introducidos del miembro del CT coinciden
     * con la información de la base de datos
     * @throws DAOException
     * @throws SQLException
     */
    public boolean comprobarMiembroCTUsuario(Usuario u) throws DAOException, SQLException;

}
