package cl.usach.lab1.rrhh.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import cl.usach.lab1.db.DAO.rrhh.CargoDAO;
import cl.usach.lab1.db.DAO.rrhh.TrabajadorDAO;
import cl.usach.lab1.db.DAO.rrhh.DepartamentoDAO;
import cl.usach.lab1.rrhh.rmi.interfaces.RrhhInterface;
import cl.usach.lab1.rrhh.rmi.vo.Departamento;
import cl.usach.lab1.rrhh.rmi.vo.Cargo;
import cl.usach.lab1.rrhh.rmi.vo.Trabajador;

/**
*
* @author Daniel Wladdimiro Cottet
* @title Taller de sistemas distribuidos - Clase 1
* 
* Modificado por clhernandez 12-04-2015
*/
public class ImplementacionRrhh extends UnicastRemoteObject implements
		RrhhInterface {

	private static final long serialVersionUID = -4208030392325540142L;
	static Logger logger;
	
	public ImplementacionRrhh() throws RemoteException {
		super();
		logger = Logger.getLogger(getClass().getName());
        logger.log(Level.INFO, "Se ha instanciado la clase de ImplementacionAutorizador");
	}


	//CRUD Trabajadores
	@Override
	public boolean ingresarTrabajador(Trabajador trabajador)
			throws RemoteException {
		logger.log(Level.INFO, "Ingresar Trabajador...");
		TrabajadorDAO objRRHH = new TrabajadorDAO();
		boolean resultado = false;
		try {
			 resultado = objRRHH.ingresarTrabajador(trabajador);
			logger.log(Level.INFO, "resultado ingresarTrabajador: " + resultado);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public boolean modificarTrabajador(Trabajador trabajador)
			throws RemoteException {
		logger.log(Level.INFO, "Modificar Trabajador...");
		TrabajadorDAO objRRHH = new TrabajadorDAO();
		boolean resultado = false;
		try {
			 resultado = objRRHH.modificarTrabajador(trabajador);
			logger.log(Level.INFO, "resultado modificarTrabajador: " + resultado);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public boolean eliminarTrabajador(int id_trabajador) throws RemoteException {
		logger.log(Level.INFO, "Eliminar Trabajador...");
		TrabajadorDAO objRRHH = new TrabajadorDAO();
		boolean resultado = false;
		try {
			 resultado = objRRHH.eliminarTrabajador(id_trabajador);
			logger.log(Level.INFO, "resultado EliminarTrabajador: " + resultado);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}
	@Override
	public Trabajador getTrabajadorByRut(String rut) throws RemoteException {
		logger.log(Level.INFO, "Get Trabajador...");
		TrabajadorDAO objRRHH = new TrabajadorDAO();
		Trabajador trabajador = null;
		try {
			trabajador = objRRHH.getTrabajadorByRut(rut);
			logger.log(Level.INFO, "resultado getTrabajador: " + trabajador);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return trabajador;
	}
	@Override
	public Trabajador loginTrabajador(String usuario, String password) throws RemoteException {
		logger.log(Level.INFO, "Login usuario...");
		TrabajadorDAO objRRHH = new TrabajadorDAO();
		Trabajador trabajador = null;
		try {
			trabajador = objRRHH.validarTrabajador(usuario, password);
			logger.log(Level.INFO, "resultado loginTrabajador: " + trabajador);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return trabajador;
	}
	@Override
	public List<Trabajador> listarTrabajadores() throws RemoteException {
		logger.log(Level.INFO, "Obteniendo Listado Trabajadores...");
		TrabajadorDAO dao = new TrabajadorDAO();
		List<Trabajador> trabajadores = new ArrayList();
		try {
			trabajadores = dao.listarTrabajadores();
			logger.log(Level.INFO, "Cantidad de trabajadores obtenidos: " + trabajadores.size());
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());			
			e.printStackTrace();
		}
		return trabajadores;
	}
	//FIN CRUD Trabajadores
	
	//CRUD Departamentos
		@Override
		public boolean ingresarDepartamento(Departamento departamento)
				throws RemoteException {
			logger.log(Level.INFO, "Ingresar Departamento...");
			DepartamentoDAO objRRHH = new DepartamentoDAO();
			boolean resultado = false;
			try {
				 resultado = objRRHH.ingresarDepartamento(departamento);
				logger.log(Level.INFO, "resultado ingresarDepartamento: " + resultado);
			} catch (ClassNotFoundException | SQLException e) {
				logger.log(Level.WARNING, e.getMessage());
				e.printStackTrace();
			}
			return resultado;
		}

		@Override
		public boolean modificarDepartamento(Departamento departamento)
				throws RemoteException {
			logger.log(Level.INFO, "Modificar Departamento...");
			DepartamentoDAO objRRHH = new DepartamentoDAO();
			boolean resultado = false;
			try {
				 resultado = objRRHH.modificarDepartamento(departamento);
				logger.log(Level.INFO, "resultado modificarDepartamento: " + resultado);
			} catch (ClassNotFoundException | SQLException e) {
				logger.log(Level.WARNING, e.getMessage());
				e.printStackTrace();
			}
			return resultado;
		}

		@Override
		public boolean eliminarDepartamento(int id_departmento) throws RemoteException {
			logger.log(Level.INFO, "Eliminar Departamento...");
			DepartamentoDAO objRRHH = new DepartamentoDAO();
			boolean resultado = false;
			try {
				 resultado = objRRHH.eliminarDepartamento(id_departmento);
				logger.log(Level.INFO, "resultado EliminarDepartamento: " + resultado);
			} catch (ClassNotFoundException | SQLException e) {
				logger.log(Level.WARNING, e.getMessage());
				e.printStackTrace();
			}
			return resultado;
		}
		public List<Departamento> listarDepartamentos() throws RemoteException {
			logger.log(Level.INFO, "Obteniendo Listado Departamento...");
			DepartamentoDAO dao = new DepartamentoDAO();
			List<Departamento> departamentos = new ArrayList();
			try {
				departamentos = dao.listarDepartamentos();
				logger.log(Level.INFO, "Cantidad de departamentos obtenidos: " + departamentos.size());
			} catch (ClassNotFoundException | SQLException e) {
				logger.log(Level.WARNING, e.getMessage());			
				e.printStackTrace();
			}
			return departamentos;
		}
		@Override
		public Departamento getDepartamentoById(int id_departamento) throws RemoteException {
			logger.log(Level.INFO, "Get Departamento...");
			DepartamentoDAO objRRHH = new DepartamentoDAO();
			Departamento departamento = null;
			try {
				departamento = objRRHH.getDepartamentoById(id_departamento);
				logger.log(Level.INFO, "resultado getDepartamento: " + departamento);
			} catch (ClassNotFoundException | SQLException e) {
				logger.log(Level.WARNING, e.getMessage());
				e.printStackTrace();
			}
			return departamento;
		}
		//FIN CRUD Departamentos
	

	
	//CRUD Cargos
	@Override
	public boolean ingresarCargo(Cargo cargo) throws RemoteException {
		logger.log(Level.INFO, "Ingresar Cargo...");
		CargoDAO objRRHH = new CargoDAO();
		boolean resultado = false;
		try {
			 resultado = objRRHH.ingresarCargo(cargo);
			logger.log(Level.INFO, "resultado ingresarCargo: " + resultado);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public boolean modificarCargo(Cargo cargo) throws RemoteException {
		logger.log(Level.INFO, "Modificar Cargo...");
		CargoDAO objRRHH = new CargoDAO();
		boolean resultado = false;
		try {
			 resultado = objRRHH.modificarCargo(cargo);
			logger.log(Level.INFO, "resultado modificarCargo: " + resultado);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}
	

	@Override
	public boolean eliminarCargo(int id_cargo) throws RemoteException {
		logger.log(Level.INFO, "Eliminar Cargo...");
		CargoDAO objRRHH = new CargoDAO();
		boolean resultado = false;
		try {
			 resultado = objRRHH.eliminarCargo(id_cargo);
			logger.log(Level.INFO, "resultado EliminarCargo: " + resultado);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return resultado;
	}
	@Override
	public Cargo getCargoById(int id_cargo) throws RemoteException {
		logger.log(Level.INFO, "Get Cargo...");
		CargoDAO objRRHH = new CargoDAO();
		Cargo cargo = null;
		try {
			cargo = objRRHH.getCargoById(id_cargo);
			logger.log(Level.INFO, "resultado getCargo: " + cargo);
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
		return cargo;
	}
	@Override
	public List<Cargo> listarCargos() throws RemoteException {
		logger.log(Level.INFO, "Obteniendo Listado Cargos...");
		CargoDAO dao = new CargoDAO();
		List<Cargo> cargos = new ArrayList();
		try {
			cargos = dao.listarCargos();
			logger.log(Level.INFO, "Cantidad de cargos obtenidos: " + cargos.size());
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.WARNING, e.getMessage());			
			e.printStackTrace();
		}
		return cargos;
	}
	//FIN CRUD Cargos
	
}
