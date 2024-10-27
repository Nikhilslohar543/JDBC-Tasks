package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task21 {

	public static void oldestAuthor() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_20", "root", "Nikhil543");

		// SQL query to find the oldest author
		PreparedStatement st = con.prepareStatement("SELECT * FROM author " + "ORDER BY birthday ASC " + "LIMIT 1");

		ResultSet rs = st.executeQuery();
		if (rs.next()) {
			System.out.println("ID: " + rs.getInt("id") + ", First name: " + rs.getString("first_name")
					+ ", Last name: " + rs.getString("last_name") + ", Birthday: " + rs.getDate("birthday"));
		} else {
			System.out.println("No authors found.");
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Task21.oldestAuthor();
	}
}
