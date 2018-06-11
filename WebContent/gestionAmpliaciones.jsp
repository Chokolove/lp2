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

    <!-- link all the scripts -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/js/uikit.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/js/components/sticky.js"></script>

  </head>
  <body>

    <nav class="uk-navbar" data-uk-sticky="{ showup: true, animation: 'uk-animation-slide-top', clsactive: 'eb-navbar-active' }">
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
            <a href="#">Gestion de Ampliaciones</a>
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

    <div class="uk-block">

      <div class="uk-container uk-margin">

        <div class="uk-container">
          <h2>Gestion de Ampliaciones</h2>
        </div>

        <section>
          <div class="uk-block uk-block-muted">
            <div class="uk-container uk-container-center">
              <div class="uk-width-large-9-10 uk-container-center">
                <div class="uk-grid uk-flex-centers" data-uk-grid-margin>

                  <!-- Primera columna -->
                  <div class="uk-width-small-4-5 uk-width-medium-1-2" data-uk-margin>
                    <div class="uk-flex">
                      <div class="uk-margin uk-margin-left">
                        <input name="entidad" type="text" class="uk-margin-left uk-width-1-1 uk-form-large" placeholder="Entidad">
                      </div>
                    </div>
                  </div>

                    <!-- Segunda columna -->
                  <div class="uk-width-small-4-5 uk-width-medium-1-2">
                    <div class="uk-margin uk-margin-left">

                      <div class="uk-button-dropdown" data-uk-dropdown>
                        <button class="uk-button">Ordenar por Estado</button>
                        <div class="uk-dropdown uk-dropdown-small">
                          <ul class="uk-nav uk-nav-dropdown">
                            <li><a href="">Tipo A</a></li>
                            <li><a href="">Tipo B</a></li>
                            <li><a href="">Tipo C</a></li>
                          </ul>
                        </div>
                      </div>

                    </div>
                  </div>

                </div>

                <div class="uk-container uk-margin-top">



                  <table class="uk-table uk-table-responsive uk-table-hover">
                    <thead>
                      <tr>
                        <th>Numero de Expediente</th>
                        <th>Entidad</th>
                        <th>Fecha de Vencimiento</th>
                        <th>Estado</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                              <td>Table Data</td>
                              <td>Table Data</td>
                              <td>Table Data</td>
                              <td>Table Data</td>
                      </tr>
                          <tr>
                              <td>Table Data</td>
                              <td>Table Data</td>
                              <td>Table Data</td>
                              <td>Table Data</td>
                          </tr>
                          <tr>
                              <td>Table Data</td>
                              <td>Table Data</td>
                              <td>Table Data</td>
                              <td>Table Data</td>
                          </tr>
                      </tbody>
                  </table>
                </div>
              </div>

            </div>
          </div>
        </section>

      </div>

    </div>

  </body>
</html>
