package com.i2i.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.i2i.model.Employee;
import com.i2i.model.Team;
import com.i2i.service.EmployeeService;
import com.i2i.service.TeamService;

/**
 * <p>
 * Controller which gets parameters from the user inputs and displays message to user
 * login and control all authentication process here.
 * Displays error message when exception occurs during the manipulation process.
 * </p>
 *
 * @author  Praveen RaJ
 *
 * @created 2016-09-15
 */
@Controller
public class LoginController {
    EmployeeService  employeeService = new EmployeeService();
    TeamService teamService = new TeamService();
    
    /**
     * <p>
     * This method redirect to. index url
     * </p>
     * 
     * @return there is no data mapped in the url it just resolve the index view
     */
    @RequestMapping("/index")
    public String indexPage() {
        return "index";
    }
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(ModelMap map, HttpSession session, @RequestParam("uname") String userName, @RequestParam("password") String password){
        try {
            Employee employee = employeeService.searchEmployeeByUserName(userName);
            if(employee!=null) {
                if((employee.getEmployeePassword()).equals(password)) {
                    for(Team team : teamService.displayTeams()){
                        if(team.getEmployee().getEmployeeId()==employee.getEmployeeId()){
                            session.setAttribute("HRMSProjectId", team.getProject().getProjectId());
                            session.setAttribute("HRMSTeamRole", team.getTeamRole());
                        }
                    }
                    session.setAttribute("HRMSEmployee", employee);
                    session.setAttribute("HRMSEmployeeId", employee.getEmployeeId());
                    session.setAttribute("HRMSRole", employee.getEmployeeRole().getRoleName());
                 } else {
                    map.addAttribute("Error", "Invalid UserName or Password..!");
                    return "index";
                 }
            } else {
                map.addAttribute("Error", "Invalid UserName or Password..!");
                return "index";
             }
        } catch (Exception e) {
            map.addAttribute("message", e.getMessage());
        }
        return "redirect:dashboard.html";
    }
    
    /**
     * Logout is used to go out from the process session
     * also invalidate the session object
     * 
     * @param session
     *     contains session object used for invalidate the session attributes
     *  
     * @return "redirect:login.html"
     *             contains redirection url 
     */
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:index.html";
    }
}
