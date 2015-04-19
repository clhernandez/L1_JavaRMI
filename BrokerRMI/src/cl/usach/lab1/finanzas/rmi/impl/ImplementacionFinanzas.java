package cl.usach.lab1.finanzas.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




import cl.usach.lab1.db.DAO.finanzas.ClienteDAO;
import cl.usach.lab1.finanzas.rmi.interfaces.FinanzasInterface;
import cl.usach.lab1.finanzas.rmi.vo.Cliente;


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
	
	
}
