package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.Util.FileUtil;
import com.i2i.connection.HibernateConnection;
import com.i2i.exception.DataException;
import com.i2i.model.Address;

/**
 * <p>
 * Dao(Data Access Object) class which establishes session with the database and
 * performs operation on manipulation of records associated with Employee
 * Addresss.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-09-02
 */

public class AddressDao {
	private HibernateConnection hibernateConnection = HibernateConnection.createObject();
	SessionFactory factory = hibernateConnection.establishConnection();

	/**
	 * <p>
	 * This method opens a new session and Inserts the model object of the
	 * address into the database.
	 * </p>
	 * 
	 * @param address
	 *            model object that stores the address data associated with
	 *            model class.
	 * @return true Gives the success status of the insertion process.
	 * @throws DataException
	 *             throws error message if problem arises with inserting the
	 *             data in the database.
	 */
	public boolean insertAddress(Address address) throws DataException {
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(address);
			transaction.commit();
			return true;
		} catch (HibernateException exception) {
			exception.printStackTrace();
			FileUtil.ErrorLogger("Exception in insertAddress() : " + exception.getMessage());
			throw new DataException("Error while adding Address ID : " + address.getAddressId());
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method opens a new session and Inserts the model object of the
	 * address into the database.
	 * </p>
	 * 
	 * @param address
	 *            model object that stores the address data associated with
	 *            model class.
	 * @return true Gives the success status of the insertion process.
	 * @throws DataException
	 *             throws error message if problem arises with inserting the
	 *             data in the database.
	 */
	public boolean modifyAddress(Address address) throws DataException {
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.update(address);
			transaction.commit();
			return true;
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in insertAddress() : " + exception.getMessage());
			throw new DataException("Error while adding Address ID : " + address.getAddressId());
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method opens a new session and Deletes the address from the records.
	 * </p>
	 * 
	 * @param addressId
	 *            contains the ID of the address.
	 * @return true Gives the success status of the deletion process.
	 * @throws DataException
	 *             throws error message if problem arises with deleting the data
	 *             in the database.
	 */
	public boolean removeAddress(Address address) throws DataException {
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.delete(address);
			transaction.commit();
			return true;
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in removeAddress() : " + exception.getMessage());
			throw new DataException("Error while deleting Address ID : " + address.getAddressId());
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method searches the address from the records using address ID and
	 * returns the data as a model object to display.
	 * </p>
	 * 
	 * @param departementId
	 *            contains the ID of the address.
	 * @return object gives the appropriate address detail for the corresponding
	 *         address ID.
	 * @throws DataException
	 *             throws error message if problem arises with searching the
	 *             data in the database.
	 */
	public Address findAddress(int addressId) throws DataException {
		Session session = factory.openSession();
		try {
			return (Address) session.get(Address.class, addressId);
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in findAddress() : " + exception.getMessage());
			throw new DataException("Error while searching Address ID : " + addressId);
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method retrieves the address data from the records and returns the
	 * list of data.
	 * </p>
	 * 
	 * @return list Gives the list of address details stored in the database.
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 */
	public List<Address> retrieveAddresss() throws DataException {
		Session session = factory.openSession();
		try {
			return session.createCriteria(Address.class).list();
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in retrieveAddresss() : " + exception.getMessage());
			throw new DataException("Error while displaying all Addresss");
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method retrieves the address data from the records and returns the
	 * list of data.
	 * </p>
	 * 
	 * @param employeeId
	 *            contains identity of the employee
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 * @return Address.List return the list of address which is stored under the
	 *         given employee
	 */
	public List<Address> retrieveAddressByEmployee(int employeeId) throws DataException {
		Session session = factory.openSession();
		try {
			return session.createQuery("From Address WHERE employee_id =" + employeeId).list();
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in retrieveCertifications() : " + exception.getMessage());
			throw new DataException("Error while displaying all Certification");
		} finally {
			session.close();
		}
	}
}