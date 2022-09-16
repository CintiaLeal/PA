
package DataType;
import java.io.File;
import java.sql.Date;

public class DTPaquetes {
 private String nombre;
 private String descripcion;
 private String fechaInicio;
 private  String fechaFin;
 private  String fechaAlta;
 private Double precio;
 private Double descuento;
 private String img;
    public DTPaquetes(String nombre, String descripcion, String fechaInicio, String fechaFin,String fechaAlta, Double precio, Double descuento,String i) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaAlta = fechaAlta;
        this.precio = precio;
        this.descuento = descuento;
        this.img = i;
    }

    public DTPaquetes() {
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public Double getPrecio() {
        return precio;
    }

    public Double getDescuento() {
        return descuento;
    }

    public String getImg() {
        return img;
    }

    @Override
    public String toString() {
        return "DTPaquetes{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", fechaAlta=" + fechaAlta + ", precio=" + precio + ", descuento=" + descuento + ", img=" + img + '}';
    }
}
