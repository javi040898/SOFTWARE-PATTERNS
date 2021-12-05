package SQL;

import DAO.DAOException;
import DAO.SocioDAO;
import Modelos.Socio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase donde se realizan las funciones necesarias para operar con la tabla
 * Socio de la BD
 *
 * @author Javier y Christian
 */
public class PostgreSQLSocioDAO implements SocioDAO {

    /**
     * Variable con la consulta SQL para insertar un socio
     */
    final String INSERT = "INSERT INTO \"Socio\" VALUES(?,?,?,?,?,?);";
    /**
     * Variable con la consulta SQL para obtener todos los socios
     */
    final String GETALL = "SELECT * FROM \"Socio\"";
    /**
     * Variable con la consulta SQL para obtener un socio con el DNI introducido
     */
    final String GETONE = "SELECT * FROM \"Socio\" WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para eliminar un socio con el DNI
     * introducido
     */
    final String DELETEONE = "DELETE FROM \"Socio\" WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para obtener el DNI un socio con el DNI
     * introducido
     */
    final String GETDNI = "SELECT \"DNI\" FROM \"Socio\" WHERE \"DNI\" = ";
    /**
     * Variable con la consulta SQL para obtener la contraseña un socio con el
     * DNI introducido
     */
    final String GETCONTRASEÑA = "SELECT \"Password\" FROM \"Socio\" WHERE \"DNI\" = ";
    /**
     * Variable con la consulta SQL para actualizar el e-mail de un socio con el
     * DNI introducido
     */
    final String UPDATECORREO = "UPDATE \"Socio\" SET \"CorreoElectronico\"= ? WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para actualizar la contraseña de un socio
     * con el DNI introducido
     */
    final String UPDATECONTRA = "UPDATE \"Socio\" SET \"Password\"= ? WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para obtener el id del equipo de un socio
     * con el DNI introducido
     */
    final String GETIDEQUIPO = "select \"id_Equipo\" from \"Socio\" where \"DNI\" = ";
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
    public PostgreSQLSocioDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Socio t) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = this.conn.prepareStatement(INSERT);
            stat.setString(1, t.getDNI());
            stat.setString(2, t.getNombre());
            stat.setString(3, t.getApellidos());
            stat.setString(4, t.getCorreoElectronico());
            stat.setInt(5, t.getIdEquipo());
            stat.setString(6, t.getPassword());

            if (stat.executeUpdate() == 0) {
                throw new DAOException("ES POSIBLE QUE NO SE HAYA GUARDADO.");
            }
        } catch (SQLException ex) {
            throw new DAOException("ERROR EN SQL", ex);
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
    public void eliminar(String DNI) throws DAOException {
        PreparedStatement stat = null;

        try {
            stat = conn.prepareStatement(DELETEONE);
            stat.setString(1, DNI);

            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que el socio no se haya borrado");

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
    public void modificar(Integer i, String DNI) throws DAOException {

    }

    /**
     * Método para obtener los campos de la tabla de SQL y transformarlos a
     * código java
     *
     * @param rs
     * @return Instancia de Directiva
     * @throws SQLException
     */
    private Socio convertir(ResultSet rs) throws SQLException {
        String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        String correoElectronico = rs.getString("correoElectronico");
        Integer idEquipo = rs.getInt("id_Equipo");
        String password = rs.getString("password");
        Socio socio = new Socio(nombre, apellidos, correoElectronico, idEquipo, password);

        socio.setDNI(rs.getString("DNI"));

        return socio;

    }

    @Override
    public List<Socio> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Socio> socios = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                socios.add(convertir(rs));
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
        return socios;
    }

    @Override
    public Socio obtener(String DNI) throws DAOException {

        PreparedStatement stat = null;
        ResultSet rs = null;
        Socio s = null;

        try {
            stat = conn.prepareStatement(GETONE);
            stat.setString(1, DNI);
            rs = stat.executeQuery();
            if (rs.next()) {
                s = convertir(rs);
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
        return s;
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

    @Override
    public int obtenerIDEquipo(String DNI) throws DAOException {
        Statement stat = null;
        ResultSet rs = null;
        String a = "0";

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
        return Integer.parseInt(a);
    }
}
