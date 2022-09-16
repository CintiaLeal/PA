/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgWS;

import java.util.List;

/**
 *
 * @author romil
 */
public class ListFunciones {
    private List<DtFunciones> lista;

    public ListFunciones() {
    }

    public ListFunciones(List<DtFunciones> lista) {
        this.lista = lista;
    }

    public List<DtFunciones> getLista() {
        return lista;
    }

    public void setLista(List<DtFunciones> lista) {
        this.lista = lista;
    }
    
    
}
