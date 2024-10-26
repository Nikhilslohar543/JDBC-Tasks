package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task18 {

	public static void authors(int id, int author_id, String title, String discription, String content, String date)
			throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_20", "root", "Nikhil543");

		PreparedStatement st = con.prepareStatement(
				"insert into post (id,author_id,title,description,content,date) Values (?,?,?,?,?,?)");

		st.setInt(1, id);
		st.setInt(2, author_id);

		st.setString(3, title);
		st.setString(4, discription);
		st.setString(5, content);
		st.setString(6, date);
		int a = st.executeUpdate();
		System.out.println(a);

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Task18.authors(7, 2, "My first post", "This is discription of my first post", "this is contents of first post",
				"2024-06-11");
		Task18.authors(8, 3, "My second post", "This is discription of my Second post", "this is contentas 2 post",
				"2024-06-11");
		Task18.authors(9, 4, "My Third post", "This is discription of my Third post", "this is contentas 3 psot",
				"2024-07-11");

	}

}
