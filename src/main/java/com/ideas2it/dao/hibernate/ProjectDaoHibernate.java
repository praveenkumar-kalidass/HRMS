package com.ideas2it.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ideas2it.util.FileUtil;
import com.ideas2it.dao.ProjectDao;
import com.ideas2it.exception.DataException;
import com.ideas2it.model.Project;
import com.ideas2it.model.ProjectRelease;

/**
 * <p>
 * DataAccessObject(Dao) for Project model is used to insert, update and delete
 * project from client. Creates session and transaction objects for each
 * operation
 * </p>
 * 
 * @author Praveen RaJ
 * 
 * @created 2016-09-09
 */
@Repository("projectDao")
@Transactional
public class ProjectDaoHibernate extends GenericDaoHibernate<Project, Long> implements ProjectDao {

	public ProjectDaoHibernate() {
		super(Project.class);
	}

	/**
	 * *
	 * <p>
	 * Method is used to insert new project create a new session and Inserts the
	 * model object of the project into the database.
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
		try {
			Session session = getSession();
			session.save(project);
			return true;
		} catch (HibernateException ex) {
			FileUtil.errorLogger("Error on ProjectDao insertProject() : " + ex.toString());
			throw new DataException("Error Occured while Inserting this" + project.getProjectName()
					+ " : please verify your details... Any try again..!");
		}
	}

	/**
	 * *
	 * <p>
	 * Method is used to update existing project create a new session and update
	 * the model object of the project from the database.
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
		try {
			Session session = getSession();
			session.update(project);
			return true;
		} catch (HibernateException ex) {
			FileUtil.errorLogger("Error on ProjectDao modifyProject() : " + ex.toString());
			throw new DataException("Error Occured while Updating this" + project.getProjectName()
					+ " : please verify your details... Any try again..!");
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
		try {
			Session session = getSession();
			session.delete(project);
			return true;
		} catch (HibernateException ex) {
			FileUtil.errorLogger("Error on ProjectDao insertProject() : " + ex.toString());
			throw new DataException("Error Occured while Adding this" + project.getProjectName()
					+ " : please verify your details... Any try again..!");
		}
	}

	/**
	 * <p>
	 * this method searches the project from the records using project ID and
	 * returns the data as a model object to display.
	 * </p>
	 * 
	 * @param projectId
	 *            contains the ID of the project.
	 * @throws DataException
	 *             throws error message if problem arises with searching the
	 *             data in the database, error will stored in log file and
	 *             context message to user.
	 * @return Project return the required project object model contains project
	 *         info.
	 */
	public Project findProjectById(int projectId) throws DataException {
		try {
			Session session = getSession();
			return (Project) session.get(Project.class, projectId);
		} catch (HibernateException exception) {
			FileUtil.errorLogger("Exception in findEmployee() : " + exception.getMessage());
			throw new DataException("Error while searching Client ID : " + projectId);
		}
	}

	/**
	 * <p>
	 * This method retrieves the project data from the records and returns the
	 * list of data.
	 * </p>
	 * 
	 * @param projectId
	 *            contains identity of the project
	 * @throws com.i2i.exception.DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 * @return Project.List return the full list of project stored in database
	 */
	public List<Project> retrieveProjects() throws DataException {
		try {
			Session session = getSession();
			return session.createCriteria(Project.class).list();
		} catch (HibernateException exception) {
			FileUtil.errorLogger("Exception in retrieveEmployees() : " + exception.getMessage());
			throw new DataException("Error while displaying all Projects");
		}
	}

	/**
	 * <p>
	 * This method retrieves the project data from the records and returns the
	 * list of data.
	 * </p>
	 * 
	 * @param projectId
	 *            contains identity of the project
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 * @return Project.List return the list of project which is stored under the
	 *         given client
	 */
	public List<Project> retrieveProjectByClient(int clientId) throws DataException {
		try {
			Session session = getSession();
			return session.createQuery("From Project WHERE client_id=" + clientId).list();
		} catch (HibernateException exception) {
			FileUtil.errorLogger("Exception in retrieveEmployees() : " + exception.getMessage());
			throw new DataException("Error while displaying all Education");
		}
	}

}
