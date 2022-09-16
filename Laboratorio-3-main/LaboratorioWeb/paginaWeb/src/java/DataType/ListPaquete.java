/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

import java.util.ArrayList;
import java.util.Objects;

public class ListPaquete {
    private ArrayList<DTPaquetes> paquetes;

    public ListPaquete() {
    }

    public ListPaquete(ArrayList<DTPaquetes> paquetes) {
        this.paquetes = paquetes;
    }

    public ArrayList<DTPaquetes> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(ArrayList<DTPaquetes> paquetes) {
        this.paquetes = paquetes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.paquetes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ListPaquete other = (ListPaquete) obj;
        if (!Objects.equals(this.paquetes, other.paquetes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ListPaquete{" + "paquetes=" + paquetes + '}';
    }
    
    
}
