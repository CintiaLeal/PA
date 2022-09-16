package Logica;

import DataType.DTFunciones;
import DataType.DTPlataforma;
import DataType.Estado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;
import persistencia.EspectaculoJpaController;
import persistencia.PlataformaJpaController;

@Entity
@Table (name = "plataforma")
public class Plataforma implements Serializable {
    
   @OneToMany(targetEntity=Espectaculo.class, cascade = CascadeType.ALL)
   @JoinTable(name = "plataforma_espectaculo", 
           joinColumns=@JoinColumn(name = "plataforma_nombre"), 
           inverseJoinColumns=@JoinColumn(name = "espectaculos_nombre"))
    public List<Espectaculo> espectaculos;
   
   
    
    @Id
    @Column(name = "nombre")
    String nombre ;
    
    @Basic
    @Column(name = "descripcion")
    String descripcion;
    @Column(name = "url")
    String url; 

    public Plataforma(String nombre, String descripcion, String url) {
        this.espectaculos = new ArrayList();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
    }
    
    
    public Plataforma() {
        espectaculos = new ArrayList();
    }
   

   

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrl() {
        return url;
    }

    public List<Espectaculo> getEspectaculos() {
        return espectaculos;
    }

    public void setEspectaculos(List<Espectaculo> espectaculos) {
        this.espectaculos = espectaculos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    public void agregarEspectaculo(Artista a,String nombre, String descripcion,String url, Integer duracion, Integer min, Integer max, Double costo, String fechaAlt, Estado es, List<Categoria> c, String img, Integer cant, String descP){
        if(a==null || nombre.equals("") || descripcion.equals("") || url.equals("") || duracion <=0 || min <=0 || max < min || costo <=0 || fechaAlt.equals("")|| es == null || es == Estado.rechazado || c == null || c.isEmpty()){
            return;
        }
        Espectaculo e = new Espectaculo(a, nombre,descripcion, url, duracion, min, max, costo, fechaAlt, es, img, cant, descP);
      
        List<Espectaculo_Categoria> ec = new ArrayList();
        for (int i = 0; i < c.size(); i++) {
            Espectaculo_Categoria item = new Espectaculo_Categoria(nombre, c.get(i).getNombre(), c.get(i), e);
            ec.add(item);
        }
        e.setCategorias(ec);
        EspectaculoJpaController esp = new EspectaculoJpaController();
       try {
           esp.create(e);
       } catch (Exception ex) {
           Logger.getLogger(Plataforma.class.getName()).log(Level.SEVERE, null, ex);
       }
        this.espectaculos.add(e);
    }
    
    public void agregarEspectaculoC(Espectaculo e){
        if(e == null){
            return;
        }
        this.espectaculos.add(e);
    }

    DTPlataforma getdata() {
        return new DTPlataforma(this.nombre, this.descripcion, this.url);
    }
 
    public String toString() {
        return "Plataforma{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", url=" + url + '}';
    }
    
   @SuppressWarnings("unchecked")
    public List<String> listarEspectaculos(){
       PlataformaJpaController pjpa = new PlataformaJpaController();
       EntityManager em = pjpa.getEntityManager();
        Query q;
        q = em.createQuery("SELECT DISTINCT e.nombre FROM Plataforma p JOIN Espectaculo e ON p.espectaculos.nombre = e.nombre WHERE p.nombre = :nombre");
        q.setParameter("nombre", nombre);
        return q.getResultList();
    }

    public Espectaculo agregarFuncion(String espectaculo, String nombre, String fecha, String hora, String img, List<Artista> a){
        if(espectaculo.equals("") || espectaculo == null){
            return null;
        }
        EspectaculoJpaController esp = new EspectaculoJpaController();
        Espectaculo e = esp.findEspectaculo(espectaculo);
        e.agregarFuncion(nombre, fecha, hora, img,a);
        return e;
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

    public int registrarEspectador(String espectaculo, String funcion, String usuario, java.util.Date fecha){
        EspectaculoJpaController ejpa = new EspectaculoJpaController();
        Espectaculo e = ejpa.findEspectaculo(espectaculo);
        return e.registrarEspectador(funcion, usuario,fecha);
    }

    List<String> listarFuncionesVigentesDeE(String espectaculo) {
        EspectaculoJpaController espJpa = new EspectaculoJpaController();
        Espectaculo e = espJpa.findEspectaculo(espectaculo);
        List<String> ret = e.listarFuncionesVigentes();
        return ret;
    }

    public List<Premio> sortearPremios(Espectaculo espectaculo, Funciones funcion) {
        return espectaculo.sortearPremios(funcion);
    }
}


