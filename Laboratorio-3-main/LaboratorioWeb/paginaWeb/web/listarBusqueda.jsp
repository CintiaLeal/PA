<%-- 
    Document   : listarBusqueda
    Created on : 13/10/2021, 05:37:28 PM
    Author     : Administrador
--%>

<%@page import="DataType.DtBusqueda"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busquedas</title>
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

    </style>
    <body>
        <div id="logo" class="p-2 m-4">
            <a href="menuArtista.jsp"><b>CoronaTickets.uy</b> </a>
        </div>
        <form action="listaBusqueda" method= "POST" id="formulario">
            <div id="lista">
                <%  List<DtBusqueda> listaP = (List<DtBusqueda>) request.getAttribute("list");%>                   
                <% for (Integer i = 0; i < listaP.size(); i++) {%>                        
                <input value="<%=listaP.get(i).getNombre()%>" readonly="true"  class="nombre"/>
                <input value="<%=listaP.get(i).getFecha()%>" class=" fecha d-none">
                <% for (Integer k = 0; k < listaP.get(i).getCategorias().size(); k++) {%>  
                <input value="<%=listaP.get(i).getCategorias().get(k)%>" readonly="true"  class="d-none categorias <%=listaP.get(i).getNombre()%>"/>
                <% } //Cerrar FOR %>
                <% for (Integer l = 0; l < listaP.get(i).getPlataformas().size(); l++) {%>  
                <input value="<%=listaP.get(i).getPlataformas().get(l)%>" readonly="true"  class="d-none plataformas <%=listaP.get(i).getNombre()%>"/>
                <% } //Cerrar FOR %>
                <% } //Cerrar FOR %>
            </div> 
            <div class="mt-5 d-flex flex-column align-items-center"> 
                <h2>Ordenar</h2>
            </div>  
            <div>
                <div class="col-6 d-flex justify-content-end"> 
                    <select id="sel" name="sel" class="col-5 input-group-text">
                        <option>
                            NOMBRE
                        </option>
                        <option>
                            FECHA
                        </option>
                        <option>
                            NINGUNO
                        </option>
                        <option>
                            CATEGORIA
                        </option>

                        <option>
                            PLATAFORMA
                        </option>
                    </select> 
                    <div class="col-6 d-flex justify-content-end">     
                        <button  name="aceptar" id="aceptar" type="submit"  style="background-color: #82D4BB; color: black;"class="btn"><b>Filtrar</b></button>
                    </div>   
                </div>
                <h2>Filtrar Categoria</h2>
                <input name="envio" id="envio" class="d-none"/>
                <select  id="categoriaSeleccionada" name="cat" class="col-5 input-group-text" required >
                    <%  List<String> listaC = (List<String>) request.getAttribute("listaCategoria");%>
                    <% for (Integer c = 0; c < listaC.size(); c++) {%>
                    <option value="<%=listaC.get(c)%>">
                        <%=listaC.get(c)%>
                    </option>
                    <% } //Cerrar FOR %>
                </select>                   
                <h2>Filtrar Plataforma</h2>
                <select  id="plataformaSeleccionada" name="pla" class="col-5 input-group-text" required >
                    <%  List<String> listaPl = (List<String>) request.getAttribute("listaPlataforma");%>
                    <% for (Integer l = 0; l < listaPl.size(); l++) {%>
                    <option value="<%=listaPl.get(l)%>">
                        <%=listaPl.get(l)%>
                    </option>
                    <% } //Cerrar FOR %>
                </select>
            </div>  
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

