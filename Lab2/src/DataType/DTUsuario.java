
package DataType;

import java.io.File;
import java.util.Date;


public class DTUsuario {
    private String nickname;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String fechaNacimiento;   
    private File img;

    public DTUsuario(String nickname, String nombre, String apellido, String correoElectronico, String fechaNacimiento, File i) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.img = i;    }
    
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

    public File getImg() {
        return img;
    }

    public String toString() {
        return "{" + "nickname=" + nickname + "\n, nombre=" + nombre + "\n, apellido=" + apellido + "\n, correoElectronico=" + correoElectronico + ", \n fechaNacimiento=" + fechaNacimiento + '}';
    }
   
}

