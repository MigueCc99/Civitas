package GUI;

import civitas.CivitasJuego;
import controladorCivitas.Controlador;
import java.util.ArrayList;

/**
 *
 * @author miguecc99
 */
public class TestP5 {

    public static void main(String[] args) {
        CivitasView vista = new CivitasView();
        CapturaNombres capturaNombres = new CapturaNombres(vista,true);
        ArrayList<String> nombres = capturaNombres.getNombres();
        CivitasJuego juego = new CivitasJuego(nombres, false);
        Controlador controlador = new Controlador(juego, vista);
        vista.setCivitasJuego(juego);  
        controlador.juega();
    }
    
}
