package com.montran.util;

import java.util.ArrayList;
import java.util.List;

import com.montran.pojo.Employee;

public class EmployeeCollectionUtil {

	private List<Employee> employeeList = new ArrayList<Employee>();
	private Employee emp;

	public boolean addNewEmployee(Employee employee) {
		employeeList.add(employee);
		return true;
	}

	public boolean addAllEmployees(Employee[] employee) {
		for (Employee employee2 : employee) {
			employeeList.add(employee2);
		}
		return true;
	}

	public boolean updateEmployeeSalary( double newSalary,Employee emp) {
            
      emp.setSalary(newSalary);
		return true;
	}

	public boolean deleteEmployee(Employee emp) {
        employeeList.remove(emp); 
		return true;
	}

	public Employee getEmployeeById(int employeeId) {
		for (Employee employee : employeeList) {
			if(employee.getEmployeeId()==employeeId) {
				return employee;
			}
		}
		return null;
	}

	public List<Employee> getAllEmployees() {
		return employeeList;
	}

}
