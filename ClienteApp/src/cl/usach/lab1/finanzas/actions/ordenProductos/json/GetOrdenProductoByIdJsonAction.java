package cl.usach.lab1.finanzas.actions.ordenProductos.json;

import java.rmi.RemoteException;

import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;
import cl.usach.lab1.finanzas.rmi.vo.OrdenProducto;

import com.opensymphony.xwork2.ActionSupport;

public class GetOrdenProductoByIdJsonAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6576960460084015606L;
	private String id_orden_producto;
	private int id_producto;
	private int cantidad;
	
	private String msj;

	public String execute() {
		try {
			ClienteFinanzasRMI cliente = new ClienteFinanzasRMI();
			OrdenProducto oprd = cliente.getOrdenProductoById(Integer.parseInt(id_orden_producto));
			if(oprd!=null){
				id_producto = oprd.getId_producto();
				cantidad = oprd.getCantidad();
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




	public int getId_producto() {
		return id_producto;
	}


	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}
	
}