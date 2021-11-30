package civitas;

import java.util.ArrayList;

/**
 *
 * @author miguecc99
 */
public class SorpresaPagarCobrar extends Sorpresa{
    protected int valor;
    
    SorpresaPagarCobrar(String texto, int valor){
        super(texto);
        this.valor = valor;
    }
    
    @Override
    void aplicarAJugador (int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
        todos.get(actual).modificarSaldo(valor);
    }
}
