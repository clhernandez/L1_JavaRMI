package cl.usach.lab1.rrhh.actions;

import java.util.List;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Departamento;

import com.opensymphony.xwork2.ActionSupport;

public class ListarDepartamentosAction extends ActionSupport{
	private List<Departamento> departamentos;
	
	public String execute() throws Exception {
		ClienteRrhhRMI clienteRRHH = new ClienteRrhhRMI();
		departamentos = clienteRRHH.listarDepartamentos();
		return SUCCESS;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
}
