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
public class ListEspectaculo {
    private List<DtEspectaculo> lista;

    public ListEspectaculo(List<DtEspectaculo> lista) {
        this.lista = lista;
    }

    public ListEspectaculo() {
    }

    public List<DtEspectaculo> getLista() {
        return lista;
    }

    public void setLista(List<DtEspectaculo> lista) {
        this.lista = lista;
    }
    
    
}
