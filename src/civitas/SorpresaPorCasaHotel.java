package civitas;

import java.util.ArrayList;

/**
 *
 * @author miguecc99
 */
public class SorpresaPorCasaHotel extends Sorpresa{
    private int valor;
    
    SorpresaPorCasaHotel(String texto, int valor){
        super(texto);
        this.valor = valor;
    }

    @Override
    void aplicarAJugador (int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
        todos.get(actual).modificarSaldo(valor*todos.get(actual).cantidadCasasHoteles());
    }
}
