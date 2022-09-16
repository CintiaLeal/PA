package Servlets;

import DataType.DtEspectaculo;
import DataType.Estado;
import Logica.Factory;
import Logica.ISistema;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

public class finalizarEspectaculo extends HttpServlet {

ISistema sis = Factory.crearSistema();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        String nick = sesion.getAttribute("nick").toString();
        String envio = request.getParameter("envio");
        String esp = request.getParameter("esp");
        if (nick != null) {
            if (envio.equals("1")) {
                DtEspectaculo e = sis.buscarEspectaculo(esp);
                request.setAttribute("nombre", e.getNombre());
                request.setAttribute("img", e.getImg());
                List<String> listaEspectaculosAceptados = new ArrayList();
                listaEspectaculosAceptados.add(e.getNombre());
                request.setAttribute("listaEspectaculosAceptados", listaEspectaculosAceptados);
                request.getRequestDispatcher("/finalizarEspectaculo.jsp").forward(request, response);
            }
            if (envio.equals("2")) {
                if (!"".equals(esp)) {
                    sis.finalizarEspectaculo(esp);
                    DtEspectaculo e = sis.buscarEspectaculo(esp);
                    if (e.getEstado() == Estado.finalizado) {
                        request.getRequestDispatcher("/exito.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("/500.jsp").forward(request, response);
                    }
                }
                request.getRequestDispatcher("/500.jsp").forward(request, response);
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
