package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pkgWS.DtEspectaculo;
import pkgWS.ListString;
import pkgWS.Publicador;
import pkgWS.PublicadorService;

public class consultaEspectaculo extends HttpServlet {

    PublicadorService service = new PublicadorService();
    Publicador sis = service.getPublicadorPort();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String aux = "";
            try {
                String categoria = request.getParameter("cat");
                String envio = request.getParameter("envio");
                String plataforma = request.getParameter("pla");

                String espectaculo = request.getParameter("esp");

                if (envio.equals("1")) {

                    //Listar para que no se queje
                    ListString listaPlataforma = sis.listarPlataforma();
                    List<String> listP = listaPlataforma.getLista();
                    request.setAttribute("listaPlataforma", listP);
                    ListString listaCategoria = sis.listarCategorias();
                    List<String> listaC = listaCategoria.getLista();
                    request.setAttribute("listaCategoria", listaC);

                    ListString listaPaquete = new ListString();
                    List<String> listaPaq = listaPaquete.getLista();
                    request.setAttribute("listaPaquete", listaPaq);

                    ListString listaFuncione = new ListString();
                    List<String> listaF = listaFuncione.getLista();
                    request.setAttribute("listaFuncione", listaF);
                    request.setAttribute("listaCategorias", listaF);

                    ListString listaEspectaculo = sis.listarEspectaculosAceptadoCategoria(categoria);
                    request.setAttribute("listaEspectaculo", listaEspectaculo.getLista());

                    request.getRequestDispatcher("/consultaEspectaculo.jsp").forward(request, response);
                }
                if (envio.equals("2")) {

                    ListString listaPlataforma = sis.listarPlataforma();
                    request.setAttribute("listaPlataforma", listaPlataforma.getLista());
                    ListString listaCategoria = sis.listarCategorias();
                    request.setAttribute("listaCategoria", listaCategoria.getLista());
                    //    Listas vacias para que la primera vez que entramos al jsp

                    ListString listaCategorias = new ListString();
                    request.setAttribute("listaCategorias", listaCategorias.getLista());

                    ListString listaPaquete = new ListString();
                    request.setAttribute("listaPaquete", listaPaquete.getLista());

                    List<String> listaFuncione = new ArrayList();
                    request.setAttribute("listaFuncione", listaFuncione);

                    ListString listaEspectaculo = sis.listarEspectaculosAceptado(plataforma);
                    request.setAttribute("listaEspectaculo", listaEspectaculo.getLista());

                    request.getRequestDispatcher("/consultaEspectaculo.jsp").forward(request, response);
                }

                if (envio.equals("3")) {
                    //listas para que no se queje
                    ListString listaPlataforma = sis.listarPlataforma();
                    request.setAttribute("listaPlataforma", listaPlataforma.getLista());
                    ListString listaCategoria = sis.listarCategorias();
                    request.setAttribute("listaCategoria", listaCategoria.getLista());
                    //    Listas vacias para que la primera vez que entramos al jsp

                    ListString listaEspectaculo = sis.listarEspectaculoPl(plataforma);
                    request.setAttribute("listaEspectaculo", listaEspectaculo.getLista());

                    DtEspectaculo e = sis.buscarEspectaculo(espectaculo);
                    String nombre = e.getNombre();
                    String descripcion = e.getDescripcion();
                    Integer cantP = e.getCantPremios();
                    String descP = e.getDescPremio();
                    Integer duracion = e.getDuracion();
                    Integer cantMin = e.getCantMaxEsp();
                    Integer cantMax = e.getCantMinEsp();
                    Double costo = e.getCosto();
                    String artista = e.getArtista().getNickname();
                    String imagen = e.getImg();
                    ListString listaCategorias = sis.listarCategoriaE(espectaculo);
                    List<String> listaFuncione = e.listarFunciones();
                    ListString listaPaquete = sis.listarPaqueteEspectaculo(e.getNombre());

                    //video
                    String url = e.getUrl();
                    String video = sis.extraerIDYoutube(url);
                    String videoEmbebido = sis.obtenerEnlaceEmbebido(video);

                    request.setAttribute("videoEmbebido", videoEmbebido);
                    //datos que devolvemos
                    request.setAttribute("nombre", nombre);
                    request.setAttribute("artista", artista);
                    request.setAttribute("descripcion", descripcion);
                    request.setAttribute("descripcionP", descP);
                    request.setAttribute("cantP", cantP);
                    request.setAttribute("url", url);
                    request.setAttribute("duracion", duracion);
                    request.setAttribute("cantMin", cantMin);
                    request.setAttribute("cantMax", cantMax);
                    request.setAttribute("costo", costo);
                    request.setAttribute("listaCategorias", listaCategorias.getLista());
                    request.setAttribute("listaPaquete", listaPaquete.getLista());
                    request.setAttribute("listaFuncione", listaFuncione);
                    request.setAttribute("imagen", imagen);
                    request.getRequestDispatcher("/consultaEspectaculo.jsp").forward(request, response);
                }
            } catch (Exception ex) {
                aux = ex.getMessage();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet altaUsuario</title>");
                out.println("</head>");
                out.println("<body>");
                out.println(aux);
                out.println("</body>");
                out.println("</html>");
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
