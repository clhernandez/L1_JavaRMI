package cl.usach.lab1.rrhh.actions;

import java.util.List;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Cargo;

import com.opensymphony.xwork2.ActionSupport;

public class IngresarCargoAction extends ActionSupport{
	private String nombre_cargo;
	private int sueldo_min;
	private int sueldo_max;

	
	//Mensajes
	private String msj;
	
	public String execute() throws Exception {

			ClienteRrhhRMI clienteRRHH = new ClienteRrhhRMI();
			Cargo crg = new Cargo();
			crg.setNombre_cargo(nombre_cargo);
			crg.setSueldo_min(sueldo_min);
			crg.setSueldo_max(sueldo_max);
			if(clienteRRHH.ingresarCargo(crg)){
				msj = "Cargo ingresado correctamente.";
			}else{
				msj = "El cargo no fue ingresado.";
			}
		return SUCCESS;
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
