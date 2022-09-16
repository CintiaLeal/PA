<%-- 
    Document   : consultarFuncion
    Created on : 11/10/2021, 11:12:36 PM
    Author     : Administrador
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <title>Consulta de Funcion</title>
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
    <div class="row m-0 d-flex justify-content-center">
        <div class="col-12 d-flex justify-content-center mb-4"><h1>Consultar Funcion</h1></div>
        <form action="consultarFuncion" method= "post" id="formulario">
            <input name="envio" id="envio" class="d-none"/>
            <div class="col-11 row my-2">
                <select  id="cat" name="cat" class="col-5 input-group-text" required >
                    <%  List<String> listaC = (List<String>) request.getAttribute("listaCategoria");%>
                    <% for (Integer c = 0; c < listaC.size(); c++) {%>
                    <option value="<%=listaC.get(c)%>">
                        <%=listaC.get(c)%>
                    </option>
                    <% } //Cerrar FOR %>
                </select>

                <h1 class="mx-5"> O </h1>

                <select  id="pla" name="pla" class="col-5 input-group-text" required >
                    <%  List<String> listaP = (List<String>) request.getAttribute("listaPlataforma");%>
                    <% for (Integer p = 0; p < listaP.size(); p++) {%>
                    <option value="<%=listaP.get(p)%>">
                        <%=listaP.get(p)%>
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
                <input name="espectaculo" id="espectaculo" class="d-none"/>
                <select  id="esp" name="esp" class="col-8 input-group-text">

                    <%  List<String> listaE = (List<String>) request.getAttribute("listaEspectaculo");%>
                    <% for (Integer p = 0; p < listaE.size(); p++) {%>
                    <option value="<%=listaE.get(p)%>">
                        <%=listaE.get(p)%>
                    </option>
                    <% } //Cerrar FOR %>
                </select>
                <div class="col-4 d-flex justify-content-center">
                    <button id="selEsp"  name="selEsp" class="col-5 btn rounded">Seleccionar</button>
                </div>

                <h1 class="mx-5"> </h1>
                <input name="funcion" id="funcion" class="d-none"/>
                <select  id="fun" name="fun" class="col-8 input-group-text">
                    <%  List<String> listaF = (List<String>) request.getAttribute("listaFuncion");%>
                    <% for (Integer p = 0; p < listaF.size(); p++) {%>
                    <option value="<%=listaF.get(p)%>">
                        <%=listaF.get(p)%>
                    </option>
                    <% } //Cerrar FOR %>
                </select>
                <div class="col-4 d-flex justify-content-center">
                    <button id="selFun"  name="selFun" class="col-5 btn rounded">Seleccionar</button>
                </div>

            </div>


            <div class="col-11 row my-2 ">
                <div class="col-5">
                    <img class="col-12"
                         src = "${imagen}" />
                </div>
                <div class="col-8 row">
                    <div class="col-4 d-flex flex-column">
                        <label>Nombre:</label>
                        <input id="nombre" name="nombre" value="${nombre}" class="input-group-text" />
                    </div>
                    <div class="col-4 d-flex flex-column">
                        <label>Fecha:</label>
                        <input id="fecha" value="${fecha}" class="input-group-text" />
                    </div>
                    <div class="col-4 d-flex flex-column">
                        <label>Hora Inicio:</label>
                        <input id="hora" value="${hora}" class="input-group-text" />
                    </div>

                    <div class="col-4 d-flex flex-column">
                        <label>Artistas Invitados:</label>

                        <select  id="art" name="art" class="col-8 input-group-text">
                            <%  List<String> listaA = (List<String>) request.getAttribute("listaArtista");%>
                            <% for (Integer p = 0; p < listaA.size(); p++) {%>
                            <option value="<%=listaA.get(p)%>">
                                <%=listaA.get(p)%>
                            </option>
                            <% } //Cerrar FOR %>
                        </select>
                    </div>
                    <!--  -->

                </div>
                <div class="mx-10 m"></div>
                <div class="col-5 mt-5 d-flex justify-content-center">
                    <button id="sorteo" name="sorteo" class="col-5 btn rounded" style="background-color: #603B54"><b>${sorteo}</b></button>
                </div>

            </div>
    </div>
                <input name="espe" id="espe" class="d-none" value="${esp}"/>

</div>
</form>
</body>

<script type="text/javascript">

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
    let selEsp = document.getElementById("selEsp")
    let esp = document.getElementById("esp")
    let espectaculo = document.getElementById("espectaculo");
    selEsp.addEventListener("click", e => {
        e.preventDefault();
        envio.value = 3;
        espectaculo.value = esp.value;
        formulario.submit();
    });
    let selFun = document.getElementById("selFun");
    selFun.addEventListener("click", e => {
        e.preventDefault();
        envio.value = 4;
        formulario.submit();
    });
    let sort = document.getElementById("sorteo");
    sort.addEventListener("click", e => {
        e.preventDefault();
        envio.value = 5;
        formulario.submit();
    });

</script>

</html>