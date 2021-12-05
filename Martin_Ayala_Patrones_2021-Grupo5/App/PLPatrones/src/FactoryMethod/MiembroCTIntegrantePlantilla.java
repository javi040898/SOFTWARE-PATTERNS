package FactoryMethod;

import DAO.DAO;
import DAO.MiembroCuerpoTecnicoDAO;
import SQL.PostgreSQLMCuerpoTecnicoDAO;
import java.sql.SQLException;
import Singleton.SingletonBBDD;

/**
 * Producto concreto
 *
 * @author Javier y Christian
 */
public class MiembroCTIntegrantePlantilla extends IntegrantePlantilla {

    @Override
    public DAO crearIntegrantePostgreSQL() {
        MiembroCuerpoTecnicoDAO dao = null;
        try {
            SingletonBBDD singleton = SingletonBBDD.getInstancia();
            dao = new PostgreSQLMCuerpoTecnicoDAO(singleton.connect());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dao;
    }

}
