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
        Sorpresa s = new SorpresaPagarCobrar("Sorpresa Por Defecto", 0);
        if(!barajada || usadas == sorpresas.size()){
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
    
    public static void main (String[] args){
        MazoSorpresas mazo = new MazoSorpresas();
        mazo.alMazo(new SorpresaPagarCobrar("Multa por exceso de velocidad!", 500));
        mazo.alMazo(new SorpresaPagarCobrar("Multa por fiesta ilegal!", 1000));
        
        System.out.println("Siguiente 1");
        System.out.println(mazo.siguiente().toString());
        for(int i=0; i<mazo.sorpresas.size(); i++)
           System.out.println(mazo.sorpresas.get(i)); 
        System.out.println("Siguiente 2");
        System.out.println(mazo.siguiente().toString());
        for(int i=0; i<mazo.sorpresas.size(); i++)
           System.out.println(mazo.sorpresas.get(i));
    }
    
}
