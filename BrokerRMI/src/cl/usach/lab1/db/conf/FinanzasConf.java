package cl.usach.lab1.db.conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import cl.usach.lab1.utils.Configuraciones;
/**
 * 
 * @author Claudio Hernandez
 * @description Singleton Conexion a BD Finanzas
 */
public class FinanzasConf {

	private final static String _nomus = Configuraciones.getConfig("bd.nomus");
	private final static String _passwd = Configuraciones.getConfig("bd.passwd");
	private final static String _url = "jdbc:mysql://" + Configuraciones.getConfig("bd.server") + "/" + Configuraciones.getConfig("bd.finanzas");
	private static Connection _conexion = null;

	public static Connection getConeccion() throws ClassNotFoundException, SQLException {

		if (_conexion == null) {
			Class.forName("com.mysql.jdbc.Driver");
			_conexion = DriverManager.getConnection(_url, _nomus, _passwd);
		}
		return _conexion;
	}

	public static void desconectar() throws SQLException {
		_conexion.close();
		System.out.println("Desconectar mysql OK");
	}

}
