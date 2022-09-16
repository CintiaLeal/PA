/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

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
import pkgWS.DtEspectaculo;
import pkgWS.DtFunciones;
import pkgWS.Espectaculo;
import pkgWS.Funciones;
import pkgWS.ListString;
import pkgWS.Publicador;
import pkgWS.PublicadorService;

public class consultarFuncion extends HttpServlet {

    PublicadorService service = new PublicadorService();
    Publicador sis = service.getPublicadorPort();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");

        String envio = request.getParameter("envio");
        String categoria = request.getParameter("cat");
        String plataforma = request.getParameter("pla");
        String funcion = request.getParameter("fun");
        if (envio.equals("1")) {
           
            //Listar para que no se queje
            ListString listaPlataforma = sis.listarPlataforma();
            request.setAttribute("listaPlataforma", listaPlataforma.getLista());
            ListString listaCategoria = sis.listarCategorias();
            request.setAttribute("listaCategoria", listaCategoria.getLista());

            List<String> listaArtista = new ArrayList();
            request.setAttribute("listaArtista", listaArtista);

            List<String> listaFuncion = new ArrayList();

            request.setAttribute("listaFuncion", listaFuncion);
            ListString listaEspectaculo = sis.listarEspectaculosAceptadoCategoria(categoria);

            request.setAttribute("listaEspectaculo", listaEspectaculo.getLista());

            request.getRequestDispatcher("/consultarFuncion.jsp").forward(request, response);
        }
        if (envio.equals("2")) {
           
            //Listar para que no se queje
            ListString listaPlataforma = sis.listarPlataforma();
            request.setAttribute("listaPlataforma", listaPlataforma.getLista());
            ListString listaCategoria = sis.listarCategorias();
            request.setAttribute("listaCategoria", listaCategoria.getLista());
            List<String> listaFuncion = new ArrayList();

            request.setAttribute("listaFuncion", listaFuncion);

            List<String> listaArtista = new ArrayList();
            request.setAttribute("listaArtista", listaArtista);
            ListString listaEspectaculo = sis.listarEspectaculosAceptado(plataforma);
            request.setAttribute("listaEspectaculo", listaEspectaculo.getLista());
            request.getRequestDispatcher("/consultarFuncion.jsp").forward(request, response);
        }
        if (envio.equals("3")) {
            
            String espectaculo = request.getParameter("espectaculo");
            DtEspectaculo e = sis.buscarEspectaculo(espectaculo);
            request.setAttribute("esp", espectaculo);
            //listas para que no se queje
            ListString listaPlataforma = sis.listarPlataforma();
            request.setAttribute("listaPlataforma", listaPlataforma.getLista());
            ListString listaCategoria = sis.listarCategorias();
            request.setAttribute("listaCategoria", listaCategoria.getLista());
            List<String> listaArtista = new ArrayList();
            request.setAttribute("listaArtista", listaArtista);
            List<String> listaEspectaculo = new ArrayList();
            listaEspectaculo.add(espectaculo);

            request.setAttribute("listaEspectaculo", listaEspectaculo);
            //Listas vacias para que la primera vez que entramos al jsp

                List<String> listaFuncion = e.listarFunciones();
                request.setAttribute("listaFuncion", listaFuncion);

           request.getRequestDispatcher("/consultarFuncion.jsp").forward(request, response);

        }

        if (envio.equals("4")) {
            String espectaculo = request.getParameter("espe");
            request.setAttribute("esp", espectaculo);
            //listas para que no se queje           
            ListString listaPlataforma = sis.listarPlataforma();
            request.setAttribute("listaPlataforma", listaPlataforma.getLista());
            ListString listaCategoria = sis.listarCategorias();
            request.setAttribute("listaCategoria", listaCategoria.getLista());
            List<String> listaEspectaculo = new ArrayList();
            request.setAttribute("listaEspectaculo", listaEspectaculo);
            //Listas vacias para que la primera vez que entramos al jsp
            List<String> listaFuncion =  new ArrayList();
            request.setAttribute("listaFuncion", listaFuncion);
            DtFunciones f = sis.buscarFunciones(funcion);
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
            if(fechaFuncion.after(ahora)){
                request.setAttribute("sorteo", "No hay sorteo disponible");
            }
            else{
                request.setAttribute("sorteo", "Sortear");
            }
            List<String> listaArtista = f.listarArtista();
            request.setAttribute("listaArtista", listaArtista);
            request.setAttribute("nombre", nombre);
            request.setAttribute("fecha", fecha);
            request.setAttribute("hora", hora);
            request.setAttribute("imagen", imagen);
            request.getRequestDispatcher("/consultarFuncion.jsp").forward(request, response);
        }
        if(envio.equals("5")){
            String espectaculo = request.getParameter("espe");
            String fun = request.getParameter("nombre");
            sis.sortearPremios(plataforma, espectaculo, fun);
            request.getRequestDispatcher("/exito.jsp").forward(request, response);
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
