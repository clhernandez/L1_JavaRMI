package cl.usach.lab1.rrhh.actions;

import java.util.Map;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InitAction extends ActionSupport{
	private String email;
	private String nombre;
	private String apellido;
	
	private int cantidadCargos;
	private int cantidadDepartamentos;
	private int cantidadTrabajadores;
	
	public String execute() throws Exception {
		Map sesion = ActionContext.getContext().getSession();
		email = (String) sesion.get("email");
		nombre = (String) sesion.get("nombre");
		apellido = (String) sesion.get("apellido");
		
		ClienteRrhhRMI cliente = new ClienteRrhhRMI();
		cantidadCargos = cliente.listarCargos().size();
		cantidadDepartamentos = cliente.listarDepartamentos().size();
		cantidadTrabajadores = cliente.listarTrabajadores().size();
		
		return SUCCESS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getCantidadCargos() {
		return cantidadCargos;
	}

	public void setCantidadCargos(int cantidadCargos) {
		this.cantidadCargos = cantidadCargos;
	}

	public int getCantidadDepartamentos() {
		return cantidadDepartamentos;
	}

	public void setCantidadDepartamentos(int cantidadDepartamentos) {
		this.cantidadDepartamentos = cantidadDepartamentos;
	}

	public int getCantidadTrabajadores() {
		return cantidadTrabajadores;
	}

	public void setCantidadTrabajadores(int cantidadTrabajadores) {
		this.cantidadTrabajadores = cantidadTrabajadores;
	}

}
