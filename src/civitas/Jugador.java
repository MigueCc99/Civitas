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
    
    private ArrayList<Casilla> propiedades;
    
    Jugador (String nombre){
        this.nombre = nombre;
        this.propiedades = new ArrayList<Casilla>();
        this.puedeComprar = true;
        this.saldo = 0;
    }
    
    protected Jugador (Jugador otro){
        this.nombre = otro.nombre;
        this.propiedades = otro.propiedades;
        this.puedeComprar = otro.puedeComprar;
        this.saldo = otro.saldo;
    }
    
    int cantidadCasasHoteles (){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");  
    }
    
    @Override
    public int compareTo (Jugador otro){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");  
    }
    
    boolean comprar (Casilla titulo){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");  
    }
    
    boolean construirCasa (int ip){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");  
    }
    
    boolean construirHotel (int ip){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");  
    }
    
    boolean enBancarrota (){
        return saldo <= 0;  
    }
    
    private boolean existeLaPropiedad (int ip){
        return 0 <= ip && ip <= propiedades.size();
    }
    
    private int getCasasMax (){
        return CasasMax;
    }
    
    int getCasasPorHotel (){
        return CasasPorHotel;
    }
    
    int getCasillaActual (){
        return casillaActual;
    }
    
    private int getHotelesMax (){
        return HotelesMax;
    }
    
    protected String getNombre (){
        return nombre;
    }
    
    private float getPremioPasoSalida (){
        return PasoPorSalida;
    }
    
    protected ArrayList<Casilla> getPropiedades (){
        return propiedades;
    }
    
    boolean getPuedeComprar (){
        return puedeComprar;
    }
    
    protected float getSaldo (){
        return saldo;
    }
    
    boolean modificaSaldo (float cantidad){
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
        return modificaSaldo(cantidad*-1);  
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
    
    private boolean puedoEdificarCasa (Casilla propiedad){
        return puedoGastar(propiedad.getPrecioEdificar()) && propiedad.getNumHoteles() < CasasMax && propiedad.getNumHoteles() >= CasasPorHotel;
    }
    
    private boolean puedoEdificarhotel (Casilla propiedad){
        return puedoGastar(propiedad.getPrecioEdificar()) && propiedad.getNumHoteles() < HotelesMax && propiedad.getNumCasas() >= CasasPorHotel;  
    }
    
    private boolean puedoGastar (float precio){
        return saldo >= precio;
    }
    
    boolean recibe (float cantidad){
        return modificaSaldo(cantidad);
    }
    
    boolean tieneAlgoQueGestionar (){
        return propiedades.size() > 0;
    }
    
    @Override
    public String toString (){
        String str = "Nombre: " + nombre + ", " +
                     "Casilla Actual: " + casillaActual + ", " +
                     "Saldo: " + saldo;
        
        if(puedeComprar)
            str += ", ¿Puede Comprar?: Sí, ";
        else
            str += ", ¿Puede Comprar?: No, ";
                     
        return str;
    }
    
}
