package cl.usach.lab1.rrhh.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import cl.usach.lab1.rrhh.rmi.interfaces.RrhhInterface;

public class ImplementacionRrhh extends UnicastRemoteObject implements
		RrhhInterface {

	private static final long serialVersionUID = -4208030392325540142L;

	public ImplementacionRrhh() throws RemoteException {
		super();
	}

}
