package com.ideas2it.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ideas2it.util.FileUtil;
import com.ideas2it.dao.CertificationDao;
import com.ideas2it.exception.DataException;
import com.ideas2it.model.Attendance;
import com.ideas2it.model.Certification;

/**
 * <p>
 * DataAccessObject(Dao) for Certification model is used to insert, update and
 * delete certification detail(s) for the user Creates session and transaction
 * objects for each operation
 * </p>
 * 
 * @author Praveen RaJ
 * 
 * @created 2016-09-06
 */

@Repository("certificationDao")
@Transactional
public class CertificationDaoHibernate extends GenericDaoHibernate<Certification, Long> implements CertificationDao {

    public CertificationDaoHibernate() {
        super(Certification.class);
    }

    /**
     * *
     * <p>
     * Method is used to insert new Certification create a new session and
     * Inserts the model object of the Certification into the database.
     * </p>
     * 
     * @param certification
     *            model object that stores the Certification data associated
     *            with model class.
     * @throws DataException
     *             if any database connection error occurred error message will
     *             be logged and send context info to user
     * @return if inserted successfully true will be return to the Calling
     *         method
     */
    public boolean insertCertification(Certification certification) throws DataException {
        try {
            Session session = getSession();
            session.save(certification);
            return true;
        } catch (HibernateException ex) {
            FileUtil.errorLogger("Error on DesignationDao insertCertification() : " + ex.toString());
            throw new DataException("Error Occured while Inserting this" + certification.getCourseName()
                    + " : please verify your details... Any try again..!");
        }
    }

    /**
     * *
     * <p>
     * Method is used to update existing certification details of the user
     * create a new session and update the model object of the certification
     * from the database.
     * </p>
     * 
     * @param certification
     *            model object that stores the certification data associated
     *            with model class.
     * @throws DataException
     *             if any database connection error occurred error message will
     *             be logged and send context info to user
     * @return if updated successfully true will be return to the Calling method
     */
    public boolean modifyCertification(Certification certification) throws DataException {
        try {
            Session session = getSession();
            session.update(certification);
            return true;
        } catch (HibernateException ex) {
            FileUtil.errorLogger("Error on DesignationDao modifyCertification() : " + ex.toString());
            throw new DataException("Error Occured while Updating this" + certification.getCourseName()
                    + " : please verify your details... Any try again..!");
        }
    }

    /**
     * <p>
     * this method searches the certification from the records using
     * certification ID and returns the data as a model object to display.
     * </p>
     * 
     * @param certificationId
     *            contains the ID of the certification.
     * @throws DataException
     *             throws error message if problem arises with searching the
     *             data in the database, error will stored in log file and
     *             context message to user.
     * @return Designation return the required designation object model contains
     *         designation info.
     */
    public Certification findCertificationById(int certificationId) throws DataException {
        try {
            Session session = getSession();
            return (Certification) session.get(Certification.class, certificationId);
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in findCertification() : " + exception.getMessage());
            throw new DataException("Error while searching Certification ID : " + certificationId);
        }
    }

    /**
     * <p>
     * This method retrieves the certification data from the records and returns
     * the list of data.
     * </p>
     * 
     * @param certificationId
     *            contains identity of the certification
     * @throws com.i2i.exception.DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     * @return Designation.List return the full list of certification stored in
     *         database
     */
    public List<Certification> retrieveCertifications() throws DataException {
        try {
            Session session = getSession();
            return session.createCriteria(Certification.class).list();
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in retriveCertification() : " + exception.getMessage());
            throw new DataException("Error while displaying all Certification");
        }
    }

    /**
     * <p>
     * This method retrieves the certification data from the records and returns
     * the list of data.
     * </p>
     * 
     * @param userId
     *            contains identity of the user
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     * @return Certification.List return the list of certification which is
     *         stored under the given user
     */
    public List<Certification> retrieveCertificationsByUser(long userId) throws DataException {
        try {
            Session session = getSession();
            return session.createQuery("From Certification WHERE user_id =" + userId).list();
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in retrieveCertifications() : " + exception.getMessage());
            throw new DataException("Error while displaying all Certification");
        }
    }
}
