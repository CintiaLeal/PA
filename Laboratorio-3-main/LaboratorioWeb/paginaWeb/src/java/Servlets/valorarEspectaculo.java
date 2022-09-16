package Servlets;

import DataType.DtEspectaculo;
import DataType.DtPuntaje;
import DataType.ListPuntaje;
import Logica.Factory;
import Logica.ISistema;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class valorarEspectaculo extends HttpServlet {

    ISistema sis = Factory.crearSistema();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession(false);
        if (sesion != null) {
            String nick = sesion.getAttribute("nick").toString();
            if (nick != null && !nick.equals("")) {
                Integer tipo = sis.tipoUsuario(nick);
                if (tipo == 1) {
                    String envio = request.getParameter("envio");
                    if (envio.equals("1")) {
                        String esp = request.getParameter("espectaculos");
                        List<String> lista = new ArrayList();
                        lista.add(esp);
                        request.setAttribute("listaEspectaculos", lista);
                        if (sis.estaValorado(esp, nick)) {
                            DtEspectaculo e = sis.buscarEspectaculo(esp);
                            ListPuntaje pun = e.getPuntajes();
                            List<DtPuntaje> punt = pun.getLista();
                            List<Integer> puntajes = sis.puntajeEspectaculo(esp);
                            float valore = 0;
                            float e1 = 0;
                            float e2 = 0;
                            float e3 = 0;
                            float e4 = 0;
                            float e5 = 0;
                            float puntU = 0;
                            if (puntajes.size() > 0) {
                                for (int i = 0; i < puntajes.size(); i++) {
                                    if(punt.get(i).getEspectador().getNickname().equals(nick)){
                                        puntU = punt.get(i).getPuntaje().floatValue();
                                    }
                                    if (puntajes.get(i) == 1) {
                                        e1++;
                                    } else if (puntajes.get(i) == 2) {
                                        e2++;
                                    } else if (puntajes.get(i) == 3) {
                                        e3++;
                                    } else if (puntajes.get(i) == 4) {
                                        e4++;
                                    } else if (puntajes.get(i) == 5) {
                                        e5++;
                                    }
                                }
                                valore = ((e5 * 5) + (e4 * 4) + (e3 * 3) + (e2 * 2) + (e1 * 1)) / (e5 + e4 + e3 + e2 + e1);
                            }
                            String str = new DecimalFormat("#.00").format(valore);
                            request.setAttribute("puntajeU", "Su puntaje: "+puntU);
                            request.setAttribute("puntajeP", str);
                            request.setAttribute("btn", "Ya ha sido valorado");
                        } else {
                            DtEspectaculo e = sis.buscarEspectaculo(esp);
                            ListPuntaje pun = e.getPuntajes();
                            List<DtPuntaje> punt = pun.getLista();
                            List<Integer> puntajes = sis.puntajeEspectaculo(esp);
                            float valore = 0;
                            float e1 = 0;
                            float e2 = 0;
                            float e3 = 0;
                            float e4 = 0;
                            float e5 = 0;
                            float puntU = 0;
                            if (puntajes.size() > 0) {
                                for (int i = 0; i < puntajes.size(); i++) {
                                    if(punt.get(i).getEspectador().getNickname().equals(nick)){
                                        puntU = punt.get(i).getPuntaje().floatValue();
                                    }
                                    if (puntajes.get(i) == 1) {
                                        e1++;
                                    } else if (puntajes.get(i) == 2) {
                                        e2++;
                                    } else if (puntajes.get(i) == 3) {
                                        e3++;
                                    } else if (puntajes.get(i) == 4) {
                                        e4++;
                                    } else if (puntajes.get(i) == 5) {
                                        e5++;
                                    }
                                }
                                valore = ((e5 * 5) + (e4 * 4) + (e3 * 3) + (e2 * 2) + (e1 * 1)) / (e5 + e4 + e3 + e2 + e1);
                            }
                            request.setAttribute("puntajeU", ""); 
                            String str = new DecimalFormat("#.00").format(valore);
                            request.setAttribute("puntajeP", str);
                            request.setAttribute("btn", "Valorar");
                        }
                        request.getRequestDispatcher("/valorarEspectaculo.jsp").forward(request, response);
                    }
                    if (envio.equals("2")) {
                        String esp = request.getParameter("espectaculos");
                        String boton = request.getParameter("valorbtn");
                        if (boton.equals("Valorar")) {
                            String p = request.getParameter("puntaje");
                            Integer punt = Integer.parseInt(p);
                            sis.valorarEspectaculo(esp, nick, punt);
                            if (sis.estaValorado(esp, nick)) {
                                request.getRequestDispatcher("/exito.jsp").forward(request, response);
                            } else {
                                request.getRequestDispatcher("/500.jsp").forward(request, response);
                            }
                        }
                        if (boton.equals("Ya ha sido valorado")) {
                            List<String> lista = new ArrayList();
                            lista.add(esp);
                            DtEspectaculo e = sis.buscarEspectaculo(esp);
                            ListPuntaje pun = e.getPuntajes();
                            List<DtPuntaje> punt = pun.getLista();
                            List<Integer> puntajes = sis.puntajeEspectaculo(esp);
                            float valore = 0;
                            float e1 = 0;
                            float e2 = 0;
                            float e3 = 0;
                            float e4 = 0;
                            float e5 = 0;
                            float puntU = 0;
                            if (puntajes.size() > 0) {
                                for (int i = 0; i < puntajes.size(); i++) {
                                    if(punt.get(i).getEspectador().getNickname().equals(nick)){
                                        puntU = punt.get(i).getPuntaje().floatValue();
                                    }
                                    if (puntajes.get(i) == 1) {
                                        e1++;
                                    } else if (puntajes.get(i) == 2) {
                                        e2++;
                                    } else if (puntajes.get(i) == 3) {
                                        e3++;
                                    } else if (puntajes.get(i) == 4) {
                                        e4++;
                                    } else if (puntajes.get(i) == 5) {
                                        e5++;
                                    }
                                }
                                valore = ((e5 * 5) + (e4 * 4) + (e3 * 3) + (e2 * 2) + (e1 * 1)) / (e5 + e4 + e3 + e2 + e1);
                            }
                            String str = new DecimalFormat("#.00").format(valore);
                            request.setAttribute("listaEspectaculos", lista);
                            request.setAttribute("btn", "Ya ha sido valorado");
                            request.setAttribute("puntajeU", "Su puntaje: "+puntU);
                            request.setAttribute("puntajeP", str);
                            request.getRequestDispatcher("/valorarEspectaculo.jsp").forward(request, response);
                        }
                    } else {
                        request.getRequestDispatcher("/500.jsp").forward(request, response);
                    }
                } else {
                    request.getRequestDispatcher("/errorpermiso.jsp").forward(request, response);
                }
            } else {
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
