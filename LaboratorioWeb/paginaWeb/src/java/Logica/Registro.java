package Logica;
import DataType.DTRegistro;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.*;

@Entity
@Table(name = "Registro")
public class Registro implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "fecha")
    private String fecha;
    
    @Column(name = "costo")
    private double costo;
    
    @OneToOne(targetEntity = Espectador.class)
    @JoinColumn (name = "nick")
    private Espectador espectador;
    
    @ManyToOne(targetEntity = Funciones.class)
    @JoinColumn (name = "nombre")
    private Funciones funciones;
    
    @OneToMany(targetEntity=Registro.class)
    @JoinColumn (name = "id_hijos")
    private List<Registro> registros;
    
    @OneToOne(targetEntity = Compra.class)
    @JoinColumn(name = "compra")
    private Compra compra;

//Constructores
    
public Registro(){
    this.registros = null;
 }

public Registro(String fecha, Espectador espectador, Funciones funciones, List<Registro> reg,double costo,Compra compra){
   
    this.fecha = fecha;
    this.espectador = espectador;
    this.funciones = funciones;
    this.registros = reg;
    this.costo = costo;
    this.compra = compra;
}

//GET
    public String getFecha() {
        return fecha;
    }

    public Integer getId() {
        return id;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public Funciones getFunciones() {
        return funciones;
    }
    
    public DTRegistro getData(){
        DTRegistro ret = new DTRegistro(this.fecha, this.id.toString());
        return ret;
    }

//SET
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }

    public void setFunciones(Funciones funciones) {
        this.funciones = funciones;
    }
}