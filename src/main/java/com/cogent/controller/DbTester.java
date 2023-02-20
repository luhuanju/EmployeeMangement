package com.cogent.controller;

import java.sql.SQLException;

import com.congent.logic.DbLogic;

public class DbTester {

	public static void main(String[] args) throws SQLException {
		DbLogic dbLogic = new DbLogic();

		System.out.println("Before insert");
		dbLogic.query();

		// add
		dbLogic.insert(123, "Tias");

		System.out.println("After insert");
		// query
		dbLogic.query();


		// query
		// update
		dbLogic.update(123, "Jack");

		System.out.println("After Update");
		// query again
		dbLogic.query();


		// delete
		dbLogic.delete(123);
		System.out.println("After Delete");
		// query again
		dbLogic.query();

	}

}
