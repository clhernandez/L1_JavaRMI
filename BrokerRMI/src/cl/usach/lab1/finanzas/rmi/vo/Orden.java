package cl.usach.lab1.finanzas.rmi.vo;

import java.io.Serializable;

public class Orden  implements Serializable{

	private static final long serialVersionUID = -890714429824228929L;
	private int id_orden;
	private int id_cliente;
	private String fecha_orden;
	public int getId_orden() {
		return id_orden;
	}
	public void setId_orden(int id_orden) {
		this.id_orden = id_orden;
	}

	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getFecha_orden() {
		return fecha_orden;
	}
	public void setFecha_orden(String fecha_orden) {
		this.fecha_orden = fecha_orden;
	}
	
	
	
	
	
	
}
