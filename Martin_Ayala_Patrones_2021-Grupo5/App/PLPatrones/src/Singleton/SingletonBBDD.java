package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que implementa el patron Singleton conocido
 *
 * @author Javier y Christian
 */
public class SingletonBBDD {

    /**
     * Instancia de la clase. Es privada: solo accesible por la propia clase. Es
     * estática: propia de la clase (compartida por los objetos).
     */
    private static SingletonBBDD instancia;

    /**
     * variable para conectar con la base de datos
     */
    private static Connection conn = null;

    /**
     * Constructor privado. No se permite crear instancias de la clase Singleton
     * usando new.
     */
    private SingletonBBDD() {
    }

    /**
     *
     * @return variable que establece la conexion can la base de datos
     */
    public Connection connect() {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PatronesSoftware", "postgres", "postgres");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Devuelve la instancia de la clase. Acceso controlado a la única
     * instancia. Otras clases que quieran una referencia a la única instancia
     * de la clase Singleton conseguirán esa instancia llamando al método
     * estático getInstancia de la clase.
     *
     * @return Instancia de la clase.
     * @throws SQLException
     */
    public static SingletonBBDD getInstancia() throws SQLException {
        if (instancia == null) {// Si la instancia es null, se crea.
            instancia = new SingletonBBDD();

        }
        return instancia;
    }
}