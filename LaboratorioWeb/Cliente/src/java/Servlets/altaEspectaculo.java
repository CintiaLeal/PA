package Servlets;

import pkgWS.Estado;
import pkgWS.ListString;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pkgWS.Publicador;
import pkgWS.PublicadorService;

public class altaEspectaculo extends HttpServlet {

    PublicadorService service = new PublicadorService();
    Publicador sis = service.getPublicadorPort();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession(false);
        if (sesion != null) {
            String nick = sesion.getAttribute("nick").toString();
            Integer u = sis.tipoUsuario(nick);
            if (u == 2) {
                String img = request.getParameter("imagen");
                String plataforma = request.getParameter("pla").toString();
                String nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("descripcion");
                String url = request.getParameter("url");
                String duracion = request.getParameter("duracion");
                Integer dura = Integer.parseInt(duracion);
                String canMin = request.getParameter("canMin");
                Integer cM = Integer.parseInt(canMin);
                String canMax = request.getParameter("canMax");
                Integer cMa = Integer.parseInt(canMax);
                String costo = request.getParameter("costo");
                Integer cantP = Integer.parseInt(request.getParameter("cant"));
                String descP = request.getParameter("descP");
                double cost = Double.parseDouble(costo);
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                Date fecha = new Date();
                String fechaAlta = fecha.toString();

                HttpSession session = request.getSession();
                String artista = (String) session.getAttribute("nick");
                String categoria = request.getParameter("categorias");
                char[] cat = categoria.toCharArray();
                String aux = "";
                List<String> resultado = new ArrayList();

                for (int i = 0; i < cat.length; i++) {
                    if (cat[i] == ',') {
                        resultado.add(aux);
                        aux = "";
                    } else {
                        aux += cat[i];
                    }
                }
                resultado.add(aux);

                if (!sis.existeEspectaculo(nombre)) {
                    ListString resultado1 = new ListString(resultado);
                    boolean b = sis.confirmarEspectaculo(plataforma, artista, nombre, descripcion, url, dura, cM, cMa, cost, fechaAlta, Estado.INGRESADO, resultado1, img, cantP, descP);
                    request.getRequestDispatcher("/exito.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }
            }
        }
        request.getRequestDispatcher("/404.jsp").forward(request, response);
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
