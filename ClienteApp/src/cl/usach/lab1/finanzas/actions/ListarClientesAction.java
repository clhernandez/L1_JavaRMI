package cl.usach.lab1.finanzas.actions;

import java.util.List;

import cl.usach.lab1.finanzas.rmi.vo.Cliente;
import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;

import com.opensymphony.xwork2.ActionSupport;

public class ListarClientesAction extends ActionSupport{
	private List<Cliente> clientes;
	
	public String execute() throws Exception {
		ClienteFinanzasRMI clienteFINANZAS = new ClienteFinanzasRMI();
		clientes = clienteFINANZAS.listarClientes();
		return SUCCESS;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}
