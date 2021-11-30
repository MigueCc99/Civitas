package civitas;

import java.util.ArrayList;

/**
 *
 * @author miguecc99
 */
public abstract class Sorpresa {
    protected String texto;
    
    Sorpresa (String texto){
        this.texto = texto;
    }
    
    abstract void aplicarAJugador (int actual, ArrayList<Jugador> todos);
    
    protected void informe (int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("La sorpresa " + texto + " se ha aplicado al jugador " + todos.get(actual).getNombre());
    }
    
    @Override
    public String toString (){
        return texto; 
    }
    
    public static void main(String[] args){
        /*
            1. Creamos un Jugador
            2. Creamos Sorpresas
            3. Aplicamos Sorpresas al jugador
        */
        Jugador jugador = new Jugador("Miguel Ángel");
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);
        Sorpresa sorpresaPagarCobrar = new SorpresaPagarCobrar("Multa por exceso de velocidad!", -500);
        
        System.out.println("toString de Jugador");
        System.out.println(jugador.toString());
        System.out.println("toString de Sorpresa");
        System.out.println(sorpresaPagarCobrar.toString());
        
        sorpresaPagarCobrar.aplicarAJugador(0, jugadores);
        System.out.println(Diario.getInstance().getEventos().get(0));
        
        System.out.println("\ntoString de Jugador después de recibir la multa");
        System.out.println(jugadores.get(0).toString());
    }
}
