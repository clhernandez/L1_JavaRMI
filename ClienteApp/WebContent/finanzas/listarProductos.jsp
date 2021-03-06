<%@include file="base/header.jsp"  %> 

<body>
	<%@include file="base/top_menu.jsp"  %> 

	<div class="container-fluid">
		<div class="row">
			<jsp:include page="base/left_menu.jsp" flush="true"></jsp:include>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">Listado Productos</h1>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>Nombre</th>
								<th>Descripcion</th>
								<th>Precio</th>
								<th>Modificar</th>
								<th>Eliminar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${productos}" var="prd" varStatus="loop">
							<tr>
								<td>${loop.count}</td>
								<td>${prd.nombre}</td>
								<td>${prd.descripcion}</td>
								<td>${prd.precio}</td>
								<td><a href="#" class="modificar_producto text-center" attr-id="${prd.id_producto}"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
								<td><a href="#" class="eliminar_producto text-center" attr-id="${prd.id_producto}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="myModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">Modificar Producto</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-signin" id="form_mod_producto">
	        	<input type="hidden" id="input_id_producto" name="id_producto">
				<label for="input_nombre" class="sr-only">Nombre Producto</label>
				<input name="nombre" type="text" id="input_nombre" class="form-control" placeholder="Nombre Producto" required autofocus="">
				
				<label for="input_precio" class="sr-only">Precio Producto</label>
				<input name="precio" type="number" id="input_precio" class="form-control" placeholder="Precio Producto"  required autofocus="">
				
				<label for="input_descripcion" class="sr-only">Descripcion Producto</label>
				<input name="descripcion" type="text" id="input_descripcion" class="form-control" placeholder="Descripcion Producto"  autofocus="">
	      	</form>
		      <span id='msjws' class='alert alert-info hide' ></span>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
	        <button type="button" class="btn btn-primary" id="guardar_producto">Guardar Cambios</button>
	      </div>
	    </div>
	  </div>
	</div>

	<jsp:include page="base/footer.jsp" flush="true"></jsp:include>
	<script>
		$(document).ready(function(){
			var reload = false;
			$(".modificar_producto").click(function(){
				var entrada = $(this).attr("attr-id");
				$.post("getProductoById", {id_producto: entrada}, function(json){
					if(json!=null){
						
						$("#input_id_producto").val(json.id_producto);
						$("#input_precio").val(json.precio);
						$("#input_descripcion").val(json.descripcion);
						$("#input_nombre").val(json.nombre);
						
						$('#myModal').modal();
					}
				});
				
			});
			$("#guardar_producto").click(function(){
				if($('#form_mod_producto')[0].checkValidity()){
					$.post("modificarProducto", $("#form_mod_producto").serialize(), function(json){
						$("#msjws").empty();
						$("#msjws").text(json.msj);
						$("#msjws").removeClass("hide");
						reload=true;
					});	
				}else{
					var $myForm = $("#form_mod_producto");
					$('<input type="submit">').hide().appendTo($myForm).click().remove();
				}
			});
			
			$(".eliminar_producto").click(function(){
				var entrada = $(this).attr("attr-id");
				console.log(entrada);
				if(confirm("�Esta seguro que desea eliminar este producto?")){
					$.post("eliminarProductoById", {id_producto: entrada}, function(json){
						location.reload();
					});
					
				}
				
			});
			$('#myModal').on('hide.bs.modal', function (e) {
				if(reload==true){
					location.reload();
				}
			});
		});
	</script>
	<style>
		#myModal form input{
			margin-bottom:5px;
		}
		#msjws{
			display:block;
		}
	</style>
</body>
</html>