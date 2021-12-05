
package Interfaces;

import Fachada.FachadaIntegrante;
import DAO.DAOException;
import DAO.DirectivaDAO;
import SQL.PostgreSQLDirectivaDAO;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Correo.Correo;
import Singleton.SingletonBBDD;

/**
 * Clase para que los usuario tipo directiva puedan acceder a sus funciones
 *
 * @author Javier y Christian
 */
public class InterfazDirectiva extends javax.swing.JFrame {

    
    /**
     * DNI del usuario que esta visitando la interfaz
     */
    private final String DNI;
    /**
     * id del equipo del usuario que esta visitando la interfaz
     */
    private final String id_equipo;
    /**
     * Constructor
     * @param id_equipo
     * @param DNI 
     */
    public InterfazDirectiva(String id_equipo, String DNI) {
        this.id_equipo = id_equipo;
        this.DNI = DNI;
        initComponents();
        
        if("1".equals(id_equipo)){
            setIconImage(new ImageIcon(getClass().getResource("/imagen/lakers.jpg")).getImage());
        }
        if("2".equals(id_equipo)){
            setIconImage(new ImageIcon(getClass().getResource("/imagen/clippers.jpg")).getImage());
        }
        if("3".equals(id_equipo)){
            setIconImage(new ImageIcon(getClass().getResource("/imagen/nets.jpg")).getImage());
        }
        if("4".equals(id_equipo)){
            setIconImage(new ImageIcon(getClass().getResource("/imagen/bucks.jpg")).getImage());
        }
        if("5".equals(id_equipo)){
            setIconImage(new ImageIcon(getClass().getResource("/imagen/celtics.jpg")).getImage());
        }
        if("6".equals(id_equipo)){
            setIconImage(new ImageIcon(getClass().getResource("/imagen/bulls.jpg")).getImage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RenovacionButton = new javax.swing.JButton();
        IPButton = new javax.swing.JButton();
        contratoButton = new javax.swing.JButton();
        PlantillaButton = new javax.swing.JButton();
        ModificarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        LideresButton = new javax.swing.JButton();
        ClasificacionButton = new javax.swing.JButton();
        CerrarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        RenovacionButton.setText("Solicitar renovación");
        RenovacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RenovacionButtonActionPerformed(evt);
            }
        });

        IPButton.setText("Alta/Baja/Modificación Integrante Plantilla");
        IPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IPButtonActionPerformed(evt);
            }
        });

        contratoButton.setText("Renuncia Contrato");
        contratoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contratoButtonActionPerformed(evt);
            }
        });

        PlantillaButton.setText("Consultar plantilla");
        PlantillaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlantillaButtonActionPerformed(evt);
            }
        });

        ModificarButton.setText("Modificar mis datos personales");
        ModificarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("           DIRECTIVO");

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

        CerrarButton.setText("Cerrar Sesión");
        CerrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(CerrarButton)
                .addGap(191, 191, 191)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ModificarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RenovacionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contratoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IPButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PlantillaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LideresButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ClasificacionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(325, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(44, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(CerrarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(PlantillaButton)
                .addGap(18, 18, 18)
                .addComponent(ModificarButton)
                .addGap(18, 18, 18)
                .addComponent(RenovacionButton)
                .addGap(18, 18, 18)
                .addComponent(contratoButton)
                .addGap(18, 18, 18)
                .addComponent(IPButton)
                .addGap(18, 18, 18)
                .addComponent(LideresButton)
                .addGap(18, 18, 18)
                .addComponent(ClasificacionButton)
                .addGap(138, 138, 138))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Boton para solicitar renovacion
     * @param evt 
     */
    private void RenovacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RenovacionButtonActionPerformed
       Correo cor= new Correo(DNI);
       cor.renovacion();
        JOptionPane.showMessageDialog(null,"Solicitud de renovación solicitada correctamente");
    }//GEN-LAST:event_RenovacionButtonActionPerformed
    /**
     * Boton para solicitar renuncia de contrato
     * @param evt 
     */
    private void contratoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contratoButtonActionPerformed
        SingletonBBDD singleton;
        try {
            singleton = SingletonBBDD.getInstancia();
            DirectivaDAO daoD = new PostgreSQLDirectivaDAO(singleton.connect());
            Correo cor= new Correo(DNI);
            cor.renuncia();
            JOptionPane.showMessageDialog(null,"Solicitud de renuncia de contrato solicitada correctamente del DNI " + daoD.obtenerDNI("\'"+DNI+"\'"));
        } catch (SQLException | DAOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }//GEN-LAST:event_contratoButtonActionPerformed
    /**
     * Boton para acceder a la interfaz de consulta de plantillas
     * @param evt 
     */
    private void PlantillaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlantillaButtonActionPerformed
        ConsultaPlantillas cp = new ConsultaPlantillas("Directiva", DNI, Integer.parseInt(id_equipo));
        this.setVisible(false);
        cp.setVisible(true);
    }//GEN-LAST:event_PlantillaButtonActionPerformed
    /**
     * Boton para acceder a la interfaz de modificar datos
     * @param evt 
     */
    private void ModificarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarButtonActionPerformed
        ModificarDatos mb = new ModificarDatos("Directiva", DNI,Integer.parseInt(id_equipo));
        this.setVisible(false);
        mb.setVisible(true);
    }//GEN-LAST:event_ModificarButtonActionPerformed
    /**
     * Boton para acceder a la fachada
     * @param evt 
     */
    private void IPButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IPButtonActionPerformed
        FachadaIntegrante ai = new FachadaIntegrante(Integer.parseInt(id_equipo), DNI);
        this.setVisible(false);
        ai.setVisible(true);
    }//GEN-LAST:event_IPButtonActionPerformed
    /**
     * Boton para acceder a la interfaz de los lideres de la liga
     * @param evt 
     */
    private void LideresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LideresButtonActionPerformed
        LideresLiga ll = new LideresLiga("Directiva", DNI, Integer.parseInt(id_equipo));
        this.setVisible(false);
        ll.setVisible(true);
    }//GEN-LAST:event_LideresButtonActionPerformed
    /**
     * Boton para acceder a la interfaz de la clasificación
     * @param evt 
     */
    private void ClasificacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClasificacionButtonActionPerformed
        Clasificacion ll = new Clasificacion("Directiva", DNI, Integer.parseInt(id_equipo));
        this.setVisible(false);
        ll.setVisible(true);
    }//GEN-LAST:event_ClasificacionButtonActionPerformed
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
            java.util.logging.Logger.getLogger(InterfazDirectiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazDirectiva("", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CerrarButton;
    private javax.swing.JButton ClasificacionButton;
    private javax.swing.JButton IPButton;
    private javax.swing.JButton LideresButton;
    private javax.swing.JButton ModificarButton;
    private javax.swing.JButton PlantillaButton;
    private javax.swing.JButton RenovacionButton;
    private javax.swing.JButton contratoButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
