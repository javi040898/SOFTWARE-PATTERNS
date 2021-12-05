package SQL;

import DAO.DAOException;
import DAO.EquipoDAO;
import Modelos.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase donde se realizan las funciones necesarias para operar con la tabla
 * Equipo de la BD
 *
 * @author Javier y Christian
 */
public class PostgreSQLEquipoDAO implements EquipoDAO {

    /**
     * Variable con la consulta SQL para insertar un miembro de la directiva
     */
    final String INSERT = "INSERT INTO \"Equipo\" VALUES(?,?,?,?,?,?,?,?,?);";
    /**
     * Variable con la consulta SQL para obtener todos los miembros de la
     * directiva
     */
    final String GETALL = "SELECT * FROM \"Equipo\"";
    /**
     * Variable con la consulta SQL para obtener un miembro de la directvia con
     * el DNI introducido
     */
    final String GETONE = "SELECT \"id\" FROM \"Equipo\" WHERE \"Nombre\" = ";
    /**
     * Variable con la consulta SQL para eliminar un miembro de la directiva con
     * el DNI introducido
     */
    final String DELETEONE = "DELETE FROM \"Equipo\" WHERE \"id\" = ";
    /**
     * Variable con la consulta SQL para actualizar el salario de un miembro de
     * la directiva con el DNI introducido
     */
    final String UPDATESAL = "UPDATE \"Equipo\" SET \"Patrocinador\"= ? WHERE \"id\" = ?";
    /**
     * Variable con la consulta SQL para obtener el DNI un miembro de la
     * directiva con el DNI introducido
     */
    final String GETDNI = "SELECT \"DNI\" FROM \"Equipo\" WHERE \"id\" = ";

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
    public PostgreSQLEquipoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Equipo t) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = this.conn.prepareStatement(INSERT);
            stat.setInt(1, t.getId());
            stat.setString(2, t.getNombre());
            stat.setString(3, t.getCiudad());
            stat.setString(4, t.getPabellon());
            stat.setString(5, t.getPatrocinador());
            stat.setString(6, t.getEquipacionLocal());
            stat.setString(7, t.getEquipacionVisitante());
            stat.setInt(8, t.getId_Liga());
            stat.setInt(9, t.getPuntos());

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

    /**
     * Método para obtener los campos de la tabla de SQL y transformarlos a
     * código java
     *
     * @param rs
     * @return Instancia de Equipo
     * @throws SQLException
     */
    private Equipo convertir(ResultSet rs) throws SQLException {
        String nombre = rs.getString("Nombre");
        String ciudad = rs.getString("ciudad");
        String pabellon = rs.getString("pabellon");
        String patrocinador = rs.getString("patrocinador");
        String equipacionLocal = rs.getString("equipacionLocal");
        String equipacionVisitante = rs.getString("equipacionVisitante");
        Integer idLiga = rs.getInt("id_Liga");
        Integer puntos = rs.getInt("puntos");
        Equipo equipo = new Equipo(nombre, ciudad, pabellon, patrocinador, equipacionLocal, equipacionVisitante, idLiga, puntos);

        equipo.setId(rs.getInt("id"));
        return equipo;
    }

    @Override
    public void eliminar(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Integer i, String DNI) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Equipo> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Equipo> equipos = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                equipos.add(convertir(rs));
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
        return equipos;
    }

    @Override
    public Equipo obtener(Integer id) throws DAOException {
        return null;

    }

    @Override
    public String obtenerID(String nombre) throws DAOException {

        Statement stat = null;
        ResultSet rs = null;
        String a = "";

        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(GETONE + nombre);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarContraseña(String i, String DNI) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
