
package DAO;

import java.util.List;

/**
 * Interfaz donde se definan las funciones comunes de la BD
 * @author Javier y Christian
 * @param <T>
 * @param <K> 
 */
public interface DAO<T,K> {
    /**
     * Método para insertar un registro en la BD a partir de una instancia de los modelos
     * @param t
     * @throws DAOException 
     */
    void insertar(T t) throws DAOException;
    
    /**
     * Método para eliminar un registro de la BD
     * @param t
     * @throws DAOException 
     */
    void eliminar(String t) throws DAOException;
    
    /**
     * Método para actualizar el salario de un registro
     *
     * @param t
     * @param ID
     * @throws DAOException
     */
    void modificar(Integer t, String ID) throws DAOException;
    
    /**
     * Método que devuelve una lista con todos los registros de la tabla
     * @return Lista con todos los registros de la tabla
     * @throws DAOException 
     */
    List<T> obtenerTodos() throws DAOException;
    
    
    /**
     * Método que devuelve un registro a partir de su DNI/ID
     * @param id
     * @return Objeto
     * @throws DAOException 
     */
    T obtener(K id) throws DAOException;
    
    /**
     * Método para modificar el e-mail
     * @param i
     * @param DNI
     * @throws DAOException 
     */
    void modificarCorreo(String i, String DNI) throws DAOException;
    /**
     * Método para modificar la contrseña
     * @param i
     * @param DNI
     * @throws DAOException 
     */
    void modificarContraseña(String i, String DNI) throws DAOException;
    
    
    
    
}
