package com.ideas2it.service;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Address;

public interface AddressService {

	/**
	 * Add new address
	 *
	 * @return True or Fales
	 */
	public boolean addAddress(Address address) throws DataException;

	/**
	 * Update existing address
	 *
	 * @return True or Fales
	 */
	public boolean updateAddress(Address address) throws DataException;

	/**
	 * Delete address
	 *
	 * @return True or Fales
	 */
	public boolean deleteAddress(int addressId) throws DataException;

	/**
	 * Search given address
	 *
	 * @return Address
	 */
	public Address searchAddress(int addressId) throws DataException;

	/**
	 * Retrive All address
	 *
	 * @return list
	 */
	public List<Address> retriveAddresss() throws DataException;

	/**
	 * Retrive address by given user
	 *
	 * @return list
	 */
	public List<Address> getAddressByUser(long userId) throws DataException;
}
