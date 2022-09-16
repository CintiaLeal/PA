package Logica;

import DataType.DTArtista;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name = "artista")
public class Artista extends Usuario implements Serializable {
    @Column (name = "biografia")
    private String bio;
    @Column (name = "descripcion")
    private String desc;
    @Column (name = "link_web")
    private String link;

    //CONSTRUCTORES
    public Artista(String nick, String nombre, String apellido, String email, String fechaNac,String pwd, String i, String desc, String bio, String link) {
        super(nick, nombre, apellido, email, fechaNac, pwd, i);
        this.bio = bio;
        this.desc = desc;
        this.link = link;
    }

    public Artista() {
    }
    
    //GETTERS

    public String getBio() {
        return bio;
    }

    public String getDesc() {
        return desc;
    }

    public String getLink() {
        return link;
    }
    
    public DTArtista getdata() {
        DTArtista ret = new DTArtista(desc, bio,link,nick, nombre, apellido, email, fechaNac, img, this.getSeguidos(), this.getSeguidores());
        return ret;
    }

    //SETTERS

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String toString() {
        return "Artista{" + "bio=" + bio + ", desc=" + desc + ", link=" + link + '}';
    }
}
