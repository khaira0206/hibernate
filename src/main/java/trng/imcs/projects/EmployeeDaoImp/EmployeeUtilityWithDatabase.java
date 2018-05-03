package trng.imcs.projects.EmployeeDaoImp;

import trng.imcs.projects.EmployeeDao.Employee;
import trng.imcs.projects.EmployeeDao.EmployeeDao;

public class EmployeeUtilityWithDatabase {

	static EmployeeDao empInterface = new EmployeeDaoImp();

	public static void createEmployee() {

		for (int i = 50000; i < 50005; i++) {
			Employee emp = new Employee(i, "singh", "harman", "cs305", "abc@gmail.com", "1", 1002, "employee");
			empInterface.add(emp);
		}

	}

	public static void delete() {

		Employee emp = new Employee(50002, "singh", "harman", "cs305", "abc@gmail.com", "1", 1002, "employee");

		empInterface.deleteEmployee(Integer.valueOf(50002));

	}

	public static void update() {

		Employee emp = new Employee(50003, "singh123", "harman123", "cs305", "abc@gmail.com123", "1", 1002,
				"employee123");

		empInterface.updateEmployee(emp);

	}

	public static void get() {

		empInterface.getAllEmployees();

	}

}
