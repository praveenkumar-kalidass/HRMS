package com.ideas2it.webapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Role;
import com.ideas2it.model.User;
import com.ideas2it.service.UserManager;
import com.ideas2it.service.UserService;

/**
 * <p>
 * Controller which passes data to the webpage to render charts. Retrieves
 * information from the database to display information on the dashboard for the
 * user.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-09-15
 */
@Controller
public class DashboardController {

	private UserManager userManager = null;

	@Autowired
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@Autowired
	UserService userService;

	/**
	 * <p>
	 * This method maps the
	 * </p>
	 * 
	 * @param model
	 *            ModelMap object which is used to map the data to the elemts in
	 *            the webpage.
	 * @param session
	 *            HttpSession object which stores the current session of the
	 *            authenticated user.
	 * @return String returns the redirecting page url based on the appropriate
	 *         operation.
	 */
	@RequestMapping("/dashboard")
	public String dashboardView(ModelMap model, final HttpServletRequest request) throws ParseException {
		try {
			float adminCount = 0;
			float userCount = 0;
			int developerCount = 0;
			int testingCount = 0;
			int hrCount = 0;
			int manageCount = 0;
			int othersCount = 0;

			for (User user : userService.retrieveUsers()) {

				for (Role role : user.getRoles()) {
					if (role.getName().equals("ROLE_ADMIN")) {
						adminCount++;
					} else {
						userCount++;
					}
				}
				if (user.getDesignation().getDepartment().getDepartmentName().equals("Developer")) {
					developerCount++;
				} else if (user.getDesignation().getDepartment().getDepartmentName().equals("Testing")) {
					testingCount++;
				} else if (user.getDesignation().getDepartment().getDepartmentName().equals("Human Resource")) {
					hrCount++;
				} else if (user.getDesignation().getDepartment().getDepartmentName().equals("Management")) {
					manageCount++;
				} else {
					othersCount++;
				}
			}

			float totalCount = adminCount + userCount;
			model.addAttribute("AdminPercent", (adminCount / totalCount) * 100);
			model.addAttribute("UserPercent", (userCount / totalCount) * 100);
			model.addAttribute("DeveloperCount", developerCount);
			model.addAttribute("TestingCount", testingCount);
			model.addAttribute("HRCount", hrCount);
			model.addAttribute("ManagementCount", manageCount);
			model.addAttribute("OthersCount", othersCount);
			long userId = 0;
			User user = userManager.getUserByUsername(request.getRemoteUser());
			if (null != user) {
				userId = (long) user.getId();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date date = format.parse(user.getDateOfBirth());

				if ((new Date().getMonth() + 1) == (date.getMonth() + 1)
						&& (new Date().getDate()) == (date.getDate())) {
					model.addAttribute("BirthdayWish", "Happy Birthday");
				} else if ((new Date().getMonth() + 1) < (date.getMonth() + 1)) {
					model.addAttribute("Birthday",
							new Date().getYear() + 1900 + "/" + (date.getMonth() + 1) + "/" + date.getDate());
				} else if ((new Date().getMonth() + 1) == (date.getMonth() + 1)
						&& (new Date().getDate()) < (date.getDate())) {
					model.addAttribute("Birthday",
							new Date().getYear() + 1900 + "/" + (date.getMonth() + 1) + "/" + date.getDate());
				} else {
					model.addAttribute("Birthday",
							new Date().getYear() + 1901 + "/" + (date.getMonth() + 1) + "/" + date.getDate());
				}
			}
		} catch (DataException e) {
			model.addAttribute("message", "Problem with Dashboard View");
		}
		return "dashboard";
	}
}
