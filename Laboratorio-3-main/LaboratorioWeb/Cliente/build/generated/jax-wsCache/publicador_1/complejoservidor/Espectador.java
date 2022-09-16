
package complejoservidor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Clase Java para espectador complex type.
 * 
 * &lt;p&gt;El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="espectador"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://complejoservidor/}usuario"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="favoritos" type="{http://complejoservidor/}espectaculo" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="paquetes" type="{http://complejoservidor/}paquete" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="premios" type="{http://complejoservidor/}premio" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="registros" type="{http://complejoservidor/}registro" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "espectador", propOrder = {
    "favoritos",
    "paquetes",
    "premios",
    "registros"
})
public class Espectador
    extends Usuario
{

    @XmlElement(nillable = true)
    protected List<Espectaculo> favoritos;
    @XmlElement(nillable = true)
    protected List<Paquete> paquetes;
    @XmlElement(nillable = true)
    protected List<Premio> premios;
    @XmlElement(nillable = true)
    protected List<Registro> registros;

    /**
     * Gets the value of the favoritos property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the favoritos property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getFavoritos().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link Espectaculo }
     * 
     * 
     */
    public List<Espectaculo> getFavoritos() {
        if (favoritos == null) {
            favoritos = new ArrayList<Espectaculo>();
        }
        return this.favoritos;
    }

    /**
     * Gets the value of the paquetes property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the paquetes property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPaquetes().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
     * Gets the value of the premios property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the premios property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPremios().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link Premio }
     * 
     * 
     */
    public List<Premio> getPremios() {
        if (premios == null) {
            premios = new ArrayList<Premio>();
        }
        return this.premios;
    }

    /**
     * Gets the value of the registros property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the registros property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getRegistros().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link Registro }
     * 
     * 
     */
    public List<Registro> getRegistros() {
        if (registros == null) {
            registros = new ArrayList<Registro>();
        }
        return this.registros;
    }

}
