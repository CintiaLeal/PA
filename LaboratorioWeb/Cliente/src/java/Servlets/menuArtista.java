package Servlets;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pkgWS.ListString;
import pkgWS.Publicador;
import pkgWS.PublicadorService;

public class menuArtista extends HttpServlet {
PublicadorService service = new PublicadorService();
Publicador sis = service.getPublicadorPort();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession(false);
        if (sesion != null) {
            String user = sesion.getAttribute("nick").toString();
            Integer u = sis.tipoUsuario(user);
            if (u == 2) {
                String envio = request.getParameter("envio");

                if (envio.equals("1")) {
                    ListString listaPaquete = sis.listarPaquetes();
                    List<String> listaPac = listaPaquete.getLista();
                    request.setAttribute("listaPaquete", listaPac);
                    List<String> listaCategoria = new ArrayList();
                    request.setAttribute("listaCategoria", listaCategoria);
                    List<String> listaEspectaculo = new ArrayList();
                    request.setAttribute("listaEspectaculo", listaEspectaculo);
                    request.getRequestDispatcher("consultaPaqueteEspectaculo.jsp").forward(request, response);
                }
                if (envio.equals("2")) {

                    ListString listaPaquete = sis.listarPaquetes();
                    List<String> listaPac = listaPaquete.getLista();
                    ListString listaPlataforma = sis.listarPlataforma();
                    List<String> listaPla = listaPlataforma.getLista();
                    List<String> listaEspectaculosNoFormanParte = new ArrayList();

                    request.setAttribute("listaPaquete", listaPac);
                    request.setAttribute("listaPlataforma", listaPla);
                    request.setAttribute("listaEspectaculosNoFormanParte", listaEspectaculosNoFormanParte);
                    request.getRequestDispatcher("agregarEspectaculoPaquete.jsp").forward(request, response);
                }
                if (envio.equals("3")) {
                    List<String> listaNull = new ArrayList();
                    request.setAttribute("listaNull", listaNull);
                    request.getRequestDispatcher("crearPaqueteEspectaculo.jsp").forward(request, response);
                }

                if (envio.equals("4")) {
                    List<String> listaNull = new ArrayList();
                    request.setAttribute("listaNull", listaNull);
                    request.getRequestDispatcher("modificarArtista.jsp").forward(request, response);

                }
                if (envio.equals("5")) {
                    ListString listaCategoria = sis.listarCategorias();
                    List<String> listaC = listaCategoria.getLista();
                    request.setAttribute("listaCategoria", listaC);
                    ListString listaPlataforma = sis.listarPlataforma();
                    List<String> listaPla = listaPlataforma.getLista();
                    request.setAttribute("listaPlataforma", listaPla);

                    request.getRequestDispatcher("altaEspectaculo.jsp").forward(request, response);

                }

                if (envio.equals("6")) {
                    ListString listaCategoria = sis.listarCategorias();
                    List<String> listaC = listaCategoria.getLista();
                    request.setAttribute("listaCategoria", listaC);
                    ListString listaPlataforma = sis.listarPlataforma();
                    List<String> listaPla = listaPlataforma.getLista();
                    request.setAttribute("listaPlataforma", listaPla);
                    //Listas vacias para que la primera vez que entramos al jsp
                    List<String> listaEspectaculo = new ArrayList();
                    request.setAttribute("listaEspectaculo", listaEspectaculo);

                    List<String> listaCategorias = new ArrayList();
                    request.setAttribute("listaCategorias", listaCategorias);

                    List<String> listaPaquete = new ArrayList();
                    request.setAttribute("listaPaquete", listaPaquete);

                    List<String> listaFuncione = new ArrayList();
                    request.setAttribute("listaFuncione", listaFuncione);

                    request.getRequestDispatcher("/consultaEspectaculo.jsp").forward(request, response);
                }
                if (envio.equals("7")) {

                    request.getRequestDispatcher("/buscarUsuario.jsp").forward(request, response);
                }
                if (envio.equals("8")) {
                    ListString listaPlataforma = sis.listarPlataforma();
                    List<String> listaPla = listaPlataforma.getLista();
                    request.setAttribute("listaPlataforma", listaPla);

                    //Listas vacias para que la primera vez que entramos al jsp
                    List<String> listaEspectaculo = new ArrayList();
                    request.setAttribute("listaEspectaculo", listaEspectaculo);

                    List<String> listaArtista = new ArrayList();
                    request.setAttribute("listaArtista", listaArtista);

                    request.getRequestDispatcher("/altaFuncion.jsp").forward(request, response);
                }
                if (envio.equals("9")) {
                    ListString listaCategoria = sis.listarCategorias();
                    List<String> listaC = listaCategoria.getLista();
                    request.setAttribute("listaCategoria", listaC);
                    ListString listaPlataforma = sis.listarPlataforma();
                    List<String> listaPla = listaPlataforma.getLista();
                    request.setAttribute("listaPlataforma", listaPla);

                    //Listas vacias para que la primera vez que entramos al jsp
                    List<String> listaEspectaculo = new ArrayList();
                    request.setAttribute("listaEspectaculo", listaEspectaculo);

                    List<String> listaArtista = new ArrayList();
                    request.setAttribute("listaArtista", listaArtista);
                    List<String> listaFuncion = new ArrayList();
                    request.setAttribute("listaFuncion", listaFuncion);
                    
                    
                    request.getRequestDispatcher("/consultarFuncion.jsp").forward(request, response);
                }
                if(envio.equals("10")){
                    ListString listaEspectaculosAceptados = sis.listarEspectaculosArtista(user);
                    request.setAttribute("listaEspectaculosAceptados", listaEspectaculosAceptados.getLista());
                    request.getRequestDispatcher("/finalizarEspectaculo.jsp").forward(request, response);

                }
                if(envio.equals("11")){
                    ListString listaEspectaculo = sis.listarEspectaculosFinalizadosArtista(user);
                    List<String> listaE = listaEspectaculo.getLista();
                    List<String> lista = new ArrayList();
                    request.setAttribute("listaCategorias", lista);
                    request.setAttribute("listaPaquete", lista);
                    request.setAttribute("listaFuncione", lista);
                    request.setAttribute("listaEspectaculo", listaE);
                    request.getRequestDispatcher("/consultarEspectaculoFinalizado.jsp").forward(request, response);
                }
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
