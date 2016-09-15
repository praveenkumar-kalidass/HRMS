package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.model.AllowanceVariant;
import com.i2i.Util.FileUtil;
import com.i2i.connection.HibernateConnection;
import com.i2i.exception.DataException;

/**
 * <p>
 * DataAccessObject(Dao) for AllowanceVariant model is used to insert, update and
 * delete allowanceVariant from designation. Creates session and transaction objects
 * for each operation
 * </p>
 * 
 * @author Praveen RaJ
 * 
 * @created 2016-09-01
 */
public class AllowanceVariantDao {
	AllowanceVariant allowanceVariant = new AllowanceVariant();
	HibernateConnection hibernateConnection = HibernateConnection.createObject();
	SessionFactory sessionFactory = hibernateConnection.establishConnection();

	/**
	 * *
	 * <p>
	 * Method is used to insert new allowanceVariant create a new session and Inserts
	 * the model object of the allowanceVariant into the database.
	 * </p>
	 * 
	 * @param allowanceVariant
	 *            model object that stores the allowanceVariant data associated with
	 *            model class.
	 * @throws DataException
	 *             if any database connection error occurred error message will
	 *             be logged and send context info to user
	 * @return if inserted successfully true will be return to the Calling
	 *         method
	 */
	public boolean insertAllowanceVariant(AllowanceVariant allowanceVariant) throws DataException {
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(allowanceVariant);
			transaction.commit();
			return true;
		} catch (HibernateException ex) {
			FileUtil.ErrorLogger("Error on AllowanceVariantDao insertAllowanceVariant() : " + ex.toString());
			throw new DataException("Error Occured while Inserting this" + allowanceVariant.getId()
					+ " : please verify your details... Any try again..!");
		} finally {
			session.close();
		}
	}

	/**
	 * *
	 * <p>
	 * Method is used to update existing allowanceVariant create a new session and
	 * update the model object of the allowanceVariant from the database.
	 * </p>
	 * 
	 * @param allowanceVariant
	 *            model object that stores the allowanceVariant data associated with
	 *            model class.
	 * @throws DataException
	 *             if any database connection error occurred error message will
	 *             be logged and send context info to user
	 * @return if updated successfully true will be return to the Calling method
	 */
	public boolean modifyAllowanceVariant(AllowanceVariant allowanceVariant) throws DataException {
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.update(allowanceVariant);
			transaction.commit();
			return true;
		} catch (HibernateException ex) {
			FileUtil.ErrorLogger("Error on AllowanceVariantDao modifyAllowanceVariant() : " + ex.toString());
			throw new DataException("Error Occured while Updating this" + allowanceVariant.getId()
					+ " : please verify your details... Any try again..!");
		} finally {
			session.close();
		}
	}

	/**
	 * *
	 * <p>
	 * Method is used to delete existing allowanceVariant create a new session and
	 * Inserts the model object of the allowanceVariant into the database.
	 * </p>
	 * 
	 * @param allowanceVariant
	 *            model object that stores the allowanceVariant data associated with
	 *            model class.
	 * @throws DataException
	 *             if any database connection error occurred error message will
	 *             be logged and send context info to user
	 * @return if inserted successfully true will be return to the Calling
	 *         method
	 */
	public boolean removeAllowanceVariant(AllowanceVariant allowanceVariant) throws DataException {
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.delete(allowanceVariant);
			transaction.commit();
			return true;
		} catch (HibernateException ex) {
			FileUtil.ErrorLogger("Error on AllowanceVariantDao insertAllowanceVariant() : " + ex.toString());
			throw new DataException("Error Occured while Adding this" + allowanceVariant.getId()
					+ " : please verify your details... Any try again..!");
		} finally {
			session.close();
		}

	}

	/**
	 * <p>
	 * this method searches the allowanceVariant from the records using allowanceVariant
	 * ID and returns the data as a model object to display.
	 * </p>
	 * 
	 * @param allowanceVariantId
	 *            contains the ID of the allowanceVariant.
	 * @throws DataException
	 *             throws error message if problem arises with searching the
	 *             data in the database, error will stored in log file and
	 *             context message to user.
	 * @return AllowanceVariant return the required allowanceVariant object model contains
	 *         allowanceVariant info.
	 */
	public AllowanceVariant findAllowanceVariantById(int allowanceVariantId) throws DataException {
		Session session = sessionFactory.openSession();
		try {
			return (AllowanceVariant) session.get(AllowanceVariant.class, allowanceVariantId);
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in findEmployee() : " + exception.getMessage());
			throw new DataException("Error while searching Designation ID : " + allowanceVariantId);
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method retrieves the allowanceVariant data from the records and returns
	 * the list of data.
	 * </p>
	 * 
	 * @param allowanceVariantId
	 *            contains identity of the allowanceVariant
	 * @throws com.i2i.exception.DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 * @return AllowanceVariant.List return the full list of allowanceVariant stored in
	 *         database
	 */
	public List<AllowanceVariant> retrieveAllowanceVariants() throws DataException {
		Session session = sessionFactory.openSession();
		try {
			return session.createCriteria(AllowanceVariant.class).list();
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in retrieveEmployees() : " + exception.getMessage());
			throw new DataException("Error while displaying all Designations");
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method retrieves the allowanceVariant data from the records and returns
	 * the list of data.
	 * </p>
	 * 
	 * @param allowanceVariantId
	 *            contains identity of the allowanceVariant
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 * @return AllowanceVariant.List return the list of allowanceVariant which is stored
	 *         under the given designation
	 */
	public AllowanceVariant retrieveAllowanceVariantByDesignation(int designationId) throws DataException {
		Session session = sessionFactory.openSession();
		try {
			AllowanceVariant allowanceVarient = null;
			List<AllowanceVariant> allowanceList =  session.createQuery("From AllowanceVariant WHERE designation_id=" + designationId).list();
			for(AllowanceVariant allowance :allowanceList ){
				allowanceVarient = allowance;
			}
			return allowanceVarient;
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in retrieveEmployees() : " + exception.getMessage());
			throw new DataException("Error while displaying all Education");
		} finally {
			session.close();
		}
	}
}