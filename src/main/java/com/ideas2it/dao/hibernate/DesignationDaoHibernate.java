package com.ideas2it.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ideas2it.model.Department;
import com.ideas2it.model.Designation;
import com.ideas2it.util.FileUtil;
import com.ideas2it.dao.DesignationDao;
import com.ideas2it.exception.DataException;

/**
 * <p>
 * DataAccessObject(Dao) for Designation model is used to insert, update and
 * delete designation from department. Creates session and transaction objects
 * for each operation
 * </p>
 * 
 * @author Praveen RaJ
 * 
 * @created 2016-09-01
 */
@Repository("designationDao")
@Transactional
public class DesignationDaoHibernate extends GenericDaoHibernate<Designation, Long> implements DesignationDao  {

	public DesignationDaoHibernate() {
        super(Designation.class);
    }

	/**
	 * *
	 * <p>
	 * Method is used to insert new designation create a new session and Inserts
	 * the model object of the designation into the database.
	 * </p>
	 * 
	 * @param designation
	 *            model object that stores the designation data associated with
	 *            model class.
	 * @throws DataException
	 *             if any database connection error occurred error message will
	 *             be logged and send context info to user
	 * @return if inserted successfully true will be return to the Calling
	 *         method
	 */
	public boolean insertDesignation(Designation designation) throws DataException {
		 Session session = null;
	    	try {
	    	session = getSession();
			session.save(designation);
			return true;
		} catch (HibernateException ex) {
			FileUtil.errorLogger("Error on DesignationDao insertDesignation() : " + ex.toString());
			throw new DataException("Error Occured while Inserting this" + designation.getDesignationName()
					+ " : please verify your details... Any try again..!");
		} finally {
			session.clear();
		}
	}

	/**
	 * *
	 * <p>
	 * Method is used to update existing designation create a new session and
	 * update the model object of the designation from the database.
	 * </p>
	 * 
	 * @param designation
	 *            model object that stores the designation data associated with
	 *            model class.
	 * @throws DataException
	 *             if any database connection error occurred error message will
	 *             be logged and send context info to user
	 * @return if updated successfully true will be return to the Calling method
	 */
	public boolean modifyDesignation(Designation designation) throws DataException {
		 Session session = null;
	    	try {
	    	session = getSession();
			session.update(designation);
			return true;
		} catch (HibernateException ex) {
			FileUtil.errorLogger("Error on DesignationDao modifyDesignation() : " + ex.toString());
			throw new DataException("Error Occured while Updating this" + designation.getDesignationName()
					+ " : please verify your details... Any try again..!");
		} finally {
			session.clear();
		}
	}

	/**
	 * *
	 * <p>
	 * Method is used to delete existing designation create a new session and
	 * Inserts the model object of the designation into the database.
	 * </p>
	 * 
	 * @param designation
	 *            model object that stores the designation data associated with
	 *            model class.
	 * @throws DataException
	 *             if any database connection error occurred error message will
	 *             be logged and send context info to user
	 * @return if inserted successfully true will be return to the Calling
	 *         method
	 */
	public boolean removeDesignation(Designation designation) throws DataException {
		Session session = null;
		try {
			session = getSession();
			session.delete(designation);
			return true;
		} catch (HibernateException ex) {
			FileUtil.errorLogger("Error on DesignationDao removeDesignation() : " + ex.toString());
			throw new DataException("Error Occured while Removing this" + designation.getDesignationName()
					+ " : please verify your details... Any try again..!");
		} finally {
			session.clear();
		}

	}

	/**
	 * <p>
	 * this method searches the designation from the records using designation
	 * ID and returns the data as a model object to display.
	 * </p>
	 * 
	 * @param designationId
	 *            contains the ID of the designation.
	 * @throws DataException
	 *             throws error message if problem arises with searching the
	 *             data in the database, error will stored in log file and
	 *             context message to user.
	 * @return Designation return the required designation object model contains
	 *         designation info.
	 */
	public Designation findDesignationById(int designationId) throws DataException {
		Session session = null;
		try {
			session = getSession();
			return (Designation) session.get(Designation.class, designationId);
		} catch (HibernateException exception) {
			FileUtil.errorLogger("Exception in findDesignationById() : " + exception.getMessage());
			throw new DataException("Error while searching Department ID : " + designationId);
		} finally {
			session.clear();
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
	 * @throws com.i2i.exception.DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 * @return Designation.List return the full list of designation stored in
	 *         database
	 */
	public List<Designation> retrieveDesignations() throws DataException {
		Session session = null;
		try {
			session = getSession();
			return session.createCriteria(Designation.class).list();
		} catch (HibernateException exception) {
			FileUtil.errorLogger("Exception in retrieveDesignations() : " + exception.getMessage());
			throw new DataException("Error while displaying all Designation");
		} finally {
			session.clear();
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
	 * @return Designation.List return the list of designation which is stored
	 *         under the given department
	 */
	public List<Designation> retrieveDesignationByDepartment(int departmentId) throws DataException {
		Session session = null;
		try {
			session = getSession();
			return session.createQuery("From Designation WHERE department_id=" + departmentId).list();
		} catch (HibernateException exception) {
			FileUtil.errorLogger("Exception in retrieveDesignationByDepartment() : " + exception.getMessage());
			throw new DataException("Error while displaying all Designation");
		} finally {
			session.clear();
		}
	}
}