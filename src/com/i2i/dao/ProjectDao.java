package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.util.FileUtil;
import com.i2i.connection.HibernateConnection;
import com.i2i.exception.DataException;
import com.i2i.model.Project;

/**
 * <p>
 * DataAccessObject(Dao) for Project model is used to insert, update and
 * delete project from client. Creates session and transaction objects
 * for each operation
 * </p>
 * 
 * @author Praveen RaJ
 * 
 * @created 2016-09-09
 */
public class ProjectDao {
	Project project = new Project();
	HibernateConnection hibernateConnection = HibernateConnection.createObject();
	SessionFactory sessionFactory = hibernateConnection.establishConnection();

	/**
	 * *
	 * <p>
	 * Method is used to insert new project create a new session and Inserts
	 * the model object of the project into the database.
	 * </p>
	 * 
	 * @param project
	 *            model object that stores the project data associated with
	 *            model class.
	 * @throws DataException
	 *             if any database connection error occurred error message will
	 *             be logged and send context info to user
	 * @return if inserted successfully true will be return to the Calling
	 *         method
	 */
	public boolean insertProject(Project project) throws DataException {
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(project);
			transaction.commit();
			return true;
		} catch (HibernateException ex) {
			FileUtil.ErrorLogger("Error on ProjectDao insertProject() : " + ex.toString());
			throw new DataException("Error Occured while Inserting this" + project.getProjectName()
					+ " : please verify your details... Any try again..!");
		} finally {
			session.close();
		}
	}

	/**
	 * *
	 * <p>
	 * Method is used to update existing project create a new session and
	 * update the model object of the project from the database.
	 * </p>
	 * 
	 * @param project
	 *            model object that stores the project data associated with
	 *            model class.
	 * @throws DataException
	 *             if any database connection error occurred error message will
	 *             be logged and send context info to user
	 * @return if updated successfully true will be return to the Calling method
	 */
	public boolean modifyProject(Project project) throws DataException {
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.update(project);
			transaction.commit();
			return true;
		} catch (HibernateException ex) {
			FileUtil.ErrorLogger("Error on ProjectDao modifyProject() : " + ex.toString());
			throw new DataException("Error Occured while Updating this" + project.getProjectName()
					+ " : please verify your details... Any try again..!");
		} finally {
			session.close();
		}
	}

	/**
	 * *
	 * <p>
	 * Method is used to delete existing project create a new session and
	 * Inserts the model object of the project into the database.
	 * </p>
	 * 
	 * @param project
	 *            model object that stores the project data associated with
	 *            model class.
	 * @throws DataException
	 *             if any database connection error occurred error message will
	 *             be logged and send context info to user
	 * @return if inserted successfully true will be return to the Calling
	 *         method
	 */
	public boolean removeProject(Project project) throws DataException {
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.delete(project);
			transaction.commit();
			return true;
		} catch (HibernateException ex) {
			FileUtil.ErrorLogger("Error on ProjectDao insertProject() : " + ex.toString());
			throw new DataException("Error Occured while Adding this" + project.getProjectName()
					+ " : please verify your details... Any try again..!");
		} finally {
			session.close();
		}

	}

	/**
	 * <p>
	 * this method searches the project from the records using project
	 * ID and returns the data as a model object to display.
	 * </p>
	 * 
	 * @param projectId
	 *            contains the ID of the project.
	 * @throws DataException
	 *             throws error message if problem arises with searching the
	 *             data in the database, error will stored in log file and
	 *             context message to user.
	 * @return Project return the required project object model contains
	 *         project info.
	 */
	public Project findProjectById(int projectId) throws DataException {
		Session session = sessionFactory.openSession();
		try {
			return (Project) session.get(Project.class, projectId);
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in findEmployee() : " + exception.getMessage());
			throw new DataException("Error while searching Client ID : " + projectId);
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method retrieves the project data from the records and returns
	 * the list of data.
	 * </p>
	 * 
	 * @param projectId
	 *            contains identity of the project
	 * @throws com.i2i.exception.DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 * @return Project.List return the full list of project stored in
	 *         database
	 */
	public List<Project> retrieveProjects() throws DataException {
		Session session = sessionFactory.openSession();
		try {
			return session.createCriteria(Project.class).list();
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in retrieveEmployees() : " + exception.getMessage());
			throw new DataException("Error while displaying all Projects");
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method retrieves the project data from the records and returns
	 * the list of data.
	 * </p>
	 * 
	 * @param projectId
	 *            contains identity of the project
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 * @return Project.List return the list of project which is stored
	 *         under the given client
	 */
	public List<Project> retrieveProjectByClient(int clientId) throws DataException {
		Session session = sessionFactory.openSession();
		try {
			return session.createQuery("From Project WHERE client_id=" + clientId).list();
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in retrieveEmployees() : " + exception.getMessage());
			throw new DataException("Error while displaying all Education");
		} finally {
			session.close();
		}
	}

}
