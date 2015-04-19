package cl.usach.lab1.db.DAO.finanzas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.usach.lab1.db.conf.FinanzasConf;
import cl.usach.lab1.finanzas.rmi.vo.Cliente;
import cl.usach.lab1.utils.Configuraciones;

public class ClienteDAO {
	
	public boolean ingresarCliente(Cliente clt) throws SQLException, ClassNotFoundException{
		PreparedStatement pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.insertIntoCliente"));
			pst.setString(1, clt.getNombre());
			pst.setString(2, clt.getApellido());
			pst.setString(3, clt.getDireccion());
			pst.setString(4, clt.getTelefono());
			pst.setString(5, clt.getCiudad());
			pst.setString(6, clt.getRegion());
			pst.execute();
			return true;
	}

	public boolean modificarCliente(Cliente clt)throws ClassNotFoundException, SQLException{
		
		PreparedStatement pst=null;
			pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.updateCliente"));
			pst.setString(1, clt.getNombre());
			pst.setString(2, clt.getApellido());
			pst.setString(3, clt.getDireccion());
			pst.setString(4, clt.getTelefono());
			pst.setString(5, clt.getCiudad());
			pst.setString(6, clt.getRegion());
			pst.setInt(7, clt.getId_cliente());
		pst.execute();
		
		
		return true;
	}
	
	public boolean eliminarCliente(int id_cliente)throws ClassNotFoundException, SQLException{
		PreparedStatement pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.deleteClienteByID"));
		pst.setInt(1, id_cliente);
		System.out.println(id_cliente);
		if(pst.executeUpdate()>0)
			return true;
		else
			return false;
	}
		
	public List<Cliente> listarClientes() throws ClassNotFoundException, SQLException{
		PreparedStatement pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.getAllClientes"));
		List<Cliente> clientes = new ArrayList();
		ResultSet rs = pst.executeQuery();
		Cliente clt = null;
		while(rs.next()){
			clt = new Cliente();
			clt.setId_cliente(rs.getInt("id_cliente"));
			clt.setNombre(rs.getString("nombre"));
			clt.setApellido(rs.getString("apellido"));
			clt.setDireccion(rs.getString("direccion"));
			clt.setTelefono(rs.getString("telefono"));
			clt.setCiudad(rs.getString("ciudad"));
			clt.setRegion(rs.getString("region"));
			clientes.add(clt);
		}
		return clientes;
	}
	
	public Cliente getClienteById(int id_cliente) throws ClassNotFoundException, SQLException{
		PreparedStatement pst = FinanzasConf.getConeccion().prepareStatement(Configuraciones.getConfig("FINANZAS.getClienteById"));
		pst.setInt(1, id_cliente);
		ResultSet rs = pst.executeQuery();
		Cliente clt = null;
		while(rs.next()){
			clt = new Cliente();
			clt.setId_cliente(rs.getInt("id_cliente"));
			clt.setNombre(rs.getString("nombre"));
			clt.setApellido(rs.getString("apellido"));
			clt.setDireccion(rs.getString("direccion"));
			clt.setTelefono(rs.getString("telefono"));
			clt.setCiudad(rs.getString("ciudad"));
			clt.setRegion(rs.getString("region"));
		}
		return clt;
	}
	
}
