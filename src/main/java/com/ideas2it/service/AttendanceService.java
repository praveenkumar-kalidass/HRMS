package com.ideas2it.service;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Attendance;

public interface AttendanceService {

    /**
     * Add new Attendance
     *
     * @return True or Fales
     */
    public boolean addAttendance(Attendance attendance) throws DataException;

    /**
     * Update existing Attendance
     *
     * @return True or Fales
     */
    public boolean updateAttendance(Attendance attendance) throws DataException;

    /**
     * Delete Attendance
     *
     * @return True or Fales
     */
    public boolean deleteAttendance(int attendanceId) throws DataException;

    /**
     * Search given Attendance
     *
     * @return Attendance
     */
    public Attendance searchAttendance(int attendanceId) throws DataException;

    /**
     * Retrive All Attendance
     *
     * @return list
     */
    public List<Attendance> retriveAttendances() throws DataException;

    /**
     * Retrive All per day Attendance for given user
     *
     * @return list
     */
    public List<Attendance> getAttendancesByUserId(long userId) throws DataException;

    /**
     * Retrive All Attendance for give user
     *
     * @return list
     */
    public List<Attendance> getCompleteAttendanceByUserId(long userId) throws DataException;
}
