package com.i2i.service;

import java.util.List;


import com.i2i.dao.RoleDao;
import com.i2i.exception.DataException;
import com.i2i.model.Role;

/**
 * <p>
 * Service class which does validations with the user input of role details.
 * Passes values to the Dao class to carry out manipulations.
 * Throws error messages in case of occurrence of any exceptions.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-08-15
 */
public class RoleService {
    RoleDao roleDao = new RoleDao();
    
    /**
     * <p>
     * This method checks the presence of role ID in the database.
     * Passes the value to its dao class to insert if not present. 
     * </p>
     * 
     * @param role
     *       model object that stores the role data associated with model.
     * @return boolean
     *       gives the status of the insertion into the database.
     * @throws DataException
     *       throws error message if problem arises with inserting the data in the database.
     */
    public boolean addRole(Role role) throws DataException {    	
    	return roleDao.insertRole(role);
    	
    }
    
    
    /**
     * <p>
     * This method checks the presence of role ID in the database.
     * Passes the value to its dao class to insert if not present. 
     * </p>
     * 
     * @param role
     *       model object that stores the role data associated with model.
     * @return boolean
     *       gives the status of the insertion into the database.
     * @throws DataException
     *       throws error message if problem arises with inserting the data in the database.
     */
    public boolean updateRole(Role role) throws DataException {    	
    	return roleDao.modifyRole(role);
    	
    }
    
    /**
     * <p>
     * This method checks the presence of role ID in the database.
     * Passes the value to its dao class to delete if present.
     * </p>
     * 
     * @param roleId
     *       contains the ID of the role.
     * @return boolean
     *       gives the status of the deletion from the database.
     * @throws DataException
     *       throws error message if problem arises with deleting the data in the database.
     */
    public boolean deleteRole(int roleId) throws DataException {
        if (roleDao.findRole(roleId) != null) {
            return roleDao.removeRole(searchRole(roleId));
        }
        return false;
    }
    
    /**
     * <p>
     * This method passes the role ID to its dao class to search in the database.
     * Returns the model object of the role to its controller to display.
     * </p>
     *
     * @param roleId
     *       contains the ID of the role.
     *       
     * @return object
     *       gives the appropriate role object for the corresponding role ID.
     * @throws DataException
     *       throws error message if problem arises with searching the data in the database.
     */
    public Role searchRole(int roleId) throws DataException {
        return roleDao.findRole(roleId);
    }
    
    /**
     * <p>
     * This method retrieves the Role data from the records and returns the list of data to display.
     * </p>
     * 
     * @return list
     *       Gives the list of role details retrieved from the database.
     * @throws DataException
     *       throws error message if problem arises with retrieving list of data from the database.
     */
    public List<Role> displayRoles() throws DataException {
        return roleDao.retrieveRoles();
    }
}