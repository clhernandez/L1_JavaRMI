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
	
	private String msj;

	public String execute() {
		try {
			ClienteRrhhRMI cliente = new ClienteRrhhRMI();
			Departamento dep = cliente.getDepartamentoById(id_departamento);
			if(dep!=null){
				id_departamento = dep.getId_departamento();
				nombre_departamento = dep.getNombre_departamento();
				administrador = dep.getAdministrador();
				ubicacion = dep.getUbicacion();
			}else{
				msj = "Error al obtener departamento";
			}
		} catch (RemoteException e) {
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
