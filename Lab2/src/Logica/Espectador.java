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
@Table (name = "espectador")
public class Espectador extends Usuario implements Serializable {
    
    @OneToMany (targetEntity=Registro.class, cascade = CascadeType.ALL)
    private Map<String, Registro> registros;

    public Espectador(String nick, String nombre, String apellido, String email, String fechaNac, File i) {
        super(nick, nombre, apellido, email, fechaNac, i);
        registros = new HashMap();
    }

    public Espectador() {
    }
    
}
