package Logica;

import DataType.DtPuntaje;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Puntaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne(targetEntity = Espectador.class)
    @JoinColumn (name = "espectador")
    private Espectador espectador;
    
    @Column(name = "puntaje")
    private Integer puntaje;

    public Puntaje() {
    }

    public Puntaje(Espectador espectador, Integer puntaje) {
        this.espectador = espectador;
        this.puntaje = puntaje;
    }

    public Long getId() {
        return id;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
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
        if (!(object instanceof Puntaje)) {
            return false;
        }
        Puntaje other = (Puntaje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    public DtPuntaje getData(){
        DtPuntaje res = new DtPuntaje(this.id, this.espectador.getdata(), this.puntaje);
        return res;
    }

    @Override
    public String toString() {
        return "Puntaje{" + "id=" + id + ", espectador=" + espectador + ", puntaje=" + puntaje + '}';
    }  
}
