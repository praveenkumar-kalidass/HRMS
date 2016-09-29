package com.ideas2it.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ideas2it.model.AllowanceVariant;
import com.ideas2it.util.FileUtil;
import com.ideas2it.dao.AllowanceVariantDao;
import com.ideas2it.exception.DataException;

/**
 * <p>
 * DataAccessObject(Dao) for AllowanceVariant model is used to insert, update
 * and delete allowanceVariant from designation. Creates session and transaction
 * objects for each operation
 * </p>
 * 
 * @author Praveen RaJ
 * 
 * @created 2016-09-01
 */

@Repository("allowanceVariantDao")
@Transactional
public class AllowanceVariantDaoHibernate extends GenericDaoHibernate<AllowanceVariant, Long>
        implements AllowanceVariantDao {
    /**
     * Constructor to create a Generics-based version using Allowance Variant as the entity
     */
    public AllowanceVariantDaoHibernate() {
        super(AllowanceVariant.class);
    }

    /**
     * *
     * <p>
     * Method is used to insert new allowanceVariant create a new session and
     * Inserts the model object of the allowanceVariant into the database.
     * </p>
     * 
     * @param allowanceVariant
     *            model object that stores the allowanceVariant data associated
     *            with model class.
     * @throws DataException
     *             if any database connection error occurred error message will
     *             be logged and send context info to user
     * @return if inserted successfully true will be return to the Calling
     *         method
     */
    public boolean insertAllowanceVariant(AllowanceVariant allowanceVariant) throws DataException {
        try {
            Session session = getSession();
            session.save(allowanceVariant);
            return true;
        } catch (HibernateException ex) {
            FileUtil.errorLogger("Error on AllowanceVariantDao insertAllowanceVariant() : " + ex.toString());
            throw new DataException("Error Occured while Inserting this allowance varient for this designation" + allowanceVariant.getDesignation().getDesignationId()
                    + " : please verify your details... Any try again..!");
        }
    }

    /**
     * *
     * <p>
     * Method is used to update existing allowanceVariant create a new session
     * and update the model object of the allowanceVariant from the database.
     * </p>
     * 
     * @param allowanceVariant
     *            model object that stores the allowanceVariant data associated
     *            with model class.
     * @throws DataException
     *             if any database connection error occurred error message will
     *             be logged and send context info to user
     * @return if updated successfully true will be return to the Calling method
     */
    public boolean modifyAllowanceVariant(AllowanceVariant allowanceVariant) throws DataException {
        try {
            Session session = getSession();
            session.update(allowanceVariant);
            return true;
        } catch (HibernateException ex) {
            FileUtil.errorLogger("Error on AllowanceVariantDao modifyAllowanceVariant() : " + ex.toString());
            throw new DataException("Error Occured while Updating this" + allowanceVariant.getId()
                    + " : please verify your details... Any try again..!");
        }
    }

    /**
     * *
     * <p>
     * Method is used to delete existing allowanceVariant create a new session
     * and Inserts the model object of the allowanceVariant into the database.
     * </p>
     * 
     * @param allowanceVariant
     *            model object that stores the allowanceVariant data associated
     *            with model class.
     * @throws DataException
     *             if any database connection error occurred error message will
     *             be logged and send context info to user
     * @return if inserted successfully true will be return to the Calling
     *         method
     */
    public boolean removeAllowanceVariant(AllowanceVariant allowanceVariant) throws DataException {
        try {
            Session session = getSession();
            session.delete(allowanceVariant);
            return true;
        } catch (HibernateException ex) {
            FileUtil.errorLogger("Error on AllowanceVariantDao removeAllowanceVariant() : " + ex.toString());
            throw new DataException("Error Occured while Deleting this" + allowanceVariant.getId()
                    + " : please verify your details... Any try again..!");
        }

    }

    /**
     * <p>
     * This method searches the allowanceVariant from the records using
     * allowanceVariant ID and returns the data as a model object to display.
     * </p>
     * 
     * @param allowanceVariantId
     *            contains the ID of the allowanceVariant.
     * @throws DataException
     *             throws error message if problem arises with searching the
     *             data in the database, error will stored in log file and
     *             context message to user.
     * @return AllowanceVariant return the required allowanceVariant object
     *         model contains allowanceVariant info.
     */
    public AllowanceVariant findAllowanceVariantById(int allowanceVariantId) throws DataException {
        try {
            Session session = getSession();
            return (AllowanceVariant) session.get(AllowanceVariant.class, allowanceVariantId);
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in findAllowanceVariantById() : " + exception.getMessage());
            throw new DataException("Error while searching Allowance Variant ID : " + allowanceVariantId);
        }
    }

    /**
     * <p>
     * This method retrieves the allowanceVariant data from the records and
     * returns the list of data.
     * </p>
     * 
     * @param allowanceVariantId
     *            contains identity of the allowanceVariant
     * @throws com.i2i.exception.DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     * @return AllowanceVariant.List return the full list of allowanceVariant
     *         stored in database
     */
    public List<AllowanceVariant> retrieveAllowanceVariants() throws DataException {
        try {
            Session session = getSession();
            return session.createCriteria(AllowanceVariant.class).list();
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in retrieveAllowanceVariants() : " + exception.getMessage());
            throw new DataException("Error while displaying all Allowance Variants");
        }
    }

    /**
     * <p>
     * This method retrieves the allowanceVariant data for a particular designation from the records and
     * returns the list of data.
     * </p>
     * 
     * @param allowanceVariantId
     *            contains identity of the allowanceVariant
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     * @return AllowanceVariant.List return the list of allowanceVariant which
     *         is stored under the given designation
     */
    public AllowanceVariant retrieveAllowanceVariantByDesignation(int designationId) throws DataException {
        try {
            Session session = getSession();
            AllowanceVariant allowanceVarient = null;
            List<AllowanceVariant> allowanceList = session
                    .createQuery("From AllowanceVariant WHERE designation_id=" + designationId).list();
            for (AllowanceVariant allowance : allowanceList) {
                allowanceVarient = allowance;
            }
            return allowanceVarient;
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in retrieveAllowanceVariantByDesignation() : " + exception.getMessage());
            throw new DataException("Error while displaying all Allowance Variants");
        }
    }
}
