/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DataType.*;
import java.io.File;
import java.sql.Time;
import java.util.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import persistencia.ArtistaJpaController;
import persistencia.CategoriaJpaController;
import persistencia.PlataformaJpaController;
import persistencia.EspectaculoJpaController;
import persistencia.EspectadorJpaController;
import persistencia.FuncionesJpaController;
import persistencia.PaqueteJpaController;
import persistencia.UsuarioJpaController;

public class Sistema extends ISistema {

    private final ArrayList<Usuario> usuarios;
    private final ArrayList<Plataforma> plataformas;
    private final ArrayList<Paquete> paquetes;
    private final ArrayList<Categoria> categorias;
    private static Sistema instancia;
    private Plataforma p;

    private Sistema() {
        this.usuarios = new ArrayList<>();
        this.plataformas = new ArrayList<>();
        this.paquetes = new ArrayList<>();
        this.categorias = new ArrayList<>();
    }

    public static Sistema getInstancia() {
        if (instancia == null) {
            instancia = new Sistema();
        }
        return instancia;
    }

    @Override
    public ArrayList<DTPaquetes> listarPaquete() {
        PaqueteJpaController p = new PaqueteJpaController();
        List<Paquete> list = p.findPaqueteEntities();
        List<DTPaquetes> listar = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            DTPaquetes item = list.get(i).getdata();
            listar.add(item);
        }
        return (ArrayList<DTPaquetes>) listar;
    }

    @Override
    public void seleccionarPaquete(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DTPlataforma> listarPlataformas() {
        PlataformaJpaController p = new PlataformaJpaController();
        List<Plataforma> list = p.findPlataformaEntities();
        List<DTPlataforma> listar = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            DTPlataforma item = list.get(i).getdata();
            listar.add(item);
        }
        return listar;
    }

    @Override
    public void seleccionarPlataforma(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<String> listarEspectaculoQueNoFormanParte(String nombre, String plataforma) {
        EspectaculoJpaController e = new EspectaculoJpaController();
        EntityManager em = e.getEntityManager();
        Query q;
        Query q2;
        
        q = em.createQuery("SELECT p.espectaculos FROM Paquete p WHERE p.nombre = :nombre");
        q2 =em.createQuery  ("SELECT DISTINCT e.nombre FROM Plataforma p JOIN Espectaculo e ON p.espectaculos.nombre = e.nombre WHERE p.nombre = :nombre");
        q.setParameter("nombre", nombre);
        q2.setParameter("nombre", plataforma);
        if(q.getSingleResult() == null){
          
            return q2.getResultList();
            
        }
      else {
            List <String>res = q2.getResultList();
            List <Espectaculo> es = q.getResultList();
            List <String> r = new ArrayList();
            Boolean entro = false;
            for(int i=0; i<res.size(); i++){
                entro = false;
                for(int f=0; f<es.size(); f++){
                    
                    if(res.get(i) == es.get(f).getNombre()){
                       entro=true;
                    
                    
                    }
                
                }
            if(!entro){
                r.add(res.get(i));
            
            
            }
            }
        return q2.getResultList();
        
        }
        
    }

    @Override
    public DTEspectaculo seleccionarEspectaculo(String nombre) {
        EspectaculoJpaController us = new EspectaculoJpaController();
        Espectaculo u = us.findEspectaculo(nombre);
        DTEspectaculo res = u.getdata();
        return res;
    }

    @Override
    public void confirmarAgregarEspectaculoaPaquete(String paquete, String espectaculo) {
        EspectaculoJpaController e = new EspectaculoJpaController ();
        PaqueteJpaController p = new PaqueteJpaController ();
        Espectaculo e1 = e.findEspectaculo(espectaculo);
        Paquete p1 = p.findPaquete(paquete);
        EntityManager em = p.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        p1.agregarPaqueteEs(espectaculo);
        em.merge(p1);
        t.commit();
        em.close();   
    }

    @Override
    public void cancelarAgregarEspectaculoaPaquete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void altaDePlataforma(String nombre, String url, String desc) {
        PlataformaJpaController plaJpa = new PlataformaJpaController();
        Plataforma p = new Plataforma(nombre, url, desc);

        try {
            plaJpa.create(p);
        } catch (Exception ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarDatosE(String nombre, String desc, Time duracion, Integer min, Integer max, Float costo, Date fechaAlt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean existeEspectaculo(String nombre) {
        EspectaculoJpaController esp = new EspectaculoJpaController();
        Espectaculo res = esp.findEspectaculo(nombre);
        if (res != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean existePlataforma(String nombre) {
        PlataformaJpaController plat = new PlataformaJpaController();
        Plataforma res = plat.findPlataforma(nombre);
        if (res != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean existeArtista(String nick) {
        ArtistaJpaController art = new ArtistaJpaController();
        Artista res = art.findArtista(nick);
        if (res != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean existeEspectador(String nick) {
        EspectadorJpaController esp = new EspectadorJpaController();
        Espectador res = esp.findEspectador(nick);
        if (res != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean existePaquete(String nombre) {
        PaqueteJpaController pac = new PaqueteJpaController();
        Paquete res = pac.findPaquete(nombre);
        if (res != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void cancelarEspectaculo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void confirmarEspectaculo(String plataforma, String nick, String nombre, String desc, Integer dur, Integer min, Integer max, Double costo, String fecha, Estado estado, List<String> cat) {
        PlataformaJpaController platJpa = new PlataformaJpaController();
        ArtistaJpaController artJpa = new ArtistaJpaController();
        CategoriaJpaController cjpa = new CategoriaJpaController();
        List<Categoria> c = new ArrayList();
        for (int i = 0; i < cat.size(); i++) {
            c.add(cjpa.findCategoria(cat.get(i)));
        }
        Artista a = artJpa.findArtista(nick);
        EntityManager em = platJpa.getEntityManager();
        Plataforma p;
        EntityTransaction t = em.getTransaction();
        t.begin();
        p = em.find(Plataforma.class, plataforma);
        p.agregarEspectaculo(a, nombre, desc, dur, min, max, costo, fecha, estado, c);
        em.merge(p);
        t.commit();
        em.close();    
    }

    public void confirmarCrearPaquete(String nombre, String descripcion, String fechaI, String fechaF, Double precio, Double descuento) {
        Paquete pa = new Paquete(nombre, descripcion, fechaI, fechaF, precio, descuento);
        PaqueteJpaController pac = new PaqueteJpaController();
        try {
            pac.create(pa);
        } catch (Exception ex) {
            Logger.getLogger(Paquete.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void confirmarUsuario(String nickname, String nombre, String apellido, String email, String fechaNac, File i, String desc, String bio, String link) {

        if (desc == "") {
            Espectador e = new Espectador(nickname, nombre, apellido, email, fechaNac, i);

            EspectadorJpaController espJpa = new EspectadorJpaController();
            try {
                espJpa.create(e);
            } catch (Exception ex) {
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            Artista a = new Artista(nickname, nombre, apellido, email, fechaNac, i, desc, bio, link);

            ArtistaJpaController artJpa = new ArtistaJpaController();
            try {
                artJpa.create(a);
            } catch (Exception ex) {
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void cancelarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<String> listarEspectaculo(String plataforma) {
        PlataformaJpaController pjpa = new PlataformaJpaController();
        Plataforma p = pjpa.findPlataforma(plataforma);
        List<String> ret = p.listarEspectaculos();
        return ret;
    }

    public List<String> listarFuncionesAsociadas(String plataforma ,String espectaculo) {
        PlataformaJpaController pjpa = new PlataformaJpaController();
        Plataforma p = pjpa.findPlataforma(plataforma);
        return p.listarFuncionesDeE(espectaculo);
         
        }

    @Override
    public DTFunciones seleccionarFuncion(String plataforma,String espectaculo ,String nombre) {
        PlataformaJpaController pjpa = new PlataformaJpaController();
        Plataforma p = pjpa.findPlataforma(plataforma);
        return p.seleccionarFuncion(espectaculo ,nombre);
    }

    @Override
    public void crearPaquete(String nombre, String desc, Date fechaI, Date fechaF, Float descuento, Date fechaAlt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancelarCrearPaquete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> listarUsuarios() {
        UsuarioJpaController u = new UsuarioJpaController();
        List<Usuario> list = u.findUsuarioEntities();
        List<String> res = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            res.add(list.get(i).getNick());
        }
        return res;
    }

    
    
    @Override
    public List<String> listarArtistas() {
        ArtistaJpaController a = new ArtistaJpaController();
        List<Artista> list = a.findArtistaEntities();
        List<String> res = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            res.add(list.get(i).getNick());
        }
        return res;
    }

    @Override
    public DTUsuario seleccionarUsuario(String nombre) {
        UsuarioJpaController us = new UsuarioJpaController();
        Usuario u = us.findUsuario(nombre);
        DTUsuario res = u.getData();
        return res;
    }

    @Override
    public void modificarUsuario(String nombre, String apellido, Date fechaNac) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<DTUsuario> listarEspectador() {
        EspectadorJpaController espJpa = new EspectadorJpaController();
        List<Espectador> lesp = espJpa.findEspectadorEntities();
        List<DTUsuario> ret = new ArrayList();
        for (int i = 0; i < lesp.size(); i++) {
            ret.add(lesp.get(i).getData());
        }
        return ret;
    }

    @Override
    public void registrarEspectador(String nickname, Date fecha, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DTRegistro> listarRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void especificarRegistros(Integer id1, Integer id2, Integer id3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seleccionarNuevoEspectador(String nick) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seleccionarNuevaFuncion(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancelarRegistroAFuncionesDeEspectaculo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aceptarComun(String nick, Date fecha, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aceptarCanje(String nick, Date fecha, String nombre, Integer id1, Integer id2, Integer id3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // @Override
    public void confirmarUsuario(String nickname, String nombre, String apellido, String email, Date fechaNac, String desc, String bio, String link) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarEspectador(String nick, String nombre, String apellido, String fecha) {
        EspectadorJpaController esp = new EspectadorJpaController();
        EntityManager em = esp.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        Espectador e = em.find(Espectador.class, nick);
        e.setApellido(apellido);
        e.setFechaNac(fecha);
        e.setNombre(nombre);
        em.merge(e);
        t.commit();
        em.close();
    }

    @Override
    public void modificarArtista(String nick, String nombre, String apellido, String fecha, String bio, String desc, String link) {
        ArtistaJpaController esp = new ArtistaJpaController();
        EntityManager em = esp.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        Artista a = em.find(Artista.class, nick);
        a.setApellido(apellido);
        a.setFechaNac(fecha);
        a.setNombre(nombre);
        a.setBio(bio);
        a.setDesc(desc);
        a.setLink(link);
        em.merge(a);
        t.commit();
        em.close();
    }

    @Override
    public boolean existeFuncion(String nombre) {
        FuncionesJpaController f = new FuncionesJpaController();
        Funciones fu = f.findFunciones(nombre);
        if (fu == null) {
            return false;
        } else {
            return true;
        }
    }
    public boolean existeFuncionenE(String espectaculo ,String nombre) {
        EspectaculoJpaController e = new EspectaculoJpaController();
        Espectaculo esp = e.findEspectaculo(espectaculo);
        return esp.existeFuncion(nombre);
    }

    @Override
    public void altaFuncion(String plataforma, String espectaculo, String nombre, String fecha, String hora) {
        PlataformaJpaController p = new PlataformaJpaController();
        Plataforma p1 = p.findPlataforma(plataforma);
        EntityManager em = p.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        Espectaculo e = p1.agregarFuncion(espectaculo,nombre,fecha,hora);
        em.merge(e);
        t.commit();
        em.close();
    }

    public List<DTFunciones> listarFuncionesAsociadas(String espectaculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    public void confirmarCategoria(String nombre){
    Categoria c = new Categoria(nombre);
        CategoriaJpaController ca = new CategoriaJpaController();
        try {
            ca.create(c);
        } catch (Exception ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
    public boolean existeCategoria(String nombre){
    CategoriaJpaController c = new CategoriaJpaController();
    Categoria ca = c.findCategoria(nombre);
        if (ca == null) {
            return false;
        } else {
            return true;
        }
    
    }
    
    
     public List<String> listarPaquetes() {
        PaqueteJpaController p = new PaqueteJpaController();
        List<Paquete> list = p.findPaqueteEntities();
        List<String> res = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            res.add(list.get(i).getNombre());
        }
        return res;
    }
    
     
     public DTPaquetes seleccionarPaquetes(String nombre) {
        PaqueteJpaController us = new PaqueteJpaController();
        Paquete u = us.findPaquete(nombre);
        DTPaquetes res = u.getData();
        return res;
    }
     
  public List<String> listarEspectaculoP(String paquete) {
        PaqueteJpaController pjpa = new PaqueteJpaController();
        Paquete p = pjpa.findPaquete(paquete);
        List<String> ret = p.listarEspectaculos();
        return ret;
    }
  
  
  public List<String> listarPlataforma(){
   PlataformaJpaController p = new  PlataformaJpaController();
        List<Plataforma> list = p.findPlataformaEntities();
        List<String> res = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            res.add(list.get(i).getNombre());
        }
        return res;
  
  }
  
   public List<String> listarEspectaculoPl(String plataforma) {
       PlataformaJpaController pjpa = new PlataformaJpaController();
        Plataforma p = pjpa.findPlataforma(plataforma);
        List<String> ret = p.listarEspectaculos();
        return ret;
    }

    @Override
    public int aceptarRegisto(String plataforma, String espectaculo, String funcion, String usuario, Date fecha) {
        PlataformaJpaController pjpa = new PlataformaJpaController();
        Plataforma p = pjpa.findPlataforma(plataforma);
        return p.registrarEspectador(espectaculo, funcion, usuario, fecha);
        }
   
   public List<String> listarEspectaculosNoProcesados(){
       EspectaculoJpaController ejpa = new EspectaculoJpaController();
       EntityManager em = ejpa.getEntityManager();
       Query q;
       Estado estado = Estado.ingresado;
       q = em.createQuery("SELECT e.nombre FROM Espectaculo e WHERE e.estado = :est");
       q.setParameter("est", estado);
       return q.getResultList();    
   }

    @Override
    public void estadoEspectaculo(String espectaculo, Estado es) {
        EspectaculoJpaController ejpa = new EspectaculoJpaController();
        Espectaculo e = ejpa.findEspectaculo(espectaculo);
        EntityManager em = ejpa.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        e.setE(es);
        em.merge(e);
        t.commit();
        em.close();
        
    }

    @Override
    public List<String> listarCategorias() {
        CategoriaJpaController cjpa = new CategoriaJpaController();
        EntityManager em = cjpa.getEntityManager();
        Query q;
        q = em.createQuery("SELECT c.nombre FROM Categoria c");
        return q.getResultList();
    }
}
