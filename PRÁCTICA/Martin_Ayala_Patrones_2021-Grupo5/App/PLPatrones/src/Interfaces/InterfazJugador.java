
package Interfaces;

import DAO.DAOException;
import DAO.JugadorDAO;
import SQL.PostgreSQLJugadorDAO;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Correo.Correo;
import State.JugadorEstado;
import Singleton.SingletonBBDD;

/**
 * Clase para que los usuarios tipo jugador puedan acceder a sus funciones
 *
 * @author Javier y Christian
 */
public class InterfazJugador extends javax.swing.JFrame {

    /**
     * DNI del usuario que esta visitando la interfaz
     */
    private final String DNI;
    /**
     * id del equipo del usuario que esta visitando la interfaz
     */
    private final int id_equipo;
    /**
     * Constructor
     * @param DNI
     * @param id_equipo 
     */
    public InterfazJugador(String DNI,int id_equipo){
        this.id_equipo = id_equipo;
        this.DNI = DNI;
        initComponents();
        if(id_equipo == 1){
            setIconImage(new ImageIcon(getClass().getResource("/imagen/lakers.jpg")).getImage());
        }
        if(id_equipo == 2){
            setIconImage(new ImageIcon(getClass().getResource("/imagen/clippers.jpg")).getImage());
        }
        if(id_equipo == 3){
            setIconImage(new ImageIcon(getClass().getResource("/imagen/nets.jpg")).getImage());
        }
        if(id_equipo == 4){
            setIconImage(new ImageIcon(getClass().getResource("/imagen/bucks.jpg")).getImage());
        }
        if(id_equipo == 5){
            setIconImage(new ImageIcon(getClass().getResource("/imagen/celtics.jpg")).getImage());
        }
        if(id_equipo == 6){
            setIconImage(new ImageIcon(getClass().getResource("/imagen/bulls.jpg")).getImage());
        }
        
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        PlantillaButton = new javax.swing.JButton();
        RenovacionButton = new javax.swing.JButton();
        LideresButton = new javax.swing.JButton();
        ClasificacionButton = new javax.swing.JButton();
        ModificarButton = new javax.swing.JButton();
        CerrarButton = new javax.swing.JButton();
        contratoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("            JUGADOR");

        PlantillaButton.setText("Consultar plantilla");
        PlantillaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlantillaButtonActionPerformed(evt);
            }
        });

        RenovacionButton.setText("Solicitar renovación");
        RenovacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RenovacionButtonActionPerformed(evt);
            }
        });

        LideresButton.setText("Ver líderes de la liga");
        LideresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LideresButtonActionPerformed(evt);
            }
        });

        ClasificacionButton.setText("Ver clasificación");
        ClasificacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClasificacionButtonActionPerformed(evt);
            }
        });

        ModificarButton.setText("Modificar mis datos personales");
        ModificarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarButtonActionPerformed(evt);
            }
        });

        CerrarButton.setText("Cerrar Sesión");
        CerrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarButtonActionPerformed(evt);
            }
        });

        contratoButton.setText("Renuncia Contrato");
        contratoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contratoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(CerrarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PlantillaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addComponent(RenovacionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ClasificacionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LideresButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ModificarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contratoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CerrarButton))
                .addGap(32, 32, 32)
                .addComponent(PlantillaButton)
                .addGap(18, 18, 18)
                .addComponent(ModificarButton)
                .addGap(18, 18, 18)
                .addComponent(RenovacionButton)
                .addGap(18, 18, 18)
                .addComponent(contratoButton)
                .addGap(18, 18, 18)
                .addComponent(LideresButton)
                .addGap(18, 18, 18)
                .addComponent(ClasificacionButton)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Boton para acceder a la interfaz de consulta de plantillas
     * @param evt 
     */
    private void PlantillaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlantillaButtonActionPerformed
        ConsultaPlantillas cp = new ConsultaPlantillas("Jugador",DNI,id_equipo);
        this.setVisible(false);
        cp.setVisible(true);
    }//GEN-LAST:event_PlantillaButtonActionPerformed
    /**
     * Boton para solicitar renovacion
     * @param evt 
     */
    private void RenovacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RenovacionButtonActionPerformed
       JugadorEstado je = new JugadorEstado();
        try {
            je.limitarAccion(DNI);
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_RenovacionButtonActionPerformed
    /**
     * Boton para acceder a la interfaz de los lideres de la liga
     * @param evt 
     */
    private void LideresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LideresButtonActionPerformed
        LideresLiga ll = new LideresLiga("Jugador",DNI,id_equipo);
        this.setVisible(false);
        ll.setVisible(true);
    }//GEN-LAST:event_LideresButtonActionPerformed
    /**
     * Boton para acceder a la interfaz de la clasificación
     * @param evt 
     */
    private void ClasificacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClasificacionButtonActionPerformed
        Clasificacion ll = new Clasificacion("Jugador",DNI,id_equipo);
        this.setVisible(false);
        ll.setVisible(true);
    }//GEN-LAST:event_ClasificacionButtonActionPerformed
    /**
     * Boton para acceder a la interfaz de modificar datos
     * @param evt 
     */
    private void ModificarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarButtonActionPerformed
        ModificarDatos mb = new ModificarDatos("Jugador",DNI,id_equipo);
        this.setVisible(false);
        mb.setVisible(true);
    }//GEN-LAST:event_ModificarButtonActionPerformed
    /**
     * Boton para cerrar sesión
     * @param evt 
     */
    private void CerrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarButtonActionPerformed
        Login l;
        try {
            l = new Login();
            this.setVisible(false);
            l.setVisible(true);
        } catch (SQLException | DAOException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_CerrarButtonActionPerformed
    /**
     * Boton para solicitar renuncia de contrato
     * @param evt 
     */
    private void contratoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contratoButtonActionPerformed
        SingletonBBDD singleton;
        Correo cor= new Correo(DNI);
        try {
            singleton = SingletonBBDD.getInstancia();
            JugadorDAO dao = new PostgreSQLJugadorDAO(singleton.connect());
            cor.renuncia();
            JOptionPane.showMessageDialog(null,"Solicitud de renuncia de contrato solicitada correctamente del DNI " + dao.obtenerDNI("\'"+DNI+"\'"));
            
        } catch (SQLException | DAOException ex) {
            System.out.println(ex.getMessage());
        }

    }//GEN-LAST:event_contratoButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                new InterfazJugador("",0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CerrarButton;
    private javax.swing.JButton ClasificacionButton;
    private javax.swing.JButton LideresButton;
    private javax.swing.JButton ModificarButton;
    private javax.swing.JButton PlantillaButton;
    private javax.swing.JButton RenovacionButton;
    private javax.swing.JButton contratoButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
