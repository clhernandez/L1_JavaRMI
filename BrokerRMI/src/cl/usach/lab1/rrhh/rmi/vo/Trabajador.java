package cl.usach.lab1.rrhh.rmi.vo;

import java.io.Serializable;

public class Trabajador implements Serializable{
	
	private static final long serialVersionUID = 7162625965979518700L;
	private int id_trabajador;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private String fecha_contratacion;
	private int id_cargo_fk;
	private int sueldo;
	private int comision_porc;
	private int id_departamento_fk;
	private String trabajadorescol;
	
	public int getId_trabajador() {
		return id_trabajador;
	}
	public void setId_trabajador(int id_trabajador) {
		this.id_trabajador = id_trabajador;
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
	public int getId_cargo_fk() {
		return id_cargo_fk;
	}
	public void setId_cargo_fk(int id_cargo_fk) {
		this.id_cargo_fk = id_cargo_fk;
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	public int getComision_porc() {
		return comision_porc;
	}
	public void setComision_porc(int comision_porc) {
		this.comision_porc = comision_porc;
	}
	public int getId_departamento_fk() {
		return id_departamento_fk;
	}
	public void setId_departamento_fk(int id_departamento_fk) {
		this.id_departamento_fk = id_departamento_fk;
	}
	public String getTrabajadorescol() {
		return trabajadorescol;
	}
	public void setTrabajadorescol(String trabajadorescol) {
		this.trabajadorescol = trabajadorescol;
	}
	
}
