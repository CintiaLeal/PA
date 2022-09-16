<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Busqueda</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>

<style>
    #logo{
        background-color: rgba(130, 172, 159, .51);
        width: 200px;
        text-align: center;
        color: #603B54;
        border-radius: 20px;
    }
    #buscador{
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
        background-color: rgba(130, 212, 187, .51);
        border-radius: 5px;
        border: none;
        width: 300px;
        height: 50px;
    }
    a{
          color: #603B54;  
        }
    #registrarme{
        background-color: rgba(148, 119, 139, .51);
        border-radius: 5px;
        border: none;
        width: 300px;
        height: 50px;
    }
    #iniciarSesion:hover{
        background-color: rgba(130, 212, 187, .75);
    }
    #registrarme:hover{
        background-color: rgba(148, 119, 139, .75);
    }
</style>
<body>
    <div class="m-auto">
        <div id="logo" class="p-2 m-4">
            <b>CoronaTickets.uy</b>
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
        <div class="mt-5 d-flex flex-column align-items-center">
            <h1>Buscar usuarios</h1>
            <form id="form" action="buscarUsuario" method="POST">
                
                <input placeholder="@example" type="text" name="nick" id="nick"/>
                <button type= "submit" class="mt-5 shadow-lg" id="iniciarSesion">Buscar</button>
            <jsp:include page = "agente.jsp" />
            </form>
        </div>
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
            for(let i = 0; i<arrIp.length; i++){
                arrIp[i].value = ip;
                arrSO[i].value = ua.platform;
                arrNavegador[i].value = ua.brands[0].brand;
                arrUrl[i].value = location.href;
            }
}

//   USO EXCLUSIVO DE FILTRO //
    let v = document.getElementById("nick");
    let form = document.getElementById("form");
    form.addEventListener("submit", e => {
            e.preventDefault();
            form.submit();
        });    
</script>
<script type="application/javascript" src="https://api.ipify.org?format=jsonp&callback=getIP"></script>

</html>
