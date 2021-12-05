package Modelos;

import java.util.Date;

/**
 * Modelo Directiva Se usará para obtener registros de la tabla Directiva de la
 * BD
 *
 * @author Javier y Christian
 */
public class Directiva {

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
    private Date finContrato;
    /**
     * Columna nacionalidad
     */
    private String nacionalidad;
    /**
     * Columna puesto
     */
    private String puesto;
    /**
     * Columna salario
     */
    private int salario;
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
     * Contructor
     *
     * @param nombre
     * @param apellidos
     * @param finContrato
     * @param nacionalidad
     * @param puesto
     * @param salario
     * @param idEquipo
     * @param correoElectronico
     * @param password
     */
    public Directiva(String nombre, String apellidos, Date finContrato, String nacionalidad, String puesto, int salario, Integer idEquipo, String correoElectronico, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.finContrato = finContrato;
        this.nacionalidad = nacionalidad;
        this.puesto = puesto;
        this.salario = salario;
        this.idEquipo = idEquipo;
        this.correoElectronico = correoElectronico;
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
     * getter de la variable finContrato
     *
     * @return finContrato
     */
    public Date getFinContrato() {
        return finContrato;
    }

    /**
     * setter de la variable finContrato
     *
     * @param finContrato
     */
    public void setFinContrato(Date finContrato) {
        this.finContrato = finContrato;
    }

    /**
     * getter de la variable nacionalidad
     *
     * @return nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * setter de la variable nacionalidad
     *
     * @param nacionalidad
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * getter de la variable puesto
     *
     * @return puesto
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * setter de la variable puesto
     *
     * @param puesto
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * getter de la variable salario
     *
     * @return salario
     */
    public int getSalario() {
        return salario;
    }

    /**
     * setter de la variable salario
     *
     * @param salario
     */
    public void setSalario(int salario) {
        this.salario = salario;
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
        return "Directiva{" + "DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", finContrato=" + finContrato + ", nacionalidad=" + nacionalidad + ", puesto=" + puesto + ", salario=" + salario + ", idEquipo=" + idEquipo + ", correoElectronico=" + correoElectronico + '}';
    }

}
