package com.i2i.service;

import java.util.List;

import com.i2i.dao.ProjectReleaseDao;
import com.i2i.exception.DataException;
import com.i2i.model.ProjectRelease;

/**
 * <p>
 * Service class which does validations with the user input of projectRelease
 * details. Passes values to the Dao class to carry out manipulations. Throws
 * error messages in case of occurrence of any exceptions.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-09-09
 */
public class ProjectReleaseService {
    ProjectReleaseDao projectReleaseDao = new ProjectReleaseDao();

    /**
     * <p>
     * This method Passes the values to its dao class to insert into the
     * database.
     * </p>
     * 
     * @param projectRelease
     *            model object that stores the projectRelease data associated
     *            with model.
     * @return boolean gives the status of the insertion into the database.
     * @throws DataException
     *             throws error message if problem arises with inserting the
     *             data in the database.
     */
    public boolean addProjectRelease(ProjectRelease projectRelease) throws DataException {
        return projectReleaseDao.insertProjectRelease(projectRelease);
    }

    /**
     * <p>
     * This method Passes the values to its dao class to update the existing
     * projectRelease in the database.
     * </p>
     * 
     * @param projectRelease
     *            model object that stores the projectRelease data associated
     *            with model.
     * @return boolean gives the status of the update from the database.
     * @throws DataException
     *             throws error message if problem arises with updating the data
     *             in the database.
     */
    public boolean updateProjectRelease(ProjectRelease projectRelease) throws DataException {
        return projectReleaseDao.modifyProjectRelease(projectRelease);
    }

    /**
     * <p>
     * This method checks the presence of projectRelease ID in the database.
     * Passes the value to its dao class to delete if present.
     * </p>
     * 
     * @param projectReleaseId
     *            contains the ID of the projectRelease.
     * @return boolean gives the status of the deletion from the database.
     * @throws DataException
     *             throws error message if problem arises with deleting the data
     *             in the database.
     */
    public boolean deleteProjectRelease(int projectReleaseId) throws DataException {
        if (projectReleaseDao.findProjectRelease(projectReleaseId) != null) {
            return projectReleaseDao.removeProjectRelease(searchProjectRelease(projectReleaseId));
        }
        return false;
    }

    /**
     * <p>
     * This method passes the projectRelease ID to its dao class to search in
     * the database. Returns the model object of the projectRelease to its
     * controller to display.
     * </p>
     *
     * @param projectReleaseId
     *            contains the ID of the projectRelease.
     * @return object gives the appropriate projectRelease object for the
     *         corresponding projectRelease ID.
     * @throws DataException
     *             throws error message if problem arises with searching the
     *             data in the database.
     */
    public ProjectRelease searchProjectRelease(int projectReleaseId) throws DataException {
        return projectReleaseDao.findProjectRelease(projectReleaseId);
    }

    /**
     * <p>
     * This method retrieves the ProjectRelease data from the records and
     * returns the list of data to display.
     * </p>
     * 
     * @return list Gives the list of projectRelease details retrieved from the
     *         database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */
    public List<ProjectRelease> getProjectReleases() throws DataException {
        return projectReleaseDao.retrieveProjectReleases();
    }
    
    /**
     * <p>
     * This method retrieves the ProjectRelease data for given project from the
     * records and returns the list of data to display.
     * </p>
     * 
     * @param projectId
     *            contains the ID of the project.
     * @return list Gives the list of projectRelease details for given projectId
     *         retrieved from the database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */
    public List<ProjectRelease> getProjectReleaseByProject(int projectId) throws DataException {
        return projectReleaseDao.retrieveProjectReleaseByProject(projectId);
    }
}
