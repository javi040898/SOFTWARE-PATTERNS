package Fachada;

import DAO.DAOException;
import DAO.JugadorDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import FactoryMethod.FactoriaIntegrantes;
import FactoryMethod.IntegrantePlantilla;

/**
 * Clase para que el directivo pueda dar de baja un jugador
 *
 * @author Javier y Christian
 */
public class BajaJugador extends javax.swing.JFrame {

    /**
     * Variable para saber el equipo al que pertenece el usuario registrado
     */
    private final int id_equipo;
    /**
     * DNI del usuario registrado
     */
    private final String DNI;

    /**
     * Constructor
     *
     * @param id_equipo
     * @param DNI
     */
    public BajaJugador(int id_equipo, String DNI) {
        this.id_equipo = id_equipo;
        this.DNI = DNI;
        initComponents();
        if (id_equipo == 1) {
            setIconImage(new ImageIcon(getClass().getResource("/imagen/lakers.jpg")).getImage());
        }
        if (id_equipo == 2) {
            setIconImage(new ImageIcon(getClass().getResource("/imagen/clippers.jpg")).getImage());
        }
        if (id_equipo == 3) {
            setIconImage(new ImageIcon(getClass().getResource("/imagen/nets.jpg")).getImage());
        }
        if (id_equipo == 4) {
            setIconImage(new ImageIcon(getClass().getResource("/imagen/bucks.jpg")).getImage());
        }
        if (id_equipo == 5) {
            setIconImage(new ImageIcon(getClass().getResource("/imagen/celtics.jpg")).getImage());
        }
        if (id_equipo == 6) {
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
        BorrarTxt = new javax.swing.JTextField();
        AceptarButton = new javax.swing.JButton();
        VolverButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Introduzca el DNI del jugador que desea dar de baja");

        AceptarButton.setText("Aceptar");
        AceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarButtonActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BorrarTxt)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(AceptarButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(VolverButton)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VolverButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(BorrarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(AceptarButton)
                .addContainerGap(159, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Botón para ejecutar la baja del jugador
     *
     * @param evt
     */
    private void AceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarButtonActionPerformed
        boolean borradoCorrectamente = false;

        FactoriaIntegrantes factoria = new FactoriaIntegrantes();
        IntegrantePlantilla integrante = factoria.getIntegrantePlantilla(0);
        JugadorDAO dao = (JugadorDAO) integrante.crearIntegrantePostgreSQL();

        try {
            if (dao.obtenerNumeroJugadores(id_equipo) == 11) {
                JOptionPane.showMessageDialog(null, "No se puede eliminar a ningun jugador al estar su plantilla con el numero minimo de jugadores (11)");
            } else {
                if (id_equipo == dao.obtenerIDEquipo("\'" + BorrarTxt.getText() + "\'")) {

                    dao.eliminar(BorrarTxt.getText());
                    JOptionPane.showMessageDialog(null, "Jugador eliminado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Este DNI no pertenece a su equipo");
                }
            }

        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al dar de baja");
        }
    }//GEN-LAST:event_AceptarButtonActionPerformed
    /**
     * Boton para volver a la interfaz anterior
     *
     * @param evt
     */
    private void VolverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverButtonActionPerformed
        FachadaIntegrante de = new FachadaIntegrante(id_equipo, DNI);
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
            java.util.logging.Logger.getLogger(BajaJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BajaJugador(0, "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarButton;
    private javax.swing.JTextField BorrarTxt;
    private javax.swing.JButton VolverButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}