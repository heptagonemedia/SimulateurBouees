package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PointDonneeDAO {
	static Connection connection;
	public PointDonneeDAO() {
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://192.168.56.10:5432/integrite", 
					"master",
					"123qweQWE");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void inserer() {
		
	}
}
