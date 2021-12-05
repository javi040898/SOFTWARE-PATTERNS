package Interfaces;

import DAO.DAOException;
import DAO.DirectivaDAO;
import DAO.DueñoDAO;
import DAO.JugadorDAO;
import DAO.MiembroCuerpoTecnicoDAO;
import DAO.SocioDAO;
import SQL.PostgreSQLDirectivaDAO;
import SQL.PostgreSQLDueñoDAO;
import SQL.PostgreSQLJugadorDAO;
import SQL.PostgreSQLMCuerpoTecnicoDAO;
import SQL.PostgreSQLSocioDAO;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Proxy.ProxyProteccion;
import Singleton.SingletonBBDD;
import Proxy.Usuario;

/**
 * Clase en la que los usuarios, a través de sus credenciales, acceden a la
 * aplicación
 *
 * @author Javier
 */
public class Login extends javax.swing.JFrame {

    /**
     * Constructor
     *
     * @throws SQLException
     * @throws DAOException
     */
    public Login() throws SQLException, DAOException {

        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagen/basket.jpg")).getImage());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LoginContraseña = new javax.swing.JPasswordField();
        LoginButton = new javax.swing.JButton();
        HacerseSocioButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LoginUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setText("                          Usuario");

        jLabel2.setText("                          Contraseña");

        LoginContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginContraseñaActionPerformed(evt);
            }
        });

        LoginButton.setText("Login");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        HacerseSocioButton.setText("Hacerse socio");
        HacerseSocioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HacerseSocioButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("¿No eres socio aún?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LoginContraseña)
                            .addComponent(LoginUsuario)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(LoginButton)))
                .addContainerGap(197, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HacerseSocioButton)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(LoginButton)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HacerseSocioButton)
                    .addComponent(jLabel3))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginContraseñaActionPerformed
    /**
     * Boton para que, una vez introducidas las credenciales, el usuario acceda
     * a la aplicación
     *
     * @param evt
     */
    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed

        SingletonBBDD singleton;

        try {
            String usuario = LoginUsuario.getText();
            String password = LoginContraseña.getText();
            String usuario2 = "\'" + usuario + "\'"; //Para que haga bien la consulta

            singleton = SingletonBBDD.getInstancia();

            DirectivaDAO daoD = new PostgreSQLDirectivaDAO(singleton.connect());
            DueñoDAO daoDu = new PostgreSQLDueñoDAO(singleton.connect());
            JugadorDAO daoJ = new PostgreSQLJugadorDAO(singleton.connect());
            MiembroCuerpoTecnicoDAO daoM = new PostgreSQLMCuerpoTecnicoDAO(singleton.connect());
            SocioDAO daoS = new PostgreSQLSocioDAO(singleton.connect());
            ProxyProteccion proxy;
            Usuario u = new Usuario(usuario, password);
            proxy = new ProxyProteccion(u);

            if (proxy.comprobarJugadorUsuario(u)) {
                int id_equipo = daoJ.obtenerIDEquipo(usuario2);
                InterfazJugador ij = new InterfazJugador(usuario, id_equipo);
                this.setVisible(false);
                ij.setVisible(true);
            } else if (proxy.comprobarMiembroCTUsuario(u)) {
                int id_equipo = daoM.obtenerIDEquipo(usuario2);
                InterfazMiembroCT ict = new InterfazMiembroCT(usuario, id_equipo);
                this.setVisible(false);
                ict.setVisible(true);
            } else if (proxy.comprobarDirectivaUsuario(u)/*daoD.obtenerDNI(usuario2).equals(usuario) && daoD.obtenerContraseña(usuario2).equals(password)*/) {
                String id_equipo = daoD.obtenerIDEquipo(usuario2);
                InterfazDirectiva idir = new InterfazDirectiva(id_equipo, usuario);
                this.setVisible(false);
                idir.setVisible(true);
            } else if (proxy.comprobarSocioUsuario(u)/*daoS.obtenerDNI(usuario2).equals(usuario) && daoS.obtenerContraseña(usuario2).equals(password)*/) {
                int id_equipo = daoS.obtenerIDEquipo(usuario2);
                InterfazSocio iso = new InterfazSocio(usuario, id_equipo);
                this.setVisible(false);
                iso.setVisible(true);
            } else if (proxy.comprobarDuenoUsuario(u)/*daoDu.obtenerDNI(usuario2).equals(usuario) && daoDu.obtenerContraseña(usuario2).equals(password)*/) {
                String id_equipo = daoDu.obtenerIDEquipo(usuario2);
                InterfazDueño idue = new InterfazDueño(id_equipo, usuario);
                this.setVisible(false);
                idue.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }

        } catch (SQLException | DAOException ex) {
            System.out.println(ex.getMessage());
        }


    }//GEN-LAST:event_LoginButtonActionPerformed
    /**
     * Boton para acceder a la interfaz de registro de socios
     *
     * @param evt
     */
    private void HacerseSocioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HacerseSocioButtonActionPerformed
        RegistroSocio rs = new RegistroSocio();
        this.setVisible(false);
        rs.setVisible(true);

    }//GEN-LAST:event_HacerseSocioButtonActionPerformed

    private void LoginUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (SQLException | DAOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HacerseSocioButton;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPasswordField LoginContraseña;
    private javax.swing.JTextField LoginUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
