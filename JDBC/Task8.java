package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task8 {

	public static void authors(int id) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_20", "root", "Nikhil543");

		PreparedStatement st = con.prepareStatement("delete from post where id = ?");

		st.setInt(1, id);

		int a = st.executeUpdate();
		System.out.println(a);

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Task8.authors(5);
	}

}
