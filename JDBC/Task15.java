package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Task15 {

	public static void authors(String firstdate, String Seconddate) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_20", "root", "Nikhil543");

		PreparedStatement st = con.prepareStatement(" SELECT * FROM post WHERE date BETWEEN ? AND ? ");

		st.setString(1, firstdate);
		st.setString(2, Seconddate);

		ResultSet a = st.executeQuery();
		while (a.next()) {

			System.out.println("id :" + a.getInt(1) + ", titile :" + a.getString(3) + ", desc :" + a.getString(4)
					+ ", date :" + a.getString(6));

		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Task15.authors("2024-02-15", "2024-04-15");

	}

}
