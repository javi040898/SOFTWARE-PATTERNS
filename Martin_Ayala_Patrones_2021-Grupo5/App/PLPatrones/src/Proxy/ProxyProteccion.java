package Proxy;

import DAO.DAOException;
import DAO.DirectivaDAO;
import DAO.DueñoDAO;
import DAO.JugadorDAO;
import DAO.MiembroCuerpoTecnicoDAO;
import DAO.SocioDAO;
import SQL.PostgreSQLDirectivaDAO;
import SQL.PostgreSQLDueñoDAO;
import SQL.PostgreSQLJugadorDAO;
import SQL.PostgreSQLMCuerpoTecnicoDAO;
import SQL.PostgreSQLSocioDAO;
import java.sql.SQLException;
import Singleton.SingletonBBDD;

/**
 * Clase que se usa para coprobar que las credenciales coinciden con los datos
 * que se encuentran en nuestra base de datos
 *
 * @author Javier y Christian
 */
public class ProxyProteccion implements InterfaceUsuario {

    /**
     * Variable de tipo usuario
     */
    private final Usuario u;

    /**
     *
     * @param u objeto de tipo usuario
     */
    public ProxyProteccion(Usuario u) {
        this.u = u;
    }

    @Override
    public boolean comprobarJugadorUsuario(Usuario u) throws DAOException, SQLException {

        boolean salida = false;

        try {
            SingletonBBDD singleton = SingletonBBDD.getInstancia();
            JugadorDAO dao = new PostgreSQLJugadorDAO(singleton.connect());

            salida = dao.obtenerDNI("\'" + u.getId() + "\'").equals(u.getId()) && dao.obtenerContraseña("\'" + u.getId() + "\'").equals(u.getContraseña());
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }
        return salida;
    }

    @Override
    public boolean comprobarDuenoUsuario(Usuario u) throws DAOException, SQLException {

        boolean salida = false;
        try {
            SingletonBBDD singleton = SingletonBBDD.getInstancia();
            DueñoDAO dao = new PostgreSQLDueñoDAO(singleton.connect());

            salida = dao.obtenerDNI("\'" + u.getId() + "\'").equals(u.getId()) && dao.obtenerContraseña("\'" + u.getId() + "\'").equals(u.getContraseña());
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }
        return salida;
    }

    @Override
    public boolean comprobarDirectivaUsuario(Usuario u) throws DAOException, SQLException {

        boolean salida = false;

        try {
            SingletonBBDD singleton = SingletonBBDD.getInstancia();
            DirectivaDAO dao = new PostgreSQLDirectivaDAO(singleton.connect());

            salida = dao.obtenerDNI("\'" + u.getId() + "\'").equals(u.getId()) && dao.obtenerContraseña("\'" + u.getId() + "\'").equals(u.getContraseña());
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }
        return salida;
    }

    @Override
    public boolean comprobarSocioUsuario(Usuario u) throws DAOException, SQLException {

        boolean salida = false;

        try {
            SingletonBBDD singleton = SingletonBBDD.getInstancia();
            SocioDAO dao = new PostgreSQLSocioDAO(singleton.connect());

            salida = dao.obtenerDNI("\'" + u.getId() + "\'").equals(u.getId()) && dao.obtenerContraseña("\'" + u.getId() + "\'").equals(u.getContraseña());
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }
        return salida;
    }

    @Override
    public boolean comprobarMiembroCTUsuario(Usuario u) throws DAOException, SQLException {

        boolean salida = false;

        try {
            SingletonBBDD singleton = SingletonBBDD.getInstancia();
            MiembroCuerpoTecnicoDAO dao = new PostgreSQLMCuerpoTecnicoDAO(singleton.connect());
            salida = dao.obtenerDNI("\'" + u.getId() + "\'").equals(u.getId()) && dao.obtenerContraseña("\'" + u.getId() + "\'").equals(u.getContraseña());
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }
        return salida;
    }
}
