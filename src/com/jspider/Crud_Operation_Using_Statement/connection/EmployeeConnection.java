package com.jspider.Crud_Operation_Using_Statement.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class EmployeeConnection {
	
	public static Connection getEmployeeConnection() {
		Driver driver;
		try {
			driver = new Driver();
			DriverManager.registerDriver(driver);
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-a5","root", "Sumanrawat@123");
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	
}
