package cl.usach.lab1.autorizador.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AutorizadorInterface extends Remote{
	public boolean autenticarUsuario(String usuario, String password) throws RemoteException;
}
