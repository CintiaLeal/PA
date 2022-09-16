
package Logica;
//package clases;
import DataType.DTUsuario;
import java.io.File;
import java.util.*;
import javax.persistence.*;

@Entity
@Table (name = "usuarios")
public class Usuario {
    
    @Id
    @Column (name = "nick")
    private String nick;
    
    @Column (name = "email")
    private String email;
  
    @Column (name = "nombre")
    private String nombre;
    
    @Column (name = "apellido")
    private String apellido;
    
    @Column (name = "fechaNac")
    private String fechaNac;
    
    @Column (name = "imagen")
    private File img;
    
   @OneToMany(targetEntity=Usuario.class, cascade = CascadeType.ALL)
   @JoinTable(name = "usuario_seguidos", 
           joinColumns=@JoinColumn(name = "usuario_seguido"), 
           inverseJoinColumns=@JoinColumn(name = "usuario_seguidor"))
    private List<Usuario> seguidos;

    //CONSTRUCTOR
    public Usuario(String nick, String nombre, String apellido, String email, String fechaNac, File i) {
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.img = i;
    }

    public Usuario() {
    }
    
    //GETTERS

    public String getNick() {
        return nick;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getFechaNac() {
        return fechaNac;
    }
    
    public DTUsuario getData(){
        DTUsuario res = new DTUsuario(this.nick, this.nombre, this.apellido, this.email, this.fechaNac, this.img);
        return res;
    }
    
    /*public Map listarRegistros(){
        if (this.registros == null)
            return null;
        Map res = new HashMap();
        for (Integer i = 0; i < this.registros.size(); i++){
            res.put(this.registros.get(i), this.registros.get(i));
        }
        return res;
    }*/
    
    //SETTERS

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nick=" + nick + ", email=" + email + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNac=" + fechaNac + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.nick);
        hash = 17 * hash + Objects.hashCode(this.email);
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.apellido);
        hash = 17 * hash + Objects.hashCode(this.fechaNac);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nick, other.nick)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.fechaNac, other.fechaNac)) {
            return false;
        }
        return true;
    }
    
    
    
}
