package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;



public class JDBCDemo {
            
	public static void main(String[] args) {
		PreparedStatement psmt = null;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","12345");
			Statement smt = con.createStatement();
			//int data = smt.executeUpdate("insert into employee values(104,'Sanika Naik',20000)");
			psmt = con.prepareStatement("select * from employee where empid=?");
			System.out.print("Enter Employee Id to be search: ");
			int id = sc.nextInt();
			psmt.setInt(1,id);
			//System.out.println("Record inserted successfully...");
			//ResultSet rs = smt.executeQuery("Select * from employee");
			ResultSet rs = psmt.executeQuery();
			System.out.println("EmpID \t EmpName \t\t salary \t");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" \t"+rs.getString(2)+"\t\t"+rs.getFloat(3)+"\t\t");
				
			}
			rs.close();
			smt.close();
			con.close();
			}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
