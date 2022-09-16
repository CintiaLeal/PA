package Servlets;


import DataType.DTEspectador;
import Logica.Artista;
import Logica.Factory;
import Logica.ISistema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class buscarUsuario extends HttpServlet {

ISistema sis = Factory.crearSistema();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nick = request.getParameter("nick");
        HttpSession sesion = request.getSession(false);
        if(sesion.getAttribute("nick") != null){
            String nick2 = (String) sesion.getAttribute("nick");
            Boolean relacion = sis.relacionUsuario(nick2, nick);
            Integer verificador = sis.tipoUsuario(nick2);
            if (relacion) {
                request.setAttribute("seguimiento", "Dejar de seguir");
            }
            else if(nick2.equals(nick)){
                request.setAttribute("seguimiento", "Yo");
            }
            else{
                request.setAttribute("seguimiento", "Seguir");
            }
        }     
        else{
            request.setAttribute("seguimiento", "Inicie sesion");
        }
        Integer tipo = sis.tipoUsuario(nick);
        if (tipo == 1) {
            DTEspectador e = sis.buscarEspectador(nick);
//            String nombre = e.getNombre();
//            String apellido = e.getApellido();
//            String email = e.getCorreoElectronico();
//            String fecha = e.getFechaNacimiento();
//            String imagen = e.getImg();
//            request.setAttribute("nick", nick);
//            request.setAttribute("nombre", nombre);
//            request.setAttribute("apellido", apellido);
//            request.setAttribute("email", email);
//            request.setAttribute("fecha", fecha);
//            request.setAttribute("imagen", imagen);
//
//            List<String> seguidos = e.listarSeguidos();
//            request.setAttribute("seguidos", seguidos);
//
//            List<String> seguidores = e.listarSeguidores();
//            request.setAttribute("seguidores", seguidores);
//
//            List<String> registros = e.listarRegistros();
//            request.setAttribute("registros", registros);

//            DTUsuario e = sis.buscarUsuario(nick);
            String nombre = e.getNombre();
            String apellido = e.getApellido();
            String email = e.getCorreoElectronico();
            String fecha = e.getFechaNacimiento();
            String imagen = e.getImg();
            request.setAttribute("nick", nick);
            request.setAttribute("nombre", nombre);
            request.setAttribute("apellido", apellido);
            request.setAttribute("email", email);
            request.setAttribute("fecha", fecha);
            request.setAttribute("imagen", imagen);
            List<String> vacia = new ArrayList();
            request.setAttribute("seguidos", e.listarSeguidos());
            request.setAttribute("seguidores", e.listarSeguidores());
            request.setAttribute("registros", e.listarRegistros());
            request.getRequestDispatcher("/consultarEspectador.jsp").forward(request, response);
        } else if (tipo == 2) {
            Artista e = sis.buscarArtista(nick);
            String nombre = e.getNombre();
            String apellido = e.getApellido();
            String email = e.getEmail();
            String fecha = e.getFechaNac();
            String bio = e.getBio();
            String desc = e.getDesc();
            String link = e.getLink();
            String imagen = e.getImg();
            request.setAttribute("nick", nick);
            request.setAttribute("nombre", nombre);
            request.setAttribute("apellido", apellido);
            request.setAttribute("email", email);
            request.setAttribute("fecha", fecha);
            request.setAttribute("biografia", bio);
            request.setAttribute("descripcion", desc);
            request.setAttribute("link", link);
            request.setAttribute("imagen", imagen);
            List<String> seguidos = e.listarSeguidos();
            request.setAttribute("seguidos", seguidos);

            List<String> seguidores = e.listarSeguidores();
            request.setAttribute("seguidores", seguidores);

            request.getRequestDispatcher("/consultarArtista.jsp").forward(request, response);
        }
        else if(tipo == 0){
            request.getRequestDispatcher("/404.jsp").forward(request, response);
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
