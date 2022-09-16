<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <title>Iniciar Sesion</title>
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
    .input{
        width: 500px;
        height: 75px;
        border-radius: 20px;
        background-color: rgba(130, 172, 159, .51);
        border: none;
        outline: none;
        font-size: 42px;
        text-align: center;
    }
    #iniciarSesion{
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
 a{
          color: #603B54;  
        }
</style>
<body>
    <div class="m-auto">
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
        <form action ="iniciarSesion" method= "post" id="formulario">
        <div class="mt-5 d-flex flex-column align-items-center">
            <h1 class="mt-5">Nickname o correo</h1>
            <input type="text" name = "nick" id="nick" class="input"/> 
           
            <h1 class="mt-5">Contraseña</h1>
            <input type="password" name = "password" id="password" class="input"/>  

            <button class="mt-5 shadow-lg" id="iniciarSesion" type="submit">Iniciar sesion</button>
        </div>
        </form>
    </div>

</body>

<script type="text/javascript">
    /*let nick = document.getElementById("nick");
    let password = document.getElementById("password");
    let button = document.getElementById("iniciarSesion")
    let bool = true;

    button.addEventListener('submit', (e) => {
        e.preventDefault();
        if(nick.value === ''){
            bool = false
            nick.style.backgroundColor = "red"
        }
        if(password.value === ''){
            bool = false
            password.style.backgroundColor = "red"
        }
        if (bool) {
            form.submit();
        }
    })*/
</script>
</html>
