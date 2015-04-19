package cl.usach.lab1.finanzas.actions.json.cliente;

import java.rmi.RemoteException;






import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;
import cl.usach.lab1.finanzas.rmi.vo.Cliente;

import com.opensymphony.xwork2.ActionSupport;

public class ModificarClienteJsonAction extends ActionSupport {

	private static final long serialVersionUID = -2922647661879878990L;
	private int id_cliente;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private String ciudad;
	private String region;
	private String msj;

	public String execute() {
		try {
			ClienteFinanzasRMI cliente = new ClienteFinanzasRMI();
			Cliente clt = new Cliente();
			clt.setNombre(nombre);
			clt.setApellido(apellido);
			clt.setDireccion(direccion);
			clt.setTelefono(telefono);
			clt.setCiudad(ciudad);
			clt.setRegion(region);
			clt.setId_cliente(id_cliente);
			
			if(cliente.modificarCliente(clt)){
				msj= "Cliente modificado exitosamente.";
			}else{
				msj= "Cliente no pudo ser modificado.";
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


	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}

}

