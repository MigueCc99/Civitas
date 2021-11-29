package vistaTextualCivitas;

import civitas.Casilla;
import civitas.CasillaCalle;
import civitas.CivitasJuego;
import civitas.Diario;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import civitas.OperacionInmobiliaria;
import civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class VistaTextual implements Vista {
  
    
  private static String separador = "=====================";
  
  private Scanner in;
  
  CivitasJuego juegoModel;
  
  public VistaTextual (CivitasJuego juegoModel) {
    in = new Scanner (System.in);
    this.juegoModel=juegoModel;
  }
           
 public  void pausa() {
    System.out.print ("\nPulsa una tecla");
    in.nextLine();
  }

  int leeEntero (int max, String msg1, String msg2) {
    Boolean ok;
    String cadena;
    int numero = -1;
    do {
      System.out.print (msg1);
      cadena = in.nextLine();
      try {  
        numero = Integer.parseInt(cadena);
        ok = true;
      } catch (NumberFormatException e) { // No se ha introducido un entero
        System.out.println (msg2);
        ok = false;  
      }
      if (ok && (numero < 0 || numero >= max)) {
        System.out.println (msg2);
        ok = false;
      }
    } while (!ok);

    return numero;
  }

  int menu (String titulo, ArrayList<String> lista) {
    String tab = "  ";
    int opcion;
    System.out.println (titulo);
    for (int i = 0; i < lista.size(); i++) {
      System.out.println (tab+i+"-"+lista.get(i));
    }

    opcion = leeEntero(lista.size(),
                          "\n"+tab+"Elige una opción: ",
                          tab+"Valor erróneo");
    return opcion;
  }

    @Override
    public void actualiza() {
        System.out.println("Info del jugador actual y sus propiedades:\n" + juegoModel.getJugadorActual().toString());
        System.out.println("Info de la casilla actual:\n" + juegoModel.getTablero().getCasilla(juegoModel.getJugadorActual().getCasillaActual()).toString());
        
        if(juegoModel.finalDelJuego()){
            for(Jugador jugador: juegoModel.getJugadores())
                System.out.println(jugador.toString() + "\n");
        }
    }
    
    @Override
    public Respuesta comprar() {
        Respuesta respuesta = null;
        int opcion = menu ("¿Desea comprar la calle en la que se encuentra?", new ArrayList<String>(Arrays.asList("SI", "NO")));
        
        switch(opcion){
            case 0:
                respuesta = Respuesta.SI;
            break;
            case 1:
                respuesta = Respuesta.NO;
            break;               
        }
        
        return respuesta;
    }

    @Override
    public OperacionInmobiliaria elegirOperacion() {
        OperacionInmobiliaria operacion = null;
        int opcion = menu("¿Qué operación inmobiliaria quiere ejecutar?", new ArrayList<String>(Arrays.asList("CONSTRUIR_CASA", "CONSTRUIR_HOTEL", "TERMINAR")));
        
        switch(opcion){
            case 0:
                operacion = OperacionInmobiliaria.CONSTRUIR_CASA;
            break;
            case 1:
                operacion = OperacionInmobiliaria.CONSTRUIR_HOTEL;
            break; 
            case 2:
                operacion = OperacionInmobiliaria.TERMINAR;
            break;
        }    
        
        return operacion;
    }

    @Override
    public int elegirPropiedad() {
        ArrayList<CasillaCalle> propiedades = juegoModel.getJugadorActual().getPropiedades();
        ArrayList<String> propiedadesString = new ArrayList<>();
        
        for(Casilla propiedad: propiedades)
            propiedadesString.add(propiedad.getNombre());
        
        return menu("¿Sobre qué propiedad quiere realizar la gestión inmobiliaria?", propiedadesString);
    }

    @Override
    public void mostrarSiguienteOperacion(OperacionJuego operacion) {
        System.out.println("La siguiente operación es: " + operacion.toString());
    }

    @Override
    public void mostrarEventos() {
        System.out.println("*********************** EVENTOS ***********************");
        while(Diario.getInstance().eventosPendientes())
            System.out.println("\n"+Diario.getInstance().leerEvento());
        System.out.println("\n*******************************************************");
    }

}