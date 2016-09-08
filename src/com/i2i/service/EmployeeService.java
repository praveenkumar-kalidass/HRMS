package com.i2i.service;

import java.util.List;

import com.i2i.dao.EmployeeDao;
import com.i2i.exception.DataException;
import com.i2i.model.Department;
import com.i2i.model.Employee;

/**
 * <p>
 * Service class which does validations with the user input of employee details.
 * Passes values to the Dao class to carry out manipulations.
 * Throws error messages in case of occurrence of any exceptions.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-09-02
 */
public class EmployeeService {
    EmployeeDao employeeDao = new EmployeeDao();
    
    /**
     * <p>
     * This method checks the presence of employee ID in the database.
     * Passes the value to its dao class to insert if not present. 
     * </p>
     * 
     * @param employee
     *       model object that stores the employee data associated with model.
     * @return boolean
     *       gives the status of the insertion into the database.
     * @throws DataException
     *       throws error message if problem arises with inserting the data in the database.
     */
    public boolean addEmployee(Employee employee) throws DataException {
    	return employeeDao.insertEmployee(employee);
    }
    
    /**
     * <p>
     * This method checks the presence of department ID in the database.
     * Passes the value to its dao class to update if present. 
     * </p>
     * 
     * @param department
     *       model object that stores the department data associated with model.
     * @return boolean
     *       gives the status of the update from the database.
     * @throws DataException
     *       throws error message if problem arises with updating the data in the database.
     */
    public boolean updateEmployee(Employee employee) throws DataException {    	
    	return employeeDao.modifyEmployee(employee);
    	
    }
    
    
    /**
     * <p>
     * This method checks the presence of employee ID in the database.
     * Passes the value to its dao class to delete if present.
     * </p>
     * 
     * @param employeeId
     *       contains the ID of the employee.
     * @return boolean
     *       gives the status of the deletion from the database.
     * @throws DataException
     *       throws error message if problem arises with deleting the data in the database.
     */
    public boolean deleteEmployee(int employeeId) throws DataException {
    	if (searchEmployee(employeeId) != null) {
            return employeeDao.removeEmployee(searchEmployee(employeeId));
        }
        return false;        
    }
    
    /**
     * <p>
     * This method passes the employee ID to its dao class to search in the database.
     * Returns the model object of the employee to its controller to display.
     * </p>
     *
     * @param employeeId
     *       contains the ID of the employee.
     *       
     * @return object
     *       gives the appropriate employee object for the corresponding employee ID.
     * @throws DataException
     *       throws error message if problem arises with searching the data in the database.
     */
    public Employee searchEmployee(int employeeId) throws DataException {
        return employeeDao.findEmployee(employeeId);
    }
    
    /**
     * <p>
     * This method retrieves the Employee data from the records and returns the list of data to display.
     * </p>
     * 
     * @return list
     *       Gives the list of employee details retrieved from the database.
     * @throws DataException
     *       throws error message if problem arises with retrieving list of data from the database.
     */
    public List<Employee> retrieveEmployees() throws DataException {
        return employeeDao.getEmployees();
    }
}