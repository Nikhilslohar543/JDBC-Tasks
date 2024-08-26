package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Task_1 {

	public static void T1(int id, String firstname, String lastname, String email, String date) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_20", "root", "Nikhil543");

		PreparedStatement p = c.prepareStatement("insert into author (id,first_name,last_name,email,birthday)values(?,?,?,?,?)");

		p.setInt(1, id);
		p.setString(2, firstname);
		p.setString(3, lastname);
		p.setString(4, email);
		p.setString(5, date);
		
		int a = p.executeUpdate();

		if(a>0) {
			System.out.println("Author added successfully...");
			System.out.println("id :"+id+", first name :"+firstname+", last name :"+lastname+", email :"+email+", DOB :"+date);
		}
		else {
			System.out.println("There was a problem");
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		Task_1.T1(7, "Ishwar", "Viadya", "ishwarvaidya@gmail.com", "2001-3-29");
	}

}
