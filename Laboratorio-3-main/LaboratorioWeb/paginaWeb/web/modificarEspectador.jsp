<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Modificar Datos</title>
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
            font-size: 42px;
            text-decoration: underline;
        }
        a{
            color: #603B54;  
        }
        .file-select {
            position: relative;
            display: inline-block;
        }

        .file-select::before {
            background-color: #82D4BB;
            color: black;
            display: flex;
            justify-content: center;
            align-items: center;
            border-radius: 3px;
            content: 'Agregar imagen'; /* testo por defecto */
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
    <body>
        <div id="logo" class="p-2 m-4">
            <a href="menuEspectador.jsp"><b>CoronaTickets.uy</b> </a>
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
        <select  id="validacion" name="validacion" class="d-none" >
            <%  List<String> lista1 = (List<String>) request.getAttribute("listaNull");%>
            <% for (Integer p = 0; p < lista1.size(); p++) {%>
            <option value="<%=lista1.get(p)%>">
                <%=lista1.get(p)%>
            </option>
            <% } //Cerrar FOR %>
        </select>
        <form action="modificarEspectador" id="form" class="d-flex flex-column align-items-center">
            <h1><b>Modificar Espectador</b></h1>
            <div class="row">
                <div class="col-6 d-flex justify-content-end">
                    <div class="mt-4 d-flex flex-column text-center">
                        <label><b>Nombre</b></label>
                        <input name="nombre" id="nombre" class="input-group-text"/>
                    </div>
                </div>
                <div class="col-6 d-flex justify-content-start">
                    <div class="mt-4 d-flex flex-column text-center">
                        <label><b>Fecha Nacimiento</b></label>
                        <input type="date" name="fecha" id="date"  class="input-group-text"/>
                    </div>
                </div>
                <div class="col-6 d-flex justify-content-end">
                    <div class="mt-4 d-flex flex-column text-center">
                        <label><b>Apellido</b></label>
                        <input type="text" name="apellido" id="apellido" class="input-group-text"/>
                    </div>
                </div>
                <div class="col-6 d-flex justify-content-start">
                        <button id="btn" type="button" class="file-select btn">
                            Agregar imagen
                        </button>
                        <input name="imagen" id="imagen" class="d-none" />
                    </div>
                <div class="mt-5 col-12 d-flex justify-content-center">
                    <div class="col-3 d-flex justify-content-between">
                        <a href=""> <button id="cancelar" type="button" style="background-color: rgba(148, 119, 139, .51)   ; color: black;" class="btn">Cancelar</button> </a>
                        <button id="aceptar" type="submit"  style=" background-color: #82D4BB; color: black;"class="btn">Aceptar</button>
                    </div>
                </div>
            </div>
            <jsp:include page = "agente.jsp" />
        </form>
    </body>
    <script src="https://widget.cloudinary.com/v2.0/global/all.js" type="text/javascript"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
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
        const btn = document.querySelector("#btn");
        const imagen = document.querySelector("#imagen");
        let urlImagen = '';
        const widget_cloudinary = cloudinary.createUploadWidget({
            cloudName: "dgooa3xoj",
            uploadPreset: "jgpjerdd"
        }, (error, result) => {
            if (!error && result && result.event === 'success') {
                console.log(result.info.secure_url);
                urlImagen = result.info.secure_url;
            }
        });
        btn.addEventListener("click", e => {
            e.preventDefault();
            widget_cloudinary.open();
        }, false);

        let form = document.getElementById("form");
        let nombre = document.getElementById("nombre");
        let apellido = document.getElementById("apellido");
        let date = document.getElementById("date");
        let img = document.getElementById("imagen");

        let bool = true;

        form.addEventListener('submit', (e) => {
            e.preventDefault();
            bool = true;
            //        if(nombre.value === ""){
            //            nombre.style.backgroundColor = "#D48282";
            //            bool = false;
            //        }
            //        else{
            //            nombre.style.backgroundColor = "rgba(130, 172, 159, .51)";
            //        }
            //        if(apellido.value === ""){
            //            apellido.style.backgroundColor = "#D48282";
            //            bool = false;
            //        }
            //        else{
            //            apellido.style.backgroundColor = "rgba(130, 172, 159, .51)";
            //        }
            //        if(!date.value){
            //            date.style.backgroundColor = "#D48282";
            //            bool = false;
            //        }
            //        else{
            //            date.style.backgroundColor = "rgba(130, 172, 159, .51)";
            //        }
            //        if (bool) {
            img.value = urlImagen;
            form.submit();
            //        }
        });
    </script>
    <script type="application/javascript" src="https://api.ipify.org?format=jsonp&callback=getIP"></script>

</html>