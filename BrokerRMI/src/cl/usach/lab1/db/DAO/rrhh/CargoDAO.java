package cl.usach.lab1.db.DAO.rrhh;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.usach.lab1.db.conf.RrhhConf;
import cl.usach.lab1.rrhh.rmi.vo.Cargo;
import cl.usach.lab1.utils.Configuraciones;

public class CargoDAO {
	
	public boolean ingresarCargo(Cargo crg) throws SQLException, ClassNotFoundException{
		PreparedStatement pst = RrhhConf.getConeccion().prepareStatement(Configuraciones.getConfig("RRHH.insertIntoCargo"));
			pst.setString(1, crg.getNombre_cargo());
			pst.setInt(2, crg.getSueldo_min());
			pst.setInt(3, crg.getSueldo_max());
			pst.execute();
			return true;
	}

	public boolean modificarCargo(Cargo crg)throws ClassNotFoundException, SQLException{
		
		PreparedStatement pst=null;
			pst = RrhhConf.getConeccion().prepareStatement(Configuraciones.getConfig("RRHH.updateCargo"));
			pst.setString(1, crg.getNombre_cargo());
			pst.setInt(2, crg.getSueldo_min());
			pst.setInt(3, crg.getSueldo_max());
			pst.setInt(4, crg.getId_cargo());
		pst.execute();
		
		
		return true;
	}
	
	public boolean eliminarCargo(int id_cargo)throws ClassNotFoundException, SQLException{
		PreparedStatement pst = RrhhConf.getConeccion().prepareStatement(Configuraciones.getConfig("RRHH.deleteCargoByID"));
		pst.setInt(1, id_cargo);
		System.out.println(id_cargo);
		if(pst.executeUpdate()>0)
			return true;
		else
			return false;
	}
		
	public List<Cargo> listarCargos() throws ClassNotFoundException, SQLException{
		PreparedStatement pst = RrhhConf.getConeccion().prepareStatement(Configuraciones.getConfig("RRHH.getAllCargos"));
		List<Cargo> cargos = new ArrayList();
		ResultSet rs = pst.executeQuery();
		Cargo crg = null;
		while(rs.next()){
			crg = new Cargo();
			crg.setId_cargo(rs.getInt("id_cargo"));
			crg.setNombre_cargo(rs.getString("nombre_cargo"));
			crg.setSueldo_min(rs.getInt("sueldo_min"));
			crg.setSueldo_max(rs.getInt("sueldo_max"));
			cargos.add(crg);
		}
		return cargos;
	}
	
	public Cargo getCargoById(int id_cargo) throws ClassNotFoundException, SQLException{
		PreparedStatement pst = RrhhConf.getConeccion().prepareStatement(Configuraciones.getConfig("RRHH.getCargoById"));
		pst.setInt(1, id_cargo);
		ResultSet rs = pst.executeQuery();
		Cargo crg = null;
		while(rs.next()){
			crg = new Cargo();
			crg.setId_cargo(rs.getInt("id_cargo"));
			crg.setNombre_cargo(rs.getString("nombre_cargo"));
			crg.setSueldo_min(rs.getInt("sueldo_min"));
			crg.setSueldo_max(rs.getInt("sueldo_max"));
		}
		return crg;
	}
	
}
