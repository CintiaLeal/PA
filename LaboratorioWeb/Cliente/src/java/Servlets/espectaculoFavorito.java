package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import pkgWS.Publicador;
import pkgWS.PublicadorService;

public class espectaculoFavorito extends HttpServlet {

    PublicadorService service = new PublicadorService();
    Publicador sis = service.getPublicadorPort();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession(false);
        String user = sesion.getAttribute("nick").toString();
        if (user != null && !user.equals("")) {
            Integer tipo = sis.tipoUsuario(user);
            if (tipo == 1) {
                String envio = request.getParameter("envio");
                if (envio.equals("1")) {
                    String esp = request.getParameter("espectaculos");
                    if (sis.esFavorito(user, esp)) {
                        request.setAttribute("btn", "Desmarcar");
                    } else {
                        request.setAttribute("btn", "Marcar");
                    }
                    List<String> lista = new ArrayList();
                    lista.add(esp);
                    request.setAttribute("listaEspectaculos", lista);
                    request.getRequestDispatcher("/espectaculoFavorito.jsp").forward(request, response);
                }
                if (envio.equals("2")) {
                    String op = request.getParameter("espFavorito");
                    String esp = request.getParameter("espectaculos");
                    if (op.equals("Marcar")) { //agregar fav
                        sis.marcarFavorito(esp, user);
                        if (sis.esFavorito(user, esp)) { //confirmo si lo marca
                            request.getRequestDispatcher("/exito.jsp").forward(request, response);
                        } else {
                            request.getRequestDispatcher("/500.jsp").forward(request, response);
                        }
                    }
                    if (op.equals("Desmarcar")) { //quitar fav
                        sis.desmarcarFavorito(esp, user);
                        if (!sis.esFavorito(user, esp)) { //confirmo si lo desmarcó
                            request.getRequestDispatcher("/exito.jsp").forward(request, response);
                        } else {
                            request.getRequestDispatcher("/500.jsp").forward(request, response);
                        }
                    }
                }
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
