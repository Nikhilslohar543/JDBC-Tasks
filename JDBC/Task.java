package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Task {

	public static void fetch(int i) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_20", "root", "Nikhil543");
	
		PreparedStatement p = c.prepareStatement("select * from author where id = ?");
		
		p.setInt(1, i);
		
		ResultSet a = p.executeQuery();
		
		boolean found = false;
		
		while(a.next()) {
			found = true;
			System.out.println(a.getInt(1)+" "+a.getString(2)+" "+a.getString(3));
		}
		if(!found) {
			System.out.println("User not found with id "+i);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter author id :");
		int id = s.nextInt();

		Task.fetch(id);

	}

}
