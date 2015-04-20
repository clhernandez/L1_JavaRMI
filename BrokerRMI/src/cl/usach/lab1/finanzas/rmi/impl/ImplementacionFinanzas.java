package cl.usach.lab1.finanzas.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




import cl.usach.lab1.finanzas.rmi.vo.OrdenProducto;
import cl.usach.lab1.db.DAO.finanzas.OrdenDAO;
import cl.usach.lab1.db.DAO.finanzas.OrdenProductoDAO;
import cl.usach.lab1.db.DAO.finanzas.ClienteDAO;
import cl.usach.lab1.db.DAO.finanzas.ProductoDAO;
import cl.usach.lab1.finanzas.rmi.interfaces.FinanzasInterface;
import cl.usach.lab1.finanzas.rmi.vo.Cliente;
import cl.usach.lab1.finanzas.rmi.vo.Orden;
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
	
	//CRUD Clientes
	@Override
	public boolean ingresarCliente(Cliente cliente) throws RemoteException {
		logger.log(Level.INFO, "Ingresar Cliente...");
		ClienteDAO objFINANZAS = new ClienteDAO();
		boolean resultado = false;
		try {
			 resultado = objFINANZAS.ingresarCliente(cliente);
			logger.log(Level.INFO, "resultado ingresarCliente: " + resultado);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public boolean modificarCliente(Cliente cliente) throws RemoteException {
		logger.log(Level.INFO, "Modificar Cliente...");
		ClienteDAO objFINANZAS = new ClienteDAO();
		boolean resultado = false;
		try {
			 resultado = objFINANZAS.modificarCliente(cliente);
			logger.log(Level.INFO, "resultado modificarCliente: " + resultado);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public boolean eliminarCliente(int id_cliente) throws RemoteException {
		logger.log(Level.INFO, "Eliminar Cliente...");
		ClienteDAO objFINANZAS = new ClienteDAO();
		boolean resultado = false;
		try {
			 resultado = objFINANZAS.eliminarCliente(id_cliente);
			logger.log(Level.INFO, "resultado EliminarCliente: " + resultado);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}
	@Override
	public Cliente getClienteById(int id_cliente) throws RemoteException {
		logger.log(Level.INFO, "Get Cliente...");
		ClienteDAO objFINANZAS = new ClienteDAO();
		Cliente cliente = null;
		try {
			cliente = objFINANZAS.getClienteById(id_cliente);
			logger.log(Level.INFO, "resultado getCliente: " + cliente);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return cliente;
	}
	@Override
	public List<Cliente> listarClientes() throws RemoteException {
		logger.log(Level.INFO, "Obteniendo Listado Cliente...");
		ClienteDAO dao = new ClienteDAO();
		List<Cliente> clientes = new ArrayList();
		try {
			clientes = dao.listarClientes();
			logger.log(Level.INFO, "Cantidad de clientes obtenidos: " + clientes.size());
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());			
			e.printStackTrace();
		}
		return clientes;
	}
	//FIN CRUD Clientes
	
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
	
	//CRUD ORDEN_PRODUCTOS
		@Override
		public boolean ingresarOrdenProducto(OrdenProducto ordenProducto)
				throws RemoteException {
			logger.log(Level.INFO, "Ingresar OrdenProducto...");
			OrdenProductoDAO objOPrd = new OrdenProductoDAO();
			boolean resultado = false;
			try {
				 resultado = objOPrd.ingresarOrdenProducto(ordenProducto);
				logger.log(Level.INFO, "resultado ingresarOrdenProducto: " + resultado);
			} catch (ClassNotFoundException | SQLException e) {
				logger.log(Level.WARNING, e.getMessage());
				e.printStackTrace();
			}
			return resultado;
		}

		@Override
		public boolean modificarOrdenProducto(OrdenProducto ondenProducto)
				throws RemoteException {
			logger.log(Level.INFO, "modificar OrdenProducto...");
			OrdenProductoDAO objOPrd = new OrdenProductoDAO();
			boolean resultado = false;
			try {
				 resultado = objOPrd.modificarOrdenProducto(ondenProducto);
				logger.log(Level.INFO, "resultado modificarOrdenProducto: " + resultado);
			} catch (ClassNotFoundException | SQLException e) {
				logger.log(Level.WARNING, e.getMessage());
				e.printStackTrace();
			}
			return resultado;
		}

		@Override
		public boolean eliminarOrdenProducto(int id_orden_producto)
				throws RemoteException {
			logger.log(Level.INFO, "eliminar OrdenProducto...");
			OrdenProductoDAO objOPrd = new OrdenProductoDAO();
			boolean resultado = false;
			try {
				 resultado = objOPrd.eliminarOrdenProducto(id_orden_producto);
				logger.log(Level.INFO, "resultado eliminarOrdenProducto: " + resultado);
			} catch (ClassNotFoundException | SQLException e) {
				logger.log(Level.WARNING, e.getMessage());
				e.printStackTrace();
			}
			return resultado;
		}

		@Override
		public OrdenProducto getOrdenProductoById(int id_orden_producto)
				throws RemoteException {
			logger.log(Level.INFO, "obtener OrdenProducto...");
			OrdenProductoDAO objOPrd = new OrdenProductoDAO();
			OrdenProducto ordenProducto = null;
			try {
				ordenProducto = objOPrd.getOrdenProductoById(id_orden_producto);
				logger.log(Level.INFO, "resultado getOrdenProductoById: " + ordenProducto);
			} catch (ClassNotFoundException | SQLException e) {
				logger.log(Level.WARNING, e.getMessage());
				e.printStackTrace();
			}
			return ordenProducto;
		}

		@Override
		public List<OrdenProducto> listarOrdenProductos() throws RemoteException {
			logger.log(Level.INFO, "Listar Orden Productos...");
			OrdenProductoDAO objOPrd = new OrdenProductoDAO ();
			List<OrdenProducto> ordenProductos = null;
			try {
				ordenProductos = objOPrd.listarOrdenProductos();
				logger.log(Level.INFO, "resultado listarOrdenProductos: " + ordenProductos.size());
			} catch (ClassNotFoundException | SQLException e) {
				logger.log(Level.WARNING, e.getMessage());
				e.printStackTrace();
			}
			return ordenProductos;
		}
		//FIN CRUD ORDEN_PRODUCTOS
		
		//CRUD ORDENES
		@Override
		public boolean ingresarOrden(Orden orden)
				throws RemoteException {
			logger.log(Level.INFO, "Ingresar Orden...");
			OrdenDAO objOPrd = new OrdenDAO();
			boolean resultado = false;
			try {
				 resultado = objOPrd.ingresarOrden(orden);
				logger.log(Level.INFO, "resultado ingresarOrden: " + resultado);
			} catch (ClassNotFoundException | SQLException e) {
				logger.log(Level.WARNING, e.getMessage());
				e.printStackTrace();
			}
			return resultado;
		}

		@Override
		public boolean modificarOrden(Orden orden)
				throws RemoteException {
			logger.log(Level.INFO, "modificar Orden...");
			OrdenDAO objOPrd = new OrdenDAO();
			boolean resultado = false;
			try {
				 resultado = objOPrd.modificarOrden(orden);
				logger.log(Level.INFO, "resultado modificarOrden: " + resultado);
			} catch (ClassNotFoundException | SQLException e) {
				logger.log(Level.WARNING, e.getMessage());
				e.printStackTrace();
			}
			return resultado;
		}

		@Override
		public boolean eliminarOrden(int id_orden)
				throws RemoteException {
			logger.log(Level.INFO, "eliminar Orden..." + id_orden);
			OrdenDAO objOPrd = new OrdenDAO();
			boolean resultado = false;
			try {
				 resultado = objOPrd.eliminarOrden(id_orden);
				logger.log(Level.INFO, "resultado eliminarOrden: " + resultado);
			} catch (ClassNotFoundException | SQLException e) {
				logger.log(Level.WARNING, e.getMessage());
				e.printStackTrace();
			}
			return resultado;
		}

		@Override
		public Orden getOrdenById(int id_orden)
				throws RemoteException {
			logger.log(Level.INFO, "obtener Orden...");
			OrdenDAO objOPrd = new OrdenDAO();
			Orden orden = null;
			try {
				orden = objOPrd.getOrdenById(id_orden);
				logger.log(Level.INFO, "resultado getOrdenById: " + orden);
			} catch (ClassNotFoundException | SQLException e) {
				logger.log(Level.WARNING, e.getMessage());
				e.printStackTrace();
			}
			return orden;
		}

		@Override
		public List<Orden> listarOrdenes() throws RemoteException {
			logger.log(Level.INFO, "Listar Ordenes...");
			OrdenDAO objOPrd = new OrdenDAO ();
			List<Orden> ordenes = null;
			try {
				ordenes = objOPrd.listarOrdenes();
				logger.log(Level.INFO, "resultado listarOrdenes: " + ordenes.size());
			} catch (ClassNotFoundException | SQLException e) {
				logger.log(Level.WARNING, e.getMessage());
				e.printStackTrace();
			}
			return ordenes;
		}
		//FIN CRUD ORDENES
	
}
