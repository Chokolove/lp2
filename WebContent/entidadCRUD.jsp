<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/css/components/form-select.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/css/components/datepicker.css">
<link rel="stylesheet" href="assets/css/master.css">

<!-- link all the scripts -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/js/uikit.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/js/components/datepicker.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/js/components/form-select.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/js/components/sticky.js"></script>


</head>
<body>

	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="uk-block">
		<form id="idFormElimina" action="Entidad">
			<input type="hidden" name="metodo" value="elimina"> <input
				type="hidden" id="id_elimina" name="id">
		</form>

		<div class="uk-container uk-margin">

			<div class="uk-container">
				<h2>Entidad</h2>
			</div>

			<!--Esta es la parte encima de la tabla-->

			<section>
				<div class="uk-block uk-block-muted">
					<div class="uk-container uk-container-center">
						<div class="uk-width-large-9-10 uk-container-center">
							<div class="uk-grid uk-flex-centers" data-uk-grid-margin>

								<!-- Primera columna -->

								<div class="uk-width-small-4-5 uk-width-medium-1-2">
									<div class="uk-flex">
										<div class="uk-margin uk-margin-left">

											<!--Esta es la Forma-->

											<form class="uk-form uk-form-stacked">

												<!--Texto-->

												<div class="uk-form-row">
													<label class="uk-form-label" for="form-h-it">Filtro:
													</label>
													<div class="uk-form-controls">
														<input type="text" id="form-h-it" placeholder="Entidad">
													</div>
												</div>


											</form>
										</div>
									</div>
								</div>

								<!-- Segunda columna -->
								<div class="uk-width-small-4-5 uk-width-medium-1-2">
									<div class="uk-margin uk-margin-left">


										<div class="uk-margin-top">
											<div class="uk-margin-left">
												<button class="uk-button uk-button-large uk-button-primary"
													type="button" data-uk-modal="{target:'#modal'}">Nueva
													Entidad</button>
											</div>
										</div>


									</div>
								</div>

							</div>

							<div class="uk-container uk-margin-top">
								<form action="Entidad">
									<input type="hidden" name="metodo" value="lista">


									<table id="myTable"
										class="uk-table uk-table-responsive uk-table-hover">
										<thead>
											<tr>
												<th onclick="sortTable(0)">Id Entidad</th>
												<th onclick="sortTable(1)">Poder Estatal</th>
												<th onclick="sortTable(2)">Nombre</th>
												<th onclick="sortTable(3)">Sector</th>
												<th onclick="sortTable(4)">Ruc</th>
												<th onclick="sortTable(5)">Direccion</th>
												<th>Editar</th>
												<th>Eliminar</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${Entidad}" var="x">
												<tr>
													<td>${x.idEntidad}</td>
													<td>${x.poderEst}</td>
													<td>${x.nombre}</td>
													<td>${x.sector}</td>
													<td>${x.ruc}</td>
													<td>${x.direccion}</td>
													<td><a href="#" class="uk-button"
														data-uk-modal="{target:'#modal2'}"
														onclick="editarEntidad('${x.idEntidad}','${x.poderEst}','${x.sector}','${x.ruc}','${x.nombre}','${x.direccion}');"><i
															class="uk-icon-pencil"></i></a></td>
													<td><a href="#" class="uk-button"
														onclick="eliminar('${x.idEntidad}');"><i
															class="uk-icon-times-circle"></i></a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</form>
							</div>
						</div>

					</div>
				</div>
			</section>

		</div>

		<div id="modal" class="uk-modal">
			<div class="uk-modal-dialog">
				<a href="" class="uk-modal-close uk-close"></a>

				<div class="uk-modal-header">
					<h2>Registro de Entidad</h2>
				</div>

				<div class="uk-container">
					<form class="uk-form uk-form-horizontal" action="Entidad"
						method="post">
						<input type="hidden" name="metodo" value="registra">


						<div class="uk-form-row">
							<label class="uk-form-label" for="poder_est">Poder
								Estatal</label>
							<div class="uk-form-controls">
								<input type="text" name="poder_est">
							</div>
						</div>

						<div class="uk-form-row">
							<label class="uk-form-label" for="sector">Sector</label>
							<div class="uk-form-controls">
								<input type="text" name="sector">
							</div>
						</div>

						<div class="uk-form-row">
							<label class="uk-form-label" for="ruc">Ruc</label>
							<div class="uk-form-controls">
								<input type="text" name="ruc">
							</div>
						</div>

						<div class="uk-form-row">
							<label class="uk-form-label" for="nombre">Nombre</label>
							<div class="uk-form-controls">
								<input type="text" name="nombre">
							</div>
						</div>

						<div class="uk-form-row">
							<label class="uk-form-label" for="direccion">Direccion</label>
							<div class="uk-form-controls">
								<input id="direccion" type="text" name="direccion">
							</div>
						</div>
						<div class="uk-form-row uk-text-right">
							<button type="submit" class="uk-button uk-button-primary">Grabar</button>
						</div>
					</form>
				</div>

				<div class="uk-modal-footer uk-text-right">
					<button type="button" class="uk-button uk-modal-close">Cancelar</button>
				</div>
			</div>
		</div>


		<div id="modal2" class="uk-modal">
			<div class="uk-modal-dialog">
				<a href="" class="uk-modal-close uk-close"></a>

				<div class="uk-modal-header">
					<h2>Editar Entidad</h2>
				</div>

				<div class="uk-container">
					<form class="uk-form uk-form-horizontal" action="Entidad"
						method="post">
						<input type="hidden" name="metodo" value="actualiza">
						<div class="uk-form-row">
							<label class="uk-form-label" for="id_ID">Id Entidad</label>
							<div class="uk-form-controls">
								<input type="text" id="id_ID" name="id">
							</div>
						</div>

						<div class="uk-form-row">
							<label class="uk-form-label" for="poder_est">Poder
								Estatal</label>
							<div class="uk-form-controls">
								<input type="text" id="poder_est" name="poder_est">
							</div>
						</div>
						<div class="uk-form-row">
							<label class="uk-form-label" for="sector">Sector</label>
							<div class="uk-form-controls">
								<input id="sector" type="text" name="sector">
							</div>
						</div>

						<div class="uk-form-row">
							<label class="uk-form-label" for="ruc">Ruc</label>
							<div class="uk-form-controls">
								<input id="ruc" type="text" name="ruc">
							</div>
						</div>

						<div class="uk-form-row">
							<label class="uk-form-label" for="nombre">Nombre</label>
							<div class="uk-form-controls">
								<input id="nombre" type="text" name="nombre">
							</div>
						</div>

						<div class="uk-form-row">
							<label class="uk-form-label" for="direccion">Direccion</label>
							<div class="uk-form-controls">
								<input id="direccion" type="text" name="direccion">
							</div>
						</div>
						<div class="uk-form-row uk-text-center">
							<button type="submit" class="uk-button uk-button-primary">Grabar</button>
						</div>
					</form>
				</div>

				<div class="uk-modal-footer uk-text-right">
					<button type="button" class="uk-button uk-modal-close">Cancelar</button>
				</div>

			</div>
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
