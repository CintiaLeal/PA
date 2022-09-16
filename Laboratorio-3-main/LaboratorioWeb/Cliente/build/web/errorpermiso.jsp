
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            font-size: 82px;
            text-decoration: underline;
            font-family: Arial;
        }
        h2{
            font-size: 52px;
            font-family: Arial;

        }
        .file-select {
            position: relative;
            display: inline-block;
        }

        .file-select::before {
            background-color: rgba(130, 146, 152, .51);
            color: black;
            display: flex;
            justify-content: center;
            align-items: center;
            border-radius: 3px;
            content: 'Imagen'; /* testo por defecto */
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
        .button {
            border: none;
            color: black;
            padding: 10px;
            text-align: center;
            font-family: Arial;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 5px 1px;
            cursor: pointer;


        }

        .button1 {border-radius: 12px;  background-color: rgba(130, 172, 159, .51);} 
        .button2 {border-radius: 12px;  background-color: rgba(130, 146, 152, .51); }

    </style>

    <body>
        <div id="logo" class="p-2 m-4">
        <a href="index.jsp">  <b>CoronaTickets.uy</b> </a>
    </div>
        <form id="form" action="exito" method="post">
    <div class="row d-flex flex-column align-items-center">
        <h1 id="titulo">Error</h1>
    </div>
    <div class="row d-flex flex-column align-items-center">
        <h2>Usted no tiene permiso para realizar esta operación</h2>
    </div>
    <div class="row d-flex flex-column align-items-center">
        <a href="index.jsp"><button type="submit" class="button button1"><b>Volver al inicio</b></button></a>
    </div>
        </form>
</body>
</html>
