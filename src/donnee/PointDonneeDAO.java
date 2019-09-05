package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class PointDonneeDAO {
	static Connection connection;
	public PointDonneeDAO() {
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://192.168.56.10:5432/projet_imr", 
					"master",
					"123qweQWE");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void inserer(PointDonnee p) {
		Statement requeteTest = null;
		try {
			requeteTest = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		java.util.Date date = new java.util.Date(p.getMoment());
		java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());



		String query = "INSERT INTO donnee_bouee (id_bouee, temperature, salinite, debit, date_temps, longitude, latitude, valide) \n" +
				"VALUES (" + p.getId_bouee() + ", " + p.getTemperature() + ", " + 
				p.getSalinite()+", " + p.getDebit() + ", '" + timestamp + "', " + 
				p.getLongitude() + ", " + p.getLatitude() + ", True)";
		
		
		//System.out.println(query);
		try {
			requeteTest.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
