package cl.usach.lab1.finanzas.actions.ordenes;

import java.util.List;

import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;


import cl.usach.lab1.finanzas.rmi.vo.Cliente;
import cl.usach.lab1.finanzas.rmi.vo.Orden;

import com.opensymphony.xwork2.ActionSupport;

public class ListarOrdenesAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5481588098410661518L;
	private List<Orden> ordenes;
	private List<Cliente> clientes;
	
	public String execute() throws Exception {
		ClienteFinanzasRMI clienteFinanzas = new ClienteFinanzasRMI();
		ordenes = clienteFinanzas.listarOrdenes();
		clientes = clienteFinanzas.listarClientes();
		return SUCCESS;
	}

	public List<Orden> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<Orden> ordenes) {
		this.ordenes = ordenes;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	
}
