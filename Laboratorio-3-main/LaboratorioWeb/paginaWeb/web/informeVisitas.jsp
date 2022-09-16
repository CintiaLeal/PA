<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Logica.ISistema"%>
<%@page import="Logica.Factory"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informes</title>
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
        <%  ISistema sis = Factory.crearSistema();
            List<String> res = sis.listarInforme();
        %>
        <div class="row d-flex flex-column align-items-center">
            <h1 id="titulo">Lista de informes</h1>
        </div>
        <div class="row d-flex flex-column align-items-center">
            <select id="cat" name="cat" class="col-5 input-group-text" required>
                <% List<String> listaC = res;%>
                <% for (Integer c = 0; c < listaC.size(); c++) {%>
                <option value="<%=listaC.get(c)%>">
                    <%=listaC.get(c)%>
                </option>
                <% } //Cerrar FOR %>
            </select>
        </div>
    </body>
</html>
