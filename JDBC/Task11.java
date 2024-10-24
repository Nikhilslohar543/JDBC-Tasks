package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task11 {

	public static void authors(String Title) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_20", "root", "Nikhil543");

		PreparedStatement st = con.prepareStatement("SELECT * FROM post WHERE title LIKE ?");

		st.setString(1, Title+ "%");

		ResultSet a = st.executeQuery();
		while (a.next()) {

			System.out.println("id :"+a.getInt(1) +"\ntitle :"+ a.getString(3) +"\ndesc : "+ a.getString(4));

		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Task11.authors("first");

	}

}
