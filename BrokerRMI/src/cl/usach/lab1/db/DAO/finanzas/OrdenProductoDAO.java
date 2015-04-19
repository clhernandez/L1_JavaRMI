package cl.usach.lab1.db.DAO.finanzas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.usach.lab1.db.conf.FinanzasConf;
import cl.usach.lab1.finanzas.rmi.vo.OrdenProducto;
import cl.usach.lab1.utils.Configuraciones;

public class OrdenProductoDAO {
	
	public boolean ingresarOrdenProducto(OrdenProducto oprd) throws SQLException, ClassNotFoundException{
		PreparedStatement pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.insertOrdenProducto"));
		pst.setInt(1, oprd.getId_producto());
		pst.setInt(2, oprd.getCantidad());
		pst.execute();
		return true;
	}
	
	public List<OrdenProducto> listarOrdenProductos() throws SQLException, ClassNotFoundException{
		OrdenProducto oprd = null;
		List<OrdenProducto> ordenProductos = new ArrayList<OrdenProducto>();
		
		PreparedStatement pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.getAllOrdenProductos"));
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			oprd = new OrdenProducto();
			oprd.setId_orden_producto(rs.getInt("id_orden_producto"));
			oprd.setId_producto(rs.getInt("id_producto"));
			oprd.setCantidad(rs.getInt("cantidad"));
			ordenProductos.add(oprd);
		}
		
		return ordenProductos;
	}

	public boolean modificarOrdenProducto(OrdenProducto oprd) throws SQLException, ClassNotFoundException {
		PreparedStatement pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.modificarOrdenProducto"));
		pst.setInt(1, oprd.getId_producto());
		pst.setInt(2, oprd.getCantidad());
		pst.setInt(3, oprd.getId_orden_producto());
		pst.execute();
		return true;
	}
	
	public boolean eliminarOrdenProducto(int id_ordenProducto) throws SQLException, ClassNotFoundException {
		PreparedStatement pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.deleteOrdenProductoByID"));
		pst.setInt(1, id_ordenProducto);
		pst.execute();
		return true;
	}
	
	public OrdenProducto getOrdenProductoById(int id_ordenProducto) throws SQLException, ClassNotFoundException{
		OrdenProducto oprd = null;
		PreparedStatement pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.getOrdenProductoById"));
		pst.setInt(1, id_ordenProducto);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			oprd = new OrdenProducto();
			oprd.setId_orden_producto(rs.getInt("id_orden_producto"));
			oprd.setId_producto(rs.getInt("id_producto"));
			oprd.setCantidad(rs.getInt("cantidad"));
		}
		
		return oprd;
	}
}
