package com.qsp.jdbc_prepared_statement_eve.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MobileConnection {

	public static Connection getConnection() {
	    //Connection connection=null;
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc-preperedstatement-eve";
			String user = "root";
			String pass = "root";
			
			Connection connection = DriverManager.getConnection(url, user, pass);
			
		    if(connection!=null) {
		    	return connection;
		    }else {
		    	System.out.println("check your url or user or pass");
		    }
		    
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}