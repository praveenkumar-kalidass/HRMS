package com.ideas2it.service;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.ProjectRelease;

public interface ProjectReleaseService {

    /**
     * Add new ProjectRelease
     *
     * @return True or False
     */
    public boolean addProjectRelease(ProjectRelease projectRelease) throws DataException;

    /**
     * Update existing ProjectRelease
     *
     * @return True or False
     */
    public boolean updateProjectRelease(ProjectRelease projectRelease) throws DataException;

    /**
     * Delete ProjectRelease
     *
     * @return True or False
     */
    public boolean deleteProjectRelease(int projectReleaseId) throws DataException;

    /**
     * Search given ProjectRelease
     *
     * @return ProjectRelease
     */
    public ProjectRelease searchProjectRelease(int projectReleaseId) throws DataException;

    /**
     * Retrieve All ProjectReleases
     *
     * @return list
     */
    public List<ProjectRelease> retriveProjectReleases() throws DataException;

    /**
     * Retrieve All ProjectReleases for Given project
     *
     * @return list
     */
    public List<ProjectRelease> getProjectReleaseByProject(int projectId) throws DataException;
}
