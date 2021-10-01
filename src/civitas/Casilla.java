package civitas;

/**
 *
 * @author miguecc99
 */
public class Casilla {
    private static float FACTORALQUILERCALLE = 1.0f;  
    private static float FACTORALQUILERCASA = 1.0f;
    private static float FACTORALQUILERHOTEL = 1.0f;
    
    private TipoCasilla tipo;    
    private String nombre;
    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private int numCasas, numHoteles;
    
    Casilla (TipoCasilla tipo, String nombre, float precioCompra, float precioEdificar, float precioBaseAlquiler){
        this.tipo = tipo;
        this.nombre = nombre;
        this.numCasas = 0;
        this.numHoteles = 0;
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
    }
    
    public String getNombre (){
        return nombre;
    }
    
    public float getPrecioCompra (){
        return precioCompra;
    }
    
    public float getPrecioEdificar (){
        return precioEdificar;
    }
    
    public float getPrecioBaseAlquiler (){
        return precioBaseAlquiler;
    }
    
    public float getPrecioAlquilerCompleto (){
        return FACTORALQUILERCALLE*precioBaseAlquiler*(1 + FACTORALQUILERCASA*numCasas + FACTORALQUILERHOTEL*numHoteles);
    }
    
    public int getNumCasas (){
        return numCasas;
    }
    
    public int getNumHoteles (){
        return numHoteles;
    }
    
    public Boolean construirCasa (){
        numCasas++;
        return true;
    }
    
    public boolean construirHotel (){
        numHoteles++;
        return true;
    }
    
    public boolean igualdadIdentidad (Casilla otraCasilla){
        return this == otraCasilla;
    }
    
    public boolean igualEstado (Casilla otraCasilla){
        if(this.nombre.equals(otraCasilla.getNombre()) && 
           this.numCasas == otraCasilla.getNumCasas() &&
           this.numHoteles == otraCasilla.getNumHoteles() &&
           this.precioBaseAlquiler == otraCasilla.getPrecioBaseAlquiler() &&
           this.precioCompra == otraCasilla.getPrecioCompra() &&
           this.precioEdificar == otraCasilla.getPrecioEdificar()){
            return true;
        }else{
            return false;
        }
    }
    
    public String toString(){
        return nombre + ", " +
               "Precios: Compra: " + precioCompra + ", " +
               "Edificar: " + precioEdificar + ", " +
               "Alquiler base: " + precioBaseAlquiler + ", " +
               "Casas: " + numCasas + ", " +
               "Hoteles: " + numHoteles;
    }
}
