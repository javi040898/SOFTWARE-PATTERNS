
package Fachada;


import javax.swing.ImageIcon;
import Interfaces.InterfazDirectiva;

/**
 * Clase que servirá como interfaz para dar de alta, baja y modificar datos de
 * jugadores y miembros del CT
 *
 * @author Javier y Chrsitian
 */
public class FachadaIntegrante extends javax.swing.JFrame {

    /**
     * Entero que representa el id de cada equipo
     */
    private final int id_equipo;
    /**
     * String que representa el dni de cada persona
     */
    private final String DNI;
    /**
     * Variable de tipo AltaMiembroCT
     */
    AltaMiembroCT amc;
    /**
     * Variable de tipo AltaJugador
     */
    AltaJugador aj;
    /**
     * Variable de tipo BajaJugador
     */
    BajaJugador bj;
    /**
     * /**
     * Variable de tipo ModificarJugador
     */
    ModificarJugador mj;
    /**
     * Variable de tipo BajaMiembroCT
     */
    BajaMiembroCT bmc;
    /**
     * Variable de tipo ModificarMiembroCT
     */
    ModificarMiembroCT mmc;

    /**
     * Constructor en el cual dependiendo de que equipo sea la persona que
     * interactúa con la interfaz, muestra un icono u otro. Instanciacion de los
     * distintos dipos de objetos, que serán las interfaces de dar de alta, baja
     * y modificacion de jugadores y miembros del CT
     *
     * @param id_equipo id de cada equipo
     * @param DNI dni de las personas
     */
    public FachadaIntegrante(int id_equipo, String DNI) {
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
        amc = new AltaMiembroCT(id_equipo, DNI);
        aj = new AltaJugador(id_equipo, DNI);
        bj = new BajaJugador(id_equipo, DNI);
        mj = new ModificarJugador(id_equipo, DNI);
        bmc = new BajaMiembroCT(id_equipo, DNI);
        mmc = new ModificarMiembroCT(id_equipo, DNI);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AltaMButton = new javax.swing.JButton();
        BajaMButton = new javax.swing.JButton();
        ModificarMButton = new javax.swing.JButton();
        AltaJButton = new javax.swing.JButton();
        BajaJButton = new javax.swing.JButton();
        ModificarJButton = new javax.swing.JButton();
        VolverButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AltaMButton.setText("Alta Miembro CT");
        AltaMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltaMButtonActionPerformed(evt);
            }
        });

        BajaMButton.setText("Baja Miembro CT");
        BajaMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BajaMButtonActionPerformed(evt);
            }
        });

        ModificarMButton.setText("Modificar Miembro CT");
        ModificarMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarMButtonActionPerformed(evt);
            }
        });

        AltaJButton.setText("Alta jugador");
        AltaJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltaJButtonActionPerformed(evt);
            }
        });

        BajaJButton.setText("Baja jugador");
        BajaJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BajaJButtonActionPerformed(evt);
            }
        });

        ModificarJButton.setText("Modificar jugador");
        ModificarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarJButtonActionPerformed(evt);
            }
        });

        VolverButton.setText("Volver");
        VolverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VolverButton)
                .addContainerGap(327, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(110, 110, 110)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(AltaJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BajaJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ModificarJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AltaMButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BajaMButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ModificarMButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(155, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(VolverButton)
                .addContainerGap(248, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(AltaJButton)
                    .addGap(18, 18, 18)
                    .addComponent(BajaJButton)
                    .addGap(18, 18, 18)
                    .addComponent(ModificarJButton)
                    .addGap(13, 13, 13)
                    .addComponent(AltaMButton)
                    .addGap(18, 18, 18)
                    .addComponent(BajaMButton)
                    .addGap(18, 18, 18)
                    .addComponent(ModificarMButton)
                    .addContainerGap(39, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Tras pulsar este botón, la ventana actual se cierrra y se da paso a la
     * ventana para dar de alta a un miembro del CT
     *
     * @param evt A semantic event which indicates that a component-defined
     * action occurred
     */
    private void AltaMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltaMButtonActionPerformed
        this.setVisible(false);
        amc.setVisible(true);
    }//GEN-LAST:event_AltaMButtonActionPerformed
    /**
     * Tras pulsar este botón, la ventana actual se cierrra y se da paso a la
     * ventana para dar de alta a un jugador
     *
     * @param evt A semantic event which indicates that a component-defined
     * action occurred
     */
    private void AltaJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltaJButtonActionPerformed
        this.setVisible(false);
        aj.setVisible(true);


    }//GEN-LAST:event_AltaJButtonActionPerformed
    /**
     * Tras pulsar este botón, la ventana actual se cierrra y se da paso a la
     * ventana para dar de baja a un jugador
     *
     * @param evt A semantic event which indicates that a component-defined
     * action occurred
     */
    private void BajaJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BajaJButtonActionPerformed
        this.setVisible(false);
        bj.setVisible(true);

    }//GEN-LAST:event_BajaJButtonActionPerformed
    /**
     * Tras pulsar este botón, la ventana actual se cierrra y se da paso a la
     * ventana para modificar los datos de un jugador
     *
     * @param evt A semantic event which indicates that a component-defined
     * action occurred
     */
    private void ModificarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarJButtonActionPerformed
        this.setVisible(false);
        mj.setVisible(true);

    }//GEN-LAST:event_ModificarJButtonActionPerformed
    /**
     * Tras pulsar este botón, la ventana actual se cierrra y se da paso a la
     * ventana para dar de baja a un miembro del CT
     *
     * @param evt A semantic event which indicates that a component-defined
     * action occurred
     */
    private void BajaMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BajaMButtonActionPerformed
        this.setVisible(false);
        bmc.setVisible(true);

    }//GEN-LAST:event_BajaMButtonActionPerformed
    /**
     * Tras pulsar este botón, la ventana actual se cierrra y se da paso a la
     * ventana para modificar los datos de un miembro del CT
     *
     * @param evt A semantic event which indicates that a component-defined
     * action occurred
     */
    private void ModificarMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarMButtonActionPerformed
        this.setVisible(false);
        mmc.setVisible(true);

    }//GEN-LAST:event_ModificarMButtonActionPerformed
    /**
     * Boton para volver a la interfaz anterior
     *
     * @param evt
     */
    private void VolverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverButtonActionPerformed
        InterfazDirectiva de = new InterfazDirectiva(Integer.toString(id_equipo), DNI);
        this.setVisible(false);
        de.setVisible(true);
    }//GEN-LAST:event_VolverButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FachadaIntegrante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FachadaIntegrante(0, "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AltaJButton;
    private javax.swing.JButton AltaMButton;
    private javax.swing.JButton BajaJButton;
    private javax.swing.JButton BajaMButton;
    private javax.swing.JButton ModificarJButton;
    private javax.swing.JButton ModificarMButton;
    private javax.swing.JButton VolverButton;
    // End of variables declaration//GEN-END:variables
}
