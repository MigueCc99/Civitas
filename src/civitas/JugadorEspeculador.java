package civitas;

import java.util.ArrayList;

/**
 *
 * @author miguecc99
 */
public class JugadorEspeculador extends Jugador{
    private static int FactorEspeculador = 2;
        
    protected JugadorEspeculador (Jugador jugadorEspeculador){
        super(jugadorEspeculador);
        actualizaPropiedadesPorConversion();
    }
    
    @Override
    boolean paga (float cantidad){
        return modificarSaldo((cantidad*-1)/2);  
    }
    
    void actualizaPropiedadesPorConversion (){
        for(CasillaCalle propiedad: getPropiedades()){
            propiedad.actualizaPropietarioPorConversión(this);
        }
    }
    
    @Override
    protected int getCasasMax (){
        return super.getHotelesMax()*2;
    }
    
    @Override
    protected int getHotelesMax (){
        return super.getHotelesMax()*2;
    }
    
    @Override
    public String toString (){
        String str = "Es un Jugador Especulador\n" + super.toString();
        
        return str;
    }
    
    public static void main(String[] args){
        /*
            1. Creamos un Jugador
            2. Creamos un Jugador Copia
        */
        Jugador jugador = new Jugador("Miguel Ángel");
        JugadorEspeculador jugadorEspeculadorCopia = new JugadorEspeculador(jugador);
        
        
        System.out.println(jugador.toString());
        System.out.println(jugadorEspeculadorCopia.toString());     
    }
}
