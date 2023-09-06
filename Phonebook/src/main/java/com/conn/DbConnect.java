package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
	private static Connection con;
	
	public static Connection getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook", "root", "Mysql123");
			System.out.println("Connection Success!");
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Something went wrong");
		}
		
		return con;
	}

}
