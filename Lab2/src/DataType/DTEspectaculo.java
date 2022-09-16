
package DataType;
import java.sql.Date;

 public class DTEspectaculo {
    private String nombre;
    private String descripcion;
    private int duracion;
    private int cantMinEsp;
    private int cantMaxEsp;
    private double costo;
    private String fechaRegistro;

public DTEspectaculo(String nombre, String descripcion, int duracion, int cantMinEsp, int cantMaxEsp, double costo, String fechaRegistro) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.duracion = duracion;
    this.cantMinEsp = cantMinEsp;
    this.cantMaxEsp = cantMaxEsp;
    this.costo = costo;
    this.fechaRegistro = fechaRegistro;
}

public DTEspectaculo(){
}

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getCantMinEsp() {
        return cantMinEsp;
    }

    public int getCantMaxEsp() {
        return cantMaxEsp;
    }

    public double getCosto() {
        return costo;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    @Override
    public String toString() {
        return "{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", duracion=" + duracion + ", cantMinEsp=" + cantMinEsp + ", cantMaxEsp=" + cantMaxEsp + ", costo=" + costo + ", fechaRegistro=" + fechaRegistro + '}';
    }

}
