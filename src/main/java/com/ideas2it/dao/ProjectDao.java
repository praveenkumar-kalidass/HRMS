package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Project;

public interface ProjectDao {

    /**
     * Add new Project
     *
     * @return True or Fales
     */
    boolean insertProject(Project project) throws DataException;

    /**
     * Update existing Project
     *
     * @return True or Fales
     */
    boolean modifyProject(Project project) throws DataException;

    /**
     * Delete Project
     *
     * @return True or Fales
     */
    boolean removeProject(Project project) throws DataException;

    /**
     * Search given Project
     *
     * @return Project
     */
    Project findProjectById(int projectId) throws DataException;

    /**
     * Retrive All Project
     *
     * @return list
     */
    List<Project> retrieveProjects() throws DataException;

    /**
     * Retrive All Project given Clien
     *
     * @return list
     */
    List<Project> retrieveProjectByClient(int clientId) throws DataException;
}
