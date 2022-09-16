/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;
import java.sql.Time;
import java.util.ArrayList;
import DataType.*;
import java.io.File;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author romil
 */
public abstract class ISistema {
    public abstract ArrayList<DTPaquetes> listarPaquete();
    public abstract void seleccionarPaquete(String nombre);
    public abstract void seleccionarPlataforma(String nombre);
    public abstract List<String> listarEspectaculoQueNoFormanParte(String nombre, String plataforma);//Que no forman parte del paquete
   public abstract DTEspectaculo seleccionarEspectaculo(String nombre);
    public abstract void confirmarAgregarEspectaculoaPaquete(String paquete, String espectaculo);
    public abstract void cancelarAgregarEspectaculoaPaquete();
    public abstract void altaDePlataforma(String nombre, String url, String desc);
    public abstract void modificarDatosE(String nombre, String desc, Time duracion, Integer min, Integer max, Float costo, Date fechaAlt);
    public abstract void cancelarEspectaculo();
    public abstract boolean existeEspectaculo(String nombre);
    public abstract boolean existePlataforma(String nombre);
    public abstract boolean existeArtista(String nick);
    public abstract boolean existePaquete(String nombre);
    public abstract boolean existeEspectador(String nick);
    public abstract void confirmarEspectaculo(String plataforma, String nick, String nombre, String desc, Integer dur, Integer min, Integer max, Double costo, String fecha, Estado e, List<String> cat);
    public abstract void confirmarUsuario(String nickname, String nombre, String apellido, String email, String fechaNac, File i, String desc, String bio, String link);
    public abstract void cancelarUsuario();
    public abstract List<String> listarArtistas();
    public abstract boolean existeFuncion(String nombre);
    public abstract boolean existeFuncionenE(String espectaculo ,String nombre);
    public abstract void altaFuncion(String plataforma, String espectaculo, String nombre, String fecha, String hora);
    public abstract List<String> listarEspectaculo(String Plataforma);
    public abstract List<String> listarFuncionesAsociadas(String plataforma,String espectaculo);
    public abstract DTFunciones seleccionarFuncion(String plataforma, String espectaculo,String nombre);
    public abstract void crearPaquete(String nombre, String desc, Date fechaI, Date fechaF, Float descuento, Date fechaAlt);
    public abstract void confirmarCrearPaquete(String nombre, String descripcion, String fechaI, String fechaF, Double precio, Double descuento);
    public abstract void cancelarCrearPaquete();
    public abstract List<String> listarUsuarios();
    public abstract DTUsuario seleccionarUsuario(String nombre);
    public abstract void modificarUsuario(String nombre, String apellido, Date fechaNac);
    public abstract List<DTUsuario> listarEspectador();
    public abstract void registrarEspectador(String nickname, Date fecha, String nombre); //recuerda los datos
    public abstract ArrayList<DTRegistro> listarRegistros();
    public abstract void especificarRegistros(Integer id1, Integer id2, Integer id3);
    public abstract void seleccionarNuevoEspectador(String nick);
    public abstract void seleccionarNuevaFuncion(String nombre);
    public abstract void cancelarRegistroAFuncionesDeEspectaculo();
    public abstract void aceptarComun(String nick, Date fecha, String nombre); //registro comun
    public abstract void aceptarCanje(String nick, Date fecha, String nombre, Integer id1, Integer id2, Integer id3); //cuando se cnjean 3 registros
    public abstract List<DTPlataforma> listarPlataformas();
    public abstract void modificarEspectador(String text, String text2, String text1, String fecha);
    public abstract void modificarArtista(String text, String text2, String text1, String fecha, String text5, String text6, String text7);
    public abstract void confirmarCategoria(String nombre);
    public abstract boolean existeCategoria(String nombre);
    public abstract List<String> listarPaquetes();
    public abstract DTPaquetes seleccionarPaquetes(String nombre);
    public abstract List<String> listarEspectaculoP(String paquete);
    public abstract List<String> listarPlataforma();
    public abstract List<String> listarEspectaculoPl(String plataforma);
    public abstract int aceptarRegisto(String plataforma, String espectaculo, String funcion, String usuario, Date fecha);
    public abstract List<String> listarEspectaculosNoProcesados();
    public abstract void estadoEspectaculo(String espectaculo, Estado es);
    public abstract List<String> listarCategorias();
    
}
