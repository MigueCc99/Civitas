package civitas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author miguecc99
 */
public class CivitasJuego {
    private int indiceJugadorActual;
    
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private EstadoJuego estado;
    private MazoSorpresas mazo;
    private Tablero tablero;
    private GestorEstados gestor;
    
    public CivitasJuego (ArrayList<String> nombres, boolean debug){
        for (String nombre: nombres)
            jugadores.add(new Jugador(nombre));
        
        gestor = new GestorEstados();
        estado = gestor.estadoInicial();
        
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
        CasillaCalle casilla = (CasillaCalle)tablero.getCasilla(numCasilla);
        
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
        return indiceJugadorActual;
    }
    
    public Jugador getJugadorActual (){
        return jugadores.get(getIndiceJugadorActual());
    }
    
    public ArrayList<Jugador> getJugadores (){
        return jugadores;
    }
    
    public Tablero getTablero (){
        return tablero;
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
        tablero.añadeCasilla(new Casilla ("SALIDA"));
        tablero.añadeCasilla(new CasillaCalle ("Calle San Matías", 1500, 1000, 500));
        tablero.añadeCasilla(new CasillaCalle ("Calle Gran Vía", 1000, 1000, 750));
        tablero.añadeCasilla(new CasillaCalle ("Calle Santiago Bernabeu", 4000, 2000, 1500));
        tablero.añadeCasilla(new CasillaCalle ("Calle Periodista Fernando Gómez de la Cruz", 3000, 1500, 1250));
        tablero.añadeCasilla(new CasillaSorpresa ("Sorpresa!!!", mazo));
        tablero.añadeCasilla(new CasillaCalle ("Calle Gonzalo Gallas", 2000, 1700, 1500));
        tablero.añadeCasilla(new CasillaCalle ("Calle Pedro Antonio", 1200, 500, 400));
        tablero.añadeCasilla(new CasillaCalle ("Calle Ganivet", 4500, 300, 600));
        tablero.añadeCasilla(new CasillaCalle ("Calle Reyes Católicos", 7000, 1000, 1500));
        tablero.añadeCasilla(new CasillaSorpresa ("Sorpresa!!!", mazo));
        tablero.añadeCasilla(new CasillaCalle ("Calle Tragofino", 5000, 5000, 2000));
        tablero.añadeCasilla(new CasillaCalle ("Calle Duero", 1700, 1000, 1200));
        tablero.añadeCasilla(new Casilla ("PARKING"));
        tablero.añadeCasilla(new CasillaCalle ("Calle Guadalquivir", 3500, 560, 700));
        tablero.añadeCasilla(new CasillaCalle ("Calle Bomba", 1100, 1000, 900));
        tablero.añadeCasilla(new CasillaSorpresa ("Sorpresa!!!", mazo));
        tablero.añadeCasilla(new CasillaCalle ("Calle Camino de Ronda", 2000, 540, 800));
        tablero.añadeCasilla(new CasillaCalle ("Calle Real Madrid", 9000, 4000, 1000));
    }
    
    private void pasarTurno (){
        indiceJugadorActual = (indiceJugadorActual+1)%jugadores.size();
    }
    
    private ArrayList<Jugador> ranking(){
        jugadores.sort((o1,o2) -> o1.compareTo(o2));
        Collections.reverse(jugadores);
        return jugadores;
    }
    
    public OperacionJuego siguientePaso (){
        Jugador jugadorActual = getJugadorActual();
        OperacionJuego operacion = gestor.siguienteOperacion(jugadorActual, estado);
        
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
    
    public void siguientePasoCompletado (OperacionJuego operacion){
        estado = gestor.siguienteEstado(getJugadorActual(), estado, operacion);
    }
    
}
