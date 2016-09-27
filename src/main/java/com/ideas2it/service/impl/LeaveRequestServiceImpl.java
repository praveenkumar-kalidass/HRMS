package com.ideas2it.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.dao.LeaveRequestDao;
import com.ideas2it.exception.DataException;
import com.ideas2it.model.LeaveRequest;
import com.ideas2it.service.LeaveRequestService;

/**
 * <p>
 * Service class which does validations with the user input of leaveRequest
 * details. Passes values to the Dao class to carry out manipulations. Throws
 * error messages in case of occurrence of any exceptions.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-08-15
 */

@Service("leaveRequestService")
public class LeaveRequestServiceImpl extends GenericManagerImpl<LeaveRequest, Long> implements LeaveRequestService {

    @Autowired
    LeaveRequestDao leaveRequestDao;

    /**
     * <p>
     * This method checks the presence of leaveRequest ID in the database.
     * Passes the value to its dao class to insert if not present.
     * </p>
     * 
     * @param leaveRequest
     *            model object that stores the leaveRequest data associated with
     *            model.
     * @return boolean gives the status of the insertion into the database.
     * @throws DataException
     *             throws error message if problem arises with inserting the
     *             data in the database.
     */
    public boolean addLeaveRequest(LeaveRequest leaveRequest) throws DataException {
        return leaveRequestDao.insertLeaveRequest(leaveRequest);

    }

    /**
     * <p>
     * This method checks the presence of leaveRequest ID in the database.
     * Passes the value to its dao class to update if present.
     * </p>
     * 
     * @param leaveRequest
     *            model object that stores the leaveRequest data associated with
     *            model.
     * @return boolean gives the status of the update from the database.
     * @throws DataException
     *             throws error message if problem arises with updating the data
     *             in the database.
     */
    public boolean updateLeaveRequest(LeaveRequest leaveRequest) throws DataException {
        return leaveRequestDao.modifyLeaveRequest(leaveRequest);
    }

    /**
     * <p>
     * This method checks the presence of leaveRequest ID in the database.
     * Passes the value to its dao class to delete if present.
     * </p>
     * 
     * @param leaveRequestId
     *            contains the ID of the leaveRequest.
     * @return boolean gives the status of the deletion from the database.
     * @throws DataException
     *             throws error message if problem arises with deleting the data
     *             in the database.
     */
    public boolean deleteLeaveRequest(int leaveRequestId) throws DataException {
        if (leaveRequestDao.findLeaveRequest(leaveRequestId) != null) {
            return leaveRequestDao.removeLeaveRequest(searchLeaveRequest(leaveRequestId));
        }
        return false;
    }

    /**
     * <p>
     * This method passes the leaveRequest ID to its dao class to search in the
     * database. Returns the model object of the leaveRequest to its controller
     * to display.
     * </p>
     *
     * @param leaveRequestId
     *            contains the ID of the leaveRequest.
     * 
     * @return object gives the appropriate leaveRequest object for the
     *         corresponding leaveRequest ID.
     * @throws DataException
     *             throws error message if problem arises with searching the
     *             data in the database.
     */
    public LeaveRequest searchLeaveRequest(int leaveRequestId) throws DataException {
        return leaveRequestDao.findLeaveRequest(leaveRequestId);
    }

    /**
     * <p>
     * This method retrieves the LeaveRequest data from the records and returns
     * the list of data to display.
     * </p>
     * 
     * @return list Gives the list of leaveRequest details retrieved from the
     *         database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */
    public List<LeaveRequest> retriveLeaveRequests() throws DataException {
        return leaveRequestDao.retrieveLeaveRequests();
    }

    /**
     * <p>
     * This method retrieves the LeaveRequest data for given user from the
     * records and returns the list of data to display.
     * </p>
     * 
     * @param userId
     *            identity of the user
     * @return list Gives the list of leaveRequest details retrieved from the
     *         database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */
    public List<LeaveRequest> retriveLeaveRequestsByUser(long userId) throws DataException {
        return leaveRequestDao.retrieveLeaveRequestsByUser(userId);
    }

    /**
     * <p>
     * This method calculates the number of leave days for given user from the
     * records and returns the data to display.
     * </p>
     * 
     * @param userId
     *            identity of the user
     * @param fromDate
     *            from the Period of Date
     * @param toDate
     *            to the Period of Date
     * @return numberOfDays no of days leave got by user database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */
    public int retriveNoofDaysLeaveByUser(long userId, String fromDate, String toDate) throws DataException {
        int numberOfDays = 0;
        for (LeaveRequest leaveRequest : leaveRequestDao.calculateLeaveDaysForUser(userId, fromDate, toDate)) {
            numberOfDays = numberOfDays + leaveRequest.getNoDays();
        }
        return numberOfDays;
    }
}
