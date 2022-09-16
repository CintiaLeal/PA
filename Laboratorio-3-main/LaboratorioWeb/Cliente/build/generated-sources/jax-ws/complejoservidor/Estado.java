
package complejoservidor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Clase Java para estado.
 * 
 * &lt;p&gt;El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="estado"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *     &amp;lt;enumeration value="ingresado"/&amp;gt;
 *     &amp;lt;enumeration value="aceptado"/&amp;gt;
 *     &amp;lt;enumeration value="rechazado"/&amp;gt;
 *     &amp;lt;enumeration value="finalizado"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "estado")
@XmlEnum
public enum Estado {

    @XmlEnumValue("ingresado")
    INGRESADO("ingresado"),
    @XmlEnumValue("aceptado")
    ACEPTADO("aceptado"),
    @XmlEnumValue("rechazado")
    RECHAZADO("rechazado"),
    @XmlEnumValue("finalizado")
    FINALIZADO("finalizado");
    private final String value;

    Estado(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Estado fromValue(String v) {
        for (Estado c: Estado.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
