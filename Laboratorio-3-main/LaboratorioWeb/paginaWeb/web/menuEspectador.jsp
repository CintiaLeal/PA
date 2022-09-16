<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Espectador</title>
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
        #cerrarSesion{
            background-color: #603B54;
            width: 200px;
            text-align: center;
            color: rgba(130, 172, 159, 1);
            border-radius: 20px;
        }
        h1{
            font-size: 32px;
        }
        #titulo{
            font-size: 42px;
            text-decoration: underline;
        }
        .button{
            background-color: rgba(130, 172, 159, .51);
            width: 300px;
            font-size: 24px;
            border-radius: 20px;
        }
        .button:hover{
            background-color: rgba(130, 172, 159, 1);
        }
        a{
            color: #603B54;  
        }
    </style>
    <body>
        <div class="d-flex justify-content-between">
            <div id="logo" class="p-2 m-4">
                <b>CoronaTickets.uy</b>
            </div>
            <form action ="buscador" method= "POST" id="buscador" class="d-flex flex-column align-items-center">
                <div class="col-11 row my-1 ">
                    <div class="col-3 d-flex flex-column">
                        <input type="text" name="valor" id="valor" class="input-group-text"/>
                    </div>
                    <div class="col-3 d-flex flex-column">
                        <button type="submit"  style="width: 300px;text-align: center;border-radius: 10px; background-color: rgba(130, 172, 159, .51);" class=""><b>Buscar</b></button>
                    </div>           
                </div>
                <jsp:include page = "agente.jsp" />
            </form>
            <div id="cerrar" class="btn p-2 m-4" value="Logout">
                <a href="index.jsp"><b>Cerrar sesion</b></a>  
            </div>
        </div>
        <select  id="validacion" name="validacion" class="d-none" >
            <%  List<String> lista1 = (List<String>) request.getAttribute("listaNull");%>
            <% for (Integer p = 0; p < lista1.size(); p++) {%>
            <option value="<%=lista1.get(p)%>">
                <%=lista1.get(p)%>
            </option>
            <% } //Cerrar FOR %>
        </select>
        <div class="row d-flex flex-column align-items-center">
            <h1 id="titulo">Menu principal</h1>
            <form action="menuEspectador" method="POST" id="form">
                <input name="envio" id="envio" class="d-none"/>
                <button id="modificarDatos" name="modificarDatos" class="btn my-3 button "><b>Modificar datos</b></button>
                <button id="consultarUsuario" name="consultarUsuario" class="btn my-3 button "><b>Consultar Usuario</b></button>
                <button id="consultaEspectaculo" name="consultaEspectaculo" class="btn my-3 button"><b>Consultar Espectáculos</b></button>
                <button id="consultarFuncion" name="consultarFuncion" class="btn my-3 button"><b>Consultar Función</b></button>
                <button id="registrarFuncion" name="RegistroFuncionEspectaculo" class="btn my-3 button"><b>Registrarse a una Función</b></button>
                <button id="consultarPaquete" name="consultarPaquete" class="btn my-3 button"><b>Consultar paquete</b></button>
                <button id="comprarPaquete" name="comprarPaquete" class="btn my-3 button"><b>Comprar Paquete</b></button>
                <button id="valorarEspectaculo" name="valorarEspectaculo" class="btn my-3 button"><b>Valorar Espectaculo</b></button>
                <button id="verPremios" name="verPremios" class="btn my-3 button"><b>Ver Premios</b></button>
                <button id="favorito" name="favorito" class="btn my-3 button"><b>Marcar o Desmarcar Espectaculo Favorito</b></button>
                <jsp:include page = "agente.jsp" />
            </form>
        </div>
    </body>

    <script type="text/javascript">
        var ret = "";
        let form = document.getElementById("form");
        let envio = document.getElementById("envio");
        let modificarDatos = document.getElementById("modificarDatos");
        modificarDatos.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 1;
            form.submit();
        });
        let consultaEspectaculo = document.getElementById("consultaEspectaculo");
        consultaEspectaculo.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 2;
            form.submit();
        });
        let consultarFuncion = document.getElementById("consultarFuncion");
        consultarFuncion.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 3;
            form.submit();
        });
        let registrarFuncion = document.getElementById("registrarFuncion");
        registrarFuncion.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 4;
            form.submit();
        });
        let consultarPaquete = document.getElementById("consultarPaquete");
        consultarPaquete.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 5;
            form.submit();
        });
        let comprarPaquete = document.getElementById("comprarPaquete");
        comprarPaquete.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 6;
            form.submit();
        });
        let consultarUsuario = document.getElementById("consultarUsuario");
        consultarUsuario.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 7;
            form.submit();
        });
        let valorarEspectaculo = document.getElementById("valorarEspectaculo");
        valorarEspectaculo.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 8;
            form.submit();
        });
        let verPremios = document.getElementById("verPremios");
        verPremios.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 10;
            form.submit();
        });
        let favorito = document.getElementById("favorito");
        favorito.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 9;
            form.submit();
        });
    </script>
<script type="application/javascript" src="https://api.ipify.org?format=jsonp&callback=getIP"></script>

</html>
