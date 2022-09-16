
package pkgWS;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtArtista complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtArtista">
 *   &lt;complexContent>
 *     &lt;extension base="{http://complejoservidor/}dtUsuario">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtArtista")
public class DtArtista
    extends DtUsuario implements Serializable
{
private String descripcion;
    private String biografia;
    private String linkSitioWeb;

    public DtArtista(String descripcion, String biografia, String linkSitioWeb, String nickname, String nombre, String apellido, String correoElectronico, String fechaNacimiento, String i, ListUsuario segui, ListUsuario seguidore) {
        super(nickname, nombre, apellido, correoElectronico, fechaNacimiento, i, segui, seguidore);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.linkSitioWeb = linkSitioWeb;
    }

    public DtArtista(){
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getLink() {
        return linkSitioWeb;
    }

}
