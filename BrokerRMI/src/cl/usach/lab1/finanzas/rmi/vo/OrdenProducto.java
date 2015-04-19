package cl.usach.lab1.finanzas.rmi.vo;

import java.io.Serializable;

public class OrdenProducto  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5386332393412302450L;
	private int id_orden_producto;
	private int id_producto;
	private int cantidad;
	
	public int getId_orden_producto() {
		return id_orden_producto;
	}
	public void setId_orden_producto(int id_orden_producto) {
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
	
	
}
