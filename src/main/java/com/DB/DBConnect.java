package com.DB;

import java.sql.*;

public class DBConnect {
	private static Connection conn=null;

public static Connection getConn()
{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:sktimaan","system","kilWish143");
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return conn;
	}
}
