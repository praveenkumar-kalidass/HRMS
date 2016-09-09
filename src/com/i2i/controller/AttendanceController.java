package com.i2i.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.i2i.exception.DataException;
import com.i2i.model.Attendance;
import com.i2i.model.LeaveRequest;
import com.i2i.service.AttendanceService;
import com.i2i.service.EmployeeService;
import com.i2i.service.LeaveRequestService;


@Controller
public class AttendanceController {
	AttendanceService attendanceService = new AttendanceService();
	EmployeeService employeeService = new EmployeeService();
	LeaveRequestService leaveRequestService = new LeaveRequestService();
/**
 * <p>
 * Mapping the request which required by user for attendance.html it will sent the page
 * and attendance list stored in database and model object to add new employee
 * </p>
 * 
 * @param model
 *     ModelMap object used for setting Attendance model object, attendance list and Employee List 
 * @return
 *     contains url of attendance add page
 * 
 */
@RequestMapping("/attendance")
public String createAttendance(ModelMap model) {
	try {
	model.addAttribute("Attendance", new Attendance());
	model.addAttribute("Date", new Date());
	model.addAttribute("AttendanceList", attendanceService.displayAttendances());
	model.addAttribute("Employee", employeeService.searchEmployee(1));
	} catch (DataException e) {
		model.addAttribute("message", e.getMessage());
	}
	return "attendance";
}

/**
 * <p>
 * This method passes the attendance detail as the model object into its Service class.
 * </p>
 * 
 * @param employeeId
 *       contains identity of the Employee it is used to many to one map with attendance
 * @param attendance
 *       model object that stores the attendance data associated with model.
 * @return String
 *       returns the redirecting page url based on the appropriate operation.
 */
@RequestMapping(value ="/attendance_insert", method = RequestMethod.POST)
public String insertAttendance(@ModelAttribute("Attendance")Attendance attendance, BindingResult result, ModelMap model) {
    try {        	
        if (attendanceService.addAttendance(attendance)) {
        	model.addAttribute("message", "Checked in Successfully");
        } else {
        	model.addAttribute("message", "Not Checked In");
        }
    } catch (DataException exception) {
        model.addAttribute("message", exception.getMessage());
    } 
    return "attendance";
}

/**
 * <p>
 * Mapping the request which required by user for attendance_edit.html it will sent the page
 * and required attendance object stored in database for edit.
 * </p>
 * 
 * @param model
 *     ModelMap object used for setting Attendance model object and Employee List 
 * @return
 *     contains url of employee edit page
 * 
 */
@RequestMapping(value ="/attendance_edit", method = RequestMethod.GET)
public String editAttendance(@RequestParam("id")int attendanceId, ModelMap model) {
	try {	
	 model.addAttribute("AttendanceEdit", attendanceService.searchAttendance(attendanceId));
	 model.addAttribute("Employee", employeeService.searchEmployee(1));
	 model.addAttribute("Date", new Date());
	 model.addAttribute("AttendanceList", attendanceService.displayAttendances());
	} catch (DataException e) {
		model.addAttribute("message", e.getMessage());
	}
	return "attendance";
}
 
 /**
 * <p>
 * This method passes the attendance detail as the model object into its Service class.
 * </p>
 * 
 * @param attendance
 *       model object that update the records in stored in database.
 * @param employeeId
 *       contains identity of the Employee it is used to many to one map with attendance
 * @param model
 *     ModelMap object used for send message to the user.      
 * @return String
 *       returns the redirecting page url based on the appropriate operation.
 */
 @RequestMapping(value ="/attendance_update", method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute("AttendanceEdit")Attendance attendance, BindingResult result, ModelMap model) {
        try {
            if (attendanceService.updateAttendance(attendance)) {
                model.addAttribute("message", "Checked out Successfully");
            } else {
            	model.addAttribute("message", "Not Checked out");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } finally {
            return "attendance";
        }
    }
    
     /**
     * <p>
     * This method passes the attendance id as the parameter object into its Service class for delete the record.
     * </p>
     * 
     * @param attendanceid
     *       contains Identity of attendance used for delete the record
     * @param model
	 *     ModelMap object used for send message to the user the message will be success or failure.    
     * @return String
     *       returns the redirecting page url based on the appropriate operation.
     */
    @RequestMapping(value ="/attendance_delete", method = RequestMethod.GET)
    public String deleteAttendance(@RequestParam("id")int attendanceId, ModelMap model) {
    	try {
            if (attendanceService.deleteAttendance(attendanceId)) {
                model.addAttribute("message", "Attendance details are successfully Deleted");
            } else {
            	model.addAttribute("message", "Attendance details are not deleted");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } finally {
            return "attendance";
        }
    }
    
/*----------------------------------------------------------------------------------------------------------------------------------------*/
    /**
	 * <p>
     * Mapping the request which required by user for leaveRequest.html it will sent the page
     * and leaveRequest list stored in database and model object to add new employee
     * </p>
	 * 
	 * @param model
	 *     ModelMap object used for setting LeaveRequest model object, leaveRequest list and Employee List 
	 * @return
	 *     contains url of leaveRequest add page
	 * 
	 */
    @RequestMapping("/leaverequest")
	public String createLeaveRequest(ModelMap model) {
		try {
		    model.addAttribute("LeaveRequest", new LeaveRequest());
	    	model.addAttribute("LeaveRequestList", leaveRequestService.displayLeaveRequests());
	    	model.addAttribute("EmployeeList", employeeService.retrieveEmployees());
	    	model.addAttribute("Employee", employeeService.searchEmployee(1));
		} catch (DataException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "leaverequest";
	}
	
    /**
     * <p>
     * This method passes the leaveRequest detail as the model object into its Service class.
     * </p>
     * 
     * @param employeeId
     *       contains identity of the Employee it is used to many to one map with leaveRequest
     * @param leaveRequest
     *       model object that stores the leaveRequest data associated with model.
     * @return String
     *       returns the redirecting page url based on the appropriate operation.
     */
    @RequestMapping(value ="/leaveRequest_insert", method = RequestMethod.POST)
    public String insertLeaveRequest(@ModelAttribute("LeaveRequest")LeaveRequest leaveRequest, BindingResult result,  ModelMap model) {
       try {        	
            if (leaveRequestService.addLeaveRequest(leaveRequest)) {
            	model.addAttribute("message", "LeaveRequest details are successfully inserted");
            } else {
            	model.addAttribute("message", "LeaveRequest details are not inserted");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } finally {
        	return "leaverequest";
        }
        
    }
	    
	     /**
	     * <p>
	     * This method passes the leaveRequest id as the parameter object into its Service class for delete the record.
	     * </p>
	     * 
	     * @param leaveRequestid
	     *       contains Identity of leaveRequest used for delete the record
	     * @param model
		 *     ModelMap object used for send message to the user the message will be success or failure.    
	     * @return String
	     *       returns the redirecting page url based on the appropriate operation.
	     */
	    @RequestMapping(value ="/leaveRequest_delete", method = RequestMethod.GET)
	    public String deleteLeaveRequest(@RequestParam("id")int leaveRequestId, ModelMap model) {
	    	try {
	            if (leaveRequestService.deleteLeaveRequest(leaveRequestId)) {
	                model.addAttribute("message", "LeaveRequest details are successfully Deleted");
	            } else {
	            	model.addAttribute("message", "LeaveRequest details are not deleted");
	            }
	        } catch (DataException exception) {
	            model.addAttribute("message", exception.getMessage());
	        } finally {
	            return "leaverequest";
	        }
	    }
	    
/*---------------------------------------------------------------------------------------------------------------------------------------*/
}