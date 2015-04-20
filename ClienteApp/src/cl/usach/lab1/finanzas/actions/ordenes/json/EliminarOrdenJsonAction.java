package cl.usach.lab1.finanzas.actions.ordenes.json;

import java.rmi.RemoteException;

import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;

import com.opensymphony.xwork2.ActionSupport;

public class EliminarOrdenJsonAction extends ActionSupport {

	private static final long serialVersionUID = 7811344443885533659L;

	private int id_orden;
	
	private String msj;

	public String execute() {
		try {
			ClienteFinanzasRMI cliente = new ClienteFinanzasRMI();
			
			if(cliente.eliminarOrden(id_orden)){ //if(cliente.eliminarOrden(Integer.parseInt(id_orden))){
				msj= "Orden Eliminada exitosamente.";
			}else{
				msj= "Orden no pudo ser eliminada..";
			}

			
		} catch (RemoteException e) {
			msj = "Error en conexion remota:"+e.getMessage();
			e.printStackTrace();
		}

		return SUCCESS;
	}

	


	public int getId_orden() {
		return id_orden;
	}




	public void setId_orden(int id_orden) {
		this.id_orden = id_orden;
	}




	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}

}

