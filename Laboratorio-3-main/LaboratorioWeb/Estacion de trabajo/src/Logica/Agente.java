/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import DataType.DtAgente;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author leand
 */
@Entity
@Table (name = "agente")
public class Agente implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;
    @Column (name = "url")
    private String url;
    @Column (name = "ip")
    private String ip;
    @Column (name = "sistema_operativo")
    private String sistemaOpearivo;
    @Column (name = "navegador")
    private String navegador;

    public Agente() {
    }

    public Agente(String url, String ip, String sistemaOpearivo, String navegador) {
        this.url = url;
        this.ip = ip;
        this.sistemaOpearivo = sistemaOpearivo;
        this.navegador = navegador;
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getIp() {
        return ip;
    }

    public String getSistemaOpearivo() {
        return sistemaOpearivo;
    }

    public String getNavegador() {
        return navegador;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setSistemaOpearivo(String sistemaOpearivo) {
        this.sistemaOpearivo = sistemaOpearivo;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }
    
        public DtAgente getData() {
        DtAgente ret = new DtAgente(ip, url, sistemaOpearivo, navegador);
        return ret;
    }
}
