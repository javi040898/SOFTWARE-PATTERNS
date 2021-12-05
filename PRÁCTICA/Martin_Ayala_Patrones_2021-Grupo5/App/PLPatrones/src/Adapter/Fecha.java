
package Adapter;

/**
 * 
 * @author Javier y Christian
 */
public interface Fecha {
    /**
     * Devuelve un String con la fecha en formato de España (DD/MM/AAAA).
     *
     * @return Fecha en formato de España (DD/MM/AAAA)
     */
    @Override
    public String toString();

    /**
     * Devuelve el año.
     *
     * @return int que representa el año.
     */
    public int getAño();

    /**
     * Devuelve el dia
     * @return int que representa el dia
     */
    
    public int getDia();

    /**
     * Devuelve el mes
     * @return int que representa el mes
     */

    public int getMes();

    
   
}
