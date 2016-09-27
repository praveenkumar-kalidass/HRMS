package com.ideas2it.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.dao.CertificationDao;
import com.ideas2it.exception.DataException;
import com.ideas2it.model.Certification;
import com.ideas2it.service.CertificationService;

/**
 * <p>
 * Service class which does validations with the user input of certification
 * details. Passes values to the Dao class to carry out manipulations. Throws
 * error messages in case of occurrence of any exceptions.
 * </p>
 *
 * @author Praveen Raj
 *
 * @created 2016-09-06
 */

@Service("certificationService")
public class CertificationServiceImpl extends GenericManagerImpl<Certification, Long> implements CertificationService {

    @Autowired
    CertificationDao certificationtDao;

    /**
     * <p>
     * This method checks the presence of certification ID in the database.
     * Passes the value to its dao class to insert if not present.
     * </p>
     * 
     * @param certification
     *            model object that stores the certification data associated
     *            with model.
     * @return boolean gives the status of the insertion into the database.
     * @throws DataException
     *             throws error message if problem arises with inserting the
     *             data in the database.
     */
    public boolean addCertification(Certification certification) throws DataException {
        return certificationtDao.insertCertification(certification);
    }

    /**
     * <p>
     * This method checks the presence of certification ID in the database.
     * Passes the value to its dao class to update if present.
     * </p>
     * 
     * @param certification
     *            model object that stores the certification data associated
     *            with model.
     * @return boolean gives the status of the update from the database.
     * @throws DataException
     *             throws error message if problem arises with updating the data
     *             in the database.
     */
    public boolean updateCertification(Certification certification) throws DataException {
        return certificationtDao.modifyCertification(certification);
    }

    /**
     * <p>
     * This method passes the department ID to its dao class to search in the
     * database. Returns the model object of the certification to its controller
     * to display.
     * </p>
     *
     * @param certificationId
     *            contains the ID of the certification.
     * 
     * @return certification gives the appropriate certification object for the
     *         corresponding certificationID.
     * @throws DataException
     *             throws error message if problem arises with searching the
     *             data in the database.
     */
    public Certification searchCertification(int certificationId) throws DataException {
        return certificationtDao.findCertificationById(certificationId);
    }

    /**
     * <p>
     * This method retrieves the Certification data from the records and returns
     * the list of data to display.
     * </p>
     * 
     * @return list Gives the list of certification details retrieved from the
     *         database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */
    public List<Certification> getCertifications() throws DataException {
        return certificationtDao.retrieveCertifications();
    }

    /**
     * <p>
     * This method retrieves the Certification data for given department from
     * the records and returns the list of data to display.
     * </p>
     * 
     * @param userId
     *            contains the ID of the user.
     * @return list Gives the list of certification details for given userId
     *         retrieved from the database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */
    public List<Certification> getCertificationByUser(long userId) throws DataException {
        return certificationtDao.retrieveCertificationsByUser(userId);
    }
}
