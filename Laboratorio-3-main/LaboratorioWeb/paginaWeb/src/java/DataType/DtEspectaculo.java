package DataType;

import java.util.List;

public class DtEspectaculo {

    private String nombre;
    private String descripcion;
    private String url;
    private int duracion;
    private int cantMinEsp;
    private int cantMaxEsp;
    private double costo;
    private String fechaRegistro;
    private String img;
    private ListPuntaje puntajes;
    private ListString funciones;
    private Integer cantPremios;
    private String descPremio;
    private DTArtista artista ;
    private Estado estado;

    public DtEspectaculo(String nombre, String descripcion, String url, int duracion, int cantMinEsp, int cantMaxEsp, double costo, String fechaRegistro, String img, ListString fun, ListPuntaje pun,Integer cantPremios,String descPremio,DTArtista a,Estado estado) {
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
        this.estado =estado;
        this.funciones = fun;
        this.url = url;
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

    public DTArtista getArtista() {
        return artista;
    }

    public void setArtista(DTArtista artista) {
        this.artista = artista;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        return "DtEspectaculo{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", url=" + url + ", duracion=" + duracion + ", cantMinEsp=" + cantMinEsp + ", cantMaxEsp=" + cantMaxEsp + ", costo=" + costo + ", fechaRegistro=" + fechaRegistro + ", img=" + img + '}';
    }

    public List<String> listarFunciones() {
        return this.funciones.getLista();
    }
}
