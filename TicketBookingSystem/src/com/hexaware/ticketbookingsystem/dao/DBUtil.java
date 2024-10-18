package com.hexaware.ticketbookingsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection getDBConnection() {

		Connection conn = null;

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketbookingsystem", "root", "Siva@2002");

		} catch (SQLException e) {

		}

		return conn;

	}

}
