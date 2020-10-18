package com.EmployeePayroll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFileIOService {

	public static final String PAYROLL_FILE_NAME = "Employee-payroll-file.txt";//

	public void writeData(List<EmployeePayrollData> employeeList) {

		StringBuffer employeeBufferString = new StringBuffer();
		employeeList.forEach(employee -> {
			String employeeDataString = employee.toString().concat("\n");
			employeeBufferString.append(employeeDataString);
		});

		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME), employeeBufferString.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();//
		}
	}

	public long countEntries() {
		long countOfEntries = 0;
		try {
			countOfEntries = Files.lines(Paths.get(PAYROLL_FILE_NAME)).count();
		} catch (IOException e) {
		}
		return countOfEntries;
	}

	public void printEmployeePayrolls() {
		try {
			Files.lines(Paths.get(PAYROLL_FILE_NAME)).forEach(System.out::println);
		} catch (IOException e) {
		}
	}
}/* ... */