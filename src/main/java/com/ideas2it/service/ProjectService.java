package com.ideas2it.service;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Project;

public interface ProjectService {

	/**
	 * Add new Project
	 *
	 * @return True or Fales
	 */
	public boolean addProject(Project project) throws DataException;

	/**
	 * Update existing Project
	 *
	 * @return True or Fales
	 */
	public boolean updateProject(Project project) throws DataException;

	/**
	 * Delete Project
	 *
	 * @return True or Fales
	 */
	public boolean deleteProject(int projectId) throws DataException;

	/**
	 * Search given Project
	 *
	 * @return Project
	 */
	public Project searchProject(int projectId) throws DataException;

	/**
	 * Retrive All Project
	 *
	 * @return list
	 */
	public List<Project> getProjects() throws DataException;

	/**
	 * Retrive All Project given Clien
	 *
	 * @return list
	 */
	public List<Project> getDesgignationByClient(int clientId) throws DataException;
}
