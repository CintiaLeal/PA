package Logica;

import DataType.DTFunciones;
import DataType.Estado;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import Logica.Espectaculo;
import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import persistencia.CategoriaJpaController;
import persistencia.EspectaculoJpaController;

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

    
    public List<String> listarEspectaculos(){
       CategoriaJpaController cjpa = new CategoriaJpaController();
       EntityManager em = cjpa.getEntityManager();
        Query q;
        Estado est = Estado.aceptado;
        q = em.createQuery("SELECT DISTINCT es.nombre FROM Categoria c JOIN Espectaculo_Categoria e ON c.nombre = e.id_categoria JOIN Espectaculo es ON e.id_espectaculo = es.nombre WHERE es.estado =:est AND c.nombre = :nombre");
        q.setParameter("nombre", this.nombre);
        q.setParameter("est", est);
        return q.getResultList();
    }

    List<String> listarFuncionesDeE(String espectaculo) {
        EspectaculoJpaController espJpa = new EspectaculoJpaController();
        Espectaculo e = espJpa.findEspectaculo(espectaculo);
        List<String> ret = e.listarFunciones();
        return ret;
    }
    
    DTFunciones seleccionarFuncion(String espectaculo, String nombre) {
        EspectaculoJpaController ejpa = new EspectaculoJpaController();
        Espectaculo e = ejpa.findEspectaculo(espectaculo);
        return e.seleccionarFuncion(nombre);}

    List<String> listarFuncionesVigentesDeE(String espectaculo) {
        EspectaculoJpaController espJpa = new EspectaculoJpaController();
        Espectaculo e = espJpa.findEspectaculo(espectaculo);
        List<String> ret = e.listarFuncionesVigentes();
        return ret;
        }

}

