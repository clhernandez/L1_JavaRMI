package cl.usach.lab1.finanzas.actions.productos;

import java.util.List;

import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;
import cl.usach.lab1.finanzas.rmi.vo.Producto;
import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Trabajador;

import com.opensymphony.xwork2.ActionSupport;

public class ListarProductosAction extends ActionSupport{
	private List<Producto> productos;
	
	public String execute() throws Exception {
		ClienteFinanzasRMI clienteFinanzas = new ClienteFinanzasRMI();
		productos = clienteFinanzas.listarProductos();
		return SUCCESS;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
