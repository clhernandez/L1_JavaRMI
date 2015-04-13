package cl.usach.lab1.rrhh.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import cl.usach.lab1.db.DAO.ProcesarRrhh;
import cl.usach.lab1.rrhh.rmi.interfaces.RrhhInterface;

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
	public HashMap getTrabajador(String usuario, String password) throws RemoteException {
		//TODO implementar la conexion a BD y validar al usuario
		logger.log(Level.INFO, "Login usuario...");
		ProcesarRrhh objRRHH = new ProcesarRrhh();
		HashMap trabajador = null;
		try {
			trabajador = objRRHH.getTrabajador(usuario, password);
			logger.log(Level.INFO, "resultado getTrabajador: " + trabajador);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return trabajador;
	}

}
