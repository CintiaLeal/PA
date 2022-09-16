
package Servlets;

import DataType.DtBusqueda;
import DataType.ListBusqueda;
import DataType.ListString;
import Logica.Factory;
import Logica.ISistema;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class buscador extends HttpServlet {
ISistema sis = Factory.crearSistema();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String valor = request.getParameter("valor");        
       // List<String> resultado = sis.listarBusqueda(valor);
        //request.setAttribute("resultado",resultado);
        
        List<String> listaC = sis.listarCategorias();
        //List<String> listaC = listaCategoria.getLista();
        request.setAttribute("listaCategoria", listaC);
        List<String> listaP = sis.listarPlataforma();
        //List<String> listaP = listaPlataforma.getLista();
        request.setAttribute("listaPlataforma", listaP);
        List<DtBusqueda> listB = sis.devolverBusqueda(valor);
        //List<DtBusqueda> listB = list.getBusquedas();
        request.setAttribute("list",listB);

        request.getRequestDispatcher("/listarBusqueda.jsp").forward(request, response);
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
