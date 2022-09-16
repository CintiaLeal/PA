<%-- 
    Document   : comprarPaquete
    Created on : 11/10/2021, 06:35:38 PM
    Author     : romil
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Comprar Paquetes</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    </head>

    <style>
        #logo{
            background-color: rgba(130, 172, 159, .51);
            width: 200px;
            text-align: center;
            color: #603B54;
            border-radius: 20px;
        }
        h1{
            font-size: 32px;
        }
        button{
            width: 500px;
        }
        .nickName{
            border-radius: 25px;
            background-color: #82AC9F;
        }

        .btn{
            /* height: 50px; */
            width: 150px;
            background-color: #82AC9F;
        }
        #cancelar{
            background-color: rgba(96, 59, 84, .51);
        }
        .fondo{

        }
    </style>
    <body>
        <div id="logo" class="p-2 m-4">
            <a href="menuEspectador.jsp"><b>CoronaTickets.uy</b> </a>
        </div>
        <form action ="buscador" method= "post" id="buscador" class="d-flex flex-column align-items-center">
            <div class="col-11 row my-1 ">
                <div class="col-3 d-flex flex-column">
                    <input type="text" name="valor" id="valor" class="input-group-text"/>
                </div>
                <div class="col-3 d-flex flex-column">
                    <button type="submit"  style="width: 300px;text-align: center;border-radius: 10px; background-color: rgba(130, 172, 159, .51);" class=""><b>Buscar</b></button>
                </div>           
            </div>
        </form>
        <form id = "form" action="comprarPaquete">
            <div class="row m-0 d-flex justify-content-center">
                <div class="col-12 d-flex justify-content-center">
                    <h1><b>Paquetes disponibles: </b><h1>
                            </div>
                            <div class="col-12 d-flex justify-content-center">
                                <select name = "select" id="select" class="col-6 input-group-text" >
                                    <%  List<String> listaP = (List<String>) request.getAttribute("listaPaquetes");%>
                                    <% for (Integer c = 0; c < listaP.size(); c++) {%>
                                    <option value="<%=listaP.get(c)%>">
                                        <%=listaP.get(c)%>
                                    </option>
                                    <% } //Cerrar FOR %>
                                </select>
                            </div>
                            <div class="mt-3 col-12 d-flex justify-content-center">
                                <button type="submit" class="btn mr-3">Aceptar</button>
                                <button id="cancelar" class="btn ml-3">Cancelar</button>
                            </div>
                            </div>
                            </form>
                            </body>

                            <script type="text/javascript">
                                let form = document.getElementById("form");
                                form.addEventListener("submit", e => {
                                    e.preventDefault();
                                    form.submit();
                                });
                            </script>
                            </html>
