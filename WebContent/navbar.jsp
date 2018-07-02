<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%><%@ taglib
	uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<nav class="uk-navbar navbarStick"
	data-uk-sticky="{ showup: true, animation: 'uk-animation-slide-top', clsactive: 'eb-navbar-active' }">
	<ul class="uk-navbar-nav">
		<li class=""><a href="#offcanvas"
			data-uk-offcanvas="{mode:'slide'}">&#9776;</a></li>
		<div class="uk-navbar-content">
			${sessionScope.objUsuario.empleado.nombre}
			${sessionScope.objUsuario.empleado.apePat}
			${sessionScope.objUsuario.empleado.cargo.idCargo}</div>

	</ul>
	<div class="uk-navbar-flip">
		<ul class="uk-navbar-nav">
			<div id="clock" class="uk-navbar-content"></div>
			<li><a href="login.jsp"> <i class="uk-icon-power-off"></i></a></li>
		</ul>
	</div>
</nav>

<div id="offcanvas" class="uk-offcanvas">
	<div class="uk-offcanvas-bar">
		<div class="uk-panel">
			<h3 class="uk-panel-title">${sessionScope.objUsuario.empleado.nombre}
				${sessionScope.objUsuario.empleado.apePat}</h3>
		</div>
		<ul class="uk-nav uk-nav-offcanvas uk-nav-parent-icon" data-uk-nav>
			<li><a href="index.jsp">Main</a></li>
			<c:choose>
				<c:when test="${sessionScope.objUsuario.empleado.cargo.idCargo==1}">
					<jsp:include page="AdminOnly.jsp"></jsp:include>
				</c:when>

				<c:when test="${sessionScope.objUsuario.empleado.cargo.idCargo==3}">
					<li><a href="gestionAmpliaciones.jsp">Gestion de
							Ampliacion</a></li>
				</c:when>
				<c:when test="${sessionScope.objUsuario.empleado.cargo.idCargo==4}">
					<!-- 
					<li><a href="modificacionDoc.jsp">Gestion de Documentos</a></li>
					 -->
				</c:when>
				<c:when test="${sessionScope.objUsuario.empleado.cargo.idCargo==5}">
					<!-- 
					<li><a href="modificacionDoc.jsp">Gestion de Documentos</a></li>
					 -->
				</c:when>
				<c:otherwise>
					<div class="uk-panel">Aun no existen funciones para usted</div>
				</c:otherwise>
			</c:choose>


		</ul>
	</div>
</div>

