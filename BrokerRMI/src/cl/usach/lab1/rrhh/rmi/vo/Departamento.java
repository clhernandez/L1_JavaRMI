package cl.usach.lab1.rrhh.rmi.vo;

import java.io.Serializable;


public class Departamento implements Serializable{
	
	//private static final long serialVersionUID = 7162625965979518700L;   ????????????
	private int id_departamento;
	private String nombre_departamento;
	private String administrador;
	private String ubicacion;
	
	public int getId_departamento() {
		return id_departamento;
	}
	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
	}
	public String getNombre_departamento() {
		return nombre_departamento;
	}
	public void setNombre_departamento(String nombre_departamento) {
		this.nombre_departamento = nombre_departamento;
	}
	public String getAdministrador() {
		return administrador;
	}
	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String Ubicacion) {
		this.ubicacion = ubicacion;
	}
		
}
