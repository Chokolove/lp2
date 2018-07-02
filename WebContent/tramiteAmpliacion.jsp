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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/css/uikit.gradient.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/css/components/sticky.gradient.css">

<!-- link all the scripts -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/js/uikit.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/js/components/sticky.js"></script>

</head>
<body>

	<jsp:include page="navbar.jsp"></jsp:include>
	<sql:setDataSource var="documentos" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost/bd_proyecto" user="root" password="mysql" />
	<sql:query dataSource="${documentos}" var="result">
            SELECT * FROM documento where idTramite = ${param.id};
    </sql:query>

	<div class="uk-block uk-block-muted">

		<div class="uk-grid uk-flex-centers" data-uk-grid-margin>

			<!-- Primera columna -->
			<div class="uk-width-small-4-5 uk-width-medium-1-2" data-uk-margin>
				<div class="uk-container uk-margin-left uk-margin">
					<h3 class="uk-h2">Gestion de Ampliaciones</h3>
					<p class="uk-text-muted uk-text-slim">Tramite : ${param.id}</p>
				</div>
			</div>

			<!-- Segunda columna -->
			<div class="uk-width-small-4-5 uk-width-medium-1-2">
				<div class="uk-flex uk-margin uk-margin-top uk-margin-left">
					<form id="idFormCons" action="Expediente" method="post">
					<input type="hidden" name="metodo" value="lista">
					 <input
						type="hidden" id="idExpe" name="id">
					<button onclick="ConsulExpe('${param.id}');" class="uk-button uk-button-large uk-button-primary">Consultar
						Expediente</button>
					
					</form>
					


				</div>
			</div>

		</div>



		<div class="uk-container uk-container-center">
			<div class="uk-width-large-9-10 uk-container-center">
				<table class="uk-table uk-table-justify uk-table-hover">
					<thead>
						<tr>
							<th>Numero de Documento</th>
							<th>Descripcion</th>
							<th>Descripcion</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="row" items="${result.rows}">
							<tr>
								<td><c:out value="${row.idDoc}" /></td>
								<td><c:out value="${row.descripcion} " /></td>
								<td><c:out value="${row.link} " /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div class="uk-grid uk-flex-center uk-margin-left"
				data-uk-grid-margin>
				<div class="uk-width-small-4-5 uk-width-medium-1-3" data-uk-margin>
					<button class="uk-button uk-button-large uk-button-success">Actualizar
						SCI</button>
				</div>
				<div class="uk-width-small-4-5 uk-width-medium-1-3" data-uk-margin>
					<a href="generarAmpliacion.jsp" class="uk-button uk-button-large">Solicitar mas
						Documentos</a>
				</div>
				<div class="uk-width-small-4-5 uk-width-medium-1-3" data-uk-margin>
					<a href="gestionAmpliaciones.jsp" class="uk-button uk-button-large uk-button-danger">Regresar</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
