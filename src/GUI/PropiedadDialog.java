package GUI;

import civitas.Casilla;
import civitas.CasillaCalle;
import civitas.Jugador;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author miguecc99
 */
public class PropiedadDialog extends javax.swing.JDialog {
    private Jugador jugadorActual;
    private int propiedadAGestionar;
    
    private void init() {
        propiedadLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        propiedadesAGestionarList.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    
    public PropiedadDialog(java.awt.Frame parent, Jugador jugadorActual) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        init();
        this.jugadorActual = jugadorActual;
        this.propiedadAGestionar = 0;
        
        generarListaPropiedadesAGestionar();
        
        this.setVisible(true);
        repaint();
        revalidate();
    }
    
    public int getPropiedad() {
        return propiedadAGestionar;
    }
    
    private void generarListaPropiedadesAGestionar() {
        DefaultListModel propiedadesAGestionar = new DefaultListModel<>();    // datos para la lista
        ArrayList<CasillaCalle> propiedades = jugadorActual.getPropiedades();
        
        for(Casilla propiedad: propiedades)
            propiedadesAGestionar.addElement(propiedad.getNombre());
        
        propiedadesAGestionarList.setModel(propiedadesAGestionar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        propiedadLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        propiedadesAGestionarList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        propiedadLabel.setText("Propiedad a Gestionar");

        propiedadesAGestionarList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        propiedadesAGestionarList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                propiedadesAGestionarListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(propiedadesAGestionarList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(propiedadLabel)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(propiedadLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void propiedadesAGestionarListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propiedadesAGestionarListMouseClicked
        // TODO add your handling code here:
        propiedadAGestionar = propiedadesAGestionarList.getSelectedIndex();
        this.dispose();
    }//GEN-LAST:event_propiedadesAGestionarListMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel propiedadLabel;
    private javax.swing.JList<String> propiedadesAGestionarList;
    // End of variables declaration//GEN-END:variables
}
