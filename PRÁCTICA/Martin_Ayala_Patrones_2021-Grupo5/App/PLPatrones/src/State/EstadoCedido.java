package State;


import javax.swing.JOptionPane;

/**
 * Estado concreto: Implementa la interfaz Estado. Implementa el comportamiento
 * específico de un estado.
 *
 * @author Javier y Christian
 */
public class EstadoCedido implements Estado{

    @Override
    public void ejecutarEstado() {
        JOptionPane.showMessageDialog(null,"No puedes renovar al estar cedido");
        
    }

}