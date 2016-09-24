package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.LeaveRequest;

public interface LeaveRequestDao extends GenericDao<LeaveRequest, Long> {
	boolean insertLeaveRequest(LeaveRequest leaveRequest) throws DataException;
	boolean modifyLeaveRequest(LeaveRequest leaveRequest) throws DataException;
	boolean removeLeaveRequest(LeaveRequest leaveRequest) throws DataException;
	LeaveRequest findLeaveRequest(int leaveId) throws DataException;
	List<LeaveRequest> retrieveLeaveRequests() throws DataException;
	List<LeaveRequest> retrieveLeaveRequestsByUser(long userId) throws DataException;
	List<LeaveRequest> calculateLeaveDaysForUser(long userId, String fromDate, String toDate) throws DataException;
}
