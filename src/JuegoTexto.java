

import civitas.CivitasJuego;
import controladorCivitas.Controlador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import vistaTextualCivitas.VistaTextual;

/**
 *
 * @author miguecc99
 */
public class JuegoTexto {
    public static void main(String[] args){      
        CivitasJuego juego = new CivitasJuego (new ArrayList<String>(Arrays.asList("Miguel Ángel", "María", "Jose", "Carmen")), false);
        VistaTextual vista = new VistaTextual(juego);
        Controlador controlador = new Controlador(juego, vista);
        
        controlador.juega();
    }
}
