package com.ideas2it.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ideas2it.util.FileUtil;
import com.ideas2it.dao.ProjectReleaseDao;
import com.ideas2it.exception.DataException;
import com.ideas2it.model.ProjectRelease;

/**
 * <p>
 * Dao(Data Access Object) class which establishes session with the database and
 * performs operation on manipulation of records associated with
 * ProjectReleases.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-09-09
 */
@Repository("projectReleaseDao")
@Transactional
public class ProjectReleaseDaoHibernate extends GenericDaoHibernate<ProjectRelease, Long> implements ProjectReleaseDao {
	/**
     * Constructor to create a Generics-based version using Project Release as the entity
     */
    public ProjectReleaseDaoHibernate() {
        super(ProjectRelease.class);
    }

    /**
     * <p>
     * This method opens a new session and Inserts the model object of the
     * projectRelease into the database.
     * </p>
     * 
     * @param projectRelease
     *            model object that stores the projectRelease data associated
     *            with model class.
     * @return true Gives the success status of the insertion process.
     * @throws DataException
     *             throws error message if problem arises with inserting the
     *             data in the database.
     */
    public boolean insertProjectRelease(ProjectRelease projectRelease) throws DataException {
        try {
            Session session = getSession();
            session.save(projectRelease);
            return true;
        } catch (HibernateException exception) {
            exception.printStackTrace();
            FileUtil.errorLogger("Exception in insertProjectRelease() : " + exception.getMessage());
            throw new DataException("Error while adding ProjectRelease ID : " + projectRelease.getReleaseId());
        }
    }

    /**
     * <p>
     * This method opens a new session and modifies the model object of the
     * projectRelease in the database.
     * </p>
     * 
     * @param projectRelease
     *            model object that stores the projectRelease data associated
     *            with model class.
     * @return true Gives the success status of the updation process.
     * @throws DataException
     *             throws error message if problem arises with updating the data
     *             in the database.
     */
    public boolean modifyProjectRelease(ProjectRelease projectRelease) throws DataException {
        try {
            Session session = getSession();
            session.update(projectRelease);
            return true;
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in modifyProjectRelease() : " + exception.getMessage());
            throw new DataException("Error while updating ProjectRelease ID : " + projectRelease.getReleaseId());
        }
    }

    /**
     * <p>
     * This method opens a new session and Deletes the projectRelease from the
     * records.
     * </p>
     * 
     * @param projectRelease
     *            model object that stores the projectRelease data associated
     *            with model class.
     * @return true Gives the success status of the deletion process.
     * @throws DataException
     *             throws error message if problem arises with deleting the data
     *             in the database.
     */
    public boolean removeProjectRelease(ProjectRelease projectRelease) throws DataException {
        try {
            Session session = getSession();
            session.delete(projectRelease);
            return true;
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in removeProjectRelease() : " + exception.getMessage());
            throw new DataException("Error while deleting ProjectRelease ID : " + projectRelease.getReleaseId());
        }
    }

    /**
     * <p>
     * This method searches the projectRelease from the records using
     * projectRelease ID and returns the data as a model object to display.
     * </p>
     * 
     * @param departementId
     *            contains the ID of the projectRelease.
     * @return object gives the appropriate projectRelease detail for the
     *         corresponding projectRelease ID.
     * @throws DataException
     *             throws error message if problem arises with searching the
     *             data in the database.
     */
    public ProjectRelease findProjectRelease(int projectReleaseId) throws DataException {
        try {
            Session session = getSession();
            return (ProjectRelease) session.get(ProjectRelease.class, projectReleaseId);
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in findProjectRelease() : " + exception.getMessage());
            throw new DataException("Error while searching ProjectRelease ID : " + projectReleaseId);
        }
    }

    /**
     * <p>
     * This method retrieves the projectRelease data from the records and
     * returns the list of data.
     * </p>
     * 
     * @return list Gives the list of projectRelease details stored in the
     *         database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */
    public List<ProjectRelease> retrieveProjectReleases() throws DataException {
        try {
            Session session = getSession();
            return session.createCriteria(ProjectRelease.class).list();
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in retrieveProjectReleases() : " + exception.getMessage());
            throw new DataException("Error while displaying all ProjectReleases");
        }
    }

    /**
     * <p>
     * This method retrieves the designation data from the records and returns
     * the list of data.
     * </p>
     * 
     * @param designationId
     *            contains identity of the designation
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     * @return ProjectRelease.List return the list of designation which is
     *         stored under the given project
     */
    public List<ProjectRelease> retrieveProjectReleaseByProject(int projectId) throws DataException {
        try {
            Session session = getSession();
            return session.createQuery("From ProjectRelease WHERE project_id=" + projectId).list();
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in retrieveProjectReleaseByProject() : " + exception.getMessage());
            throw new DataException("Error while displaying all Relases");
        }
    }
}
