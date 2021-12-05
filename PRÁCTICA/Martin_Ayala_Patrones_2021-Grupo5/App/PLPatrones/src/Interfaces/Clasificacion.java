package Interfaces;

import DAO.DAOException;
import DAO.EquipoDAO;
import Iterator.Agregado;
import Iterator.AgregadoConcreto;
import Iterator.Iterador;
import Modelos.Equipo;
import SQL.PostgreSQLEquipoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import Estrategia.ContextoEquipo;
import Estrategia.EstrategiaConcretaClasificacion;
import Estrategia.EstrategiaEquipo;
import Singleton.SingletonBBDD;

/**
 * Clase para que el usuario pueda consultar la claificacion de la liga
 *
 * @author Javier y Christian
 */
public class Clasificacion extends javax.swing.JFrame {

    /**
     * Variable para crear la tabla
     */
    DefaultTableModel modelo;
    /**
     * Variable para saber qué usuario está visitando esta interfaz Se utiliza
     * para volver hacia atrás
     */
    private String tabla;
    /**
     * DNI del usuario que esta visitando la interfaz
     */
    private String DNI;
    /**
     * id del equipo del usuario que esta visitando la interfaz
     */
    private int id_Equipo;

    /**
     * Constructor
     *
     * @param tabla
     * @param DNI
     * @param id_Equipo
     */
    public Clasificacion(String tabla, String DNI, int id_Equipo) {
        initComponents();
        this.tabla = tabla;
        this.DNI = DNI;
        this.id_Equipo = id_Equipo;
        if (id_Equipo == 1) {
            setIconImage(new ImageIcon(getClass().getResource("/imagen/lakers.jpg")).getImage());
        }
        if (id_Equipo == 2) {
            setIconImage(new ImageIcon(getClass().getResource("/imagen/clippers.jpg")).getImage());
        }
        if (id_Equipo == 3) {
            setIconImage(new ImageIcon(getClass().getResource("/imagen/nets.jpg")).getImage());
        }
        if (id_Equipo == 4) {
            setIconImage(new ImageIcon(getClass().getResource("/imagen/bucks.jpg")).getImage());
        }
        if (id_Equipo == 5) {
            setIconImage(new ImageIcon(getClass().getResource("/imagen/celtics.jpg")).getImage());
        }
        if (id_Equipo == 6) {
            setIconImage(new ImageIcon(getClass().getResource("/imagen/bulls.jpg")).getImage());
        }
        modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Pabellon");
        modelo.addColumn("Patrocinador");
        modelo.addColumn("Equipacion Local");
        modelo.addColumn("Equipacion Visitante");
        modelo.addColumn("Puntos");

        this.Tabla.setModel(modelo);

        try {
            SingletonBBDD singleton = SingletonBBDD.getInstancia();
            EquipoDAO dao = new PostgreSQLEquipoDAO(singleton.connect());
            List<Equipo> equipos = null;
            try {
                equipos = dao.obtenerTodos();
            } catch (DAOException ex) {
                System.out.println(ex.getMessage());
            }
            try {

                Agregado agregado = new AgregadoConcreto(equipos);

                Iterador iterador = agregado.crearIterador();

                EstrategiaEquipo est = new EstrategiaConcretaClasificacion();
                ContextoEquipo contexto = new ContextoEquipo(est, equipos);
                contexto.ejecutaEstrategia();

                while (iterador.hayMas()) {
                    Equipo e = (Equipo) iterador.elementoActual();

                    String[] equipo = new String[11];
                    equipo[0] = e.getNombre();
                    equipo[1] = e.getCiudad();
                    equipo[2] = e.getPabellon();
                    equipo[3] = e.getPatrocinador();
                    equipo[4] = e.getEquipacionLocal();
                    equipo[5] = e.getEquipacionVisitante();
                    equipo[6] = String.valueOf(e.getPuntos());

                    modelo.addRow(equipo);
                    iterador.siguiente();
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: " + e.toString());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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

        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        volverButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(Tabla);

        volverButton.setText("Volver");
        volverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(volverButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1408, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(volverButton)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Boton para volver a la interfaz anterior dependiendo del nombre de la
     * tabla
     *
     * @param evt
     */
    private void volverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverButtonActionPerformed
        if ("Directiva".equals(tabla)) {
            InterfazDirectiva id = new InterfazDirectiva(Integer.toString(id_Equipo), DNI);
            this.setVisible(false);
            id.setVisible(true);
        }
        if ("Dueño".equals(tabla)) {
            InterfazDueño id = new InterfazDueño(Integer.toString(id_Equipo), DNI);
            this.setVisible(false);
            id.setVisible(true);
        }
        if ("Jugador".equals(tabla)) {
            InterfazJugador id = new InterfazJugador(DNI, id_Equipo);
            this.setVisible(false);
            id.setVisible(true);
        }
        if ("MiembroCT".equals(tabla)) {
            InterfazMiembroCT id = new InterfazMiembroCT(DNI, id_Equipo);
            this.setVisible(false);
            id.setVisible(true);
        }

        if ("Socio".equals(tabla)) {
            InterfazSocio id = new InterfazSocio(DNI, id_Equipo);
            this.setVisible(false);
            id.setVisible(true);
        }
    }//GEN-LAST:event_volverButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Clasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Clasificacion("", "", 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
