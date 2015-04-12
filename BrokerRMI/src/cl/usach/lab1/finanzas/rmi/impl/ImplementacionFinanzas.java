package cl.usach.lab1.finanzas.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

import cl.usach.lab1.finanzas.rmi.interfaces.FinanzasInterface;

public class ImplementacionFinanzas extends UnicastRemoteObject implements
		FinanzasInterface {

	private static final long serialVersionUID = 2766405946067358593L;
	static Logger logger;
	
	public ImplementacionFinanzas() throws RemoteException {
		super();
		logger = Logger.getLogger(getClass().getName());
        logger.log(Level.INFO, "Se ha instanciado la clase de ImplementacionFinanzas");
	}
	
	@Override
	public boolean loginUsuario(String usuario, String password)
			throws RemoteException {
		//TODO implementar la conexion a BD y validar al usuario
		logger.log(Level.INFO, "Login usuario...");
		if(usuario.isEmpty()==false && password.isEmpty()==false){
			logger.log(Level.INFO, "Login usuario...ok");
			return true;
		}
		logger.log(Level.INFO, "Login usuario...nok");
		return false;
	}

}
