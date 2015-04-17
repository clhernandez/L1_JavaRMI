package cl.usach.lab1.rrhh.actions.json.trabajador;

import java.rmi.RemoteException;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Trabajador;

import com.opensymphony.xwork2.ActionSupport;

public class EliminarTrabajadorJsonAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5046650810979161239L;
	/**
	 * 
	 */
	private String id_trabajador;
	
	private String msj;

	public String execute() {
		try {
			ClienteRrhhRMI cliente = new ClienteRrhhRMI();
			
			if(cliente.eliminarTrabajador(Integer.parseInt(id_trabajador))){
				msj= "Trabajador modificado exitosamente.";
			}else{
				msj= "Trabajador no pudo ser modificado.";
			}

			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}


	public String getId_trabajador() {
		return id_trabajador;
	}


	public void setId_trabajador(String id_trabajador) {
		this.id_trabajador = id_trabajador;
	}


	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}

}

