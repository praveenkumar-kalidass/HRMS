package com.ideas2it.service;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Client;

public interface ClientService {

    /**
     * Add new Client
     *
     * @return True or False
     */
    public boolean addClient(Client client) throws DataException;

    /**
     * Update existing Client
     *
     * @return True or False
     */
    public boolean updateClient(Client client) throws DataException;

    /**
     * Delete Client
     *
     * @return True or False
     */
    public boolean deleteClient(int clientId) throws DataException;

    /**
     * Search given Client
     *
     * @return Client
     */
    public Client searchClient(int clientId) throws DataException;

    /**
     * Retrieve All Clients
     *
     * @return list
     */
    public List<Client> displayClients() throws DataException;
}
