package cl.usach.lab1.rrhh.rmi.conn;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import cl.usach.lab1.rrhh.rmi.interfaces.RrhhInterface;

/**
*
* @author Daniel Wladdimiro Cottet
* @title Taller de sistemas distribuidos - Clase 1
* 
* Modificado por clhernandez 12-04-2015
*/
public class ConexionRrhhRMI {
    private Registry registry;  //Registro de la conexión del usuario con el servidor
    private boolean conectado;  //Estado de conexión del usuario con el servidor
    private RrhhInterface servidor; //Interface necesaria para la comunición con el objecto del servidor

    public ConexionRrhhRMI() {
        this.conectado = false;
        this.registry = null;
        this.servidor = null;
    }
    
    public boolean iniciarRegistro(String IP, int Puerto, String nombreObjetoRemoto) throws RemoteException {
        try {
            
            //Se le otorga el permiso necesario para poder ejecutar las funciones correspondientes
            java.security.AllPermission allPermision = new java.security.AllPermission();          
            System.setProperty("java.security.policy", "rmi.policy");
            //Se inicia RMI-Registry para el registro del objeto
            
            try {
                //Obtenemos el Registry del servidor RMI
                registry = LocateRegistry.getRegistry(IP, Puerto);
            //De existir algún error con el registro que se desea obtener del servidor, se mostrará un mensaje
            } catch (RemoteException e) {
                System.out.println(IP + ":" + Puerto);
                System.out.println(e.getMessage());
                System.out.println(e.toString());
            }

            //Vamos al Registry y miramos el Objeto "nombreObjRemoto" para poder usarlo.
            servidor = (RrhhInterface) registry.lookup(nombreObjetoRemoto);
            this.conectado = true;
            return true;
            
        //De existir algún error con la conexión al servidor, se mostrará un mensaje
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Error: No se posee conexion");
            
            this.conectado = false;
            return false;
        }

    }
    
    //Getting y Setting de los atributos de ConexionCliente

    public Registry getRegistry() {
        return registry;
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
    }

    public boolean getConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    public RrhhInterface getServidor() {
        return servidor;
    }

    public void setServidor(RrhhInterface servidor) {
        this.servidor = servidor;
    }
}
