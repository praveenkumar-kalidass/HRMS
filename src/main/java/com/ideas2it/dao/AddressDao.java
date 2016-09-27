package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Address;

public interface AddressDao extends GenericDao<Address, Long> {

	/**
	 * Add new address
	 *
	 * @return True or Fales
	 */
	boolean insertAddress(Address address) throws DataException;

	/**
	 * Update existing address
	 *
	 * @return True or Fales
	 */
	boolean modifyAddress(Address address) throws DataException;

	/**
	 * Delete address
	 *
	 * @return True or Fales
	 */
	boolean removeAddress(Address address) throws DataException;

	/**
	 * Search given address
	 *
	 * @return Address
	 */
	Address findAddress(int addressId) throws DataException;

	/**
	 * Retrive All address
	 *
	 * @return list
	 */
	List<Address> retrieveAddresss() throws DataException;

	/**
	 * Retrive address by given user
	 *
	 * @return list
	 */
	List<Address> retrieveAddressByUser(long userId) throws DataException;
}
