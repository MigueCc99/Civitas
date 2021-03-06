package civitas;

import java.util.ArrayList;

/**
 *
 * @author miguecc99
 */
public class Tablero {
    private ArrayList<Casilla> casillas;
    private boolean porSalida;
    
    public Tablero (){
        casillas = new ArrayList<Casilla>();
        porSalida = false;
    }
    
    private boolean correcto (int numCasilla){
        if(numCasilla >= 0 && numCasilla < casillas.size())
            return true;
        else
            return false;
    }
    
    boolean computarPasoPorSalida (){
        boolean porSalidaOld = porSalida;
        porSalida = false;
        return porSalidaOld;
    }
    
    void añadeCasilla (Casilla casilla){
        casillas.add(casilla);
    }
    
    public Casilla getCasilla (int numCasilla){
        return casillas.get(numCasilla);
    }
    
    public ArrayList<Casilla> getCasilllas (){
        return casillas;
    }
    
    int nuevaPosicion (int actual, int tirada){
        int newPos = (actual+tirada)%casillas.size();
        
        if(newPos != actual + tirada)
            porSalida = true;
        
        return newPos;
    }
    
}
