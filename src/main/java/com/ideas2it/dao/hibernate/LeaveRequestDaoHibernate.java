package com.ideas2it.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ideas2it.util.FileUtil;
import com.ideas2it.dao.LeaveRequestDao;
import com.ideas2it.exception.DataException;
import com.ideas2it.model.Department;
import com.ideas2it.model.LeaveRequest;

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
@Repository("leaveRequestDao")
@Transactional
public class LeaveRequestDaoHibernate extends GenericDaoHibernate<LeaveRequest, Long> implements LeaveRequestDao {
    /**
     * Constructor to create a Generics-based version using Leave Request as the entity
     */
    public LeaveRequestDaoHibernate() {
        super(LeaveRequest.class);
    }

    /**
     * <p>
     * This method opens a new session and Inserts the model object of the
     * leaveRequest into the database.
     * </p>
     * 
     * @param leaveRequest
     *            model object that stores the leaveRequest data associated with
     *            model class.
     * @return true Gives the success status of the insertion process.
     * @throws DataException
     *             throws error message if problem arises with inserting the
     *             data in the database.
     */
    public boolean insertLeaveRequest(LeaveRequest leaveRequest) throws DataException {
        try {
            Session session = getSession();
            session.save(leaveRequest);
            return true;
        } catch (HibernateException exception) {
            exception.printStackTrace();
            FileUtil.errorLogger("Exception in insertLeaveRequest() : " + exception.getMessage());
            throw new DataException("Error while adding for this reason : " + leaveRequest.getLeaveReason());
        }
    }

    /**
     * <p>
     * This method opens a new session and modify the model object of the
     * leaveRequest from the database.
     * </p>
     * 
     * @param leaveRequest
     *            model object that stores the leaveRequest data associated with
     *            model class.
     * @return true Gives the success status of the updation process.
     * @throws DataException
     *             throws error message if problem arises with updating the data
     *             in the database.
     */
    public boolean modifyLeaveRequest(LeaveRequest leaveRequest) throws DataException {
        try {
            Session session = getSession();
            session.update(leaveRequest);
            return true;
        } catch (HibernateException exception) {
            exception.printStackTrace();
            FileUtil.errorLogger("Exception in modifyLeaveRequest() : " + exception.getMessage());
            throw new DataException("Error while modifying LeaveRequest ID : " + leaveRequest.getLeaveId());
        }
    }

    /**
     * <p>
     * This method opens a new session and Deletes the leaveRequest from the
     * records.
     * </p>
     * 
     * @param leaveRequestId
     *            contains the ID of the leaveRequest.
     * @return true Gives the success status of the deletion process.
     * @throws DataException
     *             throws error message if problem arises with deleting the data
     *             in the database.
     */
    public boolean removeLeaveRequest(LeaveRequest leaveRequest) throws DataException {
        try {
            Session session = getSession();
            session.delete(leaveRequest);
            return true;
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in removeLeaveRequest() : " + exception.getMessage());
            throw new DataException("Error while deleting LeaveRequest ID : " + leaveRequest.getLeaveId());
        }
    }

    /**
     * <p>
     * This method searches the leaveRequest from the records using leaveRequest
     * ID and returns the data as a model object to display.
     * </p>
     * 
     * @param departementId
     *            contains the ID of the leaveRequest.
     * @return object gives the appropriate leaveRequest detail for the
     *         corresponding leaveRequest ID.
     * @throws DataException
     *             throws error message if problem arises with searching the
     *             data in the database.
     */
    public LeaveRequest findLeaveRequest(int leaveId) throws DataException {
        try {
            Session session = getSession();
            return (LeaveRequest) session.get(LeaveRequest.class, leaveId);
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in findLeaveRequest() : " + exception.getMessage());
            throw new DataException("Error while searching LeaveRequest ID : " + leaveId);
        }
    }

    /**
     * <p>
     * This method retrieves the leaveRequest data from the records and returns
     * the list of data.
     * </p>
     * 
     * @return list Gives the list of leaveRequest details stored in the
     *         database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */
    public List<LeaveRequest> retrieveLeaveRequests() throws DataException {
        try {
            Session session = getSession();
            return session.createCriteria(LeaveRequest.class).list();
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in retrieveLeaveRequests() : " + exception.getMessage());
            throw new DataException("Error while displaying all LeaveRequests");
        }
    }

    /**
     * <p>
     * This method retrieves the leaveRequest data for given user from the
     * records and returns the list of data.
     * </p>
     * 
     * @param userId
     *            identity of the user
     * @return list Gives the list of leaveRequest details for given user stored
     *         in the database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */
    public List<LeaveRequest> retrieveLeaveRequestsByUser(long userId) throws DataException {
        try {
            Session session = getSession();
            return session.createQuery("From LeaveRequest WHERE user_id=" + userId + " order by id desc").list();
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in retrieveLeaveRequestsByUser() : " + exception.getMessage());
            throw new DataException("Error while displaying all LeaveRequests");
        }
    }

    /**
     * <p>
     * This method calculates the number of leave days for given user for given
     * period from the records and returns the list of data.
     * </p>
     * 
     * @param userId
     *            identity of the user
     * @param fromDate
     *            from the Period of Date
     * @param toDate
     *            to the Period of Date
     * @return list Gives the list of leaveRequest details for given user stored
     *         in the database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */
    public List<LeaveRequest> calculateLeaveDaysForUser(long userId, String fromDate, String toDate)
            throws DataException {
        try {
            Session session = getSession();
            return session.createQuery("From LeaveRequest WHERE user_id=" + userId + " and from_date>='" + fromDate
                    + "' and to_date <='" + toDate + "' and status='Approved'").list();
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in calculateLeaveDaysForUser() : " + exception.getMessage());
            throw new DataException("Error while displaying all LeaveRecords");
        }
    }

}
