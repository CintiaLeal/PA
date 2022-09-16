package Logica;
import java.sql.SQLException;

public class Factory {
    private Factory(){};
    private static Factory instancia = null;
    
    public Factory getInstancia(){
        if(instancia == null)
            instancia = new Factory();
        return instancia;
    }
    
    public static ISistema crearSistema(){
        return Sistema.getInstancia();
    }
}
