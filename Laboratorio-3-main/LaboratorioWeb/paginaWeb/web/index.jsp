<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CoronaTickets</title>
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
        <form id="form" action="index">
            <input id="agente" name="agente" class="d-none">
            
        </form>

    </body>  

    <script type="text/javascript">
        let form = document.getElementById("form");
        let vari = document.getElementById("agente");
            if(navigator.userAgentData.platform === 'Windows' || navigator.userAgentData.platform === 'MacOS' || navigator.userAgentData.platform === 'Ubuntu')
                 vari.value = "desktop";
            else
                vari.value = "mobile";
        form.submit();
    </script>
</html>