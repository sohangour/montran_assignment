package com.montran.main;
import java.util.List;
import java.util.Scanner;

import com.montran.pojo.Employee;

import com.montran.util.EmployeeCollectionUtil;

public class EmployeeCollectionMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EmployeeCollectionUtil util = new EmployeeCollectionUtil();
		Employee employee;
		int employeeId;
		String name;
		double salary;
		String Continuechoice;
		int choice;
		boolean result;
		List<Employee> employeeList;
		Employee[] employeeArray;
		do {
			employeeList = util.getAllEmployees();
			if (employeeList.isEmpty()) {

			} else {
				showEmployeeInTabular(employeeList);
			}
			System.out.println("Menu");
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("1. Add Single Employee");
			System.out.println("2. Add Multiple Employees");
			System.out.println("3. Update Existing Employee");
			System.out.println("4. Delete Existing Employee");
			System.out.println("5. Print Single Employee Details");
			System.out.println("6. Exit");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Employee Name");
				name = scanner.nextLine();
				System.out.println("Enter Employee Salary");
				salary = scanner.nextDouble();
				employee = new Employee(employeeId, name, salary);
				result = util.addNewEmployee(employee);
				if (result) {
					System.out.println("Successfully inserted");
				} else {
					System.out.println("No more space available");
				}
				break;
			case 2:
				System.out.println("How many Employees you want to add ");
				int n = scanner.nextInt();
				employeeArray = new Employee[n];
				for (int i = 0; i < n; i++) {
					int j = i + 1;
					System.out.println("Enter Employee " + j + " id");
					employeeId = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter Employee " + j + " name");
					name = scanner.nextLine();
					System.out.println("Enter Employee " + j + " price");
					salary = scanner.nextDouble();
					employee = new Employee(employeeId, name, salary);
					employeeArray[i] = employee;
				}
				result = util.addAllEmployees(employeeArray);
				if (result) {
					System.out.println("Successfully inserted");
				} else {
					System.out.println("No more space available");
				}

				break;
			case 3:
				System.out.println("Enter Employee id for update");
				employeeId = scanner.nextInt();
				employee = util.getEmployeeById(employeeId);
				if (employee == null) {
					System.out.println("No Employee Found ");
				} else {
					System.out.println("Enter Employee Salary");
					salary = scanner.nextDouble();
					result = util.updateEmployeeSalary(salary, employee);
					if (result) {
						System.out.println("Successfully updated");
					} else {
						System.out.println("Failed to update");
					}
				}
				break;
			case 4:
				System.out.println("Enter Employee id for delete");
				employeeId = scanner.nextInt();
				employee = util.getEmployeeById(employeeId);
				if (employee == null) {
					System.out.println("No Employee Found ");
				} else {
					result = util.deleteEmployee(employee);
					if (result) {
						System.out.println("Successfully deleted");
					} else {
						System.out.println("No Employee Found");
					}
				}
				break;
			case 5:
				System.out.println("Enter Employee id");
				employeeId = scanner.nextInt();
				employee = util.getEmployeeById(employeeId);
				if (employee != null) {
					System.out.println(employee);
				} else {
					System.out.println("No Employee Found");
				}
				break;
			case 6:
				System.out.println(" Thank you !!");
				System.exit(0);

			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue yes - no ?");
			Continuechoice = scanner.next();
		} while (Continuechoice.toLowerCase().equals("yes"));
		scanner.close();
	}

	private static void showEmployeeInTabular(List<Employee> allEmployee) {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.printf("%10s %30s %20s", "Employee Id", "Name", "Salary");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------");

		for (Employee Employee : allEmployee) {
			if (Employee != null) {
				System.out.format("%10d %30s %20f", Employee.getEmployeeId(), Employee.getName(), Employee.getSalary());
				System.out.println();
			}

		}
		System.out.println("-----------------------------------------------------------------------------");

	}
}
