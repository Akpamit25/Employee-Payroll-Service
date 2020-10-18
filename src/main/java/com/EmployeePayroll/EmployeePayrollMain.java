package com.EmployeePayroll;

import java.util.*;

public class EmployeePayrollMain {

	private List<EmployeePayrollData> empList;
	
	
	public EmployeePayrollMain(List<EmployeePayrollData> empList) {
		super();
		this.empList = empList;
	}

	public EmployeePayrollMain() {
		this.empList  = new ArrayList<EmployeePayrollData>();
	}
	public static void main(String[] args) {
		//ArrayList<EmployeePayrollData> empList = new ArrayList<>();
		EmployeePayrollMain empMain = new EmployeePayrollMain();
		Scanner sc = new Scanner(System.in);
		empMain.readInput(sc);
		empMain.showOutput();
	}
	
	private void readInput(Scanner sc) {
		EmployeePayrollData empPayroll = new EmployeePayrollData();
		System.out.println("Enter Employee id");
		//int id = sc.nextInt();
		empPayroll.id = sc.nextInt();
		System.out.println("Enter Employee name");
		//String name = sc.next();
		empPayroll.name = sc.next();
		sc.nextLine();
		System.out.println("Enter Employee salary");
		//float salary = sc.nextFloat();
		empPayroll.salary = sc.nextFloat();

		empList.add(empPayroll);
	}

	private void showOutput() {
		System.out.println("\n Writing Employee Payroll Details To The Console : ");
	    System.out.println(empList);

	}

}
