package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Education;

public interface EducationDao extends GenericDao<Education, Long> {

    /**
     * Add new Education
     *
     * @return True or False
     */
    boolean insertEducation(Education education) throws DataException;

    /**
     * Delete Education
     *
     * @return True or False
     */
    boolean modifyEducation(Education education) throws DataException;

    /**
     * Search given Education
     *
     * @return Education
     */
    Education findEducationById(int educationId) throws DataException;

    /**
     * Retrieve All Education
     *
     * @return list
     */
    List<Education> retrieveEducations() throws DataException;

    /**
     * Retrieve All Education Given by user
     *
     * @return list
     */
    List<Education> retrieveEducationByUser(long userId) throws DataException;
}
