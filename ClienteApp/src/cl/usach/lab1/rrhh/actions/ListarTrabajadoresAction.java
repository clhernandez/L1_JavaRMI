package cl.usach.lab1.rrhh.actions;

import java.util.List;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Cargo;
import cl.usach.lab1.rrhh.rmi.vo.Departamento;
import cl.usach.lab1.rrhh.rmi.vo.Trabajador;

import com.opensymphony.xwork2.ActionSupport;

public class ListarTrabajadoresAction extends ActionSupport{
	private List<Trabajador> trabajadores;
	private List<Cargo> cargos;
	private List<Departamento> departamentos;
	
	public String execute() throws Exception {
		ClienteRrhhRMI clienteRRHH = new ClienteRrhhRMI();
		trabajadores = clienteRRHH.listarTrabajadores();
		departamentos = clienteRRHH.listarDepartamentos();
		cargos = clienteRRHH.listarCargos();
		return SUCCESS;
	}

	public List<Trabajador> getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(List<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
}
