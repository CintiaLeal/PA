/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgWS;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author romil
 */
public class ListUsuario implements Serializable{
    private List<DtUsuario> lista;

    public ListUsuario() {
    }

    public ListUsuario(List<DtUsuario> lista) {
        this.lista = lista;
    }

    public List<DtUsuario> getLista() {
        return lista;
    }

    public void setLista(List<DtUsuario> lista) {
        this.lista = lista;
    }
    
    
}
