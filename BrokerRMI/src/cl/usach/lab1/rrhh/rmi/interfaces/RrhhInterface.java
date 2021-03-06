package cl.usach.lab1.rrhh.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import cl.usach.lab1.rrhh.rmi.vo.Cargo;
import cl.usach.lab1.rrhh.rmi.vo.Departamento;
import cl.usach.lab1.rrhh.rmi.vo.Trabajador;

/**
*
* @author Daniel Wladdimiro Cottet
* @title Taller de sistemas distribuidos - Clase 1
* 
* Modificado por clhernandez 12-04-2015
*/
public interface RrhhInterface extends Remote {
	
	//Metodos CRUD para Trabajadores.
	public boolean ingresarTrabajador(Trabajador trabajador) throws RemoteException;
	public boolean modificarTrabajador(Trabajador trabajador) throws RemoteException;
	public boolean eliminarTrabajador(int id_trabajador) throws RemoteException;
	public Trabajador loginTrabajador(String usuario, String password) throws RemoteException;
	public Trabajador getTrabajadorByRut(String rut) throws RemoteException;
	public List<Trabajador> listarTrabajadores() throws RemoteException;

//Metodos CRUD para Departamentos
	public boolean ingresarDepartamento(Departamento departamento) throws RemoteException;
	public boolean modificarDepartamento(Departamento departamento) throws RemoteException;
	public boolean eliminarDepartamento(int id_departamento) throws RemoteException;
	public List<Departamento> listarDepartamentos() throws RemoteException;
	public Departamento getDepartamentoById(int id_departamento) throws RemoteException;
	
	//Metodos CRUD para Cargos
	public boolean ingresarCargo(Cargo cargo) throws RemoteException;
	public boolean modificarCargo(Cargo cargo) throws RemoteException;
	public boolean eliminarCargo(int id_cargo) throws RemoteException;
	public Cargo getCargoById(int id_cargo) throws RemoteException;
	public List<Cargo> listarCargos() throws RemoteException;
	
}