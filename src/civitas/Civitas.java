package civitas;

import java.util.ArrayList;

/**
 *
 * @author miguecc99
 */
public class Civitas {

    public static void main(String[] args) {
        ArrayList<Integer> valores = new ArrayList<Integer>(){{
        add(0);
        add(0);
        add(0);
        add(0);
        }};

        int valor = 0;
        Dado.getInstance().setDebug(true);
        Tablero tablero = new Tablero();
        
        for(int i=0; i<100; i++){
            valor = Dado.getInstance().quienEmpieza(4);
            valores.set(valor, valores.get(valor)+1);
        }
        
        System.out.println("Tenemos 4 jugadores y sorteamos 100 veces con el dado quien empieza la partida!!!");
        System.out.println("*********************************************************************************");
        System.out.println("Jugador 1 comienza: " + valores.get(0) + " veces.");
        System.out.println("Jugador 2 comienza: " + valores.get(1) + " veces.");
        System.out.println("Jugador 3 comienza: " + valores.get(2) + " veces.");
        System.out.println("Jugador 4 comienza: " + valores.get(3) + " veces.");
        
        System.out.println("\nÚltimo resultado del dado: " + Dado.getInstance().getUltimoResultado());
        
        System.out.println("\nElementos de cada enumerado!!!");
        System.out.println("*********************************************************************************");
        System.out.println("EstadosJuego: " + EstadoJuego.INICIO_TURNO);
        System.out.println("EstadosJuego: " + TipoSorpresa.PAGARCOBRAR);
        
        tablero.añadeCasilla(new CasillaCalle("Calle Castellana", 150000, 10000, 15000));
        tablero.añadeCasilla(new CasillaCalle("Calle Alhambra", 250000, 30000, 25000));
        tablero.añadeCasilla(new CasillaCalle("Calle Bulería", 550000, 20000, 30000));
        
        System.out.println("\nTABLERO!!!");
        System.out.println("*********************************************************************************");
        
        CasillaCalle calleMasCara = new CasillaCalle("Calle Por Defecto", 0, 0, 0);
        CasillaCalle calleMasBarata = (CasillaCalle)tablero.getCasilla(0);
        int sumaPrecioCalles = 0;
        int precioMedioCalles = 0;
        CasillaCalle calle;
        
        for(int i=0; i<3; i++){
            System.out.println(tablero.getCasilla(i).toString());
            calle = (CasillaCalle)tablero.getCasilla(i);
            if(calleMasCara.getPrecioAlquilerCompleto() < calle.getPrecioAlquilerCompleto())
                calleMasCara = calle;
            
            if(calleMasBarata.getPrecioAlquilerCompleto() > calle.getPrecioAlquilerCompleto())
                calleMasBarata = calle;
            
            sumaPrecioCalles += calle.getPrecioAlquilerCompleto();            
        }
        precioMedioCalles = sumaPrecioCalles/3;
        
        System.out.println("*********************************************************************************");
        System.out.println("Calle más cara: " + calleMasCara.toString());
        System.out.println("Calle más barata: " + calleMasBarata.toString());
        System.out.println("Precio medio de las calles: " + precioMedioCalles);
        
        System.out.println("\nPrueba de la clase Diario!!!");
        System.out.println("*********************************************************************************");   
        Diario.getInstance().ocurreEvento("Prueba de la clase Diario");
        System.out.println(Diario.getInstance().leerEvento());
        
        System.out.println("\nComprobación de tiradas de dado y correcto cálculo de posición!!!");
        System.out.println("*********************************************************************************");  
        int tirada = 0;
        int posActual = 0;
            System.out.println(tirada);
            System.out.println(posActual);
        for(int i=0; i<10; i++){
            tirada = Dado.getInstance().tirar();
            System.out.println(tirada);
            tablero.nuevaPosicion(posActual, tirada);
            System.out.println(posActual);
        }
    
    }
    
}
