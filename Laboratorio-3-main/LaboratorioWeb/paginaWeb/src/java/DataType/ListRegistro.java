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
public class ListRegistro {
    private List<DTRegistro> lista;

    public ListRegistro() {
    }

    public ListRegistro(List<DTRegistro> lista) {
        this.lista = lista;
    }

    public List<DTRegistro> getLista() {
        return lista;
    }

    public void setLista(List<DTRegistro> lista) {
        this.lista = lista;
    }
    
    
}
