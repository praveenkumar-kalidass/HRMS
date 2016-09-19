package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.util.FileUtil;
import com.i2i.connection.HibernateConnection;
import com.i2i.exception.DataException;
import com.i2i.model.ProjectRelease;

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
public class ProjectReleaseDao {
	private HibernateConnection hibernateConnection = HibernateConnection.createObject();
	SessionFactory factory = hibernateConnection.establishConnection();

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
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(projectRelease);
			transaction.commit();
			return true;
		} catch (HibernateException exception) {
			exception.printStackTrace();
			FileUtil.ErrorLogger("Exception in insertProjectRelease() : " + exception.getMessage());
			throw new DataException("Error while adding ProjectRelease ID : " + projectRelease.getReleaseId());
		} finally {
			session.close();
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
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.update(projectRelease);
			transaction.commit();
			return true;
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in modifyProjectRelease() : " + exception.getMessage());
			throw new DataException("Error while updating ProjectRelease ID : " + projectRelease.getReleaseId());
		} finally {
			session.close();
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
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.delete(projectRelease);
			transaction.commit();
			return true;
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in removeEmployee() : " + exception.getMessage());
			throw new DataException("Error while deleting ProjectRelease ID : " + projectRelease.getReleaseId());
		} finally {
			session.close();
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
		Session session = factory.openSession();
		try {
			return (ProjectRelease) session.get(ProjectRelease.class, projectReleaseId);
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in findProjectRelease() : " + exception.getMessage());
			throw new DataException("Error while searching ProjectRelease ID : " + projectReleaseId);
		} finally {
			session.close();
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
		Session session = factory.openSession();
		try {
			return session.createCriteria(ProjectRelease.class).list();
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in retrieveProjectReleases() : " + exception.getMessage());
			throw new DataException("Error while displaying all ProjectReleases");
		} finally {
			session.close();
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
	 * @return ProjectRelease.List return the list of designation which is stored
	 *         under the given project
	 */
	public List<ProjectRelease> retrieveProjectReleaseByProject(int projectId) throws DataException {
		Session session = factory.openSession();
		try {
			return session.createQuery("From ProjectRelease WHERE project_id=" + projectId).list();
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in retrieveProjectReleaseByProject() : " + exception.getMessage());
			throw new DataException("Error while displaying all Relases");
		} finally {
			session.close();
		}
	}
}