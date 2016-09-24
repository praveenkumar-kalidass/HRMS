package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Client;

public interface ClientDao extends GenericDao<Client, Long>{
	boolean insertClient(Client client) throws DataException;
	boolean modifyClient(Client client) throws DataException;
	boolean removeClient(Client client) throws DataException;
	Client findClient(int clientId) throws DataException;
	List<Client> retrieveClients() throws DataException;
}
