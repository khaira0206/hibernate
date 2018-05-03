package trng.imcs.projects.EmployeeDaoImp;

public class AppWithDatabase {

	public static void main(String[] args) {

		EmployeeUtilityWithDatabase.createEmployee();
		EmployeeUtilityWithDatabase.delete();

		EmployeeUtilityWithDatabase.update();
		EmployeeUtilityWithDatabase.get();

	}

}
