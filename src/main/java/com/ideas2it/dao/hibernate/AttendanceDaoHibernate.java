package com.ideas2it.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ideas2it.util.FileUtil;
import com.ideas2it.dao.AttendanceDao;
import com.ideas2it.exception.DataException;
import com.ideas2it.model.Attendance;

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
@Repository("attendanceDao")
@Transactional
public class AttendanceDaoHibernate extends GenericDaoHibernate<Attendance, Long> implements AttendanceDao {
    /**
     * Constructor to create a Generics-based version using Attendance as the entity
     */
    public AttendanceDaoHibernate() {
        super(Attendance.class);
    }

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
        try {
            Session session = getSession();
            session.saveOrUpdate(attendance);
            return true;
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in insertAttendance() : " + exception.getMessage());
            throw new DataException("Error while adding Attendance for this time in : " + attendance.getTimeIn());
        }
    }

    /**
     * <p>
     * This method opens a new session and modifies the model object of the
     * attendance in the database.
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
        try {
            Session session = getSession();
            session.update(attendance);
            return true;
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in modifyAttendance() : " + exception.getMessage());
            throw new DataException("Error while modifying Attendance for this time out : " + attendance.getTimeOut());
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
        try {
            Session session = getSession();
            session.delete(attendance);
            return true;
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in removeAttendance() : " + exception.getMessage());
            throw new DataException("Error while deleting Attendance ID : " + attendance.getAttendanceId());
        }
    }

    /**
     * <p>
     * this method searches the attendance from the records using attendance ID
     * and returns the data as a model object to display.
     * </p>
     * 
     * @param attendanceId
     *            contains the ID of the attendance.
     * @return object gives the appropriate attendance detail for the
     *         corresponding attendance ID.
     * @throws DataException
     *             throws error message if problem arises with searching the
     *             data in the database.
     */
    public Attendance findAttendance(int attendanceId) throws DataException {
        try {
            Session session = getSession();
            return (Attendance) session.get(Attendance.class, attendanceId);
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in findAttendance() : " + exception.getMessage());
            throw new DataException("Error while searching Attendance ID : " + attendanceId);
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
        try {
            Session session = getSession();
            return session.createCriteria(Attendance.class).list();
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in retrieveAttendances() : " + exception.getMessage());
            throw new DataException("Error while displaying all Attendances");
        }
    }

    /**
     * <p>
     * This method retrieves the recent attendance data for a particular user from the records and returns
     * the list of data.
     * </p>
     * 
     * @return list Gives the list of attendance details stored in the database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */
    public List<Attendance> retrieveAttendancesByUserId(long userId) throws DataException {
        try {
            Session session = getSession();
            Query q = session.createQuery("From Attendance WHERE user_id=" + userId + " order by id desc");
            q.setFirstResult(0);
            q.setMaxResults(1);
            return q.list();
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in retrieveAttendancesByUserId() : " + exception.getMessage());
            throw new DataException("Error while displaying all Attendances");
        }
    }

    /**
     * <p>
     * This method retrieves the complete attendance data for a particular user from the records and returns
     * the list of data for given User Id.
     * </p>
     * 
     * @param userId
     *            identity of the user
     * @return list Gives the list of attendance details for give user stored in
     *         the database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */

    public List<Attendance> retrieveCompleteAttendanceByUserId(long userId) throws DataException {
        try {
            Session session = getSession();
            Query q = session.createQuery("From Attendance WHERE user_id=" + userId + " order by id desc");
            return q.list();
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in retrieveCompleteAttendanceByUserId() : " + exception.getMessage());
            throw new DataException("Error while displaying all Attendances");
        }
    }
}
