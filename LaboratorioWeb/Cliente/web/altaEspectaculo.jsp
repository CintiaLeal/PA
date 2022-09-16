<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Alta Espectaculo</title>
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
        a{
            color: #603B54;  
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
    </style>
    <body>
        <div id="logo" class="p-2 m-4">
            <a href="menuArtista.jsp"><b>CoronaTickets.uy</b> </a>
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
        <form action="altaEspectaculo" method= "post" id="form" class="d-flex flex-column align-items-center">
            <div class="row m-0 d-flex justify-content-center">
                <div class="col-12 d-flex justify-content-center mt-2 mb-4"><h1>Crear Espectaculo</h1></div>

                <div class="col-11 row my-1">
                    <select  id="pla" name="pla" class="form-control input-group-text col-11 " required >
                        <%  List<String> lista = (List<String>) request.getAttribute("listaPlataforma");%>
                        <% for (Integer i = 0; i < lista.size(); i++) {%>
                        <option value="<%=lista.get(i)%>">
                            <%=lista.get(i)%>
                        </option>
                        <% } //Cerrar FOR %>   
                    </select>

                </div>
                <div class="col-11 row my-1 ">
                    <div class="col-5 d-flex flex-column">
                        <label class="">Nombre</label>
                        <input type="text" name="nombre" id="nombre" class="input-group-text" />
                    </div>

                    <div class="col-6 d-flex flex-column">
                        <label>Descripcion</label>
                        <input type="text" name="descripcion" id="descripcion"class="input-group-text" />
                    </div>
                </div>

                <div class="col-11 row my-1 ">
                    <div class="col-3 d-flex flex-column">
                        <label>Duracion</label>
                        <input type="text" name="duracion" id="duracion" class="input-group-text" />
                    </div>
                    <div class="col-3 d-flex flex-column">
                        <label>Espectadores minimos</label>
                        <input type="text" name="canMin" id="canMin" class="input-group-text" />
                    </div>
                    <div class="col-3 d-flex flex-column">
                        <label>Espectadores maximo</label>
                        <input type="text" name="canMax" id="canMax" class="input-group-text" />
                    </div>
                </div>

                <div class="col-11 row my-1 ">
                    <div class="col-3 d-flex flex-column">
                        <label>Url</label>
                        <input type="text" name="url" id="url" class="input-group-text" />
                    </div>
                    <div class="col-3 d-flex flex-column">
                        <label>Costo</label>
                        <input type="text" name="costo" id="costo" class="input-group-text" />
                    </div>
                    <div class="col-3 d-flex flex-column">
                        <label>Cantidad premios</label>
                        <input type="text" name="cant" id="cant" class="input-group-text" />
                    </div>
                    <div class="col-3 d-flex flex-column">
                        <label>Descripcion premio</label>
                        <input type="text" name="descP" id="descP" class="input-group-text" />
                    </div>
                    <div class="col-3 d-flex flex-column">
                        <label>Categoria</label>
                        <input  name="categorias" id="categorias" class="d-none"/>       
                        <select  id="cat" name="cat" class="form-control input-group-text" required >
                            <%  List<String> listaC = (List<String>) request.getAttribute("listaCategoria");%>
                            <% for (Integer e = 0; e < listaC.size(); e++) {%>
                            <option value="<%=listaC.get(e)%>">
                                <%=listaC.get(e)%>
                            </option>
                            <% } //Cerrar FOR %>   
                        </select> 
                    </div>
                    <div class="col-3 d-flex flex-column justify-content-end">
                        <button id="seleccionar" class="btn">Seleccionar</button>
                    </div>
                </div>
                <div class="col-12 d-flex justify-content-center file">
                    <button  type="button" class="file-select btn" id="btn">
                        Agregar imagen
                    </button>
                    <input name="imagen" id="imagen" class="d-none" />
                </div>
                <div class="col-3 d-flex flex-column justify-content-end">
                    <button type="submit" class="btn">Aceptar</button>
                </div>
                <div class="col-3 d-flex flex-column justify-content-end">
                    <a href="menuArtista.jsp"><button type="click" class="btn">Cancelar</button></a>
                </div>
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

        let boton = document.getElementById("seleccionar");
        let select = document.getElementById("cat");
        let arr = [];
        let form = document.getElementById("form");
        let categorias = document.getElementById("categorias");

        boton.addEventListener("click", e => {
            e.preventDefault();
            arr.push(select.value);

            console.log(arr);
        });
        form.addEventListener("submit", e => {
            e.preventDefault();

            const unicos = arr.filter((valor, indice) => {
                return arr.indexOf(valor) === indice;
            }
            );
            categorias.value = unicos;
            let img = document.getElementById("imagen");
            img.value = urlImagen;
            form.submit();

            // console.log(categorias.value);
        });
    </script>


</html>
