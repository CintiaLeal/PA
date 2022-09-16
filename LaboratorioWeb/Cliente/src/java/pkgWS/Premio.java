
package pkgWS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para premio complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="premio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="espectaculo" type="{http://complejoservidor/}espectaculo" minOccurs="0"/>
 *         &lt;element name="espectador" type="{http://complejoservidor/}espectador" minOccurs="0"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funcion" type="{http://complejoservidor/}funciones" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "premio", propOrder = {
    "descripcion",
    "espectaculo",
    "espectador",
    "fecha",
    "funcion",
    "id"
})
public class Premio {

    protected String descripcion;
    protected Espectaculo espectaculo;
    protected Espectador espectador;
    protected String fecha;
    protected Funciones funcion;
    protected Long id;

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
     * Obtiene el valor de la propiedad espectaculo.
     * 
     * @return
     *     possible object is
     *     {@link Espectaculo }
     *     
     */
    public Espectaculo getEspectaculo() {
        return espectaculo;
    }

    /**
     * Define el valor de la propiedad espectaculo.
     * 
     * @param value
     *     allowed object is
     *     {@link Espectaculo }
     *     
     */
    public void setEspectaculo(Espectaculo value) {
        this.espectaculo = value;
    }

    /**
     * Obtiene el valor de la propiedad espectador.
     * 
     * @return
     *     possible object is
     *     {@link Espectador }
     *     
     */
    public Espectador getEspectador() {
        return espectador;
    }

    /**
     * Define el valor de la propiedad espectador.
     * 
     * @param value
     *     allowed object is
     *     {@link Espectador }
     *     
     */
    public void setEspectador(Espectador value) {
        this.espectador = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecha(String value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad funcion.
     * 
     * @return
     *     possible object is
     *     {@link Funciones }
     *     
     */
    public Funciones getFuncion() {
        return funcion;
    }

    /**
     * Define el valor de la propiedad funcion.
     * 
     * @param value
     *     allowed object is
     *     {@link Funciones }
     *     
     */
    public void setFuncion(Funciones value) {
        this.funcion = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

}
