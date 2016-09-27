package com.ideas2it.service;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Designation;

public interface DesignationService {

    /**
     * Add new Designation
     *
     * @return True or False
     */
    public boolean addDesignation(Designation designation) throws DataException;

    /**
     * Update existing Designation
     *
     * @return True or False
     */
    public boolean updateDesignation(Designation designation) throws DataException;

    /**
     * Delete Designation
     *
     * @return True or False
     */
    public boolean deleteDesignation(int designationId) throws DataException;

    /**
     * Search given Designation
     *
     * @return Designation
     */
    public Designation searchDesignation(int designationId) throws DataException;

    /**
     * Retrieve All Designations
     *
     * @return list
     */
    public List<Designation> getDesignations() throws DataException;

    /**
     * Retrieve All Designations by given Department
     *
     * @return list
     */
    public List<Designation> getDesgignationByDepartment(int departmentId) throws DataException;
}