//   USO EXCLUSIVO DE FILTRO //
    let aceptar = document.getElementById("aceptar");
    let elemento = document.getElementsByClassName("elem");
    let sel = document.getElementById("sel");
    let busqueda = document.getElementsByClassName("busqueda");
    let nombre = document.getElementsByClassName("nombre");
    let fecha = document.getElementsByClassName("fecha");
    let catDeUnElem = document.getElementsByClassName("categorias");
    let categoriaSeleccionada = document.getElementById("categoriaSeleccionada")
    let platDeUnElem = document.getElementsByClassName("plataformas");
    let plataformaSeleccionada = document.getElementById("plataformaSeleccionada")
   
    aceptar.addEventListener("click", e => {
        e.preventDefault();
        let arrCategorias = []
        let arrPlataformas = []
        for (let i in catDeUnElem) {
            arrCategorias.push({categoria: catDeUnElem[i].value, padre: catDeUnElem[i].className})
        }
        for (let i in platDeUnElem) {
            arrPlataformas.push({plataforma: platDeUnElem[i].value, padre: platDeUnElem[i].className})
        }
        console.log(sel.value);
        let aux = [];
        let ordenarNombre = [];
        let ordenarFecha = [];
        let filtrarCategoria = [];
        let filtrarPlataforma = [];
        for (let i in nombre) {
            if (nombre[i].value != undefined) {
                let comparar = "d-none categorias " + nombre[i].value;
                let compararPlat = "d-none plataformas " + nombre[i].value;
                let arrAux = [];
                for (let i in arrCategorias) {
                    if (arrCategorias[i].padre != undefined) {
                        if (arrCategorias[i].padre === comparar) {
                            arrAux.push(arrCategorias[i].categoria)
                        }
                    }
                }
                let arrAux2 = [];
                for (let i in arrPlataformas) {
                    if (arrPlataformas[i].padre != undefined) {
                        if (arrPlataformas[i].padre === compararPlat) {
                            arrAux2.push(arrPlataformas[i].plataforma)
                        }
                    }
                }
                aux.push({
                    upperCase: nombre[i].value.toUpperCase(),
                    originName: nombre[i].value,
                    fecha: fecha[i].value,
                    categorias: arrAux,
                    plataformas: arrAux2
                })
                ordenarNombre.push(nombre[i].value.toUpperCase())
                ordenarFecha.push(fecha[i].value)
                filtrarCategoria.push({
                    upperCase: nombre[i].value.toUpperCase(),
                    originName: nombre[i].value,
                    fecha: fecha[i].value,
                    categorias: arrAux
                })
                filtrarPlataforma.push({
                    upperCase: nombre[i].value.toUpperCase(),
                    originName: nombre[i].value,
                    fecha: fecha[i].value,
                    plataformas: arrAux2
                })
            }
        }
        ordenarNombre = ordenarNombre.sort();
        ordenarFecha = ordenarFecha.sort();
        if (sel.value === "NOMBRE") {
            for (let i in ordenarNombre) {
                let a = aux.find(elem => elem.upperCase == ordenarNombre[i])
                nombre[i].value = a.originName
                fecha[i].value = a.fecha
            }
        } else if (sel.value === "FECHA") {

            for (let i in ordenarFecha) {
                let a = aux.find(elem => elem.fecha == ordenarFecha[i])
                nombre[i].value = a.originName
                fecha[i].value = a.fecha
            }
        } else if (sel.value === "NINGUNO") {
            for (let i in nombre) {
                nombre[i].style = "block"
            }
        } else if (sel.value === "CATEGORIA") {
            console.log(filtrarCategoria);
            let oculto = [];
            for (let i in filtrarCategoria) {
                let existe = false;
                for (let n in filtrarCategoria[i].categorias) {
                    if (filtrarCategoria[i].categorias[n] === categoriaSeleccionada.value) {
                        console.log(filtrarCategoria[i]);
                        existe = true;
                    }
                }
                if (!existe) {

                    for (let m in nombre) {
                        if (nombre[m].value === filtrarCategoria[i].originName) {
                            nombre[m].style.display = "none"
                            oculto.push(m);
                        }
                    }


                }
                console.log(oculto)
                for (let i in nombre) {
                    let noMostrar = false;
                    for (let m in oculto) {
                        if (oculto[m] == i)
                            noMostrar = true
                    }
                    if (!noMostrar) {
                        if (typeof (nombre[i]) == 'object')
                            nombre[i].style.display = "block"
                    }
                }
            }

        } else if (sel.value === "PLATAFORMA") {
            console.log("emtra")
            let oculto = [];
            for (let i in filtrarPlataforma) {
                let existe = false;
                console.log("entra")
                for (let n in filtrarPlataforma[i].plataformas) {
                    console.log(filtrarPlataforma[i].plataformas[n])
                    console.log(plataformaSeleccionada.value)
                    if (filtrarPlataforma[i].plataformas[n] === plataformaSeleccionada.value) {
                        console.log(filtrarPlataforma[i]);
                        existe = true;
                    }
                }
                if (!existe) {

                    for (let m in nombre) {
                        if (nombre[m].value === filtrarPlataforma[i].originName) {
                            nombre[m].style.display = "none"
                            oculto.push(m);
                        }
                    }


                }
                console.log(oculto)
                for (let i in nombre) {
                    let noMostrar = false;
                    for (let m in oculto) {
                        if (oculto[m] == i)
                            noMostrar = true
                    }
                    if (!noMostrar) {
                        if (typeof (nombre[i]) == 'object')
                            nombre[i].style.display = "block"
                    }
                }
            }

        }
    });
//    let mostrar = document.getElementById("busqueda");
//
//
//    let envio = document.getElementById("envio");
//    var ret = "";
//    //para boton seleccionar categoria
//    let selCat = document.getElementById("selCat");
//    selCat.addEventListener("click", e => {
//        e.preventDefault();
//        envio.value = 1;
//        formulario.submit();
//    });
//    //para boton seleccionar plataforma
//    let selPla = document.getElementById("selPla");
//    selPla.addEventListener("click", e => {
//        e.preventDefault();
//        envio.value = 2;
//        formulario.submit();
//    });
</script>
<script type="application/javascript" src="https://api.ipify.org?format=jsonp&callback=getIP"></script>
</html>