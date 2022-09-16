package DataType;

import java.util.List;
import java.util.Objects;

public class ListPlataforma {
    private List<DTPlataforma> plataformas;

    public ListPlataforma() {
    }

    public ListPlataforma(List<DTPlataforma> plataformas) {
        this.plataformas = plataformas;
    }

    public List<DTPlataforma> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(List<DTPlataforma> plataformas) {
        this.plataformas = plataformas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.plataformas);
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
        final ListPlataforma other = (ListPlataforma) obj;
        if (!Objects.equals(this.plataformas, other.plataformas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ListPlataforma{" + "plataformas=" + plataformas + '}';
    }
    
    
}


