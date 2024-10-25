package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task14 {

	public static void authors() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_20", "root", "Nikhil543");

		PreparedStatement st = con.prepareStatement(
				" select author.id,author.first_name,author.last_name from author "
				+ "left join post on author.id = post.author_id where post.author_id is null");

		ResultSet a = st.executeQuery();
		while (a.next()) {

			System.out.println(
					"id :" + a.getInt(1) + ", First name :" + a.getString(2) + ", Last name : " + a.getString(3));

		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Task14.authors();
	}

}
