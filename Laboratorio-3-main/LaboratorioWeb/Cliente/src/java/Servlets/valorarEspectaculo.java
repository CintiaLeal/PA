package Servlets;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pkgWS.Publicador;
import pkgWS.PublicadorService;

public class valorarEspectaculo extends HttpServlet {
PublicadorService service = new PublicadorService();
Publicador sis = service.getPublicadorPort();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession(false);
        if (sesion != null) {
            String nick = sesion.getAttribute("nick").toString();
            if (nick != null && !nick.equals("")) {
                Integer tipo = sis.tipoUsuario(nick);
                if (tipo == 1) {
                    String envio = request.getParameter("envio");
                    if (envio.equals("1")) {
                        String esp = request.getParameter("espectaculos");
                        List<String> lista = new ArrayList();
                        lista.add(esp);
                        request.setAttribute("listaEspectaculos", lista);
                        if (sis.estaValorado(esp, nick)) {
                            request.setAttribute("btn", "Ya ha sido valorado");
                        } else {
                            request.setAttribute("btn", "Valorar");
                        }
                        request.getRequestDispatcher("/valorarEspectaculo.jsp").forward(request, response);
                    }
                    if (envio.equals("2")) {
                        String esp = request.getParameter("espectaculos");
                        String boton = request.getParameter("valorbtn");
                        if (boton.equals("Valorar")) {
                            String p = request.getParameter("puntaje");
                            Integer punt = Integer.parseInt(p);
                            sis.valorarEspectaculo(esp, nick, punt);
                            if (sis.estaValorado(esp, nick)) {
                                request.getRequestDispatcher("/exito.jsp").forward(request, response);
                            } else {
                                List<String> lista = new ArrayList();
                                lista.add(esp);
                                request.setAttribute("listaEspectaculos", lista);
                                request.setAttribute("btn", "Ya ha sido valorado");
                                request.getRequestDispatcher("/500.jsp").forward(request, response);
                            }
                        }
                        if (boton.equals("Ya ha sido valorado")) {
                            List<String> lista = new ArrayList();
                            lista.add(esp);
                            request.setAttribute("listaEspectaculos", lista);
                            request.setAttribute("btn", "Ya ha sido valorado");
                            request.getRequestDispatcher("/valorarEspectaculo.jsp").forward(request, response);
                        }
                    } else {
                        request.getRequestDispatcher("/500.jsp").forward(request, response);
                    }
                } else {
                    request.getRequestDispatcher("/errorpermiso.jsp").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("/errorpermiso.jsp").forward(request, response);
            }
        }
        request.getRequestDispatcher("/errorpermiso.jsp").forward(request, response);
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
