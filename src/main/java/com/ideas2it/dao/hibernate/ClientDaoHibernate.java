package com.ideas2it.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ideas2it.util.FileUtil;
import com.ideas2it.dao.ClientDao;
import com.ideas2it.exception.DataException;
import com.ideas2it.model.Certification;
import com.ideas2it.model.Client;

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

@Repository("clientDao")
@Transactional
public class ClientDaoHibernate extends GenericDaoHibernate<Client, Long> implements ClientDao {

	public ClientDaoHibernate() {
		super(Client.class);
	}

	/**
	 * <p>
	 * This method opens a new session and Inserts the model object of the
	 * client into the database.
	 * </p>
	 * 
	 * @param client
	 *            model object that stores the client data associated with model
	 *            class.
	 * @return true Gives the success status of the insertion process.
	 * @throws DataException
	 *             throws error message if problem arises with inserting the
	 *             data in the database.
	 */
	public boolean insertClient(Client client) throws DataException {
		try {
			Session session = getSession();
			session.save(client);
			return true;
		} catch (HibernateException exception) {
			FileUtil.errorLogger("Exception in insertClient() : " + exception.getMessage());
			throw new DataException("Error while adding Client ID : " + client.getClientId());
		}
	}

	/**
	 * <p>
	 * This method opens a new session and modifies the model object of the
	 * client in the database.
	 * </p>
	 * 
	 * @param client
	 *            model object that stores the client data associated with model
	 *            class.
	 * @return true Gives the success status of the updation process.
	 * @throws DataException
	 *             throws error message if problem arises with updating the data
	 *             in the database.
	 */
	public boolean modifyClient(Client client) throws DataException {
		try {
			Session session = getSession();
			session.update(client);
			return true;
		} catch (HibernateException exception) {
			FileUtil.errorLogger("Exception in modifyClient() : " + exception.getMessage());
			throw new DataException("Error while updating Client ID : " + client.getClientId());
		}
	}

	/**
	 * <p>
	 * This method opens a new session and Deletes the client from the records.
	 * </p>
	 * 
	 * @param client
	 *            model object that stores the client data associated with model
	 *            class.
	 * @return true Gives the success status of the deletion process.
	 * @throws DataException
	 *             throws error message if problem arises with deleting the data
	 *             in the database.
	 */
	public boolean removeClient(Client client) throws DataException {
		Session session = null;
		try {
			session = getSession();
			session.delete(client);
			return true;
		} catch (HibernateException exception) {
			FileUtil.errorLogger("Exception in removeEmployee() : " + exception.getMessage());
			throw new DataException("Error while deleting Client ID : " + client.getClientId());
		}
	}

	/**
	 * <p>
	 * This method searches the client from the records using client ID and
	 * returns the data as a model object to display.
	 * </p>
	 * 
	 * @param departementId
	 *            contains the ID of the client.
	 * @return object gives the appropriate client detail for the corresponding
	 *         client ID.
	 * @throws DataException
	 *             throws error message if problem arises with searching the
	 *             data in the database.
	 */
	public Client findClient(int clientId) throws DataException {
		try {
			Session session = getSession();
			return (Client) session.get(Client.class, clientId);
		} catch (HibernateException exception) {
			FileUtil.errorLogger("Exception in findClient() : " + exception.getMessage());
			throw new DataException("Error while searching Client ID : " + clientId);
		}
	}

	/**
	 * <p>
	 * This method retrieves the client data from the records and returns the
	 * list of data.
	 * </p>
	 * 
	 * @return list Gives the list of client details stored in the database.
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 */
	public List<Client> retrieveClients() throws DataException {
		try {
			Session session = getSession();
			return session.createCriteria(Client.class).list();
		} catch (HibernateException exception) {
			FileUtil.errorLogger("Exception in retrieveClients() : " + exception.getMessage());
			throw new DataException("Error while displaying all Clients");
		}
	}
}
