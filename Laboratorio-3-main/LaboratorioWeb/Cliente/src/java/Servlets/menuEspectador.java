package Servlets;


import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pkgWS.DtEspectador;
import pkgWS.ListString;
import pkgWS.ParseException_Exception;
import pkgWS.Publicador;
import pkgWS.PublicadorService;

public class menuEspectador extends HttpServlet {

PublicadorService service = new PublicadorService();
Publicador sis = service.getPublicadorPort();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, ParseException_Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession(false);
        if (sesion != null) {
            String user = sesion.getAttribute("nick").toString();
            Integer u = sis.tipoUsuario(user);
            if (u == 1) {
                String envio = request.getParameter("envio");
                if (envio.equals("1")) {
                    List<String> listaNull = new ArrayList();
                    request.setAttribute("listaNull", listaNull);
                    request.getRequestDispatcher("modificarEspectador.jsp").forward(request, response);
                }
                if (envio.equals("2")) {

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
                if (envio.equals("3")) {
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
                if (envio.equals("4")) {
                    ListString listaCategoria = sis.listarCategorias();
                    List<String> listaC = listaCategoria.getLista();
                    request.setAttribute("listaCategoria", listaC);
                    ListString listaPlataforma = sis.listarPlataforma();
                    List<String> listaPla = listaPlataforma.getLista();
                    request.setAttribute("listaPlataforma", listaPla);
                    //Listas vacias

                    List<String> listaFuncion = new ArrayList();
                    request.setAttribute("listaFuncion", listaFuncion);

                    List<String> listaEspectaculo = new ArrayList();
                    request.setAttribute("listaEspectaculo", listaEspectaculo);

                    List<String> listaPaquete = new ArrayList();
                    request.setAttribute("listaPaquete", listaPaquete);

                    List<String> listaRegistro = new ArrayList();
                    request.setAttribute("listaRegistro", listaRegistro);

                    request.getRequestDispatcher("/registroFuncion.jsp").forward(request, response);
                }
                if (envio.equals("5")) {
                    ListString listaPaquete = sis.listarPaquetes();
                    List<String> listaPaq = listaPaquete.getLista();
                    request.setAttribute("listaPaquete", listaPaq);

                    List<String> listaCategoria = new ArrayList();
                    request.setAttribute("listaCategoria", listaCategoria);

                    List<String> listaEspectaculo = new ArrayList();
                    request.setAttribute("listaEspectaculo", listaEspectaculo);

                    request.getRequestDispatcher("consultaPaqueteEspectaculo.jsp").forward(request, response);
                }
                if (envio.equals("6")) {
                    String nick = (String) sesion.getAttribute("nick");
                    DtEspectador e = sis.buscarEspectador(nick);
                    ListString listaPaquetes = sis.paquetesNoComprados(nick);
                    List<String> listaPaq = listaPaquetes.getLista();
                    request.setAttribute("listaPaquetes", listaPaq);
                    request.getRequestDispatcher("/comprarPaquete.jsp").forward(request, response);
                }
                if (envio.equals("7")) {
                    request.getRequestDispatcher("/buscarUsuario.jsp").forward(request, response);
                }
                if(envio.equals("8")){
                    String nick = (String) sesion.getAttribute("nick");
                    DtEspectador e = sis.buscarEspectador(nick);
                    List<String> premios = e.listarPremios();
                    request.setAttribute("premios", premios);
                    request.getRequestDispatcher("/visualizarPremio.jsp").forward(request, response);
                }
                if(envio.equals("9")){
                    ListString listaE = sis.listarTodosEspectaculosAceptados();
                    List<String> listaEspectaculos = listaE.getLista();
                    request.setAttribute("listaEspectaculos", listaEspectaculos);
                    request.setAttribute("btn", "...");
                    request.getRequestDispatcher("/espectaculoFavorito.jsp").forward(request, response);
                }
                if(envio.equals("10")){
                    ListString lista = sis.listarEspectaculosValoracion(user);
                    List<String> listaE = lista.getLista();
                    request.setAttribute("listaEspectaculos", listaE);
                    request.setAttribute("btn", "...");
                    request.getRequestDispatcher("/valorarEspectaculo.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(menuEspectador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException_Exception ex) {
        Logger.getLogger(menuEspectador.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(menuEspectador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException_Exception ex) {
        Logger.getLogger(menuEspectador.class.getName()).log(Level.SEVERE, null, ex);
    }
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
