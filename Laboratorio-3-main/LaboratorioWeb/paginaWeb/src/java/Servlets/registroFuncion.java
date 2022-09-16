/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DataType.DTEspectador;
import DataType.DTFunciones;
import DataType.DtEspectaculo;
import DataType.ListString;
import Logica.Espectaculo;
import Logica.Espectador;
import Logica.Factory;
import Logica.Funciones;
import Logica.ISistema;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class registroFuncion extends HttpServlet {

ISistema sis = Factory.crearSistema();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(false);
        if (sesion != null) {
            String user = sesion.getAttribute("nick").toString();
            Integer u = sis.tipoUsuario(user);
            if (u == 1) {
                Boolean si;
                String envio = request.getParameter("envio");
                String plataforma = request.getParameter("pl");
                String categoria = request.getParameter("cate");
                String espectaculo = request.getParameter("esp");
                String funcion = request.getParameter("fun");
                String arr = request.getParameter("enviarArr");
                String auxpaquete = request.getParameter("auxpaquete");
                if (envio.equals("1")) {
                    List<String> listaCategoria = sis.listarCategorias();
                    //List<String> listaC = listaCategoria.getLista();
                    request.setAttribute("listaCategoria", listaCategoria);
                    
                    List<String> listaPlataforma = sis.listarPlataforma();
                    //List<String> listaPla = listaPlataforma.getLista();
                    request.setAttribute("listaPlataforma", listaPlataforma);

                    List<String> listaEspectaculo = sis.listarEspectaculo(plataforma);
                    //List<String> listaE = listaEspectaculo.getLista();
                    request.setAttribute("listaEspectaculo", listaEspectaculo);
                    //Listas vacias
                    List<String> listaFuncion = new ArrayList();
                    request.setAttribute("listaFuncion", listaFuncion);

                    List<String> listaPaquete = new ArrayList();
                    request.setAttribute("listaPaquete", listaPaquete);

                    List<String> listaRegistro = new ArrayList();
                    request.setAttribute("listaRegistro", listaRegistro);

                    request.getRequestDispatcher("/registroFuncion.jsp").forward(request, response);
                }
                else if (envio.equals("2")) {
                    //Listas vacias
                    List<String> listaC = sis.listarCategorias();
                    //List<String> listaC = listaCategoria.getLista();
                    request.setAttribute("listaCategoria", listaC);
                    
                    List<String> listaPla = sis.listarPlataforma();
                    //List<String> listaPla = listaPlataforma.getLista();
                    request.setAttribute("listaPlataforma", listaPla);

                    List<String> listaFuncion = new ArrayList();
                    request.setAttribute("listaFuncion", listaFuncion);

                    List<String> listaPaquete = new ArrayList();
                    request.setAttribute("listaPaquete", listaPaquete);

                    List<String> listaRegistro = new ArrayList();
                    request.setAttribute("listaRegistro", listaRegistro);

                    List<String> listaE = sis.listarEspectaculoCategoria(categoria);
                    //List<String> listaE = listaEspectaculo.getLista();
                    request.setAttribute("listaEspectaculo", listaE);

                    request.getRequestDispatcher("/registroFuncion.jsp").forward(request, response);
                }
                else if (envio.equals("3")) {
                    HttpSession ses = request.getSession();
                    String nick = (String) ses.getAttribute("nick");
                    DtEspectaculo aux = sis.buscarEspectaculo(request.getParameter("esp"));
                    String pattern = "yyyy-MM-dd";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                    Date f = new Date();
                    String fecha = simpleDateFormat.format(f);
                    arr = request.getParameter("enviarArr");
                    auxpaquete = request.getParameter("auxpaquete");
                    Funciones fun = sis.buscarFunciones(funcion);
                    if (arr.length() == 0 && auxpaquete.length() == 0) {
                        si = sis.estarRegistrado(nick, funcion);
                        if (si) {
                            request.getRequestDispatcher("/error.jsp").forward(request, response);
                        }
                        
                        sis.registrarEspectador(fecha, nick, funcion, null, aux.getCosto(), null);
                        si = sis.estarRegistrado(nick, funcion);
                        if (si) {
                            request.getRequestDispatcher("/exito.jsp").forward(request, response);
                        }
                        else{
                            //deberia entrar
                            request.getRequestDispatcher("/500.jsp").forward(request, response);
                        }

                    } else if (!auxpaquete.equals("")) {
                        si = sis.estarRegistrado(nick, funcion);
                        if (si) {
                            request.getRequestDispatcher("/error.jsp").forward(request, response);
                        }
                        sis.registrarEspectador(fecha, nick, funcion, null, aux.getCosto(), auxpaquete);
                        si = sis.estarRegistrado(nick, funcion);
                        if (si) {
                            request.getRequestDispatcher("/exito.jsp").forward(request, response);
                        }
                    } else if (!arr.equals("")) {
                        char[] cat = arr.toCharArray();
                        String auxiliar = "";
                        List<String> resultado = new ArrayList();

                        for (int i = 0; i < cat.length; i++) {
                            if (cat[i] == ',') {
                                resultado.add(auxiliar);
                                auxiliar = "";
                            } else {
                                auxiliar += cat[i];
                            }
                        }
                        resultado.add(auxiliar);
                        si = sis.estarRegistrado(nick, funcion);
                        if (si) {
                            request.getRequestDispatcher("/error.jsp").forward(request, response);
                        }
                        ListString resultado1 = new ListString(resultado);
                        sis.registrarEspectador(fecha, nick, funcion, resultado1, aux.getCosto(), null);
                        si = sis.estarRegistrado(nick, funcion);
                        if (si) {
                            request.getRequestDispatcher("/exito.jsp").forward(request, response);
                        }
                    }
                }
                else if (envio.equals("4")) {

                    List<String> listaC = sis.listarCategorias();
                    //List<String> listaC = listaCategoria.getLista();
                    request.setAttribute("listaCategoria", listaC);
                    List<String> listaPla = sis.listarPlataforma();
                    //List<String> listaPla = listaPlataforma.getLista();
                    request.setAttribute("listaPlataforma", listaPla);
                    
                    request.setAttribute("espectaculo", espectaculo);
                    DtEspectaculo e = sis.buscarEspectaculo(espectaculo);
                    List<String> list = new ArrayList();
                    list.add(espectaculo);
                    request.setAttribute("listaEspectaculo", list);

                    List<String> listaFuncion = e.listarFunciones();
                    request.setAttribute("listaFuncion", listaFuncion);

                    HttpSession ses = request.getSession();
                    String nick = (String) ses.getAttribute("nick");
                    DTEspectador esp = sis.buscarEspectador(nick);
                    List<String> listaPaquete = esp.listarPaquetes();
                    request.setAttribute("listaPaquete", listaPaquete);

                    String espectador = (String) sesion.getAttribute("nick");

                    List<String> listaR = sis.listarRegistros(espectador);
                    //List<String> listaR = listaRegistro.getLista();
                    request.setAttribute("listaRegistro", listaR);

                    request.getRequestDispatcher("/registroFuncion.jsp").forward(request, response);

                }
            } else {
                request.getRequestDispatcher("/errorpermiso.jsp").forward(request, response);
            }
        } else {
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
