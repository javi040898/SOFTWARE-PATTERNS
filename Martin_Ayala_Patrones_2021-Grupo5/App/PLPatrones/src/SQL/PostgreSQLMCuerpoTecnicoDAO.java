package SQL;

import DAO.DAOException;
import DAO.MiembroCuerpoTecnicoDAO;
import Modelos.MiembroCuerpoTecnico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase donde se realizan las funciones necesarias para operar con la tabla
 * MiembroCuerpoTecnico de la BD
 *
 * @author Javier y Christian
 */
public class PostgreSQLMCuerpoTecnicoDAO implements MiembroCuerpoTecnicoDAO {

    /**
     * Variable con la consulta SQL para insertar un miembro del cuerpo tecnico
     */
    final String INSERT = "INSERT INTO \"MiembroCuerpoTecnico\" VALUES(?,?,?,?,?,?,?,?,?,?,?);";
    /**
     * Variable con la consulta SQL para obtener todos los miembros del cuerpo
     * tecnico
     */
    final String GETALL = "SELECT * FROM \"MiembroCuerpoTecnico\"";
    /**
     * Variable con la consulta SQL para obtener un miembro del cuerpo tecnico
     * con el DNI introducido
     */
    final String GETONE = "SELECT * FROM \"MiembroCuerpoTecnico\" WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para eliminar un miembro del cuerpo tecnico
     * con el DNI introducido
     */
    final String DELETEONE = "DELETE FROM \"MiembroCuerpoTecnico\" WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para actualizar el salario de un miembro del
     * cuerpo tecnico con el DNI introducido
     */
    final String UPDATESAL = "UPDATE \"MiembroCuerpoTecnico\" SET \"Salario\"= ? WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para obtener el DNI un miembro del cuerpo
     * tecnico con el DNI introducido
     */
    final String GETDNI = "SELECT \"DNI\" FROM \"MiembroCuerpoTecnico\" WHERE \"DNI\" = ";
    /**
     * Variable con la consulta SQL para obtener la contraseña un miembro del
     * cuerpo tecnico con el DNI introducido
     */
    final String GETCONTRASEÑA = "SELECT \"Password\" FROM \"MiembroCuerpoTecnico\" WHERE \"DNI\" = ";

    final String UPDATEFECHA = "UPDATE \"MiembroCuerpoTecnico\" SET \"FechaFinContrato\"= ? WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para obtener el id del equipo de un miembro
     * del cuerpo tecnico con el DNI introducido
     */
    final String GETIDEQUIPO = "select \"id_Equipo\" from \"MiembroCuerpoTecnico\" where \"DNI\" = ";
    /**
     * Variable con la consulta SQL para actualizar el e-mail de un miembro del
     * cuerpo tecnico con el DNI introducido
     */
    final String UPDATECORREO = "UPDATE \"MiembroCuerpoTecnico\" SET \"CorreoElectronico\"= ? WHERE \"DNI\" = ?";
    /**
     * Variable con la consulta SQL para obtener la contraseña de un miembro del
     * cuerpo tecnico con el DNI introducido
     */
    final String UPDATECONTRA = "UPDATE \"MiembroCuerpoTecnico\" SET \"Password\"= ? WHERE \"DNI\" = ?";
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
    public PostgreSQLMCuerpoTecnicoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(MiembroCuerpoTecnico t) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = this.conn.prepareStatement(INSERT);
            stat.setString(1, t.getDNI());
            stat.setString(2, t.getNombre());
            stat.setString(3, t.getApellidos());
            stat.setString(4, t.getPuesto());
            stat.setInt(5, t.getSalario());
            stat.setDate(6, new Date(t.getFinContrato().getTime()));
            stat.setString(7, t.getNacionalidad());
            stat.setString(8, t.getTacticaFavorita());
            stat.setInt(9, t.getIdEquipo());
            stat.setString(10, t.getCorreoElectronico());
            stat.setString(11, t.getPassword());
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
                throw new DAOException("Puede que el miembro del cuerpo tecnico no se haya borrado");

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
                throw new DAOException("Puede que el miembro CT no se haya actualizado");

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
                throw new DAOException("Puede que el miembro del cuerpo tecnico no se haya actualizado");

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
    private MiembroCuerpoTecnico convertir(ResultSet rs) throws SQLException {

        String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        String puesto = rs.getString("puesto");
        Date finContrato = rs.getDate("FechaFinContrato");
        String nacionalidad = rs.getString("nacionalidad");
        int salario = rs.getInt("salario");
        String tacticaFavorita = rs.getString("tacticaFavorita");
        Integer idEquipo = rs.getInt("id_Equipo");
        String correoElectronico = rs.getString("correoElectronico");
        String password = rs.getString("password");
        MiembroCuerpoTecnico mct = new MiembroCuerpoTecnico(nombre, apellidos, puesto, finContrato, nacionalidad, salario, tacticaFavorita, idEquipo, correoElectronico, password);

        mct.setDNI(rs.getString("DNI"));

        return mct;

    }

    @Override
    public List<MiembroCuerpoTecnico> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<MiembroCuerpoTecnico> miembros = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                miembros.add(convertir(rs));
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
        return miembros;
    }

    @Override
    public MiembroCuerpoTecnico obtener(String DNI) throws DAOException {

        PreparedStatement stat = null;
        ResultSet rs = null;
        MiembroCuerpoTecnico mct = null;

        try {
            stat = conn.prepareStatement(GETONE);
            stat.setString(1, DNI);
            rs = stat.executeQuery();
            if (rs.next()) {
                mct = convertir(rs);
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
        return mct;
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
