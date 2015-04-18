package cl.usach.lab1.finanzas.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import cl.usach.lab1.finanzas.rmi.vo.Producto;

public interface FinanzasInterface extends Remote {
	
	public boolean ingresarProducto(Producto producto) throws RemoteException;
	public boolean modificarProducto(Producto producto) throws RemoteException;
	public boolean eliminarProducto(int id_producto) throws RemoteException;
	public Producto getProductoById(int id_producto) throws RemoteException;
	public List<Producto> listarProductos() throws RemoteException;
}
