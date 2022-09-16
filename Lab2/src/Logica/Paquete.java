/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DataType.DTPaquetes;
import DataType.DTUsuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;
import persistencia.EspectaculoJpaController;
import persistencia.PaqueteJpaController;
import persistencia.PlataformaJpaController;

@Entity
@Table(name = "paquete")
public class Paquete {
   @Id
    @Column(name = "nombre")
    private String nombre;
   @Column(name = "descripcion")
    private String descripcion;
   @Column(name = "fechaI")
    private String fechaI;
   @Column(name = "fechaF")
    private String fechaF;
   @Column(name = "precio")
    private Double precio;
   @Column(name = "descuento")
    private Double descuento;

  
   @OneToMany (targetEntity=Espectaculo.class, cascade = CascadeType.ALL)
    private List<Espectaculo> espectaculos;
   
   //CONSTRUCTORES
    
    public Paquete() {
        espectaculos =  new ArrayList();
    }

    public Paquete(String nombre, String descripcion, String fechaI, String fechaF, Double precio, Double descuento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.precio = precio;
        this.descuento = descuento;
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

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    DTPaquetes getdata() {
         return new DTPaquetes(this.nombre, this.descripcion, this.fechaI, this.fechaF, this.precio,this.descuento);
    }
    
   
   void agregarPaqueteEs(String nombre) {
  
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
        DTPaquetes res = new DTPaquetes(this.nombre, this.descripcion, this.fechaI, this.fechaF, this.precio,this.descuento);
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
        q.setParameter("nombre", nombre);
        return q.getResultList();
    }

    
   
}
