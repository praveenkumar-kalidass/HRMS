package com.i2i.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.i2i.exception.DataException;
import com.i2i.model.Department;
import com.i2i.model.Designation;
import com.i2i.service.DepartmentService;
import com.i2i.service.DesignationService;

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
	DesignationService designationService = new DesignationService();
	
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
	
	
	
	@RequestMapping("/designation")
	public String createDesignation(ModelMap model) {
		try {
		model.addAttribute("Designation", new Designation());
		model.addAttribute("DesignationList", designationService.getDesignations());
		model.addAttribute("DepartmentList", departmentService.displayDepartments());
		
		} catch (DataException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "designation";
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
    @RequestMapping(value ="/designation_insert", method = RequestMethod.POST)
    public String insertDesignation(@ModelAttribute("Designation")Designation designation, BindingResult result, @RequestParam("department")int departmentId, ModelMap model) {   
        try {        	
        	designation.setDepartment(departmentService.searchDepartment(departmentId));
            if (designationService.addDesignation(designation)) {
            	model.addAttribute("message", "Designation details are successfully inserted");
            } else {
            	model.addAttribute("message", "Designation details are not inserted");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } finally {
           
        }
        return "designation";
    }
	
	
	@RequestMapping(value ="/department_edit", method = RequestMethod.GET)
	public String editDepartment(@RequestParam("id")int departmentId, ModelMap model) {
		try {
		 model.addAttribute("DepartmentEdit", departmentService.searchDepartment(departmentId));
		 
		} catch (DataException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "department";
	}
	 @RequestMapping(value ="/designation_update", method = RequestMethod.POST)
	    public String updateDepartment(@ModelAttribute("DesignationEdit")Designation designation, BindingResult result, @RequestParam("department")int departmentId, ModelMap model) {
	        try {
	        	designation.setDepartment(departmentService.searchDepartment(departmentId));
	            if (designationService.updateDesignation(designation)) {
	                model.addAttribute("message", "Designation details are successfully Updated");
	            } else {
	            	model.addAttribute("message", "Designation details are not updated");
	            }
	        } catch (DataException exception) {
	            model.addAttribute("message", exception.getMessage());
	        } finally {
	            return "designation";
	        }
	    }
	
	
	@RequestMapping(value ="/designation_edit", method = RequestMethod.GET)
	public String editDesignation(@RequestParam("id")int designationId, ModelMap model) {
		try {	
		 model.addAttribute("DesignationEdit", designationService.searchDesignation(designationId));
		 model.addAttribute("DepartmentList", departmentService.displayDepartments());
		} catch (DataException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "designation";
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
    @RequestMapping(value ="/department_update", method = RequestMethod.POST)
    public String updateDepartment(@ModelAttribute("DepartmentEdit")Department department, ModelMap model) {
        try {
            if (departmentService.updateDepartment(department)) {
                model.addAttribute("message", "Department details are successfully Updated");
            } else {
            	model.addAttribute("message", "Department details are not updated");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } finally {
            return "department";
        }
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
    
    @RequestMapping(value ="/department_delete", method = RequestMethod.GET)
    public String deleteDepartment(@RequestParam("id")int departmentId, ModelMap model) {
    	try {
            if (departmentService.deleteDepartment(departmentId)) {
                model.addAttribute("message", "Department details are successfully Deleted");
            } else {
            	model.addAttribute("message", "Department details are not deleted");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } finally {
            return "department";
        }
    }
	
}