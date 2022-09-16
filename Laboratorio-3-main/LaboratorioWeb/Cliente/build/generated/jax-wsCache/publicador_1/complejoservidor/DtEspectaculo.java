
package complejoservidor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Clase Java para dtEspectaculo complex type.
 * 
 * &lt;p&gt;El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="dtEspectaculo"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="artista" type="{http://complejoservidor/}dtArtista" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="cantPremios" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="descPremio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="estado" type="{http://complejoservidor/}estado" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="funciones" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="puntajes" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtEspectaculo", propOrder = {
    "artista",
    "cantPremios",
    "descPremio",
    "estado",
    "funciones",
    "puntajes"
})
public class DtEspectaculo {

    protected DtArtista artista;
    protected Integer cantPremios;
    protected String descPremio;
    @XmlSchemaType(name = "string")
    protected Estado estado;
    @XmlElement(nillable = true)
    protected List<String> funciones;
    @XmlElement(nillable = true)
    protected List<String> puntajes;

    /**
     * Obtiene el valor de la propiedad artista.
     * 
     * @return
     *     possible object is
     *     {@link DtArtista }
     *     
     */
    public DtArtista getArtista() {
        return artista;
    }

    /**
     * Define el valor de la propiedad artista.
     * 
     * @param value
     *     allowed object is
     *     {@link DtArtista }
     *     
     */
    public void setArtista(DtArtista value) {
        this.artista = value;
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
     * Gets the value of the funciones property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the funciones property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getFunciones().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFunciones() {
        if (funciones == null) {
            funciones = new ArrayList<String>();
        }
        return this.funciones;
    }

    /**
     * Gets the value of the puntajes property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the puntajes property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPuntajes().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPuntajes() {
        if (puntajes == null) {
            puntajes = new ArrayList<String>();
        }
        return this.puntajes;
    }

}
