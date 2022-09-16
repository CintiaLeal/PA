<!-- <%@page import="java.util.List"%>
<%@page import="Logica.Factory"%>
<%@page import="Logica.ISistema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html>

<head>
    <title>Consulta de Artista</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>

<style>
    #logo {
        background-color: rgba(130, 172, 159, .51);
        width: 200px;
        text-align: center;
        color: #603B54;
        border-radius: 20px;
    }

    h1 {
        font-size: 32px;
    }

    button {
        width: 500px;
    }

    .nickName {
        border-radius: 25px;
        background-color: #82AC9F;
    }

    .btn {
        height: 50px;
        background-color: #82AC9F;
    }

    .fondo {}

    a {
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
            </div>
        <jsp:include page = "agente.jsp" />
        </form>
    <div class="row m-0 d-flex justify-content-center">
        <div class="col-10 row m-auto m-0">
            <div class="col-5">
                <img class="col-12"
                    src = "${imagen}" />
            </div>
            <div class="col-7">
                <div class="col-6 nickName py-2 text-center" id="nickname">
                    <h1><b id="n">${nick}</b></h1>
                </div>
                <div class="mt-5 row">
                    <div class="col-6 m-0">
                        <div class="col-12 mt-3 m-auto text-center">
                            <h1>Biografia:</h1>
                        </div>
                        <div style="height: 200px; border-radius: 20px; background-color: rgba(148, 119, 139, .21);"
                            class="col-12 text-center">
                                <label>${biografia}</label>
                        </div>
                    </div>
                    <div class="col-6 m-0">
                        <div class="col-12 mt-3 m-auto text-center">
                            <h1>Descripcion:</h1>
                        </div>
                        <div style="height: 200px; border-radius: 20px; background-color: rgba(148, 119, 139, .21);"
                            class="col-12 text-center">
                                <label>${descripcion}</label>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Seguidores -->
            <div class="col-6 d-flex flex-column justify-content-center mt-3 ">
                <div class="d-flex flex-column align-items-center justify-content-center">
                    <div class="mt-3">
                        <h1>Seguidores:</h1>
                    </div>
                    <select id="esp" name="esp" class="col-6 input-group-text" required>
                        <%  List<String> listaE = (List<String>) request.getAttribute("seguidores");%>
                                    <% for (Integer p = 0; p < listaE.size(); p++) {%> -->
                        <option value="<%=listaE.get(p)%>">
                            <%=listaE.get(p)%>
                        </option>
                        <% } //Cerrar FOR %>
                    </select>
                </div>
                <div class="d-flex flex-column align-items-center justify-content-center">
                    <div class="mt-3">
                        <h1>Seguidos:</h1>
                    </div>
                    <select id="esp" name="esp" class="col-6 input-group-text" required>
                        <%  List<String> listaS = (List<String>) request.getAttribute("seguidos");%>
                                <% for (Integer p = 0; p < listaS.size(); p++) {%> -->
                        <option value="<%=listaS.get(p)%>">
                            <%=listaS.get(p)%>
                        </option>
                        <% } //Cerrar FOR %>
                    </select>
                </div>
                <form action="seguirUsuario" id="seguimient" class="d-flex justify-content-center mt-3">
                    <input name="nick" id="nick1" class="d-none" />
                    <input name="seguimiento" id="seguimiento" class="d-none" />
                    <button type="submit" class="btn mr-3 col-6" id="seguir"><b id="seg">${seguimiento}</b></button>
                   <jsp:include page = "agente.jsp" />
                </form>
            </div>
            <!-- IZQUIERDA -->
            <div class="col-5 mt-3 d-flex flex-column">
                <h1><b>Nombre y apellido: </b> ${nombre} ${apellido}</h1>
                <h1><b>Email: </b>${email}</h1>
                <h1><b>Fecha nacimiento: </b>${fecha}</h1>
                <h1><b>Sitio Web: </b>${link}</h1>
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
    let form = document.getElementById("seguimient");
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