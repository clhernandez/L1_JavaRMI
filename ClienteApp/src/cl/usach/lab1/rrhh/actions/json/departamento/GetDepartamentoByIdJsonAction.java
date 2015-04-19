package cl.usach.lab1.rrhh.actions.json.departamento;

import java.rmi.RemoteException;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Departamento;

import com.opensymphony.xwork2.ActionSupport;

public class GetDepartamentoByIdJsonAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9190365488000926015L;
	/**
	 * 
	 */
	/**
	 * 
	 */
	private int id_departamento;
	private String nombre_departamento;
	private String administrador;
	private String ubicacion;
//	private String telefono;
//	private String fecha_contratacion;
//	private int id_cargo_fk;
//	private int sueldo;
//	private int id_departamento_fk;

	public String execute() {
		try {
			ClienteRrhhRMI cliente = new ClienteRrhhRMI();
			Departamento dep = cliente.getDepartamentoById(id_departamento);
//			if(dep!=null){
				id_departamento = dep.getId_departamento();
				nombre_departamento = dep.getNombre_departamento();
				administrador = dep.getAdministrador();
				ubicacion = dep.getUbicacion();
//				telefono = dep.getTelefono();
//				fecha_contratacion = dep.getFecha_contratacion();
//				id_cargo_fk = dep.getId_cargo_fk();
//				sueldo = dep.getSueldo();
//				id_departamento_fk = dep.getId_departamento_fk();
//			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}

//	public String getRut() {
//		return rut;
//	}

//	public void setRut(String rut) {
//		this.rut = rut;
//	}

	public int getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
	}

	public String getNombre_departamento() {
		return nombre_departamento;
	}

	public void setAdministrador(String Administrador) {
		this.administrador = administrador;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

//	public String getEmail() {
//		return email;
//	}

//	public void setEmail(String email) {
//		this.email = email;
//	}

//	public String getTelefono() {
//		return telefono;
//	}

/*	public void setTelefono(String telefono) {
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
	}*/
}
