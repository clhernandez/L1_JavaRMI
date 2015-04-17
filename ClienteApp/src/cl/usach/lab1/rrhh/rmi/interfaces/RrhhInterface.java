package cl.usach.lab1.rrhh.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

import cl.usach.lab1.rrhh.rmi.vo.Cargo;
import cl.usach.lab1.rrhh.rmi.vo.Trabajador;

public interface RrhhInterface extends Remote {
	
	//Metodos CRUD para Trabajadores.
	public boolean ingresarTrabajador(Trabajador trabajador) throws RemoteException;
	public boolean modificarTrabajador(Trabajador trabajador) throws RemoteException;
	public boolean eliminarTrabajador(int id_trabajador) throws RemoteException;
	public Trabajador loginTrabajador(String usuario, String password) throws RemoteException;
	public Trabajador getTrabajadorByRut(String rut) throws RemoteException;
	public List<Trabajador> listarTrabajadores() throws RemoteException;

	//Metodos CRUD para Cargos
	public boolean ingresarCargo(Cargo cargo) throws RemoteException;
	public boolean modificarCargo(Cargo cargo) throws RemoteException;
	public boolean eliminarCargo(int id_cargo) throws RemoteException;
	public List<Cargo> listarCargos() throws RemoteException;
	
}