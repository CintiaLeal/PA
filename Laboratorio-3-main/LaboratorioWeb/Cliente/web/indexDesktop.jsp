<%-- 
    Document   : indexDesktop
    Created on : 02/11/2021, 03:12:52 PM
    Author     : leand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <title>JSP Page</title>
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
        .btn{
            background-color: rgba(130, 212, 187, .51);
            border-radius: 5px;
            border: none;
            width: 300px;
            height: 50px;
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
        <div class="mt-5 d-flex flex-column align-items-center">
            <form id="form" action="index" method="post" class="d-flex flex-column align-items-center">
                <input name="envio" id="envio" class="d-none"/>
                <input name="agente" id="agente" class="d-none"/>
                <button type= "submit" class="btn mt-3" id="buscar" name="buscar"><b>Buscar Usuarios</b></button>           
                <button id="iniciarsesion" name="iniciarsesion"  class="btn mt-3"> <b>Iniciar sesion</b></button>
                <button id="registrarme" name="registrarme"  class="btn mt-3"> <b>Registrarme</b></button>
                <button id="consultaEspectaculo" name="consultaEspectaculo"  class="btn mt-3"> <b>Consulta Espectaculo</b></button>
                <button id="consultaPaqueteEspectaculo" name="consultaPaqueteEspectaculo"  class="btn mt-3"><b>Consultar paquete</b></button>
                <button id="consultarFuncion" name="consultarFuncion" class="btn mt-3"><b>Consultar funcion</b></button>
                <!--AGENTE-->
<!--                <input id="AgenteNavegador" name="AgenteNavegador" class="d-none">
                <input id="AgentePlataforma" name="AgentePlataforma" class="d-none">
                <input id="AgenteUrl" name="AgenteUrl" class="d-none">-->
                <!--AGENTE-->
            </form>
        </div>
    </div>
</body>

<script type="text/javascript">
//   USO EXCLUSIVO DE FILTRO //
//    document.getElementById("AgenteNavegador").value = navigator.userAgentData.brands[0].brand;
//    document.getElementById("AgentePlataforma").value = navigator.userAgentData.platform;
//    document.getElementById("AgenteUrl").value = location.href;
//   USO EXCLUSIVO DE FILTRO //

    let formulario = document.getElementById("form");
    let envio = document.getElementById("envio");
    let ag = document.getElementById("agente");
    ag.value = "";
    let buscar = document.getElementById("buscar");
      buscar.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 1;
            formulario.submit();
        });
    
    let iniciarsesion = document.getElementById("iniciarsesion");
      iniciarsesion.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 2;
            formulario.submit();
        });
     let registrarme = document.getElementById("registrarme");
     registrarme.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 9;
            formulario.submit();
        });
    let consultaEspectaculo = document.getElementById("consultaEspectaculo");
      consultaEspectaculo.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 3;
            formulario.submit();
        });
    let consultaPaqueteEspectaculo = document.getElementById("consultaPaqueteEspectaculo");
      consultaPaqueteEspectaculo.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 4;
            formulario.submit();
        });
    let consultarFuncion = document.getElementById("consultarFuncion");
        consultarFuncion.addEventListener("click", e => {
            e.preventDefault();
            envio.value = 5;
            formulario.submit();
        });
</script>

</html>
