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
import com.i2i.model.Client;
import com.i2i.model.Project;
import com.i2i.service.ClientService;
import com.i2i.service.ProjectService;

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
	ProjectService projectService = new ProjectService();
	
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
	public String createClient(ModelMap model) {
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
	public String insertClient(@ModelAttribute("Client") Client client, ModelMap model) {
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
	
	/**
	 * <p>
	 * Mapping the request which required by user for client_edit.html it
	 * will sent the page and required client object stored in database for
	 * edit.
	 * </p>
	 * 
	 * @param model
	 *            ModelMap object used for setting Client model object.
	 * @return contains url of client edit page
	 * 
	 */
	@RequestMapping(value = "/client_edit", method = RequestMethod.GET)
	public String editClient(@RequestParam("id") int clientId, ModelMap model) {
		try {
			model.addAttribute("ClientEdit", clientService.searchClient(clientId));

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
	 *            model object that update the records in stored in database.
	 * @param model
	 *            ModelMap object used for send message to the user.
	 * @return String returns the redirecting page url based on the appropriate
	 *         operation.
	 */
	@RequestMapping(value = "/client_update", method = RequestMethod.POST)
	public String updateClient(@ModelAttribute("ClientEdit") Client client, ModelMap model) {
		try {
			if (clientService.updateClient(client)) {
				model.addAttribute("message", "Client details are successfully Updated");
			} else {
				model.addAttribute("message", "Client details are not updated");
			}
		} catch (DataException exception) {
			model.addAttribute("message", exception.getMessage());
		} finally {
			return "client";
		}
	}
	
	/**
	 * <p>
	 * This method passes the Client id as the parameter object into its
	 * Service class for delete the record.
	 * </p>
	 * 
	 * @param ClientId
	 *            contains Identity of Client used for delete the record
	 * @param model
	 *            ModelMap object used for send message to the user the message
	 *            will be success or failure.
	 * @return String returns the redirecting page url based on the appropriate
	 *         operation.
	 */

	@RequestMapping(value = "/client_delete", method = RequestMethod.GET)
	public String deleteClient(@RequestParam("id") int clientId, ModelMap model) {
		try {
			if (clientService.deleteClient(clientId)) {
				model.addAttribute("message", "Client details are successfully Deleted");
			} else {
				model.addAttribute("message", "Client details are not deleted");
			}
		} catch (DataException exception) {
			model.addAttribute("message", exception.getMessage());
		} finally {
			return "client";
		}
	}
	
	/**
	 * <p>
	 * Mapping the request which required by user for project.html it will
	 * sent the page and project list stored in database and model object to
	 * add new client
	 * </p>
	 * 
	 * @param model
	 *            ModelMap object used for setting Project model object,
	 *            project list and Client List
	 * @return contains url of project add page
	 * 
	 */
	@RequestMapping("/project")
	public String createProject(ModelMap model) {
		try {
			model.addAttribute("Project", new Project());
			model.addAttribute("ProjectList", projectService.getProjects());
			model.addAttribute("ClientList", clientService.displayClients());
		} catch (DataException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "project";
	}
	/**
	 * <p>
	 * This method passes the project detail as the model object into its
	 * Service class.
	 * </p>
	 * 
	 * @param clientId
	 *            contains identity of the Client it is used to many to one
	 *            map with project
	 * @param project
	 *            model object that stores the project data associated with
	 *            model.
	 * @return String returns the redirecting page url based on the appropriate
	 *         operation.
	 */
	@RequestMapping(value = "/project_insert", method = RequestMethod.POST)
	public String insertProject(@ModelAttribute("Project") Project project, BindingResult result,
			ModelMap model) {
		try {
			if (projectService.addProject(project)) {
				model.addAttribute("message", "Project details are successfully inserted");
			} else {
				model.addAttribute("message", "Project details are not inserted");
			}
		} catch (DataException exception) {
			model.addAttribute("message", exception.getMessage());
		} 
		return "project";
	}

	/**
	 * <p>
	 * This method passes is used for AJAX to get the project list for the
	 * given client
	 * </p>
	 * 
	 * @param clientId
	 *            contains identity of the Client it is used to many to one
	 *            map with project
	 * @param projectList
	 *            model object that stores the project List data associated
	 *            with model.
	 * @return String returns the redirecting page url based on the appropriate
	 *         operation.
	 */
	@RequestMapping(value = "/projectView", method = RequestMethod.GET)
	public String projectView(@RequestParam("clientId") int clientId, ModelMap map) {
		try {
			map.addAttribute("ProjectList", projectService.getDesgignationByClient(clientId));
		} catch (DataException exception)  {
			map.addAttribute("message", exception.getMessage());
		}
		return "projectView";

	}

	/**
	 * <p>
	 * Mapping the request which required by user for project_edit.html it
	 * will sent the page and required project object stored in database for
	 * edit.
	 * </p>
	 * 
	 * @param model
	 *            ModelMap object used for setting Project model object and
	 *            Client List
	 * @return contains url of project edit page
	 * 
	 */
	@RequestMapping(value = "/project_edit", method = RequestMethod.GET)
	public String editProject(@RequestParam("id") int projectId, ModelMap model) {
		try {
			model.addAttribute("ProjectEdit", projectService.searchProject(projectId));
			model.addAttribute("ClientList", clientService.displayClients());
		} catch (DataException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "project";
	}

	/**
	 * <p>
	 * This method passes the project detail as the model object into its
	 * Service class.
	 * </p>
	 * 
	 * @param project
	 *            model object that update the records in stored in database.
	 * @param clientId
	 *            contains identity of the Client it is used to many to one
	 *            map with project
	 * @param model
	 *            ModelMap object used for send message to the user.
	 * @return String returns the redirecting page url based on the appropriate
	 *         operation.
	 */
	@RequestMapping(value = "/project_update", method = RequestMethod.POST)
	public String updateClient(@ModelAttribute("ProjectEdit") Project project, BindingResult result,
			@RequestParam("client") int clientId, ModelMap model) {
		try {
			project.setClient(clientService.searchClient(clientId));
			if (projectService.updateProject(project)) {
				model.addAttribute("message", "Project details are successfully Updated");
			} else {
				model.addAttribute("message", "Project details are not updated");
			}
		} catch (DataException exception) {
			model.addAttribute("message", exception.getMessage());
		} 
		return "project";
	}

	/**
	 * <p>
	 * This method passes the project id as the parameter object into its
	 * Service class for delete the record.
	 * </p>
	 * 
	 * @param projectid
	 *            contains Identity of project used for delete the record
	 * @param model
	 *            ModelMap object used for send message to the user the message
	 *            will be success or failure.
	 * @return String returns the redirecting page url based on the appropriate
	 *         operation.
	 */
	@RequestMapping(value = "/project_delete", method = RequestMethod.GET)
	public String deleteProject(@RequestParam("id") int projectId, ModelMap model) {
		try {
			if (projectService.deleteProject(projectId)) {
				model.addAttribute("message", "Project details are successfully Deleted");
			} else {
				model.addAttribute("message", "Project details are not deleted");
			}
		} catch (DataException exception) {
			model.addAttribute("message", exception.getMessage());
		} 
		return "project";
	}
}
