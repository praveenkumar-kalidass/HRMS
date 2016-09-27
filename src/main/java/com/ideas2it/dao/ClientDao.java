package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Client;

public interface ClientDao extends GenericDao<Client, Long> {

	/**
	 * Add new Client
	 *
	 * @return True or Fales
	 */
	boolean insertClient(Client client) throws DataException;

	/**
	 * Update existing Client
	 *
	 * @return True or Fales
	 */
	boolean modifyClient(Client client) throws DataException;

	/**
	 * Delete Client
	 *
	 * @return True or Fales
	 */
	boolean removeClient(Client client) throws DataException;

	/**
	 * Search given Client
	 *
	 * @return Client
	 */
	Client findClient(int clientId) throws DataException;

	/**
	 * Retrive All Client
	 *
	 * @return list
	 */
	List<Client> retrieveClients() throws DataException;
}
