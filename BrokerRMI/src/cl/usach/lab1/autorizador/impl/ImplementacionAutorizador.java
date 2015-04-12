package cl.usach.lab1.autorizador.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

import cl.usach.lab1.autorizador.interfaces.AutorizadorInterface;

public class ImplementacionAutorizador extends UnicastRemoteObject implements
AutorizadorInterface{
	
	private static final long serialVersionUID = -8140717671004234406L;
	static Logger logger;
	
	public ImplementacionAutorizador() throws RemoteException {
		super();
		logger = Logger.getLogger(getClass().getName());
        logger.log(Level.INFO, "Se ha instanciado la clase de ImplementacionAutorizador");
	}

	@Override
	public boolean autenticarUsuario(String usuario, String password)
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
