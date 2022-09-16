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
        <title>Registro a Funcion de Espectaculo</title>
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
        </div>
        <a href="menuArtista.jsp"><b>CoronaTickets.uy</b> </a>
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
        <form action="RegistroFuncionEspectaculo" method= "POST" id="formulario">
            <div class="col-12 d-flex justify-content-center mb-4"><h1>Registro Funcion de Espectaculo por</h1></div>
            <div class="col-11 row my-2">
                <select  id="cat" name="cat" class="col-5 input-group-text" required >
                    <%  List<String> listaC = new ArrayList();/*(List<String>) request.getAttribute("listaCategoria");*/%>
                    <% for (Integer c = 0; c < listaC.size(); c++) {%>
                    <option value="<%=listaC.get(c)%>">
                        <%=listaC.get(c)%>
                    </option>
                    <% } //Cerrar FOR %>
                </select>

                <h1 class="mx-5"> O </h1>

                <select  id="pla" name="pla" class="col-5 input-group-text" required >
                    <%  List<String> listaP = new ArrayList(); /*(List<String>)request.getAttribute("listaPlataforma");*/%>
                    <% for (Integer p = 0; p < listaP.size(); p++) {%>
                    <option value="<%listaP.get(p);%>">
                        <%listaP.get(p);%>
                    </option>
                    <% } //Cerrar FOR %>
                </select>
            </div>
            <div class="col-11 row my-2 ">
                <div class="col-5 d-flex justify-content-center">
                    <button id="selCat" name="selCat" class="col-5 btn rounded">Seleccionar Categoria</button>
                </div>
                <div class="mx-5"></div>
                <div class="col-5 d-flex justify-content-center">
                    <button id="selPla" name="selPla" class="col-5 btn rounded">Seleccionar Plataforma</button>
                </div>

            </div>

            <div class="col-11 row my-2">
                <select  id="cat" name="esp" class="col-5 input-group-text" required >
                    <%  List<String> listaE = new ArrayList();/*(List<String>) request.getAttribute("listaCategoria");*/%>
                    <% for (Integer e = 0; e < listaE.size(); e++) {%>
                    <option value="<%listaE.get(e);%>">
                        <%listaE.get(e);%>
                    </option>
                    <% } //Cerrar FOR %>
                </select>

                <h1 class="mx-5"> O </h1>

                <select  id="pla" name="fun" class="col-5 input-group-text" required >
                    <%  List<String> listaF = new ArrayList(); /*(List<String>)request.getAttribute("listaPlataforma");*/%>
                    <% for (Integer f = 0; f < listaF.size(); f++) {%>
                    <option value="<%listaF.get(f);%>">
                        <%listaF.get(f);%>
                    </option>
                    <% } //Cerrar FOR %>
                </select>
            </div>
            <div class="col-11 row my-2 ">
                <div class="col-5 d-flex justify-content-center">
                    <button id="selCat" name="setEsp" class="col-5 btn rounded">Seleccionar Categoria</button>
                </div>
                <div class="mx-5"></div>
                <div class="col-5 d-flex justify-content-center">
                    <button id="selPla" name="selFun" class="col-5 btn rounded">Seleccionar Plataforma</button>
                </div>

            </div>
            <jsp:include page = "agente.jsp" />
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
        var ret = "";
        //para boton seleccionar categoria
        let selCat = document.getElementById("selCat");
        selCat.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 1;
            formulario.submit();
        });
        //para boton seleccionar plataforma
        let selPla = document.getElementById("selPla");
        selPla.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 2;
            formulario.submit();
        });
        let selEsp = document.getElementById("selEsp");
        selEsp.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 3;
            formulario.submit();
        });

        let selEsp = document.getElementById("selFun");
        selEsp.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 4;
            formulario.submit();
        });
    </script>
    <script type="application/javascript" src="https://api.ipify.org?format=jsonp&callback=getIP"></script>

</html>
