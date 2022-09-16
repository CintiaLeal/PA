package Logica;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

public class Espectaculo_Categoria_Id implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "categoria_nombre")
    private String id_categoria;

    @Column(name = "espectaculo_nombre")
    private String id_espectaculo;

    public Espectaculo_Categoria_Id() {
    }

    public Espectaculo_Categoria_Id(String id_categoria, String id_espectaculo) {
        this.id_categoria = id_categoria;
        this.id_espectaculo = id_espectaculo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public String getId_espectaculo() {
        return id_espectaculo;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setId_espectaculo(String id_espectaculo) {
        this.id_espectaculo = id_espectaculo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id_categoria);
        hash = 47 * hash + Objects.hashCode(this.id_espectaculo);
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
        final Espectaculo_Categoria_Id other = (Espectaculo_Categoria_Id) obj;
        if (!Objects.equals(this.id_categoria, other.id_categoria)) {
            return false;
        }
        if (!Objects.equals(this.id_espectaculo, other.id_espectaculo)) {
            return false;
        }
        return true;
    }
    
    
}