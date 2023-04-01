package jdbc.utils;

import java.sql.*;

public class DBUtil {

	public static Connection getMySQLConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "12345");
		} catch (Exception e) {
			System.out.println("Error while creating DATABASE");
		}
		return con;
	}

	public static void cleanup(Connection con, Statement smt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (smt != null)
				smt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void cleanup(Connection con, Statement smt)
	{
		try {
			if(smt != null)
			smt.close();
			if(con != null)
				con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
