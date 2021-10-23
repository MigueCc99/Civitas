package civitas;

import java.util.ArrayList;

/**
 *
 * @author miguecc99
 */
public class Sorpresa {
    private String texto;
    private int valor;
    
    private TipoSorpresa tipo;
    
    Sorpresa (TipoSorpresa tipo, String texto, int valor){
        this.tipo = tipo;
        this.texto = texto;
        this.valor = valor;
    }
    
    void aplicarAJugador (int actual, ArrayList<Jugador> todos){
        if(TipoSorpresa.PAGARCOBRAR == tipo){
            aplicarAJugador_pagarCobrar(actual, todos);
        }
        else if(TipoSorpresa.PORCASAHOTEL == tipo){
            aplicarAJugador_porCasaHotel(actual, todos);
        }
    }
    
    private void aplicarAJugador_pagarCobrar (int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
        todos.get(actual).modificaSaldo(valor);
    }
    
    private void aplicarAJugador_porCasaHotel (int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
        todos.get(actual).modificaSaldo(valor*todos.get(actual).cantidadCasasHoteles());
    }
    
    private void informe (int actual, ArrayList<Jugador> todos){
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
        Sorpresa sorpresaPagarCobrar = new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Multa por exceso de velocidad!", 500);
        
        System.out.println("toString de Jugador");
        System.out.println(jugador.toString());
        System.out.println("toString de Sorpresa");
        System.out.println(sorpresaPagarCobrar.toString());
        
        sorpresaPagarCobrar.aplicarAJugador(0, jugadores);
        System.out.println(Diario.getInstance().getEventos().get(0));

    }
}
