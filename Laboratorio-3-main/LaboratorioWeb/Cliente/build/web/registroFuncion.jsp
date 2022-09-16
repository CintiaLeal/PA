<%-- 
    Document   : registroFuncion
    Created on : 12/10/2021, 08:40:29 AM
    Author     : romil
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro Funcion</title>
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
        select{
            height: 50px;
        }
    </style>
    <body>
        <div id="logo" class="p-2 m-4">
            <b>CoronaTickets.uy</b>
        </div>
<!--        <form action ="buscador" method= "post" id="buscador" class="d-flex flex-column align-items-center">
            <div class="col-11 row my-1 ">
                <div class="col-3 d-flex flex-column">
                    <input type="text" name="valor" id="valor" class="input-group-text"/>
                </div>
                <div class="col-3 d-flex flex-column">
                    <button type="submit"  style="width: 300px;text-align: center;border-radius: 10px; background-color: rgba(130, 172, 159, .51);" class=""><b>Buscar</b></button>
                </div>           
            </div>
        </form>-->
        <div>
            <form id="form" action="registroFuncion" class="row m-0 d-flex justify-content-center">
                <input id="enviarArr" name="enviarArr" class="d-none"/>
                <input id="envio" name="envio" class="d-none"/>
                <input id="pl" name="pl" class="d-none"/>
                <input id="cate" name="cate" class="d-none"/>
                <input id="auxpaquete" name="auxpaquete" class="d-none"/>
                <input id="espectaculo" name="espectaculo" class="d-none" value=$(espectaculo)>
                <div class="col-12 d-flex justify-content-center mt-2 mb-4"><h1>Registrarse a Funcion</h1></div>
                <div class="col-11 row my-2">
                    <select id="pla" name="pla" class="col-5 input-group-text" >
                        <%  List<String> listaP = (List<String>) request.getAttribute("listaPlataforma");%>
                        <% for (Integer c = 0; c < listaP.size(); c++) {%>
                        <option value="<%=listaP.get(c)%>">
                            <%=listaP.get(c)%>
                        </option>
                        <% } //Cerrar FOR %>
                    </select>
                    <h1 class="mx-5"> O </h1>
                    <select id="cat" class="col-5 input-group-text" >
                        <%  List<String> listaC = (List<String>) request.getAttribute("listaCategoria");%>
                        <% for (Integer i = 0; i < listaC.size(); i++) {%>
                        <option value="<%=listaC.get(i)%>">
                            <%=listaC.get(i)%>
                        </option>
                        <% } //Cerrar FOR %>
                    </select>
                </div>
                <div class="col-11 row my-2 ">
                    <div class="col-5 d-flex justify-content-center">
                        <button id="plataforma" name="plataforma" class="col-5 btn rounded">Seleccionar Pla</button>
                    </div>
                    <div class="mx-5"></div>
                    <div class="col-5 d-flex justify-content-center">
                        <button id="categoria" name="categoria" class="col-5 btn rounded">Seleccionar  Cat</button>
                    </div>
                </div>

                <div class="col-11 row my-2">
                    <select id="esp" name ="esp" class="col-5 input-group-text" >
                        <%  List<String> listaE = (List<String>) request.getAttribute("listaEspectaculo");%>
                        <% for (Integer j = 0; j < listaE.size(); j++) {%>
                        <option value="<%=listaE.get(j)%>">
                            <%=listaE.get(j)%>
                        </option>
                        <% } //Cerrar FOR %>
                    </select>
                    <button id="selEsp" class=" ml-5 col-3 btn rounded">Seleccionar E</button>
                </div>

                <div class="col-11 row my-2">
                    <select id="fun" name="fun" class="col-5 input-group-text" >
                        <%  List<String> listaF = (List<String>) request.getAttribute("listaFuncion");%>
                        <% for (Integer f = 0; f < listaF.size(); f++) {%>
                        <option value="<%=listaF.get(f)%>">
                            <%=listaF.get(f)%>
                        </option>
                        <% } //Cerrar FOR %>
                    </select>

                </div>
                <!-- IMPORTANTE ACA ESTA LA FUNCIONALIDAD -->
                <div class="col-11 row my-2">
                    <select id="paquetes" name="paquetes" class="col-5 input-group-text" >
                        <%  List<String> listaPa = (List<String>) request.getAttribute("listaPaquete");%>
                        <% for (Integer f = 0; f < listaPa.size(); f++) {%>
                        <option value="<%=listaPa.get(f)%>">
                            <%=listaPa.get(f)%>
                        </option>
                        <% } //Cerrar FOR %>
                    </select>
                    <h1 class="mx-5"> O </h1>
                    <select id="registros" class="col-5 input-group-text" >
                        <%  List<String> listar = (List<String>) request.getAttribute("listaRegistro");%>
                        <% for (Integer r = 0; r < listar.size(); r++) {%>
                        <option value="<%=listar.get(r)%>">
                            <%=listar.get(r)%>
                        </option>
                        <% } //Cerrar FOR %>
                    </select>
                </div>
                <div class="col-11 row my-2 ">
                    <div class="col-5 d-flex justify-content-center">
                        <button id="seleccionarRegistro" class="col-5 btn rounded">Seleccionar</button>
                    </div>
                    <div class="mx-5"></div>
                    <div class="col-5 d-flex justify-content-center">
                        <button id="seleccionarPaquete" class="col-5 btn rounded">Seleccionar</button>
                    </div>
                </div>

                <div style="height: 150px;" id="divMostrar" class="col-3 rounded">
                    <!-- MOSTRAR LOS USUARIOS SELECCIONADOS -->
                </div>

                <div style="margin-top: 50px;" class="col-8 d-flex justify-content-end alig-items-center">
                    <button id="aceptar" name="aceptar" type="submit" class="btn mr-3">Aceptar</button>
                    <button class="btn ml-3">Cancelar</button>
                </div>

            </form>
        </div>
    </body>

    <script type="text/javascript">
        let form = document.getElementById("form");
        let enviarArr = document.getElementById("enviarArr");
        let envio = document.getElementById("envio");

        let pla = document.getElementById("plataforma");
        let p = document.getElementById("pla");
        let pl = document.getElementById("pl");
        pla.addEventListener("click", e => {
            e.preventDefault();
            pl.value = p.value;
            envio.value = 1;
            form.submit();
        });

        let cat = document.getElementById("categoria");
        let c = document.getElementById("cat");
        let categoria = document.getElementById("cate");
        cat.addEventListener("click", e => {
            e.preventDefault();
            categoria.value = c.value;
            envio.value = 2;
            form.submit();
        });
        let selEsp = document.getElementById("selEsp");
        let esp = document.getElementById("espectaculo");
        selEsp.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 0;
            form.submit();
        });
        let btnRegistro = document.getElementById("seleccionarRegistro");
        let btnPaquete = document.getElementById("seleccionarPaquete");

        let divMostrar = document.getElementById("divMostrar");
        let registroNuevo = document.getElementById("registros");
        let paqueteNuevo = document.getElementById("paquetes");

        let arr = []
        btnRegistro.addEventListener("click", e => {
            e.preventDefault();
            if (!divMostrar.value) { //Si el valor del div es undefined => significa que no hay nada guardado
                divMostrar.innerHTML += registroNuevo.value + "<br/>";
                divMostrar.value = "registro";
                arr.push(registroNuevo.value);
            } else if (divMostrar.value != "registro registro registro" && divMostrar.value != "paquete") {
                divMostrar.value += " registro";
                divMostrar.innerHTML += registroNuevo.value + "<br/>";
                arr.push(registroNuevo.value);
            }
        })
        let auxpaquete = document.getElementById("auxpaquete");
        let selecpaquete = document.getElementById("paquetes");
        btnPaquete.addEventListener("click", e => {
            e.preventDefault();
            if (!divMostrar.value) { //Si el valor del div es undefined => significa que no hay nada guardado
                divMostrar.innerHTML += paqueteNuevo.value + "<br/>";
                divMostrar.value = "paquete";
                auxpaquete.value = selecpaquete.value;
            }
        })
        let aceptar = document.getElementById("aceptar");
        form.addEventListener("submit", e => {
            e.preventDefault();
            envio.value = 3;
            enviarArr.value = arr;
            if (divMostrar.value === "registro registro registro") {
                form.submit();
            } else if (divMostrar.value === "paquete") {
                form.submit();
            } else if (divMostrar.value === undefined) {
                form.submit();
            }
        });

    </script>
</html>
