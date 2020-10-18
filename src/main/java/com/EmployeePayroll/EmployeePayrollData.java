package com.EmployeePayroll;

public class EmployeePayrollData {

	int id;
	String name;
	float salary;

	public EmployeePayrollData(int id, String name, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	
	public EmployeePayrollData() {
		
	}
	
	public String toString() {
		return "EmployeeId =" + id + " ,name=" + name + " ,salary=" + salary;
	}
}
