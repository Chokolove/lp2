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
<link rel="stylesheet" href="assets/css/master.css">

<!-- link all the scripts -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/js/uikit.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/js/components/sticky.js"></script>
<script src="assets/js/myScripts.js"></script>

</head>
<body>

	<jsp:include page="navbar.jsp"></jsp:include>

	<sql:setDataSource var="ampliaciones" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost/bd_proyecto" user="root" password="mysql" />

	<sql:query dataSource="${ampliaciones}" var="result">
            SELECT t.idTramite, tr.Nombre, tr.apePat, t.fchVenc, t.estado FROM tramite t join expediente e on t.NroExpediente = e.NroExpediente
			join trabajador_estatal tr on e.idTrabajador=tr.idTrabajador
			where t.tipo='A';
    </sql:query>
	<sql:query dataSource="${ampliaciones }" var="X">
		SELECT estado FROM tramite;
    </sql:query>



	<div class="uk-block">

		<div class="uk-container uk-margin">

			<div class="uk-container">
				<h2>Gestion de Ampliaciones</h2>
			</div>
			<form id="idFormRev" action="Tramite">
				<input type="hidden" name="metodo" value="lista"> <input
					type="hidden" id="id_rev" name="id">
			</form>
			<section>
				<div class="uk-block uk-block-muted">
					<div class="uk-container uk-container-center">
						<div class="uk-width-large-9-10 uk-container-center">
							<div class="uk-grid uk-flex-centers" data-uk-grid-margin>

								<!-- Primera columna -->
								<div class="uk-width-small-4-5 uk-width-medium-1-2"
									data-uk-margin>
									<div class="uk-flex">
										<div class="uk-margin uk-margin-left">
											<input name="entidad" type="text" id="form-h-it"
												class="uk-margin-left uk-width-1-1 uk-form-large"
												placeholder="Apellido">
										</div>
									</div>
								</div>

								<!-- Segunda columna -->
								<div class="uk-width-small-4-5 uk-width-medium-1-2">
									<div class="uk-margin uk-margin-left"></div>
								</div>

							</div>

							<div class="uk-container uk-margin-top">



								<table id="myTable"
									class="uk-table uk-table-responsive uk-table-hover">
									<thead>
										<tr>
											<th onclick="sortTable(0)">Id Tramite</th>
											<th onclick="sortTable(1)">Nombre</th>
											<th onclick="sortTable(2)">Apellido</th>
											<th onclick="sortTable(3)">Fecha de Vencimiento</th>
											<th onclick="sortTable(4)">Estado</th>
											<th>Revisar</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="row" items="${result.rows}">
											<tr>
												<td><c:out value="${row.idTramite}" /></td>
												<td><c:out value="${row.nombre} " /></td>
												<td><c:out value="${row.apePat} " /></td>
												<td><c:out value="${row.fchVenc}" /></td>
												<td><c:out value="${row.estado}" /></td>
												<td><a href="#" class="uk-button"
													onclick="revisar('${row.idTramite}');"><i
														class="uk-icon-search"></i></a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>

					</div>
				</div>
			</section>

			

		</div>

	</div>
	<script src="assets/js/myScripts.js"></script>
	<script type="text/javascript">
		function sortTable(n) {
			var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
			table = document.getElementById("myTable");
			switching = true;
			// Set the sorting direction to ascending:
			dir = "asc";
			/* Make a loop that will continue until
			no switching has been done: */
			while (switching) {
				// Start by saying: no switching is done:
				switching = false;
				rows = table.getElementsByTagName("TR");
				/* Loop through all table rows (except the
				first, which contains table headers): */
				for (i = 1; i < (rows.length - 1); i++) {
					// Start by saying there should be no switching:
					shouldSwitch = false;
					/* Get the two elements you want to compare,
					one from current row and one from the next: */
					x = rows[i].getElementsByTagName("TD")[n];
					y = rows[i + 1].getElementsByTagName("TD")[n];
					/* Check if the two rows should switch place,
					based on the direction, asc or desc: */
					if (dir == "asc") {
						if (x.innerHTML.toLowerCase() > y.innerHTML
								.toLowerCase()) {
							// If so, mark as a switch and break the loop:
							shouldSwitch = true;
							break;
						}
					} else if (dir == "desc") {
						if (x.innerHTML.toLowerCase() < y.innerHTML
								.toLowerCase()) {
							// If so, mark as a switch and break the loop:
							shouldSwitch = true;
							break;
						}
					}
				}
				if (shouldSwitch) {
					/* If a switch has been marked, make the switch
					and mark that a switch has been done: */
					rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
					switching = true;
					// Each time a switch is done, increase this count by 1:
					switchcount++;
				} else {
					/* If no switching has been done AND the direction is "asc",
					set the direction to "desc" and run the while loop again. */
					if (switchcount == 0 && dir == "asc") {
						dir = "desc";
						switching = true;
					}
				}
			}
		}
	</script>
</body>
</html>
