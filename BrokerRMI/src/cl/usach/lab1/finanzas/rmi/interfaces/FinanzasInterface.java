package cl.usach.lab1.finanzas.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import cl.usach.lab1.finanzas.rmi.vo.Cliente;
import cl.usach.lab1.rrhh.rmi.vo.Cargo;

public interface FinanzasInterface extends Remote {

	//Metodos CRUD para Clientes
	public boolean ingresarCliente(Cliente cliente) throws RemoteException;
	public boolean modificarCliente(Cliente cliente) throws RemoteException;
	public boolean eliminarCliente(int id_cliente) throws RemoteException;
	public Cliente getClienteById(int id_cliente) throws RemoteException;
	public List<Cliente> listarClientes() throws RemoteException;
	
}
