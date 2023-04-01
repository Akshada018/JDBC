package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class ResultsetMetaDataEx {

	public static void main(String[] args) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "12345");
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("select * from student");
			ResultSetMetaData rsmd = rs.getMetaData();
			int n = rsmd.getColumnCount();
			System.out.println("Number of fields= " + n);

		} catch (Exception e) {

		}
	}

}
