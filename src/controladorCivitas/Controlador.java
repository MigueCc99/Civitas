package controladorCivitas;

import civitas.CivitasJuego;
import civitas.GestionInmobiliaria;
import civitas.OperacionInmobiliaria;
import civitas.OperacionJuego;
import vistaTextualCivitas.VistaTextual;

/**
 *
 * @author miguecc99
 */
public class Controlador {
    private CivitasJuego juego;
    private VistaTextual vista;
    
    public Controlador (CivitasJuego juego, VistaTextual vista){
        this.juego = juego;
        this.vista = vista;
    }
    
    public void juega (){
        Respuesta respuesta = null;
        
        while(!juego.finalDelJuego()){
            vista.actualiza();
            vista.pausa();
            OperacionJuego operacionJ =juego.siguientePaso();
            vista.mostrarSiguienteOperacion(operacionJ);
            
            if(operacionJ != OperacionJuego.PASAR_TURNO)
                vista.mostrarEventos();
            
            if(!juego.finalDelJuego()){
                switch(operacionJ){
                    case COMPRAR:
                        respuesta = vista.comprar();
                        
                        if(respuesta == Respuesta.SI){
                            juego.comprar();
                            juego.siguientePasoCompletado(operacionJ);                            
                        }
                    break;
                    case GESTIONAR:
                        OperacionInmobiliaria operacionI = vista.elegirOperacion();
                        int propiedad = vista.elegirPropiedad();
                        GestionInmobiliaria gestion = new GestionInmobiliaria(operacionI, propiedad);
                        
                        switch (operacionI){
                            case TERMINAR:
                                juego.siguientePasoCompletado(operacionJ);
                            break;
                            case CONSTRUIR_CASA:
                                juego.construirCasa(gestion.getPropiedad());
                            break;
                            case CONSTRUIR_HOTEL:
                                juego.construirHotel(gestion.getPropiedad());
                            break;     
                        }
                    break;
                }
            }            
            //ArrayList<Jugador> jugadoresRanking = juego.ranking();
            vista.actualiza();
        }
    }
}

