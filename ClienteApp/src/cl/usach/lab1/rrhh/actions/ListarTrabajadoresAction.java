package cl.usach.lab1.rrhh.actions;

import java.util.List;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Trabajador;

import com.opensymphony.xwork2.ActionSupport;

public class ListarTrabajadoresAction extends ActionSupport{
	private List<Trabajador> trabajadores;
	
	public String execute() throws Exception {
		ClienteRrhhRMI clienteRRHH = new ClienteRrhhRMI();
		trabajadores = clienteRRHH.listarTrabajadores();
		return SUCCESS;
	}

	public List<Trabajador> getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(List<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}
	
}
