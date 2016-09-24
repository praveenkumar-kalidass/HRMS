package com.ideas2it.webapp.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Attendance;
import com.ideas2it.model.LeaveRequest;
import com.ideas2it.model.User;
import com.ideas2it.service.AttendanceService;
import com.ideas2it.service.UserService;
import com.ideas2it.service.LeaveRequestService;
import com.ideas2it.service.UserManager;

/**
 * <p>
 * Controller which gets parameters from the user inputs and displays message to
 * the user, based on the status of the manipulation of attendance records.
 * Displays error message when exception occurs during the manipulation process.
 * </p>
 *
 * @author Praveenkumar and Praveen RaJ
 *
 * @created 2016-09-10
 */
@Controller
public class AttendanceController {
	
	
	
	private UserManager userManager = null;

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
	
	@Autowired
    AttendanceService attendanceService;
	
	@Autowired
    UserService userService;
	
	@Autowired
    LeaveRequestService leaveRequestService;
    /**
     * <p>
     * Mapping the request which required by user for attendance.html it will
     * sent the page and attendance list stored in database and model object to
     * add new user
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting Attendance model object,
     *            attendance list and User List
     * @param session
     *            HttpSession object which stores the current session of the
     *            authenticated user.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping("/attendance")
    public String createAttendance(ModelMap model, final HttpServletRequest request) {
        try {
        	User user = userManager.getUserByUsername(request.getRemoteUser());
            if(null != user) { 
            	long userId = user.getId();
                model.addAttribute("AttendanceList", attendanceService.getCompleteAttendanceByUserId(userId));
                if (attendanceService.getAttendancesByUserId(userId).size() != 0) {
                    for (Attendance attendance : attendanceService.getAttendancesByUserId(userId)) {
                        if (attendance.getTimeOut() == null) {
                            model.addAttribute("CheckOut", "True");
                        } else {
                            model.addAttribute("CheckIn", "True");
                        }
                    }
                } else {
                    model.addAttribute("CheckIn", "True");
                }
            }
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "attendance";
    }

    /**
     * <p>
     * Mapping the request which required by user for attendance_view.html it will
     * sent the page and attendance list stored in database and model object to
     * add new user
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting Attendance model object,
     *            attendance list and User List
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping("/attendance_view")
    public String viewAttendanceForUser(@RequestParam("id") long userId, ModelMap model) {
        try {
            model.addAttribute("AttendanceList", attendanceService.getCompleteAttendanceByUserId(userId));
            model.addAttribute("Date", new Date());
            if (attendanceService.getAttendancesByUserId(userId).size() != 0) {
                for (Attendance attendance : attendanceService.getAttendancesByUserId(userId)) {
                    if (attendance.getTimeOut() == null) {
                        model.addAttribute("CheckOut", "True");
                    } else {
                        model.addAttribute("CheckIn", "True");
                    }
                }
            } else {
                model.addAttribute("CheckIn", "True");
            }

        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "attendanceView";
    }

    /**
     * <p>
     * This method passes the attendance detail as the model object into its
     * Service class to insert into the database. Processes check in for an
     * user for the corresponding day.
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting Attendance model object,
     *            attendance list and User List
     * @param userId
     *            contains identity of the User it is used to many to one
     *            map with attendance
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/check_in", method = RequestMethod.GET)
    public String checkInAttendance(ModelMap model, final HttpServletRequest request) {
        try {
        	User user = userManager.getUserByUsername(request.getRemoteUser());
        	long userId = user.getId();
            Date date = new Date();
            Attendance attendance = new Attendance();
            attendance.setDate(date.getYear() + 1900 + "-" + date.getMonth() + "-" + date.getDate());
            attendance.setTimeIn(date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
            attendance.setUser(userService.searchUser(userId));
            model.addAttribute("AttendanceList", attendanceService.getCompleteAttendanceByUserId(userId));
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
     * This method passes the attendance detail as the model object into its
     * Service class to update the checked in log in the database. Processes
     * check out for an user for the check in of the corresponding day.
     * </p>
     * 
     * @param userId
     *            contains the ID of the user
     * @param model
     *            ModelMap object used for setting Attendance model object and
     *            User List
     * @return contains url of user edit page
     */
    @RequestMapping(value = "/check_out", method = RequestMethod.GET)
    public String checkOutAttendance(ModelMap model, final HttpServletRequest request) {
        try {
        	User user = userManager.getUserByUsername(request.getRemoteUser());
        	long userId = user.getId();
            Date date = new Date();
            Attendance attendance = null;
            for (Attendance attendance1 : attendanceService.getAttendancesByUserId(userId)) {
                attendance = attendance1;
            }
            attendance.setTimeOut(date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
            model.addAttribute("AttendanceList", attendanceService.getCompleteAttendanceByUserId(userId));
            if (attendanceService.updateAttendance(attendance)) {
                model.addAttribute("message", "Checked out Successfully");
            } else {
                model.addAttribute("message", "Not Checked out");
            }
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "attendance";
    }

    /**
     * <p>
     * Mapping the request which required by user for leaveRequest.html it will
     * sent the page and leaveRequest list stored in database and model object
     * to add new user
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting LeaveRequest model object,
     *            leaveRequest list and User List
     * @param session
     *            Session object that stores the current session of the
     *            authenticated user.
     * @return contains url of leaveRequest add page
     * 
     */
    @RequestMapping("/leaverequest")
    public String createLeaveRequest(ModelMap model, final HttpServletRequest request) {
        try {
        	User user = userManager.getUserByUsername(request.getRemoteUser());
        	long userId = user.getId();            
            model.addAttribute("LeaveRequest", new LeaveRequest());
            model.addAttribute("LeaveRequestList", leaveRequestService.displayLeaveRequests());
            model.addAttribute("OwnLeaveRequestList", leaveRequestService.displayLeaveRequestsByUser(userId));
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "leaverequest";
    }

    /**
     * <p>
     * This method passes the leaveRequest detail as the model object into its
     * Service class.
     * </p>
     * 
     * @param userId
     *            contains identity of the User it is used to many to one
     *            map with leaveRequest
     * @param leaveRequest
     *            model object that stores the leaveRequest data associated with
     *            model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/leaveRequest_insert", method = RequestMethod.POST)
    public String insertLeaveRequest(@ModelAttribute("LeaveRequest") LeaveRequest leaveRequest, BindingResult result,
            ModelMap model) {
        try {
            if (leaveRequestService.addLeaveRequest(leaveRequest)) {
                model.addAttribute("message", "LeaveRequest details are successfully Added Please Wait for Admin Approvel");
            } else {
                model.addAttribute("message", "LeaveRequest details are not added");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        }
        return "leaverequest";
    }

    /**
     * <p>
     * This method passes the leaveRequest id as the parameter object into its
     * Service class for delete the record.
     * </p>
     * 
     * @param leaveRequestid
     *            contains Identity of leaveRequest used for delete the record
     * @param model
     *            ModelMap object used for send message to the user the message
     *            will be success or failure.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/leaveRequest_status", method = RequestMethod.GET)
    public String deleteLeaveRequest(@RequestParam("id") int leaveRequestId, @RequestParam("status") int status,
            ModelMap model, final HttpServletRequest request) {
        try {
        	User user = userManager.getUserByUsername(request.getRemoteUser());
        	long userId = user.getId();
                LeaveRequest leaveRequest = leaveRequestService.searchLeaveRequest(leaveRequestId);
                if (status == 1) {
                    leaveRequest.setLeaveStatus("Approved");
                } else if (status == 2) {
                    leaveRequest.setLeaveStatus("Rejected");
                }
                model.addAttribute("LeaveRequestList", leaveRequestService.displayLeaveRequests());
                model.addAttribute("OwnLeaveRequestList", leaveRequestService.displayLeaveRequestsByUser(userId));
                if (leaveRequestService.updateLeaveRequest(leaveRequest)) {
                   model.addAttribute("message", "LeaveRequest status updated successfully ");
                } else {
                   model.addAttribute("message", "LeaveRequest status not updated");
                }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        }
        return "leaverequest";
    }
}
