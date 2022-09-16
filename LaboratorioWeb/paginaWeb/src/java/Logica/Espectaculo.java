package Logica;

import DataType.DtEspectaculo;
import DataType.DTFunciones;
import DataType.DtPuntaje;
import DataType.Estado;
import DataType.ListPuntaje;
import DataType.ListString;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Query;
import persistencia.EspectaculoJpaController;
import persistencia.FuncionesJpaController;

@Entity
@Table(name = "espectaculo")
public class Espectaculo implements Serializable {

    @Id
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "url")
    private String url;

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

    @Column(name = "imagen")
    private String img;

    @Column(name = "cantidad_premios")
    private Integer cantPremios;

    @Column(name = "premio_descripcion")
    private String descPremio;

    @OneToOne(targetEntity = Artista.class)
    @JoinColumn(name = "nick")
    private Artista a;

    @OneToMany(targetEntity = Funciones.class, cascade = CascadeType.ALL)
    @JoinTable(name = "espectaculo_funciones",
            joinColumns = @JoinColumn(name = "espectaculo_nombre"),
            inverseJoinColumns = @JoinColumn(name = "funciones_nombre"))
    private List<Funciones> funciones;

    @OneToMany
    @JoinColumn(name = "cat_nombre", referencedColumnName = "categoria_nombre", insertable = false, updatable = false)
    private List<Espectaculo_Categoria> categorias;

    @OneToMany(targetEntity = Paquete.class, cascade = CascadeType.ALL)
    @JoinTable(name = "espectaculo_susPaquetes",
            joinColumns = @JoinColumn(name = "espectaculo_nombre"),
            inverseJoinColumns = @JoinColumn(name = "paquete_nombre"))
    private List<Paquete> paquetes;

    @OneToMany(targetEntity = Puntaje.class)
    @JoinTable(name = "espectaculo_puntajes",
            joinColumns = @JoinColumn(name = "espectaculo_nombre"),
            inverseJoinColumns = @JoinColumn(name = "puntaje_id"))
    private List<Puntaje> puntajes;

    //------------------------//
    public Espectaculo() {
    }

    public Espectaculo(Artista a, String nombre, String descripcion, String url, Integer duracion, Integer min, Integer max, Double cost, String fechaAlt, Estado e, String i, Integer cant, String descP) {
        this.a = a;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.duracion = duracion;
        this.cantMinEsp = min;
        this.cantMaxEsp = max;
        this.costo = cost;
        this.fechaRegistro = fechaAlt;
        this.estado = e;
        this.img = i;
        this.cantPremios = cant;
        this.descPremio = descP;
        this.paquetes = new ArrayList();
        this.puntajes = new ArrayList();
        this.categorias = new ArrayList();
    }

    public List<Espectaculo_Categoria> getCategorias() {
        return categorias;
    }

    public DtEspectaculo getdata() {
        //String nombre, String descripcion, String link, int duracion, int cantMinEsp, int cantMaxEsp, double costo, String fechaRegistro, String img, ListString fun, ListPuntaje pun, Integer cantPremios, String descPremio, DtArtista a, Estado estado
        ListString funciones = new ListString(this.listarFunciones());
        List<DtPuntaje> res = new ArrayList();
        if(this.puntajes!= null){
            for (int i = 0; i < this.puntajes.size(); i++) {
                res.add(this.puntajes.get(i).getData());
            }
        }
        ListPuntaje puntajes = new ListPuntaje(res);
        DtEspectaculo ret = new DtEspectaculo(nombre, descripcion, url, duracion, cantMinEsp, cantMaxEsp, costo, fechaRegistro, img, funciones, puntajes, this.cantPremios, this.descPremio, this.a.getdata(), this.estado);
        return ret;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCantPremios() {
        return cantPremios;
    }

    public String getDescPremio() {
        return descPremio;
    }

    public List<Puntaje> getPuntajes() {
        return puntajes;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrl() {
        return url;
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

    public Estado getEstado() {
        return estado;
    }

    public String getImg() {
        return img;
    }

    public Artista getA() {
        return a;
    }

    public List<Funciones> getFunciones() {
        return funciones;
    }

    //SET
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantPremios(Integer cantPremios) {
        this.cantPremios = cantPremios;
    }

    public void setDescPremio(String descPremio) {
        this.descPremio = descPremio;
    }

    public void setPuntajes(List<Puntaje> puntajes) {
        this.puntajes = puntajes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public void setCategorias(List<Espectaculo_Categoria> categorias) {
        this.categorias = categorias;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setA(Artista a) {
        this.a = a;
    }

    public void setFunciones(List<Funciones> funciones) {
        this.funciones = funciones;
    }

    @Override
    public String toString() {
        return "Espectaculo{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", url=" + url + ", duracion=" + duracion + ", cantMinEsp=" + cantMinEsp + ", cantMaxEsp=" + cantMaxEsp + ", costo=" + costo + ", fechaRegistro=" + fechaRegistro + ", estado=" + estado + ", img=" + img + ", a=" + a + ", funciones=" + funciones + ", categorias=" + categorias + '}';
    }

    public void agregarFuncion(String nombre, String fecha, String hora, String img, List<Artista> a) {
        java.util.Date fe = new java.util.Date();
        String fechaR = fe.toString();
        FuncionesJpaController fu = new FuncionesJpaController();
        EntityManager em = fu.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        Funciones f = new Funciones(nombre, fecha, hora, fechaR, img, a);
        this.funciones.add(f);
        em.persist(f);
        em.merge(this);
        t.commit();
        em.close();
    }

    public List<String> listarFunciones() {
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

    List<String> listarFuncionesVigentes() {
        EspectaculoJpaController espjpa = new EspectaculoJpaController();
        EntityManager em = espjpa.getEntityManager();
        Query q;
        q = em.createQuery("SELECT DISTINCT f.nombre FROM Espectaculo e JOIN Funciones f ON e.funciones.nombre = f.nombre WHERE e.nombre = :nombre");
        q.setParameter("nombre", this.nombre);
        return q.getResultList();
    }

    List<String> listarCategoria() {
        List<String> res = new ArrayList();
        EspectaculoJpaController ejpa = new EspectaculoJpaController();
        EntityManager em = ejpa.getEntityManager();
        Query q = em.createNamedQuery("SELECT e.categorias FROM Espectaculo e JOIN Espectaculo_Categoria ec ON ec.espectaculo_nombre = e.nombre WHERE e.nombre = :nombre");
        q.setParameter("nombre", this.nombre);
        res = q.getResultList();
        return res;
    }
    
    List<String> listarPuntajes(){
        List<String> res = new ArrayList();
        for (int i = 0; i < this.puntajes.size(); i++) {
            res.add(this.puntajes.get(i).getPuntaje().toString());
        }
        return res;
    }

    public List<Premio> sortearPremios(Funciones funcion) {
        return funcion.sortearPremios(this.cantPremios, this.descPremio, this);
    }

    public List<Funciones> listarFuncionesRealizadas() throws ParseException {
        List<Funciones> res = new ArrayList();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String now = simpleDateFormat.format(new Date());
        Date vig = new SimpleDateFormat("yyyy-MM-dd").parse(now);
        for (int i = 0; i < this.funciones.size(); i++) {
            String f = this.funciones.get(i).getFecha();
            Date fechaF = new SimpleDateFormat("yyyy-MM-dd").parse(f);
            if (fechaF.before(vig)) {
                res.add(this.funciones.get(i));
            }
        }
        return res;
    }

    public void agregarPuntaje(Espectador e, Integer puntaje) {
        Puntaje p = new Puntaje(e, puntaje);
        this.puntajes.add(p);
    }
}
