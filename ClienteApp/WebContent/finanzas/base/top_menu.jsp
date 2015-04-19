<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/finanzas/dashboard">Finanzas</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/finanzas/dashboard">Dashboard</a></li>
				<li><a href="#"><c:out value="${sessionScope.nombre}" /> <c:out value="${sessionScope.apellido}" /></a></li>
				<li><a href="${pageContext.request.contextPath}/logout">Cerrar Sesión</a></li>
			</ul>
		</div>
	</div>
</nav>