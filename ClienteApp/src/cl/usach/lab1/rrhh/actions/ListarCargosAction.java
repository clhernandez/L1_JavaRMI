package cl.usach.lab1.rrhh.actions;

import java.util.List;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Cargo;

import com.opensymphony.xwork2.ActionSupport;

public class ListarCargosAction extends ActionSupport{
	private List<Cargo> cargos;
	
	public String execute() throws Exception {
		ClienteRrhhRMI clienteRRHH = new ClienteRrhhRMI();
		cargos = clienteRRHH.listarCargos();
		return SUCCESS;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
}
