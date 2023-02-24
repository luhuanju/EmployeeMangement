package com.cogent.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDb {



	private static final String DB_URL = "jdbc:mysql://localhost/batch65";
	private static final String USER = "root";
	private static final String PASS = "password";
	private static Connection conn;


	public static ConnectDb instanConnectDb = new ConnectDb();

	public Connection getDbConnection() {
		return conn;
	}

	static {
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			ResultSet rs = conn.getMetaData().getTables(null, null, "Product", null);
			if (!rs.next()) {
				// create the table if it does not exist
				String sql = "CREATE TABLE Product (id int, name VARCHAR(50), cost FLOAT, available BOOLEAN)";
				stmt.executeUpdate(sql);
				System.out.println("Table created successfully.");
			} else {
				System.out.println("Table already exists.");
			}

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
