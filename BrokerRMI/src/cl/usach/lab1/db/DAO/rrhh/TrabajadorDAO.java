package cl.usach.lab1.db.DAO.rrhh;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cl.usach.lab1.db.conf.RrhhConf;
import cl.usach.lab1.rrhh.rmi.vo.Trabajador;
import cl.usach.lab1.utils.Configuraciones;

public class TrabajadorDAO {
	
	public Trabajador getTrabajador(String nomus, String passwd) throws ClassNotFoundException, SQLException{
		PreparedStatement pst = RrhhConf.getConeccion().prepareStatement(Configuraciones.getConfig("RRHH.getTrabajadorByNomPass"));
		pst.setString(1, nomus);
		pst.setString(2, passwd);
		ResultSet rs = pst.executeQuery();
		Trabajador trb = null;
		while(rs.next()){
			trb = new Trabajador();
			trb.setNombre(rs.getString("nombre"));
			trb.setApellido(rs.getString("apellido"));
			trb.setEmail(rs.getString("email"));		
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
			trb.setNombre(rs.getString("nombre"));
			trb.setApellido(rs.getString("apellido"));
			trb.setEmail(rs.getString("email"));
			trb.setTelefono(rs.getString("telefono"));
			trb.setFecha_contratacion(rs.getString("fecha_contratacion"));
			trb.setId_cargo_fk(rs.getInt("id_cargo_fk"));
			trb.setSueldo(rs.getInt("sueldo"));
			trb.setComision_porc(rs.getInt("comision_porc"));
			trb.setId_departamento_fk(rs.getInt("id_departamento_fk"));
			trb.setTrabajadorescol(rs.getString("trabajadorescol"));
			trabajadores.add(trb);
		}
		return trabajadores;
	}
}
