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
								<th>RUT</th>
								<th>Nombre</th>
								<th>Apellido</th>
								<th>Departamento</th>
								<th>Cargo</th>
								<th>Modificar</th>
								<th>Eliminar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${trabajadores}" var="trb">
							<tr>
								<td>${trb.id_trabajador}</td>
								<td>${trb.rut}</td>
								<td>${trb.nombre}</td>
								<td>${trb.apellido}</td>
								<td>${trb.id_departamento_fk}</td>
								<td>${trb.id_cargo_fk}</td>
								<td><a href="#" class="modificar_trabajador text-center" attr-id="${trb.rut}"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
								<td><a href="#" class="eliminar_trabajador text-center" attr-id="${trb.id_trabajador}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
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
	        <h4 class="modal-title">Modificar Trabajador</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-signin" action="modificarTrabajador" name="form_mod_trabajador" id="form_mod_trabajador">
	        	<input name="id_trabajador" type="hidden" id="input_id_trabajador" class="form-control">
				<label for="input_rut" class="sr-only">rut</label>
				<input name="rut" type="text" id="input_rut" class="form-control" placeholder="rut" required autofocus="">
				<label for="input_nombre" class="sr-only">nombre</label>
				<input name="nombre" type="text" id="input_nombre" class="form-control" placeholder="nombre" required autofocus="">
				<label for="input_apellido" class="sr-only">apellido</label>
				<input name="apellido" type="text" id="input_apellido" class="form-control" placeholder="apellido"  required autofocus="">
				<label for="input_email" class="sr-only">email</label>
				<input name="email" type="text" id="input_email" class="form-control" placeholder="email"  autofocus="">
				<label for="input_password" class="sr-only">password</label>
				<input name="password" type="password" id="input_password" class="form-control" placeholder="password"  autofocus="">
				<label for="input_telefono" class="sr-only">telefono</label>
				<input name="telefono" type="text" id="input_telefono" class="form-control" placeholder="telefono"  autofocus="">
				<label for="input_fecha_contratacion" class="sr-only">fecha_contratacion</label>
				<input name="fecha_contratacion" type="text" id="input_fecha_contratacion" class="form-control" placeholder="fecha_contratacion"  autofocus="">
				<label for="input_sueldo" class="sr-only">sueldo</label>
				<input name="sueldo" type="numeric" id="input_sueldo" class="form-control" placeholder="sueldo"  autofocus="">
		      </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
	        <button type="button" class="btn btn-primary" id="guardar_trabajador">Guardar Cambios</button>
	      </div>
	    </div>
	  </div>
	</div>

	<jsp:include page="base/footer.jsp" flush="true"></jsp:include>
	<script>
		$(document).ready(function(){
			$(".modificar_trabajador").click(function(){
				var entrada = $(this).attr("attr-id");
				console.log(entrada);
				$.post("getTrabajadorByRut", {rut: entrada}, function(json){
					console.log(json);
					if(json!=null){
						
						$("#input_id_trabajador").val(json.id_trabajador);
						$("#input_rut").val(json.rut);
						$("#input_nombre").val(json.nombre);
						$("#input_apellido").val(json.apellido);
						$("#input_email").val(json.email);
						$("#input_password").val(json.password);
						$("#input_telefono").val(json.telefono);
						$("#input_fecha_contratacion").val(json.fecha_contratacion);
						$("#input_sueldo").val(json.sueldo);
						
						$('#myModal').modal();
					}
				});
				
			});
			$("#guardar_trabajador").click(function(){
				console.log( $("#form_mod_trabajador").serialize() );
				$.post("modificar_trabajador", $("#form_mod_trabajador").serialize(), function(json){
					console.log(json);
				});
			});
			
			$(".eliminar_trabajador").click(function(){
				var entrada = $(this).attr("attr-id");
				console.log(entrada);
				if(confirm("�Esta seguro que desea eliminar a este trabajador?")){
					
					$.post("eliminarTrabajadorById", {id_trabajador: entrada}, function(json){
						
					});
					
				}
				
			});
		});
	</script>
	<style>
		#myModal form input{
			margin-bottom:5px;
		}
	</style>
</body>
</html>