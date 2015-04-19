package cl.usach.lab1.rrhh.actions;

import java.util.List;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Departamento;

import com.opensymphony.xwork2.ActionSupport;

public class IngresarDepartamentoAction extends ActionSupport{
	private int id_departamento;
	private String nombre_departamento;
	private String administrador;
	private String ubicacion;
	
	//Mensajes
	private String msj;
	
	public String execute() throws Exception {
		if(id_departamento==1){
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


	public int getId_departamento() {
		return id_departamento;
	}


	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
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
