package cl.usach.lab1.rrhh.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface RrhhInterface extends Remote {
	public HashMap getTrabajador(String usuario, String password) throws RemoteException;
}
