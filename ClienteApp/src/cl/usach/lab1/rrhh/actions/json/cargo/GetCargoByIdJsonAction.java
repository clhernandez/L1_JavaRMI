package cl.usach.lab1.rrhh.actions.json.cargo;

import java.rmi.RemoteException;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Cargo;

import com.opensymphony.xwork2.ActionSupport;

public class GetCargoByIdJsonAction extends ActionSupport {

	private static final long serialVersionUID = 5699305162529383741L;
	private String nombre_cargo;
	private int id_cargo;
	private int sueldo_min;
	private int sueldo_max;

	public String execute() {
		try {
			ClienteRrhhRMI cliente = new ClienteRrhhRMI();
			Cargo crg = cliente.getCargoById(id_cargo);
			if(crg!=null){
				id_cargo = crg.getId_cargo();
				nombre_cargo = crg.getNombre_cargo();
				sueldo_min = crg.getSueldo_min();
				sueldo_max = crg.getSueldo_max();
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public String getNombre_cargo() {
		return nombre_cargo;
	}

	public void setNombre_cargo(String nombre_cargo) {
		this.nombre_cargo = nombre_cargo;
	}

	public int getId_cargo() {
		return id_cargo;
	}

	public void setId_cargo(int id_cargo) {
		this.id_cargo = id_cargo;
	}

	public int getSueldo_min() {
		return sueldo_min;
	}

	public void setSueldo_min(int sueldo_min) {
		this.sueldo_min = sueldo_min;
	}

	public int getSueldo_max() {
		return sueldo_max;
	}

	public void setSueldo_max(int sueldo_max) {
		this.sueldo_max = sueldo_max;
	}


}
