package com.ideas2it.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.AllowanceVariant;
import com.ideas2it.service.AllowanceVariantService;
import com.ideas2it.service.DepartmentService;
import com.ideas2it.service.UserService;
import com.ideas2it.service.LeaveRequestService;
import com.ideas2it.service.SalaryService;

/**
 * <p>
 * Controller which gets parameters from the user inputs and displays message to
 * the user, based on the status of the manipulation of salary records. Displays
 * error message when exception occurs during the manipulation process.
 * </p>
 *
 * @author Praveen RaJ
 *
 * @created 2016-08-15
 */

@Controller
public class SalaryController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    UserService userService;

    @Autowired
    AllowanceVariantService allowanceVariantService;

    @Autowired
    LeaveRequestService leaveRequestService;

    @Autowired
    SalaryService salaryService;

    /**
     * <p>
     * Mapping the request which required by user for allowance.html it will
     * sent the page and allowance list stored in database and model object to
     * add new allowance
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting allowance model object and
     *            Department List
     * @return contains url of allowance add page
     * 
     */
    @RequestMapping("/allowance")
    public String createAllowanceVariant(ModelMap model) {
        try {
            model.addAttribute("Allowance", new AllowanceVariant());
            model.addAttribute("AllowanceList", allowanceVariantService.getAllowanceVariants());
            model.addAttribute("DepartmentList", departmentService.retriveDepartments());
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "allowance";
    }

    /**
     * <p>
     * This method passes the allowance detail as the model object into its
     * Service class.
     * </p>
     * 
     * @param allowance
     *            model object that stores the allowance data associated with
     *            model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/allowance_insert", method = RequestMethod.POST)
    public String insertAllowanceVariant(@ModelAttribute("allowance") AllowanceVariant allowanceVariant,
            ModelMap model) {
        try {
            if (allowanceVariantService.addAllowanceVariant(allowanceVariant)) {
                model.addAttribute("message", "AllowanceVariant details are successfully Added");
            } else {
                model.addAttribute("message", "AllowanceVariant details are not Added");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        }
        return "allowance";
    }

    /**
     * <p>
     * Mapping the request which required by user for allowance_edit.html it
     * will sent the page and required allowanceVariant object stored in
     * database for edit.
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting allowance model object.
     * @return contains url of department edit page
     * 
     */
    @RequestMapping(value = "/allowance_edit", method = RequestMethod.GET)
    public String editAllowanceVariant(@RequestParam("id") int allowanceId, ModelMap model) {
        try {
            model.addAttribute("AllowanceEdit", allowanceVariantService.searchAllowanceVariant(allowanceId));
            model.addAttribute("DepartmentList", departmentService.retriveDepartments());

        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "allowance";
    }

    /**
     * <p>
     * This method passes the allowance detail as the model object into its
     * Service class.
     * </p>
     * 
     * @param allowanceVariant
     *            model object that update the records in stored in database.
     * @param model
     *            ModelMap object used for send message to the user.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/allowance_update", method = RequestMethod.POST)
    public String updateAllowanceVariant(@ModelAttribute("AllowanceEdit") AllowanceVariant allowanceVariant,
            ModelMap model) {
        try {
            if (allowanceVariantService.updateAllowanceVariant(allowanceVariant)) {
                model.addAttribute("message", "Allowance Variant details are successfully Updated");
            } else {
                model.addAttribute("message", "Allowance Variant  details are not updated");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        }
        return "allowance";
    }

    /**
     * <p>
     * This method passes the allowance id as the parameter object into its
     * Service class for delete the record.
     * </p>
     * 
     * @param allowanceId
     *            contains Identity of allowance used for delete the record
     * @param model
     *            ModelMap object used for send message to the user the message
     *            will be success or failure.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/allowance_delete", method = RequestMethod.GET)
    public String deleteAllowanceVariant(@RequestParam("id") int allowanceId, ModelMap model) {
        try {
            if (allowanceVariantService.deleteAllowanceVariant(allowanceId)) {
                model.addAttribute("message", "Allowance details are successfully Deleted");
            } else {
                model.addAttribute("message", "Allowance details are not deleted");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        }
        return "allowance";
    }

    /**
     * <p>
     * Mapping the request which required by user for salary.html it will sent
     * the page and salary list stored in database and model object to add new
     * allowance
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting salary model object and
     *            Department List
     * @return contains url of salary add page
     * 
     */
    @RequestMapping("/salary")
    public String salaey(ModelMap model) {
        return "salary";
    }

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
     */
    @RequestMapping(value = "/salary_generate", method = RequestMethod.GET)
    public String salaryGenerate(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
            @RequestParam("noDays") int noDays, ModelMap model) {
        try {
            model.addAttribute("SalaryList", salaryService.generateSalary(fromDate, toDate, noDays));
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        }
        return "salary_generate";
    }
}
