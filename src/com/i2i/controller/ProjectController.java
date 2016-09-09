package com.i2i.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.i2i.exception.DataException;
import com.i2i.model.Client;
import com.i2i.model.Department;
import com.i2i.service.ClientService;

/**
 * <p>
 * Controller which gets parameters from the user inputs and displays message to
 * the user, based on the status of the manipulation of project records.
 * Displays error message when exception occurs during the manipulation process.
 * </p>
 *
 * @author Praveenkumar and Praveen RaJ
 *
 * @created 2016-08-09
 */
@Controller
public class ProjectController {
	ClientService clientService = new ClientService();
	
	/**
	 * <p>
	 * Mapping the request which required by user for client.html it will
	 * sent the page and client list stored in database and model object to
	 * add new client
	 * </p>
	 * 
	 * @param model
	 *            ModelMap object used for setting Client model object and
	 *            Client List
	 * @return contains url of Client add page
	 * 
	 */
	@RequestMapping("/client")
	public String createDepartment(ModelMap model) {
		try {
			Client client = new Client();
			model.addAttribute("Client", client);
			model.addAttribute("ClientList", clientService.displayClients());
		} catch (DataException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "client";
	}
	
	/**
	 * <p>
	 * This method passes the client detail as the model object into its
	 * Service class.
	 * </p>
	 * 
	 * @param client
	 *            model object that stores the client data associated with model.
	 * @return String returns the redirecting page url based on the appropriate
	 *         operation.
	 */
	@RequestMapping(value = "/client_insert", method = RequestMethod.POST)
	public String insertDepartment(@ModelAttribute("Client") Department client, ModelMap model) {
		try {
			if (clientService.addClient(client)) {
				model.addAttribute("message", "Client details are successfully inserted");
			} else {
				model.addAttribute("message", "Client details are not inserted");
			}
		} catch (DataException exception) {
			model.addAttribute("message", exception.getMessage());
		} finally {
			return "client";
		}
	}
}
