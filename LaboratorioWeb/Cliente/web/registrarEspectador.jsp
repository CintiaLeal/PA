<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro</title>
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
        a{
            color: #603B54;  
        }
        .input{
            width: 300px;
            height: 45px;
            margin-bottom: 25px;
            border-radius: 20px;
            background-color: rgba(130, 172, 159, .51);
            border: none;
            outline: none;
            /* font-size: 42px; */
            text-align: center;
        }
        #file-upload-button{
            background-color: red; 
        }
        .btnRegistro{
            background-color: rgba(148, 119, 139, .51);
            border-radius: 5px;
            border: none;
            width: 300px;
            height: 75px;
            font-size: 24px;
        }

        #iniciarSesion:hover{
            background-color: rgba(148, 119, 139, 1);
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
        <form action = "registroE" method= "post" id="form" class="m-auto">
            <div class="row">
                <div class="col-6 d-flex flex-column align-items-end container">
                    <div class="text-center">
                        <h1 class="">Nickname</h1>
                        <input type="text" name="nick" id="nick" class="input"/>
                    </div>
                </div>
                <div class="col-6 d-flex flex-column justify-content-center align-items-start container">
                    <div class="text-center">
                        <h1 class="">Nombre</h1>
                        <input type="text" name="nombre" id="nombre" class="input"/>
                    </div>
                </div>
                <div class="col-6 d-flex flex-column justify-content-center align-items-end container">
                    <div class="text-center">
                        <h1 class="">Apellido</h1>
                        <input type="text" name="apellido" id="apellido" class="input"/>
                    </div>
                </div>
                <div class="col-6 d-flex flex-column justify-content-center align-items-start container">
                    <div class="text-center">
                        <h1 class="">Email</h1>
                        <input type="text" name="email" id="email" type="email" class="input"/>
                    </div>
                </div>
                <div class="col-6 d-flex flex-column justify-content-center align-items-end container">
                    <div class="text-center">
                        <h1 class="">Contraseña</h1>
                        <input type="password" name="password" id="password" class="input"/>
                    </div>
                </div>
                <div class="col-6 d-flex flex-column justify-content-center align-items-start container">
                    <div class="text-center">
                        <h1 class="">Confirmar contraseña</h1>
                        <input type="password" name="repeatPassword" id="repeatPassword" class="input"/>
                    </div>
                </div>

                <div class="col-6 d-flex flex-column justify-content-center align-items-start container">
                    <div class="text-center">
                        <h1>Fecha de Nacimiento</h1>
                        <input type="date" name = "fecha" id="fecha" class ="input"/>
                    </div>
                </div>

                <div class="col-12 d-flex justify-content-center file">
                    <button  type="button" class="file-select btn" id="btn">
                        Agregar imagen

                    </button>
                    <input name="imagen" id="imagen" class="d-none" />
                </div>

                <div class="col-12 d-flex flex-column align-items-center">
                    <button class="mt-5 shadow-lg btnRegistro" id="registrarEspectador" type="submit">Registrar espectador</button>
                    <h1 class="mt-2">O</h1>
                    <a href="registrarArtista.jsp"><button class="mt-2 shadow-lg btnRegistro" id="registrarArtista" type="button">Registrar artista</button></a>
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


        let form = document.getElementById("form")
        let nick = document.getElementById("nick");
        let nombre = document.getElementById("nombre");
        let apellido = document.getElementById("apellido");
        let email = document.getElementById("email");
        let password = document.getElementById("password");
        let repeatPassword = document.getElementById("repeatPassword");
        let file = document.getElementById("files"); //Se guarda la foto que quiere subir

        let bool = true;

        form.addEventListener('submit', (e) => {
            e.preventDefault();
            bool = true;
            if (nick.value === "") {
                nick.style.backgroundColor = "#D48282";
                bool = false;

            } else {
                nick.style.backgroundColor = "rgba(130, 172, 159, .51)";
            }
            if (nombre.value === "") {
                nombre.style.backgroundColor = "#D48282";
                bool = false;
            } else {
                nombre.style.backgroundColor = "rgba(130, 172, 159, .51)";
            }
            if (apellido.value === "") {
                apellido.style.backgroundColor = "#D48282";
                bool = false;
            } else {
                apellido.style.backgroundColor = "rgba(130, 172, 159, .51)";
            }
            if (email.value === "") {
                email.style.backgroundColor = "#D48282";
                bool = false;
            } else {
                email.style.backgroundColor = "rgba(130, 172, 159, .51)";
            }
            if (password.value === "") {
                password.style.backgroundColor = "#D48282";
                bool = false;
            } else {
                password.style.backgroundColor = "rgba(130, 172, 159, .51)";
            }
            if (repeatPassword.value === "" || repeatPassword.value != password.value) {
                repeatPassword.style.backgroundColor = "#D48282";
                bool = false;
            } else {
                repeatPassword.style.backgroundColor = "rgba(130, 172, 159, .51)";
            }
            if (bool) {
                imagen.value = urlImagen
                form.submit();
            }
        })
    </script>
</html>
