<%@include file="base/header.jsp"  %> 

<body>
	<%@include file="base/top_menu.jsp"  %> 

	<div class="container-fluid">
		<div class="row">
			<jsp:include page="base/left_menu.jsp" flush="true"></jsp:include>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">Listado Trabajadores</h1>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>Nombre</th>
								<th>Apellido</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${trabajadores}" var="trb">
							<tr>
								<td>${trb.id_trabajador}</td>
								<td>${trb.nombre}</td>
								<td>${trb.apellido}</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="base/footer.jsp" flush="true"></jsp:include>
</body>
</html>