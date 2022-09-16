package Logica;

import java.util.Date;
import java.sql.Time;
import java.util.ArrayList;
import DataType.*;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

public abstract class ISistema {

    public abstract ArrayList<DTPaquetes> listarPaquete();

    public abstract void seleccionarPaquete(String nombre);

    public abstract void seleccionarPlataforma(String nombre);

    public abstract List<String> listarEspectaculoQueNoFormanParte(String nombre, String plataforma);//Que no forman parte del paquete

    public abstract DtEspectaculo seleccionarEspectaculo(String nombre);

    public abstract boolean confirmarAgregarEspectaculoaPaquete(String paquete, String espectaculo);

    public abstract void cancelarAgregarEspectaculoaPaquete();

    public abstract boolean altaDePlataforma(String nombre, String url, String desc);

    public abstract void modificarDatosE(String nombre, String desc, Time duracion, Integer min, Integer max, Float costo, Date fechaAlt);

    public abstract void cancelarEspectaculo();

    public abstract boolean existeEspectaculo(String nombre);
    
    public abstract boolean existeUsuario(String nick);

    public abstract boolean existePlataforma(String nombre);

    public abstract boolean existeArtista(String nick);

    public abstract boolean existePaquete(String nombre);

    public abstract boolean existeEspectador(String nick);

    public abstract boolean confirmarEspectaculo(String plataforma, String nick, String nombre, String url, String desc, Integer dur, Integer min, Integer max, Double costo, String fecha, Estado estado, ListString cat, String img, Integer cant, String descP);

    public abstract boolean confirmarUsuario(String nickname, String nombre, String apellido, String email, String fechaNac, String pws, String i, String desc, String bio, String link);

    public abstract void cancelarUsuario();

    public abstract List<String> listarArtistas();

    public abstract boolean existeFuncion(String nombre);

    public abstract boolean existeFuncionenE(String espectaculo, String nombre);

    public abstract List<String> listarEspectaculo(String Plataforma);

    public abstract List<String> listarEspectaculoCategoria(String Categoria);

    public abstract List<String> listarFuncionesAsociadas(String plataforma, String espectaculo);

    public abstract List<String> listarFuncionesAsociadasCategoria(String Categoria, String espectaculo);

    public abstract DTFunciones seleccionarFuncionCategoria(String Categoria, String espectaculo, String nombre);

    public abstract DTFunciones seleccionarFuncion(String plataforma, String espectaculo, String nombre);

    public abstract void crearPaquete(String nombre, String desc, Date fechaI, Date fechaF, Float descuento, Date fechaAlt);

    public abstract boolean confirmarCrearPaquete(String nombre, String descripcion, String fechaI, String fechaF, String fechaA, Double precio, Double descuento, String img);

    public abstract void cancelarCrearPaquete();

    public abstract List<String> listarUsuarios();

    public abstract DTUsuario seleccionarUsuario(String nombre);

    public abstract void modificarUsuario(String nombre, String apellido, Date fechaNac);

    public abstract List<DTUsuario> listarEspectador();

    public abstract boolean registrarEspectador(String fecha, String nick, String funcion, ListString reg, double costo, String paquete); //recuerda los datos

    public abstract List<String> listarRegistros(String nickname);

    public abstract void especificarRegistros(Integer id1, Integer id2, Integer id3);

    public abstract void seleccionarNuevoEspectador(String nick);

    public abstract void seleccionarNuevaFuncion(String nombre);

    public abstract void cancelarRegistroAFuncionesDeEspectaculo();

    public abstract void aceptarComun(String nick, Date fecha, String nombre); //registro comun

    public abstract void aceptarCanje(String nick, Date fecha, String nombre, Integer id1, Integer id2, Integer id3); //cuando se cnjean 3 registros

    public abstract List<DTPlataforma> listarPlataformas();

    public abstract void modificarEspectador(String text, String text2, String text1, String fecha, String img);

    public abstract void modificarArtista(String text, String text2, String text1, String fecha, String text5, String text6, String text7, String img);

    public abstract boolean confirmarCategoria(String nombre);

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

    public abstract List<String> listarCategoriaPE(String nombre);

    public abstract int validarUsuario(String nick, String pwd);

    public abstract List<String> listarCategoriaE(String espectaculo);

    public abstract DTEspectador buscarEspectador(String nick);

    public abstract int tipoUsuario(String nick);

    public abstract DTPaquetes buscarPaquete(String nombre);

    public abstract void seguirUsuario(String seguido, String seguidor);

    public abstract boolean relacionUsuario(String seguido, String seguidor);

    public abstract void dejarDeSeguir(String seguido, String seguidor);

    public abstract DtEspectaculo buscarEspectaculo(String nombre);

    public abstract List<String> listarPaqueteEspectaculo(String espectaculo);

    public abstract Artista buscarArtista(String nick);

    public abstract void comprarPaquete(String nick, String paquete);

    public abstract List<String> paquetesNoComprados(String es);

    public abstract List<String> listarPaquetesVigentes();

    public abstract List<String> listarEspectaculosAceptado(String plataforma);

    public abstract void altaFuncion(String plataforma, String espectaculo, ListString artista, String nombre, String fecha, String hora, String img);

    public abstract List<String> listarEspectaculosAceptadoCategoria(String categoria);

    public abstract Funciones buscarFunciones(String nombre);
    
    public abstract List<String> listarFuncionesVigentes(String plataforma, String espectaculo); 
    
    public abstract boolean estarRegistrado(String nick, String fun);
    
    public abstract boolean estaComprado(String nick, String paquete);
    
    public abstract List<String> listarBusqueda(String valor);
    
    public abstract List<DtBusqueda> devolverBusqueda(String valor);
    
    public abstract  String extraerIDYoutube(String URLYoutube);
    
    public abstract String obtenerEnlaceEmbebido(String idYoutube);
    
    public abstract void sortearPremios(String plataforma, String espectaculo, String funcion);
    
    public abstract void finalizarEspectaculo(String espectaculo);
    
    public abstract List<String> listarEspectaculosArtista(String nick);
    
    public abstract List<String> listarEspectaculosFinalizadosArtista(String nick);
    
    public abstract boolean esFavorito(String nick, String espectaculo);
    
    public abstract void marcarFavorito(String espectaculo, String nick);
    
    public abstract void desmarcarFavorito(String espectaculo, String nick);
    
    public abstract List<String> listarTodosEspectaculosAceptados();
    
    public abstract List<String> listarEspectaculosValoracion(String nick)throws ParseException;
    
    public abstract void valorarEspectaculo(String espectaculo, String nick, Integer puntaje);
    
    public abstract boolean estaValorado(String espectaculo, String nick);
    
    public abstract DTUsuario buscarUsuario(String nick);
    
    public abstract List<Integer> puntajeEspectaculo(String esp);
    
    public abstract List<DtAgente> listarAgentes(); 
    
}

