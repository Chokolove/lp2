<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>ANSC</title>

    <!-- link all the styles -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/css/uikit.gradient.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/css/components/sticky.gradient.css">
    <link rel="stylesheet" href="assets/css/master.css">

    <!-- link all the scripts -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/js/uikit.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/js/components/sticky.js"></script>
	<script src="assets/js/myScripts.js"></script>

  </head>
  <body>

    <nav class="uk-navbar navbarStick" data-uk-sticky="{ showup: true, animation: 'uk-animation-slide-top', clsactive: 'eb-navbar-active' }">
      <ul class="uk-navbar-nav">
        <li class=""><a href="#offcanvas" data-uk-offcanvas="{mode:'slide'}">&#9776;</a></li>
        <div class="uk-navbar-content">
          Panchita Juliana
        </div>
      </ul>
      <div class="uk-navbar-flip">
        <ul class="uk-navbar-nav">
          <div class="uk-navbar-content">
            InsertarHora
          </div>
          <li><a href=""><i class="uk-icon-power-off"></i></a></li>
        </ul>
      </div>
    </nav>

    <div id="offcanvas" class="uk-offcanvas">
      <div class="uk-offcanvas-bar">
        <div class="uk-panel">
          <h3 class="uk-panel-title">Panchita Juliana</h3>
        </div>
        <ul class="uk-nav uk-nav-offcanvas uk-nav-parent-icon" data-uk-nav>
          <li>
            <a href="index.jsp">Main</a>
          </li>
          <li>
            <a href="gestionAmpliaciones.jsp">Gestion de Ampliaciones</a>
          </li>
           <li>
            <a href="Expediente?metodo=lista&filtro=">Expediente CRUD</a>
          </li>
           <li>
            <a href="Documento?metodo=lista&filtro=">Documento CRUD</a>
          </li>
          <li class="uk-parent">
            <a href="#">Reportes</a>
            <ul class="uk-nav-sub">
              <li><a href="">ejemplo1</a></li>
              <li><a href="">ejemplo2</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>

    <div class="uk-container uk-flex uk-flex-center uk-margin-top uk-align-center">
      <img src="assets/images/back1.PNG" alt="">
    </div>

  </body>
</html>
