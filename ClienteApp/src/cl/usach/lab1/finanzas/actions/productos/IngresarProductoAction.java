package cl.usach.lab1.finanzas.actions.productos;

import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;
import cl.usach.lab1.finanzas.rmi.vo.Producto;

import com.opensymphony.xwork2.ActionSupport;

public class IngresarProductoAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3705891033531596087L;
	private String nombre;
	private int precio;
	private String descripcion;
	
	//Mensajes
	private String msj;
	
	public String execute() throws Exception {
			
			if(nombre !=null && nombre.isEmpty()==false){
				ClienteFinanzasRMI clienteFinanzas = new ClienteFinanzasRMI();
				Producto prd = new Producto();
				prd.setNombre(nombre);
				prd.setPrecio(precio);
				prd.setDescripcion(descripcion);
				if(clienteFinanzas.ingresarProducto(prd)){
					msj = "El Producto fue ingresado correctamente.";
				}else{
					msj = "El Producto no pudo ser ingresado.";
				}
			}
		return SUCCESS;
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
