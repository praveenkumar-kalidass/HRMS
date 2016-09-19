package com.i2i.service;

import java.util.List;

import com.i2i.dao.DesignationDao;
import com.i2i.exception.DataException;
import com.i2i.model.Designation;

/**
 * <p>
 * Service class which does validations with the user input of designation
 * details. Passes values to the Dao class to carry out manipulations. Throws
 * error messages in case of occurrence of any exceptions.
 * </p>
 *
 * @author Praveen Raj
 *
 * @created 2016-09-01
 */
public class DesignationService {
    DesignationDao designationtDao = new DesignationDao();

    /**
     * <p>
     * This method checks the presence of designation ID in the database. Passes
     * the value to its dao class to insert if not present.
     * </p>
     * 
     * @param designation
     *            model object that stores the designation data associated with
     *            model.
     * @return boolean gives the status of the insertion into the database.
     * @throws DataException
     *             throws error message if problem arises with inserting the
     *             data in the database.
     */
    public boolean addDesignation(Designation designation) throws DataException {
        return designationtDao.insertDesignation(designation);
    }

    /**
     * <p>
     * This method checks the presence of designation ID in the database. Passes
     * the value to its dao class to update if present.
     * </p>
     * 
     * @param designation
     *            model object that stores the designation data associated with
     *            model.
     * @return boolean gives the status of the update from the database.
     * @throws DataException
     *             throws error message if problem arises with updating the data
     *             in the database.
     */
    public boolean updateDesignation(Designation designation) throws DataException {
        return designationtDao.modifyDesignation(designation);
    }

    /**
     * <p>
     * This method checks the presence of designation ID in the database. Passes
     * the value to its dao class to delete if present.
     * </p>
     * 
     * @param designationId
     *            contains the ID of the designation.
     * @return boolean gives the status of the deletion from the database.
     * @throws DataException
     *             throws error message if problem arises with deleting the data
     *             in the database.
     */
    public boolean deleteDesignation(int designationId) throws DataException {
        if (searchDesignation(designationId) != null) {
            return designationtDao.removeDesignation(searchDesignation(designationId));
        }
        return false;
    }

    /**
     * <p>
     * This method passes the department ID to its dao class to search in the
     * database. Returns the model object of the designation to its controller
     * to display.
     * </p>
     *
     * @param designationId
     *            contains the ID of the designation.
     * 
     * @return designation gives the appropriate designation object for the
     *         corresponding designationID.
     * @throws DataException
     *             throws error message if problem arises with searching the
     *             data in the database.
     */
    public Designation searchDesignation(int designationId) throws DataException {
        return designationtDao.findDesignationById(designationId);
    }

    /**
     * <p>
     * This method retrieves the Designation data from the records and returns
     * the list of data to display.
     * </p>
     * 
     * @return list Gives the list of designation details retrieved from the
     *         database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */
    public List<Designation> getDesignations() throws DataException {
        return designationtDao.retrieveDesignations();
    }

    /**
     * <p>
     * This method retrieves the Designation data for given department from the
     * records and returns the list of data to display.
     * </p>
     * 
     * @param departmentId
     *            contains the ID of the department.
     * @return list Gives the list of designation details for given departmentId
     *         retrieved from the database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */
    public List<Designation> getDesgignationByDepartment(int departmentId) throws DataException {
        return designationtDao.retrieveDesignationByDepartment(departmentId);
    }
}
