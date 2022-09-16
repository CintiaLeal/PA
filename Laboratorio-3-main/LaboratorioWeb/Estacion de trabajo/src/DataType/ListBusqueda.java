package DataType;

import java.util.List;
import java.util.Objects;

public class ListBusqueda {
    private List<DtBusqueda> busquedas;

    public ListBusqueda() {
    }

    public ListBusqueda(List<DtBusqueda> busquedas) {
        this.busquedas = busquedas;
    }

    public List<DtBusqueda> getBusquedas() {
        return busquedas;
    }

    public void setBusquedas(List<DtBusqueda> busquedas) {
        this.busquedas = busquedas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.busquedas);
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
        final ListBusqueda other = (ListBusqueda) obj;
        if (!Objects.equals(this.busquedas, other.busquedas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ListBusqueda{" + "busquedas=" + busquedas + '}';
    }
    
    
}
