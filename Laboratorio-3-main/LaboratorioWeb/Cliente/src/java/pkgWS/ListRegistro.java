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
public class ListRegistro {
    private List<DtRegistro> lista;

    public ListRegistro() {
    }

    public ListRegistro(List<DtRegistro> lista) {
        this.lista = lista;
    }

    public List<DtRegistro> getLista() {
        return lista;
    }

    public void setLista(List<DtRegistro> lista) {
        this.lista = lista;
    }
    
    
}
