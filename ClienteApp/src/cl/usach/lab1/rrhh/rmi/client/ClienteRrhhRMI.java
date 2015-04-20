package cl.usach.lab1.rrhh.rmi.client;


import java.rmi.RemoteException;
import java.util.List;

import cl.usach.lab1.rrhh.rmi.conn.ConexionRrhhRMI;
import cl.usach.lab1.rrhh.rmi.interfaces.RrhhInterface;
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
public class ClienteRrhhRMI {
    public static int Puerto = 2015;                                 //Número del puerto que está alojado el servidor
    public static String IPServer = "localhost";                    //Dirección IP del servidor, la cual podría utilizarse por defecto el localhost
    public static String nombreReferenciaRrhhRemota = "RRHH-RMI";
    
    private static RrhhInterface objetoRemoto;
    private ConexionRrhhRMI conexion;
    
    public ClienteRrhhRMI() throws RemoteException {
    	conexion = new ConexionRrhhRMI();
	}
    
    
    //TRABAJADORES
    public Trabajador loginUsuario(String nomus, String passwd) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaRrhhRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.loginTrabajador(nomus, passwd);
    	}
    	return null;
    }
    
    public List<Trabajador> listarTrabajadores() throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaRrhhRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.listarTrabajadores();
    	}
    	return null;
    }
    
    public boolean ingresarTrabajador(Trabajador trb) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaRrhhRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.ingresarTrabajador(trb);
    	}
    	return false;
    }
    
    public boolean modificarTrabajador(Trabajador trb) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaRrhhRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.modificarTrabajador(trb);
    	}
    	return false;
    }
    
    public boolean eliminarTrabajador(int id_trabajador) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaRrhhRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.eliminarTrabajador(id_trabajador);
    	}
    	return false;
    }
    
    public Trabajador getTrabajadorByRut(String rut) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaRrhhRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.getTrabajadorByRut(rut);
    	}
    	return null;
    }
    
    
    //CARGOS   
    public List<Cargo> listarCargos() throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaRrhhRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.listarCargos();
    	}
    	return null;
    }
    
    public boolean ingresarCargo(Cargo crg) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaRrhhRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.ingresarCargo(crg);
    	}
    	return false;
    }
    
    public boolean modificarCargo(Cargo crg) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaRrhhRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.modificarCargo(crg);
    	}
    	return false;
    }
    
    public boolean eliminarCargo(int id_cargo) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaRrhhRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.eliminarCargo(id_cargo);
    	}
    	return false;
    }
    public Cargo getCargoById(int id_cargo) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaRrhhRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.getCargoById(id_cargo);
    	}
    	return null;
    }
    
    //Departamentos
    
   
    public List<Departamento> listarDepartamentos() throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaRrhhRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.listarDepartamentos();
    	}
    	return null;
    }
    
    public boolean ingresarDepartamento(Departamento dep) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaRrhhRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.ingresarDepartamento(dep);
    	}
    	return false;
    }
    
    public boolean modificarDepartamento(Departamento dep) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaRrhhRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.modificarDepartamento(dep);
    	}
    	return false;
    }
    
    public boolean eliminarDepartamento(int id_departamento) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaRrhhRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.eliminarDepartamento(id_departamento);
    	}
    	return false;
    }
    
    public Departamento getDepartamentoById(int id_departamento) throws RemoteException{
    	if (conexion.iniciarRegistro(IPServer, Puerto, nombreReferenciaRrhhRemota)) {
    		objetoRemoto = conexion.getServidor();
    		return objetoRemoto.getDepartamentoById(id_departamento);
    	}
    	return null;
    }
    
    //Fin Departamentos
     
}
