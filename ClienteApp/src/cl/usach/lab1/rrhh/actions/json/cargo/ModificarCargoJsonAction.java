package cl.usach.lab1.rrhh.actions.json.cargo;

import java.rmi.RemoteException;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Cargo;

import com.opensymphony.xwork2.ActionSupport;

public class ModificarCargoJsonAction extends ActionSupport {

	private static final long serialVersionUID = -759350771147113715L;
	private int id_cargo;
	private String nombre_cargo;
	private int sueldo_min;
	private int sueldo_max;
	private String msj;

	public String execute() {
		try {
			ClienteRrhhRMI cliente = new ClienteRrhhRMI();
			Cargo crg = new Cargo();
			crg.setNombre_cargo(nombre_cargo);
			crg.setSueldo_min(sueldo_min);
			crg.setSueldo_max(sueldo_max);
			crg.setId_cargo(id_cargo);
			
			if(cliente.modificarCargo(crg)){
				msj= "Cargo modificado exitosamente.";
			}else{
				msj= "Cargo no pudo ser modificado.";
			}

			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}



	public int getId_cargo() {
		return id_cargo;
	}



	public void setId_cargo(int id_cargo) {
		this.id_cargo = id_cargo;
	}



	public String getNombre_cargo() {
		return nombre_cargo;
	}



	public void setNombre_cargo(String nombre_cargo) {
		this.nombre_cargo = nombre_cargo;
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



	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}

}

