package GUI;

import civitas.Casilla;
import civitas.CivitasJuego;
import civitas.Diario;
import civitas.Jugador;
import civitas.OperacionInmobiliaria;
import civitas.OperacionJuego;
import civitas.Tablero;
import controladorCivitas.Respuesta;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
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
    
    private DiarioDialog diarioD;
    private GestionarDialog gestionarD;
    private PropiedadDialog propiedadD;

    public CivitasView() {
        initComponents();
        config();
    }
    
    private void actualizarActual(){
        this.jugadorActual = juego.getJugadorActual();
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
        this.tablero = juego.getTablero();
        actualizarActual();
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
        actualizarActual();
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
        int val= JOptionPane.showConfirmDialog(null, "??Continuar?", "Siguente paso", JOptionPane.YES_NO_OPTION);
        
        if(val == 1) System.exit(0);
    }

    @Override
    public Respuesta comprar() {
        Respuesta respuesta = null;
        int opcion = 1-JOptionPane.showConfirmDialog(null, "??Quieres comprar la calle actual?", "Compra", JOptionPane.YES_NO_OPTION);
        
        switch(opcion){
            case 0:
                respuesta = Respuesta.NO;
            break;
            case 1:
                respuesta = Respuesta.SI;
            break;
        }
        
        return respuesta;
    }

    @Override
    public OperacionInmobiliaria elegirOperacion() {
        OperacionInmobiliaria operacion = null;
        gestionarD = new GestionarDialog(this);    

        switch(gestionarD.getGestion()){
            case 0:
                operacion = OperacionInmobiliaria.CONSTRUIR_CASA;
            break;
            case 1:
                operacion = OperacionInmobiliaria.CONSTRUIR_HOTEL;
            break; 
            case 2:
                operacion = OperacionInmobiliaria.TERMINAR;
            break;
        }    
        
        return operacion;
    }

    @Override
    public int elegirPropiedad() {
        propiedadD = new PropiedadDialog(this, juego.getJugadorActual());
        return propiedadD.getPropiedad();
    }

    @Override
    public void mostrarSiguienteOperacion(OperacionJuego operaci??n) {
        siguienteOperacionTextField.setText(operaci??n.toString());
        if(operaci??n.equals(OperacionJuego.AVANZAR)){
            Dado.getInstance();
        }
        
        this.repaint();
    }

    @Override
    public void mostrarEventos() {
        if(!Diario.getInstance().getEventos().isEmpty())
            diarioD = new DiarioDialog(this);  // crea la ventana del diario
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
        getContentPane().add(jugadorPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 16, 929, 180));
        getContentPane().add(casillaPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 929, -1));

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 930, 120));

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
