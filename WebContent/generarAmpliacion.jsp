<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
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

    <jsp:include page="navbar.jsp"></jsp:include>

    <div class="uk-block uk-block-muted">

      <div class="uk-container uk-margin-left uk-margin">
        <h3 class="uk-h2">Generar Ampliacion</h3>
        <p class="uk-text-muted uk-text-slim">
          Expediente: ####<br>
          Tramite : ####
        </p>
      </div>

      <div class="uk-container uk-container-center">
        <div class="uk-width-large-9-10 uk-container-center">

          <div class="uk-grid uk-flex-center" data-uk-grid-margin>

            <!-- Primera columna -->
            <div class="uk-width-small-4-5 uk-width-medium-1-2" data-uk-margin>
              <div class="uk-flex">
                <div class="uk-margin-left">
                  <button class="uk-button uk-button-large uk-button-primary" data-uk-modal="{target:'#modal'}">Añadir</button>
                </div>
              </div>
            </div>

            <!-- Segunda columna -->
            <div class="uk-width-small-4-5 uk-width-medium-1-2">
              <div class="uk-flex uk-margin uk-margin-top uk-margin-left">



              </div>
          </div>

          <div class="uk-width-large-9-10 uk-container">
            <table class="uk-table uk-table-responsive uk-table-hover">
              <thead>
                <tr>
                  <th>Tipo de Documento</th>
                  <th>Nombre de Documento</th>
                  <th>Descripcion</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>Table Data</td>
                  <td>Table Data</td>
                  <td>Table Data</td>
                </tr>
                <tr>
                  <td>Table Data</td>
                  <td>Table Data</td>
                  <td>Table Data</td>
                </tr>
                <tr>
                  <td>Table Data</td>
                  <td>Table Data</td>
                  <td>Table Data</td>
                </tr>
              </tbody>
            </table>

          </div>

        </div>

        <div class="uk-grid uk-flex-center uk-margin-left" data-uk-grid-margin>
          <div class="uk-width-small-4-5 uk-width-medium-1-2" data-uk-margin>
            <button class="uk-button uk-button-large uk-button-success">ENVIAR</button>
          </div>
          <div class="uk-width-small-4-5 uk-width-medium-1-2" data-uk-margin>
            <button class="uk-button uk-button-large uk-button-danger">CANCELAR</button>
          </div>
        </div>
      </div>
    </div>


    <div id="modal" class="uk-modal">
      <div class="uk-modal-dialog">
        <a href="" class="uk-modal-close uk-close"></a>

        <div class="uk-modal-header">
          <h2>Registro de Documentos</h2>
        </div>

        <div class="uk-container">
          <form class="uk-form uk-form-horizontal" action="Expediente"  method="post">
            <input type="hidden" name="metodo" value="registra" >


            <!--Dropdown-->

            <div class="uk-form-row">
               <label class="uk-form-label" for="form-h-s">Tipo Documento</label>
               <div class="uk-form-controls">
                 <input type="text" id="form-h-s" placeholder="Tipo">
               </div>
            </div>

            <div class="uk-form-row">
               <label class="uk-form-label" for="form-h-s">Nombre Documento</label>
               <div class="uk-form-controls">
                 <input type="text" id="form-h-s" placeholder="Nombre">
              </div>
           </div>


          <div class="uk-form-row">
             <label class="uk-form-label" for="form-h-s">Descripcion</label>
             <div class="uk-form-controls">
               <input type="text" id="form-h-s" placeholder="Descripcion">
            </div>
         </div>


              <div class="uk-form-row uk-text-center">
              <button type="submit" class="uk-button uk-button-primary">Grabar</button>
              </div>
          </form>
        </div>

        <div class="uk-modal-footer uk-text-right">
          <button type="button" class="uk-button uk-modal-close uk-button-danger">Cancelar</button>
        </div>

       </div>
    </div>

  </body>
</html>
