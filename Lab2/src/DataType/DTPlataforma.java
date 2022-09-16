
package DataType;


public class DTPlataforma {
   private String nombre; 
   private String descripcion;
   private String URL;

public DTPlataforma(String nombre, String descripcion, String URL) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.URL = URL;
}
public DTPlataforma(){
}

    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion(){
        return descripcion; 
    }
    
    public String getURL() {
        return URL;
    }


}
