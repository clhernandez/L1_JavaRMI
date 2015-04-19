package cl.usach.lab1.rrhh.actions.json.departamento;

import java.rmi.RemoteException;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Departamento;
import cl.usach.lab1.rrhh.rmi.vo.Trabajador;

import com.opensymphony.xwork2.ActionSupport;

public class ModificarDepartamentoJsonAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -46737823333430612L;
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
/*	private String password;
	private String email;
	private String telefono;
	private String fecha_contratacion;
	private int id_cargo_fk;
	private int sueldo;
	private int id_departamento_fk;*/
	
	private String msj;

	public String execute() {
		try {
			ClienteRrhhRMI cliente = new ClienteRrhhRMI();
			Departamento dep = new Departamento();
			dep.setId_departamento(id_departamento);
			dep.setNombre_departamento(nombre_departamento);
			dep.setAdministrador(administrador);
			dep.setUbicacion(ubicacion);
/*			dep.setTelefono(telefono);
			dep.setFecha_contratacion(fecha_contratacion);
			dep.setId_cargo_fk(id_cargo_fk);
			dep.setSueldo(sueldo);
			dep.setId_departamento_fk(id_departamento_fk);
			dep.setId_trabajador(id_trabajador);*/
			
			if(cliente.modificarDepartamento(dep)){
				msj= "Departamento modificado exitosamente.";
			}else{
				msj= "Departamento no pudo ser modificado.";
			}

			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

