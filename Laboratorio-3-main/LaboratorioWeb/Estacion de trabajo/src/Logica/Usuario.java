package Logica;
import DataType.DTUsuario;
import java.io.File;
import java.io.Serializable;
import java.sql.Blob;
import java.util.*;
import javax.persistence.*;

@Entity
@Table (name = "usuarios")
public class Usuario implements Serializable {
    
    @Id
    @Column (name = "nick")
     String nick;
    
    @Column (name = "email")
     String email;
  
    @Column (name = "nombre")
     String nombre;
    
    @Column (name = "apellido")
     String apellido;
    
    @Column (name = "fechaNac")
     String fechaNac;
    
    @Column (name = "pwd")
    private String pwd; 
    
    @Column (name = "imagen")
     String img;
    
   @OneToMany(targetEntity=Usuario.class, cascade = CascadeType.ALL)
   @JoinTable(name = "usuario_seguidos", 
           joinColumns=@JoinColumn(name = "usuario_seguido"), 
           inverseJoinColumns=@JoinColumn(name = "usuario_seguidor"))
    private List<Usuario> seguidos;
   
   @OneToMany(targetEntity=Usuario.class, cascade = CascadeType.ALL)
   @JoinTable(name = "usuario_seguidores", 
           joinColumns=@JoinColumn(name = "usuario_seguidor"), 
           inverseJoinColumns=@JoinColumn(name = "usuario_seguido"))
    private List<Usuario> seguidores;

    //CONSTRUCTOR
    public Usuario(String nick, String nombre, String apellido, String email, String fechaNac,String  pwd ,String i) {
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.pwd = pwd;
        this.img = i;
        this.seguidores = new ArrayList();
        this.seguidos = new ArrayList();
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

    public String getPwd() {
        return pwd;
    }

    public String getImg() {
        return img;
    }

    public List<Usuario> getSeguidos() {
        return seguidos;
    }
    
    public DTUsuario getData(){
        DTUsuario res = new DTUsuario(this.nick, this.nombre, this.apellido, this.email, this.fechaNac, this.img, this.seguidos, this.seguidores);
        return res;
    }

    public List<Usuario> getSeguidores() {
        return seguidores;
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

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setSeguidores(List<Usuario> seguidores) {
        this.seguidores = seguidores;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setSeguidos(List<Usuario> seguidos) {
        this.seguidos = seguidos;
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
    
    //agregar un seguidor a su lista de seguidores
    public void agregarSeguidor(Usuario seguidor){
        if(seguidor == null)
            return;
	this.seguidores.add(seguidor);
}
    //seguir a otro usuario
    public void seguirUsuario(Usuario useguido){
        if(useguido == null)
            return;
        this.seguidos.add(useguido);
	useguido.agregarSeguidor(this);
    }
    
    //dejar de seguir a un usuario
    public void dejarDeSeguirUsuario(Usuario seguido){
        if(seguido == null)
            return;
	this.seguidos.remove(seguido);
	seguido.quitarSeguidor(this);
    }

    //remover un seguidor
    public void quitarSeguidor(Usuario seguidor){
        if(seguidor == null)
            return;
	this.seguidores.remove(seguidor);
    }
    
    public List<String> listarSeguidos(){
        List<Usuario> us = this.getSeguidos();
        List<String> res = new ArrayList();
        for (int i = 0; i < us.size(); i++) {
            res.add(us.get(i).getNick());
        }
        return res;
    }
    
    public List<String> listarSeguidores(){
        List<Usuario> us = this.getSeguidores();
        List<String> res = new ArrayList();
        for (int i = 0; i < us.size(); i++) {
            res.add(us.get(i).getNick());
        }
        return res;
    }
}
