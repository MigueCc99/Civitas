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
    
    public int tirar (){
        if(debug)
            ultimoResultado = 1;
        else
            ultimoResultado = random.nextInt(1,7);
            
        return ultimoResultado;
    }
    
    public int quienEmpieza (int n){
        ultimoResultado = random.nextInt(0,n);
        return ultimoResultado;
    }
    
    public void setDebug (boolean d){
        debug = d;
        if(debug)
            Diario.getInstance().ocurreEvento("Dado en modo debug!!!");
        else
            Diario.getInstance().ocurreEvento("Dado en modo normal!!!");
    }
    
    public boolean getDebug (){
        return debug;
    }
    
    public int getUltimoResultado (){
        return ultimoResultado;
    }
    
    public static void main (String[] args){
        System.out.println("NORMAL MODE");
        for(int i=0; i<10; i++){
            System.out.println("Tirada " + i + ": "+ Dado.getInstance().tirar());
            System.out.println("Quien empieza: " + Dado.getInstance().quienEmpieza(4));           
        }        
        System.out.println("Ultimo resultado: " + Dado.getInstance().getUltimoResultado());
        
        System.out.println("DEBUG MODE");
        Dado.getInstance().setDebug(true);
        
        for(int i=0; i<10; i++){
            System.out.println("Tirada " + i + ": "+ Dado.getInstance().tirar());
            System.out.println("Quien empieza: " + Dado.getInstance().quienEmpieza(4));           
        }        
        System.out.println("Ultimo resultado: " + Dado.getInstance().getUltimoResultado());
    }
}
