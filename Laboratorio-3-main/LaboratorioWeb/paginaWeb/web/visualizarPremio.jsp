<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Visualizar premios</title>
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
            height: 50px;
            background-color: #82AC9F;
        }
        #seguir{
            background-color: #603B54;
        }
        .btn{
            width: 150px;
        }
        #noMostrar{
            color:rgba(130, 172, 159, .0);
        }
    </style>
    <body class="pb-5">
        <div id="logo" class="p-2 m-4">
            <b>CoronaTickets.uy</b>
        </div>
        <form id="form" action="visualizarPremio">
        <input name="envio" id="envio" class="d-none"/>
        <div class="row m-0 d-flex justify-content-center">
            <div class="col-12 d-flex justify-content-center mb-4"><h1>Visualizar Premios</h1></div>

            <div class="col-11 row my-2">
                <select id="premios" name="premios" class="col-5 input-group-text" >
                        <%  List<String> lista = (List<String>) request.getAttribute("premios");%>
                        <% for (Integer c = 0; c < lista.size(); c++) {%>
                        <option value="<%=lista.get(c)%>">
                            <%=lista.get(c)%>
                        </option>
                        <% } //Cerrar FOR %>
                </select>
                <div class="col-5 d-flex justify-content-center"> 
                    <button id="info" name="info" class="col-5 btn rounded">Info</button> 
                </div>
                <div class="col-8 row">
                    <div class="col-4 d-flex flex-column">
                        <label>Fecha Sorteo:</label>
                        <input class="input-group-text" value="${fechaSorteo}"/>
                    </div>
                    <div class="col-4 d-flex flex-column">
                        <label>Función:</label>
                        <input class="input-group-text" value="${funcion}"/>
                    </div>
                    <div class="col-4 d-flex flex-column">
                        <label>Espectaculo:</label>
                        <input class="input-group-text" value="${espectaculo}"/>
                    </div>
                    <div class="col-4 d-flex flex-column">
                        <label>Descripcion:</label>
                        <input class="input-group-text" value="${desc}"/>
                    </div>
                </div>
                <div class="mx-10 m"></div>
                <div class="col-5 mt-5 d-flex justify-content-center">
                    <button id="imprimir" name="imprimir" class="col-5 btn rounded" style="background-color: #829298"> <b>Imprimir Comprobante</b></button>
                </div> 
            </div>
        </div>
                    <jsp:include page = "agente.jsp" />
        </form>
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
    let info = document.getElementById("info");
    let form = document.getElementById("form");
    let imprimir = document.getElementById("imprimir");
    
   
     
    info.addEventListener("click", e => {
        e.preventDefault();
        envio.value = 1;
        form.submit();
    });
   
   
    imprimir.addEventListener("click", e => {
        e.preventDefault();
        envio.value = 2;
        form.submit();
    });
</script>
<script type="application/javascript" src="https://api.ipify.org?format=jsonp&callback=getIP"></script>

</html>