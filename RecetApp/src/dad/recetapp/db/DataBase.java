package dad.recetapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataBase {

	private static final ResourceBundle CONFIG = ResourceBundle.getBundle(DataBase.class.getPackage().getName() + ".database");
	private static Connection conn = null;
	
	private DataBase() {}
	
	public static Connection getConnection() throws SQLException {
		if (conn == null || conn.isClosed()) {
			conn = connect();
		}
		return conn;
	}
	
	private static void registerDriver() {
		try {
			Class.forName(CONFIG.getString("db.driver.classname"));
		} catch (ClassNotFoundException e) {
			System.err.println("Error al cargar el driver JDBC");
			e.printStackTrace();
		}
	}
	
	public static Connection connect(String url, String username, String password) throws SQLException {
		registerDriver();
		return DriverManager.getConnection(url, username, password);
	}
	
	public static Connection connect() throws SQLException {
		return connect(CONFIG.getString("db.url"), CONFIG.getString("db.username"), CONFIG.getString("db.password"));
	}
	
	public static void disconnect(Connection conn) throws SQLException {
		if (conn != null && !conn.isClosed()) {
			conn.close();
			conn = null;
		}
	}
	
	public static void disconnect() throws SQLException {
		disconnect(conn);
	}
	
	public static Boolean test() {
		Boolean testOk = false;
		try {
			Connection c = connect();
			disconnect(c);
			testOk = true; 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return testOk;
	}
	
}
