package com.ideas2it.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.dao.EducationDao;
import com.ideas2it.exception.DataException;
import com.ideas2it.model.Designation;
import com.ideas2it.model.Education;
import com.ideas2it.service.DesignationService;
import com.ideas2it.service.EducationService;

/**
 * <p>
 * Service class which does validations with the user input of education
 * details. Passes values to the Dao class to carry out manipulations. Throws
 * error messages in case of occurrence of any exceptions.
 * </p>
 *
 * @author Praveen Raj
 *
 * @created 2016-09-06
 */

@Service("educationService")
public class EducationServiceImpl extends GenericManagerImpl<Education, Long> implements EducationService {

	@Autowired
	EducationDao educationtDao;

	/**
	 * <p>
	 * This method checks the presence of education ID in the database. Passes
	 * the value to its dao class to insert if not present.
	 * </p>
	 * 
	 * @param education
	 *            model object that stores the education data associated with
	 *            model.
	 * @return boolean gives the status of the insertion into the database.
	 * @throws DataException
	 *             throws error message if problem arises with inserting the
	 *             data in the database.
	 */
	public boolean addEducation(Education education) throws DataException {
		return educationtDao.insertEducation(education);
	}

	/**
	 * <p>
	 * This method checks the presence of education ID in the database. Passes
	 * the value to its dao class to update if present.
	 * </p>
	 * 
	 * @param education
	 *            model object that stores the education data associated with
	 *            model.
	 * @return boolean gives the status of the update from the database.
	 * @throws DataException
	 *             throws error message if problem arises with updating the data
	 *             in the database.
	 */
	public boolean updateEducation(Education education) throws DataException {
		return educationtDao.modifyEducation(education);
	}

	/**
	 * <p>
	 * This method passes the department ID to its dao class to search in the
	 * database. Returns the model object of the education to its controller to
	 * display.
	 * </p>
	 *
	 * @param educationId
	 *            contains the ID of the education.
	 * 
	 * @return education gives the appropriate education object for the
	 *         corresponding educationID.
	 * @throws DataException
	 *             throws error message if problem arises with searching the
	 *             data in the database.
	 */
	public Education searchEducation(int educationId) throws DataException {
		return educationtDao.findEducationById(educationId);
	}

	/**
	 * <p>
	 * This method retrieves the Education data from the records and returns the
	 * list of data to display.
	 * </p>
	 * 
	 * @return list Gives the list of education details retrieved from the
	 *         database.
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 */
	public List<Education> getEducations() throws DataException {
		return educationtDao.retrieveEducations();
	}

	/**
	 * <p>
	 * This method retrieves the Education data for given department from the
	 * records and returns the list of data to display.
	 * </p>
	 * 
	 * @param userId
	 *            contains the ID of the user.
	 * @return list Gives the list of education details for given userId
	 *         retrieved from the database.
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 */
	public List<Education> getEducationByUser(long userId) throws DataException {
		return educationtDao.retrieveEducationByUser(userId);
	}
}
