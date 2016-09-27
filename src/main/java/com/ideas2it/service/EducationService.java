package com.ideas2it.service;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Education;

public interface EducationService {

    /**
     * Add new Education
     *
     * @return True or False
     */
    public boolean addEducation(Education education) throws DataException;

    /**
     * Update existing Education
     *
     * @return True or False
     */
    public boolean updateEducation(Education education) throws DataException;

    /**
     * Search given Education
     *
     * @return Education
     */
    public Education searchEducation(int educationId) throws DataException;

    /**
     * Retrieve All Educations
     *
     * @return list
     */
    public List<Education> getEducations() throws DataException;

    /**
     * Retrieve All Educations Given by user
     *
     * @return list
     */
    public List<Education> getEducationByUser(long userId) throws DataException;
}
