package Interfaces;

import DAO.DAOException;
import DAO.JugadorDAO;
import Iterator.Agregado;
import Iterator.AgregadoConcreto;
import Iterator.Iterador;
import Modelos.Jugador;
import SQL.PostgreSQLJugadorDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import Adapter.AdapterFecha;
import Estrategia.Contexto;
import Estrategia.Estrategia;
import Estrategia.EstrategiaConcretaAsistencias;
import Estrategia.EstrategiaConcretaPuntos;
import Estrategia.EstrategiaConcretaRebotes;
import Adapter.Fecha;
import Singleton.SingletonBBDD;

/**
 * Clase para que el usuario pueda consultar las plantillas de la liga
 *
 * @author Javier y Christian
 */
public class ConsultaPlantillas extends javax.swing.JFrame {

    /**
     * Variable tipo Fecha para adaptar la fecha con formato US al formato
     * español
     */
    Fecha fecha;
    /**
     * Variable para crear la tabla
     */
    DefaultTableModel modelo;
    /**
     * Variable para saber qué usuario está visitando esta interfaz Se utiliza
     * para volver hacia atrás
     */
    private final String tabla;
    /**
     * DNI del usuario que esta visitando la interfaz
     */
    private final String DNI;
    /**
     * id del equipo del usuario que esta visitando la interfaz
     */
    private final int id_Equipo;

