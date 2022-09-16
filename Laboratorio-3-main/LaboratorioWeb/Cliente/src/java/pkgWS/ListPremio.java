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
public class ListPremio {
    private List<DtPremio> lista;

    public ListPremio(List<DtPremio> lista) {
        this.lista = lista;
    }

    public ListPremio() {
    }

    public List<DtPremio> getLista() {
        return lista;
    }

    public void setLista(List<DtPremio> lista) {
        this.lista = lista;
    }
    
    
}
