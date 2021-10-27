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
}
