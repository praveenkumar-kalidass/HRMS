package com.ideas2it.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.dao.DepartmentDao;
import com.ideas2it.exception.DataException;
import com.ideas2it.model.Client;
import com.ideas2it.model.Department;
import com.ideas2it.service.ClientService;
import com.ideas2it.service.DepartmentService;

/**
 * <p>
 * Service class which does validations with the user input of department
 * details. Passes values to the Dao class to carry out manipulations. Throws
 * error messages in case of occurrence of any exceptions.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-09-01
 */

@Service("departmentService")
public class DepartmentServiceImpl extends GenericManagerImpl<Department, Long> implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    /**
     * <p>
     * This method Passes the values to its dao class to insert into the
     * database.
     * </p>
     * 
     * @param department
     *            model object that stores the department data associated with
     *            model.
     * @return boolean gives the status of the insertion into the database.
     * @throws DataException
     *             throws error message if problem arises with inserting the
     *             data in the database.
     */
    public boolean addDepartment(Department department) throws DataException {
        return departmentDao.insertDepartment(department);
    }

    /**
     * <p>
     * This method Passes the values to its dao class to update the existing
     * department in the database.
     * </p>
     * 
     * @param department
     *            model object that stores the department data associated with
     *            model.
     * @return boolean gives the status of the update from the database.
     * @throws DataException
     *             throws error message if problem arises with updating the data
     *             in the database.
     */
    public boolean updateDepartment(Department department) throws DataException {
        return departmentDao.modifyDepartment(department);
    }

    /**
     * <p>
     * This method checks the presence of department ID in the database. Passes
     * the value to its dao class to delete if present.
     * </p>
     * 
     * @param departmentId
     *            contains the ID of the department.
     * @return boolean gives the status of the deletion from the database.
     * @throws DataException
     *             throws error message if problem arises with deleting the data
     *             in the database.
     */
    public boolean deleteDepartment(int departmentId) throws DataException {
        if (departmentDao.findDepartment(departmentId) != null) {
            return departmentDao.removeDepartment(searchDepartment(departmentId));
        }
        return false;
    }

    /**
     * <p>
     * This method passes the department ID to its dao class to search in the
     * database. Returns the model object of the department to its controller to
     * display.
     * </p>
     *
     * @param departmentId
     *            contains the ID of the department.
     * @return object gives the appropriate department object for the
     *         corresponding department ID.
     * @throws DataException
     *             throws error message if problem arises with searching the
     *             data in the database.
     */
    public Department searchDepartment(int departmentId) throws DataException {
        return departmentDao.findDepartment(departmentId);
    }

    /**
     * <p>
     * This method retrieves the Department data from the records and returns
     * the list of data to display.
     * </p>
     * 
     * @return list Gives the list of department details retrieved from the
     *         database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */
    public List<Department> retriveDepartments() throws DataException {
        return departmentDao.retrieveDepartments();
    }
}
