package com.ideas2it.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.dao.AllowanceVariantDao;
import com.ideas2it.exception.DataException;
import com.ideas2it.model.AllowanceVariant;
import com.ideas2it.service.AllowanceVariantService;

/**
 * <p>
 * Service class which does validations with the user input of Allowance
 * details. Passes values to the Dao class to carry out manipulations. Throws
 * error messages in case of occurrence of any exceptions.
 * </p>
 *
 * @author Praveen RaJ
 *
 * @created 2016-09-15
 */

@Service("allowanceVariantService")
public class AllowanceVariantServiceImpl extends GenericManagerImpl<AllowanceVariant, Long>
		implements AllowanceVariantService {

	@Autowired
	AllowanceVariantDao allowanceVarianttDao;

	/**
	 * <p>
	 * This method checks the presence of allowanceVariant ID in the database.
	 * Passes the value to its dao class to insert if not present.
	 * </p>
	 * 
	 * @param allowanceVariant
	 *            model object that stores the allowanceVariant data associated
	 *            with model.
	 * @return boolean gives the status of the insertion into the database.
	 * @throws DataException
	 *             throws error message if problem arises with inserting the
	 *             data in the database.
	 */
	public boolean addAllowanceVariant(AllowanceVariant allowanceVariant) throws DataException {
		return allowanceVarianttDao.insertAllowanceVariant(allowanceVariant);
	}

	/**
	 * <p>
	 * This method checks the presence of allowanceVariant ID in the database.
	 * Passes the value to its dao class to update if present.
	 * </p>
	 * 
	 * @param allowanceVariant
	 *            model object that stores the allowanceVariant data associated
	 *            with model.
	 * @return boolean gives the status of the update from the database.
	 * @throws DataException
	 *             throws error message if problem arises with updating the data
	 *             in the database.
	 */
	public boolean updateAllowanceVariant(AllowanceVariant allowanceVariant) throws DataException {
		return allowanceVarianttDao.modifyAllowanceVariant(allowanceVariant);
	}

	/**
	 * <p>
	 * This method checks the presence of allowanceVariant ID in the database.
	 * Passes the value to its dao class to delete if present.
	 * </p>
	 * 
	 * @param allowanceVariantId
	 *            contains the ID of the allowanceVariant.
	 * @return boolean gives the status of the deletion from the database.
	 * @throws DataException
	 *             throws error message if problem arises with deleting the data
	 *             in the database.
	 */
	public boolean deleteAllowanceVariant(int allowanceVariantId) throws DataException {
		if (searchAllowanceVariant(allowanceVariantId) != null) {
			return allowanceVarianttDao.removeAllowanceVariant(searchAllowanceVariant(allowanceVariantId));
		}
		return false;
	}

	/**
	 * <p>
	 * This method passes the designation ID to its dao class to search in the
	 * database. Returns the model object of the allowanceVariant to its
	 * controller to display.
	 * </p>
	 *
	 * @param allowanceVariantId
	 *            contains the ID of the allowanceVariant.
	 * 
	 * @return allowanceVariant gives the appropriate allowanceVariant object
	 *         for the corresponding allowanceVariantID.
	 * @throws DataException
	 *             throws error message if problem arises with searching the
	 *             data in the database.
	 */
	public AllowanceVariant searchAllowanceVariant(int allowanceVariantId) throws DataException {
		return allowanceVarianttDao.findAllowanceVariantById(allowanceVariantId);
	}

	/**
	 * <p>
	 * This method retrieves the AllowanceVariant data from the records and
	 * returns the list of data to display.
	 * </p>
	 * 
	 * @return list Gives the list of allowanceVariant details retrieved from
	 *         the database.
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 */
	public List<AllowanceVariant> getAllowanceVariants() throws DataException {
		return allowanceVarianttDao.retrieveAllowanceVariants();
	}

	/**
	 * <p>
	 * This method retrieves the AllowanceVariant data for given designation
	 * from the records and returns the list of data to display.
	 * </p>
	 * 
	 * @param designationId
	 *            contains the ID of the designation.
	 * @return list Gives the list of allowanceVariant details for given
	 *         designationId retrieved from the database.
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 */
	public AllowanceVariant getAllowanceVariantByDesignation(int designationId) throws DataException {
		return allowanceVarianttDao.retrieveAllowanceVariantByDesignation(designationId);
	}
}
