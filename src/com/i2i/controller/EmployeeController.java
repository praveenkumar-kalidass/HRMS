package com.i2i.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.i2i.exception.DataException;
import com.i2i.model.Department;
import com.i2i.service.DepartmentService;

/**
 * <p>
 * Controller which gets parameters from the user inputs and displays message to the user, based
 * on the status of the manipulation of employee records. Displays error message when exception occurs
 * during the manipulation process.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-08-15
 */
@Controller
public class EmployeeController {
	
	DepartmentService departmentService = new DepartmentService();
	
	@RequestMapping("/index")
	public String indexPage() {
		return "index";
	}
	
	
	
	@RequestMapping("/department")
	public String createDepartment(ModelMap model) {
		try {
		model.addAttribute("Department", new Department());
		model.addAttribute("DepartmentList", departmentService.displayDepartments());
		} catch (DataException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "department";
	}
	
	/**
     * <p>
     * This method passes the department detail as the model object into its Service class.
     * </p>
     * 
     * @param department
     *       model object that stores the department data associated with model.
     * @return String
     *       returns the redirecting page url based on the appropriate operation.
     */
    @RequestMapping(value ="/department_insert", method = RequestMethod.POST)
    public String insertDepartment(@ModelAttribute("Department")Department department, ModelMap model) {
        try {
            DepartmentService departmentService = new DepartmentService();
            if (departmentService.addDepartment(department)) {
                model.addAttribute("message", "Department details are successfully inserted");
            } else {
            	model.addAttribute("message", "Department details are not inserted");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } finally {
            return "department";
        }
    }
    
    
	
	
}