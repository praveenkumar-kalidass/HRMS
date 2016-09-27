package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.LeaveRequest;

public interface LeaveRequestDao extends GenericDao<LeaveRequest, Long> {

	/**
	 * Add new LeaveRequest
	 *
	 * @return True or Fales
	 */
	boolean insertLeaveRequest(LeaveRequest leaveRequest) throws DataException;

	/**
	 * Update existing LeaveRequest
	 *
	 * @return True or Fales
	 */
	boolean modifyLeaveRequest(LeaveRequest leaveRequest) throws DataException;

	/**
	 * Delete LeaveRequest
	 *
	 * @return True or Fales
	 */
	boolean removeLeaveRequest(LeaveRequest leaveRequest) throws DataException;

	/**
	 * Search given LeaveRequest
	 *
	 * @return LeaveRequest
	 */
	LeaveRequest findLeaveRequest(int leaveId) throws DataException;

	/**
	 * Retrive All LeaveRequest
	 *
	 * @return list
	 */
	List<LeaveRequest> retrieveLeaveRequests() throws DataException;

	/**
	 * Retrive All LeaveRequest by given User
	 *
	 * @return list
	 */
	List<LeaveRequest> retrieveLeaveRequestsByUser(long userId) throws DataException;

	/**
	 * Retrive No of Days Leave By given User
	 *
	 * @return int
	 */
	List<LeaveRequest> calculateLeaveDaysForUser(long userId, String fromDate, String toDate) throws DataException;
}
