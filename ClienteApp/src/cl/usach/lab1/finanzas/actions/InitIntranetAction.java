package cl.usach.lab1.finanzas.actions;

import java.util.Map;

import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InitIntranetAction extends ActionSupport{
	private String email;
	private String nombre;
	private String apellido;
	private int cantidadProductos;
	private int cantidadClientes;
	private int cantidadOrdenes;
	private int cantidadOrdenesProducto;
	
	public String execute() throws Exception {
		Map sesion = ActionContext.getContext().getSession();
		email = (String) sesion.get("email");
		nombre = (String) sesion.get("nombre");
		apellido = (String) sesion.get("apellido");
		ClienteFinanzasRMI cliente = new ClienteFinanzasRMI();
		cantidadClientes = cliente.listarClientes().size();
		cantidadOrdenes = cliente.listarOrdenes().size();
		cantidadProductos = cliente.listarProductos().size();
		cantidadOrdenesProducto = cliente.listarOrdenProductos().size();
				
		return SUCCESS;
	}
	
	

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public int getCantidadProductos() {
		return cantidadProductos;
	}



	public void setCantidadProductos(int cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}



	public int getCantidadClientes() {
		return cantidadClientes;
	}



	public void setCantidadClientes(int cantidadClientes) {
		this.cantidadClientes = cantidadClientes;
	}



	public int getCantidadOrdenes() {
		return cantidadOrdenes;
	}



	public void setCantidadOrdenes(int cantidadOrdenes) {
		this.cantidadOrdenes = cantidadOrdenes;
	}



	public int getCantidadOrdenesProducto() {
		return cantidadOrdenesProducto;
	}



	public void setCantidadOrdenesProducto(int cantidadOrdenesProducto) {
		this.cantidadOrdenesProducto = cantidadOrdenesProducto;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
