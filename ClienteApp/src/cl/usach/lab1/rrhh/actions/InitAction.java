package cl.usach.lab1.rrhh.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InitAction extends ActionSupport{
	private String email;
	private String nombre;
	private String apellido;
	
	public String execute() throws Exception {
		Map sesion = ActionContext.getContext().getSession();
		email = (String) sesion.get("email");
		nombre = (String) sesion.get("nombre");
		apellido = (String) sesion.get("apellido");
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
	
}
