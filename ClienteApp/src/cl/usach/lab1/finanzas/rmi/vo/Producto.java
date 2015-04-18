package cl.usach.lab1.finanzas.rmi.vo;

import java.io.Serializable;

public class Producto  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4433457001161844796L;
	private int id_producto;
	private String nombre;
	private int precio;
	private String descripcion;
	
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
