package Logica;

import DataType.DTEspectador;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table (name = "espectador")
public class Espectador extends Usuario implements Serializable {
    
    @OneToMany (targetEntity=Registro.class, cascade = CascadeType.ALL)
    @JoinTable(name = "espectador_registros",
            joinColumns = @JoinColumn(name = "espectador_nick"),
            inverseJoinColumns = @JoinColumn(name = "registro_id"))
    private List<Registro> registros;
    
    @OneToMany(targetEntity = Paquete.class, cascade = CascadeType.ALL)
    @JoinTable(name = "espectador_paquetes",
            joinColumns = @JoinColumn(name = "espectador_nick"),
            inverseJoinColumns = @JoinColumn(name = "paquete_nombre"))
    private List<Paquete> paquetes;
    
    @OneToMany(targetEntity = Premio.class)
    @JoinTable(name = "espectador_premios",
            joinColumns = @JoinColumn(name = "espectador_premio"),
            inverseJoinColumns = @JoinColumn(name = "premio_id"))
    private List<Premio> premios;
    
    @OneToMany(targetEntity = Espectaculo.class)
    @JoinTable(name = "espectaculos_favoritos",
            joinColumns = @JoinColumn(name = "espectador"),
            inverseJoinColumns = @JoinColumn(name = "espectaculo_id"))
    private List<Espectaculo> favoritos;
    

    public Espectador(String nick, String nombre, String apellido, String email, String fechaNac,String pwd, String i) {
        super(nick, nombre, apellido, email, fechaNac,pwd, i);
        this.registros = new ArrayList();
        this.paquetes = new ArrayList();
        this.premios = new ArrayList();
        this.favoritos = new ArrayList();
    }

    public Espectador() {
    }
    
    public DTEspectador getdata() {
        DTEspectador ret = new DTEspectador(nick, nombre, apellido, email, fechaNac, img, this.getSeguidos(), this.getSeguidores(),this.favoritos, this.paquetes, this.premios, this.registros);
        return ret;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public List<Premio> getPremios() {
        return premios;
    }

    public void setPremios(List<Premio> premios) {
        this.premios = premios;
    }

    public List<Espectaculo> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(List<Espectaculo> favoritos) {
        this.favoritos = favoritos;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }
    
    public void comprarPaquete(Paquete p){
        if(p == null)
            return;
        this.paquetes.add(p);
    }
    
    public List<String> listarPaquetes(){
        List<String> res = new ArrayList();
        for (int i = 0; i < this.paquetes.size(); i++) {
            res.add(this.paquetes.get(i).getNombre());
        }
        return res;
    }
    public void borrarregistro(Registro r){
        if(r == null){
            return;
        }
    registros.remove(r);
    }

    public void agregarregistro(Registro r) {
        if(r == null)
            return;
        registros.add(r);
    }
    
    public List<String> listarRegistros(){
        List<String> res = new ArrayList();
        List<Registro> r = this.getRegistros();
        for (int i = 0; i < r.size(); i++) {
            if(r.get(i).getId() == null){
            }
            else
                res.add(r.get(i).getId().toString());
        }
        return res;
    }

    public void agregarPremio(Premio p) {
        premios.add(p);
    }
    
    public List<String> listarPremios(){
        List<String> res = new ArrayList();
        for (int i = 0; i < this.premios.size(); i++) {
            res.add(this.premios.get(i).getId().toString());
        }
        return res;
    }
    
    public Premio buscarPremio(String id){
        for (int i = 0; i < this.premios.size(); i++) {
            if(this.premios.get(i).getId().toString().equals(id)){
                return this.premios.get(i);
            }
        }
        return null;
    }
    
    public void agregarFavorito(Espectaculo e){
        this.favoritos.add(e);
    }
    
    public void quitarFavorito(Espectaculo e){
        if(this.favoritos.contains(e)){
            this.favoritos.remove(e);
        }
    }
}
