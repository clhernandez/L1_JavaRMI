package cl.usach.lab1.finanzas.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import cl.usach.lab1.db.DAO.finanzas.ProductoDAO;
import cl.usach.lab1.finanzas.rmi.interfaces.FinanzasInterface;
import cl.usach.lab1.finanzas.rmi.vo.Producto;

public class ImplementacionFinanzas extends UnicastRemoteObject implements
		FinanzasInterface {

	private static final long serialVersionUID = 2766405946067358593L;
	static Logger logger;
	
	public ImplementacionFinanzas() throws RemoteException {
		super();
		logger = Logger.getLogger(getClass().getName());
        logger.log(Level.INFO, "Se ha instanciado la clase de ImplementacionFinanzas");
	}
	
	//CRUD PRODUCTOS
	@Override
	public boolean ingresarProducto(Producto producto) throws RemoteException {
		logger.log(Level.INFO, "Ingresar Producto...");
		ProductoDAO objPrd = new ProductoDAO();
		boolean resultado = false;
		try {
			 resultado = objPrd.ingresarProducto(producto);
			logger.log(Level.INFO, "resultado ingresarProducto: " + resultado);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public boolean modificarProducto(Producto producto) throws RemoteException {
		logger.log(Level.INFO, "modificar Producto...");
		ProductoDAO objPrd = new ProductoDAO();
		boolean resultado = false;
		try {
			 resultado = objPrd.modificarProducto(producto);
			logger.log(Level.INFO, "resultado modificarProducto: " + resultado);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public boolean eliminarProducto(int id_producto) throws RemoteException {
		logger.log(Level.INFO, "eliminar Producto...");
		ProductoDAO objPrd = new ProductoDAO();
		boolean resultado = false;
		try {
			 resultado = objPrd.eliminarProducto(id_producto);
			logger.log(Level.INFO, "resultado eliminarProducto: " + resultado);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Producto getProductoById(int id_producto) throws RemoteException {
		logger.log(Level.INFO, "obtener Producto...");
		ProductoDAO objPrd = new ProductoDAO();
		Producto producto = null;
		try {
			producto = objPrd.getProductoById(id_producto);
			logger.log(Level.INFO, "resultado getProductoById: " + producto);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return producto;
	}

	@Override
	public List<Producto> listarProductos() throws RemoteException {
		logger.log(Level.INFO, "Listar Productos...");
		ProductoDAO objPrd = new ProductoDAO();
		List<Producto> productos = null;
		try {
			productos = objPrd.listarProductos();
			logger.log(Level.INFO, "resultado listarProductos: " + productos.size());
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return productos;
	}
	//FIN CRUD PRODUCTOS
}
