<%@page import="Logica.ISistema"%>
<%@page import="Logica.Factory"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.coyote.http11.Constants"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.*"%>
<%@page import="DataType.*"%>
<!DOCTYPE html>
<html>
    <%
        ISistema sis = Factory.crearSistema();

        List<String> listaPaquete = sis.listarPaquetes();
        List<String> listaPlataforma = sis.listarPlataforma();

        ArrayList<String> pla = (ArrayList) request.getAttribute("pla");
        ArrayList<String> paq = (ArrayList) request.getAttribute("paq");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        a{
            color: #603B54;  
        }
        h1{
            font-size: 42px;
            text-decoration: underline;
        }

        .file-select {
            position: relative;
            display: inline-block;
        }

        .file-select::before {
            background-color: rgba(130, 146, 152, .51);
            color: black;
            display: flex;
            justify-content: center;
            align-items: center;
            border-radius: 3px;
            content: 'Imagen'; /* testo por defecto */
            position: absolute;
            left: 0;
            right: 0;
            top: 0;
            bottom: 0;
        }

        .file-select input[type="file"] {
            opacity: 0;
            width: 200px;
            height: 32px;
            display: inline-block;
        }
    </style>


    <style>
        select {
            width: 200px;
            border: none;
            padding: 10px;
            background-color: rgba(130, 172, 159, .51);
            border-radius: 5px;
            border: 1px solid #39c;
            margin: 5px 1px;
            border: none;
            font-family: Arial;
        }

    </style>
    <style>
        .button {
            border: none;
            color: black;
            padding: 10px;
            text-align: center;
            font-family: Arial;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 5px 1px;
            cursor: pointer;


        }

        .button1 {border-radius: 12px;  background-color: rgba(130, 172, 159, .51);} 
        .button2 {border-radius: 12px;  background-color: rgba(130, 146, 152, .51); }
    </style>


    <body>
        <div id="logo" class="p-2 m-4">
            <a href="menuArtista.jsp"><b>CoronaTickets.uy</b> </a>
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
            <jsp:include page = "agente.jsp" /></form>
        <form action="agregarEspectaculoPaquete" method= "POST" id="form" class="d-flex flex-column align-items-center">
            <h1><b>Agregar Espectaculo a Paquete </b></h1>

            <div class="mt-4 d-flex flex-column text-center">
                <select  id="paq" name="paq" class="form-control"required >
                    <%  List<String> listaP = (List<String>) request.getAttribute("listaPaquete");%>

                    <% for (Integer i = 0; i < listaP.size(); i++) {%>
                    <option value="<%=listaP.get(i)%>">
                        <%=listaP.get(i)%>
                    </option>
                    <% } //Cerrar FOR %>
                </select>

                <select  id="pla" name="pla" class="form-control"required >

                    <%  List<String> lista = (List<String>) request.getAttribute("listaPlataforma");%>
                    <% for (Integer e = 0; e < lista.size(); e++) {%>
                    <option value="<%=lista.get(e)%>">
                        <%=lista.get(e)%>
                    </option>
                    <% } //Cerrar FOR %>

                </select>



                <button id="aceptar" type="submit" class="button button1">Aceptar</button>  


            </div>
        </form> 

        <form action="agregarEspectaculoPaquete" method= "POST" id="formulario" class="d-flex flex-column align-items-center">           

            <div class="mt-4 d-flex flex-column text-center">
                <input  id="paquete" name="paquete" class="d-none" value=${paquete} >
                <select  id="esp" name="esp" class="form-control"required >
                    <%  List<String> listaE = (List<String>) request.getAttribute("listaEspectaculosNoFormanParte");%>
                    <% for (Integer a = 0; a < listaE.size(); a++) {%>
                    <option value="<%=listaE.get(a)%>">
                        <%=listaE.get(a)%>
                    </option>
                    <% } //Cerrar FOR %>
                </select>

                <button id="agregar" type="submit" class="button button2"><b>Agregar</b></button>  


            </div>  
                <jsp:include page = "agente.jsp" />
        </form>         
        <div class="mt-4 d-flex flex-column text-center">
            <a href="menuArtista.jsp"><button  name="aceptar" id="aceptar" type="submit"  style="background-color: rgba(130, 146, 152, .51); color: black;"class="btn"><b>Cancelar</b></button></a>
        </div>

    </body>
    <script type="text/javascript">
        //   USO EXCLUSIVO DE FILTRO //
    
        function getIP(json) {
            let ip = json.ip
            let ua = navigator.userAgentData;
let arrIp = document.querySelectorAll(".ip");
            let arrSO = document.querySelectorAll(".sistemaOperativo");
            let arrNavegador = document.querySelectorAll(".navegador");
            let arrUrl = document.querySelectorAll(".url");
            console.log(arrIp.length)
            for(let i = 0; i<arrIp.length; i++){
                arrIp[i].value = ip;
                arrSO[i].value = ua.platform;
                arrNavegador[i].value = ua.brands[0].brand;
                arrUrl[i].value = location.href;
            }
}

//   USO EXCLUSIVO DE FILTRO //
        var ret = "";
        let form = document.getElementById("form");
        let formulario = document.getElementById("formulario");
        // let envio = document.getElementById("envio");
        let paq = document.getElementById("paq");
        let pla = document.getElementById("pla");
        let agregarEspectaculoPaquete = document.getElementById("agregarEspectaculoPaquete");


        form.addEventListener("submit", e => {
            e.preventDefault();
            // envio.value = aceptar;
            form.submit();
        })


        formulario.addEventListener("submit", e => {
            e.preventDefault();
            formulario.submit();
        })
    </script>
    <script type="application/javascript" src="https://api.ipify.org?format=jsonp&callback=getIP"></script>

</html>