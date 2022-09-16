package pkgWS;
import java.sql.Date;

public class DtRegistro {
   private  Date fecha; 
   private String id;
   
public DtRegistro (Date fecha, String id){
    this.fecha = fecha;
    this.id = id;
}

public DtRegistro (){

}
public Date getFecha() {
        return fecha;
    }
public String getId(){
        return id;
    }
}