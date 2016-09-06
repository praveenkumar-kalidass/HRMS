package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.Util.FileUtil;
import com.i2i.connection.HibernateConnection;
import com.i2i.exception.DataException;
import com.i2i.model.Certification;

/**
 * <p>
 * DataAccessObject(Dao) for Certification model 
 * is used to insert, update and delete certification detail(s) for the employee
 * Creates session and transaction objects for each operation 
 * </p>
 * 
 * @author Praveen RaJ
 * 
 * @created 2016-09-06
 */
public class CertificationDao {
	Certification certification  = new Certification();
	HibernateConnection hibernateConnection =  HibernateConnection.createObject();
	SessionFactory sessionFactory = hibernateConnection.establishConnection();
	
	/**
	 * * <p>
	 * Method is used to insert new Certification
     * create a new session and Inserts the model object of the Certification into the database.
     * </p>
	 * @param certification
	 *      model object that stores the Certification data associated with model class.
	 * @throws DataException
	 *      if any database connection error occurred error message will be logged and send context info to user 
	 *  @return 
	 *      if inserted successfully true will be return to the Calling method   
	 */
	public boolean insertCertification(Certification certification) throws DataException {
		Session session=sessionFactory.openSession();
		try {
			Transaction transaction=session.beginTransaction();	
	        session.save(certification);  	
	        transaction.commit();
	        return true;	       
		} catch (HibernateException ex) {
			FileUtil.ErrorLogger("Error on DesignationDao insertCertification() : " + ex.toString());
	        throw new DataException("Error Occured while Inserting this" + certification.getCourseName() + " : please verify your details... Any try again..!");
		} finally {
			session.close();
		}
	}
	
	/**
	 * * <p>
	 * Method is used to update existing certification details of the employee
     * create a new session and update the model object of the certification from the database.
     * </p>
	 * @param certification
	 *      model object that stores the certification data associated with model class.
	 * @throws DataException
	 *      if any database connection error occurred error message will be logged and send context info to user 
	 *  @return 
	 *      if updated successfully true will be return to the Calling method   
	 */
	public boolean modifyCertification(Certification certification) throws DataException {
		Session session=sessionFactory.openSession();
		try {
			Transaction transaction=session.beginTransaction();	
	        session.update(certification);  	
	        transaction.commit();
	        return true;	       
		} catch (HibernateException ex) {
			FileUtil.ErrorLogger("Error on DesignationDao modifyCertification() : " + ex.toString());
	        throw new DataException("Error Occured while Updating this" + certification.getCourseName() + " : please verify your details... Any try again..!");
		} finally {
			session.close();
		}
	}
	
	
	
	/**
     * <p>
     * this method searches the certification from the records using certification ID and 
     * returns the data as a model object to display.
     * </p>
     * 
     * @param certificationId
     *       contains the ID of the certification.    
     * @throws DataException
     *       throws error message if problem arises with searching the data in the database, error will stored in log file and context message to user.
     * @return Designation
     *       return the required designation object model contains designation info.
     */
    public Certification findCertificationById(int certificationId) throws DataException {
    	Session session=sessionFactory.openSession();
        try {
            return (Certification)session.get(Certification.class,certificationId);
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in findCertification() : " + exception.getMessage());
            throw new DataException("Error while searching Certification ID : " + certificationId);
        } finally {
            session.close();
        }
    }
    
    
    /**
     * <p>
     * This method retrieves the certification data from the records and returns the list of data.
     * </p>
     * 
     * @param certificationId
     *      contains identity of the certification 
     * @throws com.i2i.exception.DataException
     *       throws error message if problem arises with retrieving list of data from the database.
     * @return Designation.List
     *       return the full list of certification stored in database
     */
    public List<Certification> retrieveCertifications() throws DataException {
    	Session session=sessionFactory.openSession();
    	try {           
    		return session.createCriteria(Certification.class).list();
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in retriveCertification() : " + exception.getMessage());
            throw new DataException("Error while displaying all Certification");
        } finally {
            session.close();
        }
    }
    
    /**
     * <p>
     * This method retrieves the certification data from the records and returns the list of data.
     * </p>
     * 
     * @param employeeId
     *      contains identity of the employee 
     * @throws DataException
     *       throws error message if problem arises with retrieving list of data from the database.
     * @return Certification.List
     *       return the list of certification which is stored under the given employee
     */
    public List<Certification> retrieveCertificationsByEmployee(int employeeId) throws DataException {
    	Session session=sessionFactory.openSession();
    	try {           
            return session.createQuery("From Certification WHERE employee_id = : employeeId").list();
        } catch (HibernateException exception) {
            FileUtil.ErrorLogger("Exception in retrieveCertifications() : " + exception.getMessage());
            throw new DataException("Error while displaying all Certification");
        } finally {
            session.close();
        }
    }       
}
