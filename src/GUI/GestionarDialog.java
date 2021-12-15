package GUI;

import civitas.OperacionInmobiliaria;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;

/**
 *
 * @author miguecc99
 */
public class GestionarDialog extends javax.swing.JDialog {
    private int gestionElegida = -1;
    
    private void init() {
       gestionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
       gestionarLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
       listaGestion.setAlignmentX(Component.CENTER_ALIGNMENT);
    }    
    
    public GestionarDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        init();
        
        generarListaGestionesInmobiliarias();
        
        this.setVisible(true); //la ventana se pone visible cuando hay eventos que mostrar
        repaint();
        revalidate();
    }
    
    public int getGestion() {
        return gestionElegida;
    }
    
    private void generarListaGestionesInmobiliarias() {
        DefaultListModel gestiones = new DefaultListModel<>();     // datos para la lista
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList(
                "Construir Casa", "Construir Hotel", 
                "Terminar"));
        for(String s: opciones){
            gestiones.addElement(s);    // se completan los datos
        }
        listaGestion.setModel(gestiones);   // Se le dice a la lista cuales son los datos
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gestionarLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaGestion = new javax.swing.JList<>();
        gestionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        gestionarLabel.setText("Gestionar");

        listaGestion.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaGestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaGestionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaGestion);

        gestionButton.setText("Realizar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(gestionarLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(gestionButton)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(gestionarLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gestionButton)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaGestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaGestionMouseClicked
        // TODO add your handling code here:
        gestionElegida = listaGestion.getSelectedIndex();
        this.dispose();
    }//GEN-LAST:event_listaGestionMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gestionButton;
    private javax.swing.JLabel gestionarLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaGestion;
    // End of variables declaration//GEN-END:variables
}
