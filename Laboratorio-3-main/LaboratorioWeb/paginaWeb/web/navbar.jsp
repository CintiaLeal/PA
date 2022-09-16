<head>
    <title>TODO supply a title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body class="bg-light">
    <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container-fluid justify-content-center">
            <div class="d-flex justify-content-center align-items-center">
                <a style="font-size: 18px;" class="navbar-brand" href="#">CoronaTicket</a>
                <span style="font-size: 18px;">Bienvenido usuario</span>
            </div>
            
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <form id="formNavbar" action="navbar" class="navbar-nav">
                <input id="envioNav" name="envio" class="d-none"/>
                <a class="nav-link active" aria-current="page" href="menuMobile.jsp">Home</a>
                <a class="nav-link" href="indexMobile.jsp">Iniciar sesion</a>
                <a class="nav-link" ><div class="nav-link" id="CerrarSesion" type="button">Cerrar sesion</div></a>
                <a class="nav-link" ><div class="nav-link" id="espectaculo" type="button">Consultar Espectaculo</div></a>
                <a class="nav-link" ><div id="funcion" type="button">Consultar Funcion</div></a>
                <!--<a class="nav-link" href="consultarEspectaculoMobile.jsp">-->
                <!--<a class="nav-link" href="consultarFuncionMobile.jsp">Consultar Funcion</a>-->
              
            </form>
          </div>
        </div>
    </nav>
</body>

<!-- BOOSTRAP -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
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
            for (let i = 0; i < arrIp.length; i++) {
                arrIp[i].value = ip;
                arrSO[i].value = ua.platform;
                arrNavegador[i].value = ua.brands[0].brand;
                arrUrl[i].value = location.href;
            }
        }

//   USO EXCLUSIVO DE FILTRO //
    let formNavbar = document.getElementById("formNavbar");
    document.getElementById("espectaculo").addEventListener("click", e => {
        e.preventDefault();
        document.getElementById("envioNav").value= 1;
        formNavbar.submit()
        
    })
    document.getElementById("funcion").addEventListener("click", e => {
        e.preventDefault();
        document.getElementById("envioNav").value= 2;
        formNavbar.submit()
    })
    document.getElementById("CerrarSesion").addEventListener("click", e => {
        e.preventDefault();
        document.getElementById("envioNav").value= 3;
        formNavbar.submit()
    })
    
    </script>
    <script type="application/javascript" src="https://api.ipify.org?format=jsonp&callback=getIP"></script>