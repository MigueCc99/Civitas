package civitas;

import java.util.ArrayList;

/**
 *
 * @author miguecc99
 */
public class Jugador implements Comparable<Jugador> {
    private static int CasasMax = 4;
    private static int CasasPorHotel = 4;
    private static int HotelesMax = 4;
    private static float PasoPorSalida = 1000;
    private static float SaldoInicial = 7500;
    
    private int casillaActual;
    private String nombre;
    private boolean puedeComprar;
    private float saldo;
    
    private ArrayList<CasillaCalle> propiedades;
    
    Jugador (String nombre){
        this.casillaActual = 0;
        this.nombre = nombre;
        this.puedeComprar = true;
        this.saldo = SaldoInicial;
        this.propiedades = new ArrayList<CasillaCalle>();
    }
    
    protected Jugador (Jugador otro){
        this.casillaActual = this.casillaActual;
        this.nombre = otro.nombre;
        this.puedeComprar = otro.puedeComprar;
        this.saldo = otro.saldo;
        this.propiedades = otro.propiedades;
        
    }
    
    int cantidadCasasHoteles (){
        int cantidad = 0;
        for(CasillaCalle propiedad: propiedades){
            cantidad += propiedad.cantidadCasasHoteles();
        }
        return cantidad;
    }
    
    @Override
    public int compareTo (Jugador otro){
        return Float.compare(this.saldo, otro.saldo);
    }
    
    boolean comprar (CasillaCalle titulo){
        boolean result = false;
        
        if(puedeComprar){
            float precio = titulo.getPrecioCompra();
            if(puedoGastar(precio)){
                result = titulo.comprar(this);
                propiedades.add(titulo);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " compra la propiedad " + titulo.getNombre());
                puedeComprar = false;
            }
            else{
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " no tiene saldo para comprar la propiedad " + titulo.getNombre());
            }
        }  
        
        return result;
    }
    
    boolean construirCasa (int ip){
        boolean result = false;
        
        if(existeLaPropiedad(ip)){
            CasillaCalle propiedad = propiedades.get(ip);
            boolean puedoEdificarCasa = puedoEdificarCasa(propiedad);
            float precio = propiedad.getPrecioEdificar();
            
            if(puedoGastar(precio) && propiedad.getNumCasas() < getCasasMax())
                puedoEdificarCasa = true;
            
            if(puedoEdificarCasa){
                result = propiedad.construirCasa(this);
                paga(precio);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " construye casa en la propiedad " + propiedad.getNombre());
            }
        }
       
        return result;
    }
    
    boolean construirHotel (int ip){
        boolean result = false;
        
        if(existeLaPropiedad(ip)){
            CasillaCalle propiedad = propiedades.get(ip);
            boolean puedoEdificarHotel = puedoEdificarhotel(propiedad);
            float precio = propiedad.getPrecioEdificar();
            
            if(puedoGastar(precio)){
                if(propiedad.getNumHoteles() < getHotelesMax() &&
                   propiedad.getNumCasas() >= getCasasPorHotel())
                    puedoEdificarHotel = true;
            }
            
            if(puedoEdificarHotel){
                result = propiedad.construirHotel(this);
                propiedad.derruirCasas(CasasPorHotel, this);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " construye hotel en la propiedad " + propiedad.getNombre());
            }
        }
        
        return result;
    }
    
    boolean enBancarrota (){
        return saldo <= 0;  
    }
    
    private boolean existeLaPropiedad (int ip){
        return 0 <= ip && ip <= propiedades.size();
    }
    
    protected int getCasasMax (){
        return CasasMax;
    }
    
    static int getCasasPorHotel (){
        return CasasPorHotel;
    }
    
    public int getCasillaActual (){
        return casillaActual;
    }
    
    protected int getHotelesMax (){
        return HotelesMax;
    }
    
    protected String getNombre (){
        return nombre;
    }
    
    private static float getPremioPasoSalida (){
        return PasoPorSalida;
    }
    
    public ArrayList<CasillaCalle> getPropiedades (){
        return propiedades;
    }
    
    boolean getPuedeComprar (){
        return puedeComprar;
    }
    
    protected float getSaldo (){
        return saldo;
    }
    
    boolean modificarSaldo (float cantidad){
        saldo += cantidad;
        Diario.getInstance().ocurreEvento("El saldo del jugador " + nombre + " ha sido modificado por una cantidad de " + cantidad);
        return true;
    }
    
    boolean moverACasilla (int numCasilla){
        casillaActual = numCasilla;
        puedeComprar = false;
        Diario.getInstance().ocurreEvento("El jugador " + nombre + " se ha movido a la casilla número " + casillaActual);
        return true;
    }
    
    boolean paga (float cantidad){
        return modificarSaldo(cantidad*-1);  
    }
    
    boolean pagaAlquiler (float cantidad){
        return paga(cantidad);  
    }
    
    boolean pasaPorSalida (){
        recibe(PasoPorSalida);
        Diario.getInstance().ocurreEvento("El jugador " + nombre + " ha pasado por la salida y ha recibido un premio de " + PasoPorSalida);
        return true;
    }
    
    boolean puedeComprarCasilla (){
        puedeComprar = true;
        return puedeComprar;
    }
    
    private boolean puedoEdificarCasa (CasillaCalle propiedad){
        return puedoGastar(propiedad.getPrecioEdificar()) && propiedad.getNumHoteles() < CasasMax && propiedad.getNumHoteles() >= CasasPorHotel;
    }
    
    private boolean puedoEdificarhotel (CasillaCalle propiedad){
        return puedoGastar(propiedad.getPrecioEdificar()) && propiedad.getNumHoteles() < HotelesMax && propiedad.getNumCasas() >= CasasPorHotel;  
    }
    
    private boolean puedoGastar (float precio){
        return saldo >= precio;
    }
    
    boolean recibe (float cantidad){
        return modificarSaldo(cantidad);
    }
    
    boolean tieneAlgoQueGestionar (){
        return propiedades.size() > 0;
    }
    
    JugadorEspeculador convertir (){
        return new JugadorEspeculador(this);
    }
    
    @Override
    public String toString (){
        String str = "Nombre: " + nombre + ", " +
                     "Casilla Actual: " + casillaActual + ", " +
                     "Saldo: " + saldo;
        
        if(puedeComprar)
            str += ", ¿Puede Comprar?: Sí";
        else
            str += ", ¿Puede Comprar?: No";
                     
        str += "\nPropiedades del jugador: \n";
        
        for (CasillaCalle propiedad: propiedades)
            str += propiedad.toString() + "\n";
        
        return str;
    }
    
    public static void main(String[] args){
        /*
            1. Creamos un Jugador
            2. Creamos un Jugador Copia
        */
        Jugador jugador = new Jugador("Miguel Ángel");
        Jugador jugadorCopia = new Jugador(jugador);
        
        System.out.println(jugador.toString());
        System.out.println(jugadorCopia.toString());
        
        int compare = jugador.compareTo(jugadorCopia);
        if(compare > 0){
            System.out.println("El jugador " + jugador.getNombre() + " es mayor que el jugador " + jugadorCopia.getNombre());
        }
        else if(compare < 0){
            System.out.println("El jugador " + jugador.getNombre() + " es menor que el jugador " + jugadorCopia.getNombre());
        }else{
            System.out.println("El jugador " + jugador.getNombre() + " es igual que el jugador " + jugadorCopia.getNombre());
        }
    }
    
}
