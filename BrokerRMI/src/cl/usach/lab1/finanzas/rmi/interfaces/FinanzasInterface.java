package cl.usach.lab1.finanzas.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import cl.usach.lab1.finanzas.rmi.vo.OrdenProducto;
import cl.usach.lab1.finanzas.rmi.vo.Producto;

public interface FinanzasInterface extends Remote {
	
	public boolean ingresarProducto(Producto producto) throws RemoteException;
	public boolean modificarProducto(Producto producto) throws RemoteException;
	public boolean eliminarProducto(int id_producto) throws RemoteException;
	public Producto getProductoById(int id_producto) throws RemoteException;
	public List<Producto> listarProductos() throws RemoteException;
	
	public boolean ingresarOrdenProducto(OrdenProducto ordenProducto) throws RemoteException;
	public boolean modificarOrdenProducto(OrdenProducto ondenProducto) throws RemoteException;
	public boolean eliminarOrdenProducto(int id_orden_producto) throws RemoteException;
	public OrdenProducto getOrdenProductoById(int id_orden_producto) throws RemoteException;
	public List<OrdenProducto> listarOrdenProductos() throws RemoteException;
}
