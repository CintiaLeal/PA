<%-- 
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
--%>

<%@page import="java.util.List"%>
<%@page import="Logica.ISistema"%>
<%@page import="Logica.Factory"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Consulta de Espectador</title>
        <meta http-equi="Conten-Type" content="text/html; charset=ISO-8859-1">
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
            height: 50px;
            background-color: #82AC9F;
            width: 500px;
        }
        .nickName{
            border-radius: 25px;
            background-color: #82AC9F;
        }

        .btn{
            height: 50px;
            background-color: #82AC9F;
        }

        a{
            color: #603B54;
        }
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
            </div
            <jsp:include page = "agente.jsp" />
        </form>
        <div class="row m-0 d-flex justify-content-center">
            <div class="col-10 row m-auto m-0">
                <div class="col-5">
                    <img class="col-12" src="${imagen}" />
                </div>
                <div class="col-7">
                    <div class="col-6 nickName py-2 text-center"><h1><b id="n">${nick}</b></h1></div>
                    <div class="mt-5">
                        <div class="col-12 mt-3"><h1>Nombre: ${nombre} </h1></div>
                        <div class="col-12 mt-3"><h1>Apellido: ${apellido}</h1></div>
                        <div class="col-12 mt-3"><h1>Email: ${email}</h1></div>
                        <div class="col-12 mt-3"><h1>Fecha de nacimiento: ${fecha}</h1></div>
                    </div>
                </div>
                <div class="col-12 d-flex justify-content-center m-4">
                    <div class="col-11 row my-2">
                        <div class="col-6 mt-3"><h1>Seguidores:</h1></div>
                        <select  id="esp" name="esp" class="col-5 input-group-text" required>
                            <%  List<String> listaE = (List<String>) request.getAttribute("seguidores");%>
                            <% for (Integer p = 0; p < listaE.size(); p++) {%>
                            <option value="<%=listaE.get(p)%>">
                                <%=listaE.get(p)%>
                            </option>
                            <% } //Cerrar FOR %>
                        </select>
                        <div class="col-6 mt-3"><h1>Seguidos:</h1></div>
                        <select  id="esp" name="esp" class="col-5 input-group-text" required>
                            <%  List<String> listaS = (List<String>) request.getAttribute("seguidos");%>
                            <% for (Integer p = 0; p < listaS.size(); p++) {%>
                            <option value="<%=listaS.get(p)%>">
                                <%=listaS.get(p)%>
                            </option>
                            <% } //Cerrar FOR %>
                        </select>
                        <div class="col-6 mt-3"><h1>Registros</h1></div>
                        <select  id="esp" name="esp" class="col-5 input-group-text" required>
                            <%  List<String> listaR = (List<String>) request.getAttribute("registros");%>
                            <% for (Integer p = 0; p < listaR.size(); p++) {%>
                            <option value="<%=listaR.get(p)%>">
                                <%=listaR.get(p)%>
                            </option>
                            <% } //Cerrar FOR %>
                        </select>
                    </div>
                    <div class="col-4 row my-3">
                        <form id="seguir" action ="seguirUsuario">
                            <input name="nick" id="nick1" class="d-none"/>
                            <input name="seguimiento" id="seguimiento" class="d-none"/>
                            <button type="submit" class="btn  col-11 mt-5"><b id="seg">${seguimiento}</b></button>
                        <jsp:include page = "agente.jsp" />
                        </form>
                    </div>
                </div>
            </div>
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
        let form = document.getElementById("seguir");
        let seguido = document.getElementById("nick1");
        let valor = document.getElementById("n");
        let bot = document.getElementById("seg");
        let seg = document.getElementById("seguimiento");
        form.addEventListener('submit', (e) => {
            e.preventDefault();
            seg.value = bot.innerHTML;
            seguido.value = valor.innerHTML;
            form.submit();
        });
    </script>
<script type="application/javascript" src="https://api.ipify.org?format=jsonp&callback=getIP"></script>

</html>
