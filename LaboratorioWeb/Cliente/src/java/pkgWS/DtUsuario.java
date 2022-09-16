package pkgWS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para dtUsuario complex type.
 *
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="dtUsuario">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtUsuario")
@XmlSeeAlso({
    DtArtista.class,
    DtEspectador.class
})
public class DtUsuario implements Serializable{

    private String nickname;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String fechaNacimiento;
    private String img;
    private ListUsuario seguidos;
    private ListUsuario seguidores;

    public DtUsuario(String nickname, String nombre, String apellido, String correoElectronico, String fechaNacimiento, String i, ListUsuario segui, ListUsuario seguidore) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.img = i;
        this.seguidores = seguidore;
        this.seguidos = segui;
    }

    public DtUsuario() {
    }

    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getImg() {
        return img;
    }

    public List<String> listarSeguidos() {

        List<String> res = new ArrayList();
        List<DtUsuario> aux = this.seguidos.getLista();
        if (this.seguidos != null) {
            for (int i = 0; i < aux.size(); i++) {
                res.add(aux.get(i).getNickname());
            }
        }
        return res;
    }

    public List<String> listarSeguidores() {
        List<String> res = new ArrayList();
        List<DtUsuario> aux = this.seguidores.getLista();
        if (this.seguidores != null) {
            for (int i = 0; i < aux.size(); i++) {
                res.add(aux.get(i).getNickname());
            }
        }
        return res;
    }
}
