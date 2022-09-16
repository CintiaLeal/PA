
package DataType;

import java.sql.Date;


public class DTRegistro {
   private  Date fecha; 
   private String id;
   
public DTRegistro (Date fecha, String id){
    this.fecha = fecha;
    this.id = id;
}

public DTRegistro (){

}
public Date getFecha() {
        return fecha;
    }
public String getId(){
        return id;
    }
}