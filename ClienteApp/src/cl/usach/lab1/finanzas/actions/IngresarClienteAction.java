package cl.usach.lab1.finanzas.actions;

import java.util.List;

import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;
import cl.usach.lab1.finanzas.rmi.vo.Cliente;
import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Trabajador;

import com.opensymphony.xwork2.ActionSupport;

public class IngresarClienteAction extends ActionSupport{
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private String ciudad;
	private String region;
	
	//Mensajes
	private String msj;
	
	public String execute() throws Exception {
		if(nombre!=null){
			ClienteFinanzasRMI clienteFINANZAS = new ClienteFinanzasRMI();
			Cliente clt = new Cliente();
			clt.setNombre(nombre);
			clt.setApellido(apellido);
			clt.setDireccion(direccion);
			clt.setTelefono(telefono);
			clt.setTelefono(ciudad);
			clt.setTelefono(region);
			if(clienteFINANZAS.ingresarCliente(clt)){
				msj = "Cliente ingresado correctamente.";
			}else{
				msj = "El cliente no fue ingresado.";
			}
		}
		
		return SUCCESS;
	}

	

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}



	public String getRegion() {
		return region;
	}



	public void setRegion(String region) {
		this.region = region;
	}



	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}
}
