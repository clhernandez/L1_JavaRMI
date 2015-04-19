package cl.usach.lab1.finanzas.actions.ordenProductos;

import java.util.List;

import cl.usach.lab1.finanzas.rmi.client.ClienteFinanzasRMI;
import cl.usach.lab1.finanzas.rmi.vo.OrdenProducto;
import cl.usach.lab1.finanzas.rmi.vo.Producto;

import com.opensymphony.xwork2.ActionSupport;

public class IngresarOrdenProductoAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3705891033531596087L;
	private String id_producto;
	private List<Producto> productos;
	private int cantidad;
	
	//Mensajes
	private String msj;
	
	public String execute() throws Exception {
			ClienteFinanzasRMI clienteFinanzas = new ClienteFinanzasRMI();
			
			if(id_producto !=null && id_producto.isEmpty()==false){
				
				OrdenProducto oPrd = new OrdenProducto();
				oPrd.setId_producto(Integer.parseInt(id_producto));
				oPrd.setCantidad(cantidad);
				
				if(clienteFinanzas.ingresarOrdenProducto(oPrd)){
					msj = "La Orden Producto fue ingresada correctamente.";
				}else{
					msj = "La Orden Producto no pudo ser ingresada.";
				}
			}else{
				productos = clienteFinanzas.listarProductos();
			}
		return SUCCESS;
	}

	public String getId_producto() {
		return id_producto;
	}



	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}
}
