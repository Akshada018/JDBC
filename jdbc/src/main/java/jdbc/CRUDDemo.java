package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.utils.DBUtil;
import com.pojo.EmployeeDetails;

public class CRUDDemo {

	public int getTotalDataCount() {
		Connection con = DBUtil.getMySQLConnection();
		int count = 0;
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT COUNT(empid) as totalEmployee FROM employee.empdetails WHERE 1=1;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	public void readEmployee() {
		Connection con = DBUtil.getMySQLConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM employee.empdetails;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createEmployee(EmployeeDetails ed) {
		Connection con = DBUtil.getMySQLConnection();
		try {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO employee.empdetails (`empid`, `empname`, `empcity`) VALUES (?,?,?);");
			ps.setInt(1, ed.getEmpid());
			ps.setString(2, ed.getEmpname());
			ps.setString(3, ed.getEmpcity());
			int a = ps.executeUpdate();
			System.out.println(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployee(EmployeeDetails empU) {
		Connection con = DBUtil.getMySQLConnection();
		try {
			PreparedStatement ps = con
					.prepareStatement("UPDATE `employee`.`empdetails` SET `empname` = ? WHERE (`empid` = ?);");
			ps.setString(1, empU.getEmpname());
			ps.setInt(2, empU.getEmpid());
			int a = ps.executeUpdate();
			System.out.println(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteEmployee(int employeeid) {
		Connection con = DBUtil.getMySQLConnection();
		try {
			PreparedStatement ps = con
					.prepareStatement("DELETE FROM `employee`.`empdetails` WHERE (`empid` = ?);");
			ps.setInt(1, employeeid);
			int a = ps.executeUpdate();
			System.out.println(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
