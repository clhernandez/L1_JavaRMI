package cl.usach.lab1.finanzas.rmi.client;


import java.rmi.RemoteException;
import java.util.List;

import cl.usach.lab1.finanzas.rmi.conn.ConexionFinanzasRMI;
import cl.usach.lab1.finanzas.rmi.interfaces.FinanzasInterface;
import cl.usach.lab1.finanzas.rmi.vo.Cliente;


public class ClienteFinanzasRMI {
    public static int Puerto = 2015;                                 //Número del puerto que está alojado el servidor
    public static String IPServer = "localhost";                    //Dirección IP del servidor, la cual podría utilizarse por defecto el localhost
    public static String nombreReferenciaFinanzasRemota = "FINANZAS-RMI";
    
    private static FinanzasInterface objetoRemoto;
    private ConexionFinanzasRMI conexion;
    
    public ClienteFinanzasRMI() throws RemoteException {
    	conexion = new ConexionFinanzasRMI();
	}
    
    public boolean loginUsuario(String nomus, String passwd) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaFinanzasRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.loginUsuario(nomus, passwd);
    	}
    	return false;
    }
    
    //CLIENTES   
    public List<Cliente> listarClientes() throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaFinanzasRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.listarClientes();
    	}
    	return null;
    }
    
    public boolean ingresarCliente(Cliente clt) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaFinanzasRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.ingresarCliente(clt);
    	}
    	return false;
    }
    
    public boolean modificarCliente(Cliente clt) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaFinanzasRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.modificarCliente(clt);
    	}
    	return false;
    }
    
    public boolean eliminarCliente(int id_cliente) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaFinanzasRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.eliminarCliente(id_cliente);
    	}
    	return false;
    }
    public Cliente getClienteById(int id_cliente) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaFinanzasRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.getClienteById(id_cliente);
    	}
    	return null;
    }
      
}
