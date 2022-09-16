package Logica;

import DataType.DTArtista;
import DataType.DTFunciones;
import DataType.DTRegistro;
import DataType.ListArtista;
import DataType.ListRegistro;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.*;
import persistencia.FuncionesJpaController;
import java.util.Random;
import persistencia.EspectadorJpaController;

@Entity
@Table(name = "funciones")
public class Funciones implements Serializable {

    @Id
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "hora")
    private String hora;

    @Column(name = "maxRegs")
    private int maxRegs;

    @Column(name = "fechaRegistro")
    private String fechaRegistro;

    @Column(name = "imagen")
    private String img;

    @OneToMany(targetEntity = Registro.class, cascade = CascadeType.ALL)
    @JoinTable(name = "funciones_registro",
            joinColumns = @JoinColumn(name = "funciones_nombre"),
            inverseJoinColumns = @JoinColumn(name = "registro_id"))
    private List<Registro> registros;

    @OneToMany(targetEntity = Usuario.class)
    @JoinTable(name = "funciones_invitados",
            joinColumns = @JoinColumn(name = "funciones_nombre"),
            inverseJoinColumns = @JoinColumn(name = "artista_nick"))
    private List<Artista> artistas;

//------------------------    
    public Funciones() {

    }

    public Funciones(String nombre, String fecha, String hora, String fechaRegistro, String img, List<Artista> u) {
        if (nombre.equals("")) {
            throw new RuntimeException("El nombre de la Funcion no puede ser vacio");
        }
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.fechaRegistro = fechaRegistro;
        this.img = img;
        if (u != null) {
            this.artistas = u;
        } else {
            this.artistas = new ArrayList();
        }
        this.registros = new ArrayList();

    }

    //GET
    public DTFunciones getdata() {
        List<DTRegistro> items = new ArrayList();
        if(this.registros!=null){
            for (int i = 0; i < this.registros.size(); i++) {
                items.add(this.registros.get(i).getData());
            }
        }
        ListRegistro reg = new ListRegistro(items);
        List<DTArtista> itemsA = new ArrayList();
        if(this.artistas!=null){
            for (int i = 0; i < this.artistas.size(); i++) {
                itemsA.add(this.artistas.get(i).getdata());
            }
        }
        ListArtista ar = new ListArtista(itemsA);
        DTFunciones ret = new DTFunciones(nombre, fecha, hora, fechaRegistro, img, reg, ar);
        return ret;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMaxRegs() {
        return maxRegs;
    }

    public void setMaxRegs(int maxRegs) {
        this.maxRegs = maxRegs;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public String getImg() {
        return img;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }
    //SET

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    int registrarEspectador(String usuario, java.util.Date fecha) {
        int ret = 0;
        return ret;
    }

    public List<String> listarArtista() {
        FuncionesJpaController pjpa = new FuncionesJpaController();
        EntityManager em = pjpa.getEntityManager();
        Query q;
        q = em.createQuery("SELECT DISTINCT e.nombre FROM Funciones p JOIN Artista e ON p.artistas.nombre = e.nombre WHERE p.nombre = :nombre");
        q.setParameter("nombre", nombre);
        return q.getResultList();
    }

    @Override
    public String toString() {
        return "Funciones{" + "nombre=" + nombre + ", fecha=" + fecha + ", hora=" + hora + ", fechaRegistro=" + fechaRegistro + '}';
    }

    public void agregarregistro(Registro r) {
        registros.add(r);
    }

    public List<Premio> sortearPremios(Integer cantPremios, String descPremio, Espectaculo esp) {
        if (cantPremios <= 0) {
            return null;
        }
        //Me traigo todos los espectadores registrados de la funcion
        List<Espectador> espectadores = new ArrayList();
        for (int i = 0; i < registros.size(); i++) {
            espectadores.add(registros.get(i).getEspectador());
        }
        Espectador winner;
        //Sorteo la cantidad de premios dada
        List<Premio> premios = new ArrayList();
        if (espectadores.size() > 0) {
            while (cantPremios > 0) {
                Random r = new Random();
                //el numero a sortear es la posicion de la lista de los espectadores registrados
                Integer valor = r.nextInt(espectadores.size());
                //guardo al ganador de la posicion valor
                winner = espectadores.get(valor);
                if (winner != null) {
                    EspectadorJpaController ejpa = new EspectadorJpaController();
                    EntityManager em = ejpa.getEntityManager();
                    EntityTransaction t = em.getTransaction();
                    t.begin();
                    String pattern = "yyyy-MM-dd";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                    Date fecha = new Date();
                    String fechaA = simpleDateFormat.format(fecha);
                    //Creo el premio y se lo agrego al ganador
                    Premio p = new Premio(winner, this, fechaA, descPremio, esp);
                    winner.agregarPremio(p);
                    premios.add(p);
                    em.merge(winner);
                    t.commit();
                    em.close();
                }
                cantPremios--;
            }
        }
        return premios;
    }

}
