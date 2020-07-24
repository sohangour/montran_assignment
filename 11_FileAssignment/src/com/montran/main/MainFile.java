package com.montran.main;

import java.io.File;
import java.util.Scanner;

import com.montran.util.InputStreamUtil;
import com.montran.util.OutputStreamUtil;

public class MainFile {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		OutputStreamUtil outputStreamUtil = new OutputStreamUtil();
		InputStreamUtil inputStreamUtil = new InputStreamUtil();
		Integer employeeId;
		String name;
		byte[] data = null;
		double salary;
		File file;
		System.out.println("Enter Employee ID");
		employeeId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Name");
		name = scanner.nextLine();
		System.out.println("Enter Salary");
		salary = scanner.nextDouble();
		file = new File("c:/Files/employee.txt");
		name = name + " " + employeeId + " " + salary;
		outputStreamUtil.storeDataIntoFile(file, name.getBytes());
		System.out.println("------------------Record inserted into " + file.getName() + " --------------------");
		System.out.println("File Data Is");
		data = inputStreamUtil.getFileData(file);
		for (byte b : data) {
			System.out.print((char) b);
		}
		scanner.close();

	}

}
