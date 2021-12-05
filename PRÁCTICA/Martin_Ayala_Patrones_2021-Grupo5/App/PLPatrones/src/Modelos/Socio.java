package Modelos;

/**
 * Modelo Socio Se usará para obtener registros de la tabla Socio de la BD
 *
 * @author Javier y Christian
 */
public class Socio {

    /**
     * Columna DNI
     */
    private String DNI = null;
    /**
     * Columna Nombre
     */
    private String nombre;
    /**
     * Columna Apellidos
     */
    private String apellidos;
    /**
     * Columna finContrato
     */
    /**
     * Columna idEquipo
     */
    private Integer idEquipo;
    /**
     * Columna correoElectronico
     */
    private String correoElectronico;
    /**
     * Columna password
     */
    private String password;

    /**
     * Constructor
     *
     * @param nombre
     * @param apellidos
     * @param correoElectronico
     * @param idEquipo
     * @param password
     */
    public Socio(String nombre, String apellidos, String correoElectronico, Integer idEquipo, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.idEquipo = idEquipo;
        this.password = password;
    }

    /**
     * getter de la variable DNI
     *
     * @return DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * setter de la variable DNI
     *
     * @param DNI
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * getter de la variable nombre
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * setter de la variable nombre
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * getter de la variable apellidos
     *
     * @return apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * setter de la variable apellidos
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * getter de la variable password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter de la variable password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getter de la variable idEquipo
     *
     * @return idEquipo
     */
    public Integer getIdEquipo() {
        return idEquipo;
    }

    /**
     * setter de la variable idEquipo
     *
     * @param idEquipo
     */
    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    /**
     * getter de la variable correoElectronico
     *
     * @return correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * setter de la variable correoElectronico
     *
     * @param correoElectronico
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * toString
     *
     * @return String con un resumen de los atributos
     */
    @Override
    public String toString() {
        return "Socio{" + "DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correoElectronico=" + correoElectronico + ", idEquipo=" + idEquipo + '}';
    }

}
