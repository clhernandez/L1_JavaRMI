package cl.usach.lab1.rrhh.actions;

import java.util.List;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Trabajador;

import com.opensymphony.xwork2.ActionSupport;

public class IngresarTrabajadorAction extends ActionSupport{
	private String rut;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private String telefono;
	private String fecha_contratacion;
	private String sueldo;
	
	//Mensajes
	private String msj;
	
	public String execute() throws Exception {
		if(rut!=null){
			ClienteRrhhRMI clienteRRHH = new ClienteRrhhRMI();
			Trabajador trb = new Trabajador();
			trb.setRut(rut);
			trb.setNombre(nombre);
			trb.setApellido(apellido);
			trb.setEmail(email);
			trb.setTelefono(telefono);
			trb.setFecha_contratacion(fecha_contratacion);
			trb.setSueldo(Integer.parseInt(sueldo));
			if(clienteRRHH.ingresarTrabajador(trb)){
				msj = "Trabajador ingresado correctamente.";
			}else{
				msj = "El usuario no fue ingresado.";
			}
		}
		
		return SUCCESS;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFecha_contratacion() {
		return fecha_contratacion;
	}

	public void setFecha_contratacion(String fecha_contratacion) {
		this.fecha_contratacion = fecha_contratacion;
	}

	public String getSueldo() {
		return sueldo;
	}

	public void setSueldo(String sueldo) {
		this.sueldo = sueldo;
	}

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}
}
