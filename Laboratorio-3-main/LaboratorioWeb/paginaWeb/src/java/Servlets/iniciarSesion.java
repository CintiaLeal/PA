package Servlets;


import Logica.Factory;
import Logica.ISistema;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class iniciarSesion extends HttpServlet {


ISistema sis = Factory.crearSistema();

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //0 no existe o no coincide la pwd
        //1 es espectador
        //2 es artista
        String nick = request.getParameter("nick");
        String password = request.getParameter("password");
        HttpSession sesion = request.getSession(true);       
            Integer i = sis.validarUsuario(nick, password);
            if (i == 1) {
                List<String> listaNull = new ArrayList();
                request.setAttribute("listaNull", listaNull);
                sesion.setAttribute("nick", nick);

                request.getRequestDispatcher("menuEspectador.jsp").forward(request, response);
            } else if (i == 2) {

                sesion.setAttribute("nick", nick);
                List<String> listaNull = new ArrayList();
                request.setAttribute("listaNull", listaNull);
                sesion.setAttribute("nick", nick);
                request.getRequestDispatcher("menuArtista.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/errorsesion.jsp").forward(request, response);
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
