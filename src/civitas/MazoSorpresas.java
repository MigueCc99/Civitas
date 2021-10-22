package civitas;

import java.util.ArrayList;
import static java.util.Collections.shuffle;

/**
 *
 * @author miguecc99
 */
public class MazoSorpresas {
    private ArrayList<Sorpresa> sorpresas;
    private boolean barajada;
    private int usadas;
    private boolean debug;
    
    private void init (){
        sorpresas = new ArrayList<Sorpresa>();
        barajada = false;
        usadas = 0;
    }
    
    MazoSorpresas (boolean debug){
        init();
        this.debug = debug;
        if (this.debug)
            Diario.getInstance().ocurreEvento("Modo debug activado!!!");
    }
    
    MazoSorpresas (){
        init();
        debug = false;
    }
    
    void alMazo (Sorpresa s){
        if(!barajada)
            sorpresas.add(s);
    }
    
    Sorpresa siguiente (){
        Sorpresa s = new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Sorpresa Por Defecto", 0);
        if(!barajada && usadas == sorpresas.size()){
            if(!debug){
                shuffle(sorpresas);
            }
            usadas = 0;
            barajada = true;
            usadas++;
            s = sorpresas.get(0);
            sorpresas.remove(0);
            sorpresas.add(s);
        }
        return s;   
    }
    
}
