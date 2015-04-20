package cl.usach.lab1.finanzas.actions.ordenes.json;

import java.rmi.RemoteException;

import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;


import cl.usach.lab1.finanzas.rmi.vo.Orden;

import com.opensymphony.xwork2.ActionSupport;

public class GetOrdenByIdJsonAction extends ActionSupport {


	private static final long serialVersionUID = 5667398013464936623L;

	private String id_orden;
	private int id_cliente;
	private String fecha_orden;
	
	private String msj;

	public String execute() {
		try {
			ClienteFinanzasRMI cliente = new ClienteFinanzasRMI();
			Orden ord = cliente.getOrdenById(Integer.parseInt(id_orden));
			if(ord!=null){
				id_cliente = ord.getId_cliente();
				fecha_orden = ord.getFecha_orden();
			}
		} catch (RemoteException e) {
			msj = "Error en conexion remota:"+e.getMessage();
			e.printStackTrace();
		}

		return SUCCESS;
	}

	
	
	public String getId_orden() {
		return id_orden;
	}



	public void setId_orden(String id_orden) {
		this.id_orden = id_orden;
	}






	public int getId_cliente() {
		return id_cliente;
	}



	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}



	public String getFecha_orden() {
		return fecha_orden;
	}



	public void setFecha_orden(String fecha_orden) {
		this.fecha_orden = fecha_orden;
	}



	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}
	
}