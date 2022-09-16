
package pkgWS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtEspectador complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtEspectador">
 *   &lt;complexContent>
 *     &lt;extension base="{http://complejoservidor/}dtUsuario">
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
@XmlType(name = "dtEspectador", propOrder = {
    "favoritos",
    "paquetes",
    "premios",
    "registros"
})
public class DtEspectador
    extends DtUsuario
{

    @XmlElement(nillable = true)
    private ListEspectaculo favoritos;
    @XmlElement(nillable = true)
    private ListPaquete paquetes;
    @XmlElement(nillable = true)
    private ListPremio premios;
    @XmlElement(nillable = true)
    private ListRegistro registros;

    public DtEspectador() {
    }

    public DtEspectador(ListEspectaculo favoritos, ListPaquete paquetes, ListPremio premios, ListRegistro registros, String nickname, String nombre, String apellido, String correoElectronico, String fechaNacimiento, String i, ListUsuario segui, ListUsuario seguidore) {
        super(nickname, nombre, apellido, correoElectronico, fechaNacimiento, i, segui, seguidore);
        this.favoritos = favoritos;
        this.paquetes = paquetes;
        this.premios = premios;
        this.registros = registros;
    }

    public ListEspectaculo getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(ListEspectaculo favoritos) {
        this.favoritos = favoritos;
    }

    public ListPaquete getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(ListPaquete paquetes) {
        this.paquetes = paquetes;
    }

    public ListPremio getPremios() {
        return premios;
    }

    public void setPremios(ListPremio premios) {
        this.premios = premios;
    }

    public ListRegistro getRegistros() {
        return registros;
    }

    public void setRegistros(ListRegistro registros) {
        this.registros = registros;
    }

    public List<String> listarPremios(){
        List<String> res = new ArrayList();
        List<DtPremio> aux = this.premios.getLista();
        for (int i = 0; i < aux.size(); i++) {
            res.add(aux.get(i).getId().toString());
        }
        return res;
    }
    
        public List<String> listarPaquetes(){
        List<String> res = new ArrayList();
        List<DtPaquetes> aux = this.paquetes.getPaquetes();
        for (int i = 0; i < aux.size(); i++) {
            res.add(aux.get(i).getNombre());
        }
        return res;
    }
    
    public List<String> listarRegistros(){
        List<String> res = new ArrayList();
        List<DtRegistro> aux = this.registros.getLista();
        if(registros != null){
            for (int i = 0; i < aux.size(); i++) {
                if(aux.get(i).getId() == null){
                }
                else
                    res.add(aux.get(i).getId().toString());
            }
        }
        return res;
    }
    public DtPremio buscarPremio(String id){
        List<DtPremio> aux = this.premios.getLista();
        for (int i = 0; i < aux.size(); i++) {
            if(aux.get(i).getId().toString().equals(id)){
                return aux.get(i);
            }
        }
        return null;
    }
}
