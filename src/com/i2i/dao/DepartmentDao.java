package com.i2i.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.Util.FileUtil;
import com.i2i.connection.HibernateConnection;
import com.i2i.exception.DataException;
import com.i2i.model.Department;

/**
 * <p>
 * Dao class which establishes session with the database and 
 * performs operation on manipulation of records associated with Department.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-09-01
 */

public class DepartmentDao {
    private HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory factory = hibernateConnection.establishConnection();
    Session session;
    Transaction transaction;
    
/**
     * <p>
     * This method opens a new session and Inserts the model object of the department into the database.
     * </p>
     * 
     * @param department
     *       model object that stores the department data associated with model class.
     * @return true
     *       Gives the success status of the insertion process.
     * @throws DataException
     *       throws error message if problem arises with inserting the data in the database.
     */
    public boolean insertDepartment(Department department) throws DataException{
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();

            session.save(department);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in insertDepartment() : " + exception.getMessage());
            throw new DataException("Error while adding Department ID : " + department.getDepartmentId());
        } finally {
            session.close();
        }
    }
    
/**
     * <p>
     * This method opens a new session and Deletes the department from the records.
     * </p>
     * 
     * @param departmentId
     *       contains the ID of the department.
     * @return true
     *       Gives the success status of the deletion process.
     * @throws DataException
     *       throws error message if problem arises with deleting the data in the database.
     */
    public boolean removeDepartment(int departmentId) throws DataException {
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Department department = (Department)session.get(Department.class, departmentId); 

            session.delete(department);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in removeEmployee() : " + exception.getMessage());
            throw new DataException("Error while deleting Department ID : " + departmentId);
        } finally {
            session.close();
        }
    }

/**
     * <p>
     * this method searches the department from the records using department ID and 
     * returns the data as a model object to display.
     * </p>
     * 
     * @param departementId
     *       contains the ID of the department.
     * @return object
     *       gives the appropriate department detail for the corresponding department ID.
     * @throws DataException
     *       throws error message if problem arises with searching the data in the database.
     */
    public Department findDepartment(int departmentId) throws DataException {
            session = factory.openSession();
        try {
            transaction = session.beginTransaction();
            return (Department)session.get(Department.class, departmentId);

        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in findEmployee() : " + exception.getMessage());
            throw new DataException("Error while searching Department ID : " + departmentId);
        } finally {
            session.close();
        }
    }
    
     /**
     * <p>
     * This method retrieves the department data from the records and returns the list of data.
     * </p>
     * 
     * @return list
     *       Gives the list of department details stored in the database.
     * @throws DataException
     *       throws error message if problem arises with retrieving list of data from the database.
     */
    public List<Department> retrieveDepartments() throws DataException {
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();

            return session.createCriteria(Department.class).list();
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in retrieveEmployees() : " + exception.getMessage());
            throw new DataException("Error while displaying all Departments");
        } finally {
            session.close();
        }
    }
}