package DAO;

/**
 * Excepcion en los métodos DAO
 *
 * @author Javier
 */
public class DAOException extends Exception {

    /**
     * Excepcion DAO
     *
     * @param string
     */
    public DAOException(String string) {
        super(string);
    }

    /**
     * Excepcion DAO
     *
     * @param string
     * @param thrwbl
     */
    public DAOException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    /**
     * Excepcion DAO
     *
     * @param thrwbl
     */
    public DAOException(Throwable thrwbl) {
        super(thrwbl);
    }

}
