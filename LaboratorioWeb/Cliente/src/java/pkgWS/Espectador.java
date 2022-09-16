
package pkgWS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para espectador complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="espectador">
 *   &lt;complexContent>
 *     &lt;extension base="{http://complejoservidor/}usuario">
 *       &lt;sequence>
 *         &lt;element name="favoritos" type="{http://complejoservidor/}espectaculo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="paquetes" type="{http://complejoservidor/}paquete" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="premios" type="{http://complejoservidor/}premio" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="registros" type="{http://complejoservidor/}registro" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the favoritos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFavoritos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
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
     * Gets the value of the premios property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the premios property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPremios().add(newItem);
     * </pre>
     * 
     * 
     * <p>
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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the registros property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegistros().add(newItem);
     * </pre>
     * 
     * 
     * <p>
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
