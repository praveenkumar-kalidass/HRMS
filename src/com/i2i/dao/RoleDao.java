package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.util.FileUtil;
import com.i2i.connection.HibernateConnection;
import com.i2i.exception.DataException;
import com.i2i.model.Role;

/**
 * <p>
 * Dao(Data Access Object) class which establishes session with the database and 
 * performs operation on manipulation of records associated with Employee Roles.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-09-02
 */
public class RoleDao {
    private HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory factory = hibernateConnection.establishConnection();
    
    /**
     * <p>
     * This method opens a new session and Inserts the model object of the role into the database.
     * </p>
     * 
     * @param role
     *       model object that stores the role data associated with model class.
     * @return true
     *       Gives the success status of the insertion process.
     * @throws DataException
     *       throws error message if problem arises with inserting the data in the database.
     */
    public boolean insertRole(Role role) throws DataException{
    	Session session = factory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in insertRole() : " + exception.getMessage());
            throw new DataException("Error while adding Role ID : " + role.getRoleId());
        } finally {
            session.close();
        }
    }
    
    /**
     * <p>
     * This method opens a new session and updates the modified model object of the role into the database.
     * </p>
     * 
     * @param role
     *       model object that stores the role data associated with model class.
     * @return true
     *       Gives the success status of the modification process.
     * @throws DataException
     *       throws error message if problem arises with modification of data in the database.
     */
    public boolean modifyRole(Role role) throws DataException{
        Session session = factory.openSession();
    	try {
            Transaction transaction = session.beginTransaction();
            session.update(role);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in modifyRole() : " + exception.getMessage());
            throw new DataException("Error while modifying Role ID : " + role.getRoleId());
        } finally {
            session.close();
        }
    }
    
    /**
     * <p>
     * This method opens a new session and Deletes the role from the records.
     * </p>
     * 
     * @param role
     *       model object that stores the role data associated with model class.
     * @return true
     *       Gives the success status of the deletion process.
     * @throws DataException
     *       throws error message if problem arises with deleting the data in the database.
     */
    public boolean removeRole(Role role) throws DataException {
    	Session session = factory.openSession();
        try {
        	Transaction transaction = session.beginTransaction();
            session.delete(role);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in removeRole() : " + exception.getMessage());
            throw new DataException("Error while deleting Role ID : " + role.getRoleId());
        } finally {
            session.close();
        }
    }
    
    /**
     * <p>
     * This method searches the role from the records using role ID and 
     * returns the data as a model object to display.
     * </p>
     * 
     * @param roleId
     *       contains the ID of the role.
     * @return object
     *       gives the appropriate role detail for the corresponding role ID.
     * @throws DataException
     *       throws error message if problem arises with searching the data in the database.
     */
    public Role findRole(int roleId) throws DataException {
    	Session session = factory.openSession();
        try {
            return (Role)session.get(Role.class, roleId);
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in findRole() : " + exception.getMessage());
            throw new DataException("Error while searching Role ID : " + roleId);
        } finally {
            session.close();
        }
    }
    
    /**
    * <p>
    * This method retrieves the roles from the records and returns the list of data.
    * </p>
    * 
    * @return list
    *       Gives the list of role details stored in the database.
    * @throws DataException
    *       throws error message if problem arises with retrieving list of data from the database.
    */
   public List<Role> retrieveRoles() throws DataException {
   	Session session = factory.openSession();
       try {
           return session.createCriteria(Role.class).list();
       } catch (HibernateException exception) {
           FileUtil.ErrorLogger("Exception in retrieveRoles() : " + exception.getMessage());
           throw new DataException("Error while displaying all Roles");
       } finally {
           session.close();
       }
   }
}