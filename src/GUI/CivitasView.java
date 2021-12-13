/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import civitas.CivitasJuego;
import civitas.OperacionInmobiliaria;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import javax.swing.JOptionPane;

/**
 *
 * @author miguecc99
 */
public class CivitasView extends javax.swing.JFrame implements Vista{
    private CivitasJuego juego;

    public CivitasView() {
        initComponents();
    }
    
    void setCivitasJuego(CivitasJuego juego){
        this.juego = juego;
        this.setVisible(true);
    }

    @Override
    public void actualiza() {
        jugadorPanel.setJugador(juego.getJugadorActual());
    }

    @Override
    public void pausa() {
        int val= JOptionPane.showConfirmDialog(null, "¿Continuar?", "Siguente paso", JOptionPane.YES_NO_OPTION);
        
        if(val == 1) System.exit(0);
    }

    @Override
    public Respuesta comprar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OperacionInmobiliaria elegirOperacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int elegirPropiedad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarSiguienteOperacion(OperacionJuego operación) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarEventos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jugadorPanel = new GUI.JugadorPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setText("CivitasView");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jugadorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addGap(18, 18, 18)
                .addComponent(jugadorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.JugadorPanel jugadorPanel;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
