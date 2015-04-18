package cl.usach.lab1.finanzas.rmi.client;


import java.rmi.RemoteException;
import java.util.List;

import cl.usach.lab1.finanzas.rmi.conn.ConexionFinanzasRMI;
import cl.usach.lab1.finanzas.rmi.interfaces.FinanzasInterface;
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

	
      
}
