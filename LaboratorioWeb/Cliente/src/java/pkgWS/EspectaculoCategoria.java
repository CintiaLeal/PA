
package pkgWS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para espectaculoCategoria complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="espectaculoCategoria">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cat" type="{http://complejoservidor/}categoria" minOccurs="0"/>
 *         &lt;element name="e" type="{http://complejoservidor/}espectaculo" minOccurs="0"/>
 *         &lt;element name="id_categoria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_espectaculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "espectaculoCategoria", propOrder = {
    "cat",
    "e",
    "idCategoria",
    "idEspectaculo"
})
public class EspectaculoCategoria {

    protected Categoria cat;
    protected Espectaculo e;
    @XmlElement(name = "id_categoria")
    protected String idCategoria;
    @XmlElement(name = "id_espectaculo")
    protected String idEspectaculo;

    /**
     * Obtiene el valor de la propiedad cat.
     * 
     * @return
     *     possible object is
     *     {@link Categoria }
     *     
     */
    public Categoria getCat() {
        return cat;
    }

    /**
     * Define el valor de la propiedad cat.
     * 
     * @param value
     *     allowed object is
     *     {@link Categoria }
     *     
     */
    public void setCat(Categoria value) {
        this.cat = value;
    }

    /**
     * Obtiene el valor de la propiedad e.
     * 
     * @return
     *     possible object is
     *     {@link Espectaculo }
     *     
     */
    public Espectaculo getE() {
        return e;
    }

    /**
     * Define el valor de la propiedad e.
     * 
     * @param value
     *     allowed object is
     *     {@link Espectaculo }
     *     
     */
    public void setE(Espectaculo value) {
        this.e = value;
    }

    /**
     * Obtiene el valor de la propiedad idCategoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCategoria() {
        return idCategoria;
    }

    /**
     * Define el valor de la propiedad idCategoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCategoria(String value) {
        this.idCategoria = value;
    }

    /**
     * Obtiene el valor de la propiedad idEspectaculo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdEspectaculo() {
        return idEspectaculo;
    }

    /**
     * Define el valor de la propiedad idEspectaculo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdEspectaculo(String value) {
        this.idEspectaculo = value;
    }

}
