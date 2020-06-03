package com.kta.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";

		try {
			
			System.out.println("connecting to database: "+url);
			Connection con = DriverManager.getConnection(url, user, pass);
			
			System.out.println("Connection successful!!");
			
		}catch( Exception ex) {
			ex.printStackTrace();
		}
	}

}
