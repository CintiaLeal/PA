
package DataType;
import java.sql.Date;
import java.sql.Time;

public class DTFunciones {
    private String nombre;
    private String fecha;
    private String hora;
    private String fechaRegistro;

            
 public DTFunciones(String nombre, String fecha, String hora, String fechaRegistro){
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.fechaRegistro = fechaRegistro;
 }
 
 public DTFunciones(){
 }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    @Override
    public String toString() {
        return "Funcion :" + "nombre=" +nombre + '\n' + ", fecha=" + fecha + '\n'+ ", hora=" + hora + '\n'+ ", fechaRegistro=" + '\n'+ fechaRegistro + '\n';
    }
 
}
