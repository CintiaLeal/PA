package Servlets;


import Logica.Factory;
import Logica.ISistema;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class modificarEspectador extends HttpServlet {

ISistema sis = Factory.crearSistema();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        if (sesion != null) {
            String nick = sesion.getAttribute("nick").toString();
            Integer u = sis.tipoUsuario(nick);
            if (u == 1) {
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String fecha = request.getParameter("fecha");
                if (fecha.equals("null")) {
                    fecha = "";
                }
                String img = request.getParameter("imagen");
                sis.modificarEspectador(nick, nombre, apellido, fecha, img);
                request.getRequestDispatcher("/exito.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/errorpermiso.jsp").forward(request, response);
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
