/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgWS;

/**
 *
 * @author romil
 */
public class DtPuntaje {
    private Long id;
    private DtEspectador espectador;
    private Integer puntaje;

    public DtPuntaje(Long id, DtEspectador espectador, Integer puntaje) {
        this.id = id;
        this.espectador = espectador;
        this.puntaje = puntaje;
    }

    public DtPuntaje() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DtEspectador getEspectador() {
        return espectador;
    }

    public void setEspectador(DtEspectador espectador) {
        this.espectador = espectador;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }
    
    
}
