package jdbc;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc1 {

	public static void main(String[] args) {
		Statement smt = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "12345");
			smt = con.createStatement();
			/* int data = smt.executeUpdate("insert into employee values(107,'Ankita Shinde',20000)");
			if (data > 0) {
				System.out.println("Data inserted successfully.");
			}*/
			System.out.println("EmpId \t\t EmpName \t\t Salary");
			ResultSet rs = smt.executeQuery("select * from employee");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getDouble(3));
			}
			rs.close();
			smt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
