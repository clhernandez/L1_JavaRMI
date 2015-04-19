package cl.usach.lab1.finanzas.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import cl.usach.lab1.finanzas.rmi.vo.Cliente;
import cl.usach.lab1.finanzas.rmi.vo.OrdenProducto;
import cl.usach.lab1.finanzas.rmi.vo.Producto;

public interface FinanzasInterface extends Remote {
	
	public boolean loginUsuario(String usuario, String password) throws RemoteException;

	//Metodos CRUD para Clientes
	public boolean ingresarCliente(Cliente cliente) throws RemoteException;
	public boolean modificarCliente(Cliente cliente) throws RemoteException;
	public boolean eliminarCliente(int id_cliente) throws RemoteException;
	public Cliente getClienteById(int id_cliente) throws RemoteException;
	public List<Cliente> listarClientes() throws RemoteException;

	//Metodos CRUD para Productos
	public boolean ingresarProducto(Producto producto) throws RemoteException;
	public boolean modificarProducto(Producto producto) throws RemoteException;
	public boolean eliminarProducto(int id_producto) throws RemoteException;
	public Producto getProductoById(int id_producto) throws RemoteException;
	public List<Producto> listarProductos() throws RemoteException;

	//Metodos CRUD para Orden Productos
	public boolean ingresarOrdenProducto(OrdenProducto ordenProducto) throws RemoteException;
	public boolean modificarOrdenProducto(OrdenProducto ondenProducto) throws RemoteException;
	public boolean eliminarOrdenProducto(int id_orden_producto) throws RemoteException;
	public OrdenProducto getOrdenProductoById(int id_orden_producto) throws RemoteException;
	public List<OrdenProducto> listarOrdenProductos() throws RemoteException;


}

