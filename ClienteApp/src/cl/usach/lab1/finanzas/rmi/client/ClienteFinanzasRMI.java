package cl.usach.lab1.finanzas.rmi.client;


import java.rmi.RemoteException;
import java.util.List;

import cl.usach.lab1.finanzas.rmi.conn.ConexionFinanzasRMI;
import cl.usach.lab1.finanzas.rmi.interfaces.FinanzasInterface;
import cl.usach.lab1.finanzas.rmi.vo.Cliente;
import cl.usach.lab1.finanzas.rmi.vo.OrdenProducto;
import cl.usach.lab1.finanzas.rmi.vo.Producto;


public class ClienteFinanzasRMI {
    public static int Puerto = 2015;                                 //Número del puerto que está alojado el servidor
    public static String IPServer = "localhost";                    //Dirección IP del servidor, la cual podría utilizarse por defecto el localhost
    public static String nombreReferenciaFinanzasRemota = "FINANZAS-RMI";
    
    private static FinanzasInterface objetoRemoto;
    private ConexionFinanzasRMI conexion;
    
    public ClienteFinanzasRMI() throws RemoteException {
    	conexion = new ConexionFinanzasRMI();
	}
    
    /**
     * CRUD PRODUCTOS
     */
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
      
      public boolean ingresarProducto(Producto producto) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaFinanzasRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.ingresarProducto(producto);
    	}
    	return false;
    }
    
    public boolean modificarProducto(Producto producto) throws RemoteException {
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaFinanzasRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.modificarProducto(producto);
    	}
    	return false;
	}
    
    public boolean eliminarProducto(int id_producto) throws RemoteException {
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaFinanzasRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.eliminarProducto(id_producto);
    	}
    	return false;
	}
    
    public Producto getProductoById(int id_producto) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaFinanzasRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.getProductoById(id_producto);
    	}
    	return null;
    }
    
    public List<Producto> listarProductos() throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaFinanzasRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.listarProductos();
    	}
    	return null;
    }
    /**
     * CRUD ORDEN PRODUCTO
     */
    public boolean ingresarOrdenProducto(OrdenProducto ordenProducto) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaFinanzasRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.ingresarOrdenProducto(ordenProducto);
    	}
    	return false;
    }
    
    public boolean modificarOrdenProducto(OrdenProducto ordenProducto) throws RemoteException {
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaFinanzasRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.modificarOrdenProducto(ordenProducto);
    	}
    	return false;
	}
    
    public boolean eliminarOrdenProducto(int id_ordenProducto) throws RemoteException {
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaFinanzasRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.eliminarOrdenProducto(id_ordenProducto);
    	}
    	return false;
	}
    
    public OrdenProducto getOrdenProductoById(int id_ordenProducto) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaFinanzasRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.getOrdenProductoById(id_ordenProducto);
    	}
    	return null;
    }
    
    public List<OrdenProducto> listarOrdenProductos() throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaFinanzasRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.listarOrdenProductos();
    	}
    	return null;
    }
}
