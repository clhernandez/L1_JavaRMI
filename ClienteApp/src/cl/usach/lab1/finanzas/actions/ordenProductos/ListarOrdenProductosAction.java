package cl.usach.lab1.finanzas.actions.ordenProductos;

import java.util.List;

import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;
import cl.usach.lab1.finanzas.rmi.vo.OrdenProducto;
import cl.usach.lab1.finanzas.rmi.vo.Producto;

import com.opensymphony.xwork2.ActionSupport;

public class ListarOrdenProductosAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5481588098410661518L;
	private List<OrdenProducto> ordenProductos;
	private List<Producto> productos;
	
	public String execute() throws Exception {
		ClienteFinanzasRMI clienteFinanzas = new ClienteFinanzasRMI();
		ordenProductos = clienteFinanzas.listarOrdenProductos();
		productos = clienteFinanzas.listarProductos();
		return SUCCESS;
	}
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<OrdenProducto> getOrdenProductos() {
		return ordenProductos;
	}

	public void setOrdenProductos(List<OrdenProducto> ordenProductos) {
		this.ordenProductos = ordenProductos;
	}
	
}
