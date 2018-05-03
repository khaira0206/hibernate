package trng.imcs.projects.EmployeeDaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import trng.imcs.projects.EmployeeDao.Employee;
import trng.imcs.projects.EmployeeDao.EmployeeDao;
import trng.imcs.projects.conn_lib.JdbcConnectionFactory;



public class EmployeeDaoImp implements EmployeeDao{

	public void getAllEmployees() {
		
		String query = "select * from employees order by lastname";

		try (Connection con = JdbcConnectionFactory.getConnection();
				PreparedStatement st = con.prepareStatement(query);) {
			ResultSet rs = st.executeQuery();

			System.out.println("Emp Id" + "             " + " Last Name" + "              " + " Fisrt Name"
					+ "                " + " Extension" + "            " + "email" + "           " + "Ofice Code"
					+ "            " + "Supervisor" + "               " + "Job Title");
			while (rs.next()) {

				System.out.println(rs.getInt(1) + "         " + rs.getString(2) + "            " + rs.getString(3)
						+ "                 " + rs.getString(4) + "               " + rs.getString(5)
						+ "                    " + rs.getString(6) + "             " + rs.getInt(7) + "                "
						+ rs.getString(8));

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	public boolean deleteEmployee(Integer id) {
		
		String query = "delete from employees where employeeNumber = ?";

		try (Connection con = JdbcConnectionFactory.getConnection();
				PreparedStatement st = con.prepareStatement(query);) {
			st.setInt(1, id);
			int noOfRecords = st.executeUpdate();

			return noOfRecords > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateEmployee(Employee obj) {
		String query = "update employees"
				+ " set  lastName = ? , firstName = ? , extension =? , email = ? , officeCode = ?, reportsTo = ?, jobTitle= ?"
				+ "where employeeNumber = ?";

		try (Connection con = JdbcConnectionFactory.getConnection();
				PreparedStatement st = con.prepareStatement(query);) {
			st.setString(1, obj.getLastName());
			st.setString(2, obj.getFisrtName());
			st.setString(3, obj.getExtension());
			st.setString(4, obj.getEmail());
			st.setString(5, obj.getOfficeCode());
			st.setInt(6, obj.getSupervisor());
			st.setString(7, obj.getJobTitle());
			st.setInt(8, obj.getEmpID());
			int noOfRecords = st.executeUpdate();

			return noOfRecords > 0;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}

	public boolean add(Employee obj) {
		
		String query = "insert into employees"
				+ "(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle)"
				+ "values (?,?,?,?,?,?,?,?)";

		try (Connection con = JdbcConnectionFactory.getConnection();
				PreparedStatement st = con.prepareStatement(query);) {
			st.setInt(1, obj.getEmpID());
			st.setString(2, obj.getLastName());
			st.setString(3, obj.getFisrtName());
			st.setString(4, obj.getExtension());
			st.setString(5, obj.getEmail());
			st.setString(6, obj.getOfficeCode());
			st.setInt(7, obj.getSupervisor());
			st.setString(8, obj.getJobTitle());

			int noOfRecords = st.executeUpdate();

			return noOfRecords > 0;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}


}
