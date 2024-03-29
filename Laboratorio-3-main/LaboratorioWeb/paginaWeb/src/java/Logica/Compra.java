/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;
    
    @OneToOne(targetEntity = Espectador.class)
    @JoinColumn(name = "nick")
    private Espectador esp;
    
    @OneToOne(targetEntity = Paquete.class)
    @JoinColumn(name = "nombre")
    private Paquete paquete;

    public Compra() {
    }

    public Compra(Espectador esp, Paquete paquete) {
        this.esp = esp;
        this.paquete = paquete;
    }

    public Long getId() {
        return id;
    }

    public Espectador getEsp() {
        return esp;
    }

    public Paquete getPaquete() {
        return paquete;
    }
    

    public void setId(Long id) {
        this.id = id;
    }

    public void setEsp(Espectador esp) {
        this.esp = esp;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
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
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Compra[ id=" + id + " ]";
    }
    
}
