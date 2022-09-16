
package DataType;

import java.io.File;
import java.util.Date;

 public class DTArtista extends DTUsuario{
    private String descripcion;
    private String biografia;
    private String linkSitioWeb;

    public DTArtista(String descripcion, String biografia, String linkSitioWeb, String nickname, String nombre, String apellido, String correoElectronico, String fechaNacimiento, File i) {
        super(nickname, nombre, apellido, correoElectronico, fechaNacimiento, i);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.linkSitioWeb = linkSitioWeb;
    }

    public DTArtista(){
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getLinkSitioWeb() {
        return linkSitioWeb;
    }
     
}
