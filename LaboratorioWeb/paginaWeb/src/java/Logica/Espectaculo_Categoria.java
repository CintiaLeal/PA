package Logica;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table (name = "espectaculo_categoria")
@IdClass(Espectaculo_Categoria_Id.class)
public class Espectaculo_Categoria implements Serializable{
    
    @Id
    @Column(name = "espectaculo_nombre")
    private String id_espectaculo;
    
    @Id
    @Column(name = "categoria_nombre")
    private String id_categoria;
    
    @ManyToOne
    @JoinColumn(name = "categoria_nombre", referencedColumnName = "categoria_nombre", insertable = false, updatable = false)
    private Categoria cat;

    @ManyToOne
    @JoinColumn(name = "espectaculo_nombre", referencedColumnName = "espectaculo_nombre", insertable = false, updatable = false)
    private Espectaculo e;

    public Espectaculo_Categoria(String id_espectaculo, String id_categoria, Categoria cat, Espectaculo e) {
        this.id_espectaculo = id_espectaculo;
        this.id_categoria = id_categoria;
        this.cat = cat;
        this.e = e;
    }

    public Espectaculo_Categoria() {
    }

    public String getId_espectaculo() {
        return id_espectaculo;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public Categoria getCat() {
        return cat;
    }

    public Espectaculo getE() {
        return e;
    }

    public void setId_espectaculo(String id_espectaculo) {
        this.id_espectaculo = id_espectaculo;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }

    public void setE(Espectaculo e) {
        this.e = e;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id_espectaculo);
        hash = 59 * hash + Objects.hashCode(this.id_categoria);
        hash = 59 * hash + Objects.hashCode(this.cat);
        hash = 59 * hash + Objects.hashCode(this.e);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Espectaculo_Categoria other = (Espectaculo_Categoria) obj;
        if (!Objects.equals(this.id_espectaculo, other.id_espectaculo)) {
            return false;
        }
        if (!Objects.equals(this.id_categoria, other.id_categoria)) {
            return false;
        }
        if (!Objects.equals(this.cat, other.cat)) {
            return false;
        }
        if (!Objects.equals(this.e, other.e)) {
            return false;
        }
        return true;
    }
}
