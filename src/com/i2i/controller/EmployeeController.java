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
import com.i2i.model.Employee;
import com.i2i.model.Role;
import com.i2i.service.DepartmentService;
import com.i2i.service.DesignationService;
import com.i2i.service.EmployeeService;
import com.i2i.service.RoleService;

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
	RoleService roleService = new RoleService();
	EmployeeService employeeService = new EmployeeService();
	
	/**
     * <p>
     * This method redirect to. index url
     * </p>
	 * @return
	 *    there is no data mapped in the url it just resolve the index view
	 */
	@RequestMapping("/index")
	public String indexPage() {
		return "index";
	}
	
	
	/**
	 * <p>
     * Mapping the request which required by user for department.html it will sent the page
     * and department list stored in database and model object to add new department
     * </p>
	 * 
	 * @param model
	 *     ModelMap object used for setting Department model object and Department List 
	 * @return
	 *     contains url of department add page
	 * 
	 */
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
    
    /**
	 * <p>
     * Mapping the request which required by user for department_edit.html it will sent the page
     * and required department object stored in database for edit.
     * </p>
	 * 
	 * @param model
	 *     ModelMap object used for setting Department model object. 
	 * @return
	 *     contains url of department edit page
	 * 
	 */
    @RequestMapping(value ="/department_edit", method = RequestMethod.GET)
	public String editDepartment(@RequestParam("id")int departmentId, ModelMap model) {
		try {
		 model.addAttribute("DepartmentEdit", departmentService.searchDepartment(departmentId));
		 
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
     *       model object that update the records in stored in database.
     * @param model
	 *     ModelMap object used for send message to the user.      
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
     * This method passes the department id as the parameter object into its Service class for delete the record.
     * </p>
     * 
     * @param departmentId
     *       contains Identity of department used for delete the record
     * @param model
	 *     ModelMap object used for send message to the user the message will be success or failure.    
     * @return String
     *       returns the redirecting page url based on the appropriate operation.
     */
    
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
    
    /**
	 * <p>
     * Mapping the request which required by user for designation.html it will sent the page
     * and designation list stored in database and model object to add new department
     * </p>
	 * 
	 * @param model
	 *     ModelMap object used for setting Designation model object, designation list and Department List 
	 * @return
	 *     contains url of designation add page
	 * 
	 */
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
     * This method passes the designation detail as the model object into its Service class.
     * </p>
     * 
     * @param departmentId
     *       contains identity of the Department it is used to many to one map with designation
     * @param designation
     *       model object that stores the designation data associated with model.
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
    
    /**
	 * <p>
     * Mapping the request which required by user for designation_edit.html it will sent the page
     * and required designation object stored in database for edit.
     * </p>
	 * 
	 * @param model
	 *     ModelMap object used for setting Designation model object and Department List 
	 * @return
	 *     contains url of department edit page
	 * 
	 */
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
     * This method passes the designation detail as the model object into its Service class.
     * </p>
     * 
     * @param designation
     *       model object that update the records in stored in database.
     * @param departmentId
     *       contains identity of the Department it is used to many to one map with designation
     * @param model
	 *     ModelMap object used for send message to the user.      
     * @return String
     *       returns the redirecting page url based on the appropriate operation.
     */
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
	    
	     /**
	     * <p>
	     * This method passes the designation id as the parameter object into its Service class for delete the record.
	     * </p>
	     * 
	     * @param designationid
	     *       contains Identity of designation used for delete the record
	     * @param model
		 *     ModelMap object used for send message to the user the message will be success or failure.    
	     * @return String
	     *       returns the redirecting page url based on the appropriate operation.
	     */
	    @RequestMapping(value ="/designation_delete", method = RequestMethod.GET)
	    public String deleteDesignation(@RequestParam("id")int designationId, ModelMap model) {
	    	try {
	            if (designationService.deleteDesignation(designationId)) {
	                model.addAttribute("message", "Designation details are successfully Deleted");
	            } else {
	            	model.addAttribute("message", "Designation details are not deleted");
	            }
	        } catch (DataException exception) {
	            model.addAttribute("message", exception.getMessage());
	        } finally {
	            return "designation";
	        }
	    }
	    
	    
/*------------------------------------------------------------------*/
	    @RequestMapping("/role")
		public String createRole(ModelMap model) {
			try {
			model.addAttribute("Role", new Role());
			model.addAttribute("RoleList", roleService.displayRoles());
			} catch (DataException e) {
				model.addAttribute("message", e.getMessage());
			}
			return "role";
		}
		
		
		@RequestMapping(value ="/role_edit", method = RequestMethod.GET)
		public String editRole(@RequestParam("id")int roleId, ModelMap model) {
			try {
				System.out.println("Edit");
			 model.addAttribute("RoleEdit", roleService.searchRole(roleId));		
			} catch (DataException e) {
				model.addAttribute("message", e.getMessage());
			}
			return "role";
		}
		
		/**
	     * <p>
	     * This method passes the role detail as the model object into its Service class.
	     * </p>
	     * 
	     * @param role
	     *       model object that stores the role data associated with model.
	     * @return String
	     *       returns the redirecting page url based on the appropriate operation.
	     */
	    @RequestMapping(value ="/role_update", method = RequestMethod.POST)
	    public String updateRole(@ModelAttribute("RoleEdit")Role role, ModelMap model) {
	        try {
	            if (roleService.updateRole(role)) {
	                model.addAttribute("message", "Role details are successfully Updated");
	            } else {
	            	model.addAttribute("message", "Role details are not updated");
	            }
	        } catch (DataException exception) {
	            model.addAttribute("message", exception.getMessage());
	        } finally {
	            return "role";
	        }
	    }
		
		
		/**
	     * <p>
	     * This method passes the role detail as the model object into its Service class.
	     * </p>
	     * 
	     * @param role
	     *       model object that stores the role data associated with model.
	     * @return String
	     *       returns the redirecting page url based on the appropriate operation.
	     */
	    @RequestMapping(value ="/role_insert", method = RequestMethod.POST)
	    public String insertRole(@ModelAttribute("Role")Role role, ModelMap model) {
	        try {
	            if (roleService.addRole(role)) {
	                model.addAttribute("message", "Role details are successfully inserted");
	            } else {
	            	model.addAttribute("message", "Role details are not inserted");
	            }
	        } catch (DataException exception) {
	            model.addAttribute("message", exception.getMessage());
	        } finally {
	            return "role";
	        }
	    }
	    
	    @RequestMapping(value ="/role_delete", method = RequestMethod.GET)
	    public String deleteRole(@RequestParam("id")int roleId, ModelMap model) {
	    	try {
	            if (roleService.deleteRole(roleId)) {
	                model.addAttribute("message", "Role details are successfully Deleted");
	            } else {
	            	model.addAttribute("message", "Role details are not deleted");
	            }
	        } catch (DataException exception) {
	            model.addAttribute("message", exception.getMessage());
	        } finally {
	            return "role";
	        }
	    }
/* ----------------------------------------------------------------------------------*/
	    
	    
	    
	    /*------------------------------------------------------------------*/
	    @RequestMapping("/employee")
		public String createEmployee(ModelMap model) {
			try {
			model.addAttribute("Employee", new Employee());
			model.addAttribute("EmployeeList", employeeService.retrieveEmployees());
			} catch (DataException e) {
				model.addAttribute("message", e.getMessage());
			}
			return "employee";
		}
		
		
		@RequestMapping(value ="/employee_edit", method = RequestMethod.GET)
		public String editEmployee(@RequestParam("id")int employeeId, ModelMap model) {
			try {
				System.out.println("Edit");
			 model.addAttribute("EmployeeEdit", employeeService.searchEmployee(employeeId));		
			} catch (DataException e) {
				model.addAttribute("message", e.getMessage());
			}
			return "employee";
		}
		
		/**
	     * <p>
	     * This method passes the employee detail as the model object into its Service class.
	     * </p>
	     * 
	     * @param employee
	     *       model object that stores the employee data associated with model.
	     * @return String
	     *       returns the redirecting page url based on the appropriate operation.
	     */
	    @RequestMapping(value ="/employee_update", method = RequestMethod.POST)
	    public String updateEmployee(@ModelAttribute("EmployeeEdit")Employee employee, ModelMap model) {
	        try {
	            if (employeeService.updateEmployee(employee)) {
	                model.addAttribute("message", "Employee details are successfully Updated");
	            } else {
	            	model.addAttribute("message", "Employee details are not updated");
	            }
	        } catch (DataException exception) {
	            model.addAttribute("message", exception.getMessage());
	        } finally {
	            return "employee";
	        }
	    }
		
		
		/**
	     * <p>
	     * This method passes the employee detail as the model object into its Service class.
	     * </p>
	     * 
	     * @param employee
	     *       model object that stores the employee data associated with model.
	     * @return String
	     *       returns the redirecting page url based on the appropriate operation.
	     */
	    @RequestMapping(value ="/employee_insert", method = RequestMethod.POST)
	    public String insertEmployee(@ModelAttribute("Employee")Employee employee, ModelMap model) {
	        try {
	            if (employeeService.addEmployee(employee)) {
	                model.addAttribute("message", "Employee details are successfully inserted");
	            } else {
	            	model.addAttribute("message", "Employee details are not inserted");
	            }
	        } catch (DataException exception) {
	            model.addAttribute("message", exception.getMessage());
	        } finally {
	            return "employee";
	        }
	    }
	    
	    @RequestMapping(value ="/employee_delete", method = RequestMethod.GET)
	    public String deleteEmployee(@RequestParam("id")int employeeId, ModelMap model) {
	    	try {
	            if (employeeService.deleteEmployee(employeeService.searchEmployee(employeeId))) {
	                model.addAttribute("message", "Employee details are successfully Deleted");
	            } else {
	            	model.addAttribute("message", "Employee details are not deleted");
	            }
	        } catch (DataException exception) {
	            model.addAttribute("message", exception.getMessage());
	        } finally {
	            return "employee";
	        }
	    }

}