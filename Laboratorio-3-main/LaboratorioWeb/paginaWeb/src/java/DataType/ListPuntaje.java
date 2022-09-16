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
public class ListPuntaje {
    private List<DtPuntaje> lista;

    public ListPuntaje() {
    }

    public ListPuntaje(List<DtPuntaje> lista) {
        this.lista = lista;
    }

    public List<DtPuntaje> getLista() {
        return lista;
    }

    public void setLista(List<DtPuntaje> lista) {
        this.lista = lista;
    }
    
    
}
