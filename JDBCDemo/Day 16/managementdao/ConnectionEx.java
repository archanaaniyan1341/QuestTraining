package managementdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
public class ConnectionEx {
	public String url="jdbc:mysql://localhost:3306/management";
	public String user="root";
	public  String password="root";
	
	public Connection getConnection() throws SQLException {
		
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(url, user, password);
		
	}
}

