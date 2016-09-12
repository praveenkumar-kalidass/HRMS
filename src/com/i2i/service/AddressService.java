package com.i2i.service;

import java.util.List;

import com.i2i.dao.AddressDao;
import com.i2i.exception.DataException;
import com.i2i.model.Address;

/**
 * <p>
 * Service class which does validations with the user input of address details.
 * Passes values to the Dao class to carry out manipulations. Throws error
 * messages in case of occurrence of any exceptions.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-08-15
 */
public class AddressService {
	AddressDao addressDao = new AddressDao();

	/**
	 * <p>
	 * This method checks the presence of address ID in the database. Passes the
	 * value to its dao class to insert if not present.
	 * </p>
	 * 
	 * @param address
	 *            model object that stores the address data associated with
	 *            model.
	 * @return boolean gives the status of the insertion into the database.
	 * @throws DataException
	 *             throws error message if problem arises with inserting the
	 *             data in the database.
	 */
	public boolean addAddress(Address address) throws DataException {
		return addressDao.insertAddress(address);

	}

	/**
	 * <p>
	 * This method checks the presence of address ID in the database. Passes the
	 * value to its dao class to insert if not present.
	 * </p>
	 * 
	 * @param address
	 *            model object that stores the address data associated with
	 *            model.
	 * @return boolean gives the status of the insertion into the database.
	 * @throws DataException
	 *             throws error message if problem arises with inserting the
	 *             data in the database.
	 */
	public boolean updateAddress(Address address) throws DataException {
		return addressDao.modifyAddress(address);

	}

	/**
	 * <p>
	 * This method checks the presence of address ID in the database. Passes the
	 * value to its dao class to delete if present.
	 * </p>
	 * 
	 * @param addressId
	 *            contains the ID of the address.
	 * @return boolean gives the status of the deletion from the database.
	 * @throws DataException
	 *             throws error message if problem arises with deleting the data
	 *             in the database.
	 */
	public boolean deleteAddress(int addressId) throws DataException {
		if (addressDao.findAddress(addressId) != null) {
			return addressDao.removeAddress(searchAddress(addressId));
		}
		return false;
	}

	/**
	 * <p>
	 * This method passes the address ID to its dao class to search in the
	 * database. Returns the model object of the address to its controller to
	 * display.
	 * </p>
	 *
	 * @param addressId
	 *            contains the ID of the address.
	 * 
	 * @return object gives the appropriate address object for the corresponding
	 *         address ID.
	 * @throws DataException
	 *             throws error message if problem arises with searching the
	 *             data in the database.
	 */
	public Address searchAddress(int addressId) throws DataException {
		return addressDao.findAddress(addressId);
	}

	/**
	 * <p>
	 * This method retrieves the Address data from the records and returns the
	 * list of data to display.
	 * </p>
	 * 
	 * @return list Gives the list of address details retrieved from the
	 *         database.
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 */
	public List<Address> displayAddresss() throws DataException {
		return addressDao.retrieveAddresss();
	}

	/**
	 * <p>
	 * This method retrieves the Address data for given employee from the
	 * records and returns the list of data to display.
	 * </p>
	 * 
	 * @param employeeId
	 *            contains the ID of the employee.
	 * @return list Gives the list of address details for given departmentId
	 *         retrieved from the database.
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 */
	public List<Address> getAddressByEmployee(int employeeId) throws DataException {
		return addressDao.retrieveAddressByEmployee(employeeId);
	}
}