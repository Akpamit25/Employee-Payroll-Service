package com.EmployeePayroll;

public class EmployeePayrollData {

	int id;//
	String name;
	double salary;//

	public EmployeePayrollData(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;//
	}
	
	
	public EmployeePayrollData() {
		
	}
	
	public String toString() {
		return "EmployeeId =" + id + " ,name=" + name + " ,salary=" + salary;
	}
}
