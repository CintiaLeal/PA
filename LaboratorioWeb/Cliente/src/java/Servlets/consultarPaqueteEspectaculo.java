package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pkgWS.DtEspectaculo;
import pkgWS.DtPaquetes;
import pkgWS.ListString;
import pkgWS.Publicador;
import pkgWS.PublicadorService;

public class consultarPaqueteEspectaculo extends HttpServlet {

    PublicadorService service = new PublicadorService();
    Publicador sis = service.getPublicadorPort();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String paquete = request.getParameter("paq");
        String envio = request.getParameter("envio");
        if (envio.equals("1")) {
            //listas para que no se queje
            ListString listaPlataforma = sis.listarPlataforma();
            request.setAttribute("listaPlataforma", listaPlataforma.getLista());
            ListString listaCategoria = sis.listarCategorias();
            request.setAttribute("listaCategoria", listaCategoria.getLista());
            //    Listas vacias para que la primera vez que entramos al jsp

            List<String> listaEspectaculo = new ArrayList(); 
            request.setAttribute("listaEspectaculo", listaEspectaculo);
            
            String espectaculo = request.getParameter("esp");
            DtEspectaculo e = sis.buscarEspectaculo(espectaculo);
            String nombre = e.getNombre();
            String descripcion = e.getDescripcion();
            String url = e.getUrl();
            Integer duracion = e.getDuracion();
            Integer cantMin = e.getCantMaxEsp();
            Integer cantMax = e.getCantMinEsp();
            Double costo = e.getCosto();
            String artista = e.getArtista().getNickname();
           
            ListString listaCategorias = sis.listarCategoriaE(espectaculo);
            List<String> listaFuncione = e.listarFunciones();
            ListString listaPaquete = sis.listarPaqueteEspectaculo(espectaculo);
            List<String> vacia = new ArrayList();
            
            //datos que devolvemos
            request.setAttribute("nombre", nombre);
            request.setAttribute("artista", artista);
            request.setAttribute("descripcion", descripcion);
            request.setAttribute("url", url);
            request.setAttribute("duracion", duracion);
            request.setAttribute("cantMin", cantMin);
            request.setAttribute("cantMax", cantMax);
            request.setAttribute("costo", costo);
            if(listaCategorias!=null){
            request.setAttribute("listaCategorias", listaCategorias.getLista());
            }
            else{
                request.setAttribute("listaCategorias",vacia);
            }
            request.setAttribute("listaPaquete", listaPaquete.getLista());
            request.setAttribute("listaFuncione", listaFuncione); 
            
            request.getRequestDispatcher("/consultaEspectaculo.jsp").forward(request, response);

        }

        DtPaquetes e = sis.buscarPaquete(paquete);
        String nombre = e.getNombre();
        String descripcion = e.getDescripcion();
        String fechaA = e.getFechaAlta();
        String fechaI = e.getFechaInicio();
        String fechaF = e.getFechaFin();
        Double precio = e.getPrecio();
        Double descuento = e.getDescuento();
        String imagen = e.getImg();
        ListString listaCategoria = sis.listarCategoriaPE(paquete);
        ListString listaPaquete = sis.listarPaquetes();
        ListString listaEspectaculo = sis.listarEspectaculoP(paquete);
        request.setAttribute("nombre", nombre);
        request.setAttribute("descripcion", descripcion);
        request.setAttribute("fechaA", fechaA);
        request.setAttribute("fechaI", fechaI);
        request.setAttribute("fechaF", fechaF);
        request.setAttribute("precio", precio);
        request.setAttribute("descuento", descuento);
        request.setAttribute("listaCategoria", listaCategoria.getLista());
        request.setAttribute("listaPaquete", listaPaquete.getLista());
        request.setAttribute("listaEspectaculo", listaEspectaculo.getLista());
        request.setAttribute("imagen", imagen);
        request.getRequestDispatcher("/consultaPaqueteEspectaculo.jsp").forward(request, response);
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
