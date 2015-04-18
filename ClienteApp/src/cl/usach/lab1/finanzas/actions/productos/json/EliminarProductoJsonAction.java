package cl.usach.lab1.finanzas.actions.productos.json;

import java.rmi.RemoteException;

import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;

import com.opensymphony.xwork2.ActionSupport;

public class EliminarProductoJsonAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4967006837485082420L;

	private String id_producto;
	
	private String msj;

	public String execute() {
		try {
			ClienteFinanzasRMI cliente = new ClienteFinanzasRMI();
			
			if(cliente.eliminarProducto(Integer.parseInt(id_producto))){
				msj= "Producto Eliminado exitosamente.";
			}else{
				msj= "Producto no pudo ser eliminado..";
			}

			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public String getId_producto() {
		return id_producto;
	}

	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}

}

