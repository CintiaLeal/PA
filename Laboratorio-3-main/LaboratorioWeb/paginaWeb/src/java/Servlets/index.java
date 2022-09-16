package Servlets;

import DataType.ListString;
import Logica.Factory;
import Logica.ISistema;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class index extends HttpServlet {


ISistema sis = Factory.crearSistema();

    //1 es espectador
    //2 es artista
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String envio = request.getParameter("envio");
        String var = request.getParameter("agente");
        if(var.equals("desktop")){
            request.getRequestDispatcher("/indexDesktop.jsp").forward(request, response);
        }
        if(var.equals("mobile")){
            request.getRequestDispatcher("/indexMobile.jsp").forward(request, response);
        }
        if (envio.equals("1")) {
            request.getRequestDispatcher("/buscarUsuario.jsp").forward(request, response);
        }
        if(envio.equals("2")){
            request.getRequestDispatcher("/iniciarSesion.jsp").forward(request, response);
        }
        List<String> listP = sis.listarPlataforma();
//        List<String> listP = listaPlataforma.getLista();
        request.setAttribute("listaPlataforma", listP);

        List<String> listaC = sis.listarCategorias();
//        List<String> listaC = listaCategoria.getLista();
        request.setAttribute("listaCategoria", listaC);

        //Listas vacias para que la primera vez que entramos al jsp
        List<String> listaEspectaculo = new ArrayList();
        request.setAttribute("listaEspectaculo", listaEspectaculo);

        if (envio.equals("3")) {

            List<String> listaPaquete = new ArrayList();
            request.setAttribute("listaPaquete", listaPaquete);
            List<String> listaCategorias = new ArrayList();
            request.setAttribute("listaCategorias", listaCategorias);
            List<String> listaFuncione = new ArrayList();
            request.setAttribute("listaFuncione", listaFuncione);
            request.getRequestDispatcher("/consultaEspectaculo.jsp").forward(request, response);
        }
        if (envio.equals("4")) {
            List<String> listaPaquete = new ArrayList();
            request.setAttribute("listaPaquete", listaPaquete);
            List<String> listaFuncione = new ArrayList();
            request.setAttribute("listaFuncione", listaFuncione);
            request.getRequestDispatcher("/consultaPaqueteEspectaculo.jsp").forward(request, response);
        }
        if (envio.equals("5")) {
            List<String> listaFuncion = new ArrayList();
            request.setAttribute("listaFuncion", listaFuncion);
            List<String> listaArtista = new ArrayList();
            request.setAttribute("listaArtista", listaArtista);
            request.getRequestDispatcher("/consultarFuncion.jsp").forward(request, response);
        }
        
        if(envio.equals("9")){
        
        
        request.getRequestDispatcher("/registrarEspectador.jsp").forward(request, response);
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
