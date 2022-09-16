package complejoservidor;

import DataType.*;
import Logica.*;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

/**
 *
 * @author user
 */
@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador {

    private Endpoint endpoint = null;

    //Constructor
    public Publicador() {
    }

    //Operaciones que quiero publicar
    @WebMethod(exclude = true)
    public void publicar() {
        endpoint = Endpoint.publish("http://localhost:8085/publicador", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
        return endpoint;
    }

    @WebMethod
    public ListPaquete listarPaquete() {
        ISistema sis = Factory.crearSistema();
        ListPaquete listp = new ListPaquete(sis.listarPaquete());
        return listp;
    }

    @WebMethod
    public ListPlataforma listarPlataformas() {
        ISistema sis = Factory.crearSistema();
        ListPlataforma listpla = new ListPlataforma(sis.listarPlataformas());
        return listpla;
    }

    @WebMethod
    public ListString listarEspectaculoQueNoFormanParte(String nombre, String plataforma) {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarEspectaculoQueNoFormanParte(nombre, plataforma));
        return lista;
    }

    @WebMethod
    public boolean confirmarAgregarEspectaculoaPaquete(String paquete, String espectaculo) {
        ISistema sis = Factory.crearSistema();
        return sis.confirmarAgregarEspectaculoaPaquete(paquete, espectaculo);
    }

    @WebMethod
    public boolean existeEspectaculo(String nombre) {
        ISistema sis = Factory.crearSistema();
        return sis.existeEspectaculo(nombre);
    }

    @WebMethod
    public boolean existePlataforma(String nombre) {
        ISistema sis = Factory.crearSistema();
        return sis.existePlataforma(nombre);
    }

    @WebMethod
    public boolean existeUsuario(String nick) {
        ISistema sis = Factory.crearSistema();
        return sis.existeUsuario(nick);
    }

    @WebMethod
    public boolean existeArtista(String nick) {
        ISistema sis = Factory.crearSistema();
        return sis.existeArtista(nick);
    }

    @WebMethod
    public boolean existeEspectador(String nick) {
        ISistema sis = Factory.crearSistema();
        return sis.existeEspectador(nick);
    }

    @WebMethod
    public boolean existePaquete(String nombre) {
        ISistema sis = Factory.crearSistema();
        return sis.existePaquete(nombre);
    }

    @WebMethod
    public boolean confirmarEspectaculo(String plataforma, String nick, String nombre, String desc, String url, Integer dur, Integer min, Integer max, Double costo, String fecha, Estado estado, ListString cat, String img, Integer cant, String descP) {
        ISistema sis = Factory.crearSistema();
        return sis.confirmarEspectaculo(plataforma, nick, nombre, url, desc, dur, min, max, costo, fecha, estado, cat, img, cant, descP);
    }

    @WebMethod
    public boolean confirmarCrearPaquete(String nombre, String descripcion, String fechaI, String fechaF, String fechaA, Double precio, Double descuento, String img) {
        ISistema sis = Factory.crearSistema();
        return sis.confirmarCrearPaquete(nombre, descripcion, fechaI, fechaF, fechaA, precio, descuento, img);
    }

    @WebMethod
    public boolean confirmarUsuario(String nickname, String nombre, String apellido, String email, String fechaNac, String pws, String i, String desc, String bio, String link) {
        ISistema sis = Factory.crearSistema();
        return sis.confirmarUsuario(nickname, nombre, apellido, email, fechaNac, pws, i, desc, bio, link);
    }

    @WebMethod
    public ListString listarEspectaculo(String plataforma) {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarEspectaculo(plataforma));
        return lista;
    }

    @WebMethod
    public ListString listarEspectaculoCategoria(String Categoria) {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarEspectaculoCategoria(Categoria));
        return lista;
    }

    @WebMethod
    public ListString listarFuncionesAsociadas(String plataforma, String espectaculo) {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarFuncionesAsociadas(plataforma, espectaculo));
        return lista;
    }

    @WebMethod
    public ListString listarFuncionesAsociadasCategoria(String Categoria, String espectaculo) {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarFuncionesAsociadasCategoria(Categoria, espectaculo));
        return lista;
    }

    @WebMethod
    public ListString listarUsuarios() {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarUsuarios());
        return lista;
    }

    @WebMethod
    public ListString listarArtistas() {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarArtistas());
        return lista;
    }

    @WebMethod
    public void registrarEspectador(String fecha, String nick, String funcion, ListString reg, double costo, String paquete) {
        ISistema sis = Factory.crearSistema();
        sis.registrarEspectador(fecha, nick, funcion, reg, costo, paquete);
    }

    @WebMethod
    public ListString listarRegistros(String nick) {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarRegistros(nick));
        return lista;
    }

    @WebMethod
    public String obtenerEnlaceEmbebido(String idYoutube) {
        ISistema sis = Factory.crearSistema();
        return sis.obtenerEnlaceEmbebido(idYoutube);
    }

    @WebMethod
    public String extraerIDYoutube(String URLYoutube) {
        ISistema sis = Factory.crearSistema();
        return sis.extraerIDYoutube(URLYoutube);
    }

    @WebMethod
    public ListBusqueda devolverBusqueda(String valor) {
        ISistema sis = Factory.crearSistema();
        ListBusqueda lista = new ListBusqueda(sis.devolverBusqueda(valor));
        return lista;
    }

    @WebMethod
    public ListString listarBusqueda(String valor) {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarBusqueda(valor));
        return lista;
    }

    @WebMethod
    public boolean estaComprado(String nick, String paquete) {
        ISistema sis = Factory.crearSistema();
        return sis.estaComprado(nick, paquete);

    }

    @WebMethod
    public boolean estarRegistrado(String nick, String fun) {
        ISistema sis = Factory.crearSistema();
        return sis.estarRegistrado(nick, fun);
    }

    @WebMethod
    public ListString listarEspectaculosAceptadoCategoria(String categoria) {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarEspectaculosAceptadoCategoria(categoria));
        return lista;
    }

    @WebMethod
    public ListString listarEspectaculosAceptado(String plataforma) {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarEspectaculosAceptado(plataforma));
        return lista;
    }

    @WebMethod
    public void altaFuncion(String plataforma, String espectaculo, ListString artista, String nombre, String fecha, String hora, String img) {
        ISistema sis = Factory.crearSistema();
        sis.altaFuncion(plataforma, espectaculo, artista, nombre, fecha, hora, img);
    }

    @WebMethod
    public ListString paquetesNoComprados(String e) {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.paquetesNoComprados(e));
        return lista;
    }

    @WebMethod
    public ListString listarPaquetesVigentes() {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarPaquetesVigentes());
        return lista;
    }

    @WebMethod
    public void comprarPaquete(String nick, String paquete) {
        ISistema sis = Factory.crearSistema();
        sis.comprarPaquete(nick, paquete);

    }

    @WebMethod
    public DTArtista buscarArtista(String nick) {
        ISistema sis = Factory.crearSistema();
        Artista a = sis.buscarArtista(nick);
        DTArtista dtartista = a.getdata();
        return dtartista;
    }

    @WebMethod
    public ListString listarPaqueteEspectaculo(String espectaculo) {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarPaqueteEspectaculo(espectaculo));
        return lista;
    }

    @WebMethod
    public void dejarDeSeguir(String seguido, String seguidor) {
        ISistema sis = Factory.crearSistema();
        sis.dejarDeSeguir(seguido, seguidor);
    }

    @WebMethod
    public boolean relacionUsuario(String seguidor, String seguido) {
        ISistema sis = Factory.crearSistema();
        return sis.relacionUsuario(seguidor, seguido);
    }

    @WebMethod
    public void seguirUsuario(String seguido, String seguidor) {
        ISistema sis = Factory.crearSistema();
        sis.seguirUsuario(seguido, seguidor);
    }

    @WebMethod
    public int tipoUsuario(String nick) {
        ISistema sis = Factory.crearSistema();
        return sis.tipoUsuario(nick);
    }

    @WebMethod
    public DTFunciones buscarFunciones(String nombre) {
        ISistema sis = Factory.crearSistema();
        Funciones f = sis.buscarFunciones(nombre);
        DTFunciones dt = f.getdata();
        return dt;
    }

    @WebMethod
    public DtEspectaculo buscarEspectaculo(String nombre) {
        ISistema sis = Factory.crearSistema();
        return sis.buscarEspectaculo(nombre);
    }

    @WebMethod
    public DTPaquetes buscarPaquete(String nombre) {
        ISistema sis = Factory.crearSistema();
        DTPaquetes p = sis.buscarPaquete(nombre);
        return p;
    }

    @WebMethod
    public DTEspectador buscarEspectador(String nick) {
        ISistema sis = Factory.crearSistema();
        DTEspectador e = sis.buscarEspectador(nick);
        return e;
    }

    @WebMethod
    public ListString listarCategoriaE(String nombre) {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarCategoriaE(nombre));
        return lista;
    }

    @WebMethod
    public int validarUsuario(String nick, String pwd) {
        ISistema sis = Factory.crearSistema();
        return sis.validarUsuario(nick, pwd);
    }

    @WebMethod
    public ListString listarCategoriaPE(String nombre) {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarCategoriaPE(nombre));
        return lista;
    }

    @WebMethod
    public ListString listarCategorias() {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarCategorias());
        return lista;
    }

    @WebMethod
    public void estadoEspectaculo(String espectaculo, Estado es) {
        ISistema sis = Factory.crearSistema();
        sis.estadoEspectaculo(espectaculo, es);
    }

    @WebMethod
    public ListString listarEspectaculosNoProcesados() {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarEspectaculosNoProcesados());
        return lista;
    }

    @WebMethod
    public int aceptarRegisto(String plataforma, String espectaculo, String funcion, String usuario, String fecha) throws ParseException {
        ISistema sis = Factory.crearSistema();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date f = formato.parse(fecha);
        return sis.aceptarRegisto(plataforma, espectaculo, funcion, usuario, f);
    }

    @WebMethod
    public ListString listarEspectaculoPl(String plataforma) {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarEspectaculoPl(plataforma));
        return lista;
    }

    @WebMethod
    public ListString listarPlataforma() {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarPlataforma());
        return lista;
    }

    @WebMethod
    public ListString listarEspectaculoP(String paquete) {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarEspectaculoP(paquete));
        return lista;
    }

    @WebMethod
    public ListString listarPaquetes() {
        ISistema sis = Factory.crearSistema();
        ListString lista = new ListString(sis.listarPaquetes());
        return lista;
    }

    @WebMethod
    public boolean existeCategoria(String nombre) {
        ISistema sis = Factory.crearSistema();
        return sis.existeCategoria(nombre);
    }

    @WebMethod
    public boolean confirmarCategoria(String nombre) {
        ISistema sis = Factory.crearSistema();
        return sis.confirmarCategoria(nombre);
    }
    
    @WebMethod
    public boolean existeFuncion(String nombre){
        ISistema sis = Factory.crearSistema();
        return sis.existeFuncion(nombre);
    }

    @WebMethod
    public boolean existeFuncionenE(String espectaculo, String nombre) {
        ISistema sis = Factory.crearSistema();
        return sis.existeFuncionenE(espectaculo, nombre);
    }

    @WebMethod
    public void modificarArtista(String nick, String nombre, String apellido, String fecha, String bio, String desc, String link, String img) {
        ISistema sis = Factory.crearSistema();
        sis.modificarArtista(nick, nombre, apellido, fecha, bio, desc, link, img);
    }

    @WebMethod
    public void modificarEspectador(String nick, String nombre, String apellido, String fecha, String img) {
        ISistema sis = Factory.crearSistema();
        sis.modificarEspectador(nick, nombre, apellido, fecha, img);

    }
    
    @WebMethod
    public ListString listarEspectaculosArtista(String nick){
        ISistema sis = Factory.crearSistema();
        ListString res = new ListString(sis.listarEspectaculosArtista(nick));
        return res;
    }
    
    @WebMethod
    public ListString listarEspectaculosFinalizadosArtista(String nick){
        ISistema sis = Factory.crearSistema();
        ListString res = new ListString(sis.listarEspectaculosFinalizadosArtista(nick));
        return res;
    }

    @WebMethod
    public ListString listarTodosEspectaculosAceptados(){
        ISistema sis = Factory.crearSistema();
        ListString res = new ListString(sis.listarTodosEspectaculosAceptados());
        return res;
    }
    
    @WebMethod
    public ListString listarEspectaculosValoracion(String nick) throws ParseException{
        ISistema sis = Factory.crearSistema();
        ListString res = new ListString(sis.listarEspectaculosValoracion(nick));
        return res;
    }
    
    @WebMethod
    public void sortearPremios(String plataforma, String espectaculo, String funcion){
        ISistema sis = Factory.crearSistema();
        sis.sortearPremios(plataforma, espectaculo, funcion);
    }
    
    @WebMethod
    public boolean esFavorito(String nick, String espectaculo){
        ISistema sis = Factory.crearSistema();
        return sis.esFavorito(nick, espectaculo);
    }
    
    @WebMethod
    public void marcarFavorito(String espectaculo, String nick){
        ISistema sis = Factory.crearSistema();
        sis.marcarFavorito(espectaculo, nick);
    }
    
    @WebMethod
    public void desmarcarFavorito(String espectaculo, String nick){
        ISistema sis = Factory.crearSistema();
        sis.desmarcarFavorito(espectaculo, nick);
    }
    @WebMethod
    public void finalizarEspectaculo(String espectaculo){
        ISistema sis = Factory.crearSistema();
        sis.finalizarEspectaculo(espectaculo);
    }
    @WebMethod
    public void valorarEspectaculo(String espectaculo, String nick, Integer puntaje){
        ISistema sis = Factory.crearSistema();
        sis.valorarEspectaculo(espectaculo, nick, puntaje);
    }
    @WebMethod
    public boolean estaValorado(String espectaculo, String nick){
        ISistema sis = Factory.crearSistema();
        return sis.estaValorado(espectaculo, nick);
    }
    @WebMethod
    public void crearPDF(String nick, String premio) throws FileNotFoundException, DocumentException{
        ISistema sis = Factory.crearSistema();
        sis.crearPDF(nick, premio);
    }
    @WebMethod
    public DTUsuario buscarUsuario(String nick){
        ISistema sis = Factory.crearSistema();
        return sis.buscarUsuario(nick);
    }
}