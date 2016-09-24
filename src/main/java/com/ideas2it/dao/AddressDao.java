package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Address;

public interface AddressDao extends GenericDao<Address, Long>  {
	boolean insertAddress(Address address) throws DataException;
	boolean modifyAddress(Address address) throws DataException;
	boolean removeAddress(Address address) throws DataException;
	Address findAddress(int addressId) throws DataException;
	List<Address> retrieveAddresss() throws DataException;
	List<Address> retrieveAddressByUser(long userId) throws DataException;
}
