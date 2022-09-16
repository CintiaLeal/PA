
package Servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pkgWS.DtBusqueda;
import pkgWS.ListBusqueda;
import pkgWS.ListString;
import pkgWS.Publicador;
import pkgWS.PublicadorService;


public class buscador extends HttpServlet {
    PublicadorService service = new PublicadorService();
    Publicador sis = service.getPublicadorPort();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String valor = request.getParameter("valor");        
       // List<String> resultado = sis.listarBusqueda(valor);
        //request.setAttribute("resultado",resultado);
        
        ListString listaCategoria = sis.listarCategorias();
        List<String> listaC = listaCategoria.getLista();
        request.setAttribute("listaCategoria", listaC);
        ListString listaPlataforma = sis.listarPlataforma();
        List<String> listaP = listaPlataforma.getLista();
        request.setAttribute("listaPlataforma", listaP);
        ListBusqueda list = sis.devolverBusqueda(valor);
        List<DtBusqueda> listB = list.getBusquedas();
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
