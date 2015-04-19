package cl.usach.lab1.rrhh.actions.json.cargo;

import java.rmi.RemoteException;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Cargo;

import com.opensymphony.xwork2.ActionSupport;

public class EliminarCargoJsonAction extends ActionSupport {

	private static final long serialVersionUID = 9163187113734667959L;
	private int id_cargo;
	
	private String msj;

	public String execute() {
		try {
			ClienteRrhhRMI cliente = new ClienteRrhhRMI();
			
			if(cliente.eliminarCargo(id_cargo)){
				msj= "Cargo eliminado exitosamente.";
			}else{
				msj= "Cargo no pudo ser eliminado.";
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

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}

}

