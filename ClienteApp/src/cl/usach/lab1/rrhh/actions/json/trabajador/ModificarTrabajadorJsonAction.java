package cl.usach.lab1.rrhh.actions.json.trabajador;

import java.rmi.RemoteException;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Trabajador;

import com.opensymphony.xwork2.ActionSupport;

public class ModificarTrabajadorJsonAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5046650810979161239L;
	/**
	 * 
	 */
	private int id_trabajador;
	private String rut;
	private String nombre;
	private String apellido;
	private String password;
	private String email;
	private String telefono;
	private String fecha_contratacion;
	private int id_cargo_fk;
	private int sueldo;
	private int id_departamento_fk;
	
	private String msj;

	public String execute() {
		try {
			ClienteRrhhRMI cliente = new ClienteRrhhRMI();
			Trabajador trb = new Trabajador();
			trb.setRut(rut);
			trb.setNombre(nombre);
			trb.setApellido(apellido);
			if(password!=null && password.equals("")==false){
				trb.setPasswd(password);
			}
			trb.setEmail(email);
			trb.setTelefono(telefono);
			trb.setFecha_contratacion(fecha_contratacion);
			trb.setId_cargo_fk(id_cargo_fk);
			trb.setSueldo(sueldo);
			trb.setId_departamento_fk(id_departamento_fk);
			trb.setId_trabajador(id_trabajador);
			
			if(cliente.modificarTrabajador(trb)){
				msj= "Trabajador modificado exitosamente.";
			}else{
				msj= "Trabajador no pudo ser modificado.";
			}

			
		} catch (RemoteException e) {
			msj="Ocurrio un error: "+e.getMessage();
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public int getId_trabajador() {
		return id_trabajador;
	}

	public void setId_trabajador(int id_trabajador) {
		this.id_trabajador = id_trabajador;
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

	public int getId_cargo_fk() {
		return id_cargo_fk;
	}

	public void setId_cargo_fk(int id_cargo_fk) {
		this.id_cargo_fk = id_cargo_fk;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public int getId_departamento_fk() {
		return id_departamento_fk;
	}

	public void setId_departamento_fk(int id_departamento_fk) {
		this.id_departamento_fk = id_departamento_fk;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}

}

