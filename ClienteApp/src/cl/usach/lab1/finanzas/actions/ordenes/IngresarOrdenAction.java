package cl.usach.lab1.finanzas.actions.ordenes;

import java.util.List;

import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;


import cl.usach.lab1.finanzas.rmi.vo.Cliente;
import cl.usach.lab1.finanzas.rmi.vo.Orden;

import com.opensymphony.xwork2.ActionSupport;

public class IngresarOrdenAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3705891033531596087L;
	private String id_cliente;
	private List<Cliente> clientes;
	private String fecha_orden;
	
	//Mensajes
	private String msj;
	
	public String execute() throws Exception {
			ClienteFinanzasRMI clienteFinanzas = new ClienteFinanzasRMI();
			
			if(id_cliente !=null && id_cliente.isEmpty()==false){
				
				Orden ord = new Orden();
				ord.setId_cliente(Integer.parseInt(id_cliente));
				ord.setFecha_orden(fecha_orden);
				
				if(clienteFinanzas.ingresarOrden(ord)){
					msj = "La Orden fue ingresada correctamente.";
				}else{
					msj = "La Orden no pudo ser ingresada.";
				}
			}else{
				clientes = clienteFinanzas.listarClientes();
			}
		return SUCCESS;
	}


	public String getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}


	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}


	public String getFecha_orden() {
		return fecha_orden;
	}


	public void setFecha_orden(String fecha_orden) {
		this.fecha_orden = fecha_orden;
	}


	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}
}
