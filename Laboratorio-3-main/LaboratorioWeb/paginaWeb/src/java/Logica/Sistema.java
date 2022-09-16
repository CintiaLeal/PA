package Logica;

import DataType.*;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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
import persistencia.RegistroJpaController;
import persistencia.UsuarioJpaController;
import java.sql.Blob;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import persistencia.AgenteJpaController;
import persistencia.CompraJpaController;

public class Sistema extends ISistema {

    private final ArrayList<Usuario> usuarios;
    private final ArrayList<Plataforma> plataformas;
    private final ArrayList<Paquete> paquetes;
    private final ArrayList<Categoria> categorias;
    private static Sistema instancia;
    private Blob b;

    public Sistema() {
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
            DTPaquetes item = list.get(i).getData();
            listar.add(item);
        }
        if (listar.size() == 0) {
            return null;
        }
        return (ArrayList<DTPaquetes>) listar;
    }

    @Override
    public void seleccionarPaquete(String nombre) {
        //UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        if (listar.size() < 0) {
            return listar;
        }
        return null;

    }

    @Override
    public void seleccionarPlataforma(String nombre) {
        //UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> listarEspectaculoQueNoFormanParte(String nombre, String plataforma) {
        EspectaculoJpaController e = new EspectaculoJpaController();
        EntityManager em = e.getEntityManager();
        Query q;
        Query q2;

        q = em.createQuery("SELECT p.espectaculos FROM Paquete p WHERE p.nombre = :nombre");
        q2 = em.createQuery("SELECT DISTINCT e.nombre FROM Plataforma p JOIN Espectaculo e ON p.espectaculos.nombre = e.nombre WHERE p.nombre = :nombre");
        q.setParameter("nombre", nombre);
        q2.setParameter("nombre", plataforma);
        if (q.getResultList().toString().equals("[null]")) {
            return q2.getResultList();
        } else {
            List<String> res = q2.getResultList();
            List<Espectaculo> es = q.getResultList();
            List<String> r = new ArrayList();
            Boolean entro = false;
            for (int i = 0; i < res.size(); i++) {
                entro = false;
                for (int f = 0; f < es.size(); f++) {

                    if (res.get(i).equals(es.get(f).getNombre())) {
                        entro = true;
                    }
                }
                if (!entro) {
                    r.add(res.get(i));
                }
            }
            return q2.getResultList();
        }
    }

    //Verificar si publicar
    @Override
    public DtEspectaculo seleccionarEspectaculo(String nombre) {
        EspectaculoJpaController us = new EspectaculoJpaController();
        Espectaculo u = us.findEspectaculo(nombre);
        if (u == null) {
            return null;
        }
        DtEspectaculo res = u.getdata();
        return res;
    }

    @Override
    public boolean confirmarAgregarEspectaculoaPaquete(String paquete, String espectaculo) {
        EspectaculoJpaController e = new EspectaculoJpaController();
        PaqueteJpaController p = new PaqueteJpaController();
        Espectaculo e1 = e.findEspectaculo(espectaculo);
        if (e1 == null) {
            return false;
        }
        Paquete p1 = p.findPaquete(paquete);
        if (p1 == null) {
            return false;
        }
        List<Paquete> items = new ArrayList();
        items.add(p1);
        EntityManager em = p.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        p1.agregarPaqueteEs(espectaculo);
        e1.setPaquetes(items);
        em.merge(p1);
        em.merge(e1);
        t.commit();
        em.close();
        return true;
    }

    @Override
    public void cancelarAgregarEspectaculoaPaquete() {
        ////UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean altaDePlataforma(String nombre, String url, String desc) {
        if (nombre == "") {
            return false;
        }
        PlataformaJpaController plaJpa = new PlataformaJpaController();
        Plataforma p = new Plataforma(nombre, url, desc);

        try {
            plaJpa.create(p);
        } catch (Exception ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public void modificarDatosE(String nombre, String desc, Time duracion, Integer min, Integer max, Float costo, Date fechaAlt) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public boolean existeUsuario(String nick) {
        UsuarioJpaController art = new UsuarioJpaController();
        Usuario res = art.findUsuario(nick);
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean confirmarEspectaculo(String plataforma, String nick, String nombre, String desc, String url, Integer dur, Integer min, Integer max, Double costo, String fecha, Estado estado, ListString c1, String img, Integer cant, String descP) {
        if (plataforma == "" || nick == "") {
            return false;
        }
        List<String> cat = c1.getLista();
        PlataformaJpaController platJpa = new PlataformaJpaController();
        ArtistaJpaController artJpa = new ArtistaJpaController();
        CategoriaJpaController cjpa = new CategoriaJpaController();
        EntityManager em = platJpa.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        List<Categoria> c = new ArrayList();
        for (int i = 0; i < cat.size(); i++) {
            if (cjpa.findCategoria(cat.get(i)) != null) { //verifica que la categoria exista en la bd antes de agregarla
                c.add(cjpa.findCategoria(cat.get(i)));
            }
        }
        Artista a = artJpa.findArtista(nick);

        Plataforma p = platJpa.findPlataforma(plataforma);
        if (p == null) {
            return false;
        }
        em.persist(p.agregarEspectaculo(a, nombre, desc, url, dur, min, max, costo, fecha, estado, c, img, cant, descP));
        em.merge(p);
        t.commit();
        em.close();
        return true;
    }

    public boolean confirmarCrearPaquete(String nombre, String descripcion, String fechaI, String fechaF, String fechaA, Double precio, Double descuento, String img) {
        if (nombre == "") {
            return false;
        }
        Paquete pa = new Paquete(nombre, descripcion, fechaI, fechaF, fechaA, precio, descuento, img);
        PaqueteJpaController pac = new PaqueteJpaController();
        try {
            pac.create(pa);
        } catch (Exception ex) {
            Logger.getLogger(Paquete.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean confirmarUsuario(String nickname, String nombre, String apellido, String email, String fechaNac, String pws, String i, String desc, String bio, String link) {
        if (nickname == "") {
            return false;
        }
        if (desc == "") {
            Espectador e = new Espectador(nickname, nombre, apellido, email, fechaNac, pws, i);

            EspectadorJpaController espJpa = new EspectadorJpaController();
            try {
                espJpa.create(e);
            } catch (Exception ex) {
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Artista a = new Artista(nickname, nombre, apellido, email, fechaNac, pws, i, desc, bio, link);

            ArtistaJpaController artJpa = new ArtistaJpaController();
            try {
                artJpa.create(a);
            } catch (Exception ex) {
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (this.existeUsuario(nickname)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void cancelarUsuario() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<String> listarEspectaculo(String plataforma) {
        if (plataforma == "") {
            return null;
        }
        PlataformaJpaController pjpa = new PlataformaJpaController();
        Plataforma p = pjpa.findPlataforma(plataforma);
        if (p == null) {
            return null;
        }
        List<String> ret = p.listarEspectaculos();
        return ret;
    }

    //Lista los espectaculos para una categoria
    @Override
    public List<String> listarEspectaculoCategoria(String Categoria) {
        if (Categoria == "") {
            return null;
        }
        CategoriaJpaController cjpa = new CategoriaJpaController();
        Categoria c = cjpa.findCategoria(Categoria);
        List<String> ret = c.listarEspectaculos();
        if (ret.size() < 0) {
            return null;
        }
        return ret;
    }

    @Override
    public List<String> listarFuncionesAsociadas(String plataforma, String espectaculo) {
        PlataformaJpaController pjpa = new PlataformaJpaController();
        Plataforma pp = pjpa.findPlataforma(plataforma);
        if (pp != null) {
            return pp.listarFuncionesDeE(espectaculo);
        } else {
            List<String> list = null;
            return list;
        }
    }

    public List<String> listarFuncionesVigentes(String plataforma, String espectaculo) {
        PlataformaJpaController pjpa = new PlataformaJpaController();
        Plataforma p = pjpa.findPlataforma(plataforma);
        if (p == null) {
            List<String> list = null;
            return list;
        }
        return p.listarFuncionesVigentesDeE(espectaculo);

    }
//aun no va el server

    public List<String> listarFuncionesvigentesCategoria(String Categoria, String espectaculo) {
        if (Categoria == "" || espectaculo == "") {
            return null;
        }
        CategoriaJpaController pjpa = new CategoriaJpaController();
        Categoria c = pjpa.findCategoria(Categoria);
        if (c != null) {
            return c.listarFuncionesVigentesDeE(espectaculo);
        } else {
            return null;
        }
    }
//aun no va el server

    public List<String> listarFuncionesAsociadasCategoria(String Categoria, String espectaculo) {
        CategoriaJpaController cjpa = new CategoriaJpaController();
        Categoria c = cjpa.findCategoria(Categoria);
        if (c != null) {
            return c.listarFuncionesDeE(espectaculo);
        }
        return null;
    }

    public DTFunciones seleccionarFuncionCategoria(String Categoria, String espectaculo, String nombre) {
        if (Categoria == "" || espectaculo == "" || nombre == "") {
            return null;
        }
        CategoriaJpaController cjpa = new CategoriaJpaController();
        Categoria c = cjpa.findCategoria(Categoria);
        return c.seleccionarFuncion(espectaculo, nombre);
    }

    @Override
    public DTFunciones seleccionarFuncion(String plataforma, String espectaculo, String nombre) {
        if (plataforma == "") {
            return null;
        }
        PlataformaJpaController pjpa = new PlataformaJpaController();
        Plataforma p = pjpa.findPlataforma(plataforma);
        if (p == null) {
            return null;
        }
        return p.seleccionarFuncion(espectaculo, nombre);
    }

    @Override
    public void crearPaquete(String nombre, String desc, Date fechaI, Date fechaF, Float descuento, Date fechaAlt) {
        //UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancelarCrearPaquete() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> listarUsuarios() {
        UsuarioJpaController u = new UsuarioJpaController();
        List<Usuario> list = u.findUsuarioEntities();
        List<String> res = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            res.add(list.get(i).getNick());
        }
        if (res.size() == 0) {
            return null;
        }
        return res;
    }

    @Override
    public List<String> listarArtistas() {
        ArtistaJpaController a = new ArtistaJpaController();
        List<Artista> list = a.findArtistaEntities();
        List<String> res = new ArrayList();
        if (list == null) {
            res = null;
            return res;
        }
        for (int i = 0; i < list.size(); i++) {
            res.add(list.get(i).getNick());
        }
        return res;
    }

    @Override
    public DTUsuario seleccionarUsuario(String nombre) {
        if (nombre == "") {
            return null;
        }
        UsuarioJpaController us = new UsuarioJpaController();
        Usuario u = us.findUsuario(nombre);
        if (u == null) {
            return null;
        }
        DTUsuario res = u.getData();
        return res;
    }

    @Override
    public void modificarUsuario(String nombre, String apellido, Date fechaNac) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<DTUsuario> listarEspectador() {
        EspectadorJpaController espJpa = new EspectadorJpaController();
        List<Espectador> lesp = espJpa.findEspectadorEntities();
        List<DTUsuario> ret = new ArrayList();
        for (int i = 0; i < lesp.size(); i++) {
            ret.add(lesp.get(i).getData());
        }
        if (ret.size() == 0) {
            return null;
        }
        return ret;
    }

    public boolean registrarEspectador(String fecha, String nick, String fun, ListString reg1, double costo, String paquete) {
        if (fun == null || nick == "") {
            return false;
        }
        FuncionesJpaController fjpa = new FuncionesJpaController();
        EspectadorJpaController ejpa = new EspectadorJpaController();
        EntityManager em = ejpa.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Espectador es = ejpa.findEspectador(nick);
        Funciones funcion = fjpa.findFunciones(fun);
        Paquete p = null;
        Compra c = null;
        List<String> reg = null;
        if (reg1 != null) {
            reg = reg1.getLista();
        }
        List<Registro> registros = null;
        if (funcion.getMaxRegs() > funcion.getRegistros().size()) {
            if (reg != null) {
                RegistroJpaController regi = new RegistroJpaController();
                registros = new ArrayList();
                for (int i = 0; i < reg.size(); i++) {
                    Registro s = regi.findRegistro(Integer.parseInt(reg.get(i)));
                    registros.add(s);
                    es.borrarregistro(s);
                }
                costo = 0;
            }
            if (paquete != null) {
                PaqueteJpaController paq = new PaqueteJpaController();
                p = paq.findPaquete(paquete);
                c = new Compra(es, p);
                costo = costo - p.getDescuento();
            }
            Registro r = new Registro(fecha, es, funcion, registros, costo, c);
            es.agregarregistro(r);
            funcion.agregarregistro(r);
            em.persist(r);
            em.merge(funcion);
            em.merge(es);
            et.commit();
            em.close();
        }
        Registro r = new Registro(fecha, es, funcion, registros, costo, c);
        es.agregarregistro(r);
        funcion.agregarregistro(r);
        em.persist(r);
        em.merge(funcion);
        em.merge(es);
        et.commit();
        em.close();
        return true;
    }

    public List<String> listarRegistros(String nick) {
        if (nick == "") {
            return null;
        }
        double costo = 0;
        EspectadorJpaController e = new EspectadorJpaController();
        EntityManager em = e.getEntityManager();
        Query q;
        q = em.createQuery("SELECT r.id FROM Registro r WHERE r.espectador.nick =:nick AND r.costo =:costo");
        q.setParameter("nick", nick);
        q.setParameter("costo", costo);
        return q.getResultList();
    }

    @Override
    public void especificarRegistros(Integer id1, Integer id2, Integer id3) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seleccionarNuevoEspectador(String nick) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seleccionarNuevaFuncion(String nombre) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancelarRegistroAFuncionesDeEspectaculo() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aceptarComun(String nick, Date fecha, String nombre) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aceptarCanje(String nick, Date fecha, String nombre, Integer id1, Integer id2, Integer id3) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // @Override
    public boolean confirmarUsuario(String nickname, String nombre, String apellido, String email, Date fechaNac, String desc, String bio, String link) {
        //UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return false;
    }

    @Override
    public void modificarEspectador(String nick, String nombre, String apellido, String fecha, String img) {
        if (nick == "") {
            return;
        }
        EspectadorJpaController esp = new EspectadorJpaController();
        EntityManager em = esp.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        Espectador e = esp.findEspectador(nick);
        if (!apellido.equals("")) {
            e.setApellido(apellido);
        }
        if (!nombre.equals("")) {
            e.setNombre(nombre);
        }
        if (!fecha.equals("")) {
            e.setFechaNac(fecha);
        }
        if (!img.equals("")) {
            e.setImg(img);
        }
        em.merge(e);
        t.commit();
        em.close();
    }

    @Override
    public void modificarArtista(String nick, String nombre, String apellido, String fecha, String bio, String desc, String link, String img) {
        ArtistaJpaController esp = new ArtistaJpaController();
        EntityManager em = esp.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        Artista a = esp.findArtista(nick);
        if (a != null) {
            if (!nombre.equals("")) {
                a.setNombre(nombre);
            }
            if (!apellido.equals("")) {
                a.setApellido(apellido);
            }
            if (!fecha.equals("")) {
                a.setFechaNac(fecha);
            }
            if (!bio.equals("")) {
                a.setBio(bio);
            }
            if (!desc.equals("")) {
                a.setDesc(desc);
            }
            if (!link.equals("")) {
                a.setLink(link);
            }
            if (!img.equals("")) {
                a.setImg(img);
            }
            em.merge(a);
            t.commit();
            em.close();
        }
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

    @Override
    public boolean existeFuncionenE(String espectaculo, String nombre) {
        EspectaculoJpaController e = new EspectaculoJpaController();
        Espectaculo esp = e.findEspectaculo(espectaculo);
        if (esp == null) {
            return false;
        }
        return esp.existeFuncion(nombre);
    }

    public List<DTFunciones> listarFuncionesAsociadas(String espectaculo) {
        //UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    @Override
    public boolean confirmarCategoria(String nombre) {
        Categoria c = new Categoria(nombre);
        CategoriaJpaController ca = new CategoriaJpaController();
        try {
            ca.create(c);
        } catch (Exception ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (this.existeCategoria(nombre)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existeCategoria(String nombre) {
        CategoriaJpaController c = new CategoriaJpaController();
        Categoria ca = c.findCategoria(nombre);
        if (ca == null) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public List<String> listarPaquetes() {
        PaqueteJpaController p = new PaqueteJpaController();
        List<Paquete> list = p.findPaqueteEntities();
        List<String> res = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            res.add(list.get(i).getNombre());
        }
        if (res.size() == 0) {
            return null;
        }
        return res;
    }

    public DTPaquetes seleccionarPaquetes(String nombre) {
        if (nombre == "") {
            return null;
        }
        PaqueteJpaController us = new PaqueteJpaController();
        Paquete u = us.findPaquete(nombre);
        if (u == null) {
            return null;
        }
        DTPaquetes res = u.getData();
        return res;
    }

    public List<String> listarEspectaculoP(String paquete) {
        if (paquete == "") {
            return null;
        }
        PaqueteJpaController pjpa = new PaqueteJpaController();
        Paquete p = pjpa.findPaquete(paquete);
        if (p == null) {
            return null;
        }
        List<String> ret = p.listarEspectaculos();
        return ret;
    }

    public List<String> listarPlataforma() {
        PlataformaJpaController p = new PlataformaJpaController();
        List<Plataforma> list = p.findPlataformaEntities();
        List<String> res = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            res.add(list.get(i).getNombre());
        }
        return res;

    }

    public List<String> listarEspectaculoPl(String plataforma) {
        if (plataforma == "") {
            return null;
        }
        PlataformaJpaController pjpa = new PlataformaJpaController();
        Plataforma p = pjpa.findPlataforma(plataforma);
        if (p == null) {
            return null;
        }
        List<String> ret = p.listarEspectaculos();
        return ret;
    }

    @Override
    public int aceptarRegisto(String plataforma, String espectaculo, String funcion, String usuario, Date fecha) {
        PlataformaJpaController pjpa = new PlataformaJpaController();
        Plataforma p = pjpa.findPlataforma(plataforma);
        if (p == null) {
            return 0;
        }
        return p.registrarEspectador(espectaculo, funcion, usuario, fecha);
    }

    public List<String> listarEspectaculosNoProcesados() {
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
        if (espectaculo == "") {
            return;
        }
        EspectaculoJpaController ejpa = new EspectaculoJpaController();
        Espectaculo e = ejpa.findEspectaculo(espectaculo);
        if (e == null) {
            return;
        }
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

    public List<String> listarCategoriaPE(String nombre) {
        if (nombre == "") {
            return null;
        }
        CategoriaJpaController ejpa = new CategoriaJpaController();
        EntityManager em = ejpa.getEntityManager();
        Query q;
        Query q1;

        q = em.createQuery("SELECT e.nombre FROM Paquete p JOIN Espectaculo e ON e.nombre = p.espectaculos.nombre WHERE p.nombre=:paq");
        q.setParameter("paq", nombre);

        List<String> espectaculos = q.getResultList();
        List<String> resultado = new ArrayList();
        List<String> aux = new ArrayList();

        for (int i = 0; i < espectaculos.size(); i++) {
            q1 = em.createQuery("SELECT e.id_categoria FROM Espectaculo_Categoria e WHERE e.id_espectaculo=:esp");
            q1.setParameter("esp", espectaculos.get(i));
            //resultado.add(i, q1.getResultList());
            aux = q1.getResultList();
            for (int j = 0; j < aux.size(); j++) {
                if (!resultado.contains(aux.get(j))) {
                    resultado.add(aux.get(j));
                }
            }
        }
        return resultado;
    }

    public int validarUsuario(String nick, String pwd) {
        UsuarioJpaController u = new UsuarioJpaController();
        Usuario user = u.findUsuario(nick);
        //0 no existe o no coincide la pwd
        //1 es espectador
        //2 es artista
        if ((user != null) && (user.getPwd().equals(pwd))) {
            if (this.existeArtista(nick)) {
                return 2;
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }

    //Listar Categorias del espectaculo
    @Override
    public List<String> listarCategoriaE(String nombre) {
        if ("".equals(nombre)) {
            return null;
        }
        EspectaculoJpaController c = new EspectaculoJpaController();
        Espectaculo e = c.findEspectaculo(nombre);
        if (e == null) {
            return null;
        } else {
//            List<String> res = new ArrayList();
            List<String> res = e.listarCategoria();
//        EntityManager em = c.getEntityManager();
//        Query q = em.createNamedQuery("SELECT c.nombre FROM Categoria c JOIN Espectaculo_Categoria ec ON ec.id_categoria = c.nombre WHERE ec.id_espectaculo=:nombre");
//        q.setParameter("nombre", nombre);
//        List<String> res = q.getResultList();
            return res;
        }
    }

    //Buscar un usuario espectador
    @Override
    public DTEspectador buscarEspectador(String nick) {
        EspectadorJpaController e = new EspectadorJpaController();
        Espectador esp = e.findEspectador(nick);
        DTEspectador espectador = esp.getdata();
        return espectador;
    }

    //Buscar un usuario paquete
    @Override
    public DTPaquetes buscarPaquete(String nombre) {
        PaqueteJpaController e = new PaqueteJpaController();
        Paquete p = e.findPaquete(nombre);
        return p.getData();
    }

    //Buscar un usuario paquete
    @Override
    public DtEspectaculo buscarEspectaculo(String nombre) {
        EspectaculoJpaController e = new EspectaculoJpaController();
        Espectaculo esp = e.findEspectaculo(nombre);
        return esp.getdata();
    }

    @Override
    public Funciones buscarFunciones(String nombre) {
        FuncionesJpaController e = new FuncionesJpaController();
        return e.findFunciones(nombre);
    }

    //1 es espectador
    //2 es artista
    @Override
    public int tipoUsuario(String nick) {
        if (nick == null || nick.equals("")) {
            return 0;
        }
        UsuarioJpaController u = new UsuarioJpaController();
        Usuario user = u.findUsuario(nick);
        //0 no existe o no coincide la pwd
        //1 es espectador
        //2 es artista
        if (user != null) {
            if (this.existeArtista(nick)) {
                return 2;
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }

    //seguir a un usuario
    @Override
    public void seguirUsuario(String seguido, String seguidor) {
        if (seguido == "" || seguidor == "") {

        }
        UsuarioJpaController ujpa = new UsuarioJpaController();
        EntityManager em = ujpa.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        Usuario useguido = ujpa.findUsuario(seguido);
        Usuario useguidor = ujpa.findUsuario(seguidor);
        if (useguidor == null) {
            t.commit();
            em.close();
            return;
        }
        useguidor.seguirUsuario(useguido);
        em.merge(useguidor);
        t.commit();
        em.close();

    }

    @Override
    public boolean relacionUsuario(String seguidor, String seguido) {
        if (seguidor == null || seguidor.equals("")) {
            return false;
        }
        UsuarioJpaController ujpa = new UsuarioJpaController();
        Usuario useguido = ujpa.findUsuario(seguido);
        List<Usuario> lista = useguido.getSeguidores();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNick().equals(seguidor)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void dejarDeSeguir(String seguido, String seguidor) {
        if (seguido == "" || seguidor == "") {
            return;
        }
        UsuarioJpaController ujpa = new UsuarioJpaController();
        EntityManager em = ujpa.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        Usuario useguido = ujpa.findUsuario(seguido);
        Usuario useguidor = ujpa.findUsuario(seguidor);
        useguidor.dejarDeSeguirUsuario(useguido);
        em.merge(useguido);
        em.merge(useguidor);
        t.commit();
        em.close();
    }

    @Override
    public List<String> listarPaqueteEspectaculo(String espectaculo) {

        EspectaculoJpaController ejpa = new EspectaculoJpaController();
        Espectaculo e = ejpa.findEspectaculo(espectaculo);
        if (e == null) {
            List<String> ret = null;
            return ret;
        }
        List<Paquete> ps = e.getPaquetes();
        List<String> paq = new ArrayList();
        for (int i = 0; i < ps.size(); i++) {
            paq.add(ps.get(i).getNombre());
        }
        return paq;
    }

    @Override
    public Artista buscarArtista(String nick) {
        ArtistaJpaController e = new ArtistaJpaController();
        return e.findArtista(nick);
    }

    @Override
    public void comprarPaquete(String nick, String paquete) {
        if (nick == "" || paquete == "") {
            return;
        }
        EspectadorJpaController ejpa = new EspectadorJpaController();
        PaqueteJpaController pjpa = new PaqueteJpaController();
        EntityManager em = ejpa.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        Espectador e = ejpa.findEspectador(nick);
        if (e == null) {
            t.commit();
            em.close();
            return;
        }
        Paquete paq = pjpa.findPaquete(paquete);

        e.comprarPaquete(paq);
        em.merge(e);
        t.commit();
        em.close();
    }

    @Override
    public List<String> listarPaquetesVigentes() {
        PaqueteJpaController p = new PaqueteJpaController();
        List<Paquete> list = p.findPaqueteEntities();
        List<String> res = new ArrayList();
        try {
            Date now = new Date();
            Date vig = new SimpleDateFormat("yyyy-MM-dd").parse(now.toString());
            for (int i = 0; i < list.size(); i++) {
                Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(list.get(i).getFechaF());
                if (fecha.compareTo(vig) > 0) {
                    res.add(list.get(i).getNombre());
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (res.size() == 0) {
            return null;
        }
        return res;
    }

    @Override
    public List<String> paquetesNoComprados(String es) {
        List<String> aux = new ArrayList();
        if (es == null || es.equals("")) {
            aux.add("primer if");
            return aux;
        }
        EspectadorJpaController ejpa = new EspectadorJpaController();
        Espectador e = ejpa.findEspectador(es);
        List<String> paq = e.listarPaquetes();
        List<String> ps = this.listarPaquetes();
        if (ps == null) {
            aux.add("segundo if");
            return aux;
        }
        for (int i = 0; i < paq.size(); i++) {
            ps.remove(paq.get(i));
        }
        if (ps.size() == 0) {
            aux.add("tercer if");
            return aux;
        }
        return ps;
    }

    @Override
    public void altaFuncion(String plataforma, String espectaculo, ListString artista1, String nombre, String fecha, String hora, String img) {
        if (plataforma == "") {
            return;
        }
        PlataformaJpaController p = new PlataformaJpaController();
        ArtistaJpaController uJpa = new ArtistaJpaController();
        List<Artista> c = new ArrayList();
        List<String> artista = artista1.getLista();
        for (int i = 0; i < artista.size(); i++) {
            c.add(uJpa.findArtista(artista.get(i)));
        }

        Plataforma p1 = p.findPlataforma(plataforma);
        EntityManager em = p.getEntityManager();
        EntityTransaction t = em.getTransaction();
        if (p1 == null) {
            return;
        }
        t.begin();
        Espectaculo e = p1.agregarFuncion(espectaculo, nombre, fecha, hora, img, c);
        em.merge(e);
        t.commit();
        em.close();
    }

    @Override
    public List<String> listarEspectaculosAceptado(String plataforma) {
        if (plataforma == "") {
            return null;
        }
        EspectaculoJpaController ejpa = new EspectaculoJpaController();
        EntityManager em = ejpa.getEntityManager();
        Query q;
        Estado estado = Estado.aceptado;
        q = em.createQuery("SELECT DISTINCT e.nombre FROM Plataforma p JOIN Espectaculo e ON p.espectaculos.nombre = e.nombre WHERE p.nombre = :plataforma AND e.estado = :est");
        q.setParameter("est", estado);
        q.setParameter("plataforma", plataforma);
        return q.getResultList();
    }

    @Override
    public List<String> listarEspectaculosAceptadoCategoria(String categoria) {
        if (categoria == "") {
            return null;
        }
        EspectaculoJpaController ejpa = new EspectaculoJpaController();
        EntityManager em = ejpa.getEntityManager();
        Query q;
        Estado estado = Estado.aceptado;
        q = em.createQuery("SELECT DISTINCT e.nombre FROM Categoria c JOIN Espectaculo_Categoria ec ON ec.id_categoria = c.nombre JOIN Espectaculo e ON ec.id_espectaculo = e.nombre WHERE c.nombre = :categoria AND e.estado = :est");
        q.setParameter("est", estado);
        q.setParameter("categoria", categoria);
        return q.getResultList();
    }

    @Override
    public boolean estarRegistrado(String nick, String fun) {
        RegistroJpaController rjpa = new RegistroJpaController();
        EntityManager em = rjpa.getEntityManager();
        Query q;
        q = em.createQuery("SELECT r.id FROM Registro r WHERE r.funciones.nombre =:fun AND r.espectador.nick =:nick ");
        q.setParameter("nick", nick);
        q.setParameter("fun", fun);
        if (q.getResultList().toString().equals("[]")) {
            return false;
        }
        return true;
    }

    @Override
    public boolean estaComprado(String nick, String paquete) {
        if (nick == "" || paquete == "") {
            return false;
        }
        EspectadorJpaController ejpa = new EspectadorJpaController();
        Espectador e = ejpa.findEspectador(nick);
        List<Paquete> paquetes = e.getPaquetes();
        for (int i = 0; i < paquetes.size(); i++) {
            if (paquetes.get(i).getNombre().equals(paquete)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> listarBusqueda(String valor) {
        if (valor == "") {
            return null;
        }
        EspectaculoJpaController ejpa = new EspectaculoJpaController();
        EntityManager em = ejpa.getEntityManager();
        Query q;
        Query q1;
        q = em.createQuery("SELECT p.nombre FROM Paquete p WHERE p.nombre LIKE CONCAT('%',:valor,'%') OR p.descripcion LIKE CONCAT('%',:valor,'%') ");
        q.setParameter("valor", valor);

        q1 = em.createQuery("SELECT e.nombre FROM Espectaculo e WHERE e.nombre LIKE CONCAT('%',:valor,'%') OR e.descripcion LIKE CONCAT('%',:valor,'%') ");
        q1.setParameter("valor", valor);
        List<String> newList = new ArrayList();

        newList.addAll(q.getResultList());
        newList.addAll(q1.getResultList());

        return newList;
    }

    @Override
    public List<DtBusqueda> devolverBusqueda(String valor) {
//        if (valor == "") {
//            return null;
//        }
        EspectaculoJpaController ejpa = new EspectaculoJpaController();
        PaqueteJpaController pjpa = new PaqueteJpaController();
        EntityManager em = ejpa.getEntityManager();
        Query q;
        Query q1;
        q = em.createQuery("SELECT p.nombre FROM Paquete p WHERE p.nombre LIKE CONCAT('%',:valor,'%') OR p.descripcion LIKE CONCAT('%',:valor,'%') ");
        q.setParameter("valor", valor);
        List<String> query1 = q.getResultList();

        q1 = em.createQuery("SELECT e.nombre FROM Espectaculo e WHERE e.nombre LIKE CONCAT('%',:valor,'%') OR e.descripcion LIKE CONCAT('%',:valor,'%') ");
        q1.setParameter("valor", valor);
        List<String> query2 = q1.getResultList();

        List<DtBusqueda> res = new ArrayList();
        PlataformaJpaController ppla = new PlataformaJpaController();
        List<Plataforma> listp = ppla.findPlataformaEntities();
        for (int i = 0; i < query1.size(); i++) {
            List<String> aux = new ArrayList();
            List<String> listaCat = this.listarCategoriaPE(query1.get(i));
            //List<String> listaPla = 
            Paquete paquete = pjpa.findPaquete(query1.get(i));
            List<Espectaculo> listaEspp = paquete.getEspectaculos();
            for (int j = 0; j < listaEspp.size(); j++) {
                for (int k = 0; k < listp.size(); k++) {
                    List<String> listaEdep = listp.get(k).listarEspectaculos();
                    for (int l = 0; l < listaEdep.size(); l++) {
                        if (listaEspp.get(j).getNombre().equals(listaEdep.get(l))) {
                            if (aux.contains(listp.get(k).getNombre())) {
                            } else {
                                aux.add(listp.get(k).getNombre());
                            }
                        }
                    }
                }
            }
            DtBusqueda item = new DtBusqueda(paquete.getNombre(), paquete.getFechaA(), listaCat, aux);
            res.add(item);
        }
        for (int i = 0; i < query2.size(); i++) {
            List<String> listaCat = this.listarCategoriaE(query2.get(i));
            List<String> aux2 = new ArrayList();
            for (int k = 0; k < listp.size(); k++) {
                List<String> listaEdep = listp.get(k).listarEspectaculos();

                for (int l = 0; l < listaEdep.size(); l++) {
                    if (query2.get(i).equals(listaEdep.get(l))) {
                        aux2.add(listp.get(k).getNombre());
                    }
                }
            }
            //List<String> listaPla = 
            Espectaculo e = ejpa.findEspectaculo(query2.get(i));
            DtBusqueda it = new DtBusqueda(e.getNombre(), e.getFechaRegistro(), listaCat, aux2);
            res.add(it);
        }

        return res;
    }

    @Override
    public String extraerIDYoutube(String URLYoutube) {
        String idYoutube = "";
        String urlDT = URLYoutube;
        int i = 0;
        i = URLYoutube.indexOf("v=") + 2;

        for (; i < urlDT.length(); i++) {
            if (urlDT.charAt(i) == '&') {
                break;
            }
            idYoutube += urlDT.charAt(i);
        }
        return idYoutube;
    }

    /**
     * Enlace para embeber video en una página
     *
     * @param idYoutube ID del video de Youtube
     * @return En lace para embeber video
     */
    @Override
    public String obtenerEnlaceEmbebido(String idYoutube) {
        return "https://www.youtube.com/embed/" + idYoutube;
    }

    @Override
    public void sortearPremios(String plataforma, String espectaculo, String funcion) {
        PlataformaJpaController pjpa = new PlataformaJpaController();
        EspectaculoJpaController ejpa = new EspectaculoJpaController();
        FuncionesJpaController fjpa = new FuncionesJpaController();
        EntityManager em = pjpa.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        Plataforma plat = pjpa.findPlataforma(plataforma);
        Espectaculo esp = ejpa.findEspectaculo(espectaculo);
        Funciones fun = fjpa.findFunciones(funcion);
        List<Premio> premios = plat.sortearPremios(esp, fun);
        for (int i = 0; i < premios.size(); i++) {
            em.persist(premios.get(i));
        }
        em.merge(plat);
        em.merge(esp);
        em.merge(fun);
        t.commit();
        em.close();
    }

    @Override
    public void finalizarEspectaculo(String espectaculo) {
        EspectaculoJpaController ejpa = new EspectaculoJpaController();
        EntityManager em = ejpa.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Espectaculo e = ejpa.findEspectaculo(espectaculo);
        e.setEstado(Estado.finalizado);
        em.merge(e);
        et.commit();
        em.close();
    }

    @Override
    public List<String> listarEspectaculosArtista(String nick) {
        PlataformaJpaController pjpa = new PlataformaJpaController();
        //me traigo todas las plataformas del sistema
        List<Plataforma> plataformas = pjpa.findPlataformaEntities();
        List<Espectaculo> espectaculos;
        List<String> res = new ArrayList();
        //para cada plataforma me traigo su lista de espectaculos
        if (plataformas.size() > 0) {
            for (int i = 0; i < plataformas.size(); i++) {
                espectaculos = plataformas.get(i).getEspectaculos();
                //por cada lista de espectaculos, me traigo sus nombres
                if (espectaculos.size() > 0) {
                    for (int j = 0; j < espectaculos.size(); j++) {
                        //si el artista del espectaculo coincide con el del parametro y ademas esta aceptado, lo agrego a la lista
                        if (espectaculos.get(j).getA().getNick().equals(nick) && espectaculos.get(j).getEstado() == Estado.aceptado) {
                            res.add(espectaculos.get(j).getNombre());
                        }
                    }
                }
            }
        }
        //si res es vacia, significa que no hay plataformas o espectaculos en el sistema
        return res;
    }

    @Override
    public List<String> listarEspectaculosFinalizadosArtista(String nick) {
        PlataformaJpaController pjpa = new PlataformaJpaController();
        //me traigo todas las plataformas del sistema
        List<Plataforma> plataformas = pjpa.findPlataformaEntities();
        List<Espectaculo> espectaculos;
        List<String> res = new ArrayList();
        //para cada plataforma me traigo su lista de espectaculos
        if (plataformas.size() > 0) {
            for (int i = 0; i < plataformas.size(); i++) {
                espectaculos = plataformas.get(i).getEspectaculos();
                //por cada lista de espectaculos, me traigo sus nombres
                if (espectaculos.size() > 0) {
                    for (int j = 0; j < espectaculos.size(); j++) {
                        //si el artista del espectaculo coincide con el del parametro y ademas esta finalizado, lo agrego a la lista
                        if (espectaculos.get(j).getA().getNick().equals(nick) && espectaculos.get(j).getEstado() == Estado.finalizado) {
                            res.add(espectaculos.get(j).getNombre());
                        }
                    }
                }
            }
        }
        //si res es vacia, significa que no hay plataformas o espectaculos en el sistema
        return res;
    }

    //pdf
    public void crearPDF(String nick, String premio) throws FileNotFoundException, DocumentException {
        try {
            //Crear pdf para espectaculo
            com.itextpdf.text.Document documento = new com.itextpdf.text.Document();

            DTEspectador e = this.buscarEspectador(nick);
            Premio p = e.buscarPremio(premio);

            String fechaPremio = p.getFecha();
            String des = p.getDescripcion();
            String nombreE = e.getNombre();
            String funcion = p.getFuncion().getNombre();
            String espectaculo = p.getEspectaculo().getNombre();

            DateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");

            Date fechaS = formatoDelTexto.parse(fechaPremio);

            Calendar c = Calendar.getInstance();
            c.setTime(fechaS);
            c.add(Calendar.DATE, 30);
            fechaS = c.getTime();

            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            String fechaRetiro = simpleDateFormat.format(fechaS);

            // Se crea el documento
            // El OutPutStream para el fichero donde crearemos el PDF
            OutputStream file = new FileOutputStream(new File("C:\\premios\\Comprobante_" + fechaPremio + ".pdf"));
            // Se asocia el documento de OutPutStream
            PdfWriter.getInstance(documento, file);

            // Se abre el documento
            documento.open();

            // Parrafo
            Paragraph titulo1 = new Paragraph("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n",
                    FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLD, new CMYKColor(0, 20, 6, 42))
            );
            Paragraph titulo2 = new Paragraph("         C  O  M  P  R  O  B  A  N  T  E \n",
                    FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLD, new CMYKColor(0, 20, 6, 42))
            );
            Paragraph titulo3 = new Paragraph("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n",
                    FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLD, new CMYKColor(0, 0, 0, 63))
            );
            Paragraph contenido1 = new Paragraph("Felicidades   " + nombreE,
                    FontFactory.getFont(FontFactory.COURIER, 20, Font.BOLD, new CMYKColor(0, 0, 0, 100))
            );
            Paragraph contenido2 = new Paragraph("Su premio es:  " + des,
                    FontFactory.getFont(FontFactory.COURIER, 15, Font.BOLD, new CMYKColor(0, 0, 0, 100))
            );
            Paragraph contenido3 = new Paragraph("Fecha del Sorteo:  " + fechaPremio,
                    FontFactory.getFont(FontFactory.COURIER, 15, Font.BOLD, new CMYKColor(0, 0, 0, 100))
            );
            Paragraph contenido4 = new Paragraph("Funcion:  " + funcion,
                    FontFactory.getFont(FontFactory.COURIER, 15, Font.BOLD, new CMYKColor(0, 0, 0, 100))
            );
            Paragraph contenido5 = new Paragraph("Espectaculo:  " + espectaculo,
                    FontFactory.getFont(FontFactory.COURIER, 15, Font.BOLD, new CMYKColor(0, 0, 0, 100))
            );
            Paragraph contenido6 = new Paragraph("\n\n",
                    FontFactory.getFont(FontFactory.COURIER, 15, Font.BOLD, new CMYKColor(0, 0, 0, 63))
            );
            Paragraph contenido7 = new Paragraph("Usted tiene hasta 30 días para retirar su premio",
                    FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 0, 0, 90))
            );
            Paragraph contenido8 = new Paragraph("Fecha de retiro:  " + fechaRetiro,
                    FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 0, 0, 90))
            );
            // Añadimos el titulo al documento
            documento.add(titulo1);
            documento.add(titulo2);
            documento.add(titulo3);
            documento.add(contenido1);
            documento.add(contenido2);
            documento.add(contenido3);
            documento.add(contenido4);
            documento.add(contenido5);
            documento.add(contenido6);
            documento.add(contenido7);
            documento.add(contenido8);
            // Se cierra el documento
            documento.close();
        } catch (ParseException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean esFavorito(String nick, String espectaculo) {
        EspectadorJpaController ejpa = new EspectadorJpaController();
        Espectador esp = ejpa.findEspectador(nick);
        List<Espectaculo> favs = esp.getFavoritos();
        for (int i = 0; i < favs.size(); i++) {
            if (favs.get(i).getNombre().equals(espectaculo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void marcarFavorito(String espectaculo, String nick) {
        EspectadorJpaController ejpa = new EspectadorJpaController();
        EspectaculoJpaController espectaculojpa = new EspectaculoJpaController();
        EntityManager em = ejpa.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        Espectador espectador = ejpa.findEspectador(nick);
        Espectaculo esp = espectaculojpa.findEspectaculo(espectaculo);
        espectador.agregarFavorito(esp);
        em.merge(espectador);
        t.commit();
        em.close();
    }

    @Override
    public void desmarcarFavorito(String espectaculo, String nick) {
        EspectadorJpaController ejpa = new EspectadorJpaController();
        EspectaculoJpaController espectaculojpa = new EspectaculoJpaController();
        UsuarioJpaController ujpa = new UsuarioJpaController();
        EntityManager em = ejpa.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        Espectador espectador = ejpa.findEspectador(nick);
        Usuario u = ujpa.findUsuario(nick);
        Espectaculo esp = espectaculojpa.findEspectaculo(espectaculo);
        List<Espectaculo> aux = espectador.getFavoritos();
        for (int i = 0; i < aux.size(); i++) {
            if (aux.get(i).getNombre().equals(espectaculo)) {
                aux.remove(i);
                i = aux.size();
            }
        }
        espectador.setFavoritos(aux);
        em.merge(espectador);
        t.commit();
        em.close();
    }

    @Override
    public List<String> listarTodosEspectaculosAceptados() {
        PlataformaJpaController pjpa = new PlataformaJpaController();
        //me traigo todas las plataformas del sistema
        List<Plataforma> plataformas = pjpa.findPlataformaEntities();
        List<Espectaculo> espectaculos;
        List<String> res = new ArrayList();
        //para cada plataforma me traigo su lista de espectaculos
        if (plataformas.size() > 0) {
            for (int i = 0; i < plataformas.size(); i++) {
                espectaculos = plataformas.get(i).getEspectaculos();
                //por cada lista de espectaculos, me traigo sus nombres
                if (espectaculos.size() > 0) {
                    for (int j = 0; j < espectaculos.size(); j++) {
                        //agrego el nombre de cada uno a la lista
                        res.add(espectaculos.get(j).getNombre());
                    }
                }
            }
        }
        //si res es vacia, significa que no hay plataformas o espectaculos en el sistema
        return res;
    }

    @Override
    public List<String> listarEspectaculosValoracion(String nick) throws ParseException {
        EspectaculoJpaController ejpa = new EspectaculoJpaController();
        List<Espectaculo> espectaculos = ejpa.findEspectaculoEntities();
        List<Funciones> funciones = new ArrayList();
        List<Registro> registros = new ArrayList();
        List<String> res = new ArrayList();
        for (int i = 0; i < espectaculos.size(); i++) {
            funciones = espectaculos.get(i).listarFuncionesRealizadas();
            for (int j = 0; j < funciones.size(); j++) {
                registros = funciones.get(j).getRegistros();
                for (int k = 0; k < registros.size(); k++) {
                    if (registros.get(k).getEspectador().getNick().equals(nick)) {
                        res.add(espectaculos.get(i).getNombre()); //agrego el espectaculo perteneciente a la funcion realizada para el registro
                    }
                }
            }
        }
        return res;
    }

    @Override
    public boolean estaValorado(String espectaculo, String nick) {
        EspectaculoJpaController ejpa = new EspectaculoJpaController();
        EspectadorJpaController eejpa = new EspectadorJpaController();
        Espectaculo esp = ejpa.findEspectaculo(espectaculo);
        Espectador espectador = eejpa.findEspectador(nick);
        List<Puntaje> puntajes = esp.getPuntajes();
        for (int i = 0; i < puntajes.size(); i++) {
            if (puntajes.get(i).getEspectador().getNick().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void valorarEspectaculo(String espectaculo, String nick, Integer puntaje) {
        EspectaculoJpaController ejpa = new EspectaculoJpaController();
        EspectadorJpaController eejpa = new EspectadorJpaController();
        EntityManager em = ejpa.getEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        Espectaculo esp = ejpa.findEspectaculo(espectaculo);
        Espectador espectador = eejpa.findEspectador(nick);
        esp.agregarPuntaje(espectador, puntaje);
        em.merge(esp);
        t.commit();
        em.close();
    }

    @Override
    public DTUsuario buscarUsuario(String nick) {
        UsuarioJpaController ujpa = new UsuarioJpaController();
        Usuario user = ujpa.findUsuario(nick);
        return user.getData();
    }

    public List<Integer> puntajeEspectaculo(String esp) {
        List<Integer> ret = new ArrayList();
        EspectaculoJpaController ejpa = new EspectaculoJpaController();
        Espectaculo e = ejpa.findEspectaculo(esp);
        List<Puntaje> puntajes = e.getPuntajes();
        for (int i = 0; i < puntajes.size(); i++) {
            ret.add(puntajes.get(i).getPuntaje());
        }
        return ret;
    }

    public void guardarAgente(String url, String ip, String sistemaOperativo, String navegador) {
        AgenteJpaController a = new AgenteJpaController();
        EntityManager m = a.getEntityManager();
        EntityTransaction t = m.getTransaction();
        t.begin();
        Agente agente = new Agente(url, ip, sistemaOperativo, navegador);
        m.persist(agente);
        t.commit();
        m.close();
    }

    @Override
    public List<String> listarInforme() {
        AgenteJpaController ajpa = new AgenteJpaController();
        List<Agente> agentes = ajpa.findAgenteEntities();
        List<String> res = new ArrayList();
        for (int i = 0; i < agentes.size(); i++) {
            if (agentes.get(i).getId() != null) {
                res.add(agentes.get(i).toString());
            }
        }
        return res;
    }
}
