package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.Util.FileUtil;
import com.i2i.connection.HibernateConnection;
import com.i2i.exception.DataException;
import com.i2i.model.Attendance;

/**
 * <p>
 * Dao(Data Access Object) class which establishes session with the database and
 * performs operation on manipulation of records associated with Attendance.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-09-01
 */

public class AttendanceDao {
	private HibernateConnection hibernateConnection = HibernateConnection.createObject();
	SessionFactory factory = hibernateConnection.establishConnection();

	/**
	 * <p>
	 * This method opens a new session and Inserts the model object of the
	 * attendance into the database.
	 * </p>
	 * 
	 * @param attendance
	 *            model object that stores the attendance data associated with
	 *            model class.
	 * @return true Gives the success status of the insertion process.
	 * @throws DataException
	 *             throws error message if problem arises with inserting the
	 *             data in the database.
	 */
	public boolean insertAttendance(Attendance attendance) throws DataException {
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(attendance);
			transaction.commit();
			return true;
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in insertAttendance() : " + exception.getMessage());
			throw new DataException("Error while adding Attendance ID : " + attendance.getAttendanceId());
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method opens a new session and modify the model object of the
	 * attendance from the database.
	 * </p>
	 * 
	 * @param attendance
	 *            model object that stores the attendance data associated with
	 *            model class.
	 * @return true Gives the success status of the updation process.
	 * @throws DataException
	 *             throws error message if problem arises with updating the data
	 *             in the database.
	 */
	public boolean modifyAttendance(Attendance attendance) throws DataException {
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.update(attendance);
			transaction.commit();
			return true;
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in insertAttendance() : " + exception.getMessage());
			throw new DataException("Error while adding Attendance ID : " + attendance.getAttendanceId());
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method opens a new session and Deletes the attendance from the
	 * records.
	 * </p>
	 * 
	 * @param attendanceId
	 *            contains the ID of the attendance.
	 * @return true Gives the success status of the deletion process.
	 * @throws DataException
	 *             throws error message if problem arises with deleting the data
	 *             in the database.
	 */
	public boolean removeAttendance(Attendance attendance) throws DataException {
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.delete(attendance);
			transaction.commit();
			return true;
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in removeEmployee() : " + exception.getMessage());
			throw new DataException("Error while deleting Attendance ID : " + attendance.getAttendanceId());
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * this method searches the attendance from the records using attendance ID
	 * and returns the data as a model object to display.
	 * </p>
	 * 
	 * @param departementId
	 *            contains the ID of the attendance.
	 * @return object gives the appropriate attendance detail for the
	 *         corresponding attendance ID.
	 * @throws DataException
	 *             throws error message if problem arises with searching the
	 *             data in the database.
	 */
	public Attendance findAttendance(int attendanceId) throws DataException {
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			return (Attendance) session.get(Attendance.class, attendanceId);
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in findAttendance() : " + exception.getMessage());
			throw new DataException("Error while searching Attendance ID : " + attendanceId);
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method retrieves the attendance data from the records and returns
	 * the list of data.
	 * </p>
	 * 
	 * @return list Gives the list of attendance details stored in the database.
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 */
	public List<Attendance> retrieveAttendances() throws DataException {
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			return session.createCriteria(Attendance.class).list();
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in retrieveAttendances() : " + exception.getMessage());
			throw new DataException("Error while displaying all Attendances");
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method retrieves the attendance data from the records and returns
	 * the list of data.
	 * </p>
	 * 
	 * @return list Gives the list of attendance details stored in the database.
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 */
	public List<Attendance> retrieveAttendancesByEmployeeId(int employeeId) throws DataException {
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			Query q = session.createQuery("From Attendance WHERE employee_id=" + employeeId + " order by id desc");
			q.setFirstResult(0);
			q.setMaxResults(1);
			return q.list();
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in retrieveAttendances() : " + exception.getMessage());
			throw new DataException("Error while displaying all Attendances");
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method retrieves the attendance data from the records and returns
	 * the list of data for given Employee Id.
	 * </p>
	 * 
	 * @param employeeId
	 *            identity of the employee
	 * @return list Gives the list of attendance details for give employee
	 *         stored in the database.
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 */

	public List<Attendance> retrieveCompleteAttendanceByEmployeeId(int employeeId) throws DataException {
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			Query q = session.createQuery("From Attendance WHERE employee_id=" + employeeId + " order by id desc");
			return q.list();
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in retrieveAttendances() : " + exception.getMessage());
			throw new DataException("Error while displaying all Attendances");
		} finally {
			session.close();
		}
	}
}