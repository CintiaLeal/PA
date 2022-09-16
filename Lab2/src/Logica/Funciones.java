
package Logica;
import DataType.DTFunciones;
import java.io.Serializable;
import java.sql.*;
import java.sql.Time;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.*;
/**
 *
 * @author cintia
 */
@Entity
@Table(name = "funciones")
public class Funciones implements Serializable{
    @Id
    @Column(name = "nombre")
    private String nombre;
  
    @Column(name = "fecha")
    private String fecha;
    
    @Column(name = "hora")
    private String hora;
     
    @Column (name = "fechaRegistro")
    private String fechaRegistro;
    
    @OneToMany (targetEntity=Registro.class, cascade = CascadeType.ALL)
    @JoinTable(name = "funciones_registro", 
           joinColumns=@JoinColumn(name = "funciones_nombre"), 
           inverseJoinColumns=@JoinColumn(name = "registro_id"))
    private List<Registro> registros;
      
    //------------------------    
    public Funciones(){
        
    }
    
    public Funciones(String nombre, String fecha, String hora, String fechaRegistro){
    if (nombre.equals ("")){
        throw new RuntimeException("El nombre de la Funcion no puede ser vacio");
    }    
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.fechaRegistro = fechaRegistro;
    }
    
    //GET
    
    public DTFunciones getdata(){
        DTFunciones ret = new DTFunciones (nombre,fecha,hora,fechaRegistro);
        return ret;
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
    //SET

     public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
      int registrarEspectador(String usuario, java.util.Date fecha){
          int ret = 0;
          
          
          return ret;
      }
}

