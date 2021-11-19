package com.oqm.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getDBConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HARISHMA", "oracle123");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}
}

