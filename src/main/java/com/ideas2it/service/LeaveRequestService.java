package com.ideas2it.service;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.LeaveRequest;

public interface LeaveRequestService {

    /**
     * Add new LeaveRequest
     *
     * @return True or Fales
     */
    public boolean addLeaveRequest(LeaveRequest leaveRequest) throws DataException;

    /**
     * Update existing LeaveRequest
     *
     * @return True or Fales
     */
    public boolean updateLeaveRequest(LeaveRequest leaveRequest) throws DataException;

    /**
     * Delete LeaveRequest
     *
     * @return True or Fales
     */
    public boolean deleteLeaveRequest(int leaveRequestId) throws DataException;

    /**
     * Search given LeaveRequest
     *
     * @return LeaveRequest
     */
    public LeaveRequest searchLeaveRequest(int leaveRequestId) throws DataException;

    /**
     * Retrive All LeaveRequest
     *
     * @return list
     */
    public List<LeaveRequest> retriveLeaveRequests() throws DataException;

    /**
     * Retrive All LeaveRequest by given User
     *
     * @return list
     */
    public List<LeaveRequest> retriveLeaveRequestsByUser(long userId) throws DataException;

    /**
     * Retrive No of Days Leave By given User
     *
     * @return int
     */
    public int retriveNoofDaysLeaveByUser(long userId, String fromDate, String toDate) throws DataException;
}
