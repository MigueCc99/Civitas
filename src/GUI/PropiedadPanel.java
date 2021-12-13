package GUI;

import civitas.CasillaCalle;

/**
 *
 * @author miguecc99
 */
public class PropiedadPanel extends javax.swing.JPanel {
    private CasillaCalle tituloPropiedad;
    
    public PropiedadPanel() {
        initComponents();
    }
    
    void setPropiedad(CasillaCalle tituloPropiedad){
        this.tituloPropiedad = tituloPropiedad;
        this.nombrePropiedadTextField.setText(String.valueOf(tituloPropiedad.getNombre()));
        this.numCasasTextField.setText(String.valueOf(tituloPropiedad.getNumCasas()));
        this.numHotelesTextField.setText(String.valueOf(tituloPropiedad.getNumHoteles()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombrePropiedadLabel = new javax.swing.JLabel();
        nombrePropiedadTextField = new javax.swing.JTextField();
        numCasasLabel = new javax.swing.JLabel();
        numCasasTextField = new javax.swing.JTextField();
        numHotelesLabel = new javax.swing.JLabel();
        numHotelesTextField = new javax.swing.JTextField();

        nombrePropiedadLabel.setText("Propiedad");
        add(nombrePropiedadLabel);

        nombrePropiedadTextField.setEditable(false);
        nombrePropiedadTextField.setText("nombre");
        add(nombrePropiedadTextField);

        numCasasLabel.setText("NºCasas");
        add(numCasasLabel);

        numCasasTextField.setEditable(false);
        numCasasTextField.setText("numCasas");
        add(numCasasTextField);

        numHotelesLabel.setText("NºHoteles");
        add(numHotelesLabel);

        numHotelesTextField.setEditable(false);
        numHotelesTextField.setText("numHoteles");
        add(numHotelesTextField);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nombrePropiedadLabel;
    private javax.swing.JTextField nombrePropiedadTextField;
    private javax.swing.JLabel numCasasLabel;
    private javax.swing.JTextField numCasasTextField;
    private javax.swing.JLabel numHotelesLabel;
    private javax.swing.JTextField numHotelesTextField;
    // End of variables declaration//GEN-END:variables
}
