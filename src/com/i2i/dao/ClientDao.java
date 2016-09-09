package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.Util.FileUtil;
import com.i2i.connection.HibernateConnection;
import com.i2i.exception.DataException;
import com.i2i.model.Client;

/**
 * <p>
 * Dao(Data Access Object) class which establishes session with the database and 
 * performs operation on manipulation of records associated with Client datas.
 * </p>
 *
 * @author Praveen RaJ
 *
 * @created 2016-09-09
 */
public class ClientDao {
	private HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory factory = hibernateConnection.establishConnection();
    
    /**
     * <p>
     * This method opens a new session and Inserts the model object of the client into the database.
     * </p>
     * 
     * @param client
     *       model object that stores the client data associated with model class.
     * @return true
     *       Gives the success status of the insertion process.
     * @throws DataException
     *       throws error message if problem arises with inserting the data in the database.
     */
    public boolean insertClient(Client client) throws DataException{
        Session session = factory.openSession();
    	try {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in insertClient() : " + exception.getMessage());
            throw new DataException("Error while adding Client ID : " + client.getClientId());
        } finally {
            session.close();
        }
    }
    
    /**
     * <p>
     * This method opens a new session and modifies the model object of the client in the database.
     * </p>
     * 
     * @param client
     *       model object that stores the client data associated with model class.
     * @return true
     *       Gives the success status of the updation process.
     * @throws DataException
     *       throws error message if problem arises with updating the data in the database.
     */
    public boolean modifyClient(Client client) throws DataException{
        Session session = factory.openSession();
    	try {
            Transaction transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in modifyClient() : " + exception.getMessage());
            throw new DataException("Error while updating Client ID : " + client.getClientId());
        } finally {
            session.close();
        }
    }
    
    /**
     * <p>
     * This method opens a new session and Deletes the client from the records.
     * </p>
     * 
     * @param client
     *       model object that stores the client data associated with model class.
     * @return true
     *       Gives the success status of the deletion process.
     * @throws DataException
     *       throws error message if problem arises with deleting the data in the database.
     */
    public boolean removeClient(Client client) throws DataException {
        Session session = factory.openSession();
    	try {
            Transaction transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in removeEmployee() : " + exception.getMessage());
            throw new DataException("Error while deleting Client ID : " + client.getClientId());
        } finally {
            session.close();
        }
    }

    /**
     * <p>
     * This method searches the client from the records using client ID and 
     * returns the data as a model object to display.
     * </p>
     * 
     * @param departementId
     *       contains the ID of the client.
     * @return object
     *       gives the appropriate client detail for the corresponding client ID.
     * @throws DataException
     *       throws error message if problem arises with searching the data in the database.
     */
    public Client findClient(int clientId) throws DataException {
    	Session session = factory.openSession();
    	try {    	    
            return (Client)session.get(Client.class, clientId);
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in findClient() : " + exception.getMessage());
            throw new DataException("Error while searching Client ID : " + clientId);
        } finally {
            session.close();
        }
    }
    
    /**
     * <p>
     * This method retrieves the client data from the records and returns the list of data.
     * </p>
     * 
     * @return list
     *       Gives the list of client details stored in the database.
     * @throws DataException
     *       throws error message if problem arises with retrieving list of data from the database.
     */
    public List<Client> retrieveClients() throws DataException {
    	Session session = factory.openSession();
    	try {        	
            return session.createCriteria(Client.class).list();
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in retrieveClients() : " + exception.getMessage());
            throw new DataException("Error while displaying all Clients");
        } finally {
            session.close();
        }
    }
}
