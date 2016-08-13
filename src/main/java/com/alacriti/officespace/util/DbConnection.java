package com.alacriti.officespace.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	static final String DB_URL = "jdbc:mysql://192.168.35.70:3306/trainee_dev";
	static final String USER_NAME = "trainee_dev";
	static final String PASSWORD = "trainee_dev";
	
	public static Connection getConnection(){
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DB_URL,USER_NAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
