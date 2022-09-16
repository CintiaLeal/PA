<%-- 
    Document   : indexMobile
    Created on : 02/11/2021, 03:11:37 PM
    Author     : leand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CoronaTickets</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<jsp:include page = "navbar.jsp" />
<body style="background-color: #eee;" class="d-flex justify-content-center align-items-center">
    
    <form action="iniciarSesionMobile" class="form-signin" method="POST">
        <h1 class="h3 mb-3 font-weight-normal text-center">Iniciar sesion</h1>
        <label for="inputEmail" class="sr-only">Email o nickname</label>
        <input type="text" id="inputEmail" class="form-control my-2" placeholder="Email o nickname" name="nick" required="" autofocus="">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required="">
        <button class="btn btn-lg mt-3 btn-primary btn-block" type="submit">Iniciar sesion</button>
        <jsp:include page = "agente.jsp" />
      </form>
    

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

</script>
<script type="application/javascript" src="https://api.ipify.org?format=jsonp&callback=getIP"></script>

    
</html>
