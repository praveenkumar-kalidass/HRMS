package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Project;

public interface ProjectDao {
	 boolean insertProject(Project project) throws DataException;
	 boolean modifyProject(Project project) throws DataException;
	 boolean removeProject(Project project) throws DataException;
	 Project findProjectById(int projectId) throws DataException;
	 List<Project> retrieveProjects() throws DataException;
	 List<Project> retrieveProjectByClient(int clientId) throws DataException;
}
