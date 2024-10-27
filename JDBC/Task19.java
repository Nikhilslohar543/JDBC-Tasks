package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task19 {

	public static void authors() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_20", "root", "Nikhil543");

		PreparedStatement st = con
				.prepareStatement("SELECT author.id, author.first_name, author.last_name, COUNT(post.id) AS post_count "
						+ "FROM author " + "LEFT JOIN post ON author.id = post.author_id "
						+ "GROUP BY author.id, author.first_name, author.last_name");

		ResultSet a = st.executeQuery();
		while (a.next()) {

			System.out.println("First name :" + a.getString("first_name") + ", Last name : " + a.getString("last_name") + ", post count :"
					+ a.getInt("post_count"));

		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Task19.authors();
	}

}
