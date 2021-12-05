package Proxy;

import DAO.DAOException;
import java.sql.SQLException;

/**
 * Clase de la que se obtendrán los datos del usuario
 * @author Javier y Christian
 */
public class Usuario implements InterfaceUsuario {
    /**
     * String que representa el id/dni del usuario
     */
    private String id;
    /**
     * String que representa la contraseña del usuario
     */
    private String contraseña;

    /**
     * Constructor
     * @param id id del usuario
     * @param contraseña contraseña del usuario
     */
    public Usuario(String id, String contraseña) {
        this.id = id;
        this.contraseña = contraseña;
    }
    /**
     * 
     * @return devuelve el id del usuario
     */
    public String getId() {
        return id;
    }
    /**
     *  Método para cambiar el id del usuario
     * @param id id del usuario
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * 
     * @return devuelve la contraseña del usuario
     */
    public String getContraseña() {
        return contraseña;
    }
    /**
     * Método para cambiar la contraseña del usuario
     * @param contraseña contraseña del usuario
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public boolean comprobarJugadorUsuario(Usuario u) throws DAOException, SQLException {
        return true;
    }

    @Override
    public boolean comprobarDuenoUsuario(Usuario u) throws DAOException, SQLException {
        return true;
    }

    @Override
    public boolean comprobarDirectivaUsuario(Usuario u) throws DAOException, SQLException {
        return true;
    }

    @Override
    public boolean comprobarSocioUsuario(Usuario u) throws DAOException, SQLException {
        return true;
    }

    @Override
    public boolean comprobarMiembroCTUsuario(Usuario u) throws DAOException, SQLException {
        return true;
    }

}