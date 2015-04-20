package cl.usach.lab1.db.DAO.finanzas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import cl.usach.lab1.db.conf.FinanzasConf;
import cl.usach.lab1.finanzas.rmi.vo.Orden;
import cl.usach.lab1.utils.Configuraciones;

public class OrdenDAO {
	
	public boolean ingresarOrden(Orden ord) throws SQLException, ClassNotFoundException{
		PreparedStatement pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.insertOrden"));
		pst.setInt(1, ord.getId_orden());
		pst.setInt(2, ord.getId_cliente());
		pst.setString(3, ord.getFecha_orden());
		pst.execute();
		return true;
	}
	
	public List<Orden> listarOrdenes() throws SQLException, ClassNotFoundException{
		Orden ord = null;
		List<Orden> ordenes = new ArrayList<Orden>();
		
		PreparedStatement pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.getAllOrdenes"));
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			ord = new Orden();
			ord.setId_orden(rs.getInt("id_orden"));
			ord.setId_cliente(rs.getInt("id_cliente"));
			ord.setFecha_orden(rs.getString("fecha_orden"));
			ordenes.add(ord);
		}
		
		return ordenes;
	}

	public boolean modificarOrden(Orden ord) throws SQLException, ClassNotFoundException {
		PreparedStatement pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.modificarOrden"));
		pst.setInt(1, ord.getId_cliente());
		pst.setString(2, ord.getFecha_orden());
		pst.setInt(3, ord.getId_orden());
		pst.execute();
		return true;
	}
	
	public boolean eliminarOrden(int id_orden) throws SQLException, ClassNotFoundException {
		PreparedStatement pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.deleteOrdenById"));
		pst.setInt(1, id_orden);
		pst.execute();
		return true;
	}
		
	public Orden getOrdenById(int id_orden) throws SQLException, ClassNotFoundException{
		Orden ord = null;
		PreparedStatement pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.getOrdenById"));
		pst.setInt(1, id_orden);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			ord = new Orden();
			ord.setId_orden(rs.getInt("id_orden"));
			ord.setId_cliente(rs.getInt("id_cliente"));
			ord.setFecha_orden(rs.getString("fecha_orden"));
		}
		
		return ord;
	}
}
