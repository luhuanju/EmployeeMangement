package com.cogent.controller;

import java.sql.SQLException;

import com.congent.logic.DbLogic;

public class DbTester {

	public static void main(String[] args) throws SQLException {
		DbLogic dbLogic = new DbLogic();

		dbLogic.insert(101, "Pantry Butter", (float) 78.0, true);
		dbLogic.insert(102, "Toilet Paper", (float) 66.0, true);
		dbLogic.insert(103, "Batteries", (float) 34.0, true);
		dbLogic.insert(104, "Pet Food", (float) 67.0, true);
		dbLogic.insert(105, "Canned Goods", (float) 55.0, true);
		dbLogic.insert(106, "Coffee Cups", (float) 90.0, true);

		dbLogic.query();

	}

}
