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

/**
 * <p>
 * Controller which passes data to the webpage to render charts. Retrieves
 * information from the database to display information on the dashboard for the
 * user.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-09-15
 */
@Controller
public class DashboardController {
    EmployeeService employeeService = new EmployeeService();

    /**
     * <p>
     * This method maps the
     * </p>
     * 
     * @param model
     *            ModelMap object which is used to map the data to the elemts in
     *            the webpage.
     * @param session
     *            HttpSession object which stores the current session of the
     *            authenticated user.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
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
            model.addAttribute("AdminPercent", (adminCount / totalCount) * 100);
            model.addAttribute("EmployeePercent", (employeeCount / totalCount) * 100);

            model.addAttribute("DeveloperCount", developerCount);
            model.addAttribute("TestingCount", testingCount);
            model.addAttribute("HRCount", hrCount);
            model.addAttribute("ManagementCount", manageCount);
            model.addAttribute("OthersCount", othersCount);

            int employeeId = (int) session.getAttribute("HRMSEmployeeId");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(employeeService.searchEmployee(employeeId).getEmployeeDateOfBirth());
            
            if ((new Date().getMonth() + 1) == (date.getMonth() + 1) && (new Date().getDate()) == (date.getDate())) {
                model.addAttribute("BirthdayWish", "Happy Birthday");
            } else if ((new Date().getMonth() + 1) <= (date.getMonth() + 1)) {
                model.addAttribute("Birthday", new Date().getYear() + 1900 + "/" + (date.getMonth() + 1) + "/" + date.getDate());
            } else {
                model.addAttribute("Birthday", new Date().getYear() + 1901 + "/" + (date.getMonth() + 1) + "/" + date.getDate());
            }
        } catch (DataException e) {
            model.addAttribute("message", "Problem with Dashboard View");
        }
        return "dashboard";
    }
}
