package cl.usach.lab1.rrhh.rmi.client;


import java.rmi.RemoteException;
import java.util.HashMap;

import cl.usach.lab1.rrhh.rmi.conn.ConexionRrhhRMI;
import cl.usach.lab1.rrhh.rmi.interfaces.RrhhInterface;


public class ClienteRrhhRMI {
    public static int Puerto = 2015;                                 //Número del puerto que está alojado el servidor
    public static String IPServer = "localhost";                    //Dirección IP del servidor, la cual podría utilizarse por defecto el localhost
    public static String nombreReferenciaRrhhRemota = "RRHH-RMI";
    
    private static RrhhInterface objetoRemoto;
    private ConexionRrhhRMI conexion;
    
    public ClienteRrhhRMI() throws RemoteException {
    	conexion = new ConexionRrhhRMI();
	}
    
    public HashMap loginUsuario(String nomus, String passwd) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaRrhhRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.getTrabajador(nomus, passwd);
    	}
    	return null;
    }
      
}
