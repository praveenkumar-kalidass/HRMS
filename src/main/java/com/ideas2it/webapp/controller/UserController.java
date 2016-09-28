package com.ideas2it.webapp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.Constants;
import com.ideas2it.dao.SearchException;
import com.ideas2it.exception.DataException;
import com.ideas2it.model.Address;
import com.ideas2it.model.AllowanceVariant;
import com.ideas2it.model.Certification;
import com.ideas2it.model.Department;
import com.ideas2it.model.Designation;
import com.ideas2it.model.Education;
import com.ideas2it.model.Role;
import com.ideas2it.model.User;
import com.ideas2it.service.AddressService;
import com.ideas2it.service.AllowanceVariantService;
import com.ideas2it.service.CertificationService;
import com.ideas2it.service.DepartmentService;
import com.ideas2it.service.DesignationService;
import com.ideas2it.service.EducationService;
import com.ideas2it.service.RoleManager;
import com.ideas2it.service.UserExistsException;
import com.ideas2it.service.UserManager;
import com.ideas2it.service.UserService;

/**
 * Simple class to retrieve a list of users from the database.
 * <p/>
 * <p>
 * <a href="UserController.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Controller
public class UserController {

    @Autowired
    DesignationService designationService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    AddressService addressService;

    @Autowired
    UserService userService;

    @Autowired
    CertificationService certficationService;

    @Autowired
    EducationService educationService;

    @Autowired
    AllowanceVariantService allowanceVariantService;

    @Autowired
    RoleManager roleManager;

    private UserManager userManager = null;

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    @RequestMapping(value = "/admin/users*", method = RequestMethod.GET)
    public ModelAndView handleRequest(@RequestParam(required = false, value = "q") String query) throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(Constants.USER_LIST, userManager.search(query));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(userManager.getUsers());
        }
        return new ModelAndView("admin/userList", model.asMap());
    }

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
            model.addAttribute("DepartmentList", departmentService.retriveDepartments());
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "department";
    }

    /**
     * <p>
     * This method redirect to. index url
     * </p>
     * 
     * @return there is no data mapped in the url it just resolve the index view
     */
    @RequestMapping("/home")
    public String homePage(HttpSession session) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(!(auth instanceof AnonymousAuthenticationToken)){
    	    User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
    	    session.setAttribute("currentUserFullName", user.getFullName());
    	    session.setAttribute("currentUserId", user.getId());
    	    session.setAttribute("currentUserPicture", user.getPicture());
    	    session.setAttribute("currentUser", user);
    	    if(user.getTeam()!=null){
    	        session.setAttribute("currentProjectId", user.getTeam().getProject().getProjectId());
    	    }
    	    for(Role role : user.getRoles()){
    	        session.setAttribute("currentRole", role.getName());
    	    }
    	}
        return "redirect:dashboard.html";
    }

    @RequestMapping("/index")
    public String indexPage(HttpSession session) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(!(auth instanceof AnonymousAuthenticationToken)){
    	    User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
    	    session.setAttribute("currentUserFullName", user.getFullName());
    	    session.setAttribute("currentUserId", user.getId());
    	    session.setAttribute("currentUserPicture", user.getPicture());
    	    session.setAttribute("currentUser", user);
    	    if(user.getTeam()!=null){
    	        session.setAttribute("currentProjectId", user.getTeam().getProject().getProjectId());
    	    }
    	    for(Role role : user.getRoles()){
    	        session.setAttribute("currentRole", role.getName());
    	    }
    	}
        return "redirect:dashboard.html";
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
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
            model.addAttribute("RoleList", roleManager.getRoles());
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "role";
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
            model.addAttribute("DepartmentList", departmentService.retriveDepartments());
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
        } catch (DataException exception) {
            map.addAttribute("message", exception.getMessage());
        }
        return "designationView";

    }

    /**
     * <p>
     * This method passes is used for AJAX to get the user list for the given
     * designation
     * </p>
     * 
     * @param designationId
     *            contains identity of the designation it is used to many to one
     *            map with user
     * @param designationList
     *            model object that stores the user List data associated with
     *            model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/usersView", method = RequestMethod.GET)
    public String retriveUserByDesignation(@RequestParam("designationId") int designationId, ModelMap map) {
        try {
            map.addAttribute("UserList", userService.getUserByDesignation(designationId));
        } catch (DataException exception) {
            map.addAttribute("message", exception.getMessage());
        }
        return "usersView";
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
            model.addAttribute("DepartmentList", departmentService.retriveDepartments());
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
            ModelMap model) {
        try {
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
     * Mapping the request which required by user for user.html it will sent the
     * page and user list stored in database and model object to add new
     * department
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting User List
     * @return contains url of user page
     * 
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String retiveAllUser(ModelMap map) {
        try {
            map.addAttribute("UserList", userService.retrieveUsers());
        } catch (DataException exception) {
            map.addAttribute("message", exception.getMessage());
        }
        return "user";
    }

    /**
     * <p>
     * Mapping the request which required by user for user_view.html it will
     * sent the page and user object, address List, education list,
     * certification list for a user stored in database.
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting User, AddressList,
     *            EducationList, CertificationList
     * @return contains url of user_view page
     * 
     */
    @RequestMapping(value = "/user_view", method = RequestMethod.GET)
    public String retriveUserById(ModelMap map, @RequestParam("id") long userId) {
        try {
            map.addAttribute("User", userService.searchUser(userId));
            map.addAttribute("AddressList", addressService.getAddressByUser(userId));
            if (educationService.getEducationByUser(userId) != null) {
                map.addAttribute("EducationList", educationService.getEducationByUser(userId));
            }
            if (certficationService.getCertificationByUser(userId) != null) {
                map.addAttribute("CertificationList", certficationService.getCertificationByUser(userId));
            }
        } catch (DataException exception) {
            map.addAttribute("message", exception.getMessage());
        }
        return "userView";
    }

    /**
     * <p>
     * This method passes the user id as the parameter object into its Service
     * class for delete the record.
     * </p>
     * 
     * @param roleId
     *            contains Identity of user used for delete the record
     * @param model
     *            ModelMap object used for send message to the user the message
     *            will be success or failure.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/user_delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") long userId, ModelMap model) {
        try {
            if (userService.deleteUser(userId)) {
                model.addAttribute("message", "User successfully Deleted");
            } else {
                model.addAttribute("message", "User are not deleted");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        }
        return "user";
    }

    /**
     * <p>
     * Mapping the request which required by user for personal.html it will sent
     * the page
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting User obeject to insert
     *            personal details, Department List and Role List
     * @return contains url of personal page
     * 
     */
    @RequestMapping(value = "/personal", method = RequestMethod.GET)
    public String createPersonalDetails(ModelMap map) {
        try {
            map.addAttribute("User", new User());
            map.addAttribute("DepartmentList", departmentService.retriveDepartments());
            map.addAttribute("RoleList", roleManager.getRoles());
        } catch (DataException exception) {
            map.addAttribute("message", exception.getMessage());
        }
        return "personal";
    }

    /**
     * <p>
     * Mapping the request which required by user for userNameValid.html it will
     * sent the page used to check the userName is already exists or not.
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting User obeject to insert
     *            personal details, Department List and Role List
     * @RequestParam userName Given Username
     * @return contains url of personal page
     * 
     */
    @RequestMapping(value = "/userNameValid", method = RequestMethod.GET)
    public String userNameValid(@RequestParam("userName") String userName, ModelMap map) {
        try {
            int valid = 1;
            for (User user : userService.retrieveUsers()) {
                if ((user.getUsername()).equals(userName)) {
                    valid = 0;
                }
            }
            map.addAttribute("Valid", valid);
        } catch (DataException exception) {
            map.addAttribute("message", exception.getMessage());
        }
        return "userNameValid";
    }

    /**
     * <p>
     * This method passes the user personal details as the model object into its
     * Service class. and also create two new address object for New Address.
     * </p>
     * 
     * @param role
     *            model object that stores the user personal data associated
     *            with model.
     * 
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     * @throws UserExistsException
     */
    @RequestMapping(value = "/user_add", method = RequestMethod.POST)
    public String addPersonalDetails(@ModelAttribute("User") User user, BindingResult result,
            HttpServletRequest request, ModelMap model) {
        try {
            String[] userRoles = request.getParameterValues("userRoles");
            Set<Role> roleSet = new HashSet<Role>();
            if (userRoles != null) {
                System.out.println("USER ROLE IF");
                user.getRoles().clear();
                for (final String roleName : userRoles) {
                    System.out.println("Roll Name" + roleName);
                    roleSet.add(roleManager.getRole(roleName));
                }
            }
            user.setRoles(roleSet);
            user.setEnabled(true);
            if (userManager.saveUser(user) != null) {
                user.add(new Address());
                user.add(new Address());
                model.addAttribute("User", user);
            } else {
                model.addAttribute("message", "Personal details are not Added");
            }
        } catch (UserExistsException exception) {
            model.addAttribute("message", exception.getMessage());
        }
        return "address";
    }

    /**
     * <p>
     * Mapping the request which required by user for userView.html it will sent
     * the page and required user object stored in database for edit.
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting User model object
     * @return contains url of user edit page
     * 
     */
    @RequestMapping(value = "/personal_edit", method = RequestMethod.GET)
    public String editPersonalDetails(@RequestParam("id") long userId, ModelMap model) {
        try {
            model.addAttribute("PersonalEdit", userService.searchUser(userId));
            model.addAttribute("DepartmentList", departmentService.retriveDepartments());
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "userView";
    }

    /**
     * <p>
     * This method passes the user detail as the model object into its Service
     * class.
     * </p>
     * 
     * @param user
     *            model object that modify the user personal data associated
     *            with model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     * @throws UserExistsException
     */
    @RequestMapping(value = "/personal_update", method = RequestMethod.POST)
    public String updatePersonalDetails(@ModelAttribute("PersonalEdit") User user, BindingResult result,
            ModelMap model) {
        try {
            System.out.println("Personla Update");

            userManager.saveUser(user);
            model.addAttribute("message", "Personal details updated Successfully");
            model.addAttribute("UserId", user.getId());
        } catch (UserExistsException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "userView";
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
    public String checkSameAsResidentialAddress(@RequestParam("same") String same,
            @RequestParam("address") String address, @RequestParam("countries") String countries,
            @RequestParam("states") String states, @RequestParam("cities") String cities,
            @RequestParam("pincode") String pincode, @RequestParam("email") String email,
            @RequestParam("mobile") String mobile, ModelMap map) {
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
     * This method passes the user Address details as the model object into its
     * Service class.
     * </p>
     * 
     * @param role
     *            model object that stores the user address data associated with
     *            model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/address_add", method = RequestMethod.POST)
    public String addAddress(@ModelAttribute("User") User user, BindingResult result, ModelMap map) {
        try {
            for (Address address : user.getAddress()) {
                address.setUser(userService.searchUser(address.getUser().getId()));
                addressService.addAddress(address);
                map.addAttribute("UserId", address.getUser().getId());
            }
        } catch (DataException exception) {
            map.addAttribute("message", exception.getMessage());
        }
        return "education";
    }

    /**
     * <p>
     * Mapping the request which required by user for userView.html it will sent
     * the page and required address object stored in database for edit.
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting Address model object
     * @return contains url of user address edit page
     * 
     */
    @RequestMapping(value = "/address_edit", method = RequestMethod.GET)
    public String editAddress(@RequestParam("id") int addressId, ModelMap model) {
        try {
            model.addAttribute("AddressEdit", addressService.searchAddress(addressId));
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "userView";
    }

    /**
     * <p>
     * This method passes the user address detail as the model object into its
     * Service class.
     * </p>
     * 
     * @param user
     *            model object that modify the user address data associated with
     *            model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/address_update", method = RequestMethod.POST)
    public String updateAddress(@ModelAttribute("AddressEdit") Address address, BindingResult result, ModelMap model) {
        try {
            address.setUser(userService.searchUser(address.getUser().getId()));
            addressService.updateAddress(address);
            model.addAttribute("UserId", (address.getUser().getId()));
            model.addAttribute("message", "Address details updated Successfully");
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "userView";
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
     *            contains identity of the user
     * @param map
     *            used to set no of object
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/certification_form", method = RequestMethod.GET)
    public String crtification_form(@RequestParam("noof") int noof, @RequestParam("eid") long userId, ModelMap map) {
        try {
            User user = userService.searchUser(userId);
            for (int i = 1; i <= noof; i++) {
                user.addCertification(new Certification());
            }
            map.addAttribute("User", user);
        } catch (DataException exception) {
            map.addAttribute("message", exception.getMessage());
        }
        return "certification_form";
    }

    /**
     * <p>
     * This method passes the user certification details as the model object
     * into its Service class.
     * </p>
     * 
     * @param role
     *            model object that stores the user certification data
     *            associated with model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/certification_insert", method = RequestMethod.POST)
    public String addCertification(@ModelAttribute("User") User user, BindingResult result, ModelMap map) {
        User user1 = null;
        try {
            for (Certification certificate : user.getCertification()) {
                certificate.setUser(userService.searchUser(certificate.getUser().getId()));
                certficationService.addCertification(certificate);
                user1 = certificate.getUser();
            }
            map.addAttribute("UserId", user1.getId());
        } catch (DataException exception) {
            map.addAttribute("message", exception.getMessage());
        }
        return "picture";
    }

    /**
     * <p>
     * Mapping the request which required by user for userView.html it will sent
     * the page and required certification object stored in database for edit.
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting certification model object
     * @return contains url of user certification edit page
     * 
     */
    @RequestMapping(value = "/certification_edit", method = RequestMethod.GET)
    public String editCertification(@RequestParam("id") int certificationId, ModelMap model) {
        try {
            model.addAttribute("CertificateEdit", certficationService.searchCertification(certificationId));
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "userView";
    }

    /**
     * <p>
     * This method passes the user certification detail as the model object into
     * its Service class.
     * </p>
     * 
     * @param user
     *            model object that modify the user certification data
     *            associated with model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/certification_update", method = RequestMethod.POST)
    public String updateCertification(@ModelAttribute("CertificateEdit") Certification certification,
            BindingResult result, ModelMap model) {
        try {
            certification.setUser(userService.searchUser(certification.getUser().getId()));
            certficationService.updateCertification(certification);
            User user = certification.getUser();
            model.addAttribute("message", "Certification details updated Successfully");
            model.addAttribute("UserId", user.getId());
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "userView";
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
     *            contains identity of the user
     * @param map
     *            used to set no of object
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/education_form", method = RequestMethod.GET)
    public String createEducation(@RequestParam("noof") int noof, @RequestParam("eid") long userId, ModelMap map) {
        try {
            User user = userService.searchUser(userId);
            for (int i = 1; i <= noof; i++) {
                user.addEducation(new Education());
            }
            map.addAttribute("User", user);
        } catch (Exception e) {
            map.addAttribute("message", e.getMessage());
        }
        return "education_form";
    }

    /**
     * <p>
     * This method passes the user education details as the model object into
     * its Service class.
     * </p>
     * 
     * @param role
     *            model object that stores the user education data associated
     *            with model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/education_insert", method = RequestMethod.POST)
    public String addEducation(@ModelAttribute("User") User user, BindingResult result, ModelMap map) {
        User user1 = null;
        try {
            for (Education education : user.getEducation()) {
                education.setUser(userService.searchUser(education.getUser().getId()));
                educationService.addEducation(education);
                user1 = education.getUser();
            }
            map.addAttribute("UserId", user1.getId());
        } catch (Exception e) {
            map.addAttribute("message", e.getMessage());
        }
        return "certification";
    }

    /**
     * <p>
     * Mapping the request which required by user for userView.html it will sent
     * the page and required education object stored in database for edit.
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting education model object
     * @return contains url of user education edit page
     * 
     */
    @RequestMapping(value = "/education_edit", method = RequestMethod.GET)
    public String editEducation(@RequestParam("id") int educationId, ModelMap model) {
        try {
            model.addAttribute("EducationEdit", educationService.searchEducation(educationId));
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "userView";
    }

    /**
     * <p>
     * This method passes the user education detail as the model object into its
     * Service class.
     * </p>
     * 
     * @param user
     *            model object that modify the education certification data
     *            associated with model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/education_update", method = RequestMethod.POST)
    public String updateEducation(@ModelAttribute("EducationEdit") Education education, BindingResult result,
            ModelMap model) {
        try {
            education.setUser(userService.searchUser(education.getUser().getId()));
            educationService.updateEducation(education);
            User user = education.getUser();
            model.addAttribute("message", "Education details updated Successfully");
            model.addAttribute("UserId", user.getId());
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "userView";
    }

    /**
     * <p>
     * Mapping the request which required by user for picture.html it will sent
     * the page
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting User List
     * @return contains url of picture_add page
     * 
     */
    @RequestMapping(value = "/picture", method = RequestMethod.GET)
    public String createPicture(@RequestParam("eid") long userId, ModelMap map) {
        map.addAttribute("UserId", userId);
        return "picture";

    }

    /**
     * <p>
     * This method passes the user picture name detail as the model object into
     * its Service class. OutputStream and InputStream, FileUtil are used to
     * store the picture of the user in specific source
     * </p>
     * 
     * @param userPicture
     *            contains picture source
     * @param userId
     *            contains user identity
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/picture_add", method = RequestMethod.POST)
    public String addPicture(@RequestParam("userPicture") MultipartFile profile, @RequestParam("userId") long userId,
            ModelMap map) {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            User user = userService.searchUser(userId);

            String fileName = profile.getOriginalFilename();
            user.setPicture(fileName);
            inputStream = profile.getInputStream();
            File newFile = new File("src/main/webapp/upload/" + fileName);
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            outputStream = new FileOutputStream(newFile);
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            userService.updateUser(user);
            map.addAttribute("message", "User details are Added Successfully");
        } catch (Exception e) {
            map.addAttribute("message", e.getMessage());
        }
        return "user";
    }

    /**
     * <p>
     * Mapping the request which required by user for userView.html it will sent
     * the page and required user object stored in database for edit.
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting emplotee model object
     * @return contains url of user edit page
     * 
     */
    @RequestMapping(value = "/picture_edit", method = RequestMethod.GET)
    public String editPicture(@RequestParam("id") long userId, ModelMap model) {
        try {
            model.addAttribute("PictureEdit", userService.searchUser(userId));
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "userView";
    }

    /**
     * <p>
     * This method passes the user picture name detail as the model object into
     * its Service class. OutputStream and InputStream, FileUtil are used to
     * store the picture of the user in specific source
     * </p>
     * 
     * @param userPicture
     *            contains picture source
     * @param userId
     *            contains user identity
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/picture_update", method = RequestMethod.POST)
    public String updatePicture(@RequestParam("picture") MultipartFile profile, @RequestParam("id") long userId,
            ModelMap map) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            User user = userService.searchUser(userId);
            String fileName = profile.getOriginalFilename();
            user.setPicture(fileName);
            inputStream = profile.getInputStream();
            File newFile = new File("src/main/webapp/upload/" + fileName);
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            outputStream = new FileOutputStream(newFile);
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            userService.updateUser(user);
            map.addAttribute("message", "Picture updated Successfully");
            map.addAttribute("UserId", userId);
        } catch (Exception e) {
            map.addAttribute("message", e.getMessage());
        }
        return "userView";
    }
}
