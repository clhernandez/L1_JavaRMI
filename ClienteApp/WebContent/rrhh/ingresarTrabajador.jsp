<%@include file="base/header.jsp"  %> 

<body>
	<%@include file="base/top_menu.jsp"  %> 

	<div class="container-fluid">
		<div class="row">
			<jsp:include page="base/left_menu.jsp" flush="true"></jsp:include>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="table-responsive">
					<h1 class="page-header">Ingresar Trabajador</h1>
				
					<form class="form-signin" action="ingresarTrabajador">
						<label for="input_rut" class="sr-only">rut</label>
						<input name="rut" type="text" id="input_rut" class="form-control" placeholder="rut" required autofocus="">
						<label for="input_nombre" class="sr-only">nombre</label>
						<input name="nombre" type="text" id="input_nombre" class="form-control" placeholder="nombre" required autofocus="">
						<label for="input_apellido" class="sr-only">apellido</label>
						<input name="apellido" type="text" id="input_apellido" class="form-control" placeholder="apellido"  required autofocus="">
						<label for="input_email" class="sr-only">email</label>
						<input name="email" type="text" id="input_email" class="form-control" placeholder="email"  autofocus="">
						<label for="input_password" class="sr-only">password</label>
						<input name="password" type="text" id="input_password" class="form-control" placeholder="password"  autofocus="">
						<label for="input_telefono" class="sr-only">telefono</label>
						<input name="telefono" type="text" id="input_telefono" class="form-control" placeholder="telefono"  autofocus="">
						<label for="input_fecha_contratacion" class="sr-only">fecha_contratacion</label>
						<input name="fecha_contratacion" type="text" id="input_fecha_contratacion" class="form-control" placeholder="fecha_contratacion"  autofocus="">
						<label for="input_sueldo" class="sr-only">sueldo</label>
						<input name="sueldo" type="numeric" id="input_sueldo" class="form-control" placeholder="sueldo"  autofocus="">
						<button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
				      </form>
				    	<c:if test="${not empty msj}">
						    <div class="alert alert-info"> ${msj} </div>
						</c:if>
				</div>
			</div>
		</div>
	</div>
	<style>
		.table-responsive{
			width:50%;
			margin: 0 auto;
		}
		.table-responsive form input{
			margin-bottom:5px;
		}
	</style>
	<jsp:include page="base/footer.jsp" flush="true"></jsp:include>
</body>
</html>