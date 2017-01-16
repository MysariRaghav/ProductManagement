package com.jdbc.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {
	
	private Connection con;
	
	public DBConnection() {
		// TODO Auto-generated constructor stub
	
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_management", "root", "password");
			
			if(con != null)
				System.out.println("connected");
			else throw new NullPointerException();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}
	
	public Connection getConnection()
	{
		return con;
	}

}
