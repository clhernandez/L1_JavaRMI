package cl.usach.lab1.rrhh.actions;

import java.util.List;

import cl.usach.lab1.rrhh.rmi.client.ClienteRrhhRMI;
import cl.usach.lab1.rrhh.rmi.vo.Cargo;
import cl.usach.lab1.rrhh.rmi.vo.Departamento;
import cl.usach.lab1.rrhh.rmi.vo.Trabajador;

import com.opensymphony.xwork2.ActionSupport;

public class IngresarTrabajadorAction extends ActionSupport{
	private String rut;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private String telefono;
	private String fecha_contratacion;
	private String sueldo;
	private int id_cargo_fk;
	private int id_departamento_fk;
	
	private List<Cargo> cargos;
	private List<Departamento> departamentos;
	
	//Mensajes
	private String msj;
	
	public String execute() throws Exception {
		ClienteRrhhRMI clienteRRHH = new ClienteRrhhRMI();
		if(rut!=null){
			Trabajador trb = new Trabajador();
			trb.setRut(rut);
			trb.setNombre(nombre);
			trb.setApellido(apellido);
			trb.setEmail(email);
			trb.setTelefono(telefono);
			trb.setFecha_contratacion(fecha_contratacion);
			trb.setSueldo(Integer.parseInt(sueldo));
			trb.setId_cargo_fk(id_cargo_fk);
			trb.setId_departamento_fk(id_departamento_fk);
			
			if(clienteRRHH.ingresarTrabajador(trb)){
				msj = "Trabajador ingresado correctamente.";
			}else{
				msj = "El usuario no fue ingresado.";
			}
		}
			departamentos = clienteRRHH.listarDepartamentos();
			cargos = clienteRRHH.listarCargos();
		
		
		return SUCCESS;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFecha_contratacion() {
		return fecha_contratacion;
	}

	public void setFecha_contratacion(String fecha_contratacion) {
		this.fecha_contratacion = fecha_contratacion;
	}

	public String getSueldo() {
		return sueldo;
	}

	public void setSueldo(String sueldo) {
		this.sueldo = sueldo;
	}

	public int getId_cargo_fk() {
		return id_cargo_fk;
	}

	public void setId_cargo_fk(int id_cargo_fk) {
		this.id_cargo_fk = id_cargo_fk;
	}

	public int getId_departamento_fk() {
		return id_departamento_fk;
	}

	public void setId_departamento_fk(int id_departamento_fk) {
		this.id_departamento_fk = id_departamento_fk;
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

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}
}
