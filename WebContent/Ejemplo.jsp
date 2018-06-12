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
          <h2>CRUD</h2>
        </div>

        <!--Esta es la parte encima de la tabla-->

        <section>
          <div class="uk-block uk-block-muted">
            <div class="uk-container uk-container-center">
              <div class="uk-width-large-9-10 uk-container-center">
                <div class="uk-grid uk-flex-centers" data-uk-grid-margin>

                  <!-- Primera columna -->

                  <div class="uk-width-small-4-5 uk-width-medium-3-4">
                    <div class="uk-flex">
                      <div class="uk-margin uk-margin-left">

                        <!--Esta es la Forma-->

                        <form class="uk-form uk-form-horizontal">

                                <!--Texto-->

                                <div class="uk-form-row">
                                    <label class="uk-form-label" for="form-h-it">Texto</label>
                                    <div class="uk-form-controls">
                                        <input type="text" id="form-h-it" placeholder="Text input">
                                    </div>
                                </div>

                                <!--Contraseñas-->

                                <div class="uk-form-row">
                                    <label class="uk-form-label" for="form-h-ip">Contraseñas</label>
                                    <div class="uk-form-controls">
                                        <input type="password" id="form-h-ip" placeholder="Password input">
                                    </div>
                                </div>

                                <!--Dropdown-->

                                <div class="uk-form-row">
                                    <label class="uk-form-label" for="form-h-s">Dropdown</label>
                                    <div class="uk-form-controls">
                                        <select id="form-h-s">
                                            <option>Option 01</option>
                                            <option>Option 02</option>
                                        </select>
                                    </div>
                                </div>

                                <!--TextoArea-->

                                <div class="uk-form-row">
                                    <label class="uk-form-label" for="form-h-t">Textarea</label>
                                    <div class="uk-form-controls">
                                        <textarea id="form-h-t" cols="30" rows="5" placeholder="Textarea text"></textarea>
                                    </div>
                                </div>

                                <!--Radio-->

                                <div class="uk-form-row">
                                    <span class="uk-form-label">Radio</span>
                                    <div class="uk-form-controls uk-form-controls-text">
                                        <input type="radio" id="form-h-r" name="radio"> <label for="form-h-r">Texto</label><br>
                                        <input type="radio" id="form-h-r1" name="radio"> <label for="form-h-r1">1</label>
                                        <label><input type="radio" name="radio"> 2</label>
                                        <label><input type="radio" name="radio"> 3</label>
                                    </div>
                                </div>

                                <!--Casillas-->

                                <div class="uk-form-row">
                                    <span class="uk-form-label">Checkbox</span>
                                    <div class="uk-form-controls uk-form-controls-text">
                                        <input type="checkbox" id="form-h-c"> <label for="form-h-c">Texto</label><br>
                                        <input type="checkbox" id="form-h-c1"> <label for="form-h-c1">1</label>
                                        <label><input type="checkbox"> 2</label>
                                        <label><input type="checkbox"> 3</label>
                                    </div>
                                </div>

                            </form>
                      </div>
                    </div>
                  </div>

                    <!-- Segunda columna -->
                  <div class="uk-width-small-4-5 uk-width-medium-1-4">
                    <div class="uk-margin uk-margin-left">

                      <!--Boton Standar-->

                      <div class="uk-flex uk-margin-top">
                        <div class="uk-h1 uk-margin-right">
                          <button class="uk-button uk-button-large" type="button">Estandar</button>
                        </div>
                      </div>

                      <!--Boton Azul-->

                      <div class="uk-flex uk-margin-top">
                        <div class="uk-h1 uk-margin-right">
                          <button class="uk-button uk-button-large uk-button-primary" type="button">Azulito</button>
                        </div>
                      </div>

                      <!--Boton Verde-->

                      <div class="uk-flex uk-margin-top">
                        <div class="uk-h1 uk-margin-right">
                          <button class="uk-button uk-button-large uk-button-success" type="button">Verdecito</button>
                        </div>
                      </div>

                      <!--Boton Rojo-->

                      <div class="uk-flex uk-margin-top">
                        <div class="uk-h1 uk-margin-right">
                          <button class="uk-button uk-button-large uk-button-danger" type="button">Rojito</button>
                        </div>
                      </div>

                    </div>
                  </div>

                </div>

                <div class="uk-container uk-margin-top">



                  <table class="uk-table uk-table-responsive uk-table-hover">
                    <thead>
                      <tr>
                        <th>Titulo 1</th>
                        <th>Titulo 2</th>
                        <th>Titulo 3</th>
                        <th>Titulo 4</th>
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
