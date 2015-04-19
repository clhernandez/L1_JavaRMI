package cl.usach.lab1.finanzas.actions.json.cliente;

import java.rmi.RemoteException;

import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;


import com.opensymphony.xwork2.ActionSupport;

public class EliminarClienteJsonAction extends ActionSupport {

	private static final long serialVersionUID = 2137281056142676271L;

	private String id_cliente;
	
	private String msj;

	public String execute() {
		try {
			ClienteFinanzasRMI cliente = new ClienteFinanzasRMI();
			
			if(cliente.eliminarCliente(Integer.parseInt(id_cliente))){
				msj= "Cliente modificado exitosamente.";
			}else{
				msj= "Cliente no pudo ser modificado.";
			}

			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}




	public String getId_cliente() {
		return id_cliente;
	}




	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}




	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}

}

