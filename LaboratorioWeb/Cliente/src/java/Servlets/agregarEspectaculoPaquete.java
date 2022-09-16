package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pkgWS.ListString;
import pkgWS.Publicador;
import pkgWS.PublicadorService;

public class agregarEspectaculoPaquete extends HttpServlet {

    PublicadorService service = new PublicadorService();
    Publicador sis = service.getPublicadorPort();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession(false);
        if (sesion != null) {
            String nick = (String) sesion.getAttribute("nick");
            Integer i = sis.tipoUsuario(nick);
            if (i == 2) {
                if (request.getParameter("pla") != null) {
                    String paquete = request.getParameter("paq");
                    String plataforma = request.getParameter("pla");
                    ListString listaPaquete = sis.listarPaquetes();
                    ListString listaPlataforma = sis.listarPlataforma();
                    ListString listaEspectaculosNoFormanParte = sis.listarEspectaculoQueNoFormanParte(paquete, plataforma);
                    request.setAttribute("listaPaquete", listaPaquete.getLista());
                    request.setAttribute("listaPlataforma", listaPlataforma.getLista());
                    request.setAttribute("listaEspectaculosNoFormanParte", listaEspectaculosNoFormanParte.getLista());
                    request.setAttribute("paquete", paquete);
                    request.getRequestDispatcher("agregarEspectaculoPaquete.jsp").forward(request, response);
                } else {
                    String paquete = request.getParameter("paquete");
                    String espectaculo = request.getParameter("esp");
                    sis.confirmarAgregarEspectaculoaPaquete(paquete, espectaculo);
                    if(sis.existePaquete(paquete)){
                        request.getRequestDispatcher("exito.jsp").forward(request, response);
                    }
                }
            }
            else{
                request.getRequestDispatcher("errorpermiso.jsp").forward(request, response);
            }
        }
        else{
            request.getRequestDispatcher("404.jsp").forward(request, response);
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

        //List<String> pla = sis.listarPlataforma();
        //  request.getRequestDispatcher("/agregarEspectaculoPaquete.jsp").forward(request, response);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet agregarEspectaculoPaquete</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<select>   ");
            out.println("<c:forEach var=\"elem\" items=\"${pla}\">");
            out.println("<option>${elem}</option>");
            out.println("</c:forEach>");
            out.println("</select>");
            out.println("</body>");
            out.println("</html>");
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
