package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Task4 {

	public static void delete(int i) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_20", "root", "Nikhil543");

		PreparedStatement p = c.prepareStatement("delete from author where id = ?");

		p.setInt(1, i);

		int a = p.executeUpdate();

		if (a > 0) {
			System.out.println("User with id " + i + " deleted successfully...");
		} else {
			System.out.println("id not found...");
		}

	}

	public static void main(String[] args) throws Exception {

		Scanner s = new Scanner(System.in);

		System.out.print("Enter author id :");
		int id = s.nextInt();

		Task4.delete(id);

	}

}
