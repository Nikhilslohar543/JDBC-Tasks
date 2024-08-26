package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Task2 {

	public static void email (String e) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_20", "root", "Nikhil543");
		
		PreparedStatement p = c.prepareStatement("select * from author where email=?");
		
		p.setString(1, e);
		
		ResultSet a = p.executeQuery();
		
		while(a.next()) {
			System.out.println(a.getInt(1)+" "+a.getString(2)+" "+a.getString(3)+" "+a.getString(4)+" "+a.getString(5));
		}
	}	
	
	public static void main(String[] args) throws Exception {

		Task2.email("ishwarvaidya@gmail.com");
		
	}

}
