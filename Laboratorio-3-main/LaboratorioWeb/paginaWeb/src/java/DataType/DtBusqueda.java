/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author romil
 */
public class DtBusqueda {
    private String nombre;
    private String fecha;
    private List<String> categorias;
    private List<String> plataformas;
    public DtBusqueda() {
    }

    public DtBusqueda(String nombre, String fecha, List<String> categorias, List<String> plataformas) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.categorias = categorias;
        this.plataformas = plataformas;
    }

    
  
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public List<String> getPlataformas() {
        return plataformas;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    public void setPlataformas(List<String> plataformas) {
        this.plataformas = plataformas;
    }

    @Override
    public String toString() {
        return "DtBusqueda{" + "nombre=" + nombre + ", fecha=" + fecha + ", categorias=" + categorias + ", plataformas=" + plataformas + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.fecha);
        hash = 53 * hash + Objects.hashCode(this.categorias);
        hash = 53 * hash + Objects.hashCode(this.plataformas);
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
        final DtBusqueda other = (DtBusqueda) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.categorias, other.categorias)) {
            return false;
        }
        if (!Objects.equals(this.plataformas, other.plataformas)) {
            return false;
        }
        return true;
    }

    

   
    
    
}
