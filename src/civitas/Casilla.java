package civitas;

import java.util.ArrayList;

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
    
    private MazoSorpresas mazo;
    private Jugador propietario;
    private Sorpresa sorpresa;
    
    private void init (){
        this.tipo = TipoCasilla.CALLE;
        this.nombre = "Casilla Por Defecto";
        this.numCasas = 0;
        this.numHoteles = 0;
        this.precioCompra = 0.0f;
        this.precioEdificar = 0.0f;
        this.precioBaseAlquiler = 0.0f;
        this.mazo = new MazoSorpresas();
        this.propietario = null;
        this.sorpresa = null;
    }
    
    Casilla (TipoCasilla tipo, String nombre, float precioCompra, float precioEdificar, float precioBaseAlquiler){
        init();
        this.tipo = tipo;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
    }
    
    Casilla (String nombre){
        this(TipoCasilla.DESCANSO, nombre, 0.0f, 0.0f, 0.0f);
    }
    
    Casilla (String titulo, float precioCompra, float precioEdificar, float precioBaseAlquiler){
        this(TipoCasilla.CALLE, titulo, precioCompra, precioEdificar, precioBaseAlquiler);
    }
    
    Casilla (String nombre, MazoSorpresas mazo){
        this(TipoCasilla.SORPRESA, nombre, 0, 0, 0);
        this.mazo = mazo;
    }
    
    public int cantidadCasasHoteles (){
        return numCasas + numHoteles;
    }
    
    public String getNombre (){
        return nombre;
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
    
    void informe (int iactual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("El jugador " + todos.get(iactual).getNombre() + " ha caido en la casilla " + this.toString());
    }
    
    void recibeJugador (int iactual, ArrayList<Jugador> todos){
        switch(tipo){
            case CALLE:
                recibeJugador_calle(iactual, todos);
            break;
            case SORPRESA:
                recibeJugador_sorpresa(iactual, todos);
            break;
            case DESCANSO:
                informe(iactual, todos);
            break;
        }
    }
    
    private void recibeJugador_calle (int iactual, ArrayList<Jugador> todos){
        informe(iactual, todos);
        
        Jugador jugador = todos.get(iactual);
        
        if(!tienePropietario())
            jugador.puedeComprarCasilla();
        else
            tramitarAlquiler(jugador);
    }
   
    private void recibeJugador_sorpresa (int iactual, ArrayList<Jugador> todos){
        Sorpresa sorpresa = mazo.siguiente();
        informe(iactual, todos);
        sorpresa.aplicarAJugador(iactual, todos);
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
    
    @Override
    public String toString(){
        String str = "Nombre: " + nombre + ", " +
                     "Tipo de Casilla: " + tipo + ", " +
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
        /*
            1. Creamos una casilla de tipo DESCANSO
            2. Creamos un par de casillas de tipo CALLE
            3. Creamos una casilla de tipo SORPRESA
        */
        Casilla casillaDescanso = new Casilla("DESCANSO");
        
        Casilla casillaCalle1 = new Casilla ("Calle San Matías", 15000, 10000, 5000);
        Casilla casillaCalle2 = new Casilla ("Calle Gran Vía", 20000, 7500, 3400);   
        
        Casilla casillaSorpresa = new Casilla ("Sorpresa 1", new MazoSorpresas());
        
        System.out.println(casillaDescanso.toString());
        System.out.println(casillaCalle1.toString());
        System.out.println(casillaCalle2.toString());
        System.out.println(casillaSorpresa.toString());
    }
}
