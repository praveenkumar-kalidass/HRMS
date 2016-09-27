package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Attendance;

public interface AttendanceDao extends GenericDao<Attendance, Long> {

    /**
     * Add new Attendance
     *
     * @return True or False
     */
    boolean insertAttendance(Attendance attendance) throws DataException;

    /**
     * Update existing Attendance
     *
     * @return True or False
     */
    boolean modifyAttendance(Attendance attendance) throws DataException;

    /**
     * Delete Attendance
     *
     * @return True or False
     */
    boolean removeAttendance(Attendance attendance) throws DataException;

    /**
     * Search given Attendance
     *
     * @return Attendance
     */
    Attendance findAttendance(int attendanceId) throws DataException;

    /**
     * Retrieve All Attendance
     *
     * @return list
     */
    List<Attendance> retrieveAttendances() throws DataException;

    /**
     * Retrieve All per day Attendance for given user
     *
     * @return list
     */
    List<Attendance> retrieveCompleteAttendanceByUserId(long userId) throws DataException;

    /**
     * Retrieve All Attendance for give user
     *
     * @return list
     */
    List<Attendance> retrieveAttendancesByUserId(long userId) throws DataException;
}
