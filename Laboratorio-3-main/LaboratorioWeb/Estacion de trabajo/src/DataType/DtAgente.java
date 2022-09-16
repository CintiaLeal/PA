/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataType;

/**
 *
 * @author leand
 */
public class DtAgente {
    private String ip;
    private String url;
    private String sistemaOperativo;
    private String navegador;

    public DtAgente() {
    }

    public DtAgente(String ip, String url, String sistemaOperativo, String navegador) {
        this.ip = ip;
        this.url = url;
        this.sistemaOperativo = sistemaOperativo;
        this.navegador = navegador;
    }

    public String getIp() {
        return ip;
    }

    public String getUrl() {
        return url;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public String getNavegador() {
        return navegador;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

}
