package buildings.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class Pool{
	
	private static final ResourceBundle prb =  ResourceBundle.getBundle("jdbc");
	private static final Logger log = Logger.getLogger(Pool.class);
	
	public static Connection getConnection() throws SQLException
	{
		//log.info("Conectando");
		Connection connection = null;
		try {
			Class.forName(prb.getString("driverClassName"));
			//Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			log.info("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(prb.getString("url"),prb.getString("userdb"),prb.getString("password"));
			//connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","system");
		} catch (SQLException e) {
			log.info("Connection Failed! Check output console");
			e.printStackTrace();
		}
		if (connection != null) {
			//log.info("You made it, take control your database now!");
		} else {
			log.info("Failed to make connection!");
		}
		return connection;
	}
	
	//prueba conexion
	public static void main(String[] argv) {
		System.out.println("-------- Oracle JDBC Connection Testing ------");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Class OK");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;
		}
		System.out.println("Oracle JDBC Driver Registered!");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "system",
					"system");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
}