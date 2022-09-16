package DataType;

import java.util.List;
import java.util.Objects;

public class ListString {
    private List<String> lista;

    public ListString() {
    }

    public ListString(List<String> lista) {
        this.lista = lista;
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.lista);
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
        final ListString other = (ListString) obj;
        if (!Objects.equals(this.lista, other.lista)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ListString{" + "lista=" + lista + '}';
    }
    
    
}
