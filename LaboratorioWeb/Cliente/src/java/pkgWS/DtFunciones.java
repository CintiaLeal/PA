package pkgWS;

import java.util.ArrayList;
import java.util.List;
import javax.lang.model.SourceVersion;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para dtFunciones complex type.
 *
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="dtFunciones">
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
@XmlType(name = "dtFunciones")
public class DtFunciones {

    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }

    private String nombre;
    private String fecha;
    private String hora;
    private String fechaRegistro;
    private String img;
    private ListRegistro registros;
    private ListArtista artistas;

    public DtFunciones(String nombre, String fecha, String hora, String fechaRegistro, String img, ListRegistro registros, ListArtista artistas) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.fechaRegistro = fechaRegistro;
        this.img = img;
    }

    public DtFunciones() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public String getImg() {
        return img;
    }

    public List<String> listarArtista() {
        List<String> res = new ArrayList();
        List<DtArtista> aux = new ArrayList();
        if (this.artistas != null) {
            for (int i = 0; i < 10; i++) {
                res.add(aux.get(i).getNickname());
            }
        }
        return res;
    }

}
