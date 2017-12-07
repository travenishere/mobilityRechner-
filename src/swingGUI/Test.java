package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
	
	public static void main(String[] args) throws SQLException {
		
		Connection c = DriverManager.getConnection
				   ("jdbc:hsqldb:file:/testdb",
				    "u1", "123");
		
	}
	
}
