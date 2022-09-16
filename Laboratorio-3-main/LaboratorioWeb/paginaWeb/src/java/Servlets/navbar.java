/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Logica.Factory;
import Logica.ISistema;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "navbar", urlPatterns = {"/navbar"})
public class navbar extends HttpServlet {

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
        if (request.getSession(false).getAttribute("nick") != null && !request.getSession(false).getAttribute("nick").toString().equals("")) {
            if (request.getParameter("envio").equals("1")) {
                List<String> listaPlataforma = sis.listarPlataforma();
                request.setAttribute("listaPlataforma", listaPlataforma);
                List<String> listaCategoria = sis.listarCategorias();
                request.setAttribute("listaCategoria", listaCategoria);

                //Listas vacias para que la primera vez que entramos al jsp
                List<String> listaEspectaculo = new ArrayList();
                request.setAttribute("listaEspectaculo", listaEspectaculo);

                List<String> listaCategorias = new ArrayList();
                request.setAttribute("listaCategorias", listaCategorias);

                List<String> listaPaquete = new ArrayList();
                request.setAttribute("listaPaquete", listaPaquete);

                List<String> listaFuncione = new ArrayList();
                request.setAttribute("listaFuncione", listaFuncione);
                request.getRequestDispatcher("/consultarEspectaculoMobile.jsp").forward(request, response);
            }
            if (request.getParameter("envio").equals("2")) {
                List<String> listaPlataforma = sis.listarPlataforma();
                request.setAttribute("listaPlataforma", listaPlataforma);

                List<String> listaCategoria = sis.listarCategorias();
                request.setAttribute("listaCategoria", listaCategoria);

                //Listas vacias para que la primera vez que entramos al jsp
                List<String> listaEspectaculo = new ArrayList();
                request.setAttribute("listaEspectaculo", listaEspectaculo);

                List<String> listaArtista = new ArrayList();
                request.setAttribute("listaArtista", listaArtista);

                List<String> listaFuncion = new ArrayList();
                request.setAttribute("listaFuncion", listaFuncion);

                request.getRequestDispatcher("/consultarFuncionMobile.jsp").forward(request, response);
            }
            if (request.getParameter("envio").equals("3")) {
                request.getSession(false).invalidate();
                request.logout();
                request.getSession(false);
                request.getRequestDispatcher("/indexMobile.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/errorpermiso.jsp").forward(request, response);
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
