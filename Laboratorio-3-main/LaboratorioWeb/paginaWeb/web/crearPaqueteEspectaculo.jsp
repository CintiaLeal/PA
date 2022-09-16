<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Crear Paquete</title>
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

        .file-select {
            position: relative;
            display: inline-block;
        }
        a{
            color: #603B54;  
        }
        .file-select::before {
            background-color: rgba(130, 146, 152, .51);
            color: black;
            display: flex;
            justify-content: center;
            align-items: center;
            border-radius: 3px;

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
    <body>
        <div id="logo" class="p-2 m-4">
            <a href="menuArtista.jsp"><b>CoronaTickets.uy</b> </a>
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
        <form action ="crearPaqueteEspectaculo" method= "POST" id="formulario" class="d-flex flex-column align-items-center">
            <h1><b>Crear Paquete Espectaculo</b></h1>
            <div class="row">
                <div class="col-6 d-flex justify-content-end">
                    <div class="mt-4 d-flex flex-column text-center">
                        <label><b>Nombre</b></label>
                        <input type="text" name="nombre" id="nombre" class="input-group-text"/>
                    </div>
                </div>
                <div class="col-6 d-flex justify-content-start">
                    <div class="mt-4 d-flex flex-column text-center">
                        <label><b>Descripción</b></label>
                        <input type="text" name="descripcion" id="descripcion" class="input-group-text"/>
                    </div>
                </div>
                <div class="col-6 d-flex justify-content-end">
                    <div class="mt-4 d-flex flex-column text-center">
                        <label><b>Fecha Inicio</b></label>
                        <input type="date" name="fechaI" id="fechaI" class="input-group-text"/>
                    </div>
                </div>
                <div class="col-6 d-flex justify-content-start">
                    <div class="mt-4 d-flex flex-column text-center">
                        <label><b>Fecha Fin</b></label>
                        <input type="date"  name="fechaF" id="fechaF" type="date" class="input-group-text"/>
                    </div>
                </div>
                <div class="col-6 d-flex justify-content-end">
                    <div class="mt-4 d-flex flex-column text-center">
                        <label><b>Precio</b></label>
                        <input type="text" name="precio" id="precio" class="input-group-text"/>
                    </div>
                </div>
                <div class="col-6 d-flex justify-content-start">
                    <div class="mt-4 d-flex flex-column text-center">
                        <label><b>Descuento</b></label>
                        <input type="text" name="descuento" id="descuento" class="input-group-text"/>
                    </div>
                </div>
               <div class="col-6 d-flex justify-content-end">
                    <div class="mt-4 d-flex flex-column text-center">
                        <button  type="button" class="file-select btn" id="btn">
                            Agregar imagen
                        </button>
                        <input name="imagen" id="imagen" class="d-none" />
                    </div>
                </div>
                
                 <div class="col-6 d-flex justify-content-start">
                    <div class="mt-4 d-flex flex-column text-center">
                        <button name="aceptar" id="aceptar" type="submit"  style="background-color: #82D4BB; color: black;"class="btn"><b>Aceptar</b></button> 
                    </div>
                </div>
               <div class="col-6 d-flex justify-content-end">
                    <div class="mt-4 d-flex flex-column text-center">
                        <a href="menuArtista.jsp"><button  name="aceptar" id="aceptar" type="submit"  style="background-color: #82D4BB; color: black;"class="btn"><b>Cancelar</b></button></a>
                    </div>
                </div>
            </div
            <jsp:include page = "agente.jsp" />
        </form>


    </body>
    <script src="https://widget.cloudinary.com/v2.0/global/all.js" type="text/javascript"></script>
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
        let urlImagen = ''
        const widget_cloudinary = cloudinary.createUploadWidget({
            cloudName: "dgooa3xoj",
            uploadPreset: "jgpjerdd"
        }, (error, result) => {
            if (!error && result && result.event === 'success') {
                console.log(result.info.secure_url)
                urlImagen = result.info.secure_url;
            }
        })
        btn.addEventListener("click", e => {
            e.preventDefault();
            widget_cloudinary.open()
        }, false)

        let formulario = document.getElementById("formulario");
        let envio = document.getElementById("envio");

        formulario.addEventListener("submit", e => {
            e.preventDefault();
            let img = document.getElementById("imagen");
            img.value = urlImagen;
            formulario.submit();

        });
    </script>
    <script type="application/javascript" src="https://api.ipify.org?format=jsonp&callback=getIP"></script>

</html>