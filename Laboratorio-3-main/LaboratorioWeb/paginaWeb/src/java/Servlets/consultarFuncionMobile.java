/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DataType.DtEspectaculo;
import Logica.Espectaculo;
import Logica.Factory;
import Logica.Funciones;
import Logica.ISistema;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class consultarFuncionMobile extends HttpServlet {

    ISistema sis = Factory.crearSistema();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");

        String envio = request.getParameter("envio");
        String categoria = request.getParameter("cat");
        String plataforma = request.getParameter("pla");
        String funcion = request.getParameter("fun");
        if (envio.equals("1")) {
           
            //Listar para que no se queje
            List<String> listaPlataforma = sis.listarPlataforma();
            request.setAttribute("listaPlataforma", listaPlataforma);
            List<String> listaCategoria = sis.listarCategorias();
            request.setAttribute("listaCategoria", listaCategoria);

            List<String> listaArtista = new ArrayList();
            request.setAttribute("listaArtista", listaArtista);

            List<String> listaFuncion = new ArrayList();

            request.setAttribute("listaFuncion", listaFuncion);
            List<String> listaEspectaculo = sis.listarEspectaculosAceptadoCategoria(categoria);

            request.setAttribute("listaEspectaculo", listaEspectaculo);

            request.getRequestDispatcher("/consultarFuncionMobile.jsp").forward(request, response);
        }
        if (envio.equals("2")) {
           
            //Listar para que no se queje
            List<String> listaPlataforma = sis.listarPlataforma();
            request.setAttribute("listaPlataforma", listaPlataforma);
            List<String> listaCategoria = sis.listarCategorias();
            request.setAttribute("listaCategoria", listaCategoria);
            List<String> listaFuncion = new ArrayList();

            request.setAttribute("listaFuncion", listaFuncion);

            List<String> listaArtista = new ArrayList();
            request.setAttribute("listaArtista", listaArtista);
            List<String> listaEspectaculo = sis.listarEspectaculosAceptado(plataforma);

            request.setAttribute("listaEspectaculo", listaEspectaculo);

            request.getRequestDispatcher("/consultarFuncionMobile.jsp").forward(request, response);
        }
        if (envio.equals("3")) {
            
            String espectaculo = request.getParameter("esp");
            DtEspectaculo e = sis.buscarEspectaculo(espectaculo);
            request.setAttribute("esp", espectaculo);
            //listas para que no se queje
            List<String> listaPlataforma = sis.listarPlataforma();
            request.setAttribute("listaPlataforma", listaPlataforma);
            List<String> listaCategoria = sis.listarCategorias();
            request.setAttribute("listaCategoria", listaCategoria);
            List<String> listaArtista = new ArrayList();
            request.setAttribute("listaArtista", listaArtista);
            List<String> listaEspectaculo = new ArrayList();
            listaEspectaculo.add(espectaculo);

            request.setAttribute("listaEspectaculo", listaEspectaculo);
            //Listas vacias para que la primera vez que entramos al jsp

                List<String> listaFuncion = e.listarFunciones();
                request.setAttribute("listaFuncion", listaFuncion);

           request.getRequestDispatcher("/consultarFuncionMobile.jsp").forward(request, response);

        }

        if (envio.equals("4")) {
            String espectaculo = request.getParameter("espe");
            request.setAttribute("esp", espectaculo);
            //listas para que no se queje           
            List<String> listaPlataforma = sis.listarPlataforma();
            request.setAttribute("listaPlataforma", listaPlataforma);
            List<String> listaCategoria = sis.listarCategorias();
            request.setAttribute("listaCategoria", listaCategoria);
            List<String> listaEspectaculo = new ArrayList();
            request.setAttribute("listaEspectaculo", listaEspectaculo);
            //Listas vacias para que la primera vez que entramos al jsp
            List<String> listaFuncion =  new ArrayList();
            request.setAttribute("listaFuncion", listaFuncion);
            Funciones f = sis.buscarFunciones(funcion);
            String nombre = f.getNombre();
            String fecha = f.getFecha();
            String hora = f.getHora();
            String imagen = f.getImg();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); 
            Date now = new Date(); 
            String fechaA = simpleDateFormat.format(now);
            Date ahora = simpleDateFormat.parse(fechaA);
            Date fechaFuncion = simpleDateFormat.parse(f.getFecha());
            
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(consultarFuncion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(consultarFuncion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
