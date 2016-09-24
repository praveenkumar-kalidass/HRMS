package com.ideas2it.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ideas2it.util.FileUtil;
import com.ideas2it.dao.EducationDao;
import com.ideas2it.exception.DataException;
import com.ideas2it.model.Designation;
import com.ideas2it.model.Education;

/**
 * <p>
 * DataAccessObject(Dao) for Designation model is used to insert, update and
 * delete education detail(s) for the user Creates session and transaction
 * objects for each operation
 * </p>
 * 
 * @author Praveen RaJ
 * 
 * @created 2016-09-06
 */
@Repository("educationDao")
@Transactional
public class EducationDaoHibernate extends GenericDaoHibernate<Education,Long> implements EducationDao {


	public EducationDaoHibernate() {
        super(Education.class);
    }

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
		Session session = null;
		try {
			session = getSession();
			session.save(education);
			return true;
		} catch (HibernateException ex) {
			FileUtil.errorLogger("Error on DesignationDao insertEducation() : " + ex.toString());
			throw new DataException("Error Occured while Inserting this" + education.getQualification()
					+ " : please verify your details... Any try again..!");
		} finally {
			session.clear();
		}
	}

	/**
	 * *
	 * <p>
	 * Method is used to update existing education details of the user
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
		Session session = null;
		try {
			session = getSession();
			session.update(education);
			return true;
		} catch (HibernateException ex) {
			FileUtil.errorLogger("Error on DesignationDao modifyEducation() : " + ex.toString());
			throw new DataException("Error Occured while Updating this" + education.getQualification()
					+ " : please verify your details... Any try again..!");
		} finally {
			session.clear();
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
		Session session = null;
		try {
			session = getSession();
			return (Education) session.get(Education.class, educationId);
		} catch (HibernateException exception) {
			FileUtil.errorLogger("Exception in findEducation() : " + exception.getMessage());
			throw new DataException("Error while searching Education ID : " + educationId);
		} finally {
			session.clear();
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
		Session session = null;
		try {
			session = getSession();
			return session.createCriteria(Education.class).list();
		} catch (HibernateException exception) {
			FileUtil.errorLogger("Exception in retriveEducation() : " + exception.getMessage());
			throw new DataException("Error while displaying all Education");
		} finally {
			session.clear();
		}
	}

	/**
	 * <p>
	 * This method retrieves the education data from the records and returns the
	 * list of data.
	 * </p>
	 * 
	 * @param userId
	 *            contains identity of the user
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 * @return Education.List return the list of education which is stored under
	 *         the given user
	 */
	public List<Education> retrieveEducationByUser(long userId) throws DataException {
		Session session = null;
		try {
			session = getSession();
			return session.createQuery("From Education WHERE user_id=" + userId).list();
		} catch (HibernateException exception) {
			FileUtil.errorLogger("Exception in retrieveUsers() : " + exception.getMessage());
			throw new DataException("Error while displaying all Education");
		} finally {
			session.clear();
		}
	}
}
