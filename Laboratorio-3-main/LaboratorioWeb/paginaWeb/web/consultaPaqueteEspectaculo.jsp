<%@page import="Logica.ISistema"%>
<%@page import="Logica.Factory"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <%
        ISistema sis = Factory.crearSistema();

        List<String> listaPaquete = sis.listarPaquetes();


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
        a{
            color: #603B54;  
        }
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
        <form action="consultarPaqueteEspectaculo" method= "POST" id="formulario" class="d-flex flex-column align-items-center">
            <jsp:include page = "agente.jsp" />
            <h1><b>Consultar Paquete Espectaculo</b></h1>
            <input id="envio" name="envio" class="d-none" />
            <select  id="paq" name="paq" class="form-control"required >
                <%  List<String> lista = (List<String>) request.getAttribute("listaPaquete");%>
                <% for (Integer i = 0; i < lista.size(); i++) {%>
                <option value="<%=lista.get(i)%>">
                    <%=lista.get(i)%>
                </option>
                <% } //Cerrar FOR %>
            </select>

            <button type="submit" class="button button1">Buscar</button>  

            <div class="row">
                <div class="col-5">
                    <img class="col-12"
                         src = "${imagen}" />
                </div>
                <div class="col-6 d-flex justify-content-start">
                    <div class="mt-4 d-flex flex-column text-center">

                        <label><b>Nombre</b></label>
                        <div class="input-group-text"> <label>${nombre} </label></div>


                    </div>
                </div>
                <div class="col-6 d-flex justify-content-end">
                    <div class="mt-4 d-flex flex-column text-center">
                        <label><b>Descripcion:</b></label>
                        <div class="input-group-text"> <label>${descripcion} </label></div>
                    </div>
                </div>
                <div class="col-6 d-flex justify-content-start">
                    <div class="mt-4 d-flex flex-column text-center">
                        <label><b>Fecha Alta:</b></label>
                        <div class="input-group-text"> <label>${fechaA} </label></div>
                    </div>
                </div>
                <div class="col-6 d-flex justify-content-end">
                    <div class="mt-4 d-flex flex-column text-center">
                        <label><b>Fecha Inicio:</b></label>
                        <div class="input-group-text"> <label>${fechaI} </label></div>
                    </div>
                </div>
                <div class="col-6 d-flex justify-content-start">
                    <div class="mt-4 d-flex flex-column text-center">
                        <label><b>Fecha Fin:</b></label>
                        <div class="input-group-text"> <label>${fechaF} </label></div>
                    </div>
                </div>
                <div class="col-6 d-flex justify-content-end">
                    <div class="mt-4 d-flex flex-column text-center">
                        <label><b>Precio</b></label>
                        <div class="input-group-text"> <label>${precio} </label></div>
                    </div>
                </div>
                <div class="col-6 d-flex justify-content-start">
                    <div class="mt-4 d-flex flex-column text-center">
                        <label><b>Descuento:</b></label>
                        <div class="input-group-text"> <label>${descuento} </label></div>
                    </div>
                </div> 
                <div class="col-6 d-flex justify-content-end">
                    <div class="mt-4 d-flex flex-column text-center">

                        <label><b>Categorias:</b></label>
                        <select  id="cat" name="cat" class="form-control" >
                            <%  List<String> listaC = (List<String>) request.getAttribute("listaCategoria");%>
                            <% for (Integer e = 0; e < listaC.size(); e++) {%>
                            <option value="<%=listaC.get(e)%>">
                                <%=listaC.get(e)%>
                            </option>
                            <% } //Cerrar FOR %>
                        </select>

                    </div>
                </div> 
                <div class="col-6 d-flex justify-content-end">
                    <div class="mt-4 d-flex flex-column text-center">
                        <label><b>Espectaculos:</b></label>

                        <select  id="esp" name="esp" class="form-control" >
                            <%  List<String> listaE = (List<String>) request.getAttribute("listaEspectaculo");%>
                            <% for (Integer e = 0; e < listaE.size(); e++) {%>
                            <option value="<%=listaE.get(e)%>">
                                <%=listaE.get(e)%>
                            </option>
                            <% } //Cerrar FOR %>
                        </select>

                    </div>
                </div>         
                <div class="col-6 d-flex justify-content-start">
                    <div class="mt-4 d-flex flex-column justify-content-end text-center">
                        <button type="submit" id="id" class="button button2">Consultar Espectaculos</button>  
                    </div>
                </div>
            </div>
        </form>

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
        let formulario = document.getElementById("formulario");
        let envio = document.getElementById("envio");

        let id = document.getElementById("id");
        id.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 1;
            formulario.submit();
        })

    </script>
    <script type="application/javascript" src="https://api.ipify.org?format=jsonp&callback=getIP"></script>

</html>
