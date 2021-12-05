package SQL;

import DAO.DAOException;
import DAO.DueñoDAO;
import Modelos.Dueño;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase donde se realizan las funciones necesarias para operar con la tabla
 * Dueño de la BD
 *
 * @author Javier y Christian
 */
public class PostgreSQLDueñoDAO implements DueñoDAO {

    /**
     * Variable con la consulta SQL para actualizar el salario de un Dueño con
     * el DNI introducido
     */
    final String UPDATESAL = "UPDATE \"Dueño\" SET \"Salario\"= ? WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL paraactualizar el e-mail de un Dueño con el
     * DNI introducido
     */
    final String UPDATECORREO = "UPDATE \"Dueño\" SET \"CorreoElectronico\"= ? WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para obtener la contraseña de un Dueño con
     * el DNI introducido
     */
    final String UPDATECONTRA = "UPDATE \"Dueño\" SET \"Password\"= ? WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para obtener todos los Dueños
     */
    final String GETALL = "SELECT * FROM \"Dueño\"";
    /**
     * Variable con la consulta SQL para obtener un Dueño con el DNI introducido
     */
    final String GETONE = "SELECT * FROM \"Dueño\" WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para obtener el DNI un Dueño con el DNI
     * introducido
     */
    final String GETDNI = "SELECT \"DNI\" FROM \"Dueño\" WHERE \"DNI\" = ";
    /**
     * Variable con la consulta SQL para obtener la contraseña un Dueño con el
     * DNI introducido
     */
    final String GETCONTRASEÑA = "SELECT \"Password\" FROM \"Dueño\" WHERE \"DNI\" = ";
    /**
     * Variable con la consulta SQL para obtener el id del equipo de un Dueño
     * con el DNI introducido
     */
    final String GETIDEQUIPO = "select \"id_Equipo\" from \"Dueño\" where \"DNI\" = ";

    /**
     * Variable tipo Connection para poder hacer adecuadamente la conexión a la
     * BD
     */
    private final Connection conn;

    /**
     * Constructor
     *
     * @param conn
     */
    public PostgreSQLDueñoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Dueño t) {

    }

    @Override
    public void eliminar(String DNI) {

    }

    @Override
    public void modificar(Integer i, String DNI) throws DAOException {
        PreparedStatement stat = null;

        try {
            stat = conn.prepareStatement(UPDATESAL);
            stat.setInt(1, i);
            stat.setString(2, DNI);

            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que el directivo no se haya actualizado");

            }
        } catch (SQLException ex) {
            throw new DAOException("Error de SQL", ex);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("ERROR EN SQL", ex);
                }
            }

        }
    }

    @Override
    public void modificarCorreo(String i, String DNI) throws DAOException {
        PreparedStatement stat = null;

        try {
            stat = conn.prepareStatement(UPDATECORREO);
            stat.setString(1, i);
            stat.setString(2, DNI);

            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que el dueño no se haya actualizado");

            }
        } catch (SQLException ex) {
            throw new DAOException("Error de SQL", ex);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("ERROR EN SQL", ex);
                }
            }

        }
    }

    @Override
    public void modificarContraseña(String i, String DNI) throws DAOException {
        PreparedStatement stat = null;

        try {
            stat = conn.prepareStatement(UPDATECONTRA);
            stat.setString(1, i);
            stat.setString(2, DNI);

            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que el dueño no se haya actualizado");

            }
        } catch (SQLException ex) {
            throw new DAOException("Error de SQL", ex);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("ERROR EN SQL", ex);
                }
            }

        }
    }

    /**
     * Método para obtener los campos de la tabla de SQL y transformarlos a
     * código java
     *
     * @param rs
     * @return Instancia de Dueño
     * @throws SQLException
     */
    private Dueño convertir(ResultSet rs) throws SQLException {
        String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        String nacionalidad = rs.getString("nacionalidad");
        String correoElectronico = rs.getString("correoElectronico");
        Integer idEquipo = rs.getInt("id_Equipo");
        String password = rs.getString("password");
        Dueño dueño = new Dueño(nombre, apellidos, nacionalidad, correoElectronico, idEquipo, password);

        dueño.setDNI(rs.getString("DNI"));
        return dueño;
    }

    @Override
    public List<Dueño> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Dueño> dueños = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                dueños.add(convertir(rs));
            }

        } catch (SQLException ex) {
            throw new DAOException("ERROR EN SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("ERROR EN SQL", ex);
                }

            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("ERROR EN SQL", ex);
                }
            }
        }
        return dueños;
    }

    @Override
    public Dueño obtener(String id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Dueño dueño = null;

        try {
            stat = conn.prepareStatement(GETONE);
            stat.setString(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                dueño = convertir(rs);
            } else {
                throw new DAOException("NO SE HA ENCONTRADO ESE REGISTRO");
            }
        } catch (SQLException ex) {
            throw new DAOException("ERROR EN SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("ERROR EN SQL", ex);
                }

            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("ERROR EN SQL", ex);
                }
            }
        }
        return dueño;
    }

    @Override
    public String obtenerDNI(String DNI) throws DAOException {
        Statement stat = null;
        ResultSet rs = null;
        String a = "";

        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(GETDNI + DNI);
            if (rs.next()) {
                a = a + (rs.getString(1).trim());

            }

        } catch (SQLException ex) {
            throw new DAOException("ERROR EN SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("ERROR EN SQL", ex);
                }

            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("ERROR EN SQL", ex);
                }
            }
        }
        return a;
    }

    @Override
    public String obtenerContraseña(String DNI) throws DAOException {
        Statement stat = null;
        ResultSet rs = null;
        String a = "";

        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(GETCONTRASEÑA + DNI);
            if (rs.next()) {
                a = a + (rs.getString(1).trim());

            }

        } catch (SQLException ex) {
            throw new DAOException("ERROR EN SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("ERROR EN SQL", ex);
                }

            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("ERROR EN SQL", ex);
                }
            }
        }
        return a;
    }

    @Override
    public String obtenerIDEquipo(String DNI) throws DAOException {
        Statement stat = null;
        ResultSet rs = null;
        String a = "";

        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(GETIDEQUIPO + DNI);
            if (rs.next()) {
                a = a + (rs.getString(1).trim());

            }

        } catch (SQLException ex) {
            throw new DAOException("ERROR EN SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("ERROR EN SQL", ex);
                }

            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("ERROR EN SQL", ex);
                }
            }
        }
        return a;
    }

}
