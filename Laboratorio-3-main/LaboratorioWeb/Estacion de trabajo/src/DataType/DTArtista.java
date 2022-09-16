package DataType;

import Logica.Usuario;
import java.io.File;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

 public class DTArtista extends DTUsuario{
    private String descripcion;
    private String biografia;
    private String linkSitioWeb;

    public DTArtista(String descripcion, String biografia, String linkSitioWeb, String nickname, String nombre, String apellido, String correoElectronico, String fechaNacimiento, String i, List<Usuario> seg, List<Usuario> seg2) {
        super(nickname, nombre, apellido, correoElectronico, fechaNacimiento, i, seg, seg2);
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
