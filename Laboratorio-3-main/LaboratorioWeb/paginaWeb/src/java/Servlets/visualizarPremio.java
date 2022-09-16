package Servlets;

import DataType.*;
import Logica.Factory;
import Logica.ISistema;
import Logica.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class visualizarPremio extends HttpServlet {

    ISistema sis = Factory.crearSistema();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, ParseException, DocumentException, FileNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession(false);
        String nick = sesion.getAttribute("nick").toString();
        String envio = request.getParameter("envio");

        if (envio.equals("1")) {
            if (nick != null || !nick.equals("")) {
                Integer tipo = sis.tipoUsuario(nick);
                if (tipo == 1) {
                    String premio = request.getParameter("premios");
                    DTEspectador e = sis.buscarEspectador(nick);
                    Premio p = e.buscarPremio(premio);

                    if (p != null) {
                        request.setAttribute("fechaSorteo", p.getFecha());
                        request.setAttribute("funcion", p.getFuncion().getNombre());
                        request.setAttribute("espectaculo", p.getEspectaculo().getNombre());
                        List<String> lista = new ArrayList();
                        lista.add(premio);
                        request.setAttribute("premios", lista);
                        request.setAttribute("desc", p.getDescripcion());
                        request.getRequestDispatcher("/visualizarPremio.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("/nopremios.jsp").forward(request, response);
                    }
                } else {
                    request.getRequestDispatcher("/errorpermiso.jsp").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("/errorpermiso.jsp").forward(request, response);
            }
        }

        if (envio.equals("2")) {            
            String premio = request.getParameter("premios");
            //String nick = request.getParameter("nick");
            DTEspectador e = sis.buscarEspectador(nick);
            sis.crearPDF(nick, premio);
            request.getRequestDispatcher("/exito.jsp").forward(request, response);
    }
    }
    
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        try {
            processRequest(request, response);

        } catch (ParseException ex) {
            Logger.getLogger(AltaArtista.class
                    .getName()).log(Level.SEVERE, null, ex);
        
        } catch (DocumentException ex) {
            Logger.getLogger(visualizarPremio.class.getName()).log(Level.SEVERE, null, ex);
        }
//        catch (DocumentException_Exception ex) {
//            Logger.getLogger(visualizarPremio.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (FileNotFoundException_Exception ex) {
//            Logger.getLogger(visualizarPremio.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
            Logger.getLogger(AltaArtista.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(visualizarPremio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(visualizarPremio.class.getName()).log(Level.SEVERE, null, ex);
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
