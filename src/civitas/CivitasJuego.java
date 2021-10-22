package civitas;

import java.util.ArrayList;

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
        
    }
    
    public boolean comprar (){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
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
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }
    
    private void inicializaTablero (MazoSorpresas mazo){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }
    
    private void pasarTurno (){
        indiceJugadorActual = (indiceJugadorActual+1)%jugadores.size();
    }
    
    private ArrayList<Jugador> ranking(){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }
    
    public OperacionesJuego siguientePaso (){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }
    
    public void siguientePasoCompletado (OperacionesJuego operacion){
        estado = gestor.siguienteEstado(getJugadorActual(), estado, operacion);
    }
    
}
