package cl.usach.lab1.finanzas.actions.ordenProductos.json;

import java.rmi.RemoteException;

import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;

import com.opensymphony.xwork2.ActionSupport;

public class EliminarOrdenProductoJsonAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4967006837485082420L;

	private String id_orden_producto;
	
	private String msj;

	public String execute() {
		try {
			ClienteFinanzasRMI cliente = new ClienteFinanzasRMI();
			
			if(cliente.eliminarOrdenProducto(Integer.parseInt(id_orden_producto))){
				msj= "Orden Producto Eliminado exitosamente.";
			}else{
				msj= "Orden Producto no pudo ser eliminado..";
			}

			
		} catch (RemoteException e) {
			msj = "Error en conexion remota:"+e.getMessage();
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public String getId_orden_producto() {
		return id_orden_producto;
	}


	public void setId_orden_producto(String id_orden_producto) {
		this.id_orden_producto = id_orden_producto;
	}


	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}

}

