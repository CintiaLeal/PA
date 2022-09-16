/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

import java.util.Objects;

/**
 *
 * @author romil
 */
public class DtPremio {
    private Long id;
    private DTEspectador espectador;
    private DTFunciones funcion;
    private DtEspectaculo espectaculo;
    private String fecha;
    private String descripcion;

    public DtPremio() {
    }

    public DtPremio(Long id, DTEspectador espectador, DTFunciones funcion, DtEspectaculo espectaculo, String fecha, String descripcion) {
        this.id = id;
        this.espectador = espectador;
        this.funcion = funcion;
        this.espectaculo = espectaculo;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DTEspectador getEspectador() {
        return espectador;
    }

    public void setEspectador(DTEspectador espectador) {
        this.espectador = espectador;
    }

    public DTFunciones getFuncion() {
        return funcion;
    }

    public void setFuncion(DTFunciones funcion) {
        this.funcion = funcion;
    }

    public DtEspectaculo getEspectaculo() {
        return espectaculo;
    }

    public void setEspectaculo(DtEspectaculo espectaculo) {
        this.espectaculo = espectaculo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.espectador);
        hash = 83 * hash + Objects.hashCode(this.funcion);
        hash = 83 * hash + Objects.hashCode(this.espectaculo);
        hash = 83 * hash + Objects.hashCode(this.fecha);
        hash = 83 * hash + Objects.hashCode(this.descripcion);
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
        final DtPremio other = (DtPremio) obj;
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.espectador, other.espectador)) {
            return false;
        }
        if (!Objects.equals(this.funcion, other.funcion)) {
            return false;
        }
        if (!Objects.equals(this.espectaculo, other.espectaculo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DtPremio{" + "id=" + id + ", espectador=" + espectador + ", funcion=" + funcion + ", espectaculo=" + espectaculo + ", fecha=" + fecha + ", descripcion=" + descripcion + '}';
    }
}
