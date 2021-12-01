package civitas;

import java.util.ArrayList;

/**
 *
 * @author miguecc99
 */
public class TestP4 {

    public static void main(String[] args) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Miguel Ángel"));
        jugadores.get(0).comprar(new CasillaCalle ("Calle Santiago Bernabeu", 4000, 2000, 1500));
        
        
        System.out.println("Jugador normal: " + jugadores.get(0).toString() + "\n");
        
        System.out.println("Convertimos el jugador a jugadorEspeculador!!!\n");
        
        SorpresaConvertirme sorpresaConvertirme = new SorpresaConvertirme("Se convierte a especulador!!!");
        
        sorpresaConvertirme.aplicarAJugador(0, jugadores);
        
        System.out.println("Jugador especulador: " + jugadores.get(0).toString() + "\n");
    }
    
}
