package GUI;

import civitas.CasillaCalle;
import civitas.Jugador;
import civitas.JugadorEspeculador;
import java.util.ArrayList;

/**
 *
 * @author miguecc99
 */
public class JugadorPanel extends javax.swing.JPanel {
    private Jugador jugador;
    
    public JugadorPanel() {
        initComponents();
    }
    
    void setJugador (Jugador jugador){
        this.jugador = jugador;
        this.nombreTextField.setText(jugador.getNombre());
        this.saldoTextField.setText(String.valueOf(jugador.getSaldo()));
        this.esEspeculadorTextField.setText(Boolean.toString(jugador.isEspeculador()));
        rellenaPropiedades(jugador.getPropiedades());
        this.repaint();
        this.revalidate();
    }
    
    void rellenaPropiedades (ArrayList<CasillaCalle> lista){
        // Se elimina información antigua
        propiedadesPanel.removeAll();
        // Se recorre la lista de propiedades para ir creando sus vistas
        for(CasillaCalle t: lista){
            PropiedadPanel vistaPropiedad = new PropiedadPanel();
            vistaPropiedad.setPropiedad(t);
        
            propiedadesPanel.add(vistaPropiedad);
            vistaPropiedad.setVisible(true);
        }
        // Se fuerza la actualización visual del panel propiedades y del panel del jugador
        repaint();
        revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jugadorPanel = new javax.swing.JPanel();
        nombreLabel = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        saldoLabel = new javax.swing.JLabel();
        saldoTextField = new javax.swing.JTextField();
        esEspeculadorLabel = new javax.swing.JLabel();
        esEspeculadorTextField = new javax.swing.JTextField();
        propiedadesPanel = new javax.swing.JPanel();

        nombreLabel.setText("Nombre");
        jugadorPanel.add(nombreLabel);

        nombreTextField.setEditable(false);
        nombreTextField.setText("nombre");
        nombreTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFieldActionPerformed(evt);
            }
        });
        jugadorPanel.add(nombreTextField);

        saldoLabel.setText("Saldo");
        jugadorPanel.add(saldoLabel);

        saldoTextField.setEditable(false);
        saldoTextField.setText("saldo");
        jugadorPanel.add(saldoTextField);

        esEspeculadorLabel.setText("¿Es especulador?");
        jugadorPanel.add(esEspeculadorLabel);

        esEspeculadorTextField.setEditable(false);
        esEspeculadorTextField.setText("especulador");
        jugadorPanel.add(esEspeculadorTextField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jugadorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
            .addComponent(propiedadesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jugadorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(propiedadesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nombreTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel esEspeculadorLabel;
    private javax.swing.JTextField esEspeculadorTextField;
    private javax.swing.JPanel jugadorPanel;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JPanel propiedadesPanel;
    private javax.swing.JLabel saldoLabel;
    private javax.swing.JTextField saldoTextField;
    // End of variables declaration//GEN-END:variables
}
