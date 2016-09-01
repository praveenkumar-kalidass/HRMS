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
	@RequestMapping("/#")
	public String createDepartment(ModelMap model) {
		model.addAttribute("department", new Department());
		return "#";
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
    @RequestMapping(value ="/#", method = RequestMethod.POST)
    public String insertDepartment(@ModelAttribute("department")Department department, ModelMap model) {
        try {
            DepartmentService departmentService = new DepartmentService();
            if (departmentService.addDepartment(department)) {
                model.addAttribute("#", "Department details are successfully inserted");
            } else {
            	model.addAttribute("#", "Department details are not inserted");
            }
        } catch (DataException exception) {
            model.addAttribute("#", exception.getMessage());
        } finally {
            return "#";
        }
    }
    
    /**
     * <p>
     * This method passes the department ID to be deleted to its service class.
     * </p>
     * 
     * @param departmentId
     *       contains the ID of the department.
     * @param message
     *       possess the message related to the status of the operation done. contains error message
     *       if any exception occurs.
     * @return String
     *       returns the redirecting page url based on the appropriate operation.
     */
    @RequestMapping(value ="/#", method = RequestMethod.GET)
    public String deleteDepartment(@RequestParam("departmentId")String departmentId, ModelMap model) {
        String message = " ";
        try {
            DepartmentService departmentService = new DepartmentService();
            if (departmentService.deleteDepartment(Integer.parseInt(departmentId))) {
            	model.addAttribute("#", "Department details are successfully deleted");
            } else {
            	model.addAttribute("#", "Department details are not deleted");
            }
        } catch (DataException exception) {
        	model.addAttribute("#", exception.getMessage());
        } finally {
            return "#";
        }
    }
    
    /**
     * <p>
     * This method passes the department ID to check its presence in the database.
     * Returns the department details to display if present in the database.
     * </p>
     * 
     * @param departmentId
     *       contains the ID of the department.
     * @return String
     *       returns the redirecting page url based on the appropriate operation.
     */
    @RequestMapping(value ="/#", method = RequestMethod.GET)
    public String searchDepartment(@RequestParam("departmentId")String departmentId, ModelMap model) {
        try {
        	DepartmentService departmentService = new DepartmentService();
            if (null != departmentService.searchDepartment(Integer.parseInt(departmentId))) {
                model.addAttribute("department", departmentService.searchDepartment(Integer.parseInt(departmentId)));
            } else {
                model.addAttribute("message", "Department detail is not present");
            }
        } catch (DataException exception) {
        	model.addAttribute("message", exception.getMessage());
        } finally {
            return "#";
        }
    }
    
    /**
     * <p>
     * This method retrieves the list of department data from the service class
     * and returns the data to display.
     * </p>
     * 
     * @return String
     *       returns the redirecting page url based on the appropriate operation.
     */
    @RequestMapping(value ="/#", method = RequestMethod.GET)
    public String displayDepartments(ModelMap model) {
        try {
        	DepartmentService departmentService = new DepartmentService();
            if (departmentService.displayDepartments().size() != 0) {
                model.addAttribute("departments", departmentService.displayDepartments());
            } else {
            	model.addAttribute("message", "Records are empty");
            }
        } catch (DataException exception) {
        	model.addAttribute("message", exception.getMessage());
        } finally {
            return "#";
        }
    }
}