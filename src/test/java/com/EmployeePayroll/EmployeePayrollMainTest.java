package com.EmployeePayroll;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;


import com.EmployeePayroll.EmployeePayrollMain.IOService;

public class EmployeePayrollMainTest {

	@Test
	public void given3EmployeesWhenWrittenToFileShouldMatchNumberOfEmployeeEntries() {
		EmployeePayrollData[] arrayOfEmployees = { 
				new EmployeePayrollData(1, "Amit Kumar", 530000.0),
				new EmployeePayrollData(2, "Ankit Singh", 320000.0),
				new EmployeePayrollData(3, "Abhijeet", 700000.0) };
		EmployeePayrollMain payrollServiceObject = new EmployeePayrollMain(Arrays.asList(arrayOfEmployees));
		payrollServiceObject.showOutput(IOService.FILE_IO);
		Assert.assertEquals(3, payrollServiceObject.countEntries(IOService.FILE_IO));//
	}

}