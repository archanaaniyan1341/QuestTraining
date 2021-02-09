package managementdao;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

public class DatabaseConnection { 

	private static Connection conn = null; 

	static
	{ 
		String url = "jdbc:mysql:// localhost:3306/management"; 
		String user = "root"; 
		String pass = "root"; 
		try { 
			Class.forName("com.mysql.jdbc.Driver"); 
			conn = DriverManager.getConnection(url, user, pass); 
		    conn.setAutoCommit(false);
		} 
		catch (ClassNotFoundException | SQLException e) { 
			e.printStackTrace(); 
		} 
	} 
	public static Connection getConnection() 
	{ 
		return conn; 
	} 
} 
