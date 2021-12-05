package Modelos;

import java.util.Date;

/**
 * Modelo Jugador Se usará para obtener registros de la tabla Jugador de la BD
 *
 * @author Javier y Christian
 */
public class Jugador {

    /**
     * Columna DNI
     */
    private String DNI = null;
    /**
     * Columna dorsal
     */
    private int dorsal;
    /**
     * Columna Nombre
     */
    private String nombre;
    /**
     * Columna Apellidos
     */
    private String apellidos;
    /**
     * Columna mediaPuntos
     */
    private int mediaPuntos;
    /**
     * Columna mediaRebotes
     */
    private int mediaRebotes;
    /**
     * Columna mediaAsistencias
     */
    private int mediaAsistencias;
    /**
     * Columna finContrato
     */
    private Date finContrato;
    /**
     * Columna nacionalidad
     */
    private String nacionalidad;
    /**
     * Columna posicion
     */
    private String posicion;
    /**
     * Columna salario
     */
    private int salario;
    /**
     * Columna estado
     */
    private String estado;
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
     * Jugador
     *
     * @param dorsal
     * @param nombre
     * @param apellidos
     * @param mediaPuntos
     * @param mediaRebotes
     * @param mediaAsistencias
     * @param finContrato
     * @param nacionalidad
     * @param posicion
     * @param salario
     * @param estado
     * @param idEquipo
     * @param correoElectronico
     * @param password
     */
    public Jugador(int dorsal, String nombre, String apellidos, int mediaPuntos, int mediaRebotes, int mediaAsistencias, Date finContrato, String nacionalidad, String posicion, int salario, String estado, Integer idEquipo, String correoElectronico, String password) {
        this.dorsal = dorsal;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.mediaPuntos = mediaPuntos;
        this.mediaRebotes = mediaRebotes;
        this.mediaAsistencias = mediaAsistencias;
        this.finContrato = finContrato;
        this.nacionalidad = nacionalidad;
        this.posicion = posicion;
        this.salario = salario;
        this.estado = estado;
        this.idEquipo = idEquipo;
        this.correoElectronico = correoElectronico;
        this.password = password;
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
     * getter de la variable dorsal
     *
     * @return dorsal
     */
    public int getDorsal() {
        return dorsal;
    }

    /**
     * setter de la variable dorsal
     *
     * @param dorsal
     */
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
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
     * getter de la variable mediaPuntos
     *
     * @return mediaPuntos
     */
    public int getMediaPuntos() {
        return mediaPuntos;
    }

    /**
     * setter de la variable mediaPuntos
     *
     * @param mediaPuntos
     */
    public void setMediaPuntos(int mediaPuntos) {
        this.mediaPuntos = mediaPuntos;
    }

    /**
     * getter de la variable mediaRebotes
     *
     * @return mediaRebotes
     */
    public int getMediaRebotes() {
        return mediaRebotes;
    }

    /**
     * setter de la variable mediaRebotes
     *
     * @param mediaRebotes
     */
    public void setMediaRebotes(int mediaRebotes) {
        this.mediaRebotes = mediaRebotes;
    }

    /**
     * getter de la variable mediaAsistencias
     *
     * @return mediaAsistencias
     */
    public int getMediaAsistencias() {
        return mediaAsistencias;
    }

    /**
     * setter de la variable mediaAsistencias
     *
     * @param mediaAsistencias
     */
    public void setMediaAsistencias(int mediaAsistencias) {
        this.mediaAsistencias = mediaAsistencias;
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
     * getter de la variable posicion
     *
     * @return posicion
     */
    public String getPosicion() {
        return posicion;
    }

    /**
     * setter de la variable posicion
     *
     * @param posicion
     */
    public void setPosicion(String posicion) {
        this.posicion = posicion;
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
     * getter de la variable estado
     *
     * @return estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * setter de la variable estado
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
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
        return "Jugador{" + "DNI=" + DNI + ", dorsal=" + dorsal + ", nombre=" + nombre + ", apellidos=" + apellidos + ", mediaPuntos=" + mediaPuntos + ", mediaRebotes=" + mediaRebotes + ", mediaAsistencias=" + mediaAsistencias + ", finContrato=" + finContrato + ", nacionalidad=" + nacionalidad + ", posicion=" + posicion + ", salario=" + salario + ", estado=" + estado + ", idEquipo=" + idEquipo + ", correoElectronico=" + correoElectronico + "contraseña" + password + '}';
    }

    public String salidaJugador() {
        return dorsal + " " + nombre + " " + apellidos + " " + mediaPuntos + " " + mediaRebotes + " " + mediaAsistencias + " " + finContrato + " " + nacionalidad + " " + posicion + " " + salario + " " + estado;
    }

}
