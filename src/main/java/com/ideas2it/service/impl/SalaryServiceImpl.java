package com.ideas2it.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.AllowanceVariant;
import com.ideas2it.model.Designation;
import com.ideas2it.model.Project;
import com.ideas2it.model.User;
import com.ideas2it.service.AllowanceVariantService;
import com.ideas2it.service.LeaveRequestService;
import com.ideas2it.service.ProjectService;
import com.ideas2it.service.SalaryService;
import com.ideas2it.service.UserService;
import com.ideas2it.model.Salary;

/**
 * <p>
 * Service class which does generate the salary for each user. Passes values to
 * the Dao class to carry out manipulations. Throws error messages in case of
 * occurrence of any exceptions.
 * </p>
 *
 * @author Praveen RaJ
 *
 * @created 2016-09-15
 */

@Service("salaryService")
public class SalaryServiceImpl extends GenericManagerImpl<Salary, Long> implements SalaryService {

	@Autowired
	UserService userService;

	@Autowired
	AllowanceVariantService allowanceVariantService;

	@Autowired
	LeaveRequestService leaveRequestService;

	/**
	 * Method is used genetare the salary for each user and return the salary
	 * list.
	 * 
	 * @param fromDate
	 *            from which Date to generate the salary
	 * @param toDate
	 *            to which Date to generate the salary
	 * @param noDays
	 *            noDays between two dates
	 * @return Salary list to the user
	 * @throws NumberFormatException
	 *             if there is any number format exception occurred
	 * @throws DataException
	 *             if there is any data exception occurred
	 */
	public List<Salary> generateSalary(String fromDate, String toDate, int noDays)
			throws NumberFormatException, DataException {
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
		for (User user : userService.retrieveUsers()) {
			basicPay = Float.parseFloat(user.getBasicPay());
			perDaySalary = basicPay / 30;
			basicPay = perDaySalary * noDays;
			designation = user.getDesignation();
			allowanceVarient = allowanceVariantService.getAllowanceVariantByDesignation(designation.getDesignationId());
			da = (allowanceVarient.getDearnessAllowance() / 100) * basicPay;
			hra = (allowanceVarient.getHouseRentAllowance() / 100) * basicPay;
			ma = (allowanceVarient.getMedicalAllowance() / 100) * basicPay;
			pf = (allowanceVarient.getProvidentFund() / 100) * basicPay;
			totalAmount = (basicPay + da + hra + ma) - pf;
			noOfDaysLeave = leaveRequestService.retriveNoofDaysLeaveByUser(user.getId(), fromDate, toDate);
			lossOfPay = perDaySalary * noOfDaysLeave;
			totalAmount = totalAmount - lossOfPay;
			salaryList.add(new Salary(user, hra, da, pf, ma, totalAmount, basicPay, noOfDaysLeave, lossOfPay));
		}
		return salaryList;
	}

}
