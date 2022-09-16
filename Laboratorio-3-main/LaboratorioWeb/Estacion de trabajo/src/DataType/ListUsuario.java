/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

import java.util.List;

/**
 *
 * @author romil
 */
public class ListUsuario {
    private List<DTUsuario> lista;

    public ListUsuario() {
    }

    public ListUsuario(List<DTUsuario> lista) {
        this.lista = lista;
    }

    public List<DTUsuario> getLista() {
        return lista;
    }

    public void setLista(List<DTUsuario> lista) {
        this.lista = lista;
    }
    
    
}
