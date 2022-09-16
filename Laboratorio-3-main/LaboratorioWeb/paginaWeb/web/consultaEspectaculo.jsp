<%@page import="Logica.ISistema" %>
    <%@page import="Logica.Factory" %>
        <%@page import="java.util.List" %>
            <%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
                <%@page import="java.util.ArrayList" %>
                    <html>

                    <head>
                        <title>Consulta de Espectáculo</title>
                        <meta charset="UTF-8">
                        <script src="https://cdn.jsdelivr.net/npm/chart.js@latest/dist/Chart.min.js"></script>
                        <link rel="stylesheet"
                            href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
                            integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
                            crossorigin="anonymous">

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

                        #seguir {
                            background-color: #603B54;
                        }

                        .btn {
                            width: 150px;
                        }

                        #noMostrar {
                            color: rgba(130, 172, 159, .0);
                        }

                        canvas {
                            position: relative;
                            height: 40vh;
                            width: 80vw
                        }
                    </style>

                    <body class="pb-5">
                        <div id="logo" class="p-2 m-4">
                            <b>CoronaTickets.uy</b>
                        </div>
                        <form action="buscador" method="POST" id="buscador"
                            class="d-flex flex-column align-items-center">
                            <div class="col-11 row my-1 ">
                                <div class="col-3 d-flex flex-column">
                                    <input type="text" name="valor" id="valor" class="input-group-text" />
                                </div>
                                <div class="col-3 d-flex flex-column">
                                    <button type="submit"
                                        style="width: 300px;text-align: center;border-radius: 10px; background-color: rgba(130, 172, 159, .51);"
                                        class=""><b>Buscar</b></button>
                                </div>
                            </div <jsp:include page="agente.jsp" />
                        </form>
                        <div class="row m-0 d-flex justify-content-center">

                            <div class="col-12 d-flex justify-content-center mb-4">
                                <h1>Consultar Espectaculo por</h1>
                            </div>
                            <form action="consultaEspectaculo" method="POST" id="formulario">
                                <input name="envio" id="envio" class="d-none" />
                                <div class="col-11 row my-2">
                                    <select id="cat" name="cat" class="col-5 input-group-text" required>
                                        <% List<String> listaC = (List<String>)
                                                request.getAttribute("listaCategoria");%>
                                                <% for (Integer c=0; c < listaC.size(); c++) {%>
                                                    <option value="<%=listaC.get(c)%>">
                                                        <%=listaC.get(c)%>
                                                    </option>
                                                    <% } //Cerrar FOR %>
                                    </select>

                                    <h1 class="mx-5"> O </h1>

                                    <select id="pla" name="pla" class="col-5 input-group-text" required>
                                        <% List<String> listaP = (List<String>)
                                                request.getAttribute("listaPlataforma");%>
                                                <% for (Integer p=0; p < listaP.size(); p++) {%>
                                                    <option value="<%=listaP.get(p)%>">
                                                        <%=listaP.get(p)%>
                                                    </option>
                                                    <% } //Cerrar FOR %>
                                    </select>
                                </div>

                                <div class="col-11 row my-2 ">
                                    <div class="col-5 d-flex justify-content-center">
                                        <button id="selCat" name="selCat" class="col-5 btn rounded">Seleccionar
                                            Categoria</button>
                                    </div>
                                    <div class="mx-5"></div>
                                    <div class="col-5 d-flex justify-content-center">
                                        <button id="selPla" name="selPla" class="col-5 btn rounded">Seleccionar
                                            Plataforma</button>
                                    </div>

                                </div>


                                <div class="col-11 row my-2 ">
                                    <select id="esp" name="esp" class="col-8 input-group-text">
                                        <% List<String> listaE = (List<String>)
                                                request.getAttribute("listaEspectaculo");%>
                                                <% for (Integer p=0; p < listaE.size(); p++) {%>
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
                                        <img class="col-12" src="${imagen}" />
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


                                        <div class="col-12 row">

                                            <div class="col-6 d-flex flex-column">
                                                <canvas id="myChart"></canvas>
                                                <label>Votos :${totalval} Promedio : ${valore}</label>


                                                <label id="fav">${favorito}</label>

                                                <label>Paquetes:</label>
                                                <select id="paq" name="paq" class="input-group-text mt-2">
                                                    <% List<String> listaPa = (List<String>)
                                                            request.getAttribute("listaPaquete");%>
                                                            <% for (Integer p=0; p < listaPa.size(); p++){%>
                                                                <option value="<%=listaPa.get(p)%>">
                                                                    <%=listaPa.get(p)%>
                                                                </option>
                                                                <% } //Cerrar FOR %>
                                                </select>
                                                <label>Funciones:</label>
                                                <select id="fun" name="fun" class="input-group-text">
                                                    <% List<String> listaF = (List<String>)
                                                            request.getAttribute("listaFuncione");%>
                                                            <% for (Integer f=0; f< listaF.size(); f++) {%>
                                                                <option value="<%=listaF.get(f)%>">
                                                                    <%=listaF.get(f)%>
                                                                </option>
                                                                <% } //Cerrar FOR %>
                                                </select>
                                                <label>Categorias:</label>
                                                <select id="cate" name="cate" class="input-group-text">
                                                    <% List<String> listaCa = (List<String>)
                                                            request.getAttribute("listaCategorias");%>
                                                            <% for (Integer c=0; c<listaCa.size(); c++) {%>
                                                                <option value="<%=listaCa.get(c)%>">
                                                                    <%=listaCa.get(c)%>
                                                                </option>
                                                                <% } %>
                                                </select>

                                                <iframe width="560" height="315" src="${videoEmbebido}"
                                                    title="YouTube video player" frameborder="0"
                                                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                                                    allowfullscreen></iframe>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <jsp:include page="agente.jsp" />
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
                            for (let i = 0; i < arrIp.length; i++) {
                                arrIp[i].value = ip;
                                arrSO[i].value = ua.platform;
                                arrNavegador[i].value = ua.brands[0].brand;
                                arrUrl[i].value = location.href;
                            }
                        }

                        //   USO EXCLUSIVO DE FILTRO //

                        if (document.getElementById("fav").innerHTML != "Es Favorito") {
                            document.getElementById("fav").style.display = "none"
                        }

                        const ctx = document.getElementById('myChart').getContext('2d');
                        const myChart = new Chart(ctx, {
                            type: 'bar',
                            data: {
                                labels: ['★★★★★', '★★★★', '★★★', '★★', '★'],
                                datasets: [{
                                    label: '',
                                    data: [${ e5 }, ${ e4 }, ${ e3 }, ${ e2 }, ${ e1 }, 0],
                                    backgroundColor: [
                                        'rgba(148, 120, 139)',
                                        'rgba(158, 140, 149)',
                                        'rgba(168, 160, 159)',
                                        'rgba(178, 180, 169)',
                                        'rgba(188, 200, 179)'
                                    ],
                                    borderColor: [
                                        'rgba(148, 120, 139, 100)',
                                        'rgba(148, 140, 139, 80)',
                                        'rgba(148, 160, 139, 60)',
                                        'rgba(148, 180, 139, 40)',
                                        'rgba(148, 110, 139, 20)'

                                    ],
                                    borderWidth: 1
                                }]
                            },
                            options: {
                                scales: {
                                    y: {
                                        beginAtZero: true
                                    }
                                }
                            }
                        });

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
                        selEsp.addEventListener("click", e => {
                            e.preventDefault();
                            envio.value = 3;
                            formulario.submit();
                        });

                    </script>
                    <script type="application/javascript"
                        src="https://api.ipify.org?format=jsonp&callback=getIP"></script>

                    </html>