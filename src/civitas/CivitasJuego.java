package civitas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author miguecc99
 */
public class CivitasJuego {
    private int indiceJugadorActual;
    
    private ArrayList<Jugador> jugadores;
    private EstadosJuego estado;
    private MazoSorpresas mazo;
    private Tablero tablero;
    private GestorEstados gestor;
    
    public CivitasJuego (ArrayList<String> nombres, boolean debug){
        for (String nombre: nombres)
            jugadores.add(new Jugador(nombre));
        
        gestor = new GestorEstados();
        gestor.estadoInicial();
        
        Dado.getInstance().setDebug(debug);
        
        indiceJugadorActual = Dado.getInstance().quienEmpieza(jugadores.size());
        
        mazo = new MazoSorpresas(debug);
        
        tablero = new Tablero ();
        
        inicializaMazoSorpresas ();
        inicializaTablero(mazo);
                
    }
    
    private void avanzaJugador (){
        Jugador jugadorActual = getJugadorActual();
        int posicionActual = jugadorActual.getCasillaActual();
        int tirada = Dado.getInstance().tirar();
        int posicionNueva = tablero.nuevaPosicion(posicionActual, tirada);
        Casilla casilla = tablero.getCasilla(posicionNueva);
        
        contabilizarPasosPorSalida();
        
        jugadorActual.moverACasilla(posicionNueva);
        
        casilla.recibeJugador(indiceJugadorActual, jugadores);        
    }
    
    public boolean comprar (){
        Jugador jugadorActual = getJugadorActual();
        int numCasilla = jugadorActual.getCasillaActual();
        Casilla casilla = tablero.getCasilla(numCasilla);
        
        return jugadorActual.comprar(casilla);
    }
    
    public boolean construirCasa (int ip){
        return getJugadorActual().construirCasa(ip);
    }
    
    public boolean construirHotel (int ip){
        return getJugadorActual().construirHotel(ip);
    }
    
    private void contabilizarPasosPorSalida (){
        if (tablero.computarPasoPorSalida())
            getJugadorActual().pasaPorSalida();
    }
    
    public boolean finalDelJuego (){
        for(Jugador jugador: jugadores)
            if(jugador.enBancarrota())
                return true;
        
        return false;
    }
    
    public int getIndiceJugadorActual (){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }
    
    public Jugador getJugadorActual (){
        return jugadores.get(indiceJugadorActual);
    }
    
    public ArrayList<Jugador> getJugadores (){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }
    
    public Tablero getTablero (){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }
    
    private void inicializaMazoSorpresas (){
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Multa por exceso de velocidad!", -500));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Multa por exibicionismo!", -2000));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Multa por exceso de atractivo!", -1500));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Has recibido la lotería de navidad!", 10000));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Has recibido un regalod de un anónimo!", 1500));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Has encontrado 500 euros en el suelo!", 500));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Pagas 500 euros por cada casa y hotel!", -500));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Pagas 1500 euros por cada casa y hotel!!", -1500));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Recibes 500 euros por cada casa y hotel!", 500));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Recibes 1500 euros por cada casa y hotel!", 1500));
    }
    
    private void inicializaTablero (MazoSorpresas mazo){
        tablero.añadeCasilla(new Casilla ("Calle San Matías", 15000, 10000, 5000));
        tablero.añadeCasilla(new Casilla ("Calle Gran Vía", 20000, 12000, 7500));
        tablero.añadeCasilla(new Casilla ("Calle Santiago Bernabeu", 30000, 13000, 8000));
        tablero.añadeCasilla(new Casilla ("Calle Periodista Fernando Gómez de la Cruz", 15000, 10000, 5000));
        tablero.añadeCasilla(new Casilla ("Calle Gonzalo Gallas", 10000, 7000, 5000));
        tablero.añadeCasilla(new Casilla ("Calle Pedro Antonio", 9000, 4000, 3000));
        tablero.añadeCasilla(new Casilla ("Calle Ganivet", 20000, 10000, 5000));
        tablero.añadeCasilla(new Casilla ("Calle Reyes Católicos", 20000, 14000, 8000));
        tablero.añadeCasilla(new Casilla ("Calle Tragofino", 8000, 5000, 2000));
        tablero.añadeCasilla(new Casilla ("Calle Duero", 17000, 13000, 2500));
        tablero.añadeCasilla(new Casilla ("Calle Guadalquivir", 20000, 10000, 5000));
        tablero.añadeCasilla(new Casilla ("Calle Bomba", 11000, 8000, 3400));
        tablero.añadeCasilla(new Casilla ("Calle Camino de Ronda", 20000, 10000, 5000));
        tablero.añadeCasilla(new Casilla ("Calle Real Madrid", 24000, 20000, 12000));
        tablero.añadeCasilla(new Casilla ("Sorpresa!!!", mazo));
        tablero.añadeCasilla(new Casilla ("Sorpresa!!!", mazo));
        tablero.añadeCasilla(new Casilla ("Sorpresa!!!", mazo));
        tablero.añadeCasilla(new Casilla ("Sorpresa!!!", mazo));
        tablero.añadeCasilla(new Casilla ("SALIDA"));
        tablero.añadeCasilla(new Casilla ("PARKING"));
    }
    
    private void pasarTurno (){
        indiceJugadorActual = (indiceJugadorActual+1)%jugadores.size();
    }
    
    private ArrayList<Jugador> ranking(){
        jugadores.sort((o1,o2) -> o1.compareTo(o2));
        Collections.reverse(jugadores);
        return jugadores;
    }
    
    public OperacionesJuego siguientePaso (){
        Jugador jugadorActual = getJugadorActual();
        OperacionesJuego operacion = gestor.siguienteOperacion(jugadorActual, estado);
        
        switch(operacion){
            case PASAR_TURNO:
                pasarTurno();
                siguientePasoCompletado(operacion);
            break;
            
            case AVANZAR:
                avanzaJugador();
                siguientePasoCompletado(operacion);
            break;
        }
        
        return operacion;
    }
    
    public void siguientePasoCompletado (OperacionesJuego operacion){
        estado = gestor.siguienteEstado(getJugadorActual(), estado, operacion);
    }
    
}
