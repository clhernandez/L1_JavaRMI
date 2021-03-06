<%@include file="base/header.jsp"  %> 

<body>
	<%@include file="base/top_menu.jsp"  %> 

	<div class="container-fluid">
		<div class="row">
			<jsp:include page="base/left_menu.jsp" flush="true"></jsp:include>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="table-responsive">
					<h1 class="page-header">Ingresar Producto</h1>
				
					<form class="form-signin" action="ingresarProducto" method="post">
						<label for="input_nombre" class="sr-only">Nombre Producto</label>
						<input name="nombre" type="text" id="input_nombre" class="form-control" placeholder="Nombre Producto" required autofocus="">
						
						<label for="input_precio" class="sr-only">Precio Producto</label>
						<input name="precio" type="number" id="input_precio" class="form-control" placeholder="Precio Producto"  required autofocus="">
						
						<label for="input_descripcion" class="sr-only">Descripcion Producto</label>
						<input name="descripcion" type="text" id="input_descripcion" class="form-control" placeholder="Descripcion Producto"  autofocus="">
					
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