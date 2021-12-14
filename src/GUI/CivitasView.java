package GUI;

import civitas.Casilla;
import civitas.CivitasJuego;
import civitas.Jugador;
import civitas.OperacionInmobiliaria;
import civitas.OperacionJuego;
import civitas.Tablero;
import controladorCivitas.Respuesta;
import java.awt.Component;
import java.util.ArrayList;
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
    
    private void ocultaRanking() {
        this.rankingLabel.setVisible(false);
        this.rankingTextField.setVisible(false);
    }
    
    private void muestraRanking() {
        ArrayList<Jugador> rankingJugadores = juego.ranking();
        String ranking = "";
        
        for(int i = 0; i < rankingJugadores.size(); i++)
            ranking += i+1 + " " + rankingJugadores.get(i) + "\n";
        
        this.rankingTextField.setText(ranking);
        this.rankingLabel.setVisible(true);
        this.rankingTextField.setVisible(true);
    }

    @Override
    public void actualiza() {
        jugadorPanel.setJugador(jugadorActual);
        casillaPanel.setCasilla(casillaActual);
        
        ocultaRanking();
        
        if(juego.finalDelJuego()){
            muestraRanking();
            this.repaint();
            this.revalidate();
        } 
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
        siguienteOperacionTextField.setText(operación.toString());
        if(operación.equals(OperacionJuego.AVANZAR)){
            Dado.getInstance();
        }
        
        this.repaint();
    }

    @Override
    public void mostrarEventos() {
        System.out.println("Eventos");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jugadorPanel = new GUI.JugadorPanel();
        casillaPanel = new GUI.CasillaPanel();
        jPanel1 = new javax.swing.JPanel();
        siguienteOperacionLabel = new javax.swing.JLabel();
        siguienteOperacionTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        rankingLabel = new javax.swing.JLabel();
        rankingTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setText("CivitasView");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 929, -1));
        getContentPane().add(jugadorPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 16, 929, 220));
        getContentPane().add(casillaPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 361, 929, -1));

        siguienteOperacionLabel.setText("Siguiente Operacion");
        jPanel1.add(siguienteOperacionLabel);

        siguienteOperacionTextField.setEditable(false);
        siguienteOperacionTextField.setText("sigOperacion");
        siguienteOperacionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteOperacionTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(siguienteOperacionTextField);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 930, 40));

        rankingLabel.setText("Ranking");
        jPanel2.add(rankingLabel);

        rankingTextField.setEditable(false);
        rankingTextField.setText("r");
        jPanel2.add(rankingTextField);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 930, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteOperacionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteOperacionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_siguienteOperacionTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.CasillaPanel casillaPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private GUI.JugadorPanel jugadorPanel;
    private javax.swing.JLabel rankingLabel;
    private javax.swing.JTextField rankingTextField;
    private javax.swing.JLabel siguienteOperacionLabel;
    private javax.swing.JTextField siguienteOperacionTextField;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
