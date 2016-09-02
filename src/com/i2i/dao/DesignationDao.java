package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.model.Department;
import com.i2i.model.Designation;
import com.i2i.Util.FileUtil;
import com.i2i.connection.HibernateConnection;
import com.i2i.exception.DataException;


/**
 * <p>
 * DataAccessObject(Dao) for Designation model 
 * is used to insert, update and delete designation from department
 * Creates session and transaction objects for each operation 
 * </p>
 * 
 * @author Praveen RaJ
 * 
 * @created 2016-09-01
 */

public class DesignationDao {

	Designation designation = new Designation();
	HibernateConnection hibernateConnection =  HibernateConnection.createObject();
	SessionFactory sessionFactory = hibernateConnection.establishConnection();
	
	
	/**
	 * * <p>
	 * Method is used to insert new designation
     * create a new session and Inserts the model object of the designation into the database.
     * </p>
	 * @param designation
	 *      model object that stores the designation data associated with model class.
	 * @throws DataException
	 *      if any database connection error occurred error message will be logged and send context info to user 
	 *  @return 
	 *      if inserted successfully true will be return to the Calling method   
	 */
	public boolean insertDesignation(Designation designation) throws DataException {
		Session session=sessionFactory.openSession();
		try {
			Transaction transaction=session.beginTransaction();	
	        session.save(designation);  	
	        transaction.commit();
	        return true;	       
		} catch (HibernateException ex) {
			FileUtil.ErrorLogger("Error on DesignationDao insertDesignation() : " + ex.toString());
	        throw new DataException("Error Occured while Inserting this" + designation.getName() + " : please verify your details... Any try again..!");
		} finally {
			session.close();
		}
	}
	
	/**
	 * * <p>
	 * Method is used to delete existing designation
     * create a new session and Inserts the model object of the designation into the database.
     * </p>
	 * @param designation
	 *      model object that stores the designation data associated with model class.
	 * @throws DataException
	 *      if any database connection error occurred error message will be logged and send context info to user 
	 *  @return 
	 *      if inserted successfully true will be return to the Calling method   
	 */
	public boolean removeDesignation(Designation designation) throws DataException {
		Session session=sessionFactory.openSession();
		try {
			Transaction transaction=session.beginTransaction();	
	        session.delete(designation);  	
	        transaction.commit();
	        return true;
		} catch (HibernateException ex) {
			FileUtil.ErrorLogger("Error on DesignationDao insertDesignation() : " + ex.toString());
	        throw new DataException("Error Occured while Adding this" + designation.getName() + " : please verify your details... Any try again..!");
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
     * @throws DataException
     *       throws error message if problem arises with searching the data in the database, error will stored in log file and context message to user.
     * @return Designation
     *       return the required designation object model contains designation info.
     */
    public Designation findDesignationById(int designationId) throws DataException {
    	Session session=sessionFactory.openSession();
        try {
            return (Designation)session.get(Designation.class, designationId);
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in findEmployee() : " + exception.getMessage());
            throw new DataException("Error while searching Department ID : " + designationId);
        } finally {
            session.close();
        }
    }
    
    /**
     * <p>
     * This method retrieves the department data from the records and returns the list of data.
     * </p>
     * 
     * @param department_id
     *      contains identity of the department 
     * @throws com.i2i.exception.DataException
     *       throws error message if problem arises with retrieving list of data from the database.
     * @return Designation.List
     *       return the full list of designation stored in database
     */
    public List<Designation> retrieveDesignation() throws DataException {
    	Session session=sessionFactory.openSession();
    	try {           
    		return session.createCriteria(Department.class).list();
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in retrieveEmployees() : " + exception.getMessage());
            throw new DataException("Error while displaying all Departments");
        } finally {
            session.close();
        }
    }
    
    
    
    /**
     * <p>
     * This method retrieves the department data from the records and returns the list of data.
     * </p>
     * 
     * @param department_id
     *      contains identity of the department 
     * @throws DataException
     *       throws error message if problem arises with retrieving list of data from the database.
     * @return Designation.List
     *       return the list of designation which is stored under the given department
     */
    public List<Designation> retrieveDesignationByDepartment(int department_id) throws DataException {
    	Session session=sessionFactory.openSession();
    	try {           
            return session.createQuery("From Designation WHERE department_id = : department_id").list();
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in retrieveEmployees() : " + exception.getMessage());
            throw new DataException("Error while displaying all Departments");
        } finally {
            session.close();
        }
    }       
        
}
