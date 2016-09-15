package com.i2i.service;

import java.util.ArrayList;
import java.util.List;

import com.i2i.exception.DataException;
import com.i2i.model.AllowanceVariant;
import com.i2i.model.Designation;
import com.i2i.model.Employee;
import com.i2i.model.Salary;

/**
 * <p>
 * Service class which does genetare the salary for each employee. 
 * Passes values to the Dao class to carry out manipulations. Throws
 * error messages in case of occurrence of any exceptions.
 * </p>
 *
 * @author Praveen RaJ
 *
 * @created 2016-09-15
 */
public class SalaryService {
	EmployeeService employeeService = new EmployeeService();
	AllowanceVariantService allowanceVariantService = new AllowanceVariantService();
	LeaveRequestService leaveRequestService = new LeaveRequestService(); 
	
/**
 * @throws DataException 
 * @throws NumberFormatException 
 * 
 */
	public List<Salary> generateSalary(String fromDate, String toDate, int noDays) throws NumberFormatException, DataException{
		float basicPay;
		float perDaySalary;
		float da;
		float hra;
		float ma;
		float pf;
		float lossOfPay;
		float totalAmount;
		int noOfDaysLeave;
		AllowanceVariant allowanceVarient;
		Designation designation;
		List<Salary> salaryList = new ArrayList<Salary>();
		for(Employee employee : employeeService.retrieveEmployees() ){
			 basicPay = Float.parseFloat(employee.getEmployeeBasicPay());
			 perDaySalary = basicPay / 30;				 
			 basicPay = perDaySalary * noDays;
			 designation = employee.getEmployeeDesignation();
			 allowanceVarient = allowanceVariantService.getAllowanceVariantByDesignation(designation.getDesignationId());
			 da = (allowanceVarient.getDearnessAllowance() / 100) * basicPay;
			 hra = (allowanceVarient.getHouseRentAllowance() / 100) * basicPay;
			 ma = (allowanceVarient.getMedicalAllowance() / 100) * basicPay;
			 pf = (allowanceVarient.getProvidentFund() / 100) * basicPay;
			 totalAmount = ( basicPay + da + hra + ma ) - pf;
			 noOfDaysLeave = leaveRequestService.retriveNoofDaysLeaveByEmployee(employee.getEmployeeId(), fromDate, toDate);
			 lossOfPay = perDaySalary * noOfDaysLeave;
			 totalAmount = totalAmount - lossOfPay;
			 salaryList.add(new Salary(employee, hra, da, pf, ma, totalAmount, basicPay, noOfDaysLeave, lossOfPay));
		}
		return salaryList;
	}
	
}
