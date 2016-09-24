package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Education;

public interface EducationDao extends GenericDao<Education, Long> {
	boolean insertEducation(Education education) throws DataException;
	boolean modifyEducation(Education education) throws DataException;
	Education findEducationById(int educationId) throws DataException;
	List<Education> retrieveEducations() throws DataException;
	List<Education> retrieveEducationByUser(long userId) throws DataException;
}
