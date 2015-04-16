package cl.usach.lab1.rrhh.actions.json.trabajador;

import java.rmi.RemoteException;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Trabajador;

import com.opensymphony.xwork2.ActionSupport;

public class GetTrabajadorByRutJsonAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5046650810979161239L;
	/**
	 * 
	 */
	private String rut;
	private int id_trabajador;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private String fecha_contratacion;
	private int id_cargo_fk;
	private int sueldo;
	private int id_departamento_fk;

	public String execute() {
		try {
			ClienteRrhhRMI cliente = new ClienteRrhhRMI();
			Trabajador trb = cliente.getTrabajadorByRut(rut);
			if(trb!=null){
				id_trabajador = trb.getId_trabajador();
				nombre = trb.getNombre();
				apellido = trb.getApellido();
				email = trb.getEmail();
				telefono = trb.getTelefono();
				fecha_contratacion = trb.getFecha_contratacion();
				id_cargo_fk = trb.getId_cargo_fk();
				sueldo = trb.getSueldo();
				id_departamento_fk = trb.getId_departamento_fk();
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
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
}
