package cl.usach.lab1.rrhh.actions;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Departamento;

import com.opensymphony.xwork2.ActionSupport;

public class IngresarDepartamentoAction extends ActionSupport{
	private String nombre_departamento;
	private String administrador;
	private String ubicacion;
	
	//Mensajes
	private String msj;
	
	public String execute() throws Exception {
		if(nombre_departamento!=null && nombre_departamento.equals("")==false){
			ClienteRrhhRMI clienteRRHH = new ClienteRrhhRMI();
			Departamento dep = new Departamento();
			dep.setNombre_departamento(nombre_departamento);
			dep.setAdministrador(administrador);
			dep.setUbicacion(ubicacion);
			if(clienteRRHH.ingresarDepartamento(dep)){
				msj = "Departamento ingresado correctamente.";
			}else{
				msj = "El departamento no fue ingresado.";
			}
		}
		
		return SUCCESS;
	}

	public String getNombre_departamento() {
		return nombre_departamento;
	}


	public void setNombre_departamento(String nombre_departamento) {
		this.nombre_departamento = nombre_departamento;
	}


	public String getAdministrador() {
		return administrador;
	}


	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}


	public String getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}
}
