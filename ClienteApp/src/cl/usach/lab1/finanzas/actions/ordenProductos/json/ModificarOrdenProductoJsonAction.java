package cl.usach.lab1.finanzas.actions.ordenProductos.json;

import java.rmi.RemoteException;

import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;
import cl.usach.lab1.finanzas.rmi.vo.OrdenProducto;

import com.opensymphony.xwork2.ActionSupport;

public class ModificarOrdenProductoJsonAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1559424061358753605L;
	private String id_orden_producto;
	private int id_producto;
	private int cantidad;

	
	private String msj;

	public String execute() {
		try {
			ClienteFinanzasRMI cliente = new ClienteFinanzasRMI();
			OrdenProducto oprd = new OrdenProducto();
			System.out.println(id_orden_producto);
			oprd.setId_orden_producto(Integer.parseInt(id_orden_producto));
			oprd.setId_producto(id_producto);
			oprd.setCantidad(cantidad);

			if(cliente.modificarOrdenProducto(oprd)){
				msj= "Orden Producto modificada exitosamente.";
			}else{
				msj= "Orden Producto no pudo ser modificada.";
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

