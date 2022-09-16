package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import pkgWS.DtEspectaculo;
import pkgWS.Publicador;
import pkgWS.PublicadorService;

public class consultarEspectaculoFinalizado extends HttpServlet {

    PublicadorService service = new PublicadorService();
    Publicador sis = service.getPublicadorPort();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession(false);
        String nick = (String) sesion.getAttribute("nick");
        if (nick != null || !nick.equals("")) {
            Integer tipo = sis.tipoUsuario(nick);
            if (tipo == 2) {
                String esp = request.getParameter("esp");
                DtEspectaculo e = sis.buscarEspectaculo(esp);
                request.setAttribute("nombre", e.getNombre());
                request.setAttribute("imagen", e.getImg());
                request.setAttribute("artista", e.getArtista().getNickname());
                request.setAttribute("duracion", e.getDuracion());
                request.setAttribute("descripcion", e.getDescripcion());
                request.setAttribute("costo", e.getCosto());
                request.setAttribute("cantMin", e.getCantMinEsp());
                request.setAttribute("cantMax", e.getCantMaxEsp());
                String url = e.getUrl();
                String video = sis.extraerIDYoutube(url);
                String videoEmbebido = sis.obtenerEnlaceEmbebido(video);
                request.setAttribute("videoEmbebido", videoEmbebido);
                request.setAttribute("listaCategorias", sis.listarCategoriaE(esp).getLista());
                request.setAttribute("listaPaquete", sis.listarPaqueteEspectaculo(esp).getLista());
                request.setAttribute("listaFuncione", e.listarFunciones());
                List<String> listaEspectaculo = new ArrayList();
                listaEspectaculo.add(esp);
                request.setAttribute("listaEspectaculo", listaEspectaculo);
                request.getRequestDispatcher("/consultarEspectaculoFinalizado.jsp").forward(request, response);
            }
            else{
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
