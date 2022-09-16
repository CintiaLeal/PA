
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@page import="java.util.ArrayList"%>
<html>
    <head>
        <title>Alta de Funcion</title>
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
        a{
            color: #603B54;  
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
            <a href="menuArtista.jsp">  <b>CoronaTickets.uy</b> </a>
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
        <form action="altaFuncion" method= "post" id="formulario">
            <input name="envio" id="envio" class="d-none"/>
            <div class="row m-0 d-flex justify-content-center">

                <div class="col-12 d-flex justify-content-center mb-4"><h1>Crear funcion de espectaculo</h1></div>
                <select  id="pla" name="pla" class="col-5 input-group-text" >
                    <%  List<String> listaP = (List<String>) request.getAttribute("listaPlataforma");%>
                    <% for (Integer p = 0; p < listaP.size(); p++) {%>
                    <option value="<%=listaP.get(p)%>">
                        <%=listaP.get(p)%>
                    </option>
                    <% } //Cerrar FOR %>
                </select>
            </div>

            <div class="mx-5"></div>
            <div class="col-5 d-flex justify-content-center">
                <button id="selPla" type="click" class="col-5 btn rounded">Seleccionar Plataforma</button>

            </div>
            <div class="col-11 row my-2 ">
                <div class="col-10 d-flex flex-column">
                    <lable>Espectaculo:</lable>
                    <select  id="esp" name="esp" class="col-8 input-group-text">
                        <%  List<String> listaE = (List<String>) request.getAttribute("listaEspectaculo");%>
                        <% for (Integer p = 0; p < listaE.size(); p++) {%>
                        <option value="<%=listaE.get(p)%>">
                            <%=listaE.get(p)%>
                        </option>
                        <% } //Cerrar FOR %>
                    </select>
                </div>

            </div>

            <div class="col-11 row my-2 ">
                <div class="col-10 d-flex flex-column">
                    <lable>Nombre:</lable>
                    <input id="nombre" name="nombre" class="col-8 input-group-text" />

                </div>
            </div>

            <div class="col-11 row my-2 ">
                <div class="col-10 row">
                    <div class="col-5">
                        <lable>Fecha:</lable>
                        <input  id="fecha" name="fecha" type="date" class="col-10 input-group-text" />
                    </div>
                    <div class="col-5">
                        <lable>Hora inicio:</lable>
                        <input id="hora" name="hora" class="col-10 input-group-text" />
                    </div>
                </div>
            </div>

            <div class="col-11 row my-2 ">
                <div class="col-3 d-flex flex-column">
                    <label>Artista</label>
                    <input  name="artista" id="artista" class="d-none"/>       
                    <select  id="art" name="art" class="form-control input-group-text" >
                        <%  List<String> listaC = (List<String>) request.getAttribute("listaArtista");%>
                        <% for (Integer e = 0; e < listaC.size(); e++) {%>
                        <option value="<%=listaC.get(e)%>">
                            <%=listaC.get(e)%>
                        </option>
                        <% } //Cerrar FOR %>   
                    </select> 
                </div>
                <div class="col-3 d-flex flex-column justify-content-end">
                    <button id="seleccionar" type="click" class="btn">Seleccionar</button>
                </div>
            </div>
        </div>

        <div class="col-12 d-flex justify-content-center file">
            <button  type="button" class="file-select btn" id="btn">
                Agregar imagen
            </button>
            <input name="imagen" id="imagen" class="d-none" />
        </div>

        <div class="d-flex justify-content-end row">
            <button  type="submit" class="btn col-3">Aceptar</button>
            <a href="menuArtista.jsp"> <button type="click" class="btn col-3 mx-3">Cancelar</button></a>
        </div>
    </form>
</body>
<script src="https://widget.cloudinary.com/v2.0/global/all.js" type="text/javascript"></script>
<script type="text/javascript">
    const btn = document.querySelector("#btn");
    const imagen = document.querySelector("#imagen");
    let urlImagen = ''
    const widget_cloudinary = cloudinary.createUploadWidget({
        cloudName: "dgooa3xoj",
        uploadPreset: "jgpjerdd"
    }, (error, result)=> {
        if(!error && result && result.event === 'success'){
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
    var ret = "";
    let artista = document.getElementById("artista");
    let arr = [];
    let art = document.getElementById("art");
    //para boton seleccionar plataforma
    let selPla = document.getElementById("selPla");
    selPla.addEventListener("click", e => {
        e.preventDefault();
        envio.value = 1;
        
        
        formulario.submit();
    });

    //para boton seleccionar plataforma
    let seleccionar = document.getElementById("seleccionar");
    seleccionar.addEventListener("click", e => {
        e.preventDefault();

        arr.push(art.value);
    });

    formulario.addEventListener("submit", e => {
        e.preventDefault();
        envio.value = 2;
        const unicos = arr.filter((valor, indice) => {
            return arr.indexOf(valor) === indice;
        }
        );
        artista.value = unicos;
        let img = document.getElementById("imagen");
        img.value = urlImagen;
     
        formulario.submit();


    })


</script>

</html>