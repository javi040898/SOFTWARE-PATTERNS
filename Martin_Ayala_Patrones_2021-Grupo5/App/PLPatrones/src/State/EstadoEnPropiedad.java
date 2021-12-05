package State;

import javax.swing.JOptionPane;
import Correo.Correo;

/**
 * Estado concreto: Implementa la interfaz Estado. Implementa el comportamiento
 * específico de un estado.
 *
 * @author Javier y Christian
 */
public class EstadoEnPropiedad implements Estado {
    /**
     * DNI del jugador
     */
    private final String DNI;
    /**
     * Constructor
     * @param DNI 
     */
    public EstadoEnPropiedad(String DNI) {
        this.DNI = DNI;
    }
    
    @Override
    public void ejecutarEstado() {
        Correo cor=new Correo(DNI);
        cor.renovacion();
        JOptionPane.showMessageDialog(null,"Renovacion solicitada correctamente");
        
    }
}
