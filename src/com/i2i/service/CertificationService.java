package com.i2i.service;

import java.util.List;

import com.i2i.dao.CertificationDao;
import com.i2i.exception.DataException;
import com.i2i.model.Certification;

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
public class CertificationService {
    CertificationDao certificationtDao = new CertificationDao();

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
     * @param employeeId
     *            contains the ID of the employee.
     * @return list Gives the list of certification details for given employeeId
     *         retrieved from the database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */
    public List<Certification> getCertificationByEmployee(int employeeId) throws DataException {
        return certificationtDao.retrieveCertificationsByEmployee(employeeId);
    }
}
