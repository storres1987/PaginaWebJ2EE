package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class sentenciasSQL {

	private Connection conn;

	public sentenciasSQL() {

	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void conectarBBDD() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = java.sql.DriverManager.getConnection(
					"jdbc:oracle:thin:@54.154.192.80:1521:xe", "open4job","open4job");
			System.out.println("Conexion realizada");
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(getClass().getName()).log(Level.SEVERE,"Conexion rechazada: " + e.getMessage());			
		}
	}

	public void closeBBDD() {
		try {
			conn.close();
			System.out.println("Conexión cerrada");
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(getClass().getName()).log(Level.SEVERE,"Fallo al cerrar la conexión: " + e.getMessage());		
		}
	}
}
