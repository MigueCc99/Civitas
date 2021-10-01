package civitas;

import java.util.Random;

/**
 *
 * @author miguecc99
 */
public class Dado {
    static final private Dado instance = new Dado();
    
    private Random random;
    private int ultimoResultado;
    private boolean debug;
    
    static public Dado getInstance (){
        return instance;
    }
    
    private Dado (){
        debug = false;
        ultimoResultado = 0;
        random = new Random();
    }
    
    int tirar (){
        if(debug)
            ultimoResultado = 1;
        else
            ultimoResultado = random.nextInt(1,6);
            
        return ultimoResultado;
    }
    
    int quienEmpieza (int n){
        return random.nextInt(0,n);
    }
    
    void setDebug (boolean d){
        debug = d;
        if(debug)
            Diario.getInstance().ocurreEvento("Dado en modo debug!!!");
        else
            Diario.getInstance().ocurreEvento("Dado en modo normal!!!");
    }
    
    int getUltimoResultado (){
        return ultimoResultado;
    }
    
}
