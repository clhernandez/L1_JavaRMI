package cl.usach.lab1.autorizador.client;


import java.rmi.RemoteException;

import cl.usach.lab1.autorizador.conn.ConexionAutorizadorRMI;
import cl.usach.lab1.autorizador.interfaces.AutorizadorInterface;


public class ClienteAutorizadorRMI {
    public static int Puerto = 2015;                                 //Número del puerto que está alojado el servidor
    public static String IPServer = "localhost";                    //Dirección IP del servidor, la cual podría utilizarse por defecto el localhost
    public static String nombreReferenciaFinanzasRemota = "AUTORIZADOR-RMI";
    
    private static AutorizadorInterface objetoRemoto;
    private ConexionAutorizadorRMI conexion;
    
    public ClienteAutorizadorRMI() throws RemoteException {
    	conexion = new ConexionAutorizadorRMI();
	}
    
    public boolean loginUsuario(String nomus, String passwd) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaFinanzasRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.autenticarUsuario(nomus, passwd);
    	}
    	return false;
    }
      
}
