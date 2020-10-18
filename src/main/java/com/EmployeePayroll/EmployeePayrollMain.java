package com.EmployeePayroll;

import java.util.*;

public class EmployeePayrollMain {
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	private List<EmployeePayrollData> empList;

	public EmployeePayrollMain(List<EmployeePayrollData> empList) {
		super();
		this.empList = empList;
	}

	public EmployeePayrollMain() {
		this.empList = new ArrayList<EmployeePayrollData>();
	}

	public static void main(String[] args) {
		// ArrayList<EmployeePayrollData> empList = new ArrayList<>();
		EmployeePayrollMain empMain = new EmployeePayrollMain();
		Scanner sc = new Scanner(System.in);
		empMain.readInput(sc);
		empMain.showOutput(IOService.CONSOLE_IO);
	}

	private void readInput(Scanner sc) {
		EmployeePayrollData empPayroll = new EmployeePayrollData();
		System.out.println("Enter Employee id");
		// int id = sc.nextInt();
		empPayroll.id = sc.nextInt();
		System.out.println("Enter Employee name");
		// String name = sc.next();
		empPayroll.name = sc.next();
		sc.nextLine();
		System.out.println("Enter Employee salary");
		// float salary = sc.nextFloat();
		empPayroll.salary = sc.nextDouble();

		empList.add(empPayroll);
	}

	public void showOutput(IOService inputReader) {
		if (inputReader.equals(IOService.CONSOLE_IO)) {
			for (EmployeePayrollData o : empList)
				System.out.println(o.toString());
		} else if (inputReader.equals(IOService.FILE_IO)) {
			new EmployeePayrollFileIOService().writeData(empList);
		}
	}

	public long countEntries(IOService inputReader) {
		if (inputReader.equals(IOService.FILE_IO))
			return new EmployeePayrollFileIOService().countEntries();
		return 0;
	}

	public void printEmployeePayrollData() {
		new EmployeePayrollFileIOService().printEmployeePayrolls();
	}

}
/* ... */