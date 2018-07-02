<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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

    <jsp:include page="navbar.jsp"></jsp:include>

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
        
        <section class="expediente">
	        <div class="uk-block uk-block-muted">
		
		      <div class="uk-container uk-margin-left uk-margin">
		        <h3 class="uk-h2">Gestion de Ampliaciones</h3>
		        <p class="uk-text-muted uk-text-slim">
		          Entidad: Lorem<br>
		          Expediente: ####
		        </p>
		      </div>
		
		      <div class="uk-container uk-container-center">
		        <div class="uk-width-large-9-10 uk-container-center">
		          <table class="uk-table uk-table-justify uk-table-hover">
		            <thead>
		                <tr>
		                    <th>Numero de Documento</th>
		                    <th>Nombre de Documento</th>
		                    <th>Descripcion</th>
		                </tr>
		            </thead>
		            <tbody>
		                <tr>
		                    <td>99999999</td>
		                    <td>Table Data</td>
		                    <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</td>
		                </tr>
		                <tr>
		                    <td>99999999</td>
		                    <td>Table Data</td>
		                    <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</td>
		                </tr>
		                <tr>
		                    <td>99999999</td>
		                    <td>Table Data</td>
		                    <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</td>
		                </tr>
		            </tbody>
		          </table>
		        </div>
		
		        <div class="uk-grid uk-flex-center uk-margin-left" data-uk-grid-margin>
		          <div class="uk-width-small-4-5 uk-width-medium-1-2" data-uk-margin>
		            <button class="uk-button uk-button-large">APROBAR</button>
		          </div>
		          <div class="uk-width-small-4-5 uk-width-medium-1-2" data-uk-margin>
		            <button class="uk-button uk-button-large">SOLICITAR MAS DOCUMENTOS</button>
		          </div>
		        </div>
		      </div>
		    </div>
        </section>

      </div>

    </div>

  </body>
</html>
