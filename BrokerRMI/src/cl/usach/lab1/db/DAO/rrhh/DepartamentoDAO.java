package cl.usach.lab1.db.DAO.rrhh;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.usach.lab1.db.conf.RrhhConf;
import cl.usach.lab1.rrhh.rmi.vo.Departamento;
import cl.usach.lab1.rrhh.rmi.vo.Trabajador;
import cl.usach.lab1.utils.Configuraciones;

public class DepartamentoDAO {
	
	public boolean ingresarDepartamento(Departamento dep) throws SQLException, ClassNotFoundException{
		PreparedStatement pst = RrhhConf.getConeccion().prepareStatement(Configuraciones.getConfig("RRHH.insertIntoDepartamento"));
		//verificar que no exista otro trabajador con el mismo rut
		return false;
	}
	public boolean modificarDepartamento(Departamento dep)throws ClassNotFoundException, SQLException{
		    PreparedStatement pst=null;
			pst = RrhhConf.getConeccion().prepareStatement(Configuraciones.getConfig("RRHH.updateDepartamento"));
			pst.setInt(1, dep.getId_departamento());
			pst.setString(2, dep.getNombre_departamento());
			pst.setString(3, dep.getAdministrador());
			pst.setString(4, dep.getUbicacion());

	
		pst.execute();
		
		
		return true;
	}
	
	public boolean eliminarDepartamento(int id_departamento)throws ClassNotFoundException, SQLException{
		PreparedStatement pst = RrhhConf.getConeccion().prepareStatement(Configuraciones.getConfig("RRHH.deleteDepartamentoByID"));
		pst.setInt(1, id_departamento);
		System.out.println(id_departamento);
		if(pst.executeUpdate()>0)
			return true;
		else
			return false;
	}
	
	
	public List<Departamento> listarDepartamentos() throws ClassNotFoundException, SQLException{
		PreparedStatement pst = RrhhConf.getConeccion().prepareStatement(Configuraciones.getConfig("RRHH.getAllDepartamentos"));
		List<Departamento> departamentos = new ArrayList();
		ResultSet rs = pst.executeQuery();
		Departamento dep = null;
		while(rs.next()){
			dep = new Departamento();
			dep.setId_departamento(rs.getInt("id_departamento"));
			dep.setNombre_departamento(rs.getString("nombre_departamento"));
			dep.setAdministrador(rs.getString("administrador"));
			dep.setUbicacion(rs.getString("ubicacion"));
			departamentos.add(dep);
		}
		return departamentos;
	}
	public Departamento getDepartamentoById(int id_departamento) throws ClassNotFoundException, SQLException{
		PreparedStatement pst = RrhhConf.getConeccion().prepareStatement(Configuraciones.getConfig("RRHH.getDepartamentoById"));
		pst.setInt(1, id_departamento);
		ResultSet rs = pst.executeQuery();
		Departamento dep = null;
		while(rs.next()){
			dep = new Departamento();
			dep.setId_departamento(rs.getInt("id_departamento"));
			dep.setNombre_departamento(rs.getString("nombre_departamento"));
			dep.setAdministrador(rs.getString("administrador"));
			dep.setUbicacion(rs.getString("ubicacion"));
		}
		return dep;
	}
	
}
