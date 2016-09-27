package com.ideas2it.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.dao.AttendanceDao;
import com.ideas2it.exception.DataException;
import com.ideas2it.model.Address;
import com.ideas2it.model.Attendance;
import com.ideas2it.service.AddressService;
import com.ideas2it.service.AttendanceService;

/**
 * <p>
 * Service class which does validations with the user input of attendance
 * details. Passes values to the Dao class to carry out manipulations. Throws
 * error messages in case of occurrence of any exceptions.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-08-15
 */

@Service("attendanceService")
public class AttendanceServiceImpl extends GenericManagerImpl<Attendance, Long> implements AttendanceService {

	@Autowired
	AttendanceDao attendanceDao;

	/**
	 * <p>
	 * This method checks the presence of attendance ID in the database. Passes
	 * the value to its dao class to insert if not present.
	 * </p>
	 * 
	 * @param attendance
	 *            model object that stores the attendance data associated with
	 *            model.
	 * @return boolean gives the status of the insertion into the database.
	 * @throws DataException
	 *             throws error message if problem arises with inserting the
	 *             data in the database.
	 */
	public boolean addAttendance(Attendance attendance) throws DataException {
		return attendanceDao.insertAttendance(attendance);

	}

	/**
	 * <p>
	 * This method checks the presence of attendance ID in the database. Passes
	 * the value to its dao class to update if present.
	 * </p>
	 * 
	 * @param attendance
	 *            model object that stores the attendance data associated with
	 *            model.
	 * @return boolean gives the status of the update from the database.
	 * @throws DataException
	 *             throws error message if problem arises with updating the data
	 *             in the database.
	 */
	public boolean updateAttendance(Attendance attendance) throws DataException {
		return attendanceDao.modifyAttendance(attendance);
	}

	/**
	 * <p>
	 * This method checks the presence of attendance ID in the database. Passes
	 * the value to its dao class to delete if present.
	 * </p>
	 * 
	 * @param attendanceId
	 *            contains the ID of the attendance.
	 * @return boolean gives the status of the deletion from the database.
	 * @throws DataException
	 *             throws error message if problem arises with deleting the data
	 *             in the database.
	 */
	public boolean deleteAttendance(int attendanceId) throws DataException {
		if (attendanceDao.findAttendance(attendanceId) != null) {
			return attendanceDao.removeAttendance(searchAttendance(attendanceId));
		}
		return false;
	}

	/**
	 * <p>
	 * This method passes the attendance ID to its dao class to search in the
	 * database. Returns the model object of the attendance to its controller to
	 * display.
	 * </p>
	 *
	 * @param attendanceId
	 *            contains the ID of the attendance.
	 * 
	 * @return object gives the appropriate attendance object for the
	 *         corresponding attendance ID.
	 * @throws DataException
	 *             throws error message if problem arises with searching the
	 *             data in the database.
	 */
	public Attendance searchAttendance(int attendanceId) throws DataException {
		return attendanceDao.findAttendance(attendanceId);
	}

	/**
	 * <p>
	 * This method retrieves the Attendance data from the records and returns
	 * the list of data to display.
	 * </p>
	 * 
	 * @return list Gives the list of attendance details retrieved from the
	 *         database.
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 */
	public List<Attendance> retriveAttendances() throws DataException {
		return attendanceDao.retrieveAttendances();
	}

	/**
	 * <p>
	 * This method retrieves the Attendance data for given user from the records
	 * and returns the list of data to display.
	 * </p>
	 * 
	 * @param userId
	 *            contains the ID of the user.
	 * @return list Gives the list of attendance details for given userId
	 *         retrieved from the database.
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 */
	public List<Attendance> getAttendancesByUserId(long userId) throws DataException {
		return attendanceDao.retrieveAttendancesByUserId(userId);
	}

	/**
	 * <p>
	 * This method retrieves the Attendance data for given user from the records
	 * and returns the list of data to display.
	 * </p>
	 * 
	 * @param userId
	 *            contains the ID of the user.
	 * @return list Gives the list of attendance details for given userId
	 *         retrieved from the database.
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 */
	public List<Attendance> getCompleteAttendanceByUserId(long userId) throws DataException {
		return attendanceDao.retrieveCompleteAttendanceByUserId(userId);
	}
}