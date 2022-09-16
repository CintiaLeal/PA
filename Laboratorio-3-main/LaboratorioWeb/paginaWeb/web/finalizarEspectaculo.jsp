<%-- 
    Document   : finalizarEspectaculo
    Created on : 28/10/2021, 11:04:00 AM
    Author     : romil
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finalizar Espectaculo</title>
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
        #noMostrar{
            color:rgba(130, 172, 159, .0);
        }
    </style>

    <body class="pb-5">
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
        <div class="row m-0 d-flex justify-content-center">

            <div class="col-12 d-flex justify-content-center mb-4"><h1>Finalizar Espectaculos</h1></div>
            <form action="finalizarEspectaculo" method= "post" id="formulario">
                <input name="envio" id="envio" class="d-none"/>
                <div class="col-11 row my-2 ">
                    <select  id="esp" name="esp" class="col-8 input-group-text">
                       <%  List<String> listaE = (List<String>) request.getAttribute("listaEspectaculosAceptados");%>
                       <% for (Integer e = 0; e < listaE.size(); e++) {%>
                            <option value="<%=listaE.get(e)%>">
                                <%=listaE.get(e)%>
                            </option>
                       <% } //Cerrar FOR %>
                    </select>
                    <div class="col-4 d-flex justify-content-center">

                        <button id="selEsp" name="selEsp" style="width: 300px;text-align: center;border-radius: 5px; background-color: rgba(148, 119, 139, .51);">Seleccionar</button>
                    </div>
                </div>

                <div class="col-11 row my-2 ">
                    <div class="col-5">
                        <img class="col-12"
                            src = "${imagen}" />
                    </div>
                    <div class="col-8 row">
                        <div class="col-4 d-flex flex-column">
                            <label><b>Nombre</b></label>
                            <div class="input-group-text"> <label>${nombre} </label></div>                            
                        </div>   
                    </div>
                </div>
                <div class="col-4 d-flex justify-content-center">
                    <button id="finalizar"  name="finalizar" style="width: 300px;text-align: center;border-radius: 5px; background-color: rgba(148, 119, 139, .51);">Finalizar</button>
                </div>

        </div>
    </form>

</body>

<script type="text/javascript">
    let form = document.getElementById("formulario");
    let envio = document.getElementById("envio");
    let selEsp = document.getElementById("selEsp");
    selEsp.addEventListener("click", e => {
        e.preventDefault();
        envio.value = "1";
        form.submit();
    });
    let finalizar = document.getElementById("finalizar");
    finalizar.addEventListener("click", e =>{
        e.preventDefault();
        envio.value = "2";
        form.submit();
    });
</script>

</html>