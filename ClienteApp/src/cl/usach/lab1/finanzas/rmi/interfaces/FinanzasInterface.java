package cl.usach.lab1.finanzas.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FinanzasInterface extends Remote {
	
	public boolean loginUsuario(String usuario, String password) throws RemoteException;

}
