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
public class ListEspectador {
    private List<DtEspectador> lista;

    public ListEspectador() {
    }

    public ListEspectador(List<DtEspectador> lista) {
        this.lista = lista;
    }

    public List<DtEspectador> getLista() {
        return lista;
    }

    public void setLista(List<DtEspectador> lista) {
        this.lista = lista;
    }
}
