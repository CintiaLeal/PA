package DataType;
import java.sql.Date;

public class DTRegistro {
   private  String fecha; 
   private String id;
   
public DTRegistro (String fecha, String id){
    this.fecha = fecha;
    this.id = id;
}

public DTRegistro (){

}
public String getFecha() {
        return fecha;
    }
public String getId(){
        return id;
    }
}