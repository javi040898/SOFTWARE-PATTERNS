package SQL;

import DAO.DAOException;
import DAO.JugadorDAO;
import Modelos.Jugador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Clase donde se realizan las funciones necesarias para operar con la tabla
 * Jugador de la BD
 *
 * @author Javier y Christian
 */
public class PostgreSQLJugadorDAO implements JugadorDAO {

    /**
     * Variable con la consulta SQL para insertar un jugador
     */
    final String INSERT = "INSERT INTO \"Jugador\" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    /**
     * Variable con la consulta SQL para obtener todos los jugadores
     */
    final String GETALL = "SELECT * FROM \"Jugador\"";
    /**
     * Variable con la consulta SQL para obtener un jugador con el DNI
     * introducido
     */
    final String GETONE = "SELECT * FROM \"Jugador\" WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para eliminar un jugador con el DNI
     * introducido
     */
    final String DELETEONE = "DELETE FROM \"Jugador\" WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para actualizar el salario de un jugador con
     * el DNI introducido
     */
    final String UPDATESAL = "UPDATE \"Jugador\" SET \"Salario\"= ? WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para actualizar el dorsal de un jugador con
     * el DNI introducido
     */
    final String UPDATEDOR = "UPDATE \"Jugador\" SET \"Dorsal\"= ? WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para actualizar el estado de un jugador con
     * el DNI introducido
     */
    final String UPDATEEST = "UPDATE \"Jugador\" SET \"Estado\"= ? WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para actualizar la fecha de fin de contrato
     * de un jugador con el DNI introducido
     */
    final String UPDATEFECHA = "UPDATE \"Jugador\" SET \"FechaFinContrato\"= ? WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para obtener el DNI un jugador con el DNI
     * introducido
     */
    final String GETDNI = "SELECT \"DNI\" FROM \"Jugador\" WHERE \"DNI\" = ";
    /**
     * Variable con la consulta SQL para obtener el id del equipo de un jugador
     * con el DNI introducido
     */
    final String GETIDEQUIPO = "select \"id_Equipo\" from \"Jugador\" where \"DNI\" = ";
    /**
     * Variable con la consulta SQL para obtener todos los jugadores de un
     * equipo
     */
    final String GETPLANTILLA = "select * from \"Jugador\" inner join \"Equipo\" on \"id_Equipo\"=\"id\" where \"Equipo\".\"Nombre\" = ";
    /**
     * Variable con la consulta SQL para obtener el estado un jugador con el DNI
     * introducido
     */
    final String GETESTADO = "select \"Estado\" from \"Jugador\" where \"DNI\" = ";
    /**
     * Variable con la consulta SQL para obtener la contraseña un jugador con el
     * DNI introducido
     */
    final String GETCONTRASEÑA = "SELECT \"Password\" FROM \"Jugador\" WHERE \"DNI\" = ";
    /**
     * Variable con la consulta SQL para actualizar el e-mail de un jugador con
     * el DNI introducido
     */
    final String UPDATECORREO = "UPDATE \"Jugador\" SET \"CorreoElectronico\"= ? WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para actualizar la contraseña de un jugador
     * con el DNI introducido
     */
    final String UPDATECONTRA = "UPDATE \"Jugador\" SET \"Password\"= ? WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para obtener el numero de jugadores de un
     * equipo
     */
    final String GETNUMJUGADORES = "select count(*) from \"Jugador\" where \"id_Equipo\"= ";
    /**
     * Variable con la consulta SQL obtener cuantas veces esta un dorsal en un
     * equipo
     */
    final String GETDORSALES = "select count(*) from \"Jugador\" where \"id_Equipo\"= ";
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
    public PostgreSQLJugadorDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Jugador j) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = this.conn.prepareStatement(INSERT);
            stat.setString(1, j.getDNI());
            stat.setInt(2, j.getDorsal());
            stat.setString(3, j.getNombre());
            stat.setString(4, j.getApellidos());
            stat.setInt(5, j.getMediaPuntos());
            stat.setInt(6, j.getMediaRebotes());
            stat.setInt(7, j.getMediaAsistencias());
            stat.setDate(8, new Date(j.getFinContrato().getTime()));
            stat.setString(9, j.getNacionalidad());
            stat.setString(10, j.getPosicion());
            stat.setInt(11, j.getSalario());
            stat.setString(12, j.getEstado());
            stat.setInt(13, j.getIdEquipo());
            stat.setString(14, j.getCorreoElectronico());
            stat.setString(15, j.getPassword());

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
                JOptionPane.showMessageDialog(null, "Puede que el jugador no se haya borrado");
                throw new DAOException("Puede que el jugador no se haya borrado");

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
        PreparedStatement stat = null;

        try {
            stat = conn.prepareStatement(UPDATESAL);
            stat.setInt(1, i);
            stat.setString(2, DNI);

            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que el jugador no se haya actualizado");

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
    public void modificarD(Integer i, String DNI) throws DAOException {
        PreparedStatement stat = null;

        try {
            stat = conn.prepareStatement(UPDATEDOR);
            stat.setInt(1, i);
            stat.setString(2, DNI);

            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que el jugador no se haya actualizado");

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
    public void modificarE(String i, String DNI) throws DAOException {
        PreparedStatement stat = null;

        try {
            stat = conn.prepareStatement(UPDATEEST);
            stat.setString(1, i);
            stat.setString(2, DNI);

            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que el jugador no se haya actualizado");

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
    public void modificarF(Date f, String DNI) throws DAOException {
        PreparedStatement stat = null;

        try {
            stat = conn.prepareStatement(UPDATEFECHA);
            stat.setDate(1, f);
            stat.setString(2, DNI);

            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que el jugador no se haya actualizado");

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
     * @return Instancia de Directiva
     * @throws SQLException
     */
    private Jugador convertir(ResultSet rs) throws SQLException {
        int dorsal = rs.getInt("dorsal");
        String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        int mediaPuntos = rs.getInt("mediaPuntos");
        int mediaRebotes = rs.getInt("mediaRebotes");
        int mediaAsistencias = rs.getInt("mediaAsistencias");
        Date finContrato = rs.getDate("FechaFinContrato");
        String nacionalidad = rs.getString("nacionalidad");
        String posicion = rs.getString("posicion");
        int salario = rs.getInt("salario");
        String estado = rs.getString("estado");
        Integer idEquipo = rs.getInt("id_Equipo");
        String correoElectronico = rs.getString("correoElectronico");
        String password = rs.getString("password");
        Jugador jugador = new Jugador(dorsal, nombre, apellidos, mediaPuntos, mediaRebotes, mediaAsistencias, finContrato, nacionalidad,
                posicion, salario, estado, idEquipo, correoElectronico, password);

        jugador.setDNI(rs.getString("DNI"));

        return jugador;

    }

    @Override
    public List<Jugador> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Jugador> jugadores = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                jugadores.add(convertir(rs));
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
        return jugadores;
    }

    @Override
    public Jugador obtener(String DNI) throws DAOException {

        PreparedStatement stat = null;
        ResultSet rs = null;
        Jugador j = null;

        try {
            stat = conn.prepareStatement(GETONE);
            stat.setString(1, DNI);
            rs = stat.executeQuery();
            if (rs.next()) {
                j = convertir(rs);
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
        return j;
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
    public int obtenerNumeroJugadores(int id_Equipo) throws DAOException {
        Statement stat = null;
        ResultSet rs = null;
        int a = 0;

        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(GETNUMJUGADORES + id_Equipo);
            if (rs.next()) {
                a = (rs.getInt(1));

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
    public int obtenerDorsal(int id_Equipo, int dorsal) throws DAOException {
        Statement stat = null;
        ResultSet rs = null;
        int a = 0;

        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(GETNUMJUGADORES + id_Equipo + "and \"Dorsal\" =" + dorsal);
            if (rs.next()) {
                a = (rs.getInt(1));

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
    public String obtenerEstado(String DNI) throws DAOException {
        Statement stat = null;
        ResultSet rs = null;
        String a = "";

        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(GETESTADO + DNI);
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

    @Override
    public List<Jugador> obtenerPlantilla(String Nombre_equipo) throws DAOException {
        Statement stat = null;
        ResultSet rs = null;
        List<Jugador> jugadores = new ArrayList<>();

        try {
            stat = conn.createStatement();

            rs = stat.executeQuery(GETPLANTILLA + "\'" + Nombre_equipo + "\'");

            while (rs.next()) {
                jugadores.add(convertir(rs));

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
        return jugadores;
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

}
