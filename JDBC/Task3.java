package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Task3 {

	public static void email(String e, int i) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_20", "root", "Nikhil543");
	
		PreparedStatement p = c.prepareStatement("update author set email=? where id=?");
		
		p.setString(1, e);
		p.setInt(2, i);
		
		int a = p.executeUpdate();
		
		if(a>0) {
			System.out.println("Email updated : "+e);
		}
		else {
			System.err.println("issue related query...");
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		Task3.email("ishwarvaidya@gmail.com", 7);

	}

}
