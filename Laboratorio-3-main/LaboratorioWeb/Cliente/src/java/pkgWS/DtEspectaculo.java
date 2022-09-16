package pkgWS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtEspectaculo", propOrder = {
    "artista",
    "cantPremios",
    "descPremio",
    "estado",
    "funciones",
    "puntajes",
    "nombre",
    "descripcion",
    "duracion",
    "cantMinEsp",
    "cantMaxEsp",
    "costo",
    "fechaRegistro",
    "img",
    "url"
})
public class DtEspectaculo {

    protected DtArtista artista;
    protected Integer cantPremios;
    protected String descPremio;
    @XmlSchemaType(name = "string")
    protected Estado estado;
    @XmlElement(nillable = true)
    protected ListString funciones;
    @XmlElement(nillable = true)
    protected ListPuntaje puntajes;
    @XmlSchemaType(name = "string")
    private String nombre;
    @XmlSchemaType(name = "string")
    private String descripcion;
    private int duracion;
    private int cantMinEsp;
    private int cantMaxEsp;
    private double costo;
    @XmlSchemaType(name = "string")
    private String fechaRegistro;
    @XmlSchemaType(name = "string")
    private String img;
    @XmlSchemaType(name = "string")
    private String url;

    public DtEspectaculo(String nombre, String descripcion, String link, int duracion, int cantMinEsp, int cantMaxEsp, double costo, String fechaRegistro, String img, ListString fun, ListPuntaje pun, Integer cantPremios, String descPremio, DtArtista a, Estado estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.cantMinEsp = cantMinEsp;
        this.cantMaxEsp = cantMaxEsp;
        this.costo = costo;
        this.fechaRegistro = fechaRegistro;
        this.img = img;
        this.puntajes = pun;
        this.cantPremios = cantPremios;
        this.descPremio = descPremio;
        this.artista = a;
        this.estado = estado;
        this.funciones = fun;
        this.url = link;

    }

    public DtEspectaculo() {
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

    public String getImg() {
        return img;
    }

    public Integer getCantPremios() {
        return cantPremios;
    }

    public void setCantPremios(Integer cantPremios) {
        this.cantPremios = cantPremios;
    }

    public String getDescPremio() {
        return descPremio;
    }

    public void setDescPremio(String descPremio) {
        this.descPremio = descPremio;
    }

    public ListPuntaje getPuntajes() {
        return puntajes;
    }

    public void setPuntajes(ListPuntaje puntajes) {
        this.puntajes = puntajes;
    }

    public ListString getFunciones() {
        return funciones;
    }

    public void setFunciones(ListString funciones) {
        this.funciones = funciones;
    }

    public DtArtista getArtista() {
        return artista;
    }

    public void setArtista(DtArtista artista) {
        this.artista = artista;
    }

    public List<String> listarFunciones() {
        List reg = new ArrayList();
        List<String> aux = this.funciones.getLista();
        if (aux != null) {
            for (int i = 0; i < aux.size(); i++) {
                reg.add(aux.get(i));
            }
        }
        return reg;
    }

    public Estado getEstado() {
        return estado;
    }
}
