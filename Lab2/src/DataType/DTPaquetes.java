
package DataType;

import java.sql.Date;

public class DTPaquetes {
 private String nombre;
 private String descripcion;
 private String fechaInicio;
 private  String fechaFin;
 private Double precio;
 private Double descuento;

    public DTPaquetes(String nombre, String descripcion, String fechaInicio, String fechaFin, Double precio, Double descuento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.descuento = descuento;
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

    public Double getPrecio() {
        return precio;
    }

    public Double getDescuento() {
        return descuento;
    }

    @Override
    public String toString() {
        return "DTPaquetes{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", precio=" + precio + ", descuento=" + descuento + '}';
    }

    
 
 
}
