package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Attendance;

public interface AttendanceDao extends GenericDao<Attendance, Long> {
	boolean insertAttendance(Attendance attendance) throws DataException;
	boolean modifyAttendance(Attendance attendance) throws DataException;
	boolean removeAttendance(Attendance attendance) throws DataException;
	Attendance findAttendance(int attendanceId) throws DataException;
	List<Attendance> retrieveAttendances() throws DataException;
	List<Attendance> retrieveCompleteAttendanceByUserId(long userId) throws DataException;
	List<Attendance> retrieveAttendancesByUserId(long userId) throws DataException;
}
