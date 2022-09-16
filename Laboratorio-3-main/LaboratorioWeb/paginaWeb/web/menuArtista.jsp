<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Menu Artista</title>
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
            <form action="cerrarSesion" id="cerrar">
                <jsp:include page = "agente.jsp" />
                <button type="submit" id="cerrarSesion" class="btn p-2 m-4" value="Logout">
                    <b>Cerrar sesion</b>
                </button>
            </form>
        </div>
        <select  id="paq" name="paq" class="d-none" >
            <%  List<String> lista = (List<String>) request.getAttribute("listaNull");%>
            <% for (Integer p = 0; p < lista.size(); p++) {%>
            <option value="<%=lista.get(p)%>">
                <%=lista.get(p)%>
            </option>
            <% } //Cerrar FOR %>
        </select>
        <div class="row d-flex flex-column align-items-center">
            <h1 id="titulo">Menu principal</h1>
            <form action="menuArtista" method="POST" id="formulario">
                <input name="envio" id="envio" class="d-none"/>
                <button id="modificarArtista" name="modificarArtista"  class="btn my-3 button"><b>Modificar Datos</b></button></a>
                <button class="btn my-3 button" id="consultarUsuario" name="consultarUsuario"><b>Consultar Usuario</b></button>
                <button id="crearEspectaculo" name="crearEspectaculo"  class="btn my-3 button"><b>Crear espectaculo</b></button>
                <button id="consultaEspectaculo" name="consultaEspectaculo" class="btn my-3 button"><b>Consultar espectaculo</b></button>
                <button id="crearFuncion" name="crearFuncion" class="btn my-3 button"><b>Crear funcion</b></button>
                <button id="consultarFuncion" name="consultarFuncion" class="btn my-3 button"><b>Consultar funcion</b></button>
                <button id="crearPaqueteEspectaculo" name="crearPaqueteEspectaculo"  class="btn my-3 button"> <b>Crear paquete</b></button></a>
                <button id="consultaPaqueteEspectaculo" name="consultaPaqueteEspectaculo"  class="btn my-3 button"><b>Consultar paquete</b></button>
                <button id="agregarEspectaculoPaquete" name="agregarEspectaculoPaquete" class="btn my-3 button"><b>Agregar espectaculo a paquete</b></button>
                <button id="finalizarEspectaculo" name="finalizarEspectaculo" class="btn my-3 button"><b>Finalizar Espectaculo</b></button>
                <button id="consultaEspectaculoFinalizado" name="consultaEspectaculoFinalizado" class="btn my-3 button"><b>Consulta Espectaculo Finalizado</b></button>
                <jsp:include page = "agente.jsp" />
            </form>
        </div>
    </body>

    <script type="text/javascript">
        let form = document.getElementById("cerrar");
        form.addEventListener('submit', (e) => {
            form.submit();
        })

        var ret = "";
        let formulario = document.getElementById("formulario");
        let envio = document.getElementById("envio");

        let consultaPaqueteEspectaculo = document.getElementById("consultaPaqueteEspectaculo");
        consultaPaqueteEspectaculo.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 1;
            formulario.submit();
        })

        let agregarEspectaculoPaquete = document.getElementById("agregarEspectaculoPaquete");
        agregarEspectaculoPaquete.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 2;
            formulario.submit();
        })

        let crearPaqueteEspectaculo = document.getElementById("crearPaqueteEspectaculo");
        crearPaqueteEspectaculo.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 3;
            formulario.submit();
        })

        let modificarArtista = document.getElementById("modificarArtista");
        modificarArtista.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 4;
            formulario.submit();
        })

        let crearEspectaculo = document.getElementById("crearEspectaculo");
        crearEspectaculo.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 5;
            formulario.submit();
        })
        let consultaEspectaculo = document.getElementById("consultaEspectaculo");
        consultaEspectaculo.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 6;
            formulario.submit();
        })
        let consultarUsuario = document.getElementById("consultarUsuario");
        consultarUsuario.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 7;
            formulario.submit();
        })
        let crearFuncion = document.getElementById("crearFuncion");
        crearFuncion.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 8;
            formulario.submit();
        })


        let consultarFuncion = document.getElementById("consultarFuncion");
        consultarFuncion.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 9;
            formulario.submit();
        });
        
        let finalizarEspectaculo = document.getElementById("finalizarEspectaculo");
        finalizarEspectaculo.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 10;
            formulario.submit();
        });
        
        let consultaEspectaculoFinalizado = document.getElementById("consultaEspectaculoFinalizado");
        consultaEspectaculoFinalizado.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 11;
            formulario.submit();
        });
        
        
    </script>
    <script type="application/javascript" src="https://api.ipify.org?format=jsonp&callback=getIP"></script>

</html>