package cl.usach.lab1.finanzas.actions.json.cliente;

import java.rmi.RemoteException;

import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;
import cl.usach.lab1.finanzas.rmi.vo.Cliente;


import com.opensymphony.xwork2.ActionSupport;

public class GetClienteByRutJsonAction extends ActionSupport {


	private static final long serialVersionUID = -2265665859968104370L;
	private int id_cliente;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private String ciudad;
	private String region;

	public String execute() {
		try {
			ClienteFinanzasRMI cliente = new ClienteFinanzasRMI();
			Cliente clt = cliente.getClienteById(id_cliente);
			if(clt!=null){
				id_cliente = clt.getId_cliente();
				nombre = clt.getNombre();
				apellido = clt.getApellido();
				direccion = clt.getDireccion();
				telefono = clt.getTelefono();
				ciudad = clt.getCiudad();
				region = clt.getRegion();

			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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


}
