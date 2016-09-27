package com.ideas2it.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.dao.ClientDao;
import com.ideas2it.exception.DataException;
import com.ideas2it.model.Certification;
import com.ideas2it.model.Client;
import com.ideas2it.service.CertificationService;
import com.ideas2it.service.ClientService;

/**
 * <p>
 * Service class which does validations with the user input of client details.
 * Passes values to the Dao class to carry out manipulations. Throws error
 * messages in case of occurrence of any exceptions.
 * </p>
 *
 * @author Praveen RaJ
 *
 * @created 2016-09-01
 */

@Service("clientService")
public class ClientServiceImpl extends GenericManagerImpl<Client, Long> implements ClientService {

    @Autowired
    ClientDao clientDao;

    /**
     * <p>
     * This method Passes the values to its dao class to insert into the
     * database.
     * </p>
     * 
     * @param client
     *            model object that stores the client data associated with
     *            model.
     * @return boolean gives the status of the insertion into the database.
     * @throws DataException
     *             throws error message if problem arises with inserting the
     *             data in the database.
     */
    public boolean addClient(Client client) throws DataException {
        return clientDao.insertClient(client);
    }

    /**
     * <p>
     * This method Passes the values to its dao class to update the existing
     * client in the database.
     * </p>
     * 
     * @param client
     *            model object that stores the client data associated with
     *            model.
     * @return boolean gives the status of the update from the database.
     * @throws DataException
     *             throws error message if problem arises with updating the data
     *             in the database.
     */
    public boolean updateClient(Client client) throws DataException {
        return clientDao.modifyClient(client);
    }

    /**
     * <p>
     * This method checks the presence of client ID in the database. Passes the
     * value to its dao class to delete if present.
     * </p>
     * 
     * @param clientId
     *            contains the ID of the client.
     * @return boolean gives the status of the deletion from the database.
     * @throws DataException
     *             throws error message if problem arises with deleting the data
     *             in the database.
     */
    public boolean deleteClient(int clientId) throws DataException {
        if (clientDao.findClient(clientId) != null) {
            return clientDao.removeClient(searchClient(clientId));
        }
        return false;
    }

    /**
     * <p>
     * This method passes the client ID to its dao class to search in the
     * database. Returns the model object of the client to its controller to
     * display.
     * </p>
     *
     * @param clientId
     *            contains the ID of the client.
     * @return object gives the appropriate client object for the corresponding
     *         client ID.
     * @throws DataException
     *             throws error message if problem arises with searching the
     *             data in the database.
     */
    public Client searchClient(int clientId) throws DataException {
        return clientDao.findClient(clientId);
    }

    /**
     * <p>
     * This method retrieves the Client data from the records and returns the
     * list of data to display.
     * </p>
     * 
     * @return list Gives the list of client details retrieved from the
     *         database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */
    public List<Client> displayClients() throws DataException {
        return clientDao.retrieveClients();
    }
}
