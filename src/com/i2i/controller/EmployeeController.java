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
import com.i2i.model.AllowanceVariant;
import com.i2i.model.Certification;
import com.i2i.model.Department;
import com.i2i.model.Designation;
import com.i2i.model.Education;
import com.i2i.model.Employee;
import com.i2i.model.Role;
import com.i2i.service.AddressService;
import com.i2i.service.AllowanceVariantService;
import com.i2i.service.CertificationService;
import com.i2i.service.DepartmentService;
import com.i2i.service.DesignationService;
import com.i2i.service.EducationService;
import com.i2i.service.EmployeeService;
import com.i2i.service.RoleService;

/**
 * <p>
 * Controller which gets parameters from the user inputs and displays message to
 * the user, based on the status of the manipulation of employee records.
 * Displays error message when exception occurs during the manipulation process.
 * </p>
 *
 * @author Praveenkumar and Praveen RaJ
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
    AllowanceVariantService allowanceVariantService = new AllowanceVariantService();

    

    /**
     * <p>
     * Mapping the request which required by user for department.html it will
     * sent the page and department list stored in database and model object to
     * add new department
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting Department model object and
     *            Department List
     * @return contains url of department add page
     * 
     */
    @RequestMapping("/department")
    public String createDepartment(ModelMap model) {
        try {
            Department department = new Department();
            model.addAttribute("Department", department);
            model.addAttribute("DepartmentList", departmentService.getDepartments());
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "department";
    }

    /**
     * <p>
     * This method passes the department detail as the model object into its
     * Service class.
     * </p>
     * 
     * @param department
     *            model object that stores the department data associated with
     *            model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/department_insert", method = RequestMethod.POST)
    public String insertDepartment(@ModelAttribute("Department") Department department, ModelMap model) {
        try {
            if (departmentService.addDepartment(department)) {
                model.addAttribute("message", "New Department Successfully Added");
            } else {
                model.addAttribute("message", "New Department not Added");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } 
        return "department";
    }

    /**
     * <p>
     * Mapping the request which required by user for department_edit.html it
     * will sent the page and required department object stored in database for
     * edit.
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting Department model object.
     * @return contains url of department edit page
     * 
     */
    @RequestMapping(value = "/department_edit", method = RequestMethod.GET)
    public String editDepartment(@RequestParam("id") int departmentId, ModelMap model) {
        try {
            model.addAttribute("DepartmentEdit", departmentService.searchDepartment(departmentId));

        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "department";
    }

    /**
     * <p>
     * This method passes the department detail as the model object into its
     * Service class.
     * </p>
     * 
     * @param department
     *            model object that update the records in stored in database.
     * @param model
     *            ModelMap object used for send message to the user.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/department_update", method = RequestMethod.POST)
    public String updateDepartment(@ModelAttribute("DepartmentEdit") Department department, ModelMap model) {
        try {
            if (departmentService.updateDepartment(department)) {
                model.addAttribute("message", "Department details are successfully Updated");
            } else {
                model.addAttribute("message", "Department details are not updated");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } 
        return "department";
    }

    /**
     * <p>
     * This method passes the department id as the parameter object into its
     * Service class for delete the record.
     * </p>
     * 
     * @param departmentId
     *            contains Identity of department used for delete the record
     * @param model
     *            ModelMap object used for send message to the user the message
     *            will be success or failure.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */

    @RequestMapping(value = "/department_delete", method = RequestMethod.GET)
    public String deleteDepartment(@RequestParam("id") int departmentId, ModelMap model) {
        try {
            if (departmentService.deleteDepartment(departmentId)) {
                model.addAttribute("message", "Department successfully Deleted");
            } else {
                model.addAttribute("message", "Department not deleted");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } 
        return "department";
    }

    /**
     * <p>
     * Mapping the request which required by user for designation.html it will
     * sent the page and designation list stored in database and model object to
     * add new department
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting Designation model object,
     *            designation list and Department List
     * @return contains url of designation add page
     * 
     */
    @RequestMapping("/designation")
    public String createDesignation(ModelMap model) {
        try {
            model.addAttribute("Designation", new Designation());
            model.addAttribute("DesignationList", designationService.getDesignations());
            model.addAttribute("DepartmentList", departmentService.getDepartments());
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "designation";
    }

    /**
     * <p>
     * This method passes the designation detail as the model object into its
     * Service class.
     * </p>
     * 
     * @param departmentId
     *            contains identity of the Department it is used to many to one
     *            map with designation
     * @param designation
     *            model object that stores the designation data associated with
     *            model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/designation_insert", method = RequestMethod.POST)
    public String insertDesignation(@ModelAttribute("Designation") Designation designation, BindingResult result,
            ModelMap model) {
        try {
            if (designationService.addDesignation(designation)) {
                AllowanceVariant allowanceVariant = new AllowanceVariant();
                allowanceVariant.setDesignation(designation);
                allowanceVariantService.addAllowanceVariant(allowanceVariant);
                model.addAttribute("message", "Designation Successfully Added");
            } else {
                model.addAttribute("message", "Designation not Added");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } 
        return "designation";
    }

    /**
     * <p>
     * This method passes is used for AJAX to get the designation list for the
     * given department
     * </p>
     * 
     * @param departmentId
     *            contains identity of the Department it is used to many to one
     *            map with designation
     * @param designationList
     *            model object that stores the designation List data associated
     *            with model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/designationView", method = RequestMethod.GET)
    public String retriveDesignation(@RequestParam("departmentId") int departmentId, ModelMap map) {
        try {
            map.addAttribute("DesignationList", designationService.getDesgignationByDepartment(departmentId));
        } catch (DataException exception)  {
            map.addAttribute("message", exception.getMessage());
        }
        return "designationView";

    }
    
    
    /**
     * <p>
     * This method passes is used for AJAX to get the employee list for the
     * given designation
     * </p>
     * 
     * @param designationId
     *            contains identity of the designation it is used to many to one
     *            map with employee
     * @param designationList
     *            model object that stores the employee List data associated
     *            with model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/employeesView", method = RequestMethod.GET)
    public String retriveEmployeeByDesignation(@RequestParam("designationId") int designationId, ModelMap map) {
        try {
            map.addAttribute("EmployeeList", employeeService.getEmployeeByDesignation(designationId));
        } catch (DataException exception)  {
            map.addAttribute("message", exception.getMessage());
        }
        return "employeesView";
    }

    /**
     * <p>
     * Mapping the request which required by user for designation_edit.html it
     * will sent the page and required designation object stored in database for
     * edit.
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting Designation model object and
     *            Department List
     * @return contains url of designation edit page
     * 
     */
    @RequestMapping(value = "/designation_edit", method = RequestMethod.GET)
    public String editDesignation(@RequestParam("id") int designationId, ModelMap model) {
        try {
            model.addAttribute("DesignationEdit", designationService.searchDesignation(designationId));
            model.addAttribute("DepartmentList", departmentService.getDepartments());
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "designation";
    }

    /**
     * <p>
     * This method passes the designation detail as the model object into its
     * Service class.
     * </p>
     * 
     * @param designation
     *            model object that update the records in stored in database.
     * @param departmentId
     *            contains identity of the Department it is used to many to one
     *            map with designation
     * @param model
     *            ModelMap object used for send message to the user.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/designation_update", method = RequestMethod.POST)
    public String updateDepartment(@ModelAttribute("DesignationEdit") Designation designation, BindingResult result,
            @RequestParam("department") int departmentId, ModelMap model) {
        try {
            designation.setDepartment(departmentService.searchDepartment(departmentId));
            if (designationService.updateDesignation(designation)) {
                model.addAttribute("message", "Designation details are successfully Updated");
            } else {
                model.addAttribute("message", "Designation details are not updated");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } 
        return "designation";
    }

    /**
     * <p>
     * This method passes the designation id as the parameter object into its
     * Service class for delete the record.
     * </p>
     * 
     * @param designationid
     *            contains Identity of designation used for delete the record
     * @param model
     *            ModelMap object used for send message to the user the message
     *            will be success or failure.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/designation_delete", method = RequestMethod.GET)
    public String deleteDesignation(@RequestParam("id") int designationId, ModelMap model) {
        try {
            if (designationService.deleteDesignation(designationId)) {
                model.addAttribute("message", "Designation successfully Deleted");
            } else {
                model.addAttribute("message", "Designation not deleted");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } 
        return "designation";
        
    }

    /**
     * <p>
     * Mapping the request which required by user for role.html it will sent the
     * page and role list stored in database and model object to add new role
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting Role model object, role list
     * @return contains url of designation add page
     * 
     */
    @RequestMapping("/role")
    public String createRole(ModelMap model) {
        try {
            model.addAttribute("Role", new Role());
            model.addAttribute("RoleList", roleService.getRoles());
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "role";
    }

    /**
     * <p>
     * This method passes the role detail as the model object into its Service
     * class.
     * </p>
     * 
     * @param role
     *            model object that stores the role data associated with model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/role_insert", method = RequestMethod.POST)
    public String insertRole(@ModelAttribute("Role") Role role, ModelMap model) {
        try {
            if (roleService.addRole(role)) {
                model.addAttribute("message", "New Role successfully Added");
            } else {
                model.addAttribute("message", "Role not Added");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } 
        return "role";        
    }

    /**
     * <p>
     * Mapping the request which required by user for role_edit.html it will
     * sent the page and required role object stored in database for edit.
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting Role model object
     * @return contains url of role edit page
     * 
     */
    @RequestMapping(value = "/role_edit", method = RequestMethod.GET)
    public String editRole(@RequestParam("id") int roleId, ModelMap model) {
        try {
            model.addAttribute("RoleEdit", roleService.searchRole(roleId));
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "role";
    }

    /**
     * <p>
     * This method passes the role detail as the model object into its Service
     * class.
     * </p>
     * 
     * @param role
     *            model object that stores the role data associated with model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/role_update", method = RequestMethod.POST)
    public String updateRole(@ModelAttribute("RoleEdit") Role role, ModelMap model) {
        try {
            if (roleService.updateRole(role)) {
                model.addAttribute("message", "Role details are successfully Updated");
            } else {
                model.addAttribute("message", "Role details are not updated");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } 
        return "role";        
    }

    /**
     * <p>
     * This method passes the role id as the parameter object into its Service
     * class for delete the record.
     * </p>
     * 
     * @param roleId
     *            contains Identity of role used for delete the record
     * @param model
     *            ModelMap object used for send message to the user the message
     *            will be success or failure.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/role_delete", method = RequestMethod.GET)
    public String deleteRole(@RequestParam("id") int roleId, ModelMap model) {
        try {
            if (roleService.deleteRole(roleId)) {
                model.addAttribute("message", "Role successfully Deleted");
            } else {
                model.addAttribute("message", "Role not deleted");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } 
        return "role";
    }

    /**
     * <p>
     * Mapping the request which required by user for employee.html it will sent
     * the page and employee list stored in database and model object to add new
     * department
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting Employee List
     * @return contains url of employee page
     * 
     */
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String retiveAllEmployee(ModelMap map) {
        try {
            map.addAttribute("EmployeeList", employeeService.retrieveEmployees());
        } catch (DataException exception) {
            map.addAttribute("message", exception.getMessage());
        }
        return "employee";
    }

    /**
     * <p>
     * Mapping the request which required by user for employee_view.html it will
     * sent the page and employee object, address List, education list,
     * certification list for a employee stored in database.
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting Employee, AddressList,
     *            EducationList, CertificationList
     * @return contains url of employee_view page
     * 
     */
    @RequestMapping(value = "/employee_view", method = RequestMethod.GET)
    public String retriveEmployeeById(ModelMap map, @RequestParam("id") int employeeId) {
        try {
            map.addAttribute("Employee", employeeService.searchEmployee(employeeId));
            map.addAttribute("AddressList", addressService.getAddressByEmployee(employeeId));
            if (educationService.getEducationByEmployee(employeeId) != null) {
                map.addAttribute("EducationList", educationService.getEducationByEmployee(employeeId));
            }
            if (certficationService.getCertificationByEmployee(employeeId) != null) {
                map.addAttribute("CertificationList", certficationService.getCertificationByEmployee(employeeId));
            }
        } catch (DataException exception) {
            map.addAttribute("message", exception.getMessage());
        }
        return "employeeView";
    }

    /**
     * <p>
     * This method passes the employee id as the parameter object into its
     * Service class for delete the record.
     * </p>
     * 
     * @param roleId
     *            contains Identity of employee used for delete the record
     * @param model
     *            ModelMap object used for send message to the employee the
     *            message will be success or failure.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/employee_delete", method = RequestMethod.GET)
    public String deleteEmployee(@RequestParam("id") int employeeId, ModelMap model) {
        try {
            if (employeeService.deleteEmployee(employeeId)) {
                model.addAttribute("message", "Employee successfully Deleted");
            } else {
                model.addAttribute("message", "Employee are not deleted");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } 
        return "employee";
    }

    /**
     * <p>
     * Mapping the request which required by user for personal.html it will sent
     * the page
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting Employee obeject to insert
     *            personal details, Department List and Role List
     * @return contains url of personal page
     * 
     */
    @RequestMapping(value = "/personal", method = RequestMethod.GET)
    public String createPersonalDetails(ModelMap map) {
        try {
            map.addAttribute("Employee", new Employee());
            map.addAttribute("DepartmentList", departmentService.getDepartments());
            map.addAttribute("RoleList", roleService.getRoles());
        } catch (DataException exception)  {
            map.addAttribute("message", exception.getMessage());
        }
        return "personal";
    }

    /**
     * <p>
     * This method passes the employee personal details as the model object into
     * its Service class. and also create two new address object for New
     * Address.
     * </p>
     * 
     * @param role
     *            model object that stores the employee personal data associated
     *            with model.
     * 
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/employee_add", method = RequestMethod.POST)
    public String addPersonalDetails(@ModelAttribute("Employee") Employee employee, BindingResult result, ModelMap model) {
        try {
            if (employeeService.addEmployee(employee)) {
                employee.add(new Address());
                employee.add(new Address());
                model.addAttribute("Employee", employee);
            } else {
                model.addAttribute("message", "Personal details are not Added");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } 
        return "address";        
    }

    /**
     * <p>
     * Mapping the request which required by user for employeeView.html it will
     * sent the page and required employee object stored in database for edit.
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting Employee model object
     * @return contains url of employee edit page
     * 
     */
    @RequestMapping(value = "/personal_edit", method = RequestMethod.GET)
    public String editPersonalDetails(@RequestParam("id") int employeeId, ModelMap model) {
        try {
            model.addAttribute("PersonalEdit", employeeService.searchEmployee(employeeId));
            model.addAttribute("DepartmentList", departmentService.getDepartments());
            model.addAttribute("RoleList", roleService.getRoles());
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "employeeView";
    }

    /**
     * <p>
     * This method passes the employee detail as the model object into its
     * Service class.
     * </p>
     * 
     * @param employee
     *            model object that modify the employee personal data associated
     *            with model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/personal_update", method = RequestMethod.POST)
    public String updatePersonalDetails(@ModelAttribute("PersonalEdit") Employee employee, BindingResult result,
            ModelMap model) {
        try {
            employeeService.updateEmployee(employee);
            model.addAttribute("message", "Personal details updated Successfully");
            model.addAttribute("EmployeeId", employee.getEmployeeId());
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "employeeView";
    }

    /**
     * <p>
     * This method passes is used for AJAX to set the same address in permanent
     * address
     * </p>
     * 
     * @param same
     *            if same address want or not
     * @param address
     *            contains street address
     * @param countries
     *            contains country name
     * @param state
     *            contains state name
     * @param city
     *            contains city name
     * @param pincode
     *            contains pincode value
     * @param email
     *            contains email address name
     * @param model
     *            used to set all above param in attribute
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/address_form", method = RequestMethod.GET)
    public String checkSameAsResidentialAddress(@RequestParam("same") String same, @RequestParam("address") String address,
            @RequestParam("countries") String countries, @RequestParam("states") String states,
            @RequestParam("cities") String cities, @RequestParam("pincode") String pincode,
            @RequestParam("email") String email, @RequestParam("mobile") String mobile, ModelMap map) {
        map.addAttribute("same", same);
        map.addAttribute("address", address);
        map.addAttribute("countries", countries);
        map.addAttribute("states", states);
        map.addAttribute("cities", cities);
        map.addAttribute("pincode", pincode);
        map.addAttribute("mobile", mobile);
        map.addAttribute("email", email);
        return "address_form";
    }

    /**
     * <p>
     * This method passes the employee Address details as the model object into
     * its Service class.
     * </p>
     * 
     * @param role
     *            model object that stores the employee address data associated
     *            with model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/address_add", method = RequestMethod.POST)
    public String addAddress(@ModelAttribute("Employee") Employee employee, BindingResult result, ModelMap map) {
        Employee employee1 = null;
        try {
            for (Address address : employee.getAddresses()) {
                addressService.addAddress(address);
                employee1 = address.getEmployee();
            }
            map.addAttribute("EmployeeId", employee1.getEmployeeId());
        } catch (DataException exception)  {
            map.addAttribute("message", exception.getMessage());
        }
        return "education";
    }

    /**
     * <p>
     * Mapping the request which required by user for employeeView.html it will
     * sent the page and required address object stored in database for edit.
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting Address model object
     * @return contains url of employee address edit page
     * 
     */
    @RequestMapping(value = "/address_edit", method = RequestMethod.GET)
    public String editAddress(@RequestParam("id") int addressId, ModelMap model) {
        try {
            model.addAttribute("AddressEdit", addressService.searchAddress(addressId));
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "employeeView";
    }

    /**
     * <p>
     * This method passes the employee address detail as the model object into
     * its Service class.
     * </p>
     * 
     * @param employee
     *            model object that modify the employee address data associated
     *            with model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/address_update", method = RequestMethod.POST)
    public String updateAddress(@ModelAttribute("AddressEdit") Address address, BindingResult result, ModelMap model) {
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

    /**
     * <p>
     * This method passes is used for AJAX to set the no of certification model
     * object
     * </p>
     * 
     * @param noof
     *            contains no of object want to create
     * @param eid
     *            contains identity of the employee
     * @param map
     *            used to set no of object
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/certification_form", method = RequestMethod.GET)
    public String crtification_form(@RequestParam("noof") int noof, @RequestParam("eid") int employeeId, ModelMap map) {
        try {
            Employee employee = employeeService.searchEmployee(employeeId);
            for (int i = 1; i <= noof; i++) {
                employee.addCertification(new Certification());
            }
            map.addAttribute("Employee", employee);
        } catch (DataException exception)  {
            map.addAttribute("message", exception.getMessage());
        }
        return "certification_form";
    }

    /**
     * <p>
     * This method passes the employee certification details as the model object
     * into its Service class.
     * </p>
     * 
     * @param role
     *            model object that stores the employee certification data
     *            associated with model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/certification_insert", method = RequestMethod.POST)
    public String addCertification(@ModelAttribute("Employee") Employee employee, BindingResult result, ModelMap map) {
        Employee employee1 = null;
        try {
            for (Certification certificate : employee.getCertification()) {
                certficationService.addCertification(certificate);
                employee1 = certificate.getEmployee();
            }
            map.addAttribute("EmployeeId", employee1.getEmployeeId());
        } catch (DataException exception)  {
            map.addAttribute("message", exception.getMessage());
        }
        return "picture";
    }

    /**
     * <p>
     * Mapping the request which required by user for employeeView.html it will
     * sent the page and required certification object stored in database for
     * edit.
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting certification model object
     * @return contains url of employee certification edit page
     * 
     */
    @RequestMapping(value = "/certification_edit", method = RequestMethod.GET)
    public String editCertification(@RequestParam("id") int certificationId, ModelMap model) {
        try {
            model.addAttribute("CertificateEdit", certficationService.searchCertification(certificationId));
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "employeeView";
    }

    /**
     * <p>
     * This method passes the employee certification detail as the model object
     * into its Service class.
     * </p>
     * 
     * @param employee
     *            model object that modify the employee certification data
     *            associated with model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/certification_update", method = RequestMethod.POST)
    public String updateCertification(@ModelAttribute("CertificateEdit") Certification certification,
            BindingResult result, ModelMap model) {
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

    /**
     * <p>
     * This method passes is used for AJAX to set the no of Education model
     * object
     * </p>
     * 
     * @param noof
     *            contains no of object want to create
     * @param eid
     *            contains identity of the employee
     * @param map
     *            used to set no of object
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/education_form", method = RequestMethod.GET)
    public String createEducation(@RequestParam("noof") int noof, @RequestParam("eid") int employeeId, ModelMap map) {
        try {
            Employee employee = employeeService.searchEmployee(employeeId);
            for (int i = 1; i <= noof; i++) {
                employee.addEducation(new Education());
            }
            map.addAttribute("Employee", employee);
        } catch (Exception e) {
            map.addAttribute("message", e.getMessage());
        }
        return "education_form";
    }

    /**
     * <p>
     * This method passes the employee education details as the model object
     * into its Service class.
     * </p>
     * 
     * @param role
     *            model object that stores the employee education data
     *            associated with model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/education_insert", method = RequestMethod.POST)
    public String addEducation(@ModelAttribute("Employee") Employee employee, BindingResult result, ModelMap map) {
        Employee employee1 = null;
        try {
            for (Education education : employee.getEducation()) {
                educationService.addEducation(education);
                employee1 = education.getEmployee();
            }
            map.addAttribute("EmployeeId", employee1.getEmployeeId());
        } catch (Exception e) {
            map.addAttribute("message", e.getMessage());
        }
        return "certification";
    }

    /**
     * <p>
     * Mapping the request which required by user for employeeView.html it will
     * sent the page and required education object stored in database for edit.
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting education model object
     * @return contains url of employee education edit page
     * 
     */
    @RequestMapping(value = "/education_edit", method = RequestMethod.GET)
    public String editEducation(@RequestParam("id") int educationId, ModelMap model) {
        try {
            model.addAttribute("EducationEdit", educationService.searchEducation(educationId));
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "employeeView";
    }

    /**
     * <p>
     * This method passes the employee education detail as the model object into
     * its Service class.
     * </p>
     * 
     * @param employee
     *            model object that modify the education certification data
     *            associated with model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/education_update", method = RequestMethod.POST)
    public String updateEducation(@ModelAttribute("EducationEdit") Education education, BindingResult result,
            ModelMap model) {
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

    /**
     * <p>
     * Mapping the request which required by user for picture.html it will sent
     * the page
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting Employee List
     * @return contains url of picture_add page
     * 
     */
    @RequestMapping(value = "/picture", method = RequestMethod.GET)
    public String createPicture(@RequestParam("eid") int employeeId, ModelMap map) {
        map.addAttribute("EmployeeId", employeeId);
        return "picture";

    }

    /**
     * <p>
     * This method passes the employee picture name detail as the model object
     * into its Service class. OutputStream and InputStream, FileUtil are used
     * to store the picture of the employee in specific source
     * </p>
     * 
     * @param employeePicture
     *            contains picture source
     * @param employeeId
     *            contains employee identity
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/picture_add", method = RequestMethod.POST)
    public String addPicture(@RequestParam("employeePicture") MultipartFile profile,
            @RequestParam("employeeId") int employeeId, ModelMap map) {
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
            map.addAttribute("message", "Employee details are Added Successfully");
        } catch (Exception e) {
            map.addAttribute("message", e.getMessage());
        } 
        return "personal";
    }

    /**
     * <p>
     * Mapping the request which required by user for employeeView.html it will
     * sent the page and required employee object stored in database for edit.
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting emplotee model object
     * @return contains url of employee edit page
     * 
     */
    @RequestMapping(value = "/picture_edit", method = RequestMethod.GET)
    public String editPicture(@RequestParam("id") int employeeId, ModelMap model) {
        try {
            model.addAttribute("PictureEdit", employeeService.searchEmployee(employeeId));
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "employeeView";
    }

    /**
     * <p>
     * This method passes the employee picture name detail as the model object
     * into its Service class. OutputStream and InputStream, FileUtil are used
     * to store the picture of the employee in specific source
     * </p>
     * 
     * @param employeePicture
     *            contains picture source
     * @param employeeId
     *            contains employee identity
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/picture_update", method = RequestMethod.POST)
    public String updatePicture(@RequestParam("employeePicture") MultipartFile profile,
            @RequestParam("employeeId") int employeeId, ModelMap map) {
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
                map.addAttribute("message", e.getMessage());
        }
        return "employeeView";
    }
}
