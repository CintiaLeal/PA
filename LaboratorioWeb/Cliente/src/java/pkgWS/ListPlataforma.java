
package pkgWS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listPlataforma complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listPlataforma">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="plataformas" type="{http://complejoservidor/}dtPlataforma" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listPlataforma", propOrder = {
    "plataformas"
})
public class ListPlataforma {

    @XmlElement(nillable = true)
    protected List<DtPlataforma> plataformas;

    /**
     * Gets the value of the plataformas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the plataformas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlataformas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtPlataforma }
     * 
     * 
     */
    public List<DtPlataforma> getPlataformas() {
        if (plataformas == null) {
            plataformas = new ArrayList<DtPlataforma>();
        }
        return this.plataformas;
    }

}
