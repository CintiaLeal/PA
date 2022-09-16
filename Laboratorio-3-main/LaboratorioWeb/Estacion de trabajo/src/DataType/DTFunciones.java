package DataType;
import java.io.File;
import java.sql.Date;
import java.sql.Time;

public class DTFunciones {
    private String nombre;
    private String fecha;
    private String hora;
    private String fechaRegistro;
    private String img;
    private ListRegistro registros;
    private ListArtista artistas;
            
 public DTFunciones(String nombre, String fecha, String hora, String fechaRegistro, String img, ListRegistro r, ListArtista a){
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.fechaRegistro = fechaRegistro;
        this.img = img;
        this.artistas = a;
        this.registros = r;
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

    public String getImg() {
        return img;
    }

    public ListRegistro getRegistros() {
        return registros;
    }

    public void setRegistros(ListRegistro registros) {
        this.registros = registros;
    }

    public ListArtista getArtistas() {
        return artistas;
    }

    public void setArtistas(ListArtista artistas) {
        this.artistas = artistas;
    }

    @Override
    public String toString() {
        return "Funcion :" + "nombre=" +nombre + '\n' + ", fecha=" + fecha + '\n'+ ", hora=" + hora + '\n'+ ", fechaRegistro=" + '\n'+ fechaRegistro + '\n';
    }
}
