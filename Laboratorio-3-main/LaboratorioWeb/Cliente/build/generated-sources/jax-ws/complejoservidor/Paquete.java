
package complejoservidor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Clase Java para paquete complex type.
 * 
 * &lt;p&gt;El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="paquete"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="descuento" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="espectaculos" type="{http://complejoservidor/}espectaculo" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="fechaA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="fechaF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="fechaI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="img" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paquete", propOrder = {
    "descripcion",
    "descuento",
    "espectaculos",
    "fechaA",
    "fechaF",
    "fechaI",
    "img",
    "nombre",
    "precio"
})
public class Paquete {

    protected String descripcion;
    protected Double descuento;
    @XmlElement(nillable = true)
    protected List<Espectaculo> espectaculos;
    protected String fechaA;
    protected String fechaF;
    protected String fechaI;
    protected String img;
    protected String nombre;
    protected Double precio;

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
     * Obtiene el valor de la propiedad descuento.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDescuento() {
        return descuento;
    }

    /**
     * Define el valor de la propiedad descuento.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDescuento(Double value) {
        this.descuento = value;
    }

    /**
     * Gets the value of the espectaculos property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the espectaculos property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getEspectaculos().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link Espectaculo }
     * 
     * 
     */
    public List<Espectaculo> getEspectaculos() {
        if (espectaculos == null) {
            espectaculos = new ArrayList<Espectaculo>();
        }
        return this.espectaculos;
    }

    /**
     * Obtiene el valor de la propiedad fechaA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaA() {
        return fechaA;
    }

    /**
     * Define el valor de la propiedad fechaA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaA(String value) {
        this.fechaA = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaF.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaF() {
        return fechaF;
    }

    /**
     * Define el valor de la propiedad fechaF.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaF(String value) {
        this.fechaF = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaI.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaI() {
        return fechaI;
    }

    /**
     * Define el valor de la propiedad fechaI.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaI(String value) {
        this.fechaI = value;
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
     * Obtiene el valor de la propiedad precio.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Define el valor de la propiedad precio.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPrecio(Double value) {
        this.precio = value;
    }

}
