package Servlets;


import Logica.Factory;
import Logica.ISistema;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;

public class crearPaqueteEspectaculo extends HttpServlet {

ISistema sis = Factory.crearSistema();
    int longitudBytes;
    FileInputStream fis;
    File img;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession(false);
        if (sesion != null) {
            String nick = sesion.getAttribute("nick").toString();
            Integer u = sis.tipoUsuario(nick);
            if (u == 2) {
                String nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("descripcion");
                String fechaI = request.getParameter("fechaI");
                String fechaF = request.getParameter("fechaF");
                String precio = request.getParameter("precio");
                String descuento = request.getParameter("descuento");
                String img = request.getParameter("imagen");
                double p = Double.parseDouble(precio);
                double d = Double.parseDouble(descuento);

            String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); 
        Date fecha = new Date(); 
        String fechaA = simpleDateFormat.format(fecha);

               

                longitudBytes = img.length();
                if (!sis.existePaquete(nombre)) {
                    sis.confirmarCrearPaquete(nombre, descripcion, fechaI, fechaF, fechaA, p, d, img);
                    request.getRequestDispatcher("/exito.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("/errorpermiso.jsp").forward(request, response);
            }
        }
        else{
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
