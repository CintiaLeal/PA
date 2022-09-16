/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.SQLException;

/**
 *
 * @author romil
 */
public class Factory {
    private Factory(){};
    private static Factory instancia = null;
    
    public Factory getInstancia(){
        if(instancia == null)
            instancia = new Factory();
        return instancia;
    }
    
    public static ISistema crearSistema(){
        return Sistema.getInstancia();
    }
}
