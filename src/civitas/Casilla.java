package civitas;

import java.util.ArrayList;

/**
 *
 * @author miguecc99
 */
public class Casilla {        
    private String nombre;
    
    private void init (){
        this.nombre = "Casilla Por Defecto";
    }
    
    Casilla (String nombre){
        init();
        this.nombre = nombre;
    }
    
    public String getNombre (){
        return nombre;
    }
    
    void informe (int iactual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("El jugador " + todos.get(iactual).getNombre() + " ha caido en la casilla " + this.toString());
    }
    
    void recibeJugador (int iactual, ArrayList<Jugador> todos){
        informe(iactual, todos);
    }
        
    public boolean igualdadIdentidad (Casilla otraCasilla){
        return this == otraCasilla;
    }
    
    public boolean igualEstado (Casilla otraCasilla){
        if(this.nombre.equals(otraCasilla.getNombre())){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        String str = "Nombre: " + nombre + ", ";
        
        return str;
    }
    
    public static void main(String[] args){
        Casilla casillaDescanso = new Casilla("DESCANSO");
        
        System.out.println(casillaDescanso.toString());
    }
}
