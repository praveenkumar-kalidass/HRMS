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
import com.i2i.model.ProjectRelease;
import com.i2i.model.Team;
import com.i2i.model.Project;
import com.i2i.service.ClientService;
import com.i2i.service.DepartmentService;
import com.i2i.service.ProjectReleaseService;
import com.i2i.service.ProjectService;
import com.i2i.service.TeamService;

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
    ProjectReleaseService projectReleaseService = new ProjectReleaseService();
    TeamService teamService = new TeamService();
    DepartmentService departmentService = new DepartmentService();
    
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
            model.addAttribute("Client", new Client());
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
                model.addAttribute("message", "Client Successfully Added");
            } else {
                model.addAttribute("message", "Client not Added");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } 
        return "client";
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
        } 
        return "client";
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
                model.addAttribute("message", "Client successfully Deleted");
            } else {
                model.addAttribute("message", "Client not deleted");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } 
        return "client";
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
                model.addAttribute("message", "Project successfully Added");
            } else {
                model.addAttribute("message", "Project not Added");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } 
        return "project";
    }

    

    /**
     * <p>
     * Mapping the request which required by user for project_view.html it
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
    @RequestMapping(value = "/project_view", method = RequestMethod.GET)
    public String viewProject(@RequestParam("id") int projectId, ModelMap model) {
        try {
            model.addAttribute("Project", projectService.searchProject(projectId));
            model.addAttribute("ReleaseList", projectReleaseService.getProjectReleaseByProject(projectId));
            model.addAttribute("TeamList", teamService.getTeamByProject(projectId));
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
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
            model.addAttribute("ProjectId", projectId);
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "projectView";
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
                model.addAttribute("ProjectId", project.getProjectId());                
            } else {
                model.addAttribute("message", "Project details are not updated");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } 
        return "projectView";
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
    
    /**
     * <p>
     * Mapping the request which required by user for projectRelease.html it will
     * sent the page and projectRelease list stored in database and model object to
     * add new project
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting ProjectRelease model object,
     *            projectRelease list and Project List
     * @return contains url of projectRelease add page
     * 
     */
    @RequestMapping(value = "/projectrelease", method = RequestMethod.GET)
    public String createProjectRelease(@RequestParam("id") int projectId, ModelMap model) {
        try {
            model.addAttribute("ProjectRelease", new ProjectRelease());    
            model.addAttribute("ProjectId", projectId);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "projectView";
    }

    /**
     * <p>
     * This method passes the projectRelease detail as the model object into its
     * Service class.
     * </p>
     * 
     * @param projectId
     *            contains identity of the Project it is used to many to one
     *            map with projectRelease
     * @param projectRelease
     *            model object that stores the projectRelease data associated with
     *            model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/projectRelease_insert", method = RequestMethod.POST)
    public String insertProjectRelease(@ModelAttribute("ProjectRelease") ProjectRelease projectRelease, BindingResult result,
            ModelMap model) {
        try {
            if (projectReleaseService.addProjectRelease(projectRelease)) {
                model.addAttribute("message", "ProjectRelease details are successfully inserted");
                model.addAttribute("ProjectId", (projectRelease.getProject()).getProjectId());
            } else {
                model.addAttribute("message", "ProjectRelease details are not inserted");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } 
        return "projectView";
    }

    /**
     * <p>
     * Mapping the request which required by user for projectRelease_edit.html it
     * will sent the page and required projectRelease object stored in database for
     * edit.
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting ProjectRelease model object and
     *            Project List
     * @return contains url of projectRelease edit page
     * 
     */
    @RequestMapping(value = "/projectRelease_edit", method = RequestMethod.GET)
    public String editProjectRelease(@RequestParam("id") int projectReleaseId, ModelMap model) {
        try {
            model.addAttribute("ProjectReleaseEdit", projectReleaseService.searchProjectRelease(projectReleaseId));
            model.addAttribute("ProjectList", projectService.getProjects());
        } catch (DataException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "projectView";
    }

    /**
     * <p>
     * This method passes the projectRelease detail as the model object into its
     * Service class.
     * </p>
     * 
     * @param projectRelease
     *            model object that update the records in stored in database.
     * @param projectId
     *            contains identity of the Project it is used to many to one
     *            map with projectRelease
     * @param model
     *            ModelMap object used for send message to the user.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/projectRelease_update", method = RequestMethod.POST)
    public String updateProject(@ModelAttribute("ProjectReleaseEdit") ProjectRelease projectRelease, BindingResult result, ModelMap model) {
        try {            
            if (projectReleaseService.updateProjectRelease(projectRelease)) {
                model.addAttribute("message", "ProjectRelease details are successfully Updated");
                model.addAttribute("ProjectId", (projectRelease.getProject()).getProjectId());
            } else {
                model.addAttribute("message", "ProjectRelease details are not updated");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } 
        return "projectView";
    }

    /**
     * <p>
     * This method passes the projectRelease id as the parameter object into its
     * Service class for delete the record.
     * </p>
     * 
     * @param projectReleaseid
     *            contains Identity of projectRelease used for delete the record
     * @param model
     *            ModelMap object used for send message to the user the message
     *            will be success or failure.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/projectRelease_delete", method = RequestMethod.GET)
    public String deleteProjectRelease(@RequestParam("id") int projectReleaseId, ModelMap model) {
        try {
            ProjectRelease projectRelease = projectReleaseService.searchProjectRelease(projectReleaseId);
            if (projectReleaseService.deleteProjectRelease(projectReleaseId)) {
                model.addAttribute("message", "ProjectRelease details are successfully Deleted");
                model.addAttribute("ProjectId", (projectRelease.getProject()).getProjectId());
            } else {
                model.addAttribute("message", "ProjectRelease details are not deleted");
            }
        } catch (DataException exception) {
        } 
        return "projectView";
    }
    
    /**
     * <p>
     * Mapping the request which required by user for projectView.html it will
     * sent the page and team list stored in database and model object to
     * add new project
     * </p>
     * 
     * @param model
     *            ModelMap object used for setting Team model object,
     *            projectRelease list and Project List
     * @return contains url of team Member add page
     * 
     */
    @RequestMapping(value = "/team", method = RequestMethod.GET)
    public String createTeamMember(@RequestParam("id") int projectId, ModelMap model) {
        try {
            model.addAttribute("TeamAdd", new Team());    
            model.addAttribute("ProjectId", projectId);
            model.addAttribute("DepartmentList", departmentService.displayDepartments());
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "projectView";
    }
    
    /**
     * <p>
     * This method passes the team detail as the model object into its
     * Service class.
     * </p>
     * 
     * @param projectId
     *            contains identity of the Project it is used to many to one
     *            map with projectRelease
     * @param projectRelease
     *            model object that stores the projectRelease data associated with
     *            model.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/team_insert", method = RequestMethod.POST)
    public String insertTeam(@ModelAttribute("TeamAdd") Team team, BindingResult result,
            ModelMap model) {
        try {
            if (teamService.addTeam(team)) {
                model.addAttribute("message", "Employee are successfully allocated");
                model.addAttribute("ProjectId", (team.getProject()).getProjectId());
            } else {
                model.addAttribute("message", "Employee details are not allocated");
            }
        } catch (DataException exception) {
            model.addAttribute("message", exception.getMessage());
        } 
        return "projectView";
    }
    
    /**
     * <p>
     * This method passes the team id as the parameter object into its
     * Service class for delete the record.
     * </p>
     * 
     * @param team
     *            contains Identity of team used for delete the record
     * @param model
     *            ModelMap object used for send message to the user the message
     *            will be success or failure.
     * @return String returns the redirecting page url based on the appropriate
     *         operation.
     */
    @RequestMapping(value = "/team_delete", method = RequestMethod.GET)
    public String deleteTeam(@RequestParam("id") int teamId, ModelMap model) {
        try {
            Team team = teamService.searchTeam(teamId);
            if (teamService.deleteTeam(teamId)) {
                model.addAttribute("message", "Team Member deallocated Successfully");
                model.addAttribute("ProjectId", (team.getProject()).getProjectId());
            } else {
                model.addAttribute("message", "Team Membe are not deallocated");
            }
        } catch (DataException exception) {
        } 
        return "projectView";
    }
}
