package State;

import DAO.DAOException;
import DAO.JugadorDAO;
import SQL.PostgreSQLJugadorDAO;
import java.sql.SQLException;
import Singleton.SingletonBBDD;

/**
 * Clase que dependiendo del estado del jugador, le permitirá hacer una cosa u
 * otra
 *
 * @author Javier y Christian
 */
public class JugadorEstado {

    private Estado estadoActual;

    /**
     * Método que limita las accione de jugadores a partir de sus estados
     * @param DNI dni del jugador
     * @throws DAOException 
     */
    public void limitarAccion(String DNI) throws DAOException {
        try {
            SingletonBBDD singleton = SingletonBBDD.getInstancia();
            JugadorDAO dao = new PostgreSQLJugadorDAO(singleton.connect());
            if (dao.obtenerEstado("\'" + DNI + "\'").equals("Cedido")) {
                estadoActual = new EstadoCedido();
                estadoActual.ejecutarEstado();

            } else {
                estadoActual = new EstadoEnPropiedad(DNI);
                estadoActual.ejecutarEstado();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}