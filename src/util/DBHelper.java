package util;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;



public class DBHelper {



	public static final String driver = "com.mysql.jdbc.Driver";



	public static final String url = "jdbc:mysql://localhost:8889/OOAD?characterEncoding=utf8&useSSL=true";

	public static final String username = "root";

	public static final String password = "root";

	public static Connection con = null;

	static {

		try {

			Class.forName(driver);

		} catch (ClassNotFoundException e) {

// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	public static Connection getConnection() {

		if (con == null) {

			try {

				con = DriverManager.getConnection(url, username, password);// build connection

			} catch (SQLException e) {

// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}

		return con;

	}

}