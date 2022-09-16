/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import DataType.DtEspectaculo;
import Logica.Espectaculo;
import Logica.Factory;
import Logica.Funciones;
import Logica.ISistema;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leand
 */
@WebServlet(name = "consultarEspectaculoMobile", urlPatterns = {"/consultarEspectaculoMobile"})
public class consultarEspectaculoMobile extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ISistema sis = Factory.crearSistema();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String categoria = request.getParameter("cat");
        String envio = request.getParameter("envio");
        String plataforma = request.getParameter("pla");

        String espectaculo = request.getParameter("esp");
        if (envio.equals("1")) {
            request.setAttribute("filtroElegido", "categoria");
            request.setAttribute("filtro", categoria);
            //Listar para que no se queje
            List<String> listaPlataforma = sis.listarPlataforma();
            request.setAttribute("listaPlataforma", listaPlataforma);
            List<String> listaCategoria = sis.listarCategorias();
            request.setAttribute("listaCategoria", listaCategoria);

            List<String> listaCategorias = new ArrayList();
            request.setAttribute("listaCategorias", listaCategorias);

            List<String> listaPaquete = new ArrayList();
            request.setAttribute("listaPaquete", listaPaquete);

            List<String> listaFuncione = new ArrayList();
            request.setAttribute("listaFuncione", listaFuncione);
            List<String> listaEspectaculo = sis.listarEspectaculosAceptadoCategoria(categoria);

            request.setAttribute("listaEspectaculo", listaEspectaculo);

            request.getRequestDispatcher("/consultarEspectaculoMobile.jsp").forward(request, response);
        }
        if (envio.equals("2")) {
            request.setAttribute("filtroElegido", "plataforma");
            request.setAttribute("filtro", plataforma);
            List<String> listaPlataforma = sis.listarPlataforma();
            request.setAttribute("listaPlataforma", listaPlataforma);
            List<String> listaCategoria = sis.listarCategorias();
            request.setAttribute("listaCategoria", listaCategoria);
            //    Listas vacias para que la primera vez que entramos al jsp

            List<String> listaCategorias = new ArrayList();
            request.setAttribute("listaCategorias", listaCategorias);

            List<String> listaPaquete = new ArrayList();
            request.setAttribute("listaPaquete", listaPaquete);

            List<String> listaFuncione = new ArrayList();
            request.setAttribute("listaFuncione", listaFuncione);

            List<String> listaEspectaculo = sis.listarEspectaculosAceptado(plataforma);
            request.setAttribute("listaEspectaculo", listaEspectaculo);

            request.getRequestDispatcher("/consultarEspectaculoMobile.jsp").forward(request, response);
        }

        if (envio.equals("3")) {

            List<Integer> puntajes = sis.puntajeEspectaculo(espectaculo);
            float valore = 0;
            float e1 = 0;
            float e2 = 0;
            float e3 = 0;
            float e4 = 0;
            float e5 = 0;
            if (puntajes.size() > 0) {
                for (int i = 0; i < puntajes.size(); i++) {
                    if (puntajes.get(i) == 1) {
                        e1++;
                    } else if (puntajes.get(i) == 2) {
                        e2++;
                    } else if (puntajes.get(i) == 3) {
                        e3++;
                    } else if (puntajes.get(i) == 4) {
                        e4++;
                    } else if (puntajes.get(i) == 5) {
                        e5++;
                    }
                }
                valore = ((e5 * 5) + (e4 * 4) + (e3 * 3) + (e2 * 2) + (e1 * 1)) / (e5 + e4 + e3 + e2 + e1);
            }
            String str = new DecimalFormat("#.00").format(valore);

            request.setAttribute("e1", e1);
            request.setAttribute("e2", e2);
            request.setAttribute("e3", e3);
            request.setAttribute("e4", e4);
            request.setAttribute("e5", e5);
            request.setAttribute("valore", str);
            request.setAttribute("totalval", puntajes.size());
            String nick = (String) request.getSession().getAttribute("nick");

            if (sis.tipoUsuario(nick) == 1) {
                if (sis.esFavorito(nick, espectaculo)) {
                    request.setAttribute("favorito", "Es Favorito");
                } else {
                    request.setAttribute("favorito", "awjkgkdsgjl");
                }
            }

            //listas para que no se queje
            List<String> listaPlataforma = sis.listarPlataforma();
            request.setAttribute("listaPlataforma", listaPlataforma);
            List<String> listaCategoria = sis.listarCategorias();
            request.setAttribute("listaCategoria", listaCategoria);
            //    Listas vacias para que la primera vez que entramos al jsp
            
            List<String> listaEspectaculo;
            if( request.getParameter("filtroElegido").equals("categoria")){
                listaEspectaculo = sis.listarEspectaculosAceptadoCategoria(request.getParameter("filtro"));
            }
            else{
                listaEspectaculo = sis.listarEspectaculosAceptado(request.getParameter("filtro"));
            }
           
            request.setAttribute("listaEspectaculo", listaEspectaculo);

            DtEspectaculo e = sis.buscarEspectaculo(espectaculo);
            String nombre = e.getNombre();
            String descripcion = e.getDescripcion();

            Integer duracion = e.getDuracion();
            Integer cantMin = e.getCantMaxEsp();
            Integer cantMax = e.getCantMinEsp();
            Double costo = e.getCosto();
            String artista = e.getArtista().getNickname();
            String imagen = e.getImg();
            List<String> listaCategorias = sis.listarCategoriaE(espectaculo);
            List<String> listaFuncione = e.listarFunciones();
            List<String> listaPaquete = sis.listarPaqueteEspectaculo(e.getNombre());

            //video
            String url = e.getUrl();
            String video = sis.extraerIDYoutube(url);
            String videoEmbebido = sis.obtenerEnlaceEmbebido(video);

            request.setAttribute("videoEmbebido", videoEmbebido);
            //datos que devolvemos
            request.setAttribute("nombre", nombre);
            request.setAttribute("artista", artista);
            request.setAttribute("descripcion", descripcion);
            request.setAttribute("url", url);
            request.setAttribute("duracion", duracion);
            request.setAttribute("cantMin", cantMin);
            request.setAttribute("cantMax", cantMax);
            request.setAttribute("costo", costo);
            request.setAttribute("listaCategorias", listaCategorias);
            request.setAttribute("listaPaquete", listaPaquete);
            request.setAttribute("listaFuncione", listaFuncione);
            request.setAttribute("imagen", imagen);
            request.getRequestDispatcher("/consultarEspectaculoMobile.jsp").forward(request, response);
        }
        if (envio.equals("4")) {
            request.setAttribute("esp", espectaculo);
            //listas para que no se queje           
            List<String> listaPlataforma = sis.listarPlataforma();
            request.setAttribute("listaPlataforma", listaPlataforma);
            List<String> listaCategoria = sis.listarCategorias();
            request.setAttribute("listaCategoria", listaCategoria);
            List<String> listaEspectaculo = new ArrayList();
            request.setAttribute("listaEspectaculo", listaEspectaculo);
            //Listas vacias para que la primera vez que entramos al jsp
            List<String> listaFuncion = new ArrayList();
            request.setAttribute("listaFuncion", listaFuncion);
            String funcion = request.getParameter("fun");
            Funciones f = sis.buscarFunciones(funcion);
            String nombre = f.getNombre();
            String fecha = f.getFecha();
            String hora = f.getHora();
            String imagen = f.getImg();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date now = new Date();
            String fechaA = simpleDateFormat.format(now);

            List<String> listaArtista = f.listarArtista();
            request.setAttribute("listaArtista", listaArtista);
            request.setAttribute("nombre", nombre);
            request.setAttribute("fecha", fecha);
            request.setAttribute("hora", hora);
            request.setAttribute("imagen", imagen);
            request.getRequestDispatcher("/consultarFuncionMobile.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
