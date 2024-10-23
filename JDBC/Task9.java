package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task9 {

	public static void authors(String date) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_20", "root", "Nikhil543");

		PreparedStatement st = con
				.prepareStatement("select * from author left join post on author.id = post.author_id where date = ?");

		st.setString(1, date);

		ResultSet a = st.executeQuery();

		while (a.next()) {
			System.out.println(a.getInt(1) + " " + a.getString(2) + " " + a.getString(3));
		}

	}

	public static void main(String[] args) throws Exception, SQLException {
		Task9.authors("2024-04-25");
	}

}
