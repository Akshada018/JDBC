import com.pojo.EmployeeDetails;

import jdbc.CRUDDemo;

public class PSDemoUsingUtilMethod {

	public static void main(String[] args) {

		CRUDDemo cd = new CRUDDemo();
		System.out.println(cd.getTotalDataCount());

		System.out.println("----------READ OPERATION-------------");
		cd.readEmployee();
		//cd.readEmployee();

		/*
		 * System.out.println("----------WRITE OPERATION------------"); EmployeeDetails
		 * ed = new EmployeeDetails(); ed.setEmpid(105); ed.setEmpname("SHRUTI BHEDE");
		 * ed.setEmpcity("PUNE"); cd.createEmployee(ed);
		 */
		
		System.out.println("-----------UPDATE OPERATION-----------");
		
		EmployeeDetails empU = new EmployeeDetails();
		empU.setEmpid(102);
		empU.setEmpname("Updated Employee");
		cd.updateEmployee(empU);
	}

}
