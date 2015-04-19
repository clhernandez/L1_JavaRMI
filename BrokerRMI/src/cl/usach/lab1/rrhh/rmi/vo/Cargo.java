package cl.usach.lab1.rrhh.rmi.vo;

import java.io.Serializable;

public class Cargo implements Serializable{
	

	private static final long serialVersionUID = 533253154507302755L;
	private int id_cargo;
	private String nombre_cargo;
	private int sueldo_min;
	private int sueldo_max;
	
	public int getId_cargo() {
		return id_cargo;
	}
	public void setId_cargo(int id_cargo) {
		this.id_cargo = id_cargo;
	}
	public String getNombre_cargo() {
		return nombre_cargo;
	}
	public void setNombre_cargo(String nombre_cargo) {
		this.nombre_cargo = nombre_cargo;
	}
	public int getSueldo_min() {
		return sueldo_min;
	}
	public void setSueldo_min(int sueldo_min) {
		this.sueldo_min = sueldo_min;
	}
	public int getSueldo_max() {
		return sueldo_max;
	}
	public void setSueldo_max(int sueldo_max) {
		this.sueldo_max = sueldo_max;
	}
	


	
}