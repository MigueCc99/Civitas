package GUI;

import civitas.Casilla;
import civitas.CasillaCalle;
import civitas.CasillaSorpresa;

/**
 *
 * @author miguecc99
 */
public class CasillaPanel extends javax.swing.JPanel {
    private Casilla casilla;
    
    public CasillaPanel() {
        initComponents();
        init();
    }
    
    private void init() {
        this.precioCompraLabel.setVisible(false);
        this.precioCompraTextField.setVisible(false);
        this.precioEdificarLabel.setVisible(false);
        this.precioEdificarTextField.setVisible(false);
        this.alquilerBaseLabel.setVisible(false);
        this.alquilerBaseTextField.setVisible(false);
        this.numCasasLabel.setVisible(false);
        this.numCasasTextField.setVisible(false);
        this.numHotelesLabel.setVisible(false);
        this.numHotelesTextField.setVisible(false);
        this.sorpresaLabel.setVisible(false);
        this.sorpresaTextField.setVisible(false);
    }
    
    private void setCasillaCalle(CasillaCalle casilla) {
            this.precioCompraTextField.setText(String.valueOf(casilla.getPrecioCompra()));
            this.precioEdificarTextField.setText(String.valueOf(casilla.getPrecioCompra()));
            this.alquilerBaseTextField.setText(String.valueOf(casilla.getPrecioCompra()));
            this.numCasasTextField.setText(String.valueOf(casilla.getPrecioCompra()));
            this.numHotelesTextField.setText(String.valueOf(casilla.getPrecioCompra()));
    }
    
    private void setCasillaSorpresa(CasillaSorpresa casilla) {
        this.sorpresaTextField.setText(String.valueOf(casilla.getSorpresaText()));
    }
    
    void setCasilla(Casilla casilla) {
        this.casilla = casilla;
        this.nombreCasillaTextField.setText(casilla.getNombre());
        init();
        
        if(casilla instanceof CasillaCalle){
            this.precioCompraLabel.setVisible(true);
            this.precioCompraTextField.setVisible(true);
            this.precioEdificarLabel.setVisible(true);
            this.precioEdificarTextField.setVisible(true);
            this.alquilerBaseLabel.setVisible(true);
            this.alquilerBaseTextField.setVisible(true);
            this.numCasasLabel.setVisible(true);
            this.numCasasTextField.setVisible(true);
            this.numHotelesLabel.setVisible(true);
            this.numHotelesTextField.setVisible(true);
            
            setCasillaCalle((CasillaCalle)casilla);
        }
        else if(casilla instanceof CasillaSorpresa){
            this.sorpresaLabel.setVisible(true);
            this.sorpresaTextField.setVisible(true); 
            
            setCasillaSorpresa((CasillaSorpresa)casilla);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreCasillaLabel = new javax.swing.JLabel();
        nombreCasillaTextField = new javax.swing.JTextField();
        precioCompraLabel = new javax.swing.JLabel();
        precioCompraTextField = new javax.swing.JTextField();
        precioEdificarLabel = new javax.swing.JLabel();
        precioEdificarTextField = new javax.swing.JTextField();
        alquilerBaseLabel = new javax.swing.JLabel();
        alquilerBaseTextField = new javax.swing.JTextField();
        numCasasLabel = new javax.swing.JLabel();
        numCasasTextField = new javax.swing.JTextField();
        numHotelesLabel = new javax.swing.JLabel();
        numHotelesTextField = new javax.swing.JTextField();
        sorpresaLabel = new javax.swing.JLabel();
        sorpresaTextField = new javax.swing.JTextField();

        nombreCasillaLabel.setText("Casilla Actual");
        add(nombreCasillaLabel);

        nombreCasillaTextField.setEditable(false);
        nombreCasillaTextField.setText("nombre");
        add(nombreCasillaTextField);

        precioCompraLabel.setText("PCompra");
        add(precioCompraLabel);

        precioCompraTextField.setEditable(false);
        precioCompraTextField.setText("pc");
        add(precioCompraTextField);

        precioEdificarLabel.setText("PEdificar");
        add(precioEdificarLabel);

        precioEdificarTextField.setEditable(false);
        precioEdificarTextField.setText("pe");
        add(precioEdificarTextField);

        alquilerBaseLabel.setText("Alquiler Base");
        add(alquilerBaseLabel);

        alquilerBaseTextField.setEditable(false);
        alquilerBaseTextField.setText("ab");
        add(alquilerBaseTextField);

        numCasasLabel.setText("NºCasas");
        add(numCasasLabel);

        numCasasTextField.setEditable(false);
        numCasasTextField.setText("nc");
        add(numCasasTextField);

        numHotelesLabel.setText("NºHoteles");
        add(numHotelesLabel);

        numHotelesTextField.setEditable(false);
        numHotelesTextField.setText("nh");
        add(numHotelesTextField);

        sorpresaLabel.setText("Sorpresa");
        add(sorpresaLabel);

        sorpresaTextField.setEditable(false);
        sorpresaTextField.setText("sorpresa");
        add(sorpresaTextField);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alquilerBaseLabel;
    private javax.swing.JTextField alquilerBaseTextField;
    private javax.swing.JLabel nombreCasillaLabel;
    private javax.swing.JTextField nombreCasillaTextField;
    private javax.swing.JLabel numCasasLabel;
    private javax.swing.JTextField numCasasTextField;
    private javax.swing.JLabel numHotelesLabel;
    private javax.swing.JTextField numHotelesTextField;
    private javax.swing.JLabel precioCompraLabel;
    private javax.swing.JTextField precioCompraTextField;
    private javax.swing.JLabel precioEdificarLabel;
    private javax.swing.JTextField precioEdificarTextField;
    private javax.swing.JLabel sorpresaLabel;
    private javax.swing.JTextField sorpresaTextField;
    // End of variables declaration//GEN-END:variables
}
