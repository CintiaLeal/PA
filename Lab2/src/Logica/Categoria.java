
package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import Logica.Espectaculo;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
    @Id
    @Column(name = "nombre")
    private String nombre;    
    
//    @JoinTable(name = "espectaculo_categoria",
//            joinColumns = @JoinColumn(name = "categoria_nombre"),
//            inverseJoinColumns = @JoinColumn(name = "espectaculo_nombre"))
    
    @OneToMany
    @JoinColumn(name = "espectaculo_nombre", referencedColumnName = "esp_nombre", insertable = false, updatable = false)
    private List<Espectaculo_Categoria> espectaculos;

    
    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public Categoria() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspectaculos(List<Espectaculo_Categoria> espectaculos) {
        this.espectaculos = espectaculos;
    }

    public List<Espectaculo_Categoria> getEspectaculos() {
        return espectaculos;
    }
    

    @Override
    public String toString() {
        return "Categoria{" + "nombre=" + nombre + '}';
    }


}

