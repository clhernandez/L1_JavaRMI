package cl.usach.lab1.db.DAO.rrhh;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.usach.lab1.db.conf.RrhhConf;
import cl.usach.lab1.rrhh.rmi.vo.Trabajador;
import cl.usach.lab1.utils.Configuraciones;

public class TrabajadorDAO {
	
	public boolean ingresarTrabajador(Trabajador trb) throws SQLException, ClassNotFoundException{
		PreparedStatement pst = RrhhConf.getConeccion().prepareStatement(Configuraciones.getConfig("RRHH.insertIntoTrabajador"));
		//verificar que no exista otro trabajador con el mismo rut
		if(getTrabajadorByRut(trb.getRut())==null){
			pst.setString(1, trb.getRut());
			pst.setString(2, trb.getNombre());
			pst.setString(3, trb.getApellido());
			pst.setString(4, trb.getEmail());
			pst.setString(5, trb.getRut());
			pst.setString(6, trb.getTelefono());
			pst.setString(7, trb.getFecha_contratacion());
			pst.setInt(8, trb.getSueldo());
			pst.setInt(9, trb.getId_cargo_fk());
			pst.setInt(10, trb.getId_departamento_fk());
			pst.execute();
			return true;
		}
		return false;
	}
	public boolean modificarTrabajador(Trabajador trb)throws ClassNotFoundException, SQLException{
		
		//verificar que no exista otro trabajador con el mismo rut
		PreparedStatement pst=null;
		if(trb.getPasswd()==null || trb.getPasswd().equals("")){
			pst = RrhhConf.getConeccion().prepareStatement(Configuraciones.getConfig("RRHH.updateTrabajadorSNPasswdUPDATE"));
			pst.setString(1, trb.getRut());
			pst.setString(2, trb.getNombre());
			pst.setString(3, trb.getApellido());
			pst.setString(4, trb.getEmail());
			pst.setString(5, trb.getTelefono());
			pst.setString(6, trb.getFecha_contratacion());
			pst.setInt(7, trb.getId_cargo_fk());
			pst.setInt(8, trb.getSueldo());
			pst.setInt(9, trb.getId_departamento_fk());
			pst.setInt(10, trb.getId_trabajador());
			
		}else{
			pst = RrhhConf.getConeccion().prepareStatement(Configuraciones.getConfig("RRHH.updateTrabajador"));
			pst.setString(1, trb.getRut());
			pst.setString(2, trb.getNombre());
			pst.setString(3, trb.getApellido());
			pst.setString(4, trb.getEmail());
			
			pst.setString(5, trb.getPasswd());
			
			pst.setString(6, trb.getTelefono());
			pst.setString(7, trb.getFecha_contratacion());
			pst.setInt(8, trb.getId_cargo_fk());
			pst.setInt(9, trb.getSueldo());
			pst.setInt(10, trb.getId_departamento_fk());
			pst.setInt(11, trb.getId_trabajador());
		}
		pst.execute();
		
		
		return true;
	}
	
	public boolean eliminarTrabajador(int id_trabajador)throws ClassNotFoundException, SQLException{
		PreparedStatement pst = RrhhConf.getConeccion().prepareStatement(Configuraciones.getConfig("RRHH.deleteTrabajadorByID"));
		pst.setInt(1, id_trabajador);
		if(pst.executeUpdate()>0)
			return true;
		else
			return false;
	}
	
	public Trabajador getTrabajadorByRut(String rut) throws ClassNotFoundException, SQLException{
		PreparedStatement pst = RrhhConf.getConeccion().prepareStatement(Configuraciones.getConfig("RRHH.getTrabajadorByRut"));
		pst.setString(1, rut);
		ResultSet rs = pst.executeQuery();
		Trabajador trb = null;
		while(rs.next()){
			trb = new Trabajador();
			trb.setId_trabajador(rs.getInt("id_trabajador"));
			trb.setRut(rs.getString("rut"));
			trb.setNombre(rs.getString("nombre"));
			trb.setApellido(rs.getString("apellido"));
			trb.setEmail(rs.getString("email"));
			trb.setTelefono(rs.getString("telefono"));
			trb.setFecha_contratacion(rs.getString("fecha_contratacion"));
			trb.setId_cargo_fk(rs.getInt("id_cargo_fk"));
			trb.setSueldo(rs.getInt("sueldo"));
			trb.setId_departamento_fk(rs.getInt("id_departamento_fk"));	
		}
		return trb;
	}
	
	public Trabajador validarTrabajador(String nomus, String passwd) throws ClassNotFoundException, SQLException{
		PreparedStatement pst = RrhhConf.getConeccion().prepareStatement(Configuraciones.getConfig("RRHH.getTrabajadorByNomPass"));
		pst.setString(1, nomus);
		pst.setString(2, passwd);
		ResultSet rs = pst.executeQuery();
		Trabajador trb = null;
		while(rs.next()){
			trb = new Trabajador();
			trb.setId_trabajador(rs.getInt("id_trabajador"));
			trb.setRut(rs.getString("rut"));
			trb.setNombre(rs.getString("nombre"));
			trb.setApellido(rs.getString("apellido"));
			trb.setEmail(rs.getString("email"));
			trb.setTelefono(rs.getString("telefono"));
			trb.setFecha_contratacion(rs.getString("fecha_contratacion"));
			trb.setId_cargo_fk(rs.getInt("id_cargo_fk"));
			trb.setSueldo(rs.getInt("sueldo"));
			trb.setId_departamento_fk(rs.getInt("id_departamento_fk"));	
		}
		return trb;
	}
	
	public List<Trabajador> listarTrabajadores() throws ClassNotFoundException, SQLException{
		PreparedStatement pst = RrhhConf.getConeccion().prepareStatement(Configuraciones.getConfig("RRHH.getAllTrabajadores"));
		List<Trabajador> trabajadores = new ArrayList();
		ResultSet rs = pst.executeQuery();
		Trabajador trb = null;
		while(rs.next()){
			trb = new Trabajador();
			trb.setId_trabajador(rs.getInt("id_trabajador"));
			trb.setRut(rs.getString("rut"));
			trb.setNombre(rs.getString("nombre"));
			trb.setApellido(rs.getString("apellido"));
			trb.setEmail(rs.getString("email"));
			trb.setTelefono(rs.getString("telefono"));
			trb.setFecha_contratacion(rs.getString("fecha_contratacion"));
			trb.setId_cargo_fk(rs.getInt("id_cargo_fk"));
			trb.setSueldo(rs.getInt("sueldo"));
			trb.setId_departamento_fk(rs.getInt("id_departamento_fk"));
			trabajadores.add(trb);
		}
		return trabajadores;
	}
}
