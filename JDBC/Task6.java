package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task6 {

	public static void authors(int author_id) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_20", "root",
				"Nikhil543");

		PreparedStatement st = con.prepareStatement("Select * from post where author_id = ?");

		st.setInt(1, author_id);

		ResultSet a = st.executeQuery();

		while (a.next()) {
			System.out.println(
					a.getInt(1) +" "+ a.getInt(2) +" "+ a.getString(3) +" "+ a.getString(4) +" "+ a.getString(5) +" "+ a.getString(6));
			System.out.println();

		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Task6.authors(3);

	}

}
