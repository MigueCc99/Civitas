package civitas;

import java.util.ArrayList;

/**
 *
 * @author miguecc99
 */
public class SorpresaConvertirme extends Sorpresa{
    
    SorpresaConvertirme(String texto){
        super(texto);
    }
    
    @Override
    void aplicarAJugador (int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
        JugadorEspeculador jugadorEspeculador = todos.get(actual).convertir();
        todos.set(actual, jugadorEspeculador);
    }
}
