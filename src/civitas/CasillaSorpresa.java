package civitas;

import java.util.ArrayList;

/**
 *
 * @author miguecc99
 */
public class CasillaSorpresa extends Casilla{
    private MazoSorpresas mazo;
    private Sorpresa sorpresa;
    
    private void init(){
        mazo = new MazoSorpresas();
        sorpresa = null;
    }
    
    public CasillaSorpresa(String nombre, MazoSorpresas mazo){
        super(nombre);
        init();
        this.mazo = mazo;
    }
    
    private void recibeJugador_sorpresa (int iactual, ArrayList<Jugador> todos){
        sorpresa = mazo.siguiente();
        informe(iactual, todos);
        sorpresa.aplicarAJugador(iactual, todos);
    }
    
    public String toString(){
        String str = super.toString() +
                     sorpresa.toString();
        
        return str;
    }
    
    public static void main(String[] args){
        MazoSorpresas mazo = new MazoSorpresas();
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Multa por exceso de velocidad!", 500));
        
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Miguel Ángel"));
    
        CasillaSorpresa casillaSorpresa = new CasillaSorpresa ("Sorpresa!!!", mazo);
        casillaSorpresa.recibeJugador_sorpresa(0, jugadores);
        
        System.out.println(casillaSorpresa.toString());
    }
}
