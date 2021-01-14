package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection connection = null;
	

	
	public static Connection getConnection(){
		
		try {
			Class.forName("org.postgresql.Driver");
			if(connection==null){
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sist_cadastro_db", "postgres", "1always2");
			}
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}
	

}
