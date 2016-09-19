package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.util.FileUtil;
import com.i2i.connection.HibernateConnection;
import com.i2i.exception.DataException;
import com.i2i.model.LeaveRequest;

/**
 * <p>
 * Dao(Data Access Object) class which establishes session with the database and 
 * performs operation on manipulation of records associated with LeaveRequest.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-09-01
 */

public class LeaveRequestDao {
    private HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory factory = hibernateConnection.establishConnection();
    
/**
     * <p>
     * This method opens a new session and Inserts the model object of the leaveRequest into the database.
     * </p>
     * 
     * @param leaveRequest
     *       model object that stores the leaveRequest data associated with model class.
     * @return true
     *       Gives the success status of the insertion process.
     * @throws DataException
     *       throws error message if problem arises with inserting the data in the database.
     */
    public boolean insertLeaveRequest(LeaveRequest leaveRequest) throws DataException{
        Session session = factory.openSession();
    	try {
            Transaction transaction = session.beginTransaction();
            session.save(leaveRequest);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
        	exception.printStackTrace();
            FileUtil.ErrorLogger("Exception in insertLeaveRequest() : " + exception.getMessage());
            throw new DataException("Error while adding LeaveRequest ID : " + leaveRequest.getLeaveId());
        } finally {
            session.close();
        }
    }
    
    
    
    /**
     * <p>
     * This method opens a new session and modify the model object of the leaveRequest from the database.
     * </p>
     * 
     * @param leaveRequest
     *       model object that stores the leaveRequest data associated with model class.
     * @return true
     *       Gives the success status of the updation process.
     * @throws DataException
     *       throws error message if problem arises with updating the data in the database.
     */
    public boolean modifyLeaveRequest(LeaveRequest leaveRequest) throws DataException{
        Session session = factory.openSession();
    	try {
            Transaction transaction = session.beginTransaction();
            session.update(leaveRequest);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
        	exception.printStackTrace();
            FileUtil.ErrorLogger("Exception in modifyLeaveRequest() : " + exception.getMessage());
            throw new DataException("Error while adding LeaveRequest ID : " + leaveRequest.getLeaveId());
        } finally {
            session.close();
        }
    }
    
/**
     * <p>
     * This method opens a new session and Deletes the leaveRequest from the records.
     * </p>
     * 
     * @param leaveRequestId
     *       contains the ID of the leaveRequest.
     * @return true
     *       Gives the success status of the deletion process.
     * @throws DataException
     *       throws error message if problem arises with deleting the data in the database.
     */
    public boolean removeLeaveRequest(LeaveRequest leaveRequest) throws DataException {
        Session session = factory.openSession();
    	try {
            Transaction transaction = session.beginTransaction();
            session.delete(leaveRequest);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in removeEmployee() : " + exception.getMessage());
            throw new DataException("Error while deleting LeaveRequest ID : " + leaveRequest.getLeaveId());
        } finally {
            session.close();
        }
    }

/**
     * <p>
     * this method searches the leaveRequest from the records using leaveRequest ID and 
     * returns the data as a model object to display.
     * </p>
     * 
     * @param departementId
     *       contains the ID of the leaveRequest.
     * @return object
     *       gives the appropriate leaveRequest detail for the corresponding leaveRequest ID.
     * @throws DataException
     *       throws error message if problem arises with searching the data in the database.
     */
    public LeaveRequest findLeaveRequest(int leaveId) throws DataException {
    	Session session = factory.openSession();
    	try {    	    
    	    Transaction transaction = session.beginTransaction();
            return (LeaveRequest)session.get(LeaveRequest.class, leaveId);
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in findLeaveRequest() : " + exception.getMessage());
            throw new DataException("Error while searching LeaveRequest ID : " + leaveId);
        } finally {
            session.close();
        }
    }
    
     /**
     * <p>
     * This method retrieves the leaveRequest data from the records and returns the list of data.
     * </p>
     * 
     * @return list
     *       Gives the list of leaveRequest details stored in the database.
     * @throws DataException
     *       throws error message if problem arises with retrieving list of data from the database.
     */
    public List<LeaveRequest> retrieveLeaveRequests() throws DataException {
    	Session session = factory.openSession();
    	try {        	
        	Transaction transaction = session.beginTransaction();
            return session.createCriteria(LeaveRequest.class).list();
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in retrieveLeaveRequests() : " + exception.getMessage());
            throw new DataException("Error while displaying all LeaveRequests");
        } finally {
            session.close();
        }
    }
    
    
    /**
     * <p>
     * This method retrieves the leaveRequest data for given employee from the records and returns the list of data.
     * </p>
	 * @param employeeId
	 *            identity of the employee
     * @return list
     *       Gives the list of leaveRequest details for given employee stored in the database.
     * @throws DataException
     *       throws error message if problem arises with retrieving list of data from the database.
     */
    public List<LeaveRequest> retrieveLeaveRequestsByEmployee(int employeeId) throws DataException {
    	Session session = factory.openSession();
    	try {        	
        	Transaction transaction = session.beginTransaction();
        	return session.createQuery("From LeaveRequest WHERE employee_id=" + employeeId +" order by id desc").list();
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in retrieveLeaveRequests() : " + exception.getMessage());
            throw new DataException("Error while displaying all LeaveRequests");
        } finally {
            session.close();
        }
    }
    
    
    /**
     * <p>
     * This method retrieves the leaveRequest data for given employee for given period from the records and returns the list of data.
     * </p>
	 * @param employeeId
	 *            identity of the employee
	 * @param fromDate
	 *            from the Period of Date
	 * @param toDate
	 *            to the Period of Date
     * @return list
     *       Gives the list of leaveRequest details for given employee stored in the database.
     * @throws DataException
     *       throws error message if problem arises with retrieving list of data from the database.
     */
    public List<LeaveRequest> calculateLeaveDaysForEmployee(int employeeId, String fromDate, String toDate) throws DataException {
    	Session session = factory.openSession();
    	try {        	
        	Transaction transaction = session.beginTransaction();
        	return session.createQuery("From LeaveRequest WHERE employee_id=" + employeeId +" and from_date>='"+ fromDate +"' and to_date <='"+ toDate+"' and status='Approved'").list();
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in retrieveLeaveRequests() : " + exception.getMessage());
            throw new DataException("Error while displaying all LeaveRequests");
        } finally {
            session.close();
        }
    }
    
    
}