package Interfaces;

import DAO.DAOException;
import DAO.EquipoDAO;
import DAO.SocioDAO;
import Modelos.Socio;
import SQL.PostgreSQLEquipoDAO;
import SQL.PostgreSQLSocioDAO;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Singleton.SingletonBBDD;

/**
 * Clase para que puedas darte de alta como socio
 *
 * @author Javier y Christian
 */
public class RegistroSocio extends javax.swing.JFrame {

    /**
     * Constructor
     */
    public RegistroSocio() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagen/basket.jpg")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jTextField6 = new javax.swing.JTextField();
        DNITextField = new javax.swing.JTextField();
        nombreTextField = new javax.swing.JTextField();
        apellidosTextField = new javax.swing.JTextField();
        mailTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        contraTextField = new javax.swing.JPasswordField();
        AbonarseButton = new javax.swing.JButton();
        equipoCombo = new javax.swing.JComboBox<>();
        CerrarButton = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jTextField6.setText("jTextField6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DNITextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DNITextFieldActionPerformed(evt);
            }
        });

        apellidosTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidosTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("DNI");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellidos");

        jLabel4.setText("E-mail");

        jLabel5.setText("Equipo");

        jLabel7.setText("Contraseña");

        AbonarseButton.setText("Abonarse al club");
        AbonarseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbonarseButtonActionPerformed(evt);
            }
        });

        equipoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Lakers", "Clippers", "Bucks", "Bulls", "Celtics", "Nets" }));
        equipoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipoComboActionPerformed(evt);
            }
        });

        CerrarButton.setText("Volver");
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
                .addGap(196, 196, 196)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(84, 84, 84))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mailTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(DNITextField)
                    .addComponent(nombreTextField)
                    .addComponent(apellidosTextField)
                    .addComponent(contraTextField)
                    .addComponent(equipoCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(313, 313, 313))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(AbonarseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(CerrarButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(CerrarButton)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DNITextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(contraTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(equipoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(AbonarseButton)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Boton para registrarte como soscio
     *
     * @param evt
     */
    private void AbonarseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbonarseButtonActionPerformed

        boolean insertadoCorrectamente = false;
        try {
            SingletonBBDD singleton = SingletonBBDD.getInstancia();
            SocioDAO daoS = new PostgreSQLSocioDAO(singleton.connect());
            EquipoDAO daoE = new PostgreSQLEquipoDAO(singleton.connect());
            String nombre = "\'" + equipoCombo.getSelectedItem().toString() + "\'";
            String id = "";
            try {
                id = daoE.obtenerID(nombre);
            } catch (DAOException ex) {
                System.out.println(ex.getMessage());
            }
            Integer id2 = Integer.parseInt(id);

            Socio s1 = new Socio(nombreTextField.getText(), apellidosTextField.getText(), mailTextField.getText(), id2, contraTextField.getText());

            s1.setDNI(DNITextField.getText());

            try {
                daoS.insertar(s1);
                insertadoCorrectamente = true;
            } catch (DAOException ex) {
                System.out.println(ex.getMessage());
            }
            if (insertadoCorrectamente) {
                JOptionPane.showMessageDialog(null, "Socio dado de alta correctamente");
                Login l;
                try {
                    l = new Login();
                    this.setVisible(false);
                    l.setVisible(true);
                } catch (SQLException | DAOException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


    }//GEN-LAST:event_AbonarseButtonActionPerformed

    private void DNITextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DNITextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DNITextFieldActionPerformed

    private void apellidosTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidosTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidosTextFieldActionPerformed

    private void equipoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipoComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_equipoComboActionPerformed
    /**
     * Boton para volver al login
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
            java.util.logging.Logger.getLogger(RegistroSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistroSocio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AbonarseButton;
    private javax.swing.JButton CerrarButton;
    private javax.swing.JTextField DNITextField;
    private javax.swing.JTextField apellidosTextField;
    private javax.swing.JPasswordField contraTextField;
    private javax.swing.JComboBox<String> equipoCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField mailTextField;
    private javax.swing.JTextField nombreTextField;
    // End of variables declaration//GEN-END:variables
}