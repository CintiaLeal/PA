<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@page import="java.util.ArrayList"%>
<html>
    <head>
        <title>Consulta de Espectáculos Finalizados</title>
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
            <form action="consultarEspectaculoFinalizado" id="form">
                <div class="col-11 row my-2 ">
                    <label>Espectaculos</label>
                    <select  id="esp" name="esp" class="col-8 input-group-text">
                        <%  List<String> listaE = (List<String>) request.getAttribute("listaEspectaculo");%>
                        <% for (Integer p = 0; p < listaE.size(); p++) {%>
                        <option value="<%=listaE.get(p)%>">
                            <%=listaE.get(p)%>
                        </option>
                        <% } //Cerrar FOR %>
                    </select>
                    <div class="col-4 d-flex justify-content-center">

                        <button id="selEsp" name="selEsp" class="col-5 btn rounded">Seleccionar</button>
                    </div>
                </div>

                <div class="col-11 row my-2 ">
                    <div class="col-5">
                        <img class="col-12"
                             src = "${imagen}" />
                    </div>
                    <div class="col-8 row">
                        <div class="col-4 d-flex flex-column">
                            <label><b>Nombre</b></label>
                            <div class="input-group-text"> <label>${nombre} </label></div>                            
                        </div>
                        <div class="col-4 d-flex flex-column">
                            <label>Artista</label>
                            <div class="input-group-text"> <label>${artista} </label></div> 
                        </div>
                        <div class="col-4 d-flex flex-column">
                            <label>Duracion</label>
                            <div class="input-group-text"> <label>${duracion} </label></div> 

                        </div>
                        <div class="col-4 d-flex flex-column">
                            <label>Descripcion</label>
                            <div class="input-group-text"> <label>${descripcion} </label></div>
                        </div>
                        <!--  -->

                        <div class="col-4 d-flex flex-column">
                            <label>Costo</label>
                            <div class="input-group-text"> <label>${costo} </label></div>
                        </div>
                        <div class="col-4 d-flex flex-column">
                            <label>Espectadores minimos</label>
                            <div class="input-group-text"> <label>${cantMin} </label></div>
                        </div>
                        <div class="col-4 d-flex flex-column">
                            <label>Espectadores maximo</label>
                            <div class="input-group-text"> <label>${cantMax} </label></div>
                        </div>
                        <iframe width="560" height="315" src="${videoEmbebido}" title="YouTube video player" 
                             frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                        <div class="col-4 d-flex flex-column">
                            <label>Categorias:</label>
                            <select id="cate" name="cate" class="input-group-text">
                                <%  List<String> listaCa = (List<String>) request.getAttribute("listaCategorias");%>
                                <% for (Integer c = 0; c<listaCa.size(); c++) {%>
                                <option value="<%=listaCa.get(c)%>">
                                    <%=listaCa.get(c)%>
                                </option>
                                <% } %>
                            </select>
                        </div>

                        <div class="col-12 row">

                            <div class="col-6 d-flex flex-column">
                                <label>Paquetes:</label>
                                <select id="paq" name="paq" class="input-group-text mt-2">
                                    <%  List<String> listaPa = (List<String>) request.getAttribute("listaPaquete");%>
                                    <%for(Integer p = 0; p < listaPa.size(); p++){%>
                                    <option value="<%=listaPa.get(p)%>">
                                        <%=listaPa.get(p)%>
                                    </option>
                                    <% } //Cerrar FOR %>
                                </select>
                                <label>Funciones:</label>
                                <select id="fun" name="fun"  class="input-group-text">
                                    <%  List<String> listaF = (List<String>) request.getAttribute("listaFuncione");%>
                                    <% for (Integer f = 0; f< listaF.size(); f++) {%>
                                    <option value="<%=listaF.get(f)%>">
                                        <%=listaF.get(f)%>
                                    </option>
                                    <% } //Cerrar FOR %>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
            </form>                   
        </div>

</body>
<script type="text/javascript">

    let formulario = document.getElementById("form");
    let envio = document.getElementById("envio");
    var ret = "";
    selEsp.addEventListener("click", e => {
        e.preventDefault();
        formulario.submit();
    });
</script>

</html>