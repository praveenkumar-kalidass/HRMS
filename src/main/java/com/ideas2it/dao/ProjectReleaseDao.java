package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.ProjectRelease;

public interface ProjectReleaseDao extends GenericDao<ProjectRelease, Long> {

    /**
     * Add new ProjectRelease
     *
     * @return True or False
     */
    boolean insertProjectRelease(ProjectRelease projectRelease) throws DataException;

    /**
     * Update existing ProjectRelease
     *
     * @return True or False
     */
    boolean modifyProjectRelease(ProjectRelease projectRelease) throws DataException;

    /**
     * Delete ProjectRelease
     *
     * @return True or False
     */
    boolean removeProjectRelease(ProjectRelease projectRelease) throws DataException;

    /**
     * Search given ProjectRelease
     *
     * @return ProjectRelease
     */
    ProjectRelease findProjectRelease(int projectReleaseId) throws DataException;

    /**
     * Retrieve All ProjectReleases
     *
     * @return list
     */
    List<ProjectRelease> retrieveProjectReleases() throws DataException;

    /**
     * Retrieve All ProjectReleases for Given project
     *
     * @return list
     */
    List<ProjectRelease> retrieveProjectReleaseByProject(int projectId) throws DataException;

}
