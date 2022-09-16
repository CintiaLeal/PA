package Servlets;

import Logica.Factory;
import Logica.ISistema;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Alta_Espectador extends HttpServlet {
    
    int longitudBytes;
    FileInputStream fis;
    File img;
ISistema sis = Factory.crearSistema();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nombre = request.getParameter("nombre");
        String nick = request.getParameter("nick");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String fechaN = request.getParameter("fecha").toString();
        String password = request.getParameter("password");
        String img = request.getParameter("imagen");

//        File image = new File(img);
//        longitudBytes = img.length();
        if (!sis.existeEspectador(nick)) {
            sis.confirmarUsuario(nick, nombre, apellido, email, fechaN, password, img, "", "", "");
            request.getRequestDispatcher("/exito.jsp").forward(request, response);
        } 
        else {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}
