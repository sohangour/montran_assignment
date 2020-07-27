package com.montran.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.montran.pojo.Employee;

public class EmployeeDatabaseUtil {

	private List<Employee> employeeList = new ArrayList<Employee>();
	private Employee employee;
	// database variable
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "montran";
	String password = "montran";
	Connection connection;
	PreparedStatement preparedStatementI, preparedStatementS, preparedStatementD, preparedStatementU,
			preparedStatementGetAll;
	ResultSet resultSet;
	String insertQuery = "insert into employee_master values(?,?,?)";
	String updateQuery = "update employee_master set salary=? where employeeId=?";
	String deleteQuery = "delete from employee_master where employeeId=?";
	String searchQuery = "select * from employee_master where employeeId=?";

	int i;
	boolean result;

	public EmployeeDatabaseUtil() {
		try {
			Class.forName(driver);
			//System.out.println("Driver Loaded");
			connection = DriverManager.getConnection(url, user, password);
			if (connection != null) {
				//System.out.println("Connection Success");
				preparedStatementI = connection.prepareStatement(insertQuery);
				preparedStatementS = connection.prepareStatement(searchQuery);
				preparedStatementD = connection.prepareStatement(deleteQuery);
				preparedStatementU = connection.prepareStatement(updateQuery);
				preparedStatementGetAll = connection.prepareStatement("select * from employee_master");
			} else {
				System.out.println("Connecetion Failed");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean addNewEmployee(Employee employee) {
		try {
			preparedStatementI.setInt(1, employee.getEmployeeId());
			preparedStatementI.setString(2, employee.getName());
			preparedStatementI.setDouble(3, employee.getSalary());
			i = preparedStatementI.executeUpdate();
			result = i > 0 ? true : false;
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addAllEmployees(Employee[] employee) {
		try {
			for (Employee employee2 : employee) {
				preparedStatementI.setInt(1, employee2.getEmployeeId());
				preparedStatementI.setString(2, employee2.getName());
				preparedStatementI.setDouble(3, employee2.getSalary());
				i = preparedStatementI.executeUpdate();
			}
			result = i > 0 ? true : false;
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateEmployeeSalary(double newSalary, int employeeId) {
		try {
			preparedStatementU.setInt(1, employeeId);
			preparedStatementU.setDouble(3, newSalary);
			i = preparedStatementU.executeUpdate();
			result = i > 0 ? true : false;
			return result;
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean deleteEmployee(int employeeId) {
		try {
			preparedStatementD.setInt(1, employeeId);
			i = preparedStatementD.executeUpdate();
			result = i > 0 ? true : false;
			return result;
		} catch (

		SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public Employee getEmployeeById(int employeeId) {
		try {
			preparedStatementS.setInt(1, employeeId);
			resultSet = preparedStatementS.executeQuery();
			if (resultSet.next()) {
				employee = new Employee(resultSet.getInt("employeeId"), resultSet.getString("name"),
						resultSet.getDouble("salary"));
				return employee;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Employee> getAllEmployees() {
		try {
			resultSet = preparedStatementGetAll.executeQuery();
			employeeList.clear();
			while (resultSet.next()) {
				employee = new Employee(resultSet.getInt("employeeId"), resultSet.getString("name"),
						resultSet.getDouble("salary"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return employeeList;
	}

	public void connectionClose() {
		try {
			connection.close();
			preparedStatementI.close();
			preparedStatementS.close();
			preparedStatementD.close();
			preparedStatementU.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
