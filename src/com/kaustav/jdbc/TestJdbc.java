package com.kaustav.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl  = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String jdbcuser = "hbstudent";
		String jdbcuserpass = "hbstudent";
		try {
			System.out.println("connecting to the databse "+jdbcUrl);
			
			Connection connection = DriverManager.getConnection(jdbcUrl, jdbcuser, jdbcuserpass);
			
			System.out.println("Connected to the database.");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
