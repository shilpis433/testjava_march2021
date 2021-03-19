package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection conn;
	public static Connection getMyConnection() {
		if(conn==null) {
			try {
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				String url="jdbc:oracle:thin:@localhost:1521:XE";
				conn=DriverManager.getConnection(url,"system","manager");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
