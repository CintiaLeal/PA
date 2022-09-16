package DataType;
import Logica.Usuario;
import java.io.File;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DTUsuario {
    private String nickname;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String fechaNacimiento;   
    private String img;
    private List<Usuario> seguidos;
    private List<Usuario> seguidores;

    public DTUsuario(String nickname, String nombre, String apellido, String correoElectronico, String fechaNacimiento, String i, List<Usuario> segui, List<Usuario> seguidore) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.img = i;    
        this.seguidores= seguidore;
        this.seguidos = segui;
    }
    
   public DTUsuario(){
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
        List<String> ret = new ArrayList();
        for (int i = 0; i < this.seguidos.size(); i++) {
            ret.add(this.seguidos.get(i).getNick());
        }
    return ret;
    }
    public List<String> listarSeguidores() {
        List<String> ret = new ArrayList();
        for (int i = 0; i < this.seguidores.size(); i++) {
            ret.add(this.seguidores.get(i).getNick());
        }
    return ret;
    }
    
    public String toString() {
        return "{" + "nickname=" + nickname + "\n, nombre=" + nombre + "\n, apellido=" + apellido + "\n, correoElectronico=" + correoElectronico + ", \n fechaNacimiento=" + fechaNacimiento + '}';
    }
}

