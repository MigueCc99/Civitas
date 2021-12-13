package GUI;

import civitas.Casilla;
import civitas.CivitasJuego;
import civitas.Jugador;
import civitas.OperacionInmobiliaria;
import civitas.OperacionJuego;
import civitas.Tablero;
import controladorCivitas.Respuesta;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author miguecc99
 */
public class CivitasView extends javax.swing.JFrame implements Vista{
    private CivitasJuego juego;
    private Jugador jugadorActual;
    private Casilla casillaActual;
    private Tablero tablero;

    public CivitasView() {
        initComponents();
        config();
    }
    
    private void init(){
        this.jugadorActual = juego.getJugadorActual();
        this.tablero = juego.getTablero();
        this.casillaActual = tablero.getCasilla(jugadorActual.getCasillaActual());
    }
    
    private void config(){
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        jugadorPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        casillaPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    
    void setCivitasJuego(CivitasJuego juego){
        this.juego = juego;
        init();
        this.setVisible(true);
    }

    @Override
    public void actualiza() {
        jugadorPanel.setJugador(jugadorActual);
        casillaPanel.setCasilla(casillaActual);
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
        casillaPanel = new GUI.CasillaPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setText("CivitasView");
        getContentPane().add(titulo, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(jugadorPanel, java.awt.BorderLayout.CENTER);
        getContentPane().add(casillaPanel, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.CasillaPanel casillaPanel;
    private GUI.JugadorPanel jugadorPanel;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
