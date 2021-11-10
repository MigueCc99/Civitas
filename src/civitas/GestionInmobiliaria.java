package civitas;

/**
 *
 * @author miguecc99
 */
public class GestionInmobiliaria {
    private int propiedad;
    private OperacionInmobiliaria operacion;
    
    public GestionInmobiliaria (OperacionInmobiliaria gest, int ip){
        this.operacion = gest;
        this.propiedad = ip;
    }
    
    public OperacionInmobiliaria getOperacion (){
        return operacion;
    }
    
    public int getPropiedad (){
        return propiedad;
    }
    
    public static void main (String[] args){
        GestionInmobiliaria gestionInmobiliaria = new GestionInmobiliaria (OperacionInmobiliaria.CONSTRUIR_CASA, 2);
        System.out.println("Gestión inmobiliaria: ");
        System.out.println(gestionInmobiliaria.getOperacion());
        System.out.println(gestionInmobiliaria.getPropiedad());
    }
}
