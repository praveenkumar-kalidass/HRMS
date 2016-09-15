package com.i2i.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.i2i.exception.DataException;
import com.i2i.model.Employee;
import com.i2i.service.EmployeeService;

@Controller
public class DashboardController {
	EmployeeService employeeService = new EmployeeService();
	
	@RequestMapping("/dashboard")
	public String dashboardView(ModelMap model, HttpSession session) throws ParseException {
		try {
			float adminCount = 0;
			float employeeCount = 0;
			int developerCount = 0;
			int testingCount = 0;
			int hrCount = 0;
			int manageCount = 0;
			int othersCount = 0;
			
		    for (Employee employee : employeeService.retrieveEmployees()) {
			    if (employee.getEmployeeRole().getRoleName().equals("Admin")) {
			    	adminCount++;
			    } else {
			    	employeeCount++;
			    }
			    
			    if (employee.getEmployeeDesignation().getDepartment().getDepartmentName().equals("Developer")) {
			    	developerCount++;
			    } else if (employee.getEmployeeDesignation().getDepartment().getDepartmentName().equals("Testing")) {
			    	testingCount++;
			    } else if (employee.getEmployeeDesignation().getDepartment().getDepartmentName().equals("HR")) {
			    	hrCount++;
			    } else if (employee.getEmployeeDesignation().getDepartment().getDepartmentName().equals("Management")) {
			    	manageCount++;
			    } else {
			    	othersCount++;
			    }
		    }
		    
		    float totalCount = adminCount + employeeCount;
		    model.addAttribute("AdminPercent", (adminCount/totalCount)*100);
		    model.addAttribute("EmployeePercent", (employeeCount/totalCount)*100);

		    model.addAttribute("DeveloperCount", developerCount);
		    model.addAttribute("TestingCount", testingCount);
		    model.addAttribute("HRCount", hrCount);
		    model.addAttribute("ManagementCount", manageCount);
		    model.addAttribute("OthersCount", othersCount);
		    
		    int employeeId = (int) session.getAttribute("HRMSEmployeeId");
		    System.out.println(employeeService.searchEmployee(employeeId).getEmployeeDateOfBirth());
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		    Date date = format.parse(employeeService.searchEmployee(employeeId).getEmployeeDateOfBirth());
		    System.out.println(employeeService.searchEmployee(employeeId).getEmployeeDateOfBirth());
		    model.addAttribute("Birthday", new Date().getYear()+1901+"/"+date.getMonth()+"/"+date.getDay());
		    System.out.println(new Date().getYear()+1901+"/"+date.getMonth()+"/"+date.getDay());
		} catch (DataException e) {
			model.addAttribute("message", "Problem with Dashboard View");
		}
		return "dashboard";
	}
}