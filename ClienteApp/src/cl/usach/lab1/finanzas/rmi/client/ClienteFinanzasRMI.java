package cl.usach.lab1.finanzas.rmi.client;


import java.rmi.RemoteException;

import cl.usach.lab1.finanzas.rmi.conn.ConexionFinanzasRMI;
import cl.usach.lab1.finanzas.rmi.interfaces.FinanzasInterface;


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
      
}
