package cl.usach.lab1.rrhh.actions.json.departamento;

import java.rmi.RemoteException;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Trabajador;

import com.opensymphony.xwork2.ActionSupport;

public class EliminarDepartamentoJsonAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3888459070720655564L;

	/**
	 * 
	 */

	/**
	 * 
	 */
	private String id_departamento;
	
	private String msj;

	public String execute() {
		try {
			ClienteRrhhRMI cliente = new ClienteRrhhRMI();
			System.out.println(id_departamento);
			if(cliente.eliminarDepartamento(Integer.parseInt(id_departamento))){
				msj= "Departamento modificado exitosamente.";
			}else{
				msj= "Departamento no pudo ser modificado.";
			}

			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}


	public String getId_departamento() {
		return id_departamento;
	}


	public void setId_departamento(String id_departamento) {
		this.id_departamento = id_departamento;
	}


	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}

}

