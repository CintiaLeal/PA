/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DataType.DTEspectaculo;
import DataType.DTFunciones;
import Logica.Categoria;
import Logica.Funciones;
import java.sql.Date;
import DataType.Estado;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Query;
import persistencia.EspectaculoJpaController;
import persistencia.FuncionesJpaController;

/**
 *
 * @author cintia
 */
@Entity
@Table(name = "espectaculo")
public class Espectaculo {

    @Id
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "duracion")
    private int duracion;

    @Column(name = "cantMinEsp")
    private int cantMinEsp;

    @Column(name = "cantMaxEsp")
    private int cantMaxEsp;

    @Column(name = "costo")
    private double costo;

    @Column(name = "fechaRegistro")
    private String fechaRegistro;

    @Column(name = "estado")
    private Estado estado;

    @OneToOne(targetEntity = Artista.class)
    @JoinColumn(name = "nick")
    private Artista a;

    @OneToMany(targetEntity = Funciones.class, cascade = CascadeType.ALL)
    @JoinTable(name = "espectaculo_funciones",
            joinColumns = @JoinColumn(name = "espectaculo_nombre"),
            inverseJoinColumns = @JoinColumn(name = "funciones_nombre"))
    private List<Funciones> funciones;

    @OneToMany
    @JoinColumn(name = "categoria_nombre", referencedColumnName = "cat_nombre", insertable = false, updatable = false)
    private List<Espectaculo_Categoria> categorias;

    //------------------------//
    public Espectaculo() {
    }

    //GET
    Espectaculo(Artista a, String nombre, String descripcion, Integer duracion, Integer min, Integer max, Double costo, String fechaAlt, Estado e) {
        this.a = a;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.cantMinEsp = cantMinEsp;
        this.cantMaxEsp = cantMaxEsp;
        this.costo = costo;
        this.fechaRegistro = fechaRegistro;
        this.estado = e;
    }

    public List<Espectaculo_Categoria> getCategorias() {
        return categorias;
    }
    

    public DTEspectaculo getdata() {
        DTEspectaculo ret = new DTEspectaculo(nombre, descripcion, duracion, cantMinEsp, cantMaxEsp, costo, fechaRegistro);
        return ret;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getCantMinEsp() {
        return cantMinEsp;
    }

    public int getCantMaxEsp() {
        return cantMaxEsp;
    }

    public double getCosto() {
        return costo;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public Estado getE() {
        return estado;
    }

    //SET
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategorias(List<Espectaculo_Categoria> categorias) {
        this.categorias = categorias;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setE(Estado e) {
        this.estado = e;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setCantMinEsp(int cantMinEsp) {
        this.cantMinEsp = cantMinEsp;
    }

    public void setCantMaxEsp(int cantMaxEsp) {
        this.cantMaxEsp = cantMaxEsp;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", duracion=" + duracion + ", cantMinEsp=" + cantMinEsp + ", cantMaxEsp=" + cantMaxEsp + ", costo=" + costo + ", fechaRegistro=" + fechaRegistro + ", estado =" + estado + ", artista=" + a + ", funciones=" + funciones + ", categorias=" + categorias + '}';
    }

    void agregarFuncion(String nombre, String fecha, String hora) {
        java.util.Date fe = new java.util.Date();
        String fechaR = fe.toString();
        Funciones f = new Funciones(nombre, fecha, hora, fechaR);
        this.funciones.add(f);
        FuncionesJpaController fu = new FuncionesJpaController();
        EntityManager em = fu.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(f);
        t.commit();
        em.close();
    }

    @SuppressWarnings("unchecked")
    List<String> listarFunciones() {
        EspectaculoJpaController espjpa = new EspectaculoJpaController();
        EntityManager em = espjpa.getEntityManager();
        Query q;
        q = em.createQuery("SELECT DISTINCT f.nombre FROM Espectaculo e JOIN Funciones f ON e.funciones.nombre = f.nombre WHERE e.nombre = :nombre");
        q.setParameter("nombre", this.nombre);
        return q.getResultList();
    }

    DTFunciones seleccionarFuncion(String nombre) {
        FuncionesJpaController fjpa = new FuncionesJpaController();
        Funciones f = fjpa.findFunciones(nombre);
        return f.getdata();
    }

    @SuppressWarnings("unchecked")
    boolean existeFuncion(String nombre) {
        EspectaculoJpaController espjpa = new EspectaculoJpaController();
        EntityManager em = espjpa.getEntityManager();
        Query q;
        q = em.createQuery("SELECT DISTINCT f.nombre FROM Espectaculo e JOIN Funciones f ON e.funciones.nombre = f.nombre WHERE e.nombre = :nombre");
        q.setParameter("nombre", this.nombre);
        List<String> list = q.getResultList();
        for (int i = 0; i < list.size(); i++) {
            if (nombre.equals(list.get(i))) {
                return true;
            }
        }
        return false;
    }

    int registrarEspectador(String funcion, String usuario, java.util.Date fecha) {
        FuncionesJpaController fjpa = new FuncionesJpaController();
        Funciones f = fjpa.findFunciones(nombre);
        int i = f.registrarEspectador(usuario, fecha);
        return i;
    }

}
