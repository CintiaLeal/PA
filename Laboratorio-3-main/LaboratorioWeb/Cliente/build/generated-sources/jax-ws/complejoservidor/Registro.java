
package complejoservidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Clase Java para registro complex type.
 * 
 * &lt;p&gt;El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="registro"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="espectador" type="{http://complejoservidor/}espectador" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="funciones" type="{http://complejoservidor/}funciones" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registro", propOrder = {
    "espectador",
    "fecha",
    "funciones"
})
public class Registro {

    protected Espectador espectador;
    protected String fecha;
    protected Funciones funciones;

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
     * Obtiene el valor de la propiedad funciones.
     * 
     * @return
     *     possible object is
     *     {@link Funciones }
     *     
     */
    public Funciones getFunciones() {
        return funciones;
    }

    /**
     * Define el valor de la propiedad funciones.
     * 
     * @param value
     *     allowed object is
     *     {@link Funciones }
     *     
     */
    public void setFunciones(Funciones value) {
        this.funciones = value;
    }

}
