package Adapter;

import java.util.Date;
import java.util.StringTokenizer;

/**
 * Clase para adaptar las fechas a formato español
 * @author Javier y Christian
 */
public class AdapterFecha implements Fecha {
    /**
     * Fecha en formato USA que se va a adaptar.
     */
    private final Date fus;
    
    /**
     * Constructor
     *
     * @param fus Fecha en formato USA.
     */
    public AdapterFecha(Date fus) {
        this.fus = fus;
    }
    
    @Override
    public String toString() {
        StringTokenizer st = new StringTokenizer(fus.toString(), "-");
        String aaaa = st.nextToken();
        String mm = st.nextToken();
        String dd = st.nextToken();

        return dd + "/" + mm + "/" + aaaa;
    }
    
    @Override
    public int getAño() {
        return this.fus.getYear();
    }

    
    @Override
    public int getDia() {
        return this.fus.getDay();
    }
    
    @Override
    public int getMes() {
        return this.fus.getMonth();
    }

    
    
    
    
}
