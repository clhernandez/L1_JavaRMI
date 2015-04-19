package cl.usach.lab1.finanzas.actions.productos.json;

import java.rmi.RemoteException;

import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;
import cl.usach.lab1.finanzas.rmi.vo.Producto;

import com.opensymphony.xwork2.ActionSupport;

public class ModificarProductoJsonAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1559424061358753605L;
	private int id_producto;
	private String nombre;
	private String descripcion;
	private int precio;

	
	private String msj;

	public String execute() {
		try {
			ClienteFinanzasRMI cliente = new ClienteFinanzasRMI();
			Producto prd = new Producto();
			prd.setId_producto(id_producto);
			prd.setNombre(nombre);
			prd.setDescripcion(descripcion);
			prd.setPrecio(precio);
			if(cliente.modificarProducto(prd)){
				msj= "Producto modificado exitosamente.";
			}else{
				msj= "Producto no pudo ser modificado.";
			}
			
		} catch (RemoteException e) {
			//TODO manejar excepcion
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}

}

