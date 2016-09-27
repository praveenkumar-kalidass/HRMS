package com.ideas2it.service;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Project;

public interface ProjectService {

    /**
     * Add new Project
     *
     * @return True or False
     */
    public boolean addProject(Project project) throws DataException;

    /**
     * Update existing Project
     *
     * @return True or False
     */
    public boolean updateProject(Project project) throws DataException;

    /**
     * Delete Project
     *
     * @return True or False
     */
    public boolean deleteProject(int projectId) throws DataException;

    /**
     * Search given Project
     *
     * @return Project
     */
    public Project searchProject(int projectId) throws DataException;

    /**
     * Retrieve All Project
     *
     * @return list
     */
    public List<Project> getProjects() throws DataException;

    /**
     * Retrieve All Project given Client
     *
     * @return list
     */
    public List<Project> getDesgignationByClient(int clientId) throws DataException;
}
