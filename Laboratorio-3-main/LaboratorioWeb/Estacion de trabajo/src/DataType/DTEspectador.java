package DataType;

import Logica.Espectaculo;
import Logica.Paquete;
import Logica.Premio;
import Logica.Registro;
import Logica.Usuario;
import java.io.File;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DTEspectador extends DTUsuario {

    private List<Paquete> paquetes;
    private List<Registro> registros;
    private List<Premio> premios;
    private List<Espectaculo> favoritos;

    public DTEspectador(String nickname, String nombre, String apellido, String correoElectronico, String fechaNacimiento, String i, List<Usuario> seg, List<Usuario> seg2, List<Espectaculo> fav, List<Paquete> pac, List<Premio> prem, List<Registro> reg) {
        super(nickname, nombre, apellido, correoElectronico, fechaNacimiento, i, seg, seg2);
        this.paquetes = pac;
        this.favoritos = fav;
        this.premios = new ArrayList();
        this.registros = reg;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
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

    public Premio buscarPremio(String id){
        for (int i = 0; i < this.premios.size(); i++) {
            if(this.premios.get(i).getId().toString().equals(id)){
                return this.premios.get(i);
            }
        }
        return null;
    }

    public List<String> listarPremios() {
        List<String> ret = new ArrayList();
        for (int i = 0; i < this.premios.size(); i++) {
            ret.add(this.premios.get(i).getDescripcion());
        }
    return ret;
    }
}
