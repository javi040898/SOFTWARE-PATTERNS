package Modelos;

/**
 * Modelo Equipo Se usará para obtener registros de la tabla Equipo de la BD
 *
 * @author Javier y Christian
 */
public class Equipo {

    /**
     * Columna id
     */
    private Integer id = null;
    /**
     * Columna nombre
     */
    private String nombre;
    /**
     * Columna ciudad
     */
    private String ciudad;
    /**
     * Columna pabellon
     */
    private String pabellon;
    /**
     * Columna patrocinador
     */
    private String patrocinador;
    /**
     * Columna equipacionLocal
     */
    private String equipacionLocal;
    /**
     * Columna equipacionVisitante
     */
    private String equipacionVisitante;
    /**
     * Columna id_Liga
     */
    private Integer id_Liga;
    /**
     * Columna puntos
     */
    private Integer puntos;

    /**
     * Constructor
     *
     * @param nombre
     * @param ciudad
     * @param pabellon
     * @param patrocinador
     * @param equipacionLocal
     * @param equipacionVisitante
     * @param id_Liga
     * @param puntos
     */
    public Equipo(String nombre, String ciudad, String pabellon, String patrocinador, String equipacionLocal, String equipacionVisitante, Integer id_Liga, Integer puntos) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pabellon = pabellon;
        this.patrocinador = patrocinador;
        this.equipacionLocal = equipacionLocal;
        this.equipacionVisitante = equipacionVisitante;
        this.id_Liga = id_Liga;
        this.puntos = puntos;
    }

    /**
     * getter de la variable id
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * setter de la variable id
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * getter de la variable puntos
     *
     * @return puntos
     */
    public Integer getPuntos() {
        return puntos;
    }

    /**
     * setter de la variable puntos
     *
     * @param puntos
     */
    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    /**
     * getter de la variable ciudad
     *
     * @return ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * setter de la variable ciudad
     *
     * @param ciudad
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * getter de la variable pabellon
     *
     * @return pabellon
     */
    public String getPabellon() {
        return pabellon;
    }

    /**
     * setter de la variable pabellon
     *
     * @param pabellon
     */
    public void setPabellon(String pabellon) {
        this.pabellon = pabellon;
    }

    /**
     * getter de la variable patrocinador
     *
     * @return patrocinador
     */
    public String getPatrocinador() {
        return patrocinador;
    }

    /**
     * setter de la variable patrocinador
     *
     * @param patrocinador
     */
    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    /**
     * getter de la variable equipacionLocal
     *
     * @return equipacionLocal
     */
    public String getEquipacionLocal() {
        return equipacionLocal;
    }

    /**
     * setter de la variable equipacionLocal
     *
     * @param equipacionLocal
     */
    public void setEquipacionLocal(String equipacionLocal) {
        this.equipacionLocal = equipacionLocal;
    }

    /**
     * getter de la variable equipacionVisitante
     *
     * @return equipacionVisitante
     */
    public String getEquipacionVisitante() {
        return equipacionVisitante;
    }

    /**
     * setter de la variable equipacionVisitante
     *
     * @param equipacionVisitante
     */
    public void setEquipacionVisitante(String equipacionVisitante) {
        this.equipacionVisitante = equipacionVisitante;
    }

    /**
     * getter de la variable id_Liga
     *
     * @return id_Liga
     */
    public Integer getId_Liga() {
        return id_Liga;
    }

    /**
     * setter de la variable id_Liga
     *
     * @param id_Liga
     */
    public void setId_Liga(Integer id_Liga) {
        this.id_Liga = id_Liga;
    }

    /**
     * toString
     *
     * @return String con un resumen de los atributos
     */
    @Override
    public String toString() {
        return "Equipo{" + "id=" + id + ", nombre=" + nombre + ", ciudad=" + ciudad + ", pabellon=" + pabellon + ", patrocinador=" + patrocinador + ", equipacionLocal=" + equipacionLocal + ", equipacionVisitante=" + equipacionVisitante + ", id_Liga=" + id_Liga + '}';
    }

}
