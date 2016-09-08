package com.i2i.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.i2i.exception.DataException;
import com.i2i.model.Address;
import com.i2i.model.Certification;
import com.i2i.model.Department;
import com.i2i.model.Designation;
import com.i2i.model.Education;
import com.i2i.model.Employee;
import com.i2i.model.Role;
import com.i2i.service.AddressService;
import com.i2i.service.CertificationService;
import com.i2i.service.DepartmentService;
import com.i2i.service.DesignationService;
import com.i2i.service.EducationService;
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
	AddressService addressService = new AddressService();
	EmployeeService employeeService = new EmployeeService();
	CertificationService certficationService = new CertificationService();
	EducationService educationService = new EducationService();
	
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
		Department department =  new Department();
		model.addAttribute("Department", department);		
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
    public String insertDesignation(@ModelAttribute("Designation")Designation designation, BindingResult result,  ModelMap model) {   
       try {        	
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
	 *     contains url of designation edit page
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
	    
	    /**
		 * <p>
	     * Mapping the request which required by user for role.html it will sent the page
	     * and role list stored in database and model object to add new role
	     * </p>
		 * 
		 * @param model
		 *     ModelMap object used for setting Role model object, role list 
		 * @return
		 *     contains url of designation add page
		 * 
		 */
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
		
	    /**
		 * <p>
	     * Mapping the request which required by user for role_edit.html it will sent the page
	     * and required designation object stored in database for edit.
	     * </p>
		 * 
		 * @param model
		 *     ModelMap object used for setting Role model object  
		 * @return
		 *     contains url of role edit page
		 * 
		 */
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
	     * This method passes the role id as the parameter object into its Service class for delete the record.
	     * </p>
	     * 
	     * @param roleId
	     *       contains Identity of role used for delete the record
	     * @param model
		 *     ModelMap object used for send message to the user the message will be success or failure.    
	     * @return String
	     *       returns the redirecting page url based on the appropriate operation.
	     */
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
		 
	    
	    @RequestMapping(value ="/employee", method = RequestMethod.GET)
	    public String employee(ModelMap map) {
	    	try{
	    		map.addAttribute("EmployeeList", employeeService.retrieveEmployees());	
	    	} catch (DataException exception) {
	    		map.addAttribute("message", exception.getMessage());
	    	}
	    	return "employee";
	    }
	    
	    
	    @RequestMapping(value ="/employee_view", method = RequestMethod.GET)
	    public String employeeView(ModelMap map, @RequestParam("id") int employeeId) {
	    	try{	    	
	    		map.addAttribute("Employee", employeeService.searchEmployee(employeeId));	
	    		map.addAttribute("AddressList", addressService.getAddressByEmployee(employeeId));
	    		if(educationService.getEducationByEmployee(employeeId)!=null){
	    		map.addAttribute("EducationList", educationService.getEducationByEmployee(employeeId));
	    		}
	    		if(certficationService.getCertificationByEmployee(employeeId)!=null){
	    		map.addAttribute("CertificationList", certficationService.getCertificationByEmployee(employeeId));
	    		}
	    	} catch (DataException exception) {
	    		System.out.println(exception);
	    		map.addAttribute("message", exception.getMessage());
	    	}
	    	return "employeeView";
	    }
	    
	    
	    @RequestMapping(value ="/employee_delete", method = RequestMethod.GET)
	    public String deleteEmployee(@RequestParam("id")int employeeId, ModelMap model) {
	    	try {
	            if (employeeService.deleteEmployee(employeeId)) {
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
	    
	    @RequestMapping(value ="/certification", method = RequestMethod.GET)
	    public String crtification() {
	    	 return "certification";
	        
	    }
	    
	    @RequestMapping(value ="/education", method = RequestMethod.GET)
	    public String education() {
	    	 return "education";
	        
	    }
	    
	    @RequestMapping(value ="/picture", method = RequestMethod.GET)
	    public String picture(@RequestParam("eid") int employeeId, ModelMap map) {
	    	 map.addAttribute("EmployeeId", employeeId);
	    	 return "picture";
	        
	    }
	    
	    @RequestMapping(value ="/address_form", method = RequestMethod.GET)
	    public String address_form(@RequestParam("same") String same, @RequestParam("address") String address,@RequestParam("countries") String countries, @RequestParam("states") String states, @RequestParam("cities") String cities, @RequestParam("pincode") String pincode, @RequestParam("email") String email, @RequestParam("mobile") String mobile , ModelMap map) {
	    	map.addAttribute("same", same);
	    	map.addAttribute("address", address);
	        map.addAttribute("countries", countries);
	        map.addAttribute("states", states);
	        map.addAttribute("cities",cities);
	        map.addAttribute("pincode", pincode);
	        map.addAttribute("mobile", mobile);
	        map.addAttribute("email", email);	        
	    	return "address_form";
	        
	    }
	    
	    @RequestMapping(value ="/personal", method = RequestMethod.GET)
	    public String personal(ModelMap map) {
	    	try {
	    	map.addAttribute("Employee", new Employee());
	    	map.addAttribute("DepartmentList", departmentService.displayDepartments());
	    	map.addAttribute("RoleList", roleService.displayRoles());
	    	}
	    	catch (Exception e) {

			}
	    	return "personal";	        
	    }
	    
	    @RequestMapping(value ="/designationView", method = RequestMethod.GET)
	    public String designationView(@RequestParam("departmentId") int departmentId, ModelMap map) {
	    	try {
	    	map.addAttribute("DesignationList", designationService.getDesgignationByDepartment(departmentId));
	    	} catch (Exception e) {
			
			}
	    	return "designationView";
	        
	    }
	    
	    @RequestMapping(value ="/employee_add", method = RequestMethod.POST)
	    public String addEmployee(@ModelAttribute("Employee")Employee employee, BindingResult result,  ModelMap model) {
	        try {
	        	if (employeeService.addEmployee(employee)) {
	        		employee.add(new Address());
	    			employee.add(new Address());  
	    			model.addAttribute("Employee", employee);	
	            } else {
	            	model.addAttribute("message", "Employee details are not inserted");
	            }
	        } catch (DataException exception) {
	            model.addAttribute("message", exception.getMessage());
	        } finally {
	            return "address";
	        }
	    }
	    
	    @RequestMapping(value ="/address_add", method = RequestMethod.POST)
	    public String addAddress(@ModelAttribute("Employee") Employee employee, BindingResult result, ModelMap map) {
	    	Employee employee1 =null;
	    	try {
	    		
	    		for (Address address : employee.getAddresses()) {
	 		    	addressService.addAddress(address);
	 		    	employee1 = address.getEmployee();
	 		     }	
	    		 map.addAttribute("EmployeeId", employee1.getEmployeeId());
	    	} catch (Exception e) {
			
			}
	    	return "education";
	    }
	    
	    @RequestMapping(value ="/certification_insert", method = RequestMethod.POST)
	    public String addCertification(@ModelAttribute("Employee") Employee employee, BindingResult result, ModelMap map) {
	    	Employee employee1 =null;
	    	try {
	    		 for (Certification certificate : employee.getCertification()) {
	    			 certficationService.addCertification(certificate);
	    			 employee1 = certificate.getEmployee();
	 		     }
	    		 map.addAttribute("EmployeeId", employee1.getEmployeeId());
	    	} catch (Exception e) {
			
			}
	    	return "picture";
	    }

	    @RequestMapping(value ="/certification_form", method = RequestMethod.GET)
	    public String crtification_form(@RequestParam("noof") int noof, @RequestParam("eid") int employeeId, ModelMap map) {
	    	try {
	    		
	    		Employee employee = employeeService.searchEmployee(employeeId);	    		
	    		for(int i=1;i<=noof;i++){
	    			employee.addCertification(new Certification());
	    		}	    			    		
	    	    map.addAttribute("Employee", employee);
	    	} catch (Exception e) {
				
			}
	    	return "certification_form";
	    }
	    
	    @RequestMapping(value ="/education_form", method = RequestMethod.GET)
	    public String education_form(@RequestParam("noof") int noof, @RequestParam("eid") int employeeId, ModelMap map) {
	    	try {
	    		Employee employee = employeeService.searchEmployee(employeeId);	    		
	    		for(int i=1;i<=noof;i++){
	    			employee.addEducation(new Education());
	    		}	    			    		
	    	    map.addAttribute("Employee", employee);
	    	    System.out.println("First Name :" +employee.getEmployeeFirstName());
	    	} catch (Exception e) {
				System.out.println(e);
			}
	    	return "education_form";
	    }
	    
	    
	    @RequestMapping(value ="/education_insert", method = RequestMethod.POST)
	    public String addEducation(@ModelAttribute("Employee") Employee employee, BindingResult result, ModelMap map) {
	    	Employee employee1 =null;
	    	try {	    		 
	    		 for (Education education : employee.getEducation()) {
	    			 educationService.addEducation(education);
	    			 employee1 = education.getEmployee();
	 		     }
	    		 map.addAttribute("EmployeeId", employee1.getEmployeeId());
	    		 System.out.println("EmployeeId :" + employee1.getEmployeeId());
	    		 
	    	} catch (Exception e) {
			   System.out.println(e);
			}
	    	return "certification";
	    }
	    
	    
	    @RequestMapping(value ="/picture_add", method = RequestMethod.POST)
	    public String addPicture(@RequestParam("employeePicture")MultipartFile profile, @RequestParam("employeeId")int employeeId, ModelMap map) {
	    	 InputStream inputStream = null;
	    	 OutputStream outputStream = null;
             
	    	try {
	    		Employee employee = employeeService.searchEmployee(employeeId);
	    		
	    		String fileName = profile.getOriginalFilename();
	    		employee.setEmployeePicture(fileName);
	    		 inputStream = profile.getInputStream();
	    		  File newFile = new File("/home/user/workspace/HRMS/WebContent/resources/upload/" + fileName);
	    		   if (!newFile.exists()) {
	    		    newFile.createNewFile();
	    		   }
	    		   outputStream = new FileOutputStream(newFile);
	    		   int read = 0;
	    		   byte[] bytes = new byte[1024];
	    		   while ((read = inputStream.read(bytes)) != -1) {
	    		    outputStream.write(bytes, 0, read);
	    		   }
	    		   employeeService.updateEmployee(employee);
	    		   map.addAttribute("message", "Employee details are inserted Successfully");
	    	} catch (Exception e) {
			    System.out.println(e);
			}
	    	return "personal";
	    }	 
	    
	    
	    
	    @RequestMapping(value ="/picture_update", method = RequestMethod.POST)
	    public String updatePicture(@RequestParam("employeePicture")MultipartFile profile, @RequestParam("employeeId")int employeeId, ModelMap map) {
	    	 InputStream inputStream = null;
	    	 OutputStream outputStream = null;
             
	    	try {
	    		Employee employee = employeeService.searchEmployee(employeeId);
	    		
	    		String fileName = profile.getOriginalFilename();
	    		employee.setEmployeePicture(fileName);
	    		 inputStream = profile.getInputStream();
	    		  File newFile = new File("/home/user/workspace/HRMS/WebContent/resources/upload/" + fileName);
	    		   if (!newFile.exists()) {
	    		    newFile.createNewFile();
	    		   }
	    		   outputStream = new FileOutputStream(newFile);
	    		   int read = 0;
	    		   byte[] bytes = new byte[1024];
	    		   while ((read = inputStream.read(bytes)) != -1) {
	    		    outputStream.write(bytes, 0, read);
	    		   }
	    		   employeeService.updateEmployee(employee);
	    		   map.addAttribute("message", "Picture updated Successfully");
	    		   map.addAttribute("EmployeeId", employeeId);
	    	} catch (Exception e) {
			    System.out.println(e);
			}
	    	return "employeeView";
	    }	 
	    
	    
	    
	    @RequestMapping(value ="/picture_edit", method = RequestMethod.GET)
		public String editPicture(@RequestParam("id")int employeeId, ModelMap model) {
			try {
			 model.addAttribute("PictureEdit", employeeService.searchEmployee(employeeId));		
			} catch (DataException e) {
				model.addAttribute("message", e.getMessage());
			}
			return "employeeView";
		}
	    
	    
	    @RequestMapping(value ="/address_edit", method = RequestMethod.GET)
		public String editaddress(@RequestParam("id")int addressId, ModelMap model) {
			try {
			  model.addAttribute("AddressEdit",addressService.searchAddress(addressId));		
			} catch (DataException e) {
				model.addAttribute("message", e.getMessage());
			}
			return "employeeView";
		}
	    
	    
	    @RequestMapping(value ="/education_edit", method = RequestMethod.GET)
		public String editEducation(@RequestParam("id")int educationId, ModelMap model) {
			try {
			  model.addAttribute("EducationEdit",educationService.searchEducation(educationId));		
			} catch (DataException e) {
				model.addAttribute("message", e.getMessage());
			}
			return "employeeView";
		}
	    
	    @RequestMapping(value ="/education_update", method = RequestMethod.POST)
 		public String updateEducation(@ModelAttribute("EducationEdit") Education education, BindingResult result , ModelMap model) {
    	try {
			 educationService.updateEducation(education);
			 Employee employee = education.getEmployee();
			 model.addAttribute("message", "Education details updated Successfully");
				model.addAttribute("EmployeeId", employee.getEmployeeId());	
			} catch (DataException e) {
				model.addAttribute("message", e.getMessage());
			}
			return "employeeView";
 		}
	    @RequestMapping(value ="/certification_edit", method = RequestMethod.GET)
		public String editCertification(@RequestParam("id")int certificationId, ModelMap model) {
			try {
			  model.addAttribute("CertificateEdit", certficationService.searchCertification(certificationId));		
			} catch (DataException e) {
				model.addAttribute("message", e.getMessage());
			}
			return "employeeView";
		}
	    
	    @RequestMapping(value ="/certification_update", method = RequestMethod.POST)
 		public String updateCertification(@ModelAttribute("CertificateEdit") Certification certification, BindingResult result , ModelMap model) {
    	try {
            certficationService.updateCertification(certification);
    		Employee employee = certification.getEmployee();
			 model.addAttribute("message", "Certification details updated Successfully");
				model.addAttribute("EmployeeId", employee.getEmployeeId());	
			} catch (DataException e) {
				model.addAttribute("message", e.getMessage());
			}
			return "employeeView";
 		}
    
	    
	    @RequestMapping(value ="/address_update", method = RequestMethod.POST)
	 		public String updateaddress(@ModelAttribute("AddressEdit") Address address, BindingResult result , ModelMap model) {
	    	try {
				 addressService.updateAddress(address);
				 Employee employee = address.getEmployee();
				 model.addAttribute("message", "Address details updated Successfully");
					model.addAttribute("EmployeeId", employee.getEmployeeId());	
				} catch (DataException e) {
					model.addAttribute("message", e.getMessage());
				}
				return "employeeView";
	 		}
	 	    
	    
	    
	    @RequestMapping(value ="/personal_edit", method = RequestMethod.GET)
		public String editPersonal(@RequestParam("id")int employeeId, ModelMap model) {
			try {
			 model.addAttribute("PersonalEdit", employeeService.searchEmployee(employeeId));
			 model.addAttribute("DepartmentList", departmentService.displayDepartments());
			 model.addAttribute("RoleList", roleService.displayRoles());
			} catch (DataException e) {
				model.addAttribute("message", e.getMessage());
			}
			return "employeeView";
		}
	    
	    
	    @RequestMapping(value ="/personal_update", method = RequestMethod.POST)
		public String updatePersonal(@ModelAttribute("PersonalEdit") Employee employee, BindingResult result, ModelMap model) {
			try {
				employeeService.updateEmployee(employee);
				model.addAttribute("message", "Personal details updated Successfully");
				model.addAttribute("EmployeeId", employee.getEmployeeId());			 			 
			} catch (DataException e) {
				model.addAttribute("message", e.getMessage());
			}
			return "employeeView";
		}
		
}