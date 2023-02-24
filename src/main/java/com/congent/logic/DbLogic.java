package com.congent.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.cogent.db.ConnectDb;
import com.cogent.streamPractice.Product;

public class DbLogic {

	private Connection conn = ConnectDb.instanConnectDb.getDbConnection();

	public void insert(int id, String name, float cost, boolean available) throws SQLException {

		String sql = "INSERT INTO Product (id, name, cost, available) VALUES (?, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.setString(2, name);
		stmt.setFloat(3, cost);
		stmt.setBoolean(4, available);

		boolean rs = stmt.execute();
		System.out.println("inserted successfully.");

		if (stmt != null)
			stmt.close();

	}


	public void query() throws SQLException {

		ArrayList<Product> proList = new ArrayList<Product>();
		String sql = "SELECT * FROM Product";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery("SELECT * FROM Product");

		System.out.println("Data in DB:");
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			float cost = rs.getFloat("cost");
			boolean ava = rs.getBoolean("available");
			proList.add(new Product(id, name, cost, ava));
		}

		proList.stream().forEach(System.out::println);

		sortByCost(proList);

		if (stmt != null)
			stmt.close();
	}

	public void sortByCost(ArrayList<Product> proList) {
		System.out.println("######sortByCost#######");
		List<Product> proBucket = proList.stream().sorted(Comparator.comparing(Product::getCost)).map(pr -> pr)
				.toList();
		System.out.println("#############");
	}




}
