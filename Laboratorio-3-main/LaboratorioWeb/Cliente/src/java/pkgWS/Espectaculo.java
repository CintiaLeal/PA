
package pkgWS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para espectaculo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="espectaculo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="a" type="{http://complejoservidor/}artista" minOccurs="0"/>
 *         &lt;element name="cantMaxEsp" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cantMinEsp" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cantPremios" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="categorias" type="{http://complejoservidor/}espectaculoCategoria" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="costo" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="descPremio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="duracion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="e" type="{http://complejoservidor/}estado" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://complejoservidor/}estado" minOccurs="0"/>
 *         &lt;element name="fechaRegistro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funciones" type="{http://complejoservidor/}funciones" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="img" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paquetes" type="{http://complejoservidor/}paquete" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="puntajes" type="{http://complejoservidor/}puntaje" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "espectaculo", propOrder = {
    "a",
    "cantMaxEsp",
    "cantMinEsp",
    "cantPremios",
    "categorias",
    "costo",
    "descPremio",
    "descripcion",
    "duracion",
    "e",
    "estado",
    "fechaRegistro",
    "funciones",
    "img",
    "nombre",
    "paquetes",
    "puntajes",
    "url"
})
public class Espectaculo {

    protected Artista a;
    protected int cantMaxEsp;
    protected int cantMinEsp;
    protected Integer cantPremios;
    @XmlElement(nillable = true)
    protected List<EspectaculoCategoria> categorias;
    protected double costo;
    protected String descPremio;
    protected String descripcion;
    protected int duracion;
    @XmlSchemaType(name = "string")
    protected Estado e;
    @XmlSchemaType(name = "string")
    protected Estado estado;
    protected String fechaRegistro;
    @XmlElement(nillable = true)
    protected List<Funciones> funciones;
    protected String img;
    protected String nombre;
    @XmlElement(nillable = true)
    protected List<Paquete> paquetes;
    @XmlElement(nillable = true)
    protected List<Puntaje> puntajes;
    protected String url;

    /**
     * Obtiene el valor de la propiedad a.
     * 
     * @return
     *     possible object is
     *     {@link Artista }
     *     
     */
    public Artista getA() {
        return a;
    }

    /**
     * Define el valor de la propiedad a.
     * 
     * @param value
     *     allowed object is
     *     {@link Artista }
     *     
     */
    public void setA(Artista value) {
        this.a = value;
    }

    /**
     * Obtiene el valor de la propiedad cantMaxEsp.
     * 
     */
    public int getCantMaxEsp() {
        return cantMaxEsp;
    }

    /**
     * Define el valor de la propiedad cantMaxEsp.
     * 
     */
    public void setCantMaxEsp(int value) {
        this.cantMaxEsp = value;
    }

    /**
     * Obtiene el valor de la propiedad cantMinEsp.
     * 
     */
    public int getCantMinEsp() {
        return cantMinEsp;
    }

    /**
     * Define el valor de la propiedad cantMinEsp.
     * 
     */
    public void setCantMinEsp(int value) {
        this.cantMinEsp = value;
    }

    /**
     * Obtiene el valor de la propiedad cantPremios.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCantPremios() {
        return cantPremios;
    }

    /**
     * Define el valor de la propiedad cantPremios.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCantPremios(Integer value) {
        this.cantPremios = value;
    }

    /**
     * Gets the value of the categorias property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categorias property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategorias().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EspectaculoCategoria }
     * 
     * 
     */
    public List<EspectaculoCategoria> getCategorias() {
        if (categorias == null) {
            categorias = new ArrayList<EspectaculoCategoria>();
        }
        return this.categorias;
    }

    /**
     * Obtiene el valor de la propiedad costo.
     * 
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Define el valor de la propiedad costo.
     * 
     */
    public void setCosto(double value) {
        this.costo = value;
    }

    /**
     * Obtiene el valor de la propiedad descPremio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescPremio() {
        return descPremio;
    }

    /**
     * Define el valor de la propiedad descPremio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescPremio(String value) {
        this.descPremio = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad duracion.
     * 
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Define el valor de la propiedad duracion.
     * 
     */
    public void setDuracion(int value) {
        this.duracion = value;
    }

    /**
     * Obtiene el valor de la propiedad e.
     * 
     * @return
     *     possible object is
     *     {@link Estado }
     *     
     */
    public Estado getE() {
        return e;
    }

    /**
     * Define el valor de la propiedad e.
     * 
     * @param value
     *     allowed object is
     *     {@link Estado }
     *     
     */
    public void setE(Estado value) {
        this.e = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link Estado }
     *     
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link Estado }
     *     
     */
    public void setEstado(Estado value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaRegistro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Define el valor de la propiedad fechaRegistro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaRegistro(String value) {
        this.fechaRegistro = value;
    }

    /**
     * Gets the value of the funciones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the funciones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFunciones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Funciones }
     * 
     * 
     */
    public List<Funciones> getFunciones() {
        if (funciones == null) {
            funciones = new ArrayList<Funciones>();
        }
        return this.funciones;
    }

    /**
     * Obtiene el valor de la propiedad img.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImg() {
        return img;
    }

    /**
     * Define el valor de la propiedad img.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImg(String value) {
        this.img = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the paquetes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paquetes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaquetes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Paquete }
     * 
     * 
     */
    public List<Paquete> getPaquetes() {
        if (paquetes == null) {
            paquetes = new ArrayList<Paquete>();
        }
        return this.paquetes;
    }

    /**
     * Gets the value of the puntajes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the puntajes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPuntajes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Puntaje }
     * 
     * 
     */
    public List<Puntaje> getPuntajes() {
        if (puntajes == null) {
            puntajes = new ArrayList<Puntaje>();
        }
        return this.puntajes;
    }

    /**
     * Obtiene el valor de la propiedad url.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Define el valor de la propiedad url.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }
}
