package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.ProjectRelease;

public interface ProjectReleaseDao extends GenericDao<ProjectRelease, Long> {
	boolean insertProjectRelease(ProjectRelease projectRelease) throws DataException;
	boolean modifyProjectRelease(ProjectRelease projectRelease) throws DataException;
	boolean removeProjectRelease(ProjectRelease projectRelease) throws DataException;
	ProjectRelease findProjectRelease(int projectReleaseId) throws DataException;
	List<ProjectRelease> retrieveProjectReleases() throws DataException;
	List<ProjectRelease> retrieveProjectReleaseByProject(int projectId) throws DataException;

}
