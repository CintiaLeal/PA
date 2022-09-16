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
public class ListArtista {
    private List<DTArtista> lista;

    public ListArtista(List<DTArtista> lista) {
        this.lista = lista;
    }

    public ListArtista() {
    }

    public List<DTArtista> getLista() {
        return lista;
    }

    public void setLista(List<DTArtista> lista) {
        this.lista = lista;
    }
    
    
}
