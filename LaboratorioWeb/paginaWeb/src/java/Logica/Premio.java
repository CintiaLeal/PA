package Logica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Premio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne(targetEntity = Espectador.class)
    @JoinColumn (name = "nick")
    private Espectador espectador;
    
    @OneToOne(targetEntity = Funciones.class)
    @JoinColumn (name = "funcion")
    private Funciones funcion;
    
    @OneToOne(targetEntity = Espectaculo.class)
    @JoinColumn (name = "espectaculo")
    private Espectaculo espectaculo;
    
    @Column (name = "fecha")
    private String fecha;
    
    @Column (name = "descripcion")
    private String descripcion;

    public Premio() {
    }

    public Premio(Espectador espectador, Funciones funcion, String fecha, String descripcion, Espectaculo esp) {
        this.espectador = espectador;
        this.funcion = funcion;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.espectaculo = esp;
    }
    
    public Long getId() {
        return id;
    }

    public Espectaculo getEspectaculo() {
        return espectaculo;
    }

    public void setEspectaculo(Espectaculo espectaculo) {
        this.espectaculo = espectaculo;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }

    public Funciones getFuncion() {
        return funcion;
    }

    public void setFuncion(Funciones funcion) {
        this.funcion = funcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Premio)) {
            return false;
        }
        Premio other = (Premio) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Premio{" + "Id=" + id + ", Ganador=" + espectador + ", Funcion=" + funcion + ", Fecha=" + fecha + ", Descripcion=" + descripcion + "}";
    }
}
