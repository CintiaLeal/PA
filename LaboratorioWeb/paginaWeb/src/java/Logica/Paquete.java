package Logica;

import DataType.DTPaquetes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;
import persistencia.EspectaculoJpaController;
import persistencia.PaqueteJpaController;

@Entity
@Table(name = "paquete")
public class Paquete implements Serializable {
   @Id
    @Column(name = "nombre")
    private String nombre;
   @Column(name = "descripcion")
    private String descripcion;
   @Column(name = "fechaI")
    private String fechaI;
   @Column(name = "fechaF")
    private String fechaF;
   @Column(name = "fechaA")
   private String fechaA;
   @Column(name = "precio")
    private Double precio;
   @Column(name = "descuento")
    private Double descuento;
    @Column (name = "imagen")
    private String img;
  
   @OneToMany (targetEntity=Espectaculo.class, cascade = CascadeType.ALL)
    private List<Espectaculo> espectaculos;
   
   //CONSTRUCTORES
    
    public Paquete() {
        espectaculos =  new ArrayList();
    }

    public Paquete(String nombre, String descripcion, String fechaI, String fechaF,String fechaA ,Double precio, Double descuento,String i) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.fechaA = fechaA;
        this.precio = precio;
        this.descuento = descuento;
        this.img = i;
        this.espectaculos = new ArrayList();    
        
 
    }
    
    //GETTERS

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaI() {
        return fechaI;
    }

    public String getFechaF() {
        return fechaF;
    }

    public Double getPrecio() {
        return precio;
    }

    public Double getDescuento() {
        return descuento;
    }

    public String getFechaA() {
        return fechaA;
    }

    public String getImg() {
        return img;
    }
 
    public List<Espectaculo> getEspectaculos() {
        return espectaculos;
    }
    
    //SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaI(String fechaI) {
        this.fechaI = fechaI;
    }

    public void setFechaF(String fechaF) {
        this.fechaF = fechaF;
    }

    public void setFechaA(String fechaA) {
        this.fechaA = fechaA;
    }

    public void setEspectaculos(List<Espectaculo> espectaculos) {
        this.espectaculos = espectaculos;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
   public void agregarPaqueteEs(String nombre) {
  
       EspectaculoJpaController e = new EspectaculoJpaController (); 
       Espectaculo e1 = e.findEspectaculo(nombre);
       this.espectaculos.add(e1);
       /*
        EntityManager em = e.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(e);
        t.commit();
        em.close();*/
    }         

    public DTPaquetes getData() {
        DTPaquetes res = new DTPaquetes(this.nombre, this.descripcion, this.fechaI, this.fechaF,this.fechaA, this.precio,this.descuento,this.img);
        return res;
    }
    
    
     public List<String> listarEspectaculosPaquete(){
       PaqueteJpaController pa = new PaqueteJpaController();
       EntityManager em = pa.getEntityManager();
        Query q;
        q = em.createQuery("SELECT DISTINCT e.nombre FROM Plataforma p JOIN Espectaculo e ON p.espectaculos.nombre = e.nombre WHERE p.nombre = :nombre");
        q.setParameter("nombre", nombre);
        return q.getResultList();
    }
  
    @SuppressWarnings("unchecked")
    public List<String> listarEspectaculos(){
       PaqueteJpaController pjpa = new PaqueteJpaController();
       EntityManager em = pjpa.getEntityManager();
        Query q;
        q = em.createQuery("SELECT DISTINCT e.nombre FROM Paquete p JOIN Espectaculo e ON p.espectaculos.nombre = e.nombre WHERE p.nombre = :nombre");
        q.setParameter("nombre", this.nombre);
        return q.getResultList();
    }

    
   
}
