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
        Diario.getInstance().ocurreEvento("La sorpresa " + texto + " se ha apliado al jugador " + todos.get(actual).getNombre());
    }
    
    public String toString (){
        return texto; 
    }
}
