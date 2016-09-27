package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Address;

public interface AddressDao extends GenericDao<Address, Long> {

    /**
     * Add new address
     *
     * @return True or False
     */
    boolean insertAddress(Address address) throws DataException;

    /**
     * Update existing address
     *
     * @return True or False
     */
    boolean modifyAddress(Address address) throws DataException;

    /**
     * Delete address
     *
     * @return True or False
     */
    boolean removeAddress(Address address) throws DataException;

    /**
     * Search given address
     *
     * @return Address
     */
    Address findAddress(int addressId) throws DataException;

    /**
     * Retrieve All address
     *
     * @return list
     */
    List<Address> retrieveAddresss() throws DataException;

    /**
     * Retrieve address by given user
     *
     * @return list
     */
    List<Address> retrieveAddressByUser(long userId) throws DataException;
}
