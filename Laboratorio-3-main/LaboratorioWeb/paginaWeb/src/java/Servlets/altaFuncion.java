/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DataType.ListString;
import Logica.Factory;
import Logica.ISistema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class altaFuncion extends HttpServlet {


ISistema sis = Factory.crearSistema();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession(false);
        if (sesion != null) {
            String user = sesion.getAttribute("nick").toString();
            Integer u = sis.tipoUsuario(user);
            if (u == 2) {
                String envio = request.getParameter("envio");
                String plataforma = request.getParameter("pla");

                if (envio.equals("1")) {

                    //Listar para que no se queje
                    List<String> listaPlataforma = sis.listarPlataforma();
                    request.setAttribute("listaPlataforma", listaPlataforma);

                    List<String> listaArtista = sis.listarArtistas();
                    request.setAttribute("listaArtista", listaArtista);

                    List<String> listaEspectaculo = sis.listarEspectaculosAceptado(plataforma);

                    request.setAttribute("listaEspectaculo", listaEspectaculo);

                    request.getRequestDispatcher("/altaFuncion.jsp").forward(request, response);
                }

                if (envio.equals("2")) {

                    String espectaculo = request.getParameter("esp");
                    String nombre = request.getParameter("nombre");
                    String hora = request.getParameter("hora");
                    String fecha = request.getParameter("fecha");
                    String img = request.getParameter("imagen");
                    String artista = request.getParameter("artista");
                    char[] cat = artista.toCharArray();
                    String aux = "";
                    List<String> resultado = new ArrayList();

                    for (int i = 0; i < cat.length; i++) {
                        if (cat[i] == ',') {
                            resultado.add(aux);
                            aux = "";
                        } else {
                            aux += cat[i];
                        }
                    }
                    resultado.add(aux);

                    if (!sis.existeFuncion(nombre)) {
                        ListString resultado1 = new ListString(resultado);
                        sis.altaFuncion(plataforma, espectaculo, resultado1, nombre, fecha, hora,img);
                        
                        request.getRequestDispatcher("/exito.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("/error.jsp").forward(request, response);
                    }
                } else {
                    request.getRequestDispatcher("/404.jsp").forward(request, response);
                }
            }
            else{
                request.getRequestDispatcher("/errorpermiso.jsp").forward(request, response);
            }
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
