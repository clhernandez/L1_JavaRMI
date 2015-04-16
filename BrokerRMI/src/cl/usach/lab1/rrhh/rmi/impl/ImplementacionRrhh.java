package cl.usach.lab1.rrhh.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import cl.usach.lab1.db.DAO.rrhh.TrabajadorDAO;
import cl.usach.lab1.rrhh.rmi.interfaces.RrhhInterface;
import cl.usach.lab1.rrhh.rmi.vo.Trabajador;

public class ImplementacionRrhh extends UnicastRemoteObject implements
		RrhhInterface {

	private static final long serialVersionUID = -4208030392325540142L;
	static Logger logger;
	
	public ImplementacionRrhh() throws RemoteException {
		super();
		logger = Logger.getLogger(getClass().getName());
        logger.log(Level.INFO, "Se ha instanciado la clase de ImplementacionAutorizador");
	}

	@Override
	public List<HashMap> listarCargos() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	//CRUD Trabajadores
	@Override
	public boolean ingresarTrabajador(Trabajador trabajador)
			throws RemoteException {
		logger.log(Level.INFO, "Ingresar Trabajador...");
		TrabajadorDAO objRRHH = new TrabajadorDAO();
		boolean resultado = false;
		try {
			 resultado = objRRHH.ingresarTrabajador(trabajador);
			logger.log(Level.INFO, "resultado ingresarTrabajador: " + resultado);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public boolean modificarTrabajador(Trabajador trabajador)
			throws RemoteException {
		logger.log(Level.INFO, "Modificar Trabajador...");
		TrabajadorDAO objRRHH = new TrabajadorDAO();
		boolean resultado = false;
		try {
			 resultado = objRRHH.modificarTrabajador(trabajador);
			logger.log(Level.INFO, "resultado modificarTrabajador: " + resultado);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public boolean eliminarTrabajador(int id_trabajador) throws RemoteException {
		logger.log(Level.INFO, "Eliminar Trabajador...");
		TrabajadorDAO objRRHH = new TrabajadorDAO();
		boolean resultado = false;
		try {
			 resultado = objRRHH.eliminarTrabajador(id_trabajador);
			logger.log(Level.INFO, "resultado EliminarTrabajador: " + resultado);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}
	@Override
	public Trabajador getTrabajadorByRut(String rut) throws RemoteException {
		logger.log(Level.INFO, "Get Trabajador...");
		TrabajadorDAO objRRHH = new TrabajadorDAO();
		Trabajador trabajador = null;
		try {
			trabajador = objRRHH.getTrabajadorByRut(rut);
			logger.log(Level.INFO, "resultado getTrabajador: " + trabajador);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return trabajador;
	}
	@Override
	public Trabajador loginTrabajador(String usuario, String password) throws RemoteException {
		logger.log(Level.INFO, "Login usuario...");
		TrabajadorDAO objRRHH = new TrabajadorDAO();
		Trabajador trabajador = null;
		try {
			trabajador = objRRHH.validarTrabajador(usuario, password);
			logger.log(Level.INFO, "resultado loginTrabajador: " + trabajador);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return trabajador;
	}
	@Override
	public List<Trabajador> listarTrabajadores() throws RemoteException {
		logger.log(Level.INFO, "Obteniendo Listado Trabajadores...");
		TrabajadorDAO dao = new TrabajadorDAO();
		List<Trabajador> trabajadores = new ArrayList();
		try {
			trabajadores = dao.listarTrabajadores();
			logger.log(Level.INFO, "Cantidad de trabajadores obtenidos: " + trabajadores.size());
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());			
			e.printStackTrace();
		}
		return trabajadores;
	}
	//FIN CRUD Trabajadores

}
