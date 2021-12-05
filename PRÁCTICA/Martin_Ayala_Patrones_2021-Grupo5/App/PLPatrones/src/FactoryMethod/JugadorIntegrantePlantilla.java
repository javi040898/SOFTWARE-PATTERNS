package FactoryMethod;

import DAO.DAO;
import DAO.JugadorDAO;
import SQL.PostgreSQLJugadorDAO;
import java.sql.SQLException;
import Singleton.SingletonBBDD;

/**
 * Producto concreto
 *
 * @author Javier y Christian
 */
public class JugadorIntegrantePlantilla extends IntegrantePlantilla {

    @Override
    public DAO crearIntegrantePostgreSQL() {
        JugadorDAO dao = null;
        try {
            SingletonBBDD singleton = SingletonBBDD.getInstancia();
            dao = new PostgreSQLJugadorDAO(singleton.connect());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dao;
    }

}
