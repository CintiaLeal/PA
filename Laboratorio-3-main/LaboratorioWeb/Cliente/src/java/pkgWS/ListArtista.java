package pkgWS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;

/**
 *
 * @author romil
 */
public class ListArtista {
    private List<DtArtista> lista;

    public ListArtista(List<DtArtista> lista) {
        this.lista = lista;
    }

    public ListArtista() {
    }

    public List<DtArtista> getLista() {
        return lista;
    }

    public void setLista(List<DtArtista> lista) {
        this.lista = lista;
    }
    
    
}