    /**
     * Constructor
     *
     * @param tabla
     * @param DNI
     * @param id_Equipo
     */
    public ConsultaPlantillas(String tabla, String DNI, int id_Equipo) {
        this.DNI = DNI;
        this.id_Equipo = id_Equipo;
        this.tabla = tabla;
        initComponents();
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
        modelo.addColumn("Apellidos");
        modelo.addColumn("Dorsal");
        modelo.addColumn("Media Puntos");
        modelo.addColumn("Media Asistencias");
        modelo.addColumn("Media Rebotes");
        modelo.addColumn("Nacionalidad");
        modelo.addColumn("Posicion");
        modelo.addColumn("Salario ($)");
        modelo.addColumn("Estado");
        modelo.addColumn("Fecha fin Contrato");
        this.Tabla.setModel(modelo);
        ordenarAsistenciasButton.setVisible(false);
        ordenarPuntosButton.setVisible(false);
        ordenarRebotesButton.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BuscarButon = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        FcontratoCombo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        ordenarPuntosButton = new javax.swing.JButton();
        ordenarAsistenciasButton = new javax.swing.JButton();
        ordenarRebotesButton = new javax.swing.JButton();
        volverButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BuscarButon.setText("Buscar");
        BuscarButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarButonActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione el equipo del que quiere consultar la plantilla");

        FcontratoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Lakers", "Clippers", "Bucks", "Bulls", "Celtics", "Nets" }));
        FcontratoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FcontratoComboActionPerformed(evt);
            }
        });

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

        ordenarPuntosButton.setText("Ordenar por puntos");
        ordenarPuntosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenarPuntosButtonActionPerformed(evt);
            }
        });

        ordenarAsistenciasButton.setText("Ordenar por asistencias");
        ordenarAsistenciasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenarAsistenciasButtonActionPerformed(evt);
            }
        });

        ordenarRebotesButton.setText("Ordenar por rebotes");
        ordenarRebotesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenarRebotesButtonActionPerformed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(volverButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FcontratoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BuscarButon)
                        .addGap(29, 29, 29)
                        .addComponent(ordenarPuntosButton)
                        .addGap(18, 18, 18)
                        .addComponent(ordenarAsistenciasButton)
                        .addGap(18, 18, 18)
                        .addComponent(ordenarRebotesButton))
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(volverButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FcontratoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarButon)
                    .addComponent(ordenarPuntosButton)
                    .addComponent(ordenarAsistenciasButton)
                    .addComponent(ordenarRebotesButton))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FcontratoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FcontratoComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FcontratoComboActionPerformed
    /**
     * Boton para seleccionar la plantilla que se desea consultar
     *
     * @param evt
     */
    private void BuscarButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarButonActionPerformed

        int a = modelo.getRowCount() - 1;

        for (int i = a; i >= 0; i--) {

            modelo.removeRow(i);
        }

        ordenarAsistenciasButton.setVisible(true);
        ordenarPuntosButton.setVisible(true);
        ordenarRebotesButton.setVisible(true);

        try {
            SingletonBBDD singleton = SingletonBBDD.getInstancia();
            JugadorDAO dao = new PostgreSQLJugadorDAO(singleton.connect());

            List<Jugador> jugadores = null;
            try {
                jugadores = dao.obtenerPlantilla(FcontratoCombo.getSelectedItem().toString());
            } catch (DAOException ex) {
                System.out.println(ex.getMessage());
            }

            try {

                Agregado agregado = new AgregadoConcreto(jugadores);
                Iterador iterador = agregado.crearIterador();

                while (iterador.hayMas()) {
                    Jugador j = (Jugador) iterador.elementoActual();
                    fecha = new AdapterFecha(j.getFinContrato());

                    String[] jugador = new String[11];
                    jugador[0] = j.getNombre();
                    jugador[1] = j.getApellidos();
                    jugador[2] = String.valueOf(j.getDorsal());
                    jugador[3] = String.valueOf(j.getMediaPuntos());
                    jugador[4] = String.valueOf(j.getMediaAsistencias());
                    jugador[5] = String.valueOf(j.getMediaRebotes());
                    jugador[6] = j.getNacionalidad();
                    jugador[7] = j.getPosicion();
                    jugador[8] = String.valueOf(j.getSalario());
                    jugador[9] = j.getEstado();
                    jugador[10] = fecha.toString();
                    modelo.addRow(jugador);
                    iterador.siguiente();
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: " + e.toString());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


    }//GEN-LAST:event_BuscarButonActionPerformed
    /**
     * Boton para ordenar la plantilla por los jugadores con mas puntos
     *
     * @param evt
     */
    private void ordenarPuntosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenarPuntosButtonActionPerformed
        int a = modelo.getRowCount() - 1;

        for (int i = a; i >= 0; i--) {

            modelo.removeRow(i);
        }

        try {
            SingletonBBDD singleton = SingletonBBDD.getInstancia();
            JugadorDAO dao = new PostgreSQLJugadorDAO(singleton.connect());

            List<Jugador> jugadores = null;
            try {
                jugadores = dao.obtenerPlantilla(FcontratoCombo.getSelectedItem().toString());
            } catch (DAOException ex) {
                System.out.println(ex.getMessage());
            }

            try {

                Agregado agregado = new AgregadoConcreto(jugadores);
                Iterador iterador = agregado.crearIterador();

                Estrategia est = new EstrategiaConcretaPuntos();
                Contexto contexto = new Contexto(est, jugadores);
                contexto.ejecutaEstrategia();

                while (iterador.hayMas()) {
                    Jugador j = (Jugador) iterador.elementoActual();
                    fecha = new AdapterFecha(j.getFinContrato());
                    String[] jugador = new String[11];
                    jugador[0] = j.getNombre();
                    jugador[1] = j.getApellidos();
                    jugador[2] = String.valueOf(j.getDorsal());
                    jugador[3] = String.valueOf(j.getMediaPuntos());
                    jugador[4] = String.valueOf(j.getMediaAsistencias());
                    jugador[5] = String.valueOf(j.getMediaRebotes());
                    jugador[6] = j.getNacionalidad();
                    jugador[7] = j.getPosicion();
                    jugador[8] = String.valueOf(j.getSalario());
                    jugador[9] = j.getEstado();
                    jugador[10] = fecha.toString();
                    modelo.addRow(jugador);
                    iterador.siguiente();
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: " + e.toString());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


    }//GEN-LAST:event_ordenarPuntosButtonActionPerformed
    /**
     * Boton para ordenar la plantilla por los jugadores con mas asistencias
     *
     * @param evt
     */
    private void ordenarAsistenciasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenarAsistenciasButtonActionPerformed

        int a = modelo.getRowCount() - 1;

        for (int i = a; i >= 0; i--) {

            modelo.removeRow(i);
        }

        try {
            SingletonBBDD singleton = SingletonBBDD.getInstancia();
            JugadorDAO dao = new PostgreSQLJugadorDAO(singleton.connect());

            List<Jugador> jugadores = null;
            try {
                jugadores = dao.obtenerPlantilla(FcontratoCombo.getSelectedItem().toString());
            } catch (DAOException ex) {
                System.out.println(ex.getMessage());
            }

            try {

                Agregado agregado = new AgregadoConcreto(jugadores);
                Iterador iterador = agregado.crearIterador();

                Estrategia est = new EstrategiaConcretaAsistencias();
                Contexto contexto = new Contexto(est, jugadores);
                contexto.ejecutaEstrategia();

                while (iterador.hayMas()) {
                    Jugador j = (Jugador) iterador.elementoActual();
                    fecha = new AdapterFecha(j.getFinContrato());
                    String[] jugador = new String[11];
                    jugador[0] = j.getNombre();
                    jugador[1] = j.getApellidos();
                    jugador[2] = String.valueOf(j.getDorsal());
                    jugador[3] = String.valueOf(j.getMediaPuntos());
                    jugador[4] = String.valueOf(j.getMediaAsistencias());
                    jugador[5] = String.valueOf(j.getMediaRebotes());
                    jugador[6] = j.getNacionalidad();
                    jugador[7] = j.getPosicion();
                    jugador[8] = String.valueOf(j.getSalario());
                    jugador[9] = j.getEstado();
                    jugador[10] = fecha.toString();
                    modelo.addRow(jugador);
                    iterador.siguiente();
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: " + e.toString());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


    }//GEN-LAST:event_ordenarAsistenciasButtonActionPerformed
    /**
     * Boton para ordenar la plantilla por los jugadores con mas rebotes
     *
     * @param evt
     */
    private void ordenarRebotesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenarRebotesButtonActionPerformed
        int a = modelo.getRowCount() - 1;

        for (int i = a; i >= 0; i--) {

            modelo.removeRow(i);
        }

        try {
            SingletonBBDD singleton = SingletonBBDD.getInstancia();
            JugadorDAO dao = new PostgreSQLJugadorDAO(singleton.connect());

            List<Jugador> jugadores = null;
            try {
                jugadores = dao.obtenerPlantilla(FcontratoCombo.getSelectedItem().toString());
            } catch (DAOException ex) {
                System.out.println(ex.getMessage());
            }

            try {

                Agregado agregado = new AgregadoConcreto(jugadores);
                Iterador iterador = agregado.crearIterador();

                Estrategia est = new EstrategiaConcretaRebotes();
                Contexto contexto = new Contexto(est, jugadores);
                contexto.ejecutaEstrategia();

                while (iterador.hayMas()) {
                    Jugador j = (Jugador) iterador.elementoActual();
                    fecha = new AdapterFecha(j.getFinContrato());
                    String[] jugador = new String[11];
                    jugador[0] = j.getNombre();
                    jugador[1] = j.getApellidos();
                    jugador[2] = String.valueOf(j.getDorsal());
                    jugador[3] = String.valueOf(j.getMediaPuntos());
                    jugador[4] = String.valueOf(j.getMediaAsistencias());
                    jugador[5] = String.valueOf(j.getMediaRebotes());
                    jugador[6] = j.getNacionalidad();
                    jugador[7] = j.getPosicion();
                    jugador[8] = String.valueOf(j.getSalario());
                    jugador[9] = j.getEstado();
                    jugador[10] = fecha.toString();
                    modelo.addRow(jugador);
                    iterador.siguiente();
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: " + e.toString());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


    }//GEN-LAST:event_ordenarRebotesButtonActionPerformed
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
            java.util.logging.Logger.getLogger(ConsultaPlantillas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConsultaPlantillas("", "", 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarButon;
    private javax.swing.JComboBox<String> FcontratoCombo;
    private javax.swing.JTable Tabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton ordenarAsistenciasButton;
    private javax.swing.JButton ordenarPuntosButton;
    private javax.swing.JButton ordenarRebotesButton;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
