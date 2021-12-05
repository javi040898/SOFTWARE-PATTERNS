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
 * Clase para que el usuario pueda consultar los lideres de la liga
 *
 * @author Javier y Christian
 */
public class LideresLiga extends javax.swing.JFrame {

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
    public LideresLiga(String tabla, String DNI, int id_Equipo) {
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
        modelo.addColumn("Media Puntos");
        modelo.addColumn("Media Asistencias");
        modelo.addColumn("Media Rebotes");
        this.Tabla.setModel(modelo);

        try {
            SingletonBBDD singleton = SingletonBBDD.getInstancia();
            JugadorDAO dao = new PostgreSQLJugadorDAO(singleton.connect());

            List<Jugador> jugadores = null;
            try {
                jugadores = dao.obtenerTodos();
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
        ordenarRebotesButton = new javax.swing.JButton();
        ordenarPuntosButton = new javax.swing.JButton();
        ordenarAsistenciasButton = new javax.swing.JButton();
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

        ordenarRebotesButton.setText("Ordenar por rebotes");
        ordenarRebotesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenarRebotesButtonActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1408, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(volverButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ordenarPuntosButton)
                .addGap(121, 121, 121)
                .addComponent(ordenarAsistenciasButton)
                .addGap(98, 98, 98)
                .addComponent(ordenarRebotesButton)
                .addGap(176, 176, 176))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(volverButton)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ordenarPuntosButton)
                    .addComponent(ordenarAsistenciasButton)
                    .addComponent(ordenarRebotesButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
                jugadores = dao.obtenerTodos();
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
                    jugador[2] = String.valueOf(j.getMediaPuntos());
                    jugador[3] = String.valueOf(j.getMediaAsistencias());
                    jugador[4] = String.valueOf(j.getMediaRebotes());

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
            jugadores = dao.obtenerTodos();
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
                jugador[2] = String.valueOf(j.getMediaPuntos());
                jugador[3] = String.valueOf(j.getMediaAsistencias());
                jugador[4] = String.valueOf(j.getMediaRebotes());
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
            jugadores = dao.obtenerTodos();
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
                jugador[2] = String.valueOf(j.getMediaPuntos());
                jugador[3] = String.valueOf(j.getMediaAsistencias());
                jugador[4] = String.valueOf(j.getMediaRebotes());

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
            java.util.logging.Logger.getLogger(LideresLiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LideresLiga("", "", 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton ordenarAsistenciasButton;
    private javax.swing.JButton ordenarPuntosButton;
    private javax.swing.JButton ordenarRebotesButton;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}