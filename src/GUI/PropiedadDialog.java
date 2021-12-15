/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI;

import civitas.Jugador;
import java.awt.Component;

/**
 *
 * @author miguecc99
 */
public class PropiedadDialog extends javax.swing.JDialog {
    Jugador jugadorActual;
    
    private void init() {
        propiedadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        propiedadLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        propiedadAGestionarPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    
    public PropiedadDialog(java.awt.Frame parent, Jugador jugadorActual) {
        super(parent, true);
        initComponents();
        init();
        this.jugadorActual = jugadorActual;
    }

    public void setPropiedadButtonText(String text) {
        propiedadButton.setText(text);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        propiedadLabel = new javax.swing.JLabel();
        propiedadAGestionarPanel = new GUI.PropiedadPanel();
        propiedadButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        propiedadLabel.setText("Propiedad a Gestionar");

        propiedadButton.setText("Listo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(propiedadAGestionarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(propiedadLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(propiedadButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(propiedadLabel)
                .addGap(29, 29, 29)
                .addComponent(propiedadAGestionarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(propiedadButton)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.PropiedadPanel propiedadAGestionarPanel;
    private javax.swing.JButton propiedadButton;
    private javax.swing.JLabel propiedadLabel;
    // End of variables declaration//GEN-END:variables
}
