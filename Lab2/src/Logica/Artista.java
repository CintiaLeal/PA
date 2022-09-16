/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
import java.io.Serializable;
import java.util.*;
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
    public Artista(String nick, String nombre, String apellido, String email, String fechaNac, File i, String desc, String bio, String link) {
        super(nick, nombre, apellido, email, fechaNac, i);
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
