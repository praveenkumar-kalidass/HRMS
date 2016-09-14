package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.Util.FileUtil;
import com.i2i.connection.HibernateConnection;
import com.i2i.exception.DataException;
import com.i2i.model.Education;

/**
 * <p>
 * DataAccessObject(Dao) for Designation model is used to insert, update and
 * delete education detail(s) for the employee Creates session and transaction
 * objects for each operation
 * </p>
 * 
 * @author Praveen RaJ
 * 
 * @created 2016-09-06
 */

public class EducationDao {

	Education education = new Education();
	HibernateConnection hibernateConnection = HibernateConnection.createObject();
	SessionFactory sessionFactory = hibernateConnection.establishConnection();

	/**
	 * *
	 * <p>
	 * Method is used to insert new Education create a new session and Inserts
	 * the model object of the Education into the database.
	 * </p>
	 * 
	 * @param education
	 *            model object that stores the Education data associated with
	 *            model class.
	 * @throws DataException
	 *             if any database connection error occurred error message will
	 *             be logged and send context info to user
	 * @return if inserted successfully true will be return to the Calling
	 *         method
	 */
	public boolean insertEducation(Education education) throws DataException {
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(education);
			transaction.commit();
			return true;
		} catch (HibernateException ex) {
			FileUtil.ErrorLogger("Error on DesignationDao insertEducation() : " + ex.toString());
			throw new DataException("Error Occured while Inserting this" + education.getQualification()
					+ " : please verify your details... Any try again..!");
		} finally {
			session.close();
		}
	}

	/**
	 * *
	 * <p>
	 * Method is used to update existing education details of the employee
	 * create a new session and update the model object of the education from
	 * the database.
	 * </p>
	 * 
	 * @param education
	 *            model object that stores the education data associated with
	 *            model class.
	 * @throws DataException
	 *             if any database connection error occurred error message will
	 *             be logged and send context info to user
	 * @return if updated successfully true will be return to the Calling method
	 */
	public boolean modifyEducation(Education education) throws DataException {
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.update(education);
			transaction.commit();
			return true;
		} catch (HibernateException ex) {
			FileUtil.ErrorLogger("Error on DesignationDao modifyEducation() : " + ex.toString());
			throw new DataException("Error Occured while Updating this" + education.getQualification()
					+ " : please verify your details... Any try again..!");
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * this method searches the education from the records using education ID
	 * and returns the data as a model object to display.
	 * </p>
	 * 
	 * @param educationId
	 *            contains the ID of the education.
	 * @throws DataException
	 *             throws error message if problem arises with searching the
	 *             data in the database, error will stored in log file and
	 *             context message to user.
	 * @return Designation return the required designation object model contains
	 *         designation info.
	 */
	public Education findEducationById(int educationId) throws DataException {
		Session session = sessionFactory.openSession();
		try {
			return (Education) session.get(Education.class, educationId);
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in findEducation() : " + exception.getMessage());
			throw new DataException("Error while searching Education ID : " + educationId);
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method retrieves the education data from the records and returns the
	 * list of data.
	 * </p>
	 * 
	 * @param educationId
	 *            contains identity of the education
	 * @throws com.i2i.exception.DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 * @return Designation.List return the full list of education stored in
	 *         database
	 */
	public List<Education> retrieveEducations() throws DataException {
		Session session = sessionFactory.openSession();
		try {
			return session.createCriteria(Education.class).list();
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in retriveEducation() : " + exception.getMessage());
			throw new DataException("Error while displaying all Education");
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method retrieves the education data from the records and returns the
	 * list of data.
	 * </p>
	 * 
	 * @param employeeId
	 *            contains identity of the employee
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 * @return Education.List return the list of education which is stored under
	 *         the given employee
	 */
	public List<Education> retrieveEducationByEmployee(int employeeId) throws DataException {
		Session session = sessionFactory.openSession();
		try {
			return session.createQuery("From Education WHERE employee_id=" + employeeId).list();
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in retrieveEmployees() : " + exception.getMessage());
			throw new DataException("Error while displaying all Education");
		} finally {
			session.close();
		}
	}
}
