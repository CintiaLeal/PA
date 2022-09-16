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
    <title>JSP Page</title>
</head>
<body style="background-color: #eee;" class="d-flex justify-content-center align-items-center">
    <jsp:include page = "navbar.jsp" />
    <form action="iniciarSesion" class="form-signin">
        <h1 class="h3 mb-3 font-weight-normal text-center">Iniciar sesion</h1>
        <label for="inputEmail" class="sr-only">Email o nickname</label>
        <input type="text" id="inputEmail" class="form-control my-2" placeholder="Email o nickname" required="" autofocus="">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
        <button class="btn btn-lg mt-3 btn-primary btn-block" type="submit">Iniciar sesion</button>
        <!--AGENTE-->
<!--        <input id="AgenteNavegador" name="AgenteNavegador" class="d-none">
        <input id="AgentePlataforma" name="AgentePlataforma" class="d-none">
        <input id="AgenteUrl" name="AgenteUrl" class="d-none">-->
        <!--AGENTE-->
      </form>
</body>

<script type="text/javascript">
//   USO EXCLUSIVO DE FILTRO //
//    let userAgentData = navigator.userAgentData
//    let AgentePlataforma = userAgentData.platform;
//    let AgenteNavegador = userAgentData.brands[0].brand;
//    let AgenteUrl = location.href;
//    document.getElementById("AgenteNavegador").value = AgenteNavegador
//    document.getElementById("AgentePlataforma").value = AgentePlataforma
//    document.getElementById("AgenteUrl").value = AgenteUrl
//   USO EXCLUSIVO DE FILTRO //
</script>

</html>


