<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Valorar Espectaculo</title>
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
        <form id="form" action="valorarEspectaculo">
        <input name="envio" id="envio" class="d-none"/>
        <input name="valorbtn" id="valorbtn" class="d-none"/>
        <div class="row m-0 d-flex justify-content-center">
            <div class="col-12 d-flex justify-content-center mb-4"><h1>Valorar un espectaculo</h1></div>

            <div class="col-11 row my-2">
                <select id="espectaculos" name="espectaculos" class="col-5 input-group-text" >
                        <%  List<String> lista = (List<String>) request.getAttribute("listaEspectaculos");%>
                        <% for (Integer c = 0; c < lista.size(); c++) {%>
                        <option value="<%=lista.get(c)%>">
                            <%=lista.get(c)%>
                        </option>
                        <% } //Cerrar FOR %>
                </select>

                <div class="col-5 d-flex justify-content-center"> 
                    <button id="selEsp" name="selEsp" class="col-5 btn rounded"><b>Seleccionar</b></button> 
                </div>
                <div class="col-5 d-flex justify-content-center"> 
                    <select id="puntaje" name="puntaje" class="col-5 input-group-text" >
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                </select>
                    <div class="col-5 d-flex justify-content-center"> 
                    <button id="selPuntaje" name="selPuntaje" class="col-5 btn rounded"><b id="boton">${btn}</b></button> 
                </div>
                </div>
            </div>
        </div>
        </form>
    </div>

</body>

<script type="text/javascript">
    let form = document.getElementById("form");
    let selEsp = document.getElementById("selEsp");
    let envio = document.getElementById("envio");
    selEsp.addEventListener("click", e => {
        e.preventDefault();
        envio.value = "1";
        form.submit();
    });
    let selPuntaje = document.getElementById("selPuntaje");
    let valorbtn = document.getElementById("valorbtn"); //input
    let valor = document.getElementById("boton");
    selPuntaje.addEventListener("click", e => {
        e.preventDefault();
        envio.value = "2";
        valorbtn.value = boton.innerHTML;
        form.submit();
    });
</script>
</html>
