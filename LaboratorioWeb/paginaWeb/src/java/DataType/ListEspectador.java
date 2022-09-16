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
public class ListEspectador {
    private List<DTEspectador> lista;

    public ListEspectador() {
    }

    public ListEspectador(List<DTEspectador> lista) {
        this.lista = lista;
    }

    public List<DTEspectador> getLista() {
        return lista;
    }

    public void setLista(List<DTEspectador> lista) {
        this.lista = lista;
    }
}
