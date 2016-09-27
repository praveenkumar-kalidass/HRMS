package com.ideas2it.service;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Designation;

public interface DesignationService {

    /**
     * Add new Designation
     *
     * @return True or Fales
     */
    public boolean addDesignation(Designation designation) throws DataException;

    /**
     * Update existing Designation
     *
     * @return True or Fales
     */
    public boolean updateDesignation(Designation designation) throws DataException;

    /**
     * Delete Designation
     *
     * @return True or Fales
     */
    public boolean deleteDesignation(int designationId) throws DataException;

    /**
     * Search given Designation
     *
     * @return Designation
     */
    public Designation searchDesignation(int designationId) throws DataException;

    /**
     * Retrive All Designation
     *
     * @return list
     */
    public List<Designation> getDesignations() throws DataException;

    /**
     * Retrive All Designation by given Department
     *
     * @return list
     */
    public List<Designation> getDesgignationByDepartment(int departmentId) throws DataException;
}
