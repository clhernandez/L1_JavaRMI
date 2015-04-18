package cl.usach.lab1.finanzas.actions.productos.json;

import java.rmi.RemoteException;

import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;
import cl.usach.lab1.finanzas.rmi.vo.Producto;

import com.opensymphony.xwork2.ActionSupport;

public class GetProductoByIdJsonAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6576960460084015606L;
	private String id_producto;
	private String nombre;
	private int precio;
	private String descripcion;
	
	private String msj;

	public String execute() {
		try {
			ClienteFinanzasRMI cliente = new ClienteFinanzasRMI();
			Producto prd = cliente.getProductoById(Integer.parseInt(id_producto));
			if(prd!=null){
				nombre = prd.getNombre();
				descripcion = prd.getDescripcion();
				precio = prd.getPrecio();
			}
		} catch (RemoteException e) {
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}
	
}