package civitas;

import java.util.ArrayList;

/**
 *
 * @author miguecc99
 */
public class CasillaCalle extends Casilla{
    private static float FACTORALQUILERCALLE = 1.0f;  
    private static float FACTORALQUILERCASA = 1.0f;
    private static float FACTORALQUILERHOTEL = 1.0f;
    
    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private int numCasas, numHoteles;
    
    private Jugador propietario;
    
    private void init (){
        this.propietario = null;
    }
    
    CasillaCalle (String titulo, float precioCompra, float precioEdificar, float precioBaseAlquiler){
        super(titulo);
        init();
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
    }
    
    public int cantidadCasasHoteles (){
        return numCasas + numHoteles;
    }
    
    float getPrecioCompra (){
        return precioCompra;
    }
    
    float getPrecioEdificar (){
        return precioEdificar;
    }
    
    float getPrecioBaseAlquiler (){
        return precioBaseAlquiler;
    }
    
    float getPrecioAlquilerCompleto (){
        return FACTORALQUILERCALLE*precioBaseAlquiler*(1 + FACTORALQUILERCASA*numCasas + FACTORALQUILERHOTEL*numHoteles);
    }
    
    int getNumCasas (){
        return numCasas;
    }
    
    int getNumHoteles (){
        return numHoteles;
    }
    
    boolean comprar (Jugador jugador){
        propietario = jugador;
        jugador.paga(getPrecioCompra());
        return true;
    }
    
    boolean construirCasa (Jugador jugador){
        numCasas++;
        return true;
    }
    
    boolean construirHotel (Jugador jugador){
        numHoteles++;
        return true;
    }
    
    boolean derruirCasas (int numero, Jugador jugador){
        if(esEsteElPropietario(jugador) && getNumCasas() >= numero){
            numCasas--;
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean esEsteElPropietario (Jugador jugador){
        return propietario == jugador;
    }
    
    @Override
    void recibeJugador (int iactual, ArrayList<Jugador> todos){
        super.recibeJugador(iactual, todos);
        
        Jugador jugador = todos.get(iactual);
        
        if(!tienePropietario())
            jugador.puedeComprarCasilla();
        else
            tramitarAlquiler(jugador);
    }
    
    public boolean tienePropietario (){
        if(propietario != null)
            return true;
        else
            return false;
    }
    
    public void tramitarAlquiler (Jugador jugador){
        if(tienePropietario() && !esEsteElPropietario(jugador)){
            jugador.pagaAlquiler(getPrecioAlquilerCompleto());
            propietario.recibe(getPrecioAlquilerCompleto());
        }
    }

    public boolean igualEstado (CasillaCalle otraCasilla){
        if( super.igualEstado(otraCasilla) &&
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
    
    public void actualizaPropietarioPorConversión (Jugador propietarioConversion){
        propietario = propietarioConversion;
    }
    
    public String toString(){
        String str = super.toString() +
                     "Precios: Compra: " + precioCompra + ", " +
                     "Edificar: " + precioEdificar + ", " +
                     "Alquiler base: " + precioBaseAlquiler + ", " +
                     "Casas: " + numCasas + ", " +
                     "Hoteles: " + numHoteles;
        
        if(tienePropietario())
            str += ", Propietario: " + propietario.getNombre();
        
        return str;
    }

    public static void main(String[] args){
        CasillaCalle casillaCalle = new CasillaCalle ("Calle Pedro Antonio", 1200, 500, 400);
        
        CasillaCalle casillaCopia = casillaCalle;
        
        System.out.println(casillaCalle.toString());
    }
}
