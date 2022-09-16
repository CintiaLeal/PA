/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.*;
/**
 *
 * @author diego
 */
@Entity
@Table(name = "Registro")
public class Registro{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "fecha")
    private String fecha;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "nick", nullable=false, updatable = false, insertable = false)
    private Espectador espectador;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "nombre", nullable=false, updatable = false, insertable = false)
    private Funciones funciones;
    
    @OneToMany(targetEntity=Registro.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn (name = "id_hijos", nullable=false, updatable = false, insertable = false)
    private List<Registro> registros;

//Constructores
    
public Registro(){
    this.registros = null;
 }

public Registro(String fecha, Espectador espectador, Funciones funciones, List<Registro> reg){
   
    this.fecha = fecha;
    this.espectador = espectador;
    this.funciones = funciones;
    if(reg == null)
        this.registros = null;
    else
        this.registros = reg;
}

//GET
    public String getFecha() {
        return fecha;
    }

    public Integer getId() {
        return id;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public Funciones getFunciones() {
        return funciones;
    }

//SET
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }

    public void setFunciones(Funciones funciones) {
        this.funciones = funciones;
    }
}