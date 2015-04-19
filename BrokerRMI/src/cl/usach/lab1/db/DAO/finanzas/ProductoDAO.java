package cl.usach.lab1.db.DAO.finanzas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.usach.lab1.db.conf.FinanzasConf;
import cl.usach.lab1.finanzas.rmi.vo.Producto;
import cl.usach.lab1.utils.Configuraciones;

public class ProductoDAO {
	
	public boolean ingresarProducto(Producto prd) throws SQLException, ClassNotFoundException{
		PreparedStatement pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.insertProducto"));
		pst.setString(1, prd.getNombre());
		pst.setString(2, prd.getDescripcion());
		pst.setInt(3, prd.getPrecio());
		pst.execute();
		return true;
	}
	
	public List<Producto> listarProductos() throws SQLException, ClassNotFoundException{
		Producto prd = null;
		List<Producto> productos = new ArrayList<Producto>();
		
		PreparedStatement pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.getAllProductos"));
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			prd = new Producto();
			prd.setId_producto(rs.getInt("id_producto"));
			prd.setNombre(rs.getString("nombre"));
			prd.setDescripcion(rs.getString("descripcion"));
			prd.setPrecio(rs.getInt("precio"));
			productos.add(prd);
		}
		
		return productos;
	}

	public boolean modificarProducto(Producto prd) throws SQLException, ClassNotFoundException {
		PreparedStatement pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.modificarProducto"));
		pst.setString(1, prd.getNombre());
		pst.setString(2, prd.getDescripcion());
		pst.setInt(3, prd.getPrecio());
		pst.setInt(4, prd.getId_producto());
		pst.execute();
		return true;
	}
	
	public boolean eliminarProducto(int id_producto) throws SQLException, ClassNotFoundException {
		PreparedStatement pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.deleteProductoByID"));
		pst.setInt(1, id_producto);
		pst.execute();
		return true;
	}
	
	public Producto getProductoById(int id_producto) throws SQLException, ClassNotFoundException{
		System.out.println(id_producto);
		Producto prd = null;
		PreparedStatement pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.getProductoById"));
		pst.setInt(1, id_producto);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			prd = new Producto();
			prd.setId_producto(rs.getInt("id_producto"));
			prd.setNombre(rs.getString("nombre"));
			prd.setDescripcion(rs.getString("descripcion"));
			prd.setPrecio(rs.getInt("precio"));
		}
		
		return prd;
	}
}
