package com.congent.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cogent.db.ConnectDb;

public class DbLogic {

	private Connection conn = ConnectDb.instanConnectDb.getDbConnection();

	public void insert(int id, String name) throws SQLException {

		String sql = "INSERT INTO Employee (employeeId, employeeName) VALUES (?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.setString(2, name);
		boolean rs = stmt.execute();
		System.out.println("inserted successfully.");

		if (stmt != null)
			stmt.close();

	}

	public void query() throws SQLException {

		String sql = "SELECT * FROM Employee";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");

		System.out.println("Data in DB:");
		// process the result set
		while (rs.next()) {
			int id = rs.getInt("employeeId");
			String name = rs.getString("employeeName");
			System.out.println("employeeId: " + id + ", employeeName: " + name);
		}

		if (stmt != null)
			stmt.close();
	}

	public void update(int id, String name) throws SQLException {

		String sql = "UPDATE Employee SET employeeName = ? WHERE employeeId = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(2, id);
		stmt.setString(1, name);
		boolean rs = stmt.execute();
		System.out.println("inserted successfully.");

		if (stmt != null)
			stmt.close();
	}


	public void delete(int id) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM Employee WHERE employeeId = ? ");
		stmt.setInt(1, id);
		boolean rs = stmt.execute();
		System.out.println(rs);
	}

}
