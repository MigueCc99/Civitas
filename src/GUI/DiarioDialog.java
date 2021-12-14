/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI;

import civitas.Diario;
import java.awt.Component;
import java.util.ArrayList;

/**
 *
 * @author miguecc99
 */
public class DiarioDialog extends javax.swing.JDialog {
    Diario diario = Diario.getInstance();
    
    private void init() {
       eventosLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
       eventosTextArea.setAlignmentX(Component.CENTER_ALIGNMENT);
       okButtonEventos.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    
    private String generarEventosPendientes() {
        ArrayList<String> ev = diario.getEventos();
        String eventos = "";
        
        for(String s: ev){
            eventos += ev + "\n";
            System.out.print(ev);
        }        
        
        return eventos;
    }
    
    void mostrarEventos(){
        String texto = "";
        String separador = " \n =================\n";
        
        while(diario.eventosPendientes()){
            texto += diario.leerEvento() + separador;
        }
        
        eventosTextArea.setText(texto);
        
         this.setVisible(true); //la ventana se pone visible cuando hay eventos que mostrar
         repaint();
         revalidate();
    }
    
    public DiarioDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        init();
        
        mostrarEventos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eventosLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventosTextArea = new javax.swing.JTextArea();
        okButtonEventos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        eventosLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eventosLabel.setText("Eventos:");
        eventosLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        eventosTextArea.setEditable(false);
        eventosTextArea.setColumns(20);
        eventosTextArea.setRows(5);
        jScrollPane1.setViewportView(eventosTextArea);

        okButtonEventos.setText("OK");
        okButtonEventos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        okButtonEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonEventosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(okButtonEventos)
                .addGap(223, 223, 223))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(eventosLabel)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(eventosLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okButtonEventos)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonEventosActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_okButtonEventosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel eventosLabel;
    private javax.swing.JTextArea eventosTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okButtonEventos;
    // End of variables declaration//GEN-END:variables
}
