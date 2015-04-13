package cl.usach.lab1.db.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import cl.usach.lab1.db.conf.RrhhConf;
import cl.usach.lab1.utils.Configuraciones;

public class ProcesarRrhh {
	
	public HashMap getTrabajador(String nomus, String passwd) throws ClassNotFoundException, SQLException{
		PreparedStatement pst = RrhhConf.getConeccion().prepareStatement(Configuraciones.getConfig("RRHH.getTrabajadorByNomPass"));
		pst.setString(1, nomus);
		pst.setString(2, passwd);
		ResultSet rs = pst.executeQuery();
		HashMap trb = null;
		while(rs.next()){
			trb = new HashMap();
			trb.put("nombre", rs.getString("nombre"));
			trb.put("apellido", rs.getString("apellido"));
			trb.put("email", rs.getString("email"));			
		}
		return trb;
	}
}
